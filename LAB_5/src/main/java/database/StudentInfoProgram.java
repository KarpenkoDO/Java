package database;

import java.sql.*;

public class StudentInfoProgram {
    public static void main(String[] args) {
        String url = "url";
        String username = "username";
        String password = "password";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String month = "June"; // Задайте потрібний місяць

            // Виконуємо запит до бази даних
            String query = "SELECT * FROM students WHERE MONTH(birth_date) = MONTH(STR_TO_DATE('" + month + "', '%M'))";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            // Виводимо результати запиту
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String lastName = resultSet.getString("last_name");
                String firstName = resultSet.getString("first_name");
                String middleName = resultSet.getString("middle_name");
                Date birthDate = resultSet.getDate("birth_date");
                String studentId = resultSet.getString("student_id");

                System.out.println("ID: " + id);
                System.out.println("Last Name: " + lastName);
                System.out.println("First Name: " + firstName);
                System.out.println("Middle Name: " + middleName);
                System.out.println("Birth Date: " + birthDate);
                System.out.println("Student ID: " + studentId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}