import java.sql.*;
public class prepareStatement {
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
//            String query = "Insert into students(name,age,job) values(?,?,?)";
            String query = "select * from students";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
//            preparedStatement.setInt(1,1);
//            preparedStatement.setString(1,"Ravi Kumar");
//            preparedStatement.setInt(2,34);
//            preparedStatement.setString(3,"Cloud Engineer");

//            int rows = preparedStatement.executeUpdate();
//            if(rows>0){
//                System.out.println("Data inserted");
//            }
//            else{
//                System.out.println("Data is not inserted");
//            }

            ResultSet resultSet = preparedStatement.executeQuery();
           while(resultSet.next()){
               int id = resultSet.getInt("id");
               String name = resultSet.getString("name");
               int age = resultSet.getInt("age");
               String job  = resultSet.getString("job");
               System.out.println("id is "+id);
               System.out.println("name is "+name);
               System.out.println("age is "+age);
               System.out.println("job is "+job);
           }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
}
