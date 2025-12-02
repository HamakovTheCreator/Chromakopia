package BD;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ExtraditionDAO {
    public List<extradition> getAllExtradition() {
        List<extradition> extraditionList = new ArrayList<>();
        String sql = "SELECT * FROM extradition";

        try (Connection conn = DataBase.getConnection();
             Statement stat = conn.createStatement();
             ResultSet rs = stat.executeQuery(sql)) {
            
            while (rs.next()) {
                extradition extradition = new extradition(
                    rs.getInt("ID_extradition"),
                    rs.getInt("ID_employee"),
                    rs.getInt("ID_uniform"),
                    rs.getDate("date_issue")
                );
                extraditionList.add(extradition);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return extraditionList;
    }
}
