package com.nextscience.controller;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
//Splitting a PDF in to many using Java 
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.multipdf.Splitter;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.SftpException;
import com.nextscience.Constants.CommonConstants;
import com.nextscience.config.SftpClient;
import com.nextscience.dto.response.NSServiceResponse;
import com.nextscience.entity.FaxRx;
import com.nextscience.enums.ErrorCodes;
import com.nextscience.exceptions.NSException;
import com.nextscience.service.FaxRxService;
import com.nextscience.utility.ResponseHelper;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(CommonConstants.APIV1FAX)
public class PdfController {

	@Autowired
	private FaxRxService faxRxService;

	@Autowired
	private SftpClient sftpClient;

	@GetMapping("/splitPdf")
	@CrossOrigin(origins = "*")
	public ResponseEntity<String> createUser() throws MalformedURLException, IOException {
		// Loading PDF
		File pdffile = new File("C:/PDF-TASK/sample.pdf");
		InputStream is;
		is = new URL("https://sftp.tika.mobi/ftp/tikaftp/NextScience/RxMgmt/Fax_Files/fax1509414370.pdf").openStream();

		// Splitter Class
		Splitter splitting = new Splitter();
		Splitter splittingRemain = new Splitter();

		// Splitting the pages into multiple PDFs
		List<PDDocument> Page;
		try {

			int fromPage = 1;
			int toPage = 2;

			splitting.setStartPage(fromPage);
			splitting.setEndPage(toPage);
			splitting.setSplitAtPage(toPage - fromPage + 1);

			PDDocument document = Loader.loadPDF(is.readAllBytes());
			int totalPages = document.getNumberOfPages();

			List<PDDocument> lst = splitting.split(document);
			PDDocument pdfDocPartial = lst.get(0);
			File fRange = new File("C:/PDF-TASK/sample-range.pdf");
			pdfDocPartial.save(fRange);

			int splitNewPageFrom = toPage + 1;
			int splitNewPageTo = totalPages;
			splittingRemain.setStartPage(splitNewPageFrom);
			splittingRemain.setEndPage(splitNewPageTo);
			splittingRemain.setSplitAtPage(splitNewPageTo - splitNewPageFrom + 1);

			List<PDDocument> lst1 = splittingRemain.split(document);
			PDDocument pdfDocPartial1 = lst1.get(0);
			File fRange1 = new File("C:/PDF-TASK/sample-range-remain.pdf");
			pdfDocPartial1.save(fRange1);
			System.out.println("Splitted Pdf Successfully.");
			document.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ResponseEntity.ok("Pdf Splitted Sucessfully");
	}

	@SuppressWarnings("unchecked")
	@GetMapping("/splitPdfByRange/{faxId}/{fromPage}/{toPage}")
	public NSServiceResponse<String> splitPdf(@PathVariable String faxId, @PathVariable int fromPage,
			@PathVariable int toPage) throws MalformedURLException, IOException, SftpException, JSchException {
		// File pdffile = new File("C:/PDF-TASK/sample.pdf");
		FaxRx faxRxResponse = faxRxService.fetchListById(faxId);
		InputStream is;
		String ftpUrl = faxRxResponse.getFaxUrl();
		is = new URL(ftpUrl).openStream();
		Splitter splitting = new Splitter();
		Splitter splittingRemain = new Splitter();
		// List<PDDocument> Page;
		try {
			PDDocument document = Loader.loadPDF(is.readAllBytes());
			int totalPages = document.getNumberOfPages();
			String errorMessage = "Range is Invalid";
			if (totalPages < fromPage) {
				throw new NSException(ErrorCodes.OK, errorMessage);
			} else if (totalPages < toPage) {
				throw new NSException(ErrorCodes.OK, errorMessage);
			} else if (fromPage > toPage) {
				throw new NSException(ErrorCodes.OK, errorMessage);
			}

			splitting.setStartPage(fromPage);
			splitting.setEndPage(toPage);
			splitting.setSplitAtPage(toPage - fromPage + 1);

			List<PDDocument> lst = splitting.split(document);
			PDDocument pdfDocPartial = lst.get(0);
			File fRange = new File("C:/SPLITPDF/" + faxId + "-a.pdf");
			pdfDocPartial.save(fRange);

			int splitNewPageFrom = toPage + 1;
			int splitNewPageTo = totalPages;
			splittingRemain.setStartPage(splitNewPageFrom);
			splittingRemain.setEndPage(splitNewPageTo);
			splittingRemain.setSplitAtPage(splitNewPageTo - splitNewPageFrom + 1);

			List<PDDocument> lst1 = splittingRemain.split(document);
			PDDocument pdfDocPartial1 = lst1.get(0);
			File fRange1 = new File("C:/SPLITPDF/" + faxId + "-b.pdf");
			pdfDocPartial1.save(fRange1);

			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			pdfDocPartial.save(baos);
			sftpClient.authPassword();
			String remoteFileName = "/tikaftp/SplitPdf/splitfax" + faxId + ".pdf";

			sftpClient.uploadFile(new ByteArrayInputStream(baos.toByteArray()), remoteFileName);
			document.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ResponseHelper.createResponse(new NSServiceResponse<String>(), "Pdf Splitted Sucessfully",
				CommonConstants.SUCCESSFULLY, CommonConstants.ERRROR);

	}

	@SuppressWarnings("unchecked")
	@PostMapping("/uploadPdfToSftp/{faxId}")
	public ResponseEntity<NSServiceResponse<String>> uploadPdfToSftp(@RequestPart("file") MultipartFile file,
			@PathVariable String faxId) throws JSchException, SftpException, MalformedURLException, IOException {
		FaxRx faxRxResponse = faxRxService.fetchListById(faxId);
		InputStream is;
		String ftpUrl = faxRxResponse.getFaxUrl();
		is = new URL(ftpUrl).openStream();
		try {

			sftpClient.authPassword();

			String remoteFileName = "/tikaftp/NextScience/RxMgmt/Fax_Files/fax" + faxId + ".pdf";
			

			sftpClient.uploadFile(new ByteArrayInputStream(file.getBytes()), remoteFileName);

			return ResponseEntity.ok(ResponseHelper.createResponse(new NSServiceResponse<>(),
					"PDF Uploaded to SFTP Successfully", CommonConstants.SUCCESSFULLY, CommonConstants.ERRROR));
		} catch (IOException e) {
			e.printStackTrace();
			return ResponseEntity.status(500).body(ResponseHelper.createResponse(new NSServiceResponse<>(),
					"Error uploading PDF to SFTP", CommonConstants.SUCCESSFULLY, CommonConstants.ERRROR));
		}
	}

}
