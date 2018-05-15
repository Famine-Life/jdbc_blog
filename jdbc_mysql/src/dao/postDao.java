package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import entity.Post;
import entity.User;
import util.DBhelper;

public class postDao {
	//添加文章
	public void add(Post post){
		String sql = " insert post values(null,?,?,?,?,?,?); ";
		try {
			Connection conn = DBhelper.getConnection();
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, post.getTitle());
			ps.setString(2, post.getContent());
			ps.setDate(3, post.getCreate_time());	//数据库和java的Date类型需要转换
			ps.setString(4, post.getArticle_type_id());
			ps.setString(5, post.getPerson_class_id());
			ps.setString(6, post.getBlog_class_id());
			ps.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
		//查询文章		//多表查询
		public List<Post> list(){
		List<Post> posts = new ArrayList<Post>();
		String sql = " select p.id,title,content,create_time, "
						+" a.type_name as 文章类型, "
						+" ps.type_name as 个人分类, "
						+" b.type_name as 博客类型  "
						+" from post as p "
						+" inner join article_type as a on p.article_type_id=a.id "
						+" inner join person_class as ps on p.person_class_id=ps.id "
						+" inner join blog_class as b on p.blog_class_id=b.id; ";
		try {
			Connection conn = DBhelper.getConnection();	//获得连接对象
			PreparedStatement ps = conn.prepareStatement(sql);
	         ResultSet rs = ps.executeQuery(sql);
	         while(rs.next()){
	        	 Post post = new Post();
	        	 int id = rs.getInt(1);
	        	 String title = rs.getString(2);
	        	 String content = rs.getString(3);
	        	 Date create_time = rs.getDate(4);
	        	 String article_type = rs.getString(5);
	        	 String person_class_type = rs.getString(6);
	        	 String blog_class_type = rs.getString(7);
	        	 post.setId(id);
	        	 post.setTitle(title);
	        	 post.setContent(content);
	        	 post.setCreate_time(create_time);
	        	 post.setArticle_type_id(article_type);
	        	 post.setPerson_class_id(person_class_type);
	        	 post.setBlog_class_id(blog_class_type);
	        	 posts.add(post);
	         }
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return posts;
	}
	
		//通过id查询文章
		public Post list(String id)
		{
			Post post = new Post();
			String sql = "select * from post where id="+id;
			try {
				Connection conn=DBhelper.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				while(rs.next()){
					post.setId(rs.getInt(1));
					post.setTitle(rs.getString(2));
					post.setContent(rs.getString(3));
					post.setCreate_time(rs.getDate(4));
					post.setArticle_type_id(rs.getString(5));
					post.setPerson_class_id(rs.getString(6));
					post.setBlog_class_id(rs.getString(7));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return post;
		}
	
}
