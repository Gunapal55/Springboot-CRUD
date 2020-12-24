package com.onebill.billhelper.dao;

import java.lang.reflect.Type;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import com.onebill.billhelper.dto.AdditionalResponseDto;
import com.onebill.billhelper.dto.BundleDetailsResponseDto;
import com.onebill.billhelper.dto.BundleResponseDto;
import com.onebill.billhelper.dto.OverDueResponseDto;
import com.onebill.billhelper.dto.ProductsDto;
import com.onebill.billhelper.entity.AdditionalCharges;
import com.onebill.billhelper.entity.Bundle;
import com.onebill.billhelper.entity.BundleDetails;
import com.onebill.billhelper.entity.OverDue;
import com.onebill.billhelper.entity.Products;

@Repository
public class ProductsDaoImplementation implements ProductsDao {

	@PersistenceUnit
	EntityManagerFactory factory;

	@Override
	public ProductsDto addProduct(ProductsDto product) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transcation = manager.getTransaction();
		transcation.begin();
		Products pro = new Products();
		BeanUtils.copyProperties(product, pro);
		manager.persist(pro);
		ProductsDto dto = new ProductsDto();
		BeanUtils.copyProperties(pro, dto);
		manager.getTransaction().commit();
		manager.close();
		return dto;
	}

	@Override
	public ProductsDto updateProduct(ProductsDto updateProduct) {
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		Products updatedProduct = manager.find(Products.class, updateProduct.getProductId());
		BeanUtils.copyProperties(updateProduct, updatedProduct);
		ProductsDto dto = new ProductsDto();
		BeanUtils.copyProperties(updatedProduct, dto);
		manager.getTransaction().commit();
		manager.close();
		return dto;
	}

	@Override
	public ProductsDto removeProduct(int productId) {
		System.out.println(productId);
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		Products deletedProduct = manager.find(Products.class, productId);
		ProductsDto dto = new ProductsDto();
		BeanUtils.copyProperties(deletedProduct, dto);
		if (deletedProduct != null) {
			manager.remove(deletedProduct);
			manager.getTransaction().commit();
			manager.close();
			return dto;
		} else {
			manager.close();
			factory.close();
			return null;
		}
	}

	@Override
	public List<ProductsDto> getAllProduct() {
		EntityManager manager = factory.createEntityManager();
		TypedQuery<Products> query = manager.createQuery("FROM Products", Products.class);
		List<Products> products = query.getResultList();
		ModelMapper mapper = new ModelMapper();
		Type listType = new TypeToken<List<ProductsDto>>() {
		}.getType();
		List<ProductsDto> dto = mapper.map(products, listType);
		return dto;
	}

	@Override
	public ProductsDto getProductById(int productId) {
		System.out.println(productId);
		EntityManager manager = factory.createEntityManager();
		Products pro = manager.find(Products.class, productId);
		ProductsDto dto = new ProductsDto();
		BeanUtils.copyProperties(pro, dto);
		manager.close();
		return dto;

	}
	@Override
	public ProductsDto getProductByName(String productName) {
		System.out.println(productName);
		EntityManager manager = factory.createEntityManager();
		TypedQuery<Products> query = manager.createQuery("from Products U where U.productName= :value", Products.class);
		query.setParameter("value", productName);
		Products pro = query.getSingleResult();
		ProductsDto dto = new ProductsDto();
		BeanUtils.copyProperties(pro, dto);
		return dto;
	}
	
	@Override
	public List<BundleResponseDto> getProductBundle(int productId) {
		EntityManager manager = factory.createEntityManager();
		Products pro = new Products();
		pro.setProductId(productId);
		TypedQuery<Bundle> query = manager.createQuery("from Bundle B where B.products=:value", Bundle.class);
		query.setParameter("value", pro);
		List<Bundle> list = query.getResultList();
		ModelMapper mapper = new ModelMapper();
		Type listType = new TypeToken<List<BundleResponseDto>>() {
		}.getType();
		List<BundleResponseDto> dto = mapper.map(list, listType);
		return dto;
	}

	@Override
	public List<BundleDetailsResponseDto> getBundleDetails(int productId, int bundleId) {
		EntityManager manager = factory.createEntityManager();
		Bundle bund = new Bundle();
		bund.setBundleId(bundleId);
		TypedQuery<BundleDetails> query = manager.createQuery("from BundleDetail B where B.bundle=:value", BundleDetails.class);
		query.setParameter("value", bund);
		List<BundleDetails> list = query.getResultList();
		ModelMapper mapper = new ModelMapper();
		Type listType = new TypeToken<List<BundleDetailsResponseDto>>() {
		}.getType();
		return mapper.map(list, listType);
	}

	@Override
	public List<AdditionalResponseDto> getAdditionalCharge(int productId, int bundleId) {
		EntityManager manager = factory.createEntityManager();
		Bundle bund = new Bundle();
		bund.setBundleId(bundleId);
		TypedQuery<AdditionalCharges> query = manager.createQuery("from AdditionalCharges A where A.bundle=:value", AdditionalCharges.class);
		query.setParameter("value", bund);
		List<AdditionalCharges> list = query.getResultList();
		ModelMapper mapper = new ModelMapper();
		Type listType = new TypeToken<List<AdditionalResponseDto>>() {
		}.getType();
		List<AdditionalResponseDto> dto = mapper.map(list, listType);
		return dto;
	}

	@Override
	public List<OverDueResponseDto> getOverdue(int productId, int bundleId) {
		EntityManager manager = factory.createEntityManager();
		Bundle bund = new Bundle();
		bund.setBundleId(bundleId);
		TypedQuery<OverDue> query = manager.createQuery("from OverDue O where O.bundle=:value",
				OverDue.class);
		query.setParameter("value", bund);
		List<OverDue> list = query.getResultList();
		ModelMapper mapper = new ModelMapper();
		Type listType = new TypeToken<List<OverDueResponseDto>>() {
		}.getType();
		List<OverDueResponseDto> dto = mapper.map(list, listType);
		return dto;
	}
	
	
}