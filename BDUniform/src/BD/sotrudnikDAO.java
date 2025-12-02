package BD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class sotrudnikDAO {
    public List<sotrudniki> getAllSotrudnik() {
        List<sotrudniki> sotrudnikList = new ArrayList<>();
        String sql = "SELECT * FROM sotrudnik";

        try (Connection conn = DataBase.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                sotrudniki sotrudnik = new sotrudniki(
                    rs.getInt("ID_employee"),
                    rs.getString("name"),
                    rs.getString("surname"),
                    rs.getString("patronymic"),
                    rs.getInt("height_employee"),
                    rs.getString("post")
                );
                sotrudnikList.add(sotrudnik);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sotrudnikList;
    }
}
