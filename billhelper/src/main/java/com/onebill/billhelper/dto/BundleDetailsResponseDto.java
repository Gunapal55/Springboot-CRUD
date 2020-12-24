package com.onebill.billhelper.dto;

import java.io.Serializable;

import com.onebill.billhelper.entity.Bundle;


import lombok.Data;

@Data
@SuppressWarnings("serial")
public class BundleDetailsResponseDto implements Serializable {

	
	private int bundleDetailId;

	private String bundleType;

	private String bundleDetails;

	private Bundle bundle;

}
