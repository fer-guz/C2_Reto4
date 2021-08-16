import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



public class Controller {
    private ArrayList<Req1> req1s;
    private ArrayList<Req2> req2s;
    private ArrayList<Req3> req3s;
    private Conector conectorDB;

    public Controller(String url) {
        super();
        // TODO inicializar las listas de reqs
        conectorDB = new Conector(url);
        this.req1s = new ArrayList<Req1>();
        ;
        this.req2s = new ArrayList<Req2>();
        ;
        this.req3s = new ArrayList<Req3>();
        ;
    }

    public void req1() {
        // TODO logica de llenado de la lista req1s

        ResultSet rs = conectorDB.getReq1DB();

        try {

            while (rs.next()) {
                int total= rs.getInt("total");
                int id= rs.getInt("id_proyecto");
                String pagado= rs.getString("pagado");
                String proveedor = rs.getString("proveedor");
                
                //Creas un objeto del tipo que te estas trayendo de la bd, en mi caso, un objeto Persona
                
                Req1 r1=new Req1(total,id,pagado, proveedor);//le mandas los parametros necesarios al constructor del Bean Persona. 
                
                req1s.add(r1); //agregas ese objeto a la lista
            }
            rs.close();

        } catch (SQLException e) {
            // Manejo de los errores

        }

    }

    public void req2() {
        // TODO logica de llenado de la lista req2s
        
        ResultSet rs = conectorDB.getReq2DB();

        try {

            while (rs.next()) {
                int estrato= rs.getInt("Estrato");
                String inicio= rs.getString("inicio");
                int fina= rs.getInt("Financiable");
                
                double porc = rs.getDouble("Porcentaje_Cuota_Inicial")*100;
                
                //Creas un objeto del tipo que te estas trayendo de la bd, en mi caso, un objeto Persona
                
                Req2 r2=new Req2(estrato, inicio, fina, porc);//le mandas los parametros necesarios al constructor del Bean Persona. 
                
                req2s.add(r2); //agregas ese objeto a la lista
            }
            rs.close();

        } catch (SQLException e) {
            // Manejo de los errores
            e.printStackTrace();

        }
    }

    public void req3() {
        // TODO logica de llenado de la lista req3s

        ResultSet rs = conectorDB.getReq3DB();

        try {

            while (rs.next()) {
                String clasi= rs.getString("Clasificacion");
                int id= rs.getInt("ID_Proyecto");
                String pagado= rs.getString("pagado");
                
                //Creas un objeto del tipo que te estas trayendo de la bd, en mi caso, un objeto Persona
                
                Req3 r3=new Req3(id, pagado, clasi);//le mandas los parametros necesarios al constructor del Bean Persona. 
                
                req3s.add(r3); //agregas ese objeto a la lista
            }
            rs.close();

        } catch (SQLException e) {
            // Manejo de los errores
            e.printStackTrace();

        }
    }

    public void printReq1() {
        for (Req1 req1 : req1s) {
            System.out.println(req1);
        }
    }

    public void printReq2() {
        for (Req2 req2 : req2s) {
            System.out.println(req2);
        }
    }

    public void printReq3() {
        for (Req3 req3 : req3s) {
            System.out.println(req3);
        }
    }
}
