package com.nhoclahola.bt2511_springsecurityjwt_demo3.controllers;

import com.nhoclahola.bt2511_springsecurityjwt_demo3.entities.Product;
import com.nhoclahola.bt2511_springsecurityjwt_demo3.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class LoginController
{
    private final ProductService productService;

    @PostMapping("/login_success_handler")
    public String loginSuccessHandler()
    {
        System.out.println("Logging user login success....");
        return "index";
    }

    @PostMapping("/login_failure_handler")
    public String loginFailureHandler()
    {
        System.out.println("Logging failure handler....");
        return "login";
    }

    @RequestMapping("/")
    public String viewHomePage(Model model)
    {
        List<Product> products = productService.listAll();
        model.addAttribute("listProducts", products);
        return "index";
    }

    @RequestMapping("/new")
    public String showNewProductForm(Model model, @ModelAttribute("product") Product product)
    {
        model.addAttribute("product", product);
        return "new_product";
    }

    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String saveProduct(@ModelAttribute("product") Product product)
    {
        productService.save(product);
        return "redirect:/";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditProductForm(@PathVariable(name = "id") Long id)
    {
        ModelAndView mav = new ModelAndView("edit_product");
        Product product = productService.get(id);
        mav.addObject("product", product);
        return mav;
    }

    @RequestMapping("/delete/{id}")
    public String deleteProduct(@PathVariable(name = "id") Long id)
    {
        productService.delete(id);
        return "redirect:/";
    }
}
