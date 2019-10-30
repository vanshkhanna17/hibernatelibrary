package controller;

import java.io.IOException;
import java.util.HashSet;
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
 * Servlet implementation class Review
 */
@WebServlet("/review")
public class Review extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Review() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		BookDao bd = new BookDao();
		Books b = bd.find(Integer.parseInt(id));
		request.setAttribute("b", b);
		request.getRequestDispatcher("addrev.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id=request.getParameter("id");
		String uname= request.getParameter("name");
		String rev= request.getParameter("txt");
		Reviews r= new Reviews(uname,rev);
		BookDao bd = new BookDao();
		Books b = bd.find(Integer.parseInt(id));
		Set<Reviews> s1= b.getReview();
		Set<Reviews> s2= new HashSet<Reviews>();
		if(s1.size()==0) {
			s2.add(r);
		}
		else {
			for(Reviews re: s1) {
				s2.add(re);
			}
			s2.add(r);
		}
		b.setReview(s2);
		try{
			bd.update(b);
			request.setAttribute("rev", true);
		}catch(Exception e) {
		request.setAttribute("rev", false);
		}finally {
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}

}
