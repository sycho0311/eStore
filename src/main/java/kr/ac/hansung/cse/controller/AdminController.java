package kr.ac.hansung.cse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.ac.hansung.cse.model.Product;
import kr.ac.hansung.cse.service.ProductService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private ProductService productService;
	
	@RequestMapping
	public String adminPage() {
		return "admin";
	}
	
	@RequestMapping("/productInventory")
	public String getProducts(Model model) { // controller -> model -> view
		
		List<Product> products = productService.getProducts();
		model.addAttribute("products", products);
		
		return "productInventory";
	}
	
	@RequestMapping(value="productInventory/addProduct", method=RequestMethod.GET)
	public String addProduct(Model model) {
		
		Product product = new Product();
		product.setCategory("computer"); // initial
		
		model.addAttribute("product", product);
		
		return "addProduct";
	}
	
	@RequestMapping(value="productInventory/addProduct", method=RequestMethod.POST)
	public String addProductPost(Product product) {
		
		if ( !productService.addProduct(product))
			System.out.println("Adding product cannot be done");
		
		return "redirect:/admin/productInventory";  // to apply model
	}
	
	@RequestMapping(value="productInventory/deleteProduct/{id}", method=RequestMethod.GET)
	public String deleteProduct(@PathVariable int id) {
		
		if ( !productService.deleteProduct(id))
			System.out.println("Deleting product cannot be done");
		
		return "redirect:/admin/productInventory";  // to apply model
	}
	
	@RequestMapping(value="productInventory/updateProduct/{id}", method=RequestMethod.GET)
	public String updateProduct(@PathVariable int id, Model model) {
		
		Product product = productService.getProductById(id);
		
		model.addAttribute("product", product);
		
		return "updateProduct";
	}
	
	@RequestMapping(value="productInventory/updateProduct", method=RequestMethod.POST)
	public String updateProductPost(Product product) {
		
		// System.out.println(product); // id binding hidden
		
		if ( !productService.updateProduct(product))
			System.out.println("Updating product cannot be done"); 
		
		return "redirect:/admin/productInventory";  // to apply model
	}
	
}
