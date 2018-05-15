package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.userDao;

/**
 * Servlet implementation class delete_servlet
 */
@WebServlet("/delete_servlet")
public class delete_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public delete_servlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String flag = request.getParameter("flag");
		String id = request.getParameter("id");
		userDao u = new userDao();
		if(flag.equals("delete"))	
		{
			if(!u.deleteUser(id))//删除操作的execute返回值为false
			{
				//重定向
				//response.sendRedirect(request.getContextPath()+"/index.jsp");
				//服务器内部跳转
				//request.getRequestDispatcher("index.jsp").forward(request,response);
				//由于重定向会导致js脚本不起作用，所以用js来跳转页面
				out.println("<script language='javascript'>window.location='index.jsp';alert('删除成功');</script>");
			}
			else
			{
				out.println("<script>alert('删除失败!');</script>");
			}
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
