package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.userDao;
import entity.User;

/**
 * Servlet implementation class signin_servlet
 */
@WebServlet("/signin_servlet")
public class signin_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public signin_servlet() {
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
		
		//解决获取到中文乱码
		request.setCharacterEncoding("utf-8"); 
		User user = new User();
		userDao userDao = new userDao();
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String phone=request.getParameter("phone");
		String email=request.getParameter("email");
		String sex=request.getParameter("sex");
		
		user.setUsername(username);
		user.setPassword(password);
		user.setPhone(phone);
		user.setEmail(email);
		user.setSex(sex);
		//插入数据库操作
		userDao.addUser(user);
		response.sendRedirect(request.getContextPath()+"/login.jsp");	//重定向
		
//		response.setContentType("text/html;charset=UTF-8");
//        PrintWriter out = response.getWriter();
//        
//        /**
//         *该方法返回一个枚举，其中包含未指定顺序的参数名。
//		一旦我们有一个枚举，我们可以以标准方式循环枚举，
//		使用 hasMoreElements() 方法来确定何时停止，
//		使用 nextElement() 方法来获取每个参数的名称。
//         */
//        Enumeration paramNames = request.getParameterNames();
//        while(paramNames.hasMoreElements()) {
//            String paramName = (String)paramNames.nextElement();
//            out.print("<tr><td>" + paramName + "</td>\n");
//            String[] paramValues =request.getParameterValues(paramName);
//            // 读取单个值的数据
//            if (paramValues.length == 1) {
//                String paramValue = paramValues[0];
//                if (paramValue.length() == 0)
//                    out.println("<td><i>没有值</i></td>");
//                else
//                    out.println("<td>" + paramValue + "</td>");
//            } else {
//                // 读取多个值的数据
//                out.println("<td><ul>");
//                for(int i=0; i < paramValues.length; i++) {
//                out.println("<li>" + paramValues[i]);
//            }
//                out.println("</ul></td>");
//            }
//            out.print("</tr>");
//        }
//        out.println("\n</table>\n</body></html>");
		
	}

}




