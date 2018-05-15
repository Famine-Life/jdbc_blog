package entity;

import java.sql.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 文章实体类
 * @author asus
 *
 */
public class Post {
	
	private int id;
	private String title;
	private String content;
	private Date create_time;
	private String article_type_id;
	private String person_class_id;
	private String blog_class_id ;
	
	 public static String StrToHtml(String str) {
		    if (str == null) {
		        return "";
		    }else if (str.length() == 0) {
		        return "";
		    }
		    str = str.replaceAll("\n", "<br />");
		    str = str.replaceAll("\r", "<br />");
		    return str;
		}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {	
		String result = this.content.replaceAll("\"", "&quot;");
		/*String[] s=new String[result.length()];
		for(int i=0;i<s.length;i++)
		{
			s[i]=result.substring(i,i+1);
			s[i]="|"+s[i];
			System.out.println(s[i]);
		}*/
		return result;
	}
	public void setContent(String content) {
		this.content = StrToHtml(content);
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	public String getArticle_type_id() {
		return article_type_id;
	}
	public void setArticle_type_id(String article_type_id) {
		this.article_type_id = article_type_id;
	}
	public String getPerson_class_id() {
		return person_class_id;
	}
	public void setPerson_class_id(String person_class_id) {
		this.person_class_id = person_class_id;
	}
	public String getBlog_class_id() {
		return blog_class_id;
	}
	public void setBlog_class_id(String blog_class_id) {
		this.blog_class_id = blog_class_id;
	}
	
}
