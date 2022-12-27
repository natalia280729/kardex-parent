package com.todouno.kardex.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.todouno.kardex.data.Products;
import com.todouno.kardex.domain.ProductDto;
import com.todouno.kardex.domain.SaleProduct;
import com.todouno.kardexsystem.services.ProductService;

@RestController
@RequestMapping("/api/product")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {
	@Autowired
	public ProductService productService;
	
	
	
	
	public ProductService getProductService() {
		return productService;
	}




	public void setProductService(ProductService productService) {
		this.productService = productService;
	}



	 @GetMapping("/list")
	public List<Products> findProducts(){
		return productService.findProducts();
	}
	 
	 @GetMapping("/search")
		public List<Products> findProducts(@RequestParam String name,@RequestParam(defaultValue="") String barCode){
			return productService.findByNameAndBarCode(name, barCode);
		}
	 
	 @PostMapping("/save")
	 public Products saveProducts(@RequestBody ProductDto products){
			return productService.saveProduct(products);
		}
	 
	 @PostMapping("/sale")
	 public Products saleProducts(@RequestBody SaleProduct saleProduct){
			 productService.saleProduct(saleProduct);
			 return new Products();
		}
	 
	 
	 
		
	
}
