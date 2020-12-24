package com.onebill.billhelper.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.onebill.billhelper.dto.ProductsDto;
import com.onebill.billhelper.dto.ResponseDto;
import com.onebill.billhelper.service.ProductsService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/products")
public class ProductsController {

	@Autowired
	private ProductsService service;

	@ResponseBody
	@PostMapping
	public ResponseDto getProduct(@RequestBody ProductsDto product) {
		ResponseDto response = new ResponseDto();
		response.setData(service.addProduct(product));
		return response;
	}

	@PutMapping
	public ResponseDto updateProduct(@RequestBody ProductsDto product) {
		ResponseDto response = new ResponseDto();
		response.setData(service.updateProduct(product));
		return response;
	}

	@DeleteMapping("/{productId}")
	public ResponseDto removeProduct(@PathVariable int productId) {
		System.out.println(productId);
		ResponseDto response = new ResponseDto();
		response.setData(service.removeProduct(productId));
		return response;

	}

	@GetMapping
	public ResponseDto getAllProducts() {
		ResponseDto response = new ResponseDto();
		response.setData(service.getAllProduct());
		return response;

	}

	@GetMapping("/{productId}")
	public ResponseDto getProductById(@PathVariable int productId) {
		ResponseDto response = new ResponseDto();
		response.setData(service.getProductById(productId));
		return response;

	}

	@GetMapping("product/{productName}")
	public ResponseDto getProductById(@PathVariable String productName) {
		System.out.println(productName);
		ResponseDto response = new ResponseDto();
		response.setData(service.getProductByName(productName));
		return response;

	}

	@GetMapping("/{productId}/bundles")
	public ResponseDto getProductBundles(@PathVariable int productId) {
		ResponseDto response = new ResponseDto();
		response.setData(service.getProductBundle(productId));
		return response;

	}

	@GetMapping("/{productId}/bundles/{bundleId}/details")
	public ResponseDto getBundleDetails(@PathVariable int productId, int bundleId) {
		ResponseDto response = new ResponseDto();
		response.setData(service.getBundleDetails(productId, bundleId));
		return response;

	}

	@GetMapping("/{productId}/bundles/{bundleId}/due")
	public ResponseDto getBundleOverDue(@PathVariable int productId, int bundleId) {
		ResponseDto response = new ResponseDto();
		response.setData(service.getOverdue(productId, bundleId));
		return response;

	}

	@GetMapping("/{productId}/bundles/{bundleId}/additional")
	public ResponseDto getProductById(@PathVariable int productId, int bundleId) {
		ResponseDto response = new ResponseDto();
		response.setData(service.getAdditionalCharge(productId, bundleId));
		return response;

	}

}
