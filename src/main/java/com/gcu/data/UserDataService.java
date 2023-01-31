package com.gcu.data;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.gcu.model.UserModel;

/**
 * Accesses users from the database.
 *
 */
@Service
public class UserDataService implements DataAccessInterface<UserModel>
{

	@Autowired
	@SuppressWarnings("unused")
	private DataSource dataSource;
	
	private JdbcTemplate jdbcTemplateObject;

	/**
	 * Constructor for this class. Creates a a new instance of this class.
	 * @param dataSource Source of user data.
	 */
	public UserDataService(DataSource dataSource)
	{
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<UserModel> findAll()
	{
		String sql = "SELECT * FROM user";
		List<UserModel> users = new ArrayList<UserModel>();
		try 
		{
			//Executes the SQL query. Now we will loop through the results of that query.
			SqlRowSet srs = jdbcTemplateObject.queryForRowSet(sql);
			while(srs.next()) 
			{
				users.add(new UserModel(srs.getString("username"), 
											srs.getString("password"),
											srs.getString("email"),
											srs.getString("phoneNum"),
											srs.getInt("userId")));
			}
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		return users;
	}

	@Override
	public UserModel findById(int id)
	{
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public UserModel findByUsername(String username) 
	{
		String sql = String.format("SELECT * FROM user WHERE username='%s'", username);
		// Initializes product as empty model
		UserModel user = null;
		try 
		{
			// Executes SQL query
			SqlRowSet srs = jdbcTemplateObject.queryForRowSet(sql);
			// Creates new product using results of query
			while(srs.next()) 
			{
				user = new UserModel(srs.getString("username"), srs.getString("password"), srs.getString("email"), srs.getString("phoneNum"), srs.getInt("userId"));
			}
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
				
		return user;
	}

	@Override
	public boolean create(UserModel user)
	{
		String sql = "INSERT INTO user (username, password, email, "
				+ "phoneNum) VALUES (?, ?, ?, ?)";
		try
		{
		    // Execute SQL Insert - password is encrypted
		    int rows = jdbcTemplateObject.update(sql,
		                                         	user.getUsername(),
		                                         	new BCryptPasswordEncoder().encode(user.getPassword()),
		                                         	user.getEmail(),
		                                         	user.getPhoneNum());

		    // Return result of Insert
		    return rows == 1 ? true : false;
		}
		catch (Exception e)
		{
		    e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean update(UserModel t)
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(UserModel t)
	{
		// TODO Auto-generated method stub
		return false;
	}

}
