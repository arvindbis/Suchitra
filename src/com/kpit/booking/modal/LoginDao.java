package com.kpit.booking.modal;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.kpit.booking.form.UserForm;
import com.kpit.booking.form.UserRegistrationForm;



public class LoginDao {
	public boolean isUserPresent(Connection connection,UserForm user){
		boolean flag = false;
		try {
			System.out.println(user.getEmail()+"  "+user.getPassword());
			System.out.println(connection);
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT USERNAME,PASSWORD FROM LOGIN WHERE USERNAME=? AND PASSWORD=?");
			preparedStatement.setString(1, user.getEmail());
			preparedStatement.setString(2, user.getPassword());
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				flag = true;
			}

		} catch (SQLException exception) {
			
			exception.printStackTrace();
		}
		if (flag)
			return true;
		else
			return false;
	}
	
	public boolean addNewUser(Connection connection,UserRegistrationForm user){
		
			int value = 0;
			

				
				PreparedStatement preparedStatement;
				try {
					preparedStatement = connection.prepareStatement("insert into login (username,password) values(?,?)");
					preparedStatement.setString(1,user.getEmailAddress() );
					preparedStatement.setString(2,user.getPwd());
					
					value = preparedStatement.executeUpdate();
					System.out.println("done");

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				
				
			if (value == 1)
				return true;
			else
				return false;

		}
	

}
