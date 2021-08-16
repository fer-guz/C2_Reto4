import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conector {
    private Connection connect;

    public Conector(String url) {
        super();
        connectDB(url);
    }

    public ResultSet getReq1DB() {
        // TODO
        String sql = "SELECT sum(cantidad) as total, id_proyecto, pagado, proveedor FROM Compra WHERE pagado = 'No' GROUP BY ID_Proyecto HAVING (total) > 50 ORDER BY `id_proyecto` DESC;";
        return executeQuery(sql);
    }

    public ResultSet getReq2DB() {
        // TODO
        String sql = "SELECT proyecto.Fecha_Inicio as inicio, tipo.Financiable, tipo.Estrato, proyecto.Porcentaje_Cuota_Inicial FROM tipo, proyecto WHERE proyecto.ID_Tipo = tipo.ID_Tipo AND proyecto.Porcentaje_Cuota_Inicial >= 0.3 AND tipo.Estrato >= 5 AND tipo.Financiable = 0 ORDER BY proyecto.Fecha_Inicio ASC;";
        return executeQuery(sql);
    }

    public ResultSet getReq3DB() {
        // TODO
        String sql = "SELECT proyecto.ID_Proyecto, compra.pagado, proyecto.Clasificacion FROM materialconstruccion, compra, proyecto WHERE materialconstruccion.Importado = 'Si' AND compra.ID_MaterialConstruccion = materialconstruccion.ID_MaterialConstruccion AND proyecto.ID_Proyecto = compra.ID_Proyecto AND compra.Pagado IN ('No', 'Parcialmente') AND proyecto.Clasificacion IN ('Apartamento','Apartaestudio') AND proyecto.Acabados = 'No' GROUP BY proyecto.ID_Proyecto ORDER BY proyecto.ID_Proyecto ASC;";
        return executeQuery(sql);
    }

    public Connection connectDB(String url) {
        try {
            connect = DriverManager.getConnection(url, "root", "");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return connect;
    }

    public ResultSet executeQuery(String sql) {
        ResultSet rs = null;
        try {
            Statement stmt = connect.createStatement();
            rs = stmt.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
}