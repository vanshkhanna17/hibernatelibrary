package controller;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Books;
import Model.Reviews;
import dao.BookDao;


/**
 * Servlet implementation class AddBook
 */
@WebServlet("/add.do")
public class AddBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddBook() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookDao sDao = new BookDao();
		List<Books> books = sDao.findAll();
		request.setAttribute("books", books);
		request.getRequestDispatcher("view.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String title = request.getParameter("title").trim();
		String author = request.getParameter("author").trim();
		String price = request.getParameter("price").trim();
		Set<Reviews> review = new HashSet<Reviews>();
		Books s = new Books(title, author, price, review);
		
		BookDao sDao = new BookDao();
		try {
			sDao.create(s);
			request.setAttribute("created", true);
			List<Books> books = sDao.findAll();
			request.setAttribute("books", books);
		}catch(Exception ex) {
			request.setAttribute("created", false);
			ex.printStackTrace();
		}finally {
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}
}
