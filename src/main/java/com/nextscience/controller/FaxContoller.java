package com.nextscience.controller;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamSource;
import org.springframework.core.io.UrlResource;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.nextscience.Constants.CommonConstants;
import com.nextscience.Constants.FaxRxConstant;
import com.nextscience.component.EmailBuilder;
import com.nextscience.dto.request.EmailDto;
import com.nextscience.dto.request.FaxRxDupeRequest;
import com.nextscience.dto.response.DupeRxResponse;
import com.nextscience.dto.response.EmailResponseDto;
import com.nextscience.dto.response.FaxRxResponse;
import com.nextscience.dto.response.NSServiceResponse;
import com.nextscience.dto.response.PageResponseDTO;
import com.nextscience.entity.FaxRx;
import com.nextscience.enums.ErrorCodes;
import com.nextscience.exceptions.NSException;
import com.nextscience.service.EmailService;
import com.nextscience.service.FaxRxService;
import com.nextscience.utility.ResponseHelper;

import jakarta.mail.MessagingException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Processes an {@link FaxContoller } controller.
 * 
 * @author Raghu
 *
 */

@RestController
@CrossOrigin("*")
@RequestMapping(CommonConstants.APIV1FAX)
public class FaxContoller {

	@Autowired
	private FaxRxService faxRxService;

	@Autowired
	private EmailService emailService;

	@Value(CommonConstants.MAILFROMEMAILID)
	private String fromEmail;

	@Value(CommonConstants.MAILSUBJECTALERTTEMPLATE)
	private String alertTemplate;

	@Value(CommonConstants.MAILSUBJECTEMAIL)
	private String subject;

	@Value(CommonConstants.MAILSUBJECTALERTMAIL)
	private String alertMail;

	/** Retrieves A list of FaxRxList */
	@SuppressWarnings("unchecked")
	@GetMapping(FaxRxConstant.FAXLIST)
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public NSServiceResponse<List<FaxRxResponse>> executeCustomQuery(
			@RequestParam(value = CommonConstants.PAGENO, required = false, defaultValue = "0") int pageNo,
			@RequestParam(value = CommonConstants.PAGESIZE, required = false, defaultValue = "1000") int pageSize,
			@RequestParam(value = CommonConstants.SORTBY, defaultValue = CommonConstants.CREATEDDATE, required = false) String sortBy,
			@RequestParam(value = CommonConstants.ORDERBY, defaultValue = CommonConstants.DESC, required = false) String orderType) {
		PageRequest page = null;
		if (CommonConstants.DESC.equals(orderType)) {
			page = PageRequest.of(pageNo, pageSize, Sort.by(sortBy).descending());
		} else {
			page = PageRequest.of(pageNo, pageSize, Sort.by(sortBy).ascending());
		}
		PageResponseDTO response = faxRxService.fetchList(page);
		// List<FaxRxResponse> faxRxResponse = faxRxService.fetchList();
		return ResponseHelper.createResponse(new NSServiceResponse<PageResponseDTO>(), response,
				CommonConstants.SUCCESSFULLY, CommonConstants.ERRROR);
	}

	/** Retrieves a Pdf From FaxPdf */
	@GetMapping(value = FaxRxConstant.FAXPDF, produces = MediaType.APPLICATION_PDF_VALUE)
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public @ResponseBody byte[] faxPdfDownload() {

		try {
			InputStream is;
			is = new URL("https://sftp.tika.mobi/ftp/tikaftp/NextScience/RxMgmt/Fax_Files/fax1509414370.pdf")
					.openStream();
			return is.readAllBytes();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/** Retrieves A Duplicate Value of FaxRxDupe */
	@SuppressWarnings("unchecked")
	@GetMapping(FaxRxConstant.FAXDUPE)
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public NSServiceResponse<List<DupeRxResponse>> executeCustomQuery() {

		List<DupeRxResponse> response = faxRxService.getDuplicateResponse();
		// List<FaxRxResponse> faxRxResponse = faxRxService.fetchList();
		return ResponseHelper.createResponse(new NSServiceResponse<PageResponseDTO>(), response,
				CommonConstants.SUCCESSFULLY, CommonConstants.ERRROR);
	}

	/** Retrieves A DuplicateByFaxId Value of FaxRxDupe */
	@SuppressWarnings("unchecked")
	@GetMapping(FaxRxConstant.FAXDUPEBYFAXID)
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public NSServiceResponse<List<DupeRxResponse>> faxDupeId(@PathVariable String faxId) {

		List<DupeRxResponse> response = faxRxService.getDuplicateByIdResponse(faxId);
		// List<FaxRxResponse> faxRxResponse = faxRxService.fetchList();
		return ResponseHelper.createResponse(new NSServiceResponse<PageResponseDTO>(), response,
				CommonConstants.SUCCESSFULLY, CommonConstants.ERRROR);
	}

	/** Retrieves A FaxPdfByFaxId in FaxRx */
	@GetMapping(value = FaxRxConstant.GETFAXPDFFAXID, produces = MediaType.APPLICATION_PDF_VALUE)
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public @ResponseBody byte[] faxPdfDownload(@PathVariable String faxId) {

		try {

			FaxRx faxRxResponse = faxRxService.fetchListById(faxId);
			InputStream is;
			String ftpUrl = faxRxResponse.getFaxUrl();
			is = new URL(ftpUrl).openStream();
			return is.readAllBytes();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@GetMapping(value = FaxRxConstant.DOWNLOADFAXPDFFAXID, produces = MediaType.APPLICATION_PDF_VALUE)
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public ResponseEntity<byte[]> downloadFaxPdf(@PathVariable String faxId, HttpServletResponse response) {

		try {
			FaxRx faxRxResponse = faxRxService.fetchListById(faxId);
			InputStream is;
			String ftpUrl = faxRxResponse.getFaxUrl();
			is = new URL(ftpUrl).openStream();

			// Read PDF content into a byte array
			byte[] pdfBytes = is.readAllBytes();

			// Set the content type and attachment header
			response.setContentType("application/pdf");
			response.setHeader("Content-Disposition", "attachment; filename=downloaded_file.pdf");

			// Copy the file content to the response
			ServletOutputStream outputStream = response.getOutputStream();
			outputStream.write(pdfBytes, 0, pdfBytes.length);
			outputStream.flush();
			outputStream.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (IOException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return null;
	}

	/** Retrieves A List of FaxDetailsPdfByFaxId in FaxRx Details */
	@SuppressWarnings("unchecked")
	@GetMapping(value = FaxRxConstant.GETFAXDETAILSFAXID, produces = MediaType.APPLICATION_JSON_VALUE)
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public NSServiceResponse<FaxRx> faxDetails(@PathVariable String faxId) {
		FaxRx faxRxResponse = faxRxService.fetchListById(faxId);
		return ResponseHelper.createResponse(new NSServiceResponse<FaxRx>(), faxRxResponse,
				CommonConstants.SUCCESSFULLY, CommonConstants.ERRROR);
	}

	/** Update A DupeMainFaxId in FaxRx */
	@SuppressWarnings("unchecked")
	@PutMapping(value = FaxRxConstant.UPDATEFAXDUPEMAINFAXID, produces = MediaType.APPLICATION_JSON_VALUE)
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public NSServiceResponse<String> updateFax(@PathVariable String dupeTrnFaxId, @PathVariable String mainTrnFaxId) {
		String response = faxRxService.updatefax(dupeTrnFaxId, mainTrnFaxId);
		return ResponseHelper.createResponse(new NSServiceResponse<String>(), response, CommonConstants.SUCCESSFULLY,
				CommonConstants.ERRROR);
	}

	/** Update A KeepDuplicateTrnFaxId in FaxRx */
	@SuppressWarnings("unchecked")
	@PutMapping(value = FaxRxConstant.KEEPDUPLICATETRNFAXID, produces = MediaType.APPLICATION_JSON_VALUE)
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public NSServiceResponse<String> keepDuplicate(@PathVariable String trnFaxId) {
		String response = faxRxService.keepDuplicate(trnFaxId);
		return ResponseHelper.createResponse(new NSServiceResponse<String>(), response,
				CommonConstants.UPDATEDSUCCESSFULLY, CommonConstants.ERRROR);
	}

	@SuppressWarnings("unchecked")
	@PostMapping(FaxRxConstant.FAXRXDUPE)
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public NSServiceResponse<FaxRxDupeRequest> faxRxValidateProc(@RequestBody FaxRxDupeRequest req) {
		String response = faxRxService.faxRxValidateProc(req);
		return ResponseHelper.createResponse(new NSServiceResponse<FaxRxDupeRequest>(), response, "Successfully ",
				"Error");
	}

	/** Retrieves A FaxPdfByFaxId in FaxRx */
	@SuppressWarnings("unchecked")
	@PostMapping(value = FaxRxConstant.FAXRXAlERTMAIL, produces = MediaType.APPLICATION_JSON_VALUE)
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public NSServiceResponse<String> sendAlertMail(@PathVariable String faxId) {

		try {

			FaxRx faxRxResponse = faxRxService.faxRxSendMail(faxId);
			InputStream is;
			InputStreamSource inputStreamSource = null;
			String ftpUrl = faxRxResponse.getFaxUrl();
			URL url = new URL(ftpUrl);
			UrlResource urlResource = new UrlResource(url);
			EmailResponseDto response = new EmailResponseDto();
			EmailDto mail = new EmailBuilder().From(fromEmail).To(fromEmail).Template(alertTemplate)
					.AddContext(subject, alertMail).Subject("Alert Mail").createMail();
			emailService.sendAlertMail(mail, true, urlResource);
			response.setMessage(CommonConstants.EMAILSENTSUCCESSFULLY);
			return ResponseHelper.createResponse(new NSServiceResponse<String>(), "Success",
					CommonConstants.EMAILSENTSUCCESSFULLY, CommonConstants.EMAILSENTFAILED);
		} catch (MessagingException e) {
			throw new NSException(ErrorCodes.INTERNAL_SERVER_ERROR, CommonConstants.EMAILSENTFAILED);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@PostMapping(value = FaxRxConstant.PDFSENDMAIL, produces = MediaType.APPLICATION_JSON_VALUE)
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public NSServiceResponse<String> sendPdfMail(@PathVariable String faxId) {

		try {
			FaxRx faxRxResponse = faxRxService.fetchListById(faxId);
			InputStream is;
			String ftpUrl = faxRxResponse.getFaxUrl();
			URL url = new URL(ftpUrl);
			UrlResource urlResource = new UrlResource(url);
			EmailResponseDto response = new EmailResponseDto();
			EmailDto mail = new EmailBuilder().From(fromEmail).To(fromEmail).Template(alertTemplate)
					.AddContext(subject, alertMail).Subject("Alert Mail").createMail();
			emailService.sendAlertMail(mail, true, urlResource);
			response.setMessage(CommonConstants.EMAILSENTSUCCESSFULLY);
			return ResponseHelper.createResponse(new NSServiceResponse<String>(), "Success",
					CommonConstants.EMAILSENTSUCCESSFULLY, CommonConstants.EMAILSENTFAILED);
		} catch (MessagingException e) {
			throw new NSException(ErrorCodes.INTERNAL_SERVER_ERROR, CommonConstants.EMAILSENTFAILED);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@PutMapping(value = FaxRxConstant.PDFPAGEROTATION, produces = MediaType.APPLICATION_JSON_VALUE)
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public ResponseEntity<Map<String, Object>> updatePageRotation(@PathVariable String faxId,
			@RequestBody Map<String, Integer> pageRotations) {
		Map<String, Object> response = new HashMap<>();

		try {
			FaxRx faxRxResponse = faxRxService.fetchListById(faxId);

			String ftpUrl = faxRxResponse.getFaxUrl();
			try (InputStream is = new URL(ftpUrl).openStream()) {

				PDDocument document = new PDDocument();

				document.addPage(new PDPage());

				for (Map.Entry<String, Integer> entry : pageRotations.entrySet()) {
					String pageId = entry.getKey();
					int rotationAngle = entry.getValue();

					int pageIndex = Integer.parseInt(pageId);
					if (pageIndex >= 0 && pageIndex < document.getNumberOfPages()) {
						PDPage pageToRotate = document.getPage(pageIndex);
						 System.out.println("Before Rotation - Page Rotation: " + pageToRotate.getRotation());
					        pageToRotate.setRotation(rotationAngle);
					        System.out.println("After Rotation - Page Rotation: " + pageToRotate.getRotation());
						
					} else {

						response.put("success", false);
						response.put("message", "Invalid page index: " + pageIndex);
						return ResponseEntity.badRequest().body(response);
					}
				}

				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				document.save(baos);
				document.close();

				String rotatedPdfContent = Base64.getEncoder().encodeToString(baos.toByteArray());
				byte[] rotatedPdfBytes = baos.toByteArray();
				faxRxService.updatePdfInDatabase(faxRxResponse.getFaxId(), rotatedPdfBytes);

				response.put("success", true);
				response.put("message", "PDF rotated successfully");
				response.put("rotatedPdfContent", rotatedPdfContent);

				return ResponseEntity.ok(response);
			}
		} catch (IOException e) {
			e.printStackTrace();

			response.put("success", false);
			response.put("message", "Error processing PDF: " + e.getMessage());
			return ResponseEntity.status(500).body(response);
		}
	}

}
