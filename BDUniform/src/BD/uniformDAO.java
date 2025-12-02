package BD;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class uniformDAO {
    public List<uniform> getAllUniform() {
        List<uniform> uniformList = new ArrayList<>();
        String sql = "SELECT * FROM uniform";

        try (Connection conn = DataBase.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                uniform uniform = new uniform(
                    rs.getInt("ID_uniform"),
                    rs.getInt("set_number"),
                    rs.getInt("size")
                );
                uniformList.add(uniform);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return uniformList;
    }
}