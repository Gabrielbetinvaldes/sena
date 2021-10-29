package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;

import connection.Connect;

import controller.RecursosHumanoController;




public class nomina extends RecursosHumanoController {


    private String factura;
    private String idEmpleado;
    private String serenatas;
    private String  vNomina;
    private String pension;
    private String salud;
    private String descuentos;
    private String ahorros;
    private String cultural;
    private String  fechaPago;
    private String  metodoPago;    
    private String totalLiquidar;

    public nomina(String factura, String idEmpleado, String serenatas, String vNomina, String pension, String salud,
            String descuentos, String ahorros, String cultural, String fechaPago, String metodoPago,
            String totalLiquidar) {
        this.factura = factura;
        this.idEmpleado = idEmpleado;
        this.serenatas = serenatas;
        this.vNomina = vNomina;
        this.pension = pension;
        this.salud = salud;
        this.descuentos = descuentos;
        this.ahorros = ahorros;
        this.cultural = cultural;
        this.fechaPago = fechaPago;
        this.metodoPago = metodoPago;
        this.totalLiquidar = totalLiquidar;
    }


    public void cargarNomina(){
  
        String cadenaSQL = "INSERT INTO nomina (NomIdfactura,NomIdEmpleado,NomCantidadSerenatas,NompagoNomina,NomPension,NomSalud,NomDescuentos,NomAhorros,NomCultural,NomFechaPago,NomMetodoPAgo,NomTotalPago)VALUES(" + factura + ","+idEmpleado+","+serenatas+","+vNomina+","+pension+","+salud+","+descuentos+","+ahorros+","+cultural+","+fechaPago+","+metodoPago+","+totalLiquidar+" )";
        System.out.println(cadenaSQL);
        try {
            Connect objConexion = new Connect();
    
            Connection conn = objConexion.connect(); // devuelve el objeto conectado a la URL
            Statement stmt =  conn.createStatement(); // permiten realizar consultas SQL en la B.D.
                        
            stmt.executeUpdate(cadenaSQL); // para insertar datos.
            conn.close();
            stmt.close();
            System.out.println("Guardado.");            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } 
    }


    public void editarNomina(String id){
  
                  
        String cadenaSQL = "UPDATE nomina  SET NomIdfactura = " + factura  +", NomIdEmpleado = " + idEmpleado + ", NomCantidadSerenatas = " + 
        serenatas+ ", NompagoNomina = " + vNomina + ", NomPension = " + pension  +  ", NomSalud = " + salud+ 
        ", NomDescuentos = " + descuentos + ", NomAhorros=  " + ahorros+ ", NomCultural= " + cultural +  " , NomFechaPago =  " + fechaPago +
        ", NomMetodoPAgo =  " + metodoPago + ", NomTotalPago= " + totalLiquidar+ 
        " WHERE NomIdNomina = " + id + ";" ;
        System.out.println(cadenaSQL);
        try {
            Connect objConexion = new Connect();
    
            Connection conn = objConexion.connect(); // devuelve el objeto conectado a la URL
            Statement stmt =  conn.createStatement(); // permiten realizar consultas SQL en la B.D.
                        
            stmt.executeUpdate(cadenaSQL); // para insertar datos.
            conn.close();
            stmt.close();
            System.out.println("Guardado.");            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } 
    }

    public static String idNomina(){
    
        String mostrar = "";
        int res = 0;
        String cadenaSQL = "Select * from nomina ORDER BY NomIdNomina DESC LIMIT 1";
        try {
            Connect objConexion = new Connect();    
            Connection conn = objConexion.connect(); // devuelve el objeto conectado a la URL
            Statement stmt =  conn.createStatement(); // permiten realizar consultas SQL en la B.D.
    
            ResultSet resultSet = stmt.executeQuery(cadenaSQL);
            while (resultSet.next()) {
              res = resultSet.getInt("NomIdNomina") + 1 ;
            } 
            
            mostrar = String.valueOf(res);      
                        
            
            conn.close();
            stmt.close();
            System.out.println("Encontrado.");            
        } catch (Exception e) {
            System.out.println(e.getMessage()); 
        }                    
            return mostrar;
    }


    public static String buscarNominaId(String id){
    
        String mostrar = "";
        String cadenaSQL = "Select * from nomina WHERE NomIdNomina =" + id ;
        try {
            Connect objConexion = new Connect();    
            Connection conn = objConexion.connect(); // devuelve el objeto conectado a la URL
            Statement stmt =  conn.createStatement(); // permiten realizar consultas SQL en la B.D.
    
            ResultSet resultSet = stmt.executeQuery(cadenaSQL);
            while (resultSet.next()) {
              mostrar = resultSet.getString("NomIdfactura") + "," + resultSet.getString("NomIdEmpleado") + "," +   resultSet.getString("NomCantidadSerenatas") + "," + resultSet.getString("NompagoNomina") + "," + resultSet.getString("NomPension") + "," +  resultSet.getString("NomSalud") + "," + resultSet.getString("NomDescuentos") + "," + resultSet.getString("NomAhorros") + "," +  resultSet.getString("NomCultural") + "," + resultSet.getString("NomFechaPago") + "," + resultSet.getString("NomMetodoPAgo") + "," + resultSet.getString("NomTotalPago");
            }      
                                  
            
            conn.close();
            stmt.close();
            System.out.println("Encontrado.");            
        } catch (Exception e) {
            System.out.println(e.getMessage()); 
        }                    
            return mostrar;
    }
    
    public  static void eliminarNomina(String id){


        String cadenaSQL = "DELETE FROM nomina  WHERE NomIdNomina = " + id ;
          
        System.out.println(cadenaSQL);
        try {
            Connect objConexion = new Connect();
    
            Connection conn = objConexion.connect(); // devuelve el objeto conectado a la URL
            Statement stmt =  conn.createStatement(); // permiten realizar consultas SQL en la B.D.
                        
            stmt.executeUpdate(cadenaSQL); // para insertar datos.
            conn.close();
            stmt.close();
            System.out.println("Eliminado.");            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    
    }



    public String getFactura() {
        return factura;
    }

    public void setFactura(String factura) {
        this.factura = factura;
    }

    public String getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(String idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getSerenatas() {
        return serenatas;
    }

    public void setSerenatas(String serenatas) {
        this.serenatas = serenatas;
    }



    public String getvNomina() {
        return vNomina;
    }



    public void setvNomina(String vNomina) {
        this.vNomina = vNomina;
    }



    public String getPension() {
        return pension;
    }

    public void setPension(String pension) {
        this.pension = pension;
    }

    public String getSalud() {
        return salud;
    }

    public void setSalud(String salud) {
        this.salud = salud;
    }

    public String getDescuentos() {
        return descuentos;
    }

    public void setDescuentos(String descuentos) {
        this.descuentos = descuentos;
    }

    public String getAhorros() {
        return ahorros;
    }

    public void setAhorros(String ahorros) {
        this.ahorros = ahorros;
    }

    public String getCultural() {
        return cultural;
    }

    public void setCultural(String cultural) {
        this.cultural = cultural;
    }

    public String getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(String fechaPago) {
        this.fechaPago = fechaPago;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public String getTotalLiquidar() {
        return totalLiquidar;
    }

    public void setTotalLiquidar(String totalLiquidar) {
        this.totalLiquidar = totalLiquidar;
    }

    
} 

    
 

    



   