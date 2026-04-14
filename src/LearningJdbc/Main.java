package LearningJdbc;

import java.sql.*;

public class Main{

  public static void main(String[] args) throws ClassNotFoundException, SQLException {

    //loading and registering the driver

    Class.forName("com.mysql.cj.jdbc.Driver");

    //establish connection

    String url="jdbc:mysql://localhost:3306/jdbc";
    String user="root";
    String password="12345678";
   Connection connect= DriverManager.getConnection(url,user,password);

   //creating statment
    Statement statement= connect.createStatement();

    //execute query and prcoess result

    String sql= "INSERT INTO studentinfo (id,sname,sage,scity) VALUES (2,'Pranav',23,'Hoshiarpur')";

    int rowsaffected=statement.executeUpdate(sql);

    if(rowsaffected==0) System.out.println("Unable to insert");
    else{
      System.out.println("Sucess");
    }



    //closing resources
    statement.close();
    connect.close();

  }
}


