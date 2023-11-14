package com.nextscience.Constants;

/**
 * Processes an {@link FaxRxConstant } constant.
 * 
 * @author Raghu
 *
 */
public class FaxRxConstant {
	public static final String FAXDUPE = "/faxDupe";
	public static final String FAXDUPEBYFAXID = "/faxDupeById/{faxId}";
	public static final String GETFAXPDFFAXID = "/getFaxPdf/{faxId}";
	public static final String GETFAXDETAILSFAXID = "/getFaxDetails/{faxId}";
	public static final String UPDATEFAXDUPEMAINFAXID = "/updateFax/{dupeTrnFaxId}/{mainTrnFaxId}";
	public static final String KEEPDUPLICATETRNFAXID = "/keepDuplicate/{trnFaxId}";
	public static final String FAXPDF = "/faxPdf";
	public static final String FAXLIST = "/faxList";
	public static final String FAXRXDUPE = "/faxRxDupe";
	public static final String FAXRXAlERTMAIL = "/faxRx/alertMail/{faxId}";
	public static final String DOWNLOADFAXPDFFAXID="/download-fax-pdf/{faxId}";
	public static final String PDFSENDMAIL="/faxRx/sendPdfMail/{faxId}";
	public static final String PDFPAGEROTATION="PageRotation/{faxId}";

	
	

}
