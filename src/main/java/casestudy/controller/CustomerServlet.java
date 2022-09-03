package casestudy.controller;

import casestudy.model.Book;
import casestudy.model.Customer;
import casestudy.service.book.BookService;
import casestudy.service.book.IBookDAO;
import casestudy.service.customer.CustomerDAO;
import casestudy.service.customer.ICustomerDAO;
import casestudy.service.order.IOrderDAO;
import casestudy.service.order.OrderDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@WebServlet(name = "CustomerServlet", urlPatterns = "/customer")
public class CustomerServlet extends HttpServlet {
    IBookDAO bookDAO = new BookService();
    ICustomerDAO customerDAO = new CustomerDAO();
    IOrderDAO orderDAO = new OrderDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "showAllBook":
                showAllBook(req,resp);
                break;
            case "create":
                showListCreate(req, resp);
                break;
            case "showDetail":
                showUpdateDetailForm(req,resp);
                break;
            case "cart":
                showCart(req,resp);
                break;
            default:
                showHomePageCustomer(req, resp);
                break;
        }
    }

    private void showCart(HttpServletRequest req, HttpServletResponse resp)  throws ServletException, IOException{
    }

    private void showAllBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        List<Book> books = bookDAO.selectAll();
        req.setAttribute("listPro",books);
        req.getRequestDispatcher("website/customer/productByCus.jsp").forward(req,resp);
    }

    private void showUpdateDetailForm(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("website/customer/updateDetailCus.jsp");
        HttpSession session = request.getSession();
        Customer temp = (Customer)session.getAttribute("acc");
        Customer temp2 = customerDAO.findByID(temp.getId());
        request.setAttribute("thisCus",temp2);
        dispatcher.forward(request,response);
    }

    private void showListCreate(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("website/customer/create.jsp");
        dispatcher.forward(request, response);
    }

    private void showHomePageCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("website/customer/homepageCustomer.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "editDetail":
                editDetailCus(req,resp);
                break;
            default:
                showHomePageCustomer(req, resp);
                break;
        }
    }

    private void editDetailCus(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Customer temp = customerDAO.findByID(id);
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        String address = request.getParameter("address");
        String gender = temp.getGender();
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String account = request.getParameter("account");
        String password = request.getParameter("password");
        Date now = temp.getStartDate();
        Customer customer = new Customer(id,name,age,gender,address,email,phone,account,password,now);
        customerDAO.update(id,customer);
        request.setAttribute("mess","Success !");
        RequestDispatcher dispatcher = request.getRequestDispatcher("website/customer/updateDetailCus.jsp");
        dispatcher.forward(request, response);
    }
}

