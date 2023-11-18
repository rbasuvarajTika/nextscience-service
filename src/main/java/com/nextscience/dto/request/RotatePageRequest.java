package com.nextscience.dto.request;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Data
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class RotatePageRequest {
	
	 private Map<String, String> pageAndRotationMap; // e.g., {"1":"90"} for page 1 with a rotation of 90 degrees

	    // getters and setters

	    public Map<String, String> getPageAndRotationMap() {
	        return pageAndRotationMap;
	    }

	    public void setPageAndRotationMap(Map<String, String> pageAndRotationMap) {
	        this.pageAndRotationMap = pageAndRotationMap;
	    }
	}

