import java.sql.*;
public class javaConnection {
    private static final String url="jdbc:mysql://localhost:3306/myjavadb",
            username="root",password="password";
    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");

        }
       catch (ClassNotFoundException e){
            e.printStackTrace();
       }
        try{
            Connection connection = DriverManager.getConnection(url,username,password);
            Statement statement = connection.createStatement();
//
//            String query = "insert into students(name,age,job) values('Hari Das',24,'frontend dev')";
//            String query = "update students set name='Shyam Hari' where id=2";
            String query ="delete from students where id=2";
            int rows = statement.executeUpdate(query);

            if(rows>0){
                System.out.println("Deleted successfully");
            }
            else{
                System.out.println("unsuccessful");
            }
            //used for select.
//            String query = "Select * from students";
//            ResultSet resultSet=statement.executeQuery(query);

//            while(resultSet.next()){
//                int id = resultSet.getInt("id");
//                String name = resultSet.getString("name");
//                int age = resultSet.getInt("age");
//                String job = resultSet.getString("job");
//                System.out.println("Id is "+id);
//                System.out.println("Name is "+name);
//                System.out.println("Age is "+age);
//                System.out.println("Job is "+job);
//
//            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
}
