package casestudy.controller;

import casestudy.model.Book;
import casestudy.service.book.BookService;
import casestudy.service.book.IBookDAO;
import casestudy.service.category.CategoryService;
import casestudy.service.category.ICategoryDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet (name = "BookServlet" , urlPatterns = "/books")
public class BookServlet extends HttpServlet {
    IBookDAO bookDAO = new BookService();
    BookService bookService = new BookService();
    ICategoryDAO categoryDAO = new CategoryService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null){
            action="";
        }
        switch (action) {
            case "create":
                showFormCreate(req, resp);
                break;
            case "editBook":
//                showEditBook(req, resp);
                break;
            case "findByName":
                selectBookByName(req, resp);
                break;
            case "findById":
                selectBookById(req, resp);
                break;
            case "showFindIdForm":
                showFindFormById(req,resp);
                break;
            case "showFindForm":
                showFindForm(req, resp);
                break;
            case "delete":
                deleteBook(req, resp);
                break;
            default:
                showAllBook(req, resp);
                break;
        }
    }
    private void showFormCreate(HttpServletRequest req, HttpServletResponse resp){
        RequestDispatcher dispatcher = req.getRequestDispatcher("book/create.jsp");
        req.setAttribute("categories", categoryDAO.selectAll());
        try {
            dispatcher.forward(req, resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void showAllBook(HttpServletRequest req, HttpServletResponse resp) {
        RequestDispatcher dispatcher = req.getRequestDispatcher("book/listBook.jsp");
        List<Book> books = bookDAO.selectAll();
        req.setAttribute("books", books);
        try {
            dispatcher.forward(req, resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void showDeleteForm(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("id"));
        List<Book> books = bookDAO.selectById(id);
        RequestDispatcher dispatcher;
        if (books == null) {
            dispatcher = req.getRequestDispatcher("Erro-404.jsp");
        }else {
            req.setAttribute("books", books);
            dispatcher = req.getRequestDispatcher("book/delete.jsp");
            try {
                dispatcher.forward(req, resp);
            } catch (ServletException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
    private void showFindForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("book/findForm.jsp");
        requestDispatcher.forward(req,resp);
    }
    private void showFindFormById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("book/findIdForm.jsp");
        requestDispatcher.forward(req,resp);
    }
    private void selectBookByName(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("book/viewBook.jsp");
        String name = req.getParameter("name");
        List<Book> books = bookDAO.selectByName(name);
        req.setAttribute("books", books);
        try {
            dispatcher.forward(req, resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void selectBookById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("book/viewBookById.jsp");
        int id = Integer.parseInt(req.getParameter("id"));
        List<Book> books = bookDAO.selectById(id);
        req.setAttribute("books", books);
        try {
            dispatcher.forward(req, resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null){
            action ="";
        }
        switch (action) {
            case "create":
                createNewBook(req, resp);
                break;
            case "edit":
//                updateBook(req, resp);
                break;
            case "findByName":
                break;
            case "delete":
                deleteBook(req, resp);
                break;
            default:
                showAllBook(req,resp);
                break;
        }
    }

    private void createNewBook(HttpServletRequest req, HttpServletResponse resp) {

        int id = Integer.parseInt(req.getParameter("id"));
        String code = req.getParameter("code");
        String name = req.getParameter("name");
        String author = req.getParameter("author");
        double price = Double.parseDouble(req.getParameter("price"));
        String image = req.getParameter("image");
        String description = req.getParameter("description");
        String[] categoriesStr = req.getParameterValues("categories");
        int[] categories = new int[categoriesStr.length];
        for (int i = 0; i < categoriesStr.length; i++) {
            categories[i] = Integer.parseInt(categoriesStr[i]);
        }

        Book book = new Book(id, code, name, author, price, image, description);
        bookDAO.saves(book, categories);
    }
    private void deleteBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        int id = Integer.parseInt(req.getParameter("id"));
//        List<Book> books = bookDAO.selectById(id);
//        RequestDispatcher dispatcher;
//        if (books == null) {
//            dispatcher = req.getRequestDispatcher("Erro-404.js@");
//        }else {
//            this.bookService.delete(id);
//            try {
//                resp.sendRedirect("/books");
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//        }
//    }
    int id = Integer.parseInt(req.getParameter("id"));
        bookService.delete(id);
    List<Book> books = bookService.selectAll();
        req.setAttribute("books", books);
    RequestDispatcher dispatcher = req.getRequestDispatcher("book/listBook.jsp");
        dispatcher.forward(req, resp);

}
}
