package com.onebill.billhelper.dto;

import java.io.Serializable;

import com.onebill.billhelper.entity.Bundle;


import lombok.Data;

@Data
@SuppressWarnings("serial")
public class OverDueResponseDto implements Serializable{
	

	private int overDueId;

	private String chargeType;
	
	private int chargeAmount;
	
	private Bundle bundle;
}