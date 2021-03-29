package database;

import java.sql.*;
public class Base {


    public static void connect(String fileName) {
        Connection conn = null;
        try {
            // db parameters

            String url = "jdbc:sqlite:src/main/java/" + fileName;
            // create a connection to the database
            conn = DriverManager.getConnection(url);

            System.out.println("Connection to SQLite has been established.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public static void createNewDatabase(String fileName) throws ClassNotFoundException {

        String url = "jdbc:sqlite:src/main/java/" + fileName;

        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
                System.out.println("The driver name is " + meta.getDriverName());
                System.out.println("A new database has been created.");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void createNewTable(String fileName) throws ClassNotFoundException {
        String url = "jdbc:sqlite:src/main/java/" + fileName;

        // SQL statement for creating a new table
        String sql = "CREATE TABLE if not exists USER " +
                "(uid INT PRIMARY KEY NOT NULL," +
                " username CHAR(50) NOT NULL, " +
                " mail text UNIQUE, " +
                " verified int DEFAULT 0)";

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void user_insert(int uid, String username, String mail, int verification) {
        String sql = "INSERT INTO USER(uid,username,mail,verified) VALUES(?,?,?,?)";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, uid);
            pstmt.setString(2, username);
            pstmt.setString(3, mail);
            pstmt.setDouble(4, verification);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:src/main/java/user.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public void user_selectAll(){
        String sql = "SELECT uid, username, mail, verified FROM USER";

        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){

            // loop through the result set
            while (rs.next()) {
                System.out.println(rs.getInt("uid") +  "," +
                        rs.getString("username") + "," +
                        rs.getString("mail") + "," +
                        rs.getInt("verified"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void user_searh(int uid){
        String sql = "SELECT uid, username, mail, verified "
                + "FROM USER WHERE uid = ?";

        try (Connection conn = this.connect();
             PreparedStatement pstmt  = conn.prepareStatement(sql)){

            // set the value
            pstmt.setInt(1,uid);
            //
            ResultSet rs  = pstmt.executeQuery();

            // loop through the result set
            while (rs.next()) {
                System.out.println(rs.getInt("uid") +  "," +
                        rs.getString("username") + "," +
                        rs.getString("mail") + "," +
                        rs.getInt("verified"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void user_verified(int value){
        String sql = "SELECT uid, username, mail, verified "
                + "FROM USER WHERE verified = ?";

        try (Connection conn = this.connect();
             PreparedStatement pstmt  = conn.prepareStatement(sql)){

            // set the value
            pstmt.setInt(1,value);
            //
            ResultSet rs  = pstmt.executeQuery();

            // loop through the result set
            while (rs.next()) {
                System.out.println(rs.getInt("uid") +  "," +
                        rs.getString("username") + "," +
                        rs.getString("mail") + "," +
                        rs.getInt("verified"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }


    }

    public void user_update(int uid, String username, String mail) {
        String sql = "UPDATE USER SET username = ? , "
                + "mail = ? "
                + "WHERE uid = ?";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // set the corresponding param
            pstmt.setString(2, username);
            pstmt.setString(3, mail);
            // update
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void user_delete(int uid) {
        String sql = "DELETE FROM User WHERE uid = ?";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // set the corresponding param
            pstmt.setInt(0, uid);
            // execute the delete statement
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    public boolean user_control(int value) throws SQLException {
        String sql = "SELECT uid "
                + "FROM USER WHERE uid = ?";

        try (Connection conn = this.connect();
             PreparedStatement pstmt  = conn.prepareStatement(sql)){
            // set the value
            pstmt.setInt(1,value);
            //
            ResultSet rs  = pstmt.executeQuery();
            if (!rs.next())
                return false;

            else
                return true;

        }
    }



}
