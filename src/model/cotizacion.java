package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;

import connection.Connect;
import controller.ContabilidadRegistrosController;


public class cotizacion extends ContabilidadRegistrosController{

    private String fechaCotizacion;
    private String idCliente;
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


    
    public cotizacion(String fechaCotizacion, String idCliente, String nombreCliente, String emailCliente,
            String wtCliente, String telDosClie, String telUnoClie, String barrio, String ciudad, String direccion,
            String motivo, String homenajeado, String parentezco, String quien, String obsequio, String precioVenta,
            String sonido, String preObsequio, String cantMusico,String estado,String transporte) {
        this.fechaCotizacion = fechaCotizacion;
        this.idCliente = idCliente;
        this.nombreCliente = nombreCliente;
        this.emailCliente = emailCliente;
        this.wtCliente = wtCliente;
        this.telDosClie = telDosClie;
        this.telUnoClie = telUnoClie;
        this.barrio = barrio;
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.motivo = motivo;
        this.homenajeado = homenajeado;
        this.parentezco = parentezco;
        this.quien = quien;
        this.obsequio = obsequio;
        this.precioVenta = precioVenta;
        this.sonido = sonido;
        this.preObsequio = preObsequio;
        this.cantMusico = cantMusico;
        this.estado = estado;
        this.transporte = transporte;
    }


    public void cargaCotizacion(){
      
          
                                                                                                                                                  
        String cadenaSQL = "INSERT INTO cotizacion (CotIdCliente,CotFechaCotizacion,CotBarrio,CotCiudad,CotDireccion,CotMotivo,CotHomenajeado,CotParentezco,CotQuienObsequia,CotObsequio,CotPrecioVenta,CotSonido,CotPrecioObsequio,CotCantidadMusicos,CotEstado,CotTransporte) VALUES(" + idCliente + ","+fechaCotizacion+","+barrio+","+ciudad+","+direccion+","+motivo+","+homenajeado+" ,"+parentezco+","+quien+","+obsequio+","+precioVenta+","+sonido+","+preObsequio+","+cantMusico+", "+estado+" , "+transporte+")";
          
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










    public String getTransporte() {
        return transporte;
    }


    public void setTransporte(String transporte) {
        this.transporte = transporte;
    }


    public String getEmailCliente() {
        return emailCliente;
    }


    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }


    public String getEstado() {
        return estado;
    }


    public void setEstado(String estado) {
        this.estado = estado;
    }


    public String getFechaCotizacion() {
        return fechaCotizacion;
    }
    public void setFechaCotizacion(String fechaCotizacion) {
        this.fechaCotizacion = fechaCotizacion;
    }
    public String getIdCliente() {
        return idCliente;
    }
    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }
    public String getNombreCliente() {
        return nombreCliente;
    }
    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }
    public String getEmailClienet() {
        return emailCliente;
    }
    public void setEmailClienet(String emailCliente) {
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





    




    
}
