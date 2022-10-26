package jweb.p.a101.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import jweb.p.a101.connectdb.ConnectDB;
import jweb.p.a101.model.Content;

public class ContentDAO {

	public static List<Content> getAllContent(HttpServletRequest request){
		List<Content> contentLit= new ArrayList<>();
		try(Connection con= ConnectDB.getConnection()){
			PreparedStatement statement= null;
			String sql= "select * from Content";
			//"select id, Title, Brief,Content, CreateTime from Content";
			statement= con.prepareStatement(sql);
			ResultSet resultSet= statement.executeQuery();
			while(resultSet.next()) {
			Date date= resultSet.getDate("CreateTime");
			System.out.println(date);
			LocalDate date1= date.toLocalDate();
			System.out.println(date1);
				contentLit.add(new Content(resultSet.getInt("id"), resultSet.getString("Title"),resultSet.getString("Brief"),resultSet.getString("Content"),date1));
			}
			statement.close();
			resultSet.close();
		}catch(SQLException e){
			
		}
		return contentLit;
	}
	
	public static Content getDataContentById(int id) {
		Content content= null;
		try(Connection con = ConnectDB.getConnection()){
			PreparedStatement statement= null;
			String sql= "select * from Content where id=?";
			
			statement= con.prepareStatement(sql);
			statement.setInt(1, id);
			ResultSet resultSet= statement.executeQuery();
			while(resultSet.next()) {
			Date date= resultSet.getDate("CreateTime");
			System.out.println(date);
			LocalDate date1= date.toLocalDate();
			System.out.println(date1);
				content=new  Content(resultSet.getInt("id"), resultSet.getString("Title"),resultSet.getString("Brief"),resultSet.getString("Content"),date1);
			}
			statement.close();
			resultSet.close();
		}catch(SQLException e) {
			e.getMessage();
		}
		return content;
	}
	public static  void updateContent(HttpServletRequest request) {
		try(Connection con= ConnectDB.getConnection()){
			//"select id, Title, Brief,Content, CreateTime from Content";
			String sql= "update Content set Title= ?, Brief=?,  Content=?, UpdateTime=?, AuthorId=? where id=? ";
			PreparedStatement statement= null;
			statement= con.prepareStatement(sql);
			statement.setString(1,request.getParameter("title"));
			statement.setString(2,request.getParameter("brief"));
			statement.setString(3,request.getParameter("content"));
			LocalDate date= LocalDate.now();
			statement.setDate(4,Date.valueOf(date));
			HttpSession sesion = request.getSession();
			System.out.println(sesion.getAttribute("sessionID"));
			int authorid = (Integer) sesion.getAttribute("sessionID");
			statement.setInt(5, authorid);
			statement.setInt(6,Integer.parseInt(request.getParameter("id")));
			statement.executeUpdate();
			statement.close();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void deleteContent(int id) {
		try(Connection con= ConnectDB.getConnection()){
			//"select id, Title, Brief,Content, CreateTime from Content";
			String sql= "delete from Content where id=? ";
			PreparedStatement statement= null;
			statement= con.prepareStatement(sql);
			statement.setInt(1,id);
			statement.executeUpdate();
			statement.close();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static boolean insertContent(HttpServletRequest request) {
		 boolean check=false;
		try(Connection con= ConnectDB.getConnection()){
			
			String sql= "insert into Content(Title,Brief,Content, CreateTime,AuthorId) values(?,?,?,?,?) ";
			HttpSession sesion = request.getSession();
			System.out.println(sesion.getAttribute("sessionID"));
			int id = (Integer) sesion.getAttribute("sessionID");
			PreparedStatement statement= null;
			statement= con.prepareStatement(sql);
			statement.setString(1,request.getParameter("title"));
			statement.setString(2,request.getParameter("brief"));
			statement.setString(3,request.getParameter("content"));
			LocalDate date= LocalDate.now();
			statement.setDate(4,Date.valueOf(date));
			statement.setInt(5, id);
			int kt=statement.executeUpdate();
			if(kt!=0) {
				check= true;
			}
			statement.close();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return check;
	}
	
	public static List<Content> searchContent(HttpServletRequest request){
		List<Content> contents= new ArrayList<>();
try(Connection con= ConnectDB.getConnection()){
			
			String sql= "select * from Content where Title like ? ";
			PreparedStatement statement= null;
			statement= con.prepareStatement(sql);
			statement.setString(1,"%"+request.getParameter("seachcontent")+"%");
			ResultSet resultSet= statement.executeQuery();
			while(resultSet.next()) {
				Date date= resultSet.getDate("CreateTime");
				System.out.println(date);
				LocalDate date1= date.toLocalDate();
				System.out.println(date1);
					contents.add(new Content(resultSet.getInt("id"), resultSet.getString("Title"),resultSet.getString("Brief"),resultSet.getString("Content"),date1));
				}
				statement.close();
				resultSet.close();
			
			statement.close();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return contents;
	}
}
