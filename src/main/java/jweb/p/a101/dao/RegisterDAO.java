package jweb.p.a101.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.servlet.http.HttpServletRequest;

import jweb.p.a101.model.Member;

public class RegisterDAO {

	public static boolean registerAcc(HttpServletRequest request, Connection con) {
		
		PreparedStatement ptmt = null;
		String sql = "insert into Member(Username,Email,Password) values(?,?,?)";
	
		try {
			ptmt = con.prepareStatement(sql);
			String email= request.getParameter("email");
			String username= request.getParameter("uname");
			String password= request.getParameter("pws");
			
			ptmt.setString(1, username);
			ptmt.setString(2, email);
			ptmt.setString(3, password);

			int kt= ptmt.executeUpdate();
		if(kt!=0) {
			return true;
		}
		ptmt.close();
		} catch (SQLException ex) {

		}
		return false;
	}
	public static String checkUseName(HttpServletRequest request, Connection con, Member member) {
	
		String resuft="";
		PreparedStatement ptmt= null;
		String sql="select* from member";
		try {
			ptmt= con.prepareStatement(sql);
			ResultSet rs= ptmt.executeQuery();
			while(rs.next()) {
				String username=rs.getString("Username").trim();
				if(member.getUseName().equals(username)) {
					resuft="succes";
					break;
				}
			}
			rs.close();
			ptmt.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return resuft;
	}
}
