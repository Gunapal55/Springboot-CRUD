package com.onebill.billhelper.dto;

import java.io.Serializable;

import com.onebill.billhelper.entity.Products;

import lombok.Data;

@Data
@SuppressWarnings("serial")
public class BundleResponseDto implements Serializable {

	private int bundleId;

	private String bundleDescription;

	private String bundleType;

	private String bundleDuration;

	private double bundleAmount;

	private Products products;

}
