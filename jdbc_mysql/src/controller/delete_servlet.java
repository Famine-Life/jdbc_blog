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
			if(!u.deleteUser(id))//ɾ��������execute����ֵΪfalse
			{
				//�ض���
				//response.sendRedirect(request.getContextPath()+"/index.jsp");
				//�������ڲ���ת
				//request.getRequestDispatcher("index.jsp").forward(request,response);
				//�����ض���ᵼ��js�ű��������ã�������js����תҳ��
				out.println("<script language='javascript'>window.location='index.jsp';alert('ɾ���ɹ�');</script>");
			}
			else
			{
				out.println("<script>alert('ɾ��ʧ��!');</script>");
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
