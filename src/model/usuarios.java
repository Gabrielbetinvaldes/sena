package model;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


import connection.Connect;
import controller.MenuController;


public class usuarios  {


    private String usuario;
    private String contraseña;
    private String rol;


 
    public usuarios(String usuario, String contraseña, String rol) {
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.rol = rol;
    }




    public static String buscarUsuario(String busuario){
    
        String mostrar = "";
        String cadenaSQL = "Select  * from usuarios WHERE usuUsuario =" + busuario  ;
        try {
            Connect objConexion = new Connect();    
            Connection conn = objConexion.connect(); // devuelve el objeto conectado a la URL
            Statement stmt =  conn.createStatement(); // permiten realizar consultas SQL en la B.D.
    
            ResultSet resultSet = stmt.executeQuery(cadenaSQL);
            while (resultSet.next()) {
              mostrar =   resultSet.getString("UsuNombres") + "," + resultSet.getString("UsuUsuario") + "," + resultSet.getString("Usucontraseña") + "," + resultSet.getString("UsuIdRol");
              
            
            }      
                                  
                
            conn.close();
            stmt.close();
            System.out.println("Encontrado.");  
            System.out.println(mostrar);            
        } catch (Exception e) {
            System.out.println(e.getMessage()); 
        }                    
            return mostrar;
            
    }

 





















    public String getUsuario() {
        return usuario;
    }
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    public String getContraseña() {
        return contraseña;
    }
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    public String getRol() {
        return rol;
    }
    public void setRol(String rol) {
        this.rol = rol;
    }



    
}
