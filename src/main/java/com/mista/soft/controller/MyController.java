package com.mista.soft.controller;

import com.mista.soft.entity.Customer;
import com.mista.soft.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class MyController {
    @Autowired
    private CustomerService customerService;

    @RequestMapping("/")
    public String showAllCustomers(Model model){
        List<Customer> allCustomers = customerService.getAllCustomers();
        model.addAttribute("allEmps",allCustomers);
        return "all-customers";
    }
    @RequestMapping("/addNewCustomer")
    public String addNewCustomer(Model model){
        Customer customer= new Customer();
        model.addAttribute("customer",customer);
        return "new-customer";
    }
    @RequestMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer customer){
        customerService.saveCustomer(customer);
        return "redirect:/";
    }
    @RequestMapping("/updateInfo")
    public String updateCustomer(@RequestParam("empId") long id, Model model){
        Customer customer = customerService.getCustomer(id);
        model.addAttribute("customer",customer);
        return "edit-customer";
    }

    @RequestMapping("/deleteCustomer")
    public String deleteCustomer(@RequestParam ("empId") long id){
        customerService.deleteCustomer(id);
        return "redirect:/";
    }
    @RequestMapping("/searchCustomer")
    public String searchCustomer(@RequestParam ("keyword") String keyword, Model model){
        List<Customer> searchCustomers = customerService.search(keyword);
        model.addAttribute("result",searchCustomers);
        return "search";
    }
}
