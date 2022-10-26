package jweb.p.a101.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import jweb.p.a101.connectdb.ConnectDB;
import jweb.p.a101.model.Member;

public class UserDao {
	public static boolean updateProfile(HttpServletRequest request) {
		boolean check = false;
		try (Connection con = ConnectDB.getConnection()) {

			String sql = "update Member set Firstname=?, Lastname=?, Phone=?, Email=?, Description=?,UpdateTime=? where id =?";
			PreparedStatement statement = null;
			statement = con.prepareStatement(sql);
			statement.setString(1, request.getParameter("firstname"));
			statement.setString(2, request.getParameter("lastname"));
			statement.setString(3, request.getParameter("phone"));
			statement.setString(4, request.getParameter("email"));
			statement.setString(5, request.getParameter("description"));
			LocalDate date = LocalDate.now();
			Date dateUpdate = Date.valueOf(date);
			System.out.println(dateUpdate);
			statement.setDate(6, dateUpdate);
			HttpSession sesion = request.getSession();
			System.out.println(sesion.getAttribute("sessionID"));
			int id = (Integer) sesion.getAttribute("sessionID");
			System.out.println(id);
			statement.setInt(7, id);
			int kt = statement.executeUpdate();
			if (kt != 0) {
				check = true;
			}
			statement.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return check;
	}

	public static Member getInfoMember(HttpServletRequest request) {
		Member member = null;
		try (Connection con = ConnectDB.getConnection()) {

			String sql = "select * from Member where id =?";
			PreparedStatement statement = null;
			statement = con.prepareStatement(sql);
			HttpSession sesion = request.getSession();
			System.out.println(sesion.getAttribute("sessionID"));
			int id = (Integer) sesion.getAttribute("sessionID");
			// System.out.println(id);
			statement.setInt(1, id);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				String fname = rs.getString("Firstname");
				String name = rs.getString("Lastname");
				String phone = rs.getString("Phone");
				String email = rs.getString("Email");
				String des= rs.getString("Description");
				member=new Member(fname, name, phone, email, des);
				
			}
			statement.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return member;
	}

}
