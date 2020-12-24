package com.onebill.billhelper.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onebill.billhelper.dao.ProductsDao;
import com.onebill.billhelper.dto.AdditionalResponseDto;
import com.onebill.billhelper.dto.BundleDetailsResponseDto;
import com.onebill.billhelper.dto.BundleResponseDto;
import com.onebill.billhelper.dto.OverDueResponseDto;
import com.onebill.billhelper.dto.ProductsDto;
import com.onebill.billhelper.exception.BillhelperException;

@Service
public class ProductsServiceImplementation implements ProductsService {

	@Autowired
	private ProductsDao productsdao;

	public void setProductDao(ProductsDao productsdao) {
		this.productsdao = productsdao;
	}

	@Override
	public ProductsDto addProduct(ProductsDto product) {
		ProductsDto products = null;
		try {
			products = productsdao.addProduct(product);
			if (products != null) {
				return products;
			} else {
				throw new BillhelperException("Failed to add product with Name " + product.getProductName()
						+ " and Type " + product.getProductType()
						+ ", Duplicate product may exisits try with differnt product name");
			}
		} catch (Exception e) {
			throw new BillhelperException("Failed to add product with Name " + product.getProductName() + " and Type "
					+ product.getProductType() + " Duplicate product may exisits try with differnt product name");
		}
	}

	@Override
	public ProductsDto removeProduct(int productId) {

		ProductsDto remPro = null;
		try {
			remPro = productsdao.removeProduct(productId);
			if (remPro != null) {

				return remPro;

			} else {
				throw new BillhelperException("Failed to remove the requested product");
			}
		} catch (Exception e) {
			throw new BillhelperException(
					"Unable to remove the prduct with id: " + productId + " please ensure you have entered proper ID");
		}
	}

	@Override
	public ProductsDto updateProduct(ProductsDto product) {
		ProductsDto updPro = null;
		try {
			updPro = productsdao.updateProduct(product);

			if (updPro != null) {
				return updPro;

			} else {
				throw new BillhelperException(
						"Unable to update the requested product with id of " + product.getProductId() + " Name "
								+ product.getProductName() + " and Type of " + product.getProductType());
			}
		} catch (Exception e) {
			throw new BillhelperException("Unable to update the requested product with id of " + product.getProductId()
					+ " Name " + product.getProductName() + " and Type of " + product.getProductType());
		}
	}

	@Override
	public List<ProductsDto> getAllProduct() {

		List<ProductsDto> proList = null;
		try {
			proList = productsdao.getAllProduct();
			if (proList != null) {

				return proList;

			} else {
				throw new BillhelperException("Product list is empty!!");
			}
		} catch (Exception e) {
			throw new BillhelperException("Please add new products to display list is empty");
		}
	}

	@Override
	public ProductsDto getProductById(int productId) {

		ProductsDto getPro = null;
		try {
			getPro = productsdao.getProductById(productId);
			if (getPro != null) {
				return getPro;
			} else {
				throw new BillhelperException("No matching product for id: " + productId + " please enter vaild id ");

			}
		} catch (Exception e) {
			throw new BillhelperException("No matching product for id: " + productId + " please enter vaild id ");
		}
	}

	@Override
	public ProductsDto getProductByName(String productName) {
		ProductsDto getPro = null;
		try {
			getPro = productsdao.getProductByName(productName);
			if (getPro != null) {
				return getPro;
			} else {
				throw new BillhelperException("No matching product for product name: " + productName + " please enter vaild product name ");

			}
		} catch (Exception e) {
			throw new BillhelperException("No matching product for product name: " + productName + " please enter vaild product name ");
		}
	}

	@Override
	public List<BundleResponseDto> getProductBundle(int productId) {
		List<BundleResponseDto> bundle = null;
		try {
			bundle = productsdao.getProductBundle(productId);
			if (!bundle.isEmpty()) {
				return bundle;
			} else {
				throw new BillhelperException("No bundle available for the selected product");
			}
		} catch (Exception e) {
			throw new BillhelperException("No bundle available for this produt id of "+productId);
		}
	}

	@Override
	public List<BundleDetailsResponseDto> getBundleDetails(int productId, int bundleId) {
		List<BundleDetailsResponseDto> details = null;
		try {
			details = productsdao.getBundleDetails(productId, bundleId);
			if (!details.isEmpty()) {
				return details;
			} else {
				throw new BillhelperException("No details available for the selected product's bundle plan");
			}
		} catch (Exception e) {
			throw new BillhelperException("No bundle available for this produt id of "+productId+" and bundel id of "+bundleId);
		}
	}

	@Override
	public List<AdditionalResponseDto> getAdditionalCharge(int productId, int bundleId) {
		List<AdditionalResponseDto> add = null;
		try {
			add = productsdao.getAdditionalCharge(productId, bundleId);
			if (!add.isEmpty()) {
				return add;
			} else {
				throw new BillhelperException("No additional charges avavilable for the selected product's bundle plan");
			}
		} catch (Exception e) {
			throw new BillhelperException("No additional charges avavilable for product id of "+productId+" and bundle id of "+bundleId);
		}
	}

	@Override
	public List<OverDueResponseDto> getOverdue(int productId, int bundleId) {
		List<OverDueResponseDto> overdue = null;
		try {
			overdue = productsdao.getOverdue(productId, bundleId);
			if (!overdue.isEmpty()) {
				return overdue;
			} else {
				throw new BillhelperException("No Overdues available for the selected product's bundle plan");
			}
		} catch (Exception e) {
			throw new BillhelperException("No Overdues available for this produt id of "+productId+" and bundle id of "+bundleId);
		}
		
	}

}
