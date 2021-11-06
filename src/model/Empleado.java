package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalTime;

import connection.Connect;
import controller.RecursosHumanoController;

public class Empleado  extends RecursosHumanoController{
    
private String  nomEmpleado;
private String  docEmpleado;
private String  dirEmpleado;
private String  ciudEmpleado;
private String  civilEmpleado;
private String  telEmpleado;
private String  carEmpleado;
private String sueldo;
private int hijos;
private String  genero;
private int edadEmpleado;
private String  fecNacimiento;
private String  fecIngreso;
private String  estEmpleado;
private String  fecRetiro;

public Empleado (String nomEmpleado, String docEmpleado, String dirEmpleado, String ciudEmpleado, String civilEmpleado,
        String telEmpleado, String carEmpleado, String sueldo, int hijos, String genero, int edadEmpleado,
        String fecNacimiento, String fecIngreso, String estEmpleado, String fecRetiro) {
    this.nomEmpleado = nomEmpleado;
    this.docEmpleado = docEmpleado;
    this.dirEmpleado = dirEmpleado;
    this.ciudEmpleado = ciudEmpleado;
    this.civilEmpleado = civilEmpleado;
    this.telEmpleado = telEmpleado;
    this.carEmpleado = carEmpleado;
    this.sueldo = sueldo;
    this.hijos = hijos;
    this.genero = genero;
    this.edadEmpleado = edadEmpleado;
    this.fecNacimiento = fecNacimiento;
    this.fecIngreso = fecIngreso;
    this.estEmpleado = estEmpleado;
    this.fecRetiro = fecRetiro;

}

public static String buscarEmpleadoCed(String ced){
    
    String mostrar = "";
    String cadenaSQL = "Select * from empleados WHERE EmpDocIdentidad =" + ced ;
    try {
        Connect objConexion = new Connect();    
        Connection conn = objConexion.connect(); // devuelve el objeto conectado a la URL
        Statement stmt =  conn.createStatement(); // permiten realizar consultas SQL en la B.D.

        ResultSet resultSet = stmt.executeQuery(cadenaSQL);
        while (resultSet.next()) {
            mostrar = resultSet.getString("EmpNombres") + "," + resultSet.getString("EmpIdEmpleados") + "," +   resultSet.getString("EmpDireccion") + "," + resultSet.getString("EmpCiudad") + "," + resultSet.getString("EmpEstadoCivil") + "," +  resultSet.getString("EmpNumerosTelefono") + "," + resultSet.getString("EmpCargo") + "," + resultSet.getString("EmpSueldo") + "," +  resultSet.getString("EmpHijos") + "," + resultSet.getString("EmpGenero") + "," + resultSet.getString("EmpEdad") + "," + resultSet.getString("EmpNacimiento") + "," + resultSet.getString("EmpIngreso") + "," + resultSet.getString("EmpEstado") + "," + resultSet.getString("EmpRetiro");
        }      
                              
        
        conn.close();
        stmt.close();
        System.out.println("Encontrado.");            
    } catch (Exception e) {
        System.out.println(e.getMessage()); 
    }                    
        return mostrar;
}

public static String buscarEmpleadoId(String id){
    
    String mostrar = "";
    String cadenaSQL = "Select * from empleados WHERE EmpIdEmpleados =" + id ;
    try {
        Connect objConexion = new Connect();    
        Connection conn = objConexion.connect(); // devuelve el objeto conectado a la URL
        Statement stmt =  conn.createStatement(); // permiten realizar consultas SQL en la B.D.

        ResultSet resultSet = stmt.executeQuery(cadenaSQL);
        while (resultSet.next()) {
          mostrar = resultSet.getString("EmpNombres") + "," + resultSet.getString("EmpDocIdentidad") + "," +   resultSet.getString("EmpDireccion") + "," + resultSet.getString("EmpCiudad") + "," + resultSet.getString("EmpEstadoCivil") + "," +  resultSet.getString("EmpNumerosTelefono") + "," + resultSet.getString("EmpCargo") + "," + resultSet.getString("EmpSueldo") + "," +  resultSet.getString("EmpHijos") + "," + resultSet.getString("EmpGenero") + "," + resultSet.getString("EmpEdad") + "," + resultSet.getString("EmpNacimiento") + "," + resultSet.getString("EmpIngreso") + "," + resultSet.getString("EmpEstado") + "," + resultSet.getString("EmpRetiro");
        }      
                              
        
        conn.close();
        stmt.close();
        System.out.println("Encontrado.");            
    } catch (Exception e) {
        System.out.println(e.getMessage()); 
    }                    
        return mostrar;
}


public static LocalDate LocalDateStringConverter(String string) {

    LocalDate fecha = LocalDate.parse(string);


return fecha;


}


public static LocalTime LocalTimeStringConverter(String string) {

    LocalTime hora = LocalTime.parse(string);


return hora;
}

public static String idEmpleado(){
    
    String mostrar = "";
    int res = 0;
    String cadenaSQL = "Select * from empleados ORDER BY EmpIdEmpleados DESC LIMIT 1";
    try {
        Connect objConexion = new Connect();    
        Connection conn = objConexion.connect(); // devuelve el objeto conectado a la URL
        Statement stmt =  conn.createStatement(); // permiten realizar consultas SQL en la B.D.

        ResultSet resultSet = stmt.executeQuery(cadenaSQL);
        while (resultSet.next()) {
          res = resultSet.getInt("EmpIdEmpleados") + 1 ;
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

public void cargaEmpleado(){


    String cadenaSQL = "INSERT INTO empleados (EmpNombres,EmpDocIdentidad,EmpDireccion,EmpCiudad,EmpEstadoCivil,EmpNumerosTelefono,EmpCargo,EmpSueldo,EmpHijos,EmpGenero,EmpEdad,EmpNacimiento,EmpIngreso,EmpEstado) VALUES (" + nomEmpleado + ","+docEmpleado+","+dirEmpleado+","+ciudEmpleado+","+civilEmpleado+","+telEmpleado+","+carEmpleado+","+sueldo+","+hijos+","+genero+","+edadEmpleado+","+fecNacimiento+","+fecIngreso+" ,"+ estEmpleado +" )";
      
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

public  static void eliminarEmpleado(String id){


    String cadenaSQL = "DELETE FROM empleados  WHERE EmpIdEmpleados = " + id ;
      
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





public void editarEmpleado(String id){


String cadenaSQL = "UPDATE empleados  SET EmpNombres = " + nomEmpleado +", EmpDocIdentidad = " + docEmpleado + ", EmpDireccion = " + 
dirEmpleado + ", EmpCiudad = " + ciudEmpleado + ", EmpEstadoCivil = " + civilEmpleado  +  ", EmpNumerosTelefono = " + telEmpleado + 
", EmpCargo = " + carEmpleado + ", EmpSueldo =  " + sueldo + ", EmpHijos = " + hijos +  " , EmpGenero =  " + genero +
", EmpEdad =  " + edadEmpleado + ", EmpNacimiento = " + fecNacimiento + ", EmpIngreso = " + fecIngreso + ", EmpEstado =  " + estEmpleado +
" WHERE EmpIdEmpleados = " + id + ";" ;
      
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


public String getNomEmpleado() {
    return nomEmpleado;
}

public void setNomEmpleado(String nomEmpleado) {
    this.nomEmpleado = nomEmpleado;
}

public String getDocEmpleado() {
    return docEmpleado;
}

public void setDocEmpleado(String docEmpleado) {
    this.docEmpleado = docEmpleado;
}

public String getDirEmpleado() {
    return dirEmpleado;
}

public void setDirEmpleado(String dirEmpleado) {
    this.dirEmpleado = dirEmpleado;
}

public String getCiudEmpleado() {
    return ciudEmpleado;
}

public void setCiudEmpleado(String ciudEmpleado) {
    this.ciudEmpleado = ciudEmpleado;
}

public String getCivilEmpleado() {
    return civilEmpleado;
}

public void setCivilEmpleado(String civilEmpleado) {
    this.civilEmpleado = civilEmpleado;
}

public String getTelEmpleado() {
    return telEmpleado;
}

public void setTelEmpleado(String telEmpleado) {
    this.telEmpleado = telEmpleado;
}

public String getCarEmpleado() {
    return carEmpleado;
}

public void setCarEmpleado(String carEmpleado) {
    this.carEmpleado = carEmpleado;
}

public String getSueldo() {
    return sueldo;
}

public void setSueldo(String sueldo) {
    this.sueldo = sueldo;
}

public int getHijos() {
    return hijos;
}

public void setHijos(int hijos) {
    this.hijos = hijos;
}

public String getGenero() {
    return genero;
}

public void setGenero(String genero) {
    this.genero = genero;
}

public int getEdadEmpleado() {
    return edadEmpleado;
}

public void setEdadEmpleado(int edadEmpleado) {
    this.edadEmpleado = edadEmpleado;
}

public String getFecNacimiento() {
    return fecNacimiento;
}

public void setFecNacimiento(String fecNacimiento) {
    this.fecNacimiento = fecNacimiento;
}

public String getFecIngreso() {
    return fecIngreso;
}

public void setFecIngreso(String fecIngreso) {
    this.fecIngreso = fecIngreso;
}

public String getEstEmpleado() {
    return estEmpleado;
}

public void setEstEmpleado(String estEmpleado) {
    this.estEmpleado = estEmpleado;
}

public String getFecRetiro() {
    return fecRetiro;
}

public void setFecRetiro(String fecRetiro) {
    this.fecRetiro = fecRetiro;
}


                                                                                                                                                                                                             
            
                                                                                                                                                                                                                                                                                                                           
}
