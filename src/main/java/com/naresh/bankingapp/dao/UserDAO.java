package com.naresh.bankingapp.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.naresh.bankingapp.model.User;

@Repository
public class UserDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate ;//= new ConnectionUtil().jdbcTemplate();
	
	
	public void save(User user) {
		System.out.println("UserDAO->save" + user);
		
		String sql = "insert into users ( name,email,password) values ( ?, ? ,?)";
		Object[] params = { user.getName(), user.getEmail(), user.getPassword() };
		int rows = jdbcTemplate.update(sql,params);
		
		System.out.println("Rows inserted:" + rows);
		
	}
	
	public List<User> list(){
		String sql = "select id,name,email from users";
		Object[] params = {};
		List<User> userList = jdbcTemplate.query(sql,params, (rs,rownum)->{
			User user = new User();
			user.setId(rs.getInt("id"));
			user.setName(rs.getString("name"));
			user.setEmail(rs.getString("email"));
			return user;
		});
		return userList;
	}
	
	public User login(String email,String password){
		String sql = "select id,name,email from users where email = ? and password = ?";
		Object[] params = {email, password};
		User userList = jdbcTemplate.queryForObject(sql,params, (rs,rownum)->{
			User user = new User();
			user.setId(rs.getInt("id"));
			user.setName(rs.getString("name"));
			user.setEmail(rs.getString("email"));
			return user;
		});
		return userList;
	}
	
	public Integer getUserId(String email){
		String sql = "select id from users where email = ?";
		Object[] params = {email};
		Integer userId= jdbcTemplate.queryForObject(sql,params, Integer.class);
		return userId;
	}
}
