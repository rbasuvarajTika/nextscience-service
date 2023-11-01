package com.nextscience.repo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.nextscience.entity.ProductDetails;

/**
 * Repository interface for managing {@link ProductDetailsRepository}.request
 * 
 * @author Raghu
 */

@Repository
public interface ProductDetailsRepository extends JpaRepository<ProductDetails, Integer> {
	@Query(nativeQuery = true, value = "SELECT a.TRN_RX_ID,a.[TRN_FAX_ID],b.FAX_ID\r\n"
			+ ",pr.PRODUCT_ID,pr.PRODUCT_CODE,pr.PRODUCT_DISPLAY_NAME\r\n"
			+ ",wp.[QUANTITY],wp.[WND1],wp.[WND2],wp.[WND3],wp.[WND4],wp.WND_CODE\r\n"
			+ "FROM [dbo].[TRN_FAX_RX_PRESCRIPTIONS] a\r\n"
			+ "join [TRN_FAX_RX] b on (a.[TRN_FAX_ID]=b.[TRN_FAX_ID])\r\n"
			+ "left join [BRDG_FAX_RX_WOUND_PRODUCT_INFO] wp on (a.[TRN_FAX_ID]=wp.[TRN_FAX_ID])\r\n"
			+ "left join [DIM_PRODUCT] pr on (wp.[PRODUCT_ID]=pr.PRODUCT_ID)")
	List<Object[]> getProductList();

	@Query(nativeQuery = true, value = "SELECT a.TRN_RX_ID,a.[TRN_FAX_ID],b.FAX_ID\r\n"
			+ ",pr.PRODUCT_ID,pr.PRODUCT_CODE,pr.PRODUCT_DISPLAY_NAME\r\n"
			+ ",wp.[QUANTITY],wp.[WND1],wp.[WND2],wp.[WND3],wp.[WND4],wp.WND_CODE\r\n"
			+ "FROM [dbo].[TRN_FAX_RX_PRESCRIPTIONS] a\r\n"
			+ "join [TRN_FAX_RX] b on (a.[TRN_FAX_ID]=b.[TRN_FAX_ID])\r\n"
			+ "left join [BRDG_FAX_RX_WOUND_PRODUCT_INFO] wp on (a.[TRN_FAX_ID]=wp.[TRN_FAX_ID])\r\n"
			+ "left join [DIM_PRODUCT] pr on (wp.[PRODUCT_ID]=pr.PRODUCT_ID)\r\n" + "WHERE a.[TRN_RX_ID]=:TRN_RX_ID")
	List<Object[]> getProductDetByTrnRxId(@Param(value = "TRN_RX_ID") int trnRxId);
	
	@Query(nativeQuery = true, value = "SELECT PRODUCT_ID, PRODUCT_CODE, PRODUCT_NAME FROM DIM_PRODUCT")
    List<Object[]> getProductInfoDetails();
    
    

}
