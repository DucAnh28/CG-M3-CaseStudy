package casestudy.controller;

import casestudy.model.Customer;
import casestudy.service.customer.CustomerDAO;
import casestudy.service.customer.ICustomerDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@WebServlet (name = "CustomerServlet",urlPatterns = "/customer")
public class CustomerServlet extends HttpServlet {
    ICustomerDAO customerDAO = new CustomerDAO();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            case "create":
                showListCreate(req,resp);
                break;
            case "showDetailCustomer":

                break;
            default:
                showHomePageCustomer(req,resp);
                break;
        }
    }

    private void showUpdateDetailForm(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
        RequestDispatcher dispatcher = request.getRequestDispatcher("website/customer/customerDetail.jsp");
    }

    private void showListCreate(HttpServletRequest request,HttpServletResponse response)  throws IOException,ServletException{
        RequestDispatcher dispatcher = request.getRequestDispatcher("website/customer/create.jsp");
        dispatcher.forward(request,response);
    }

    private void showHomePageCustomer(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        RequestDispatcher dispatcher = request.getRequestDispatcher("website/customer/homepageCustomer.jsp");
        dispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            case "create":
                createNewCustomer(req,resp);
                break;
            default:
                showHomePageCustomer(req,resp);
                break;
        }
    }

    private void createNewCustomer(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        RequestDispatcher dispatcher = request.getRequestDispatcher("website/customer/create.jsp");
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        String gender = request.getParameter("gender");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String account = request.getParameter("account");
        String password = request.getParameter("password");
        Date date = Date.valueOf(LocalDate.now());
        Customer customer = new Customer(id,name,age,gender,address,phone,email,account,password,date);
        customerDAO.save(customer);
        request.setAttribute("mess","Create Successful");
        dispatcher.forward(request,response);
    }
}
