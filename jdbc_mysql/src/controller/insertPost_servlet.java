package controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.postDao;
import entity.Post;

/**
 * Servlet implementation class insertPost_servlet
 */
@WebServlet("/insertPost_servlet")
public class insertPost_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public insertPost_servlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;utf-8");
		String flag = request.getParameter("flag");
		String title=request.getParameter("title");	//文章标题
		String content=request.getParameter("content");	//获取文章内容
		String article_type=request.getParameter("article_type");
		String person_class=request.getParameter("person_class");
		String blog_class=request.getParameter("blog_class");
		java.sql.Date nowdate = new java.sql.Date(new Date().getTime());
		
		Post post=new Post();
		postDao postDao = new postDao();
			post.setTitle(title);
			post.setContent(content);
			post.setCreate_time(nowdate);
			post.setArticle_type_id(article_type);
			post.setPerson_class_id(person_class);
			post.setBlog_class_id(blog_class);
			postDao.add(post);		//调用dao里的方法,写入数据库
			response.sendRedirect(request.getContextPath()+"/post_brief.jsp");
	}

}
