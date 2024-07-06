package krushi_mart;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;

public class UserCurd {
	public Connection getConnection() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/krushi_mart", "root", "root");

	}

//	public int register(User user) throws Exception {
//		Connection connection = getConnection();
//		PreparedStatement preparedStatement = connection.prepareStatement("insert into user values(?,?,?,?,?,?,?)");
//		preparedStatement.setInt(1, user.getId());
//		preparedStatement.setString(2, user.getFirstName());
//		preparedStatement.setString(3, user.getLastName());
//		preparedStatement.setString(4, user.getEmail());
//		preparedStatement.setString(5, user.getPassword());
//		preparedStatement.setLong(6, user.getPhone());
//		preparedStatement.setString(7, user.getRole());
//
//		int count = preparedStatement.executeUpdate();
//
//		connection.close();
//		return count;
//
//	}
//
	public User logIn(String email) throws Exception{
		Connection connction = getConnection();
		System.out.println(email);
		
		PreparedStatement preparedStatement=connction.prepareStatement("select * from user where email=?");
		preparedStatement.setString(1, email);
		
		ResultSet result=preparedStatement.executeQuery();
		
		User user=null;
		
		while(result.next() )
		{
			user=new User();
			
			user.setId(result.getInt("user_id"));
			user.setFirstName(result.getString("first_name"));
			user.setLastName(result.getString("last_name"));
			user.setEmail(result.getString("email"));
			user.setPassword(result.getString("password"));
			user.setPhone(result.getLong("phone"));
			user.setRole(result.getString("role"));
			user.setAddress(result.getString("address"));
		}

	
		connction.close();
		return user;
	}
	
	
	//metod to insert the date into the table baser on the role
	public int register(User user)throws Exception
	{
		
	
		String query="insert into user values(?,?,?,?,?,?,?,?)";
		
		Connection connection=getConnection();
		
		PreparedStatement preparedStatement=connection.prepareStatement(query);
		preparedStatement.setInt(1,newUserId());
		preparedStatement.setString(2, user.getFirstName());
		preparedStatement.setString(3, user.getLastName());
		preparedStatement.setString(4,user.getEmail());
		preparedStatement.setString(5, user.getPassword());
		preparedStatement.setLong(6, user.getPhone());

		preparedStatement.setString(7, user.getRole());
		preparedStatement.setString(8,user.getAddress());
		
		int count=preparedStatement.executeUpdate();
		
		connection.close();
		
		return count;
		
	}

  //this method will give unique id every time	
	public int newUserId()throws Exception
	{
		Connection connection=getConnection();
		
		PreparedStatement preparedStatement=connection.prepareStatement("select count(*) as count from user ");
		ResultSet result =preparedStatement.executeQuery();
		int id=0;
		while(result.next())
		{
			id= result.getInt("count");
		}
		return ++id;
	}
	
	public User getUserById(int id) throws Exception
	{
		Connection connction = getConnection();
		System.out.println(id);
		
		PreparedStatement preparedStatement=connction.prepareStatement("select * from user where user_id=?");
		preparedStatement.setInt(1, id);
		
		ResultSet result=preparedStatement.executeQuery();
		
		User user=null;
		
		while(result.next() )
		{
			user=new User();
			
			user.setId(result.getInt("user_id"));
			user.setFirstName(result.getString("first_name"));
			user.setLastName(result.getString("last_name"));
			user.setEmail(result.getString("email"));
			user.setPassword(result.getString("password"));
			user.setPhone(result.getLong("phone"));
			user.setRole(result.getString("role"));
			user.setAddress(result.getString("address"));
		}

	
		connction.close();
		return user;
	}
	
	public int changePassword(String cPassword, int id) throws Exception
	{
		Connection connction = getConnection();
		
		PreparedStatement preparedStatement=connction.prepareStatement("update  user set password=? where user_id=?");
		preparedStatement.setString(1, cPassword);
		preparedStatement.setInt(2, id);
		
		int result =preparedStatement.executeUpdate();
		connction.close();
		return result ;
		
	}
	
//*********************************************************************************************************************************
	
	//method to add new post 
	public int addNewPost(Post post)throws Exception
	{
		
	
		String query="insert into post values(?,?,?,?,?) ";
		
		Connection connection=getConnection();
		
		PreparedStatement preparedStatement=connection.prepareStatement(query);
		preparedStatement.setInt(1,countPost()+post.hashCode());
		preparedStatement.setDouble(2,post.getPrice());
		preparedStatement.setInt(3,post.getQuentity());
		preparedStatement.setString(4, post.getProduct_name());
		preparedStatement.setInt(5,post.getFarmer_id());
				
		
		int count=preparedStatement.executeUpdate();
		
		connection.close();
		
		return count;
		
	}
	
	
	//this method to get all the post made by the farmer 
	
	public List<Post> getAllPost()throws Exception
	{
		Connection connction = getConnection();
		PreparedStatement preparedStatement=connction.prepareStatement("select * from post");
		
		ResultSet result=preparedStatement.executeQuery();
		
		List<Post> postList=new ArrayList();
		
		while(result.next())
		{
			Post post=new Post();
			
			post.setId(result.getInt("id"));
			post.setFarmer_id(result.getInt("farmer_id"));
			post.setPrice(result.getDouble("price"));
			post.setQuentity(result.getInt("quentity"));
			post.setProduct_name(result.getString("product_name"));
			
			postList.add(post);
			
		}
		connction.close();
		return postList;
	}
	
	
	
	//this will return the count of the post   
	public int countPost() throws Exception
	{
		Connection connection=getConnection();
		
		PreparedStatement preparedStatement=connection.prepareStatement("select count(*) as count from post");
		
		ResultSet result=preparedStatement.executeQuery();
		
		int id=0;
		
		while(result.next())
		{
			id=result.getInt("count")+1;
		}
		
		
		return id;
		
	}
	
	public List<Post> getPostById(int farmer_id) throws Exception
	{
		Connection connction = getConnection();
		PreparedStatement preparedStatement=connction.prepareStatement("select * from post where farmer_id=?");
		preparedStatement.setInt(1,farmer_id);
		ResultSet result=preparedStatement.executeQuery();
		
		List<Post> postList=new ArrayList();
		
		while(result.next())
		{
			Post post=new Post();
			
			post.setId(result.getInt("id"));
			post.setFarmer_id(result.getInt("farmer_id"));
			post.setPrice(result.getDouble("price"));
			post.setQuentity(result.getInt("quentity"));
			post.setProduct_name(result.getString("product_name"));
			
			postList.add(post);
			
		}
		connction.close();
		return postList; 
		
	}
	
	public int deletePostById(int id) throws Exception
	{
		Connection connction = getConnection();
		PreparedStatement preparedStatement=connction.prepareStatement("delete from post where id=?");
		preparedStatement.setInt(1, id);
		
		int count=preparedStatement.executeUpdate();
		
		connction.close();
		return id;

	}
	
	
//	public static void main(String[] args) {
//		UserCurd curd=new UserCurd();
//		try {
//			System.out.println(curd.changePassword("12345",1));
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} 
//	}
		
	

	
	  
}
