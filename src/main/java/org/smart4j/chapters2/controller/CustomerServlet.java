package org.smart4j.chapters2.controller;

import org.smart4j.chapters2.model.Customer;
import org.smart4j.chapters2.service.CustomerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 进入客户列表界面
 */
@WebServlet("/customer")
public class CustomerServlet extends HttpServlet{
       CustomerService customerService = new CustomerService();
    @Override                                                                                                                
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Customer> customerList = customerService.getCustomerList();
        req.setAttribute("customers",customerList);
        req.getRequestDispatcher("WEB-INF/jsp/customer.jsp").forward(req,resp);
        
    }

    }