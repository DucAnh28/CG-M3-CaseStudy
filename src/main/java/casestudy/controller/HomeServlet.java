package casestudy.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "HomeServlet", value = "/home")
public class HomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action = "" ;
        }
        switch (action){
            case "contact":
                showContactPage(request,response);
                break;
            default:
                showHomePage(request,response);
        }
    }
    private void showContactPage(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        RequestDispatcher dispatcher = request.getRequestDispatcher("website/contact.jsp");
        dispatcher.forward(request,response);
    }

    private void showHomePage(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
        RequestDispatcher dispatcher = request.getRequestDispatcher("homepage.jsp");
        dispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
