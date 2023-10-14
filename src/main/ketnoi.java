package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ketnoi {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/hocform";
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "";

    public static Connection ketNoiDatabase() {
        Connection conn = null;
        try {
            // Đăng ký driver MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
            System.out.println("Kết nối thành công đến cơ sở dữ liệu!");
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Kết nối thất bại: " + ex.getMessage());
        }
        return conn;
    }
    
    public static void main(String[] args) {
        Connection conn = ketNoiDatabase();
        if (conn != null) {
            // Kết nối thành công, bạn có thể thực hiện các hoạt động với cơ sở dữ liệu ở đây
            // Ví dụ: thực hiện truy vấn SQL
            try {
                conn.close();
            } catch (SQLException ex) {
                System.out.println("Lỗi khi đóng kết nối: " + ex.getMessage());
            }
        } else {
            // Xử lý khi kết nối thất bại
            System.out.println("Không thể thực hiện hoạt động với cơ sở dữ liệu do kết nối thất bại.");
        }
    }
}
