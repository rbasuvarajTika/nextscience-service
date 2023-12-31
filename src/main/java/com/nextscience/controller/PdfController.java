package com.nextscience.controller;

import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
//Splitting a PDF in to many using Java 
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.multipdf.Splitter;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.SftpException;
import com.nextscience.Constants.CommonConstants;
import com.nextscience.config.SftpClient;
import com.nextscience.dto.request.InsertFaxRxSplitHistRequest;
import com.nextscience.dto.request.PageRequest;
import com.nextscience.dto.request.PageRequestRetrive;
import com.nextscience.dto.request.RotatePageRequest;
import com.nextscience.dto.request.UpdateFaxRxSplitHistRequest;
import com.nextscience.dto.response.FaxRxSplitHistResponse;
import com.nextscience.dto.response.NSServiceResponse;
import com.nextscience.entity.FaxRx;
import com.nextscience.enums.ErrorCodes;
import com.nextscience.exceptions.NSException;
import com.nextscience.service.FaxRxService;
import com.nextscience.service.FaxRxSplitHistService;
import com.nextscience.utility.ResponseHelper;

import ch.qos.logback.classic.Logger;
import lombok.extern.slf4j.Slf4j;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;

import okhttp3.Response;
import okhttp3.MultipartBody;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(CommonConstants.APIV1FAX)
@Slf4j
public class PdfController {

	@Autowired
	private FaxRxService faxRxService;

	@Autowired
	private SftpClient sftpClient;

	@Autowired
	private FaxRxSplitHistService faxRxSplitHistService;

