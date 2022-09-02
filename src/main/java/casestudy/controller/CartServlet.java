package casestudy.controller;

import casestudy.model.Order;
import casestudy.service.order.IOrderDAO;
import casestudy.service.order.OrderDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CartServlet", value = "/customer/cart")
public class CartServlet extends HttpServlet {
    IOrderDAO orderDAO = new OrderDAO();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            case "create":
                break;
            default:
                showCart(request,response);
                break;
        }
    }

    private void showCart(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        List<Order> orderList = orderDAO.selectAll();
        RequestDispatcher dispatcher = request.getRequestDispatcher("html/cart.jsp");
        request.setAttribute("dsgh",orderList);
        dispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
