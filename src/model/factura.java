package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;

import connection.Connect;
import controller.ContabilidadRegistrosController;

public class factura {
    

    private String fechaFactura;
    private String idCotizacion;
    private String nombreCliente;
    private String emailCliente;
    private String wtCliente;
    private String telDosClie;
    private String telUnoClie;
    private String barrio;
    private String ciudad;
    private String direccion;
    private String motivo ;
    private String homenajeado;
    private String parentezco;
    private String quien;
    private String obsequio;
    private String precioVenta;
    private String sonido;
    private String preObsequio;
    private String cantMusico;
    private String estado;
    private String transporte;
    private String totalCotizacion;
    private String hora;

 


    public factura(String fechaFactura, String idCotizacion, String estado) {
        this.fechaFactura = fechaFactura;
        this.idCotizacion = idCotizacion;
        this.estado = estado;
    }



    public void cargaFactura(){
      
          
                                                                                                                                                  
        String cadenaSQL = "INSERT INTO factura (FacIdCotizacion, FacFechaFactura, FacEstado) VALUES("+idCotizacion+" ," + fechaFactura +" ," + estado + ")";
          
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








    public static String idFactura(){
    
        String mostrar = "";
        int res = 0;
        String cadenaSQL = "Select * from factura ORDER BY FacIdFactura DESC LIMIT 1";
        try {
            Connect objConexion = new Connect();    
            Connection conn = objConexion.connect(); // devuelve el objeto conectado a la URL
            Statement stmt =  conn.createStatement(); // permiten realizar consultas SQL en la B.D.
    
            ResultSet resultSet = stmt.executeQuery(cadenaSQL);
            while (resultSet.next()) {
              res = resultSet.getInt("FacIdFactura") + 1 ;
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












    public String getFechaFactura() {
        return fechaFactura;
    }
    public void setFechaFactura(String fechaFactura) {
        this.fechaFactura = fechaFactura;
    }
    public String getIdCotizacion() {
        return idCotizacion;
    }
    public void setIdCotizacion(String idCotizacion) {
        this.idCotizacion = idCotizacion;
    }
    public String getNombreCliente() {
        return nombreCliente;
    }
    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }
    public String getEmailCliente() {
        return emailCliente;
    }
    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }
    public String getWtCliente() {
        return wtCliente;
    }
    public void setWtCliente(String wtCliente) {
        this.wtCliente = wtCliente;
    }
    public String getTelDosClie() {
        return telDosClie;
    }
    public void setTelDosClie(String telDosClie) {
        this.telDosClie = telDosClie;
    }
    public String getTelUnoClie() {
        return telUnoClie;
    }
    public void setTelUnoClie(String telUnoClie) {
        this.telUnoClie = telUnoClie;
    }
    public String getBarrio() {
        return barrio;
    }
    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }
    public String getCiudad() {
        return ciudad;
    }
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public String getMotivo() {
        return motivo;
    }
    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }
    public String getHomenajeado() {
        return homenajeado;
    }
    public void setHomenajeado(String homenajeado) {
        this.homenajeado = homenajeado;
    }
    public String getParentezco() {
        return parentezco;
    }
    public void setParentezco(String parentezco) {
        this.parentezco = parentezco;
    }
    public String getQuien() {
        return quien;
    }
    public void setQuien(String quien) {
        this.quien = quien;
    }
    public String getObsequio() {
        return obsequio;
    }
    public void setObsequio(String obsequio) {
        this.obsequio = obsequio;
    }
    public String getPrecioVenta() {
        return precioVenta;
    }
    public void setPrecioVenta(String precioVenta) {
        this.precioVenta = precioVenta;
    }
    public String getSonido() {
        return sonido;
    }
    public void setSonido(String sonido) {
        this.sonido = sonido;
    }
    public String getPreObsequio() {
        return preObsequio;
    }
    public void setPreObsequio(String preObsequio) {
        this.preObsequio = preObsequio;
    }
    public String getCantMusico() {
        return cantMusico;
    }
    public void setCantMusico(String cantMusico) {
        this.cantMusico = cantMusico;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public String getTransporte() {
        return transporte;
    }
    public void setTransporte(String transporte) {
        this.transporte = transporte;
    }
    public String getTotalCotizacion() {
        return totalCotizacion;
    }
    public void setTotalCotizacion(String totalCotizacion) {
        this.totalCotizacion = totalCotizacion;
    }
    public String getHora() {
        return hora;
    }
    public void setHora(String hora) {
        this.hora = hora;
    }



    


}
