package model;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;

import connection.Connect;
import controller.ContabilidadRegistrosController;



public class cliente  extends ContabilidadRegistrosController{

    private String  nomCliente;
    private String  docCliente;
    private String  emailCliente;
    private String  telUnoClie;
    private String  telDosClie;
    private String  wtCliente;
    private String  refCliente;


public cliente(String nomCliente, String docCliente, String emailCliente, String telUnoClie, String telDosClie,
            String wtCliente, String refCliente) {
        this.nomCliente = nomCliente;
        this.docCliente = docCliente;
        this.emailCliente = emailCliente;
        this.telUnoClie = telUnoClie;
        this.telDosClie = telDosClie;
        this.wtCliente = wtCliente;
        this.refCliente = refCliente;
    }


    public void cargaCliente(){

                                                                                                                                           
        String cadenaSQL = "INSERT INTO clientes (CliNombres,CliDocIdentidad,CliEmail,CliTelefonoUno,CliTelefonoDos,CliWhatSapp,CliReferencias) VALUES (" + nomCliente + ","+docCliente+","+emailCliente+","+telUnoClie+","+telDosClie+","+wtCliente+","+refCliente+" )";
          
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


    public static String idCliente(){
    
        String mostrar = "";
        int res = 0;
        String cadenaSQL = "Select * from clientes ORDER BY CliIdClientes DESC LIMIT 1";
        try {
            Connect objConexion = new Connect();    
            Connection conn = objConexion.connect(); // devuelve el objeto conectado a la URL
            Statement stmt =  conn.createStatement(); // permiten realizar consultas SQL en la B.D.
    
            ResultSet resultSet = stmt.executeQuery(cadenaSQL);
            while (resultSet.next()) {
              res = resultSet.getInt("CliIdClientes") + 1 ;
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



    public static String buscarClienteId(String id){
    
        String mostrar = "";
        String cadenaSQL = "Select * from clientes WHERE CliIdClientes =" + id ;
        try {
            Connect objConexion = new Connect();    
            Connection conn = objConexion.connect(); // devuelve el objeto conectado a la URL
            Statement stmt =  conn.createStatement(); // permiten realizar consultas SQL en la B.D.
    
            ResultSet resultSet = stmt.executeQuery(cadenaSQL);
            while (resultSet.next()) {
              mostrar = resultSet.getString("CliNombres") + "," + resultSet.getString("CliDocIdentidad") + "," +   resultSet.getString("CliEmail") + "," + resultSet.getString("CliTelefonoUno") + "," + resultSet.getString("CliTelefonoDos") + "," +  resultSet.getString("CliWhatSapp") + "," + resultSet.getString("CliReferencias");
            }      
                                  
            
            conn.close();
            stmt.close();
            System.out.println("Encontrado.");            
        } catch (Exception e) {
            System.out.println(e.getMessage()); 
        }                    
            return mostrar;
    }



    public void editarCliente(String id){


    

        String cadenaSQL = "UPDATE clientes  SET CliNombres = " + nomCliente +", CliDocIdentidad = " + docCliente + ", CliEmail = " + 
        emailCliente + ", CliTelefonoUno = " + telUnoClie + ", CliTelefonoDos = " + telDosClie +  ", CliWhatSapp = " +wtCliente + 
        ", CliReferencias = " + refCliente  +" WHERE CliIdClientes = " + id + ";" ;
              
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


        public  static void eliminarCliente(String id){


            String cadenaSQL = "DELETE FROM clientes  WHERE CliIdClientes = " + id ;
              
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



public String getNomCliente() {
    return nomCliente;
}


public void setNomCliente(String nomCliente) {
    this.nomCliente = nomCliente;
}


public String getDocCliente() {
    return docCliente;
}


public void setDocCliente(String docCliente) {
    this.docCliente = docCliente;
}


public String getEmailCliente() {
    return emailCliente;
}


public void setEmailCliente(String emailCliente) {
    this.emailCliente = emailCliente;
}


public String getTelUnoClie() {
    return telUnoClie;
}


public void setTelUnoClie(String telUnoClie) {
    this.telUnoClie = telUnoClie;
}


public String getTelDosClie() {
    return telDosClie;
}


public void setTelDosClie(String telDosClie) {
    this.telDosClie = telDosClie;
}


public String getWtCliente() {
    return wtCliente;
}


public void setWtCliente(String wtCliente) {
    this.wtCliente = wtCliente;
}


public String getRefCliente() {
    return refCliente;
}


public void setRefCliente(String refCliente) {
    this.refCliente = refCliente;
}

    


    

}
