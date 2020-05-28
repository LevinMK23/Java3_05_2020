package lesson2;

import java.sql.*;

public class DataTools {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        Connection connection = DriverManager.getConnection("jdbc:sqlite:lessonDB");

        //System.out.println(connection.getCatalog());
        Statement stmt = connection.createStatement();
        // stmt.executeUpdate() delete insert update -> count of affected strings
        // stmt.executeQuery() -> ResultSet (table with data) get iterator
        // stmt.execute()
        //ResultSet result = stmt.executeQuery("select * from students;");
        //System.out.println(result);
        //stmt.executeUpdate("insert into users (login, password) values ('user1', 'password1');");
        ResultSet rs = stmt.executeQuery("select login from users where login = 'user2'");
        int cnt = 0;
        while (rs.next()) {
            cnt++;
        }
        if (cnt != 0) {
            System.out.println("AUTH!");
        }
    }
}
