package com.nextscience.dto.response;

import java.util.Date;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Processes an {@link AccountDetailsResponse } response.
 * @author Raghu
 *
 */

@Data
@NoArgsConstructor
public class AccountDetailsResponse {

	  private Integer accountId;

	    private String acctWhId;

	    private String accountName;

	    private String accountName2;

	    private String accountType;

	    private String facilityType;

	    private String address1;

	    private String address2;

	    private String city;

	    private String state;

	    private String zip;

	    private String country;

	    private String phone;

	    private String fax;

	    private String email;

	    private String npi;

	    private String internalId;

	    private String custId;

	    private Double latitude;

	    private Double longitude;

	    
	    private Date geoDate;

	    private String website;

	    private String acoAffiliations;

	    private String ownership;

	    private String medSchoolAffiliation;

	    private String dhcProfileLink;

	    private String gpoAffiliations;

	    private String idnWhId;

	    private String idnName;

	    private String parentIdnWhId;

	    private String parentIdnName;

	    private String idnIntegrationLevel;

	    private String createdUser;

	   
	    private Date createdDate;

	    private String updatedUser;

	    
	    private Date updatedDate;

	    private String primaryHin;

	    private String facilityNickname;

	    private String gpoMembership;

	    private String activeFlag;

	    private String complex;

	    private String network;

	    private String facilityClassification;

	    private String AccountName2;

	    private String keyAccount;

	    private String accountClass;

	    private String stateName;

	    private String nationalAccountFlag;

	    private String sfAccountNumber;

	    private String sfAccountId;

	    private String sfAccountName;

	    private String sfParentAccount;

	    private String sfParentAccountId;

	    private String sfMatchType;

	    private String acctStatus;

	    private String acctCatg;

	    private String status;

	   
	    private Date statusDate;


		public AccountDetailsResponse(Integer accountId, String acctWhId, String accountName, String accountName2,
				String accountType, String facilityType, String address1, String address2, String city, String state,
				String zip, String country, String phone, String fax, String email, String npi, String internalId,
				String custId, Double latitude, Double longitude, Date geoDate, String website, String acoAffiliations,
				String ownership, String medSchoolAffiliation, String dhcProfileLink, String gpoAffiliations,
				String idnWhId, String idnName, String parentIdnWhId, String parentIdnName, String idnIntegrationLevel,
				String createdUser, Date createdDate, String updatedUser, Date updatedDate, String primaryHin,
				String facilityNickname, String gpoMembership, String activeFlag, String complex, String network,
				String facilityClassification, String AccountName2, String keyAccount, String accountClass,
				String stateName, String nationalAccountFlag, String sfAccountNumber, String sfAccountId,
				String sfAccountName, String sfParentAccount, String sfParentAccountId, String sfMatchType,
				String acctStatus, String acctCatg, String status, Date statusDate) {
			super();
			this.accountId = accountId;
			this.acctWhId = acctWhId;
			this.accountName = accountName;
			this.accountName2 = accountName2;
			this.accountType = accountType;
			this.facilityType = facilityType;
			this.address1 = address1;
			this.address2 = address2;
			this.city = city;
			this.state = state;
			this.zip = zip;
			this.country = country;
			this.phone = phone;
			this.fax = fax;
			this.email = email;
			this.npi = npi;
			this.internalId = internalId;
			this.custId = custId;
			this.latitude = latitude;
			this.longitude = longitude;
			this.geoDate = geoDate;
			this.website = website;
			this.acoAffiliations = acoAffiliations;
			this.ownership = ownership;
			this.medSchoolAffiliation = medSchoolAffiliation;
			this.dhcProfileLink = dhcProfileLink;
			this.gpoAffiliations = gpoAffiliations;
			this.idnWhId = idnWhId;
			this.idnName = idnName;
			this.parentIdnWhId = parentIdnWhId;
			this.parentIdnName = parentIdnName;
			this.idnIntegrationLevel = idnIntegrationLevel;
			this.createdUser = createdUser;
			this.createdDate = createdDate;
			this.updatedUser = updatedUser;
			this.updatedDate = updatedDate;
			this.primaryHin = primaryHin;
			this.facilityNickname = facilityNickname;
			this.gpoMembership = gpoMembership;
			this.activeFlag = activeFlag;
			this.complex = complex;
			this.network = network;
			this.facilityClassification = facilityClassification;
			this.AccountName2 = AccountName2;
			this.keyAccount = keyAccount;
			this.accountClass = accountClass;
			this.stateName = stateName;
			this.nationalAccountFlag = nationalAccountFlag;
			this.sfAccountNumber = sfAccountNumber;
			this.sfAccountId = sfAccountId;
			this.sfAccountName = sfAccountName;
			this.sfParentAccount = sfParentAccount;
			this.sfParentAccountId = sfParentAccountId;
			this.sfMatchType = sfMatchType;
			this.acctStatus = acctStatus;
			this.acctCatg = acctCatg;
			this.status = status;
			this.statusDate = statusDate;
		}
	    
	    
}
