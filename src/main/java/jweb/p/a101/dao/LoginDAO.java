package jweb.p.a101.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import jweb.p.a101.connectdb.ConnectDB;
import jweb.p.a101.model.Member;

public class LoginDAO {
	public static Member authenticationMenber(HttpServletRequest request ) {
		Member member= new Member();
		String sql="select * from Member";
		PreparedStatement ptmt= null;
		try(Connection con = ConnectDB.getConnection()) {
			ptmt= con.prepareStatement(sql);
			ResultSet rs= ptmt.executeQuery();
			member.setUseName((request.getParameter("uname")));
			member.setPassword((request.getParameter("pws")));
			while(rs.next()) {
				String username= rs.getString("Username").trim();
				String password= rs.getString("Password").trim();
				int id= rs.getInt("id");
				if( (member.getUseName().equals(username) && member.getPassword().equals(password))) {
					member= new Member(id,username,password);
				    break;
				}
			}
			rs.close();
			if(ptmt!=null) {
				ptmt.close();
			}
		
		} catch (SQLException e) {
			
			e.getMessage();
		}
		
		return member;
	}
	
}
