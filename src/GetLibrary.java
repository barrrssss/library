import java.io.IOException;
import java.sql.*;

public class GetLibrary extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        final String connectionUrl = "jdbc:mysql://localhost:3306/library";
        final String user = "root";
        final String password = "root";
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection connection = DriverManager.getConnection(connectionUrl, user, password);
             Statement statement = connection.createStatement()){
            ResultSet resultSet = statement.executeQuery("Select * from books");

            while (resultSet.next()){
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String author = resultSet.getString(3);
                int quantity = resultSet.getInt(4);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
