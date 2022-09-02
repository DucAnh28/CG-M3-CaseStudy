package casestudy.controller;

import casestudy.model.Customer;
import casestudy.service.book.BookService;
import casestudy.service.book.IBookDAO;
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

@WebServlet(name = "AdminServlet", urlPatterns = "/admin")
public class AdminServlet extends HttpServlet {
    ICustomerDAO customerDAO = new CustomerDAO();
    IBookDAO bookDAO = new BookService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "showAllBook":
                break;
            case "editBook":
                break;
            case "showAllCus":
                showAllCustomer(req, resp);
                break;
            case "editCustomer":
                showEditCustomer(req, resp);
                break;
            default:
                showHomePageAdmin(req,resp);
        }
    }

    private void showHomePageAdmin(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
        RequestDispatcher dispatcher = request.getRequestDispatcher("webapp/website/admin/adminPage.jsp");
        dispatcher.forward(request,response);
    }

    private void showEditCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id")) ;
        Customer customer = customerDAO.findByID(id);
        request.setAttribute("thisCus",customer);
        RequestDispatcher dispatcher = request.getRequestDispatcher("website/customer/update.jsp");
        dispatcher.forward(request,response);
    }

    private void showAllCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> customerList = customerDAO.selectAll();
        RequestDispatcher dispatcher = request.getRequestDispatcher("website/admin/customerList.jsp");
        request.setAttribute("cusList", customerList);
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "showAllBook":
                break;
            case "editBook":
                break;
            case "showAllCus":
                showAllCustomer(req, resp);
                break;
            case "editCustomer":

                break;
            default:

        }
    }

}
