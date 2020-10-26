package database;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Types;
import java.util.Scanner;


public class Data {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub


	//	insert();
	//	select();
	//	delete();
	//	update();
	//	executeProcedure();
	//	executeProcWithparam();
		proc2();

	}

	public static void insert() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("1");
			Scanner sc = new Scanner(System.in);
			int id =sc.nextInt();
			sc.nextLine();
			String name= sc.next();
			int age = sc.nextInt();
			
			Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/avizva?useSSL=false&autoreconnect=true","root","Aadi@123");
			System.out.println("2");
			PreparedStatement ps=con.prepareStatement("insert into t1 values (?,?,?),(36,'kk',44), ("+ id +",'" + name+ "',"+ age+ ")");
			ps.setInt(1, 35);
			ps.setString(2, "Aadi");
			ps.setInt(3, 34);
		//	PreparedStatement ps2=con.prepareStatement("insert into t1 values (3,'popl',44)");
		//	ps.executeUpdate();
			
			
			int count= ps.executeUpdate();
			if(count>0) 
				System.out.println(count+ " inserted");
				else
					System.out.println("Not inserted");
			
			ps.close();
			con.close();
			sc.close();
			
		}
		catch(Exception e) {
			
		}
		
		
	}
	

	public static void select() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("1");
			Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/avizva?useSSL=false&autoreconnect=true","root","Aadi@123");
			System.out.println("2");
			Statement smt = con.createStatement();
			ResultSet rs= smt.executeQuery("select * from t1");
			while(rs.next()) {
				System.out.println("Id: "+ rs.getInt(1) + " Name: " + rs.getString("EName")+ "Age: "+ rs.getInt(3));
			}
			
		}
		catch(Exception e) {
			System.out.println(e);
			
		}
			
		
	}
	public static void delete() {
		try
		{
			//step 1
			Class.forName("com.mysql.cj.jdbc.Driver");//mysql 8
			//step 2
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/avizva?useSSL=false&autoreconnect=true","root","Aadi@123");
			//step 3
			PreparedStatement ps=con.prepareStatement("delete from t1 where id>?");
			
			ps.setInt(1, 30);
			//step 4
			int count=ps.executeUpdate();
			if(count>0)
			{
				System.out.println(count +" deleted successfully");
			}
			else
			{
				System.out.println("no record found");
			}
			//step 5
			
			ps.close();
			con.close();

	
	}
		catch(Exception e) {
			System.out.println(e);
			
		}
		
	}
	public static void update() {
		try
		{
			//step 1
			Class.forName("com.mysql.cj.jdbc.Driver");//mysql 8
			//step 2
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/avizva?useSSL=false&autoreconnect=true","root","Aadi@123");
			//step 3
			PreparedStatement ps=con.prepareStatement("update t1 set EName=? where id=?");
			ps.setString(1, "kriti");
			ps.setInt(2, 25);
			//step 4
			int count=ps.executeUpdate();
			if(count>0)
			{
				System.out.println(count +" updated successfully");
			}
			else
			{
				System.out.println("no record found");
			}
			//step 5
			
			ps.close();
			con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}

	}
	
	public static void multinsert() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("1");
			Scanner sc = new Scanner(System.in);
			int id =sc.nextInt();
			sc.nextLine();
			String name= sc.next();
			int age = sc.nextInt();
			
			Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/avizva?useSSL=false&autoreconnect=true","root","Aadi@123");
			System.out.println("2");
			PreparedStatement ps=con.prepareStatement("insert into t1 values (?,?,?),(36,'kk',44), ("+ id +",'" + name+ "',"+ age+ ")");
			ps.setInt(1, 35);
			ps.setString(2, "Aadi");
			ps.setInt(3, 34);
		//	PreparedStatement ps2=con.prepareStatement("insert into t1 values (3,'popl',44)");
		//	ps.executeUpdate();
			
			
			int count= ps.executeUpdate();
			if(count>0) 
				System.out.println(count+ " inserted");
				else
					System.out.println("Not inserted");
			
			ps.close();
			con.close();
			sc.close();
			
		}
		catch(Exception e) {
			
		}
		
		
	}
	
	public static void procedureExecute() {
		try
		{
			//step 1
			Class.forName("com.mysql.cj.jdbc.Driver");//mysql 8
			//step 2
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/avizva?useSSL=false&autoreconnect=true","root","Aadi@123");
			//step 3
			
			//step 4
			//step 5
			
			con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}

	}
	
	static void executeProcedure()
	{
		try
		{
			//step 1
			Class.forName("com.mysql.cj.jdbc.Driver");//mysql 8
			//step 2
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/avizva?useSSL=false&autoreconnect=true","root","Aadi@123");
			//step 3
			CallableStatement call=con.prepareCall("{call GetAllEmployees()}");
			
			ResultSet rs=call.executeQuery();
			
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3));
			}
			
			rs.close();
			call.close();
			con.close();
		}
		catch(Exception e)
		{
			
		}
	}


static void executeProcWithparam()
{
	try
	{
		//step 1
		Class.forName("com.mysql.cj.jdbc.Driver");//mysql 8
		//step 2
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/avizva?useSSL=false&autoreconnect=true","root","Aadi@123");
		//step 3
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Details: ");

		int id =sc.nextInt();
		sc.nextLine();
		String name= sc.next();
		int age = sc.nextInt();
		CallableStatement call=con.prepareCall("{call InsertIntoEmployees("+id+",'" +name+"',"+ age+")}");
		System.out.println("hello");
		call.executeQuery();
		
//		while(rs.next())
//		{
//			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3));
//		}
//		
		//rs.close();
		call.close();
		con.close();
	}
	catch(Exception e)
	{
		System.out.println(e);
	}
}


static void proc2()
{
	try
	{
		//step 1
		Class.forName("com.mysql.cj.jdbc.Driver");//mysql 8
		//step 2
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/avizva?useSSL=false&autoreconnect=true","root","Aadi@123");
		//step 3
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Details: ");

		int id =sc.nextInt();
		sc.nextLine();
		String name= sc.next();
		int age = sc.nextInt();
		CallableStatement call=con.prepareCall("{call proc2("+id+",'" +name+"',"+ age+",?)}");
		call.registerOutParameter(1, Types.VARCHAR);
		System.out.println("hello");
		call.execute();
		System.out.println(call.getString(1));
		
		call.close();
		con.close();
	}
	catch(Exception e)
	{
		System.out.println(e);
	}
}

}
class Employee{
	int id;
	String name;
	int age;
	public Employee(int id, String name, int age) {
		this.id = id;
		this.name = name;
		this.age = age;
	}
	
}
