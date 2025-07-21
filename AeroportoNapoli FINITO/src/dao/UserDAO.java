package dao;

import controller.Controller;
import model.User;

import java.sql.*;

/**
 * The type User dao.
 */
public class UserDAO {

    /**
     * Find by credentials user.
     *
     * @param username the username
     * @param password the password
     * @return the user
     * @throws SQLException the sql exception
     */
    public static User findByCredentials(String username, String password) throws SQLException {
        String sql = "SELECT * FROM user WHERE username = ? AND password = ?";

        try (Connection con = Controller.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setString(1, username);
            pst.setString(2, password);

            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    int id = rs.getInt("id");
                    boolean isAdmin = rs.getBoolean("admin");
                    return new User(id, username, isAdmin);
                }
            }
        }
        return null;
    }

    /**
     * Find by username user.
     *
     * @param username the username
     * @return the user
     * @throws SQLException the sql exception
     */
    public static User findByUsername(String username) throws SQLException {
        String sql = "SELECT * FROM user WHERE username = ?";

        try (Connection con = Controller.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setString(1, username);

            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    int id = rs.getInt("id");
                    boolean isAdmin = rs.getBoolean("admin");
                    return new User(id, username, isAdmin);
                }
            }
        }
        return null;
    }

    /**
     * Find by id user.
     *
     * @param userId the user id
     * @return the user
     * @throws SQLException the sql exception
     */
    public static User findById(int userId) throws SQLException {
        String sql = "SELECT * FROM user WHERE id = ?";

        try (Connection con = Controller.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setInt(1, userId);

            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    String username = rs.getString("username");
                    boolean isAdmin = rs.getBoolean("admin");
                    return new User(userId, username, isAdmin);
                }
            }
        }
        return null;
    }

    /**
     * Insert boolean.
     *
     * @param username the username
     * @param password the password
     * @return the boolean
     * @throws SQLException the sql exception
     */
    public static boolean insert(String username, String password) throws SQLException {
        String sql = "INSERT INTO user (username, password, admin) VALUES (?, ?, false)";

        try (Connection con = Controller.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setString(1, username);
            pst.setString(2, password);

            int rowsAffected = pst.executeUpdate();
            return rowsAffected > 0;
        }
    }

    /**
     * Update password boolean.
     *
     * @param userId      the user id
     * @param newPassword the new password
     * @return the boolean
     * @throws SQLException the sql exception
     */
    public static boolean updatePassword(int userId, String newPassword) throws SQLException {
        String sql = "UPDATE user SET password = ? WHERE id = ?";

        try (Connection con = Controller.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setString(1, newPassword);
            pst.setInt(2, userId);

            int rowsAffected = pst.executeUpdate();
            return rowsAffected > 0;
        }
    }

    /**
     * Update admin status boolean.
     *
     * @param userId  the user id
     * @param isAdmin the is admin
     * @return the boolean
     * @throws SQLException the sql exception
     */
    public static boolean updateAdminStatus(int userId, boolean isAdmin) throws SQLException {
        String sql = "UPDATE user SET admin = ? WHERE id = ?";

        try (Connection con = Controller.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setBoolean(1, isAdmin);
            pst.setInt(2, userId);

            int rowsAffected = pst.executeUpdate();
            return rowsAffected > 0;
        }
    }

    /**
     * Delete boolean.
     *
     * @param userId the user id
     * @return the boolean
     * @throws SQLException the sql exception
     */
    public static boolean delete(int userId) throws SQLException {
        String sql = "DELETE FROM user WHERE id = ?";

        try (Connection con = Controller.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setInt(1, userId);

            int rowsAffected = pst.executeUpdate();
            return rowsAffected > 0;
        }
    }

    /**
     * Username exists boolean.
     *
     * @param username the username
     * @return the boolean
     * @throws SQLException the sql exception
     */
    public static boolean usernameExists(String username) throws SQLException {
        String sql = "SELECT COUNT(*) FROM user WHERE username = ?";

        try (Connection con = Controller.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setString(1, username);

            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
            }
        }
        return false;
    }
}