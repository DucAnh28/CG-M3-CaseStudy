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
import java.util.List;

@WebServlet (name = "CustomerServlet",urlPatterns = "/customer")
public class CustomerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            case "create":

                break;
            default:
                showAllCustomerInShop(req,resp);
                break;
        }
    }

    private void showListCreate(HttpServletRequest request,HttpServletResponse response)  throws IOException,ServletException{

    }

    private void showAllCustomerInShop(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        ICustomerDAO customerDAO = new CustomerDAO();
        List<Customer> customers = customerDAO.selectAll();
        RequestDispatcher dispatcher = request.getRequestDispatcher("website/customer/customer.jsp");
        request.setAttribute("dskh",customers);
        dispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
