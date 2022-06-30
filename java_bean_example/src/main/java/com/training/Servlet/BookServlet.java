package com.training.Servlet;

import java.util.*;
import java.awt.im.InputMethodRequests;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.View;

import com.javatraining.model.Book;
import com.javatraining.model.BookService;
import com.training.utils.ConnectionFactory;

/**
 * Servlet implementation class BookServlet
 * 
 * @param <Book>
 */
@WebServlet("/")
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Connection con = null;
	private BookService service = null;



	private Object Books;

	private Object addedBook;


	/**
	 * @see HttpServlet#HttpServlet()
	 */

	@Override
	public void destroy() {

		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void init() throws ServletException {

		con = ConnectionFactory.getpostgresConnection();

		service = new BookService(con);

		System.out.println("Connection:=" + con);

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		String action = request.getServletPath();
		 
		switch (action) {
		case "/find":
			showAll(request,response);
			break;
		case "/edit":
			 View(request,response);
			 break;
		case "/Delete":
			Delete(request,response);
			 break;
			 
		default:
			break;
		}
		
		
	}

		private void Delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String strId =request.getParameter("id");
			 
			 int id = Integer.parseInt(strId);
			 
			Book book= service.remove(id);
			
			List<Book> books = service.findAll();
			
			request.setAttribute("books", Books);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/showBook.jsp");
			dispatcher.forward(request, response);
			
			
	}

	

		private void View(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			List<Book> books = service.findAll();			
			
			request.setAttribute("books", Books);
			

			RequestDispatcher dispatcher = request.getRequestDispatcher("/showBook.jsp");
			dispatcher.forward(request, response);

	}

		private void showAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			List<Book> books = service.findAll();
			
			
			request.setAttribute("books", Books);
			

			RequestDispatcher dispatcher = request.getRequestDispatcher("/showBook.jsp");
			dispatcher.forward(request, response);

		}
		
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String Key=request.getServletPath();
		switch (Key) {
		case "/books":
			handleAdd(request,response);
			break;
		case "/update":
			handleUpdate(request,response);
			break;

		default:
			break;
		}
		
	}
			private void handleAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				request.setAttribute("added", addedBook);
				request.setAttribute("message", "One Book Added");

				RequestDispatcher dispatcher = request.getRequestDispatcher("/addBook.jsp");
				dispatcher.forward(request, response);
			}

			private void handleUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				String strBookNumber = request.getParameter("bookNumber");
				int bookNumber = Integer.parseInt(strBookNumber);

				String bookName = request.getParameter("bookName");
				String authorName = request.getParameter("authourName");
				String strPrice = request.getParameter("price");
				double price = Double.parseDouble(strPrice);

				Book entity = new Book(bookNumber, bookName, authorName, price);

				Book addedBook = service.add(entity);

				request.setAttribute("books", Books);
				List<Book> books = service.findAll();

				RequestDispatcher dispatcher = request.getRequestDispatcher("/showBook.jsp");
				dispatcher.forward(request, response);
				
			}

}

