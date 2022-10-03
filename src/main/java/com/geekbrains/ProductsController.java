package com.geekbrains;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/product")
public class ProductsController {
    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }
    @RequestMapping("/showForm")
    public String showForm(Model model){
        Product product = new Product();
        model.addAttribute("product",product);
        return "showForm";
    }

    @RequestMapping("/processForm")
    public String processForm(Product product) {
        productService.addProduct(product);
        return "processFormWithNewProduct";
    }

    @RequestMapping(path = "/showProductById", method = RequestMethod.GET)
    @ResponseBody
    public Product showProductId(Model model, @RequestParam long id){
        Product product  = productService.getProductId(id);
        return product;
    }

    @RequestMapping("/showProducts")
    public String showProducts(Model model){
        model.addAttribute("products",productService.getAll());
        return "showProducts";
    }

}
