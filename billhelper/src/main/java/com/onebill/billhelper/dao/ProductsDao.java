package com.onebill.billhelper.dao;

import java.util.List;

import com.onebill.billhelper.dto.AdditionalResponseDto;
import com.onebill.billhelper.dto.BundleDetailsResponseDto;
import com.onebill.billhelper.dto.BundleResponseDto;
import com.onebill.billhelper.dto.OverDueResponseDto;
import com.onebill.billhelper.dto.ProductsDto;

public interface ProductsDao {

	public ProductsDto addProduct(ProductsDto product);
	
	public ProductsDto updateProduct(ProductsDto product);
	
	public List<ProductsDto> getAllProduct();
	
	public ProductsDto getProductById(int productId);

	public ProductsDto removeProduct(int productId);
	
	public ProductsDto getProductByName(String productName);

	public List<BundleResponseDto> getProductBundle(int productId);

	public List<BundleDetailsResponseDto> getBundleDetails(int productId, int bundleId);

	public List<AdditionalResponseDto> getAdditionalCharge(int productId, int bundleId);

	public List<OverDueResponseDto> getOverdue(int productId, int bundleId);
	
	
}
