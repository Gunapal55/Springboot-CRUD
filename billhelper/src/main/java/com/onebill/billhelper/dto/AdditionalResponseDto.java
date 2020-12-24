package com.onebill.billhelper.dto;

import java.io.Serializable;

import com.onebill.billhelper.entity.Bundle;

import lombok.Data;

@SuppressWarnings("serial")
@Data
public class AdditionalResponseDto implements Serializable{


	private int chargeId;
	
	private String chargeType;
	
	private int chargeAmount;
	
	private String requiredDocuments;
	
	private Bundle bundle;
}