	@GetMapping("/splitPdf")
	@CrossOrigin(origins = "*")
	public ResponseEntity<String> createUser() throws MalformedURLException, IOException {
		// Loading PDF
		File pdffile = new File("C:/PDF-TASK/sample.pdf");
		InputStream is;
		is = new URL("https://sftp.tika.mobi/ftp/tikaftp/NextScience/RxMgmt/Fax_Files/fax1509414370.pdf").openStream();

		Splitter splitting = new Splitter();
		Splitter splittingRemain = new Splitter();

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

	@SuppressWarnings("unchecked")
	@GetMapping("/splitPdfByPages/{faxId}/{pages}")
	public NSServiceResponse<String> splitPdfByPages(@PathVariable String faxId, @PathVariable String pages)
			throws IOException, JSchException, SftpException {
		PDDocument document = null;
		PDDocument combinedDocument = null;

		try {
			FaxRx faxRxResponse = faxRxService.fetchListById(faxId);
			String ftpUrl = faxRxResponse.getFaxUrl();
			InputStream is = new URL(ftpUrl).openStream();

			document = Loader.loadPDF(is.readAllBytes());
			int totalPages = document.getNumberOfPages();

			List<Integer> pageList = Arrays.stream(pages.split(",")).map(Integer::parseInt)
					.collect(Collectors.toList());

			for (int page : pageList) {
				if (page < 1 || page > totalPages) {
					throw new NSException(ErrorCodes.OK, "Invalid page number: " + page);
				}
			}

			combinedDocument = new PDDocument();

			for (int page : pageList) {
				combinedDocument.addPage(document.getPage(page - 1));
			}

			String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
			String localOutputFileName = "C:/SPLITPDF/" + faxId + "-combined-" + timestamp + ".pdf";
			File localOutputFile = new File(localOutputFileName);

			combinedDocument.save(localOutputFile);

			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			combinedDocument.save(baos);
			sftpClient.authPassword();
			String remoteFileName = "/tikaftp/SplitPdf/splitfax" + faxId + "-combined-" + timestamp + ".pdf";
			sftpClient.uploadFile(new ByteArrayInputStream(baos.toByteArray()), remoteFileName);

		} catch (IOException e) {
			e.printStackTrace();

		} finally {

			if (combinedDocument != null) {
				combinedDocument.close();
			}
			if (document != null) {
				document.close();
			}
		}

		return ResponseHelper.createResponse(new NSServiceResponse<String>(), "Pdf Splitted Successfully",
				CommonConstants.SUCCESSFULLY, CommonConstants.ERRROR);
	}

	@SuppressWarnings("unchecked")
	@PostMapping("/splitByPdfPages/{faxId}")
	public NSServiceResponse<String> splitByPdfPages(@PathVariable String faxId, @RequestBody PageRequest request)
			throws IOException, JSchException, SftpException {
		PDDocument document = null;
		PDDocument combinedDocument = null;
		PDDocument remainingPagesDocument = null;

		try {
			FaxRx faxRxResponse = faxRxService.fetchListById(faxId);
			String ftpUrl = faxRxResponse.getFaxUrl();
			InputStream is = new URL(ftpUrl).openStream();

			document = Loader.loadPDF(is.readAllBytes());
			int totalPages = document.getNumberOfPages();

			List<String> pageList = Arrays.asList(request.getPages().split(","));

			combinedDocument = new PDDocument();
			remainingPagesDocument = new PDDocument();

			for (String page : pageList) {
				int pageNumber = Integer.parseInt(page);
				if (pageNumber < 1 || pageNumber > totalPages) {
					throw new NSException(ErrorCodes.OK, "Invalid page number: " + pageNumber);
				}
				combinedDocument.addPage(document.getPage(pageNumber - 1));
			}

			String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
			String combinedOutputFileName = "C:/SPLITPDF/" + faxId + "-a-" + timestamp + ".pdf";
			File combinedOutputFile = new File(combinedOutputFileName);
			combinedDocument.save(combinedOutputFile);

			for (int page = 1; page <= totalPages; page++) {
				if (!pageList.contains(String.valueOf(page))) {
					remainingPagesDocument.addPage(document.getPage(page - 1));
				}
			}

			String remainingOutputFileName = "C:/SPLITPDF/" + faxId + "-b-" + timestamp + ".pdf";
			File remainingOutputFile = new File(remainingOutputFileName);
			remainingPagesDocument.save(remainingOutputFile);

			sftpClient.authPassword();
			String remoteCombinedFileName = "/tikaftp/SplitPdf/splitfax" + faxId + "-a-" + timestamp + ".pdf";
			sftpClient.uploadFile(new FileInputStream(combinedOutputFile), remoteCombinedFileName);

			sftpClient.authPassword();
			String remoteRemainingFileName = "/tikaftp/SplitPdf/splitfax" + faxId + "-b-" + timestamp + ".pdf";
			sftpClient.uploadFile(new FileInputStream(remainingOutputFile), remoteRemainingFileName);

		} catch (IOException e) {
			e.printStackTrace();

		} finally {
			if (combinedDocument != null) {
				combinedDocument.close();
			}
			if (remainingPagesDocument != null) {
				remainingPagesDocument.close();
			}
			if (document != null) {
				document.close();
			}
		}

		return ResponseHelper.createResponse(new NSServiceResponse<>(), "Pdf Splitted Successfully",
				CommonConstants.SUCCESSFULLY, CommonConstants.ERRROR);
	}

	@SuppressWarnings("unchecked")
	@PostMapping("/rotateAndSavePdf/{faxId}")
	public NSServiceResponse<String> rotateAndSavePdf(@PathVariable String faxId,
			@RequestBody Map<String, String> pageAndRotation) throws IOException, JSchException, SftpException {
		PDDocument document = null;

		try {
			FaxRx faxRxResponse = faxRxService.fetchListById(faxId);
			String ftpUrl = faxRxResponse.getFaxUrl();
			InputStream is = new URL(ftpUrl).openStream();

			document = Loader.loadPDF(is.readAllBytes());
			int totalPages = document.getNumberOfPages();

			for (Map.Entry<String, String> entry : pageAndRotation.entrySet()) {
				int pageNumberToRotate = Integer.parseInt(entry.getKey());
				int rotationDegree = Integer.parseInt(entry.getValue());

				if (pageNumberToRotate < 1 || pageNumberToRotate > totalPages) {
					throw new NSException(ErrorCodes.OK, "Invalid page number: " + pageNumberToRotate);
				}

				PDPage rotatedPage = document.getPage(pageNumberToRotate - 1);
				rotatedPage.setRotation(rotationDegree);
			}

			String outputFileName = "C:/SPLITPDF/fax" + faxId + ".pdf";
			File outputFile = new File(outputFileName);

			document.save(outputFile);

			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			document.save(baos);

			URL url = new URL(ftpUrl);
			String path = url.getPath();
				path = path.substring(4);

			sftpClient.authPassword();

			if (faxRxResponse.getFaxUrl().contains("FaxFiles")) {
				String remoteFileName = "/tikaftp/NextScience/RxMgmt/FaxFiles/fax" + faxId + ".pdf";
				// String remoteFileName = path + "fax" + faxId + ".pdf";
				// String remoteFileName = "tikaftp/NextScience/RxMgmt/FaxFiles/" + faxId +
				// ".pdf";
				sftpClient.uploadFile(new ByteArrayInputStream(baos.toByteArray()), path);
			} else {

				String remoteFileName = "/tikaftp/NextScience/RxMgmt/Fax_Files/fax" + faxId + ".pdf";
				// String remoteFileName = path + "fax" + faxId + ".pdf";
				// String remoteFileName = "tikaftp/NextScience/RxMgmt/FaxFiles/" + faxId +
				// ".pdf";
				sftpClient.uploadFile(new ByteArrayInputStream(baos.toByteArray()), path);
			}
			faxRxService.updatePdfRotation(faxId, pageAndRotation,faxRxResponse.getPdfRotation());

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (document != null) {
				document.close();
			}
		}

		return ResponseHelper.createResponse(new NSServiceResponse<>(), "PDF Rotated and Saved Locally Successfully",
				CommonConstants.SUCCESSFULLY, CommonConstants.ERRROR);
	}

	@SuppressWarnings("unchecked")
	@PostMapping("/sendPdfByPages")
	public NSServiceResponse<String> sendPdfbyPages(@RequestBody PageRequest request)
			throws IOException, JSchException, SftpException {
		PDDocument document = null;
		PDDocument combinedDocument = null;
		PDDocument remainingPagesDocument = null;
		FaxRx faxRxResponse = faxRxService.fetchListById(request.getFaxId());
		String faxIdNew = null;
		String filenameFile = null;
		List<String> pageList = null;
		try {

			String ftpUrl = faxRxResponse.getFaxUrl();
			InputStream is = new URL(ftpUrl).openStream();

			document = Loader.loadPDF(is.readAllBytes());
			int totalPages = document.getNumberOfPages();

			pageList = Arrays.asList(request.getPages().split(","));

			combinedDocument = new PDDocument();
			remainingPagesDocument = new PDDocument();

			for (String page : pageList) {
				int pageNumber = Integer.parseInt(page);
				if (pageNumber < 1 || pageNumber > totalPages) {
					throw new NSException(ErrorCodes.OK, "Invalid page number: " + pageNumber);
				}
				combinedDocument.addPage(document.getPage(pageNumber - 1));
			}

			if (isDuplicateSplit(request.getFaxId(), pageList)) {
				throw new NSException(ErrorCodes.OK,
						"Duplicate split detected for pages: " + String.join(",", pageList));
			}

			String faxId = request.getFaxId();
			List<FaxRxSplitHistResponse> historyResponse = faxRxSplitHistService.getByFaxId(faxId);
			// int splitCounter = historyResponse.size()+1;
			String splitCounter = String.valueOf(historyResponse.size() + 1);

			String splitIdentifier = "_" + splitCounter;
			String combinedOutputFileName = "C:/SPLITPDF/" + faxId + splitIdentifier + ".pdf";
			File combinedOutputFile = new File(combinedOutputFileName);
			combinedDocument.save(combinedOutputFile);

			for (int page = 1; page <= totalPages; page++) {
				if (!pageList.contains(String.valueOf(page))) {
					remainingPagesDocument.addPage(document.getPage(page - 1));
				}
			}
			filenameFile = faxId + splitIdentifier;
			sftpClient.authPassword();
			String remoteCombinedFileName = "/tikaftp/SplitPdf/splitfax" + faxId + splitIdentifier + ".pdf";
			sftpClient.uploadFile(new FileInputStream(combinedOutputFile), remoteCombinedFileName);

			byte[] fileContent = sftpClient.retrieveFileContent(remoteCombinedFileName);

			faxIdNew = faxRxResponse.getFaxId() + splitIdentifier;
			String faxNumber = faxRxResponse.getFaxNumber();
			OkHttpClient client = new OkHttpClient().newBuilder().build();

			Date date = faxRxResponse.getFaxReceivedDate();
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

			String strDate = dateFormat.format(date);
			String count = String.valueOf(pageList.size());

			okhttp3.RequestBody body = new MultipartBody.Builder().setType(MultipartBody.FORM)
					.addFormDataPart("recvid", faxIdNew).addFormDataPart("recvdate", strDate)
					.addFormDataPart("CID", faxNumber).addFormDataPart("pagecount", count)
					.addFormDataPart("file", remoteCombinedFileName, okhttp3.RequestBody
							.create(okhttp3.MediaType.parse("application/octet-stream"), fileContent))
					.build();
			System.out.println("Request Body --->" + body);

			String username = "springboot";
			String password = "f@x@p!@2";
			String valueToEncode = username + ":" + password;
			String token = "Basic " + Base64.getEncoder().encodeToString(valueToEncode.getBytes());

			Request request1 = new Request.Builder().url("http://localhost:2345/upload_fax").method("POST", body)
					.addHeader("Authorization", token).build();
			System.out.println("Request header --->" + request1);
			Response response = client.newCall(request1).execute();
			System.out.println("Response header --->" + response);

			if (response.code() == 200) {
				InsertFaxRxSplitHistRequest histRequest = new InsertFaxRxSplitHistRequest();
				histRequest.setTrnFaxId(faxRxResponse.getTrnFaxId());
				histRequest.setFaxId(faxRxResponse.getFaxId());
				histRequest.setMainFileName(faxRxResponse.getFaxFilename());
				histRequest.setSplitFaxId(faxIdNew);
				histRequest.setSplitFileName(faxId + splitIdentifier + ".pdf");
				histRequest.setFaxUrl(
						"https://sftp.tika.mobi/ftp/tikaftp/SplitPdf/splitfax" + faxId + splitIdentifier + ".pdf");
				histRequest.setSplitPages((String.join(",", pageList)));
				histRequest.setSplitType(request.getSplitType());
				histRequest.setSplitAttempts("1");
				histRequest.setSplitStatus("success");
				histRequest.setPageCount(pageList.size());
				histRequest.setCreatedUser(request.getUserName());
				faxRxSplitHistService.InsertFaxRxSplitHistInfoProc(histRequest);
			} else {

				InsertFaxRxSplitHistRequest histRequest = new InsertFaxRxSplitHistRequest();
				histRequest.setTrnFaxId(faxRxResponse.getTrnFaxId());
				histRequest.setFaxId(faxRxResponse.getFaxId());
				histRequest.setMainFileName(faxRxResponse.getFaxFilename());
				histRequest.setSplitFaxId(faxIdNew);
				histRequest.setSplitFileName(faxId + splitIdentifier + ".pdf");
				histRequest.setFaxUrl(
						"https://sftp.tika.mobi/ftp/tikaftp/SplitPdf/splitfax" + faxId + splitIdentifier + ".pdf");
				histRequest.setSplitPages((String.join(",", pageList)));
				histRequest.setSplitType(request.getSplitType());
				histRequest.setSplitAttempts("1");
				histRequest.setSplitStatus("failure");
				histRequest.setPageCount(pageList.size());
				histRequest.setCreatedUser(request.getUserName());
				faxRxSplitHistService.InsertFaxRxSplitHistInfoProc(histRequest);

				System.out.println("Error Response --->" + response);

			}
		} catch (IOException e) {
			InsertFaxRxSplitHistRequest histRequest = new InsertFaxRxSplitHistRequest();
			histRequest.setTrnFaxId(faxRxResponse.getTrnFaxId());
			histRequest.setFaxId(faxRxResponse.getFaxId());
			histRequest.setMainFileName(faxRxResponse.getFaxFilename());
			histRequest.setSplitFaxId(faxIdNew);
			histRequest.setSplitFileName(filenameFile + ".pdf");
			histRequest.setFaxUrl("https://sftp.tika.mobi/ftp/tikaftp/SplitPdf/splitfax" + filenameFile + ".pdf");
			histRequest.setSplitPages((String.join(",", pageList)));
			histRequest.setSplitType(request.getSplitType());
			histRequest.setSplitAttempts("1");
			histRequest.setSplitStatus("failure");
			histRequest.setPageCount(pageList.size());
			histRequest.setCreatedUser(request.getUserName());
			faxRxSplitHistService.InsertFaxRxSplitHistInfoProc(histRequest);
			e.printStackTrace();

		} finally {
			if (combinedDocument != null) {
				combinedDocument.close();
			}
			if (remainingPagesDocument != null) {
				remainingPagesDocument.close();
			}
			if (document != null) {
				document.close();
			}

			// System.out.println("Error Response --->" + response);
		}

		return ResponseHelper.createResponse(new NSServiceResponse<>(), "Pdf Splitted Successfully",
				CommonConstants.SUCCESSFULLY, CommonConstants.ERRROR);
	}

	private boolean isDuplicateSplit(String faxId, List<String> pageList) {
		List<FaxRxSplitHistResponse> historyResponse = faxRxSplitHistService.getByFaxId(faxId);

		// Convert pageList to a sorted string for comparison
		String sortedPageList = pageList.stream().sorted().collect(Collectors.joining(","));

		for (FaxRxSplitHistResponse history : historyResponse) {
			// Convert history pages to a sorted string for comparison
			List<String> historyPages = Arrays.asList(history.getSplitPages().split(","));
			String sortedHistoryPages = historyPages.stream().sorted().collect(Collectors.joining(","));

			// Check if the current split has the same set of pages
			if (sortedPageList.equals(sortedHistoryPages)) {
				return true;
			}
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	@PostMapping("/sendPdfByPagesRetrive")
	public NSServiceResponse<String> sendPdfbyPagesRetrive(@RequestBody PageRequestRetrive request)
			throws IOException, JSchException, SftpException {
		PDDocument document = null;
		PDDocument combinedDocument = null;
		PDDocument remainingPagesDocument = null;

		try {
			FaxRx faxRxResponse = faxRxService.fetchListById(request.getFaxId());
			String ftpUrl = faxRxResponse.getFaxUrl();
			InputStream is = new URL(ftpUrl).openStream();

			document = Loader.loadPDF(is.readAllBytes());
			int totalPages = document.getNumberOfPages();

			List<String> pageList = Arrays.asList(request.getPages().split(","));

			combinedDocument = new PDDocument();
			remainingPagesDocument = new PDDocument();

			for (String page : pageList) {
				int pageNumber = Integer.parseInt(page);
				if (pageNumber < 1 || pageNumber > totalPages) {
					throw new NSException(ErrorCodes.OK, "Invalid page number: " + pageNumber);
				}
				combinedDocument.addPage(document.getPage(pageNumber - 1));
			}

			String faxSplitname = request.getSplitFaxId();
			String combinedOutputFileName = "C:/SPLITPDF/" + faxSplitname + ".pdf";
			File combinedOutputFile = new File(combinedOutputFileName);
			// combinedDocument.save(combinedOutputFile);

			for (int page = 1; page <= totalPages; page++) {
				if (!pageList.contains(String.valueOf(page))) {
					remainingPagesDocument.addPage(document.getPage(page - 1));
				}
			}
			sftpClient.authPassword();
			String remoteCombinedFileName = "/tikaftp/SplitPdf/splitfax" + faxSplitname + ".pdf";
			sftpClient.uploadFile(new FileInputStream(combinedOutputFile), remoteCombinedFileName);

			byte[] fileContent = sftpClient.retrieveFileContent(remoteCombinedFileName);

			String faxNumber = faxRxResponse.getFaxNumber();
			OkHttpClient client = new OkHttpClient().newBuilder().build();

			Date date = faxRxResponse.getFaxReceivedDate();
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

			String strDate = dateFormat.format(date);
			String count = String.valueOf(pageList.size());

			okhttp3.RequestBody body = new MultipartBody.Builder().setType(MultipartBody.FORM)
					.addFormDataPart("recvid", faxSplitname).addFormDataPart("recvdate", strDate)
					.addFormDataPart("CID", faxNumber).addFormDataPart("pagecount", count)
					.addFormDataPart("file", remoteCombinedFileName, okhttp3.RequestBody
							.create(okhttp3.MediaType.parse("application/octet-stream"), fileContent))
					.build();
			System.out.println("Request Body --->" + body);

			String username = "springboot";
			String password = "f@x@p!@2";
			String valueToEncode = username + ":" + password;
			String token = "Basic " + Base64.getEncoder().encodeToString(valueToEncode.getBytes());

			Request request1 = new Request.Builder().url("http://localhost:2345/upload_fax").method("POST", body)
					.addHeader("Authorization", token).build();
			System.out.println("Request header --->" + request1);
			Response response = client.newCall(request1).execute();
			System.out.println("Response header --->" + response);

			Integer attempts = Integer.parseInt(request.getSplitAttempts());
			attempts = attempts + 1;
			String attemptsConverstion = String.valueOf(attempts);

			if (response.code() == 200) {
				UpdateFaxRxSplitHistRequest histRequestRetrive = new UpdateFaxRxSplitHistRequest();
				histRequestRetrive.setTrnFaxSplitId(request.getTrnFaxSplitId());
				histRequestRetrive.setSplitStatus("success");
				histRequestRetrive.setSplitAttempts(attemptsConverstion);
				histRequestRetrive.setUpdatedUser(request.getUserName());
				faxRxSplitHistService.updateFaxRxSplitHistInfoProc(histRequestRetrive);
			} else {

				UpdateFaxRxSplitHistRequest histRequestRetrive = new UpdateFaxRxSplitHistRequest();
				histRequestRetrive.setTrnFaxSplitId(request.getTrnFaxSplitId());
				histRequestRetrive.setSplitStatus("failure");
				histRequestRetrive.setSplitAttempts(attemptsConverstion);
				histRequestRetrive.setUpdatedUser(request.getUserName());

				faxRxSplitHistService.updateFaxRxSplitHistInfoProc(histRequestRetrive);
				System.out.println("Error Response --->" + response);

			}
		} catch (IOException e) {
			e.printStackTrace();

		} finally {
			if (combinedDocument != null) {
				combinedDocument.close();
			}
			if (remainingPagesDocument != null) {
				remainingPagesDocument.close();
			}
			if (document != null) {
				document.close();
			}
		}

		return ResponseHelper.createResponse(new NSServiceResponse<>(), "Pdf Splitted Successfully",
				CommonConstants.SUCCESSFULLY, CommonConstants.ERRROR);
	}

}