import java.io.*;
import java.sql.*;
import java.util.*;

/*
This class connects to wahi database that cntains threee tables:
Table 1: login table that contains admin username and password
Table 2: sqlcommands table that contain keys for different sql queries that WAHI can understand such as 0 for retreiving data from grocessory_lst table etc
Tble 3: grocessory list table that has sample grocessory data 
The accessLogin function retreive login credentials from login table and returns the result set to get checked by the entered text.
access function takes in the id that user has said wahi to execute and runs the corresponding query and retrive data accordingly into a corresponding text file
Writetofile() function writes down the retrieved data into a text file and siplays it to the user
 */

public class AccessJDBC{

	

	public ResultSet accessLogin(){

		ResultSet rs=null;
		try{
			Connection con = null;
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/wahi", "root", "iqra12345");
			Statement st = con.createStatement();
			String cmd="select * from login";
			rs = st.executeQuery(cmd);
			
		}catch(Exception e){
			System.out.println(e);
		}
		return(rs);
	}
	
	public void access(String sqlCommandid) {
		ArrayList<String> data=new ArrayList<String>();
		try {
			Connection con = null;
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/wahi", "root", "iqra12345");
			Statement st = con.createStatement();
			ResultSet rs=null;
			if(sqlCommandid=="0"){
				File file = new File("grocessory_lst.txt");
				file.createNewFile();
				String cmd="select * from grocessory_lst";
				rs = st.executeQuery(cmd);
			while (rs.next()) {
				String id = String.valueOf(rs.getInt("id"));
				String name = rs.getString("name");
				String quantity = String.valueOf(rs.getInt("quantity"));
				String price = String.valueOf(rs.getInt("price"));
				data.add(id+" "+name+" "+quantity+" "+price);
			}
			writetoFile(data,file);
		}
			else if(sqlCommandid=="1"){
				File file = new File("filteredgrocessory_lst.txt");
				file.createNewFile();
				String cmd="select * from grocessory_lst where price > 10";
				rs = st.executeQuery(cmd);
			while (rs.next()) {
				String id = String.valueOf(rs.getInt("id"));
				String name = rs.getString("name");
				String quantity = String.valueOf(rs.getInt("quantity"));
				String price = String.valueOf(rs.getInt("price"));
				data.add(id+" "+name+" "+quantity+" "+price);
			}
			writetoFile(data,file);
		}else if(sqlCommandid=="2"){
			File file = new File("WAHICommands.txt");
			file.createNewFile();
			String cmd="select * from wahi_commands";
			rs = st.executeQuery(cmd);
		while (rs.next()) {
			String id = String.valueOf(rs.getInt("id"));
			String command = rs.getString("cmd");
			data.add(id+" "+command);
		}
		writetoFile(data,file);
	}
			rs.close();
			st.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void writetoFile(ArrayList data,File file){
		try{
		BufferedWriter out = null;
		out = new BufferedWriter(new FileWriter(file, true));
		for(int i=0;i<data.size();i++){
			//System .out.print(a);
			String a=String.valueOf(data.get(i));
			out.write(a);
			out.newLine();
		}
		out.close();
	}catch(Exception e){
		System.out.println(e);
	}
}
}