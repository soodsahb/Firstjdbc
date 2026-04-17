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

//    String sql= "INSERT INTO studentinfo (id,sname,sage,scity) VALUES (2,'Pranav',23,'Hoshiarpur')";
//
//    int rowsaffected=statement.executeUpdate(sql);
//
//    if(rowsaffected==0) System.out.println("Unable to insert");
//    else{
//      System.out.println("Sucess");
//    }

//    String sql2= "Update studentinfo set sage=26 where id=2";
//    int rowsaffected2=statement.executeUpdate(sql2);
//      if(rowsaffected2==0) System.out.println("Unable to update");
//      else{
//          System.out.println("Sucess update");
//      }


//      String sql3="Select * from studentinfo";
//      ResultSet rs= statement.executeQuery(sql3);
//
//      while(rs.next()){
//          System.out.println(rs.getInt(1)+" "+ rs.getString(2));
//      }

//      String sql4="Delete from studentinfo where id=2";
//      int rowaffected= statement.executeUpdate(sql4);
//
//      if(rowaffected==0) System.out.println("Nothing happeed");
//      else System.out.println("Success delete");

      String sql= "update studentinfo set sage=29 where id=1";
      boolean status= statement.execute(sql); //wii return if non update statment

      if(status){

          ResultSet rs= statement.getResultSet();

          while(rs.next()){
              System.out.println(rs.getInt(1)+" "+ rs.getString(2));
          }
          rs.close();
      }else{

          int rowsaffected= statement.getUpdateCount();
          if(rowsaffected==0) System.out.println("Nothing happened");
          else{
              System.out.println("Sucess update");
          } 

      } 
 


    //closing resources
//      rs.close();
    statement.close();
    connect.close();

  }
}


