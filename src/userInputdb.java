import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class userInputdb {
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
            Scanner scanner = new Scanner(System.in);


            while(true){
                System.out.print("Enter a name");
                String name = scanner.next();
                System.out.print("Enter a age");
                int age = scanner.nextInt();
                System.out.print("Enter a job");
                String job = scanner.next();
                System.out.print("Do you want to add more data?(Y/N)");
                String choice = scanner.next();
                String query = String.format("insert into students(name,age,job) values('%s',%d,'%s')",name,age,job);
                statement.addBatch(query);
                if(choice.toUpperCase().equals("N")){
                    break;
                }
            }
            int[] rows = statement.executeBatch();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
