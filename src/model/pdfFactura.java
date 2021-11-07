package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.swing.JEditorPane;
import javax.swing.JFileChooser;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import javafx.util.StringConverter;

import com.itextpdf.text.Image;

import java.awt.Desktop;




public class pdfFactura{

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
    private String totalCotizacion;
    private String idCotizacion;
    private String hora;
    private String idFactura;

    
    public pdfFactura(String fechaCotizacion, String idCliente, String nombreCliente, String emailCliente,
            String wtCliente, String telDosClie, String telUnoClie, String barrio, String ciudad, String direccion,
            String motivo, String homenajeado, String parentezco, String quien, String obsequio, String precioVenta,
            String sonido, String preObsequio, String cantMusico, String estado, String transporte,
            String totalCotizacion,String idCotizacion, String hora, String idFactura) {
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
        this.totalCotizacion = totalCotizacion;
        this.idCotizacion = idCotizacion;
        this.hora = hora;
        this.idFactura = idFactura;
    }



    public void  imprimirCertificado() throws FileNotFoundException, DocumentException{

        LocalDate hoy = LocalDate.now();
        
               
            
        FileOutputStream archivo = new FileOutputStream("C:/Users/Gabokeybass/Desktop/Documentos/" + idFactura + ".pdf");
        Document documento = new Document();
        PdfWriter.getInstance(documento, archivo);
        documento.open();
        
        Image image = null;
            try {
                image =  Image.getInstance("D:/GABO MUSIC/ADSI/MARIACHI/MariachiPasionMexicana/MPM/src/view/imagenes/Sin título-1.png");//carga imagen
                image.scaleAbsolute(80, 80);//cambia tamaño
                image.setAbsolutePosition(40,770 );//coloca imagen en la posicion
            } catch (Exception e) {
                e.printStackTrace();
            }
            documento.add(image);//agrega la imagen al documento    
            
            Font fuente2= new Font();
            fuente2.setSize(10); 
            fuente2.setColor(255,255,255); 


            Font fuente3= new Font();
            fuente3.setSize(10);
             
            
            Paragraph parrafo1= new Paragraph("                                                Factura No " +  idFactura +                     "                                        Fecha: "+ hoy);
            parrafo1.setAlignment(1); 
             
            
            Paragraph parrafo2= new Paragraph("______________________________________________________________________________"); 
            Paragraph parrafo3= new Paragraph("Proveedor: Mariachi Pasion Mexicana                                                                             Nit:                1143122047-1  ",fuente3);
            Paragraph parrafo4= new Paragraph("Ciudad:      Barranquilla                                                                                                    Telefono:          3016013248", fuente3    );
            Paragraph parrafo5= new Paragraph("Email:        gerenciaBquilla@mariachipasionmexicana.co                                               Direccion: Calle 46 # 6 c sur " ,fuente3   );  
            Paragraph parrafo6= new Paragraph("______________________________________________________________________________"); 
     

            documento.add(parrafo1);
            documento.add(parrafo2);                
            documento.add(parrafo3);  
            documento.add(parrafo4);
            documento.add(parrafo5);  
            documento.add(parrafo6);
            documento.add(new Paragraph("\n"));
            documento.add(new Paragraph("\n"));
            

            
            
            Font fuente= new Font();
            fuente.setSize(8);
            
                 
               
                 
        PdfPTable tablaDatosCliente = new PdfPTable(6);
        tablaDatosCliente.setWidthPercentage(100);

        PdfPCell clienteId = new PdfPCell(new Phrase("Id del cliente", fuente2));
        clienteId.setBackgroundColor(BaseColor.RED);  
        clienteId.setBorder(PdfPCell.NO_BORDER);      
        PdfPCell clienteNombre= new PdfPCell(new Phrase("Nombres del cliente", fuente2));
        clienteNombre.setBackgroundColor(BaseColor.RED);
        clienteNombre.setBorder(PdfPCell.NO_BORDER); 
        PdfPCell clienteEmail = new PdfPCell(new Phrase("Email ", fuente2));
        clienteEmail.setBackgroundColor(BaseColor.RED);
        clienteEmail.setBorder(PdfPCell.NO_BORDER); 
        PdfPCell telefonoCliente= new PdfPCell(new Phrase("Telefono", fuente2));
        telefonoCliente.setBackgroundColor(BaseColor.RED);
        telefonoCliente.setBorder(PdfPCell.NO_BORDER); 
        PdfPCell clienteCelular = new PdfPCell(new Phrase("Celular", fuente2));
        clienteCelular.setBackgroundColor(BaseColor.RED);
        clienteCelular.setBorder(PdfPCell.NO_BORDER); 
        PdfPCell clienteWt = new PdfPCell(new Phrase("Whatsapp", fuente2));
        clienteWt.setBackgroundColor(BaseColor.RED);
        clienteWt.setBorder(PdfPCell.NO_BORDER); 
      
       
         
        tablaDatosCliente.addCell(clienteId);
        tablaDatosCliente.addCell(clienteNombre);
        tablaDatosCliente.addCell(clienteEmail);
        tablaDatosCliente.addCell(telefonoCliente);
        tablaDatosCliente.addCell(clienteCelular);
        tablaDatosCliente.addCell(clienteWt);

           

        PdfPCell clienteId2 = new PdfPCell(new Phrase(idCliente, fuente));        
        clienteId2.setBorder(PdfPCell.NO_BORDER);           
        PdfPCell clienteNombre2= new PdfPCell(new Phrase(nombreCliente, fuente));        
        clienteNombre2.setBorder(PdfPCell.NO_BORDER); 
        PdfPCell clienteEmail2 = new PdfPCell(new Phrase(emailCliente, fuente));        
        clienteEmail2.setBorder(PdfPCell.NO_BORDER); 
        PdfPCell telefonoCliente2= new PdfPCell(new Phrase(telUnoClie,fuente));        
        telefonoCliente2.setBorder(PdfPCell.NO_BORDER); 
        PdfPCell clienteCelular2 = new PdfPCell(new Phrase(telDosClie,fuente));       
        clienteCelular2.setBorder(PdfPCell.NO_BORDER); 
        PdfPCell clienteWt2 = new PdfPCell(new Phrase(wtCliente,fuente));        
        clienteWt2.setBorder(PdfPCell.NO_BORDER); 
        PdfPCell identado= new PdfPCell(new Phrase("\n"));        
        identado.setBorder(PdfPCell.NO_BORDER);


        tablaDatosCliente.addCell(clienteId2);
        tablaDatosCliente.addCell(clienteNombre2);
        tablaDatosCliente.addCell(clienteEmail2);
        tablaDatosCliente.addCell(telefonoCliente2);
        tablaDatosCliente.addCell(clienteCelular2);
        tablaDatosCliente.addCell(clienteWt2);
       
       
        tablaDatosCliente.addCell(identado);
        tablaDatosCliente.addCell(identado);
        tablaDatosCliente.addCell(identado);
        tablaDatosCliente.addCell(identado);
        tablaDatosCliente.addCell(identado);
        tablaDatosCliente.addCell(identado);
        tablaDatosCliente.addCell(identado);
        tablaDatosCliente.addCell(identado);
        tablaDatosCliente.addCell(identado);
        tablaDatosCliente.addCell(identado);
     
        
       

        
      
        PdfPTable tablaDatosSerenata = new PdfPTable(9);
        tablaDatosSerenata.setWidthPercentage(100);

        PdfPCell celdaCiudad= new PdfPCell(new Phrase("Ciudad", fuente2));
        celdaCiudad.setBackgroundColor(BaseColor.RED);  
        celdaCiudad.setBorder(PdfPCell.NO_BORDER);      
        PdfPCell celdaBarrio= new PdfPCell(new Phrase("Barrio", fuente2));
        celdaBarrio.setBackgroundColor(BaseColor.RED);
        celdaBarrio.setBorder(PdfPCell.NO_BORDER); 
        PdfPCell celdaDireccion = new PdfPCell(new Phrase("Direccion ", fuente2));
        celdaDireccion.setBackgroundColor(BaseColor.RED);
        celdaDireccion.setBorder(PdfPCell.NO_BORDER); 
        PdfPCell celdaHomenajeada= new PdfPCell(new Phrase("Homenajeado(a)", fuente2));
        celdaHomenajeada.setBackgroundColor(BaseColor.RED);
        celdaHomenajeada.setBorder(PdfPCell.NO_BORDER); 
        PdfPCell celdaFecha1 = new PdfPCell(new Phrase("Fecha", fuente2));
        celdaFecha1.setBackgroundColor(BaseColor.RED);
        celdaFecha1.setBorder(PdfPCell.NO_BORDER);
        PdfPCell celdaHora = new PdfPCell(new Phrase("Hora", fuente2));
        celdaHora.setBackgroundColor(BaseColor.RED);
        celdaHora.setBorder(PdfPCell.NO_BORDER); 
        PdfPCell celdaQuien = new PdfPCell(new Phrase("Responsable", fuente2));
        celdaQuien.setBackgroundColor(BaseColor.RED);
        celdaQuien.setBorder(PdfPCell.NO_BORDER); 
        PdfPCell celdaMotivo = new PdfPCell(new Phrase("Motivo", fuente2));
        celdaMotivo.setBackgroundColor(BaseColor.RED);
        celdaMotivo.setBorder(PdfPCell.NO_BORDER); 
        PdfPCell celdaCotizacion = new PdfPCell(new Phrase("Cotizacion", fuente2));
        celdaCotizacion.setBackgroundColor(BaseColor.RED);
        celdaCotizacion.setBorder(PdfPCell.NO_BORDER); 
        

        
       
         
        tablaDatosSerenata.addCell(celdaCiudad);
        tablaDatosSerenata.addCell(celdaBarrio);
        tablaDatosSerenata.addCell(celdaDireccion );
        tablaDatosSerenata.addCell(celdaHomenajeada);
        tablaDatosSerenata.addCell(celdaFecha1 );
        tablaDatosSerenata.addCell(celdaHora );
        tablaDatosSerenata.addCell(celdaQuien);
        tablaDatosSerenata.addCell(celdaMotivo);
        tablaDatosSerenata.addCell(celdaCotizacion);

        

        PdfPCell celdaCiudad2 = new PdfPCell(new Phrase(ciudad, fuente));        
        celdaCiudad2.setBorder(PdfPCell.NO_BORDER);           
        PdfPCell celdaBarrio2= new PdfPCell(new Phrase(barrio, fuente));        
        celdaBarrio2.setBorder(PdfPCell.NO_BORDER); 
        PdfPCell celdaDireccion2 = new PdfPCell(new Phrase(direccion, fuente));        
        celdaDireccion2.setBorder(PdfPCell.NO_BORDER); 
        PdfPCell celdaHomenajeada2= new PdfPCell(new Phrase(homenajeado,fuente));        
        celdaHomenajeada2.setBorder(PdfPCell.NO_BORDER); 
        PdfPCell celdaFecha = new PdfPCell(new Phrase(fechaCotizacion,fuente));        
        celdaFecha.setBorder(PdfPCell.NO_BORDER); 
        PdfPCell celdaHora2 = new PdfPCell(new Phrase(hora,fuente));       
        celdaHora2.setBorder(PdfPCell.NO_BORDER); 
        PdfPCell celdaQuien2= new PdfPCell(new Phrase(quien,fuente));        
        celdaQuien2.setBorder(PdfPCell.NO_BORDER);
        PdfPCell celdaMotivo2 = new PdfPCell(new Phrase(motivo, fuente));
        celdaMotivo2.setBorder(PdfPCell.NO_BORDER);  
        PdfPCell celdaCotizacion2 = new PdfPCell(new Phrase(idCotizacion, fuente));
        celdaCotizacion2 .setBorder(PdfPCell.NO_BORDER); 

        
        tablaDatosSerenata.addCell(celdaCiudad2);
        tablaDatosSerenata.addCell(celdaBarrio2);
        tablaDatosSerenata.addCell(celdaDireccion2);
        tablaDatosSerenata.addCell(celdaHomenajeada2);
        tablaDatosSerenata.addCell(celdaFecha);
        tablaDatosSerenata.addCell(celdaHora2);
        tablaDatosSerenata.addCell(celdaQuien2);
        tablaDatosSerenata.addCell(celdaMotivo2);
        tablaDatosSerenata.addCell(celdaCotizacion2 );

        tablaDatosSerenata.addCell(identado);
        tablaDatosSerenata.addCell(identado);
        tablaDatosSerenata.addCell(identado);
        tablaDatosSerenata.addCell(identado);
        tablaDatosSerenata.addCell(identado);
        tablaDatosSerenata.addCell(identado);
        tablaDatosSerenata.addCell(identado);
        tablaDatosSerenata.addCell(identado);
        tablaDatosSerenata.addCell(identado);
        tablaDatosSerenata.addCell(identado);
        tablaDatosSerenata.addCell(identado);
        tablaDatosSerenata.addCell(identado);
        tablaDatosSerenata.addCell(identado);
        tablaDatosSerenata.addCell(identado);
        tablaDatosSerenata.addCell(identado);
        tablaDatosSerenata.addCell(identado);
        tablaDatosSerenata.addCell(identado);

        PdfPTable tablaCostosSerenata = new PdfPTable(2);
        tablaCostosSerenata.setWidthPercentage(100);

        PdfPCell celdaConcepto= new PdfPCell(new Phrase("Concepto", fuente2));
        celdaConcepto.setBackgroundColor(BaseColor.RED);  
        celdaConcepto.setBorder(PdfPCell.NO_BORDER);      
        PdfPCell celdaValor= new PdfPCell(new Phrase("Valor", fuente2));
        celdaValor.setBackgroundColor(BaseColor.RED);
        celdaValor.setBorder(PdfPCell.NO_BORDER); 
        

        tablaCostosSerenata.addCell(celdaConcepto);
        tablaCostosSerenata.addCell(celdaValor);

        PdfPCell celdaConcepto1 = new PdfPCell(new Phrase("Precio de Venta" , fuente));        
        celdaConcepto1.setBorder(PdfPCell.NO_BORDER);           
        PdfPCell celdaValor1 = new PdfPCell(new Phrase(precioVenta, fuente));        
        celdaValor1.setBorder(PdfPCell.NO_BORDER); 
        PdfPCell celdaConcepto2 = new PdfPCell(new Phrase("Transporte", fuente));        
        celdaConcepto2.setBorder(PdfPCell.NO_BORDER);           
        PdfPCell celdaValor2 = new PdfPCell(new Phrase(transporte, fuente));        
        celdaValor2.setBorder(PdfPCell.NO_BORDER); 
        PdfPCell celdaConcepto3 = new PdfPCell(new Phrase("Sonido", fuente));        
        celdaConcepto3.setBorder(PdfPCell.NO_BORDER);           
        PdfPCell celdaValor3 = new PdfPCell(new Phrase(sonido, fuente));        
        celdaValor3.setBorder(PdfPCell.NO_BORDER); 
        PdfPCell celdaConcepto4 = new PdfPCell(new Phrase(obsequio, fuente));        
        celdaConcepto4.setBorder(PdfPCell.NO_BORDER);           
        PdfPCell celdaValor4 = new PdfPCell(new Phrase(preObsequio, fuente));        
        celdaValor4.setBorder(PdfPCell.NO_BORDER); 




        
        
        tablaCostosSerenata.addCell(celdaConcepto1);        
        tablaCostosSerenata.addCell(celdaValor1);
        tablaCostosSerenata.addCell(identado);
        tablaCostosSerenata.addCell(identado);
        tablaCostosSerenata.addCell(celdaConcepto2);        
        tablaCostosSerenata.addCell(celdaValor2);
        tablaCostosSerenata.addCell(identado);
        tablaCostosSerenata.addCell(identado);
        tablaCostosSerenata.addCell(celdaConcepto3);        
        tablaCostosSerenata.addCell(celdaValor3);
        tablaCostosSerenata.addCell(identado);
        tablaCostosSerenata.addCell(identado);
        tablaCostosSerenata.addCell(celdaConcepto4);        
        tablaCostosSerenata.addCell(celdaValor4);
        tablaCostosSerenata.addCell(identado);
        tablaCostosSerenata.addCell(identado);
       

      


        PdfPTable tablaTotalSerenata = new PdfPTable(2);
        tablaTotalSerenata.setWidthPercentage(100);

        PdfPCell celdaTotales= new PdfPCell(new Phrase("TOTAL", fuente3));
        celdaTotales.setBackgroundColor(BaseColor.ORANGE);  
        celdaTotales.setBorder(PdfPCell.NO_BORDER);      
        PdfPCell celdaValorTotales= new PdfPCell(new Phrase(totalCotizacion, fuente3));
        celdaValorTotales.setBackgroundColor(BaseColor.ORANGE);
        celdaValorTotales.setBorder(PdfPCell.NO_BORDER); 
        

        tablaTotalSerenata.addCell(celdaTotales);
        tablaTotalSerenata.addCell(celdaValorTotales);
       
       
        Paragraph parrafo7= new Paragraph("                                                                DATOS DEL CLIENTE"); 
        documento.add(parrafo7);
        parrafo7.setAlignment(1); 
        documento.add(new Paragraph("\n"));
        
               
        documento.add(tablaDatosCliente);  
        
        Paragraph parrafo8= new Paragraph("                                                                DATOS DE LA SERENATA"); 
        documento.add(parrafo8);
        parrafo8.setAlignment(1); 
        documento.add(new Paragraph("\n"));
                
        
        documento.add(tablaDatosSerenata);   
        
        
        
        Paragraph parrafo9= new Paragraph("                                                                 COSTOS DEL SERVICIO"); 
        documento.add(parrafo9);
        parrafo9.setAlignment(1);
        documento.add(new Paragraph("\n"));    

        documento.add(tablaCostosSerenata);   
        
        

       


        documento.add(tablaTotalSerenata);     

        Paragraph parrafo10= new Paragraph("__________________________" +  "\n"); 
        Paragraph parrafo11= new Paragraph("Richard Lindarte Antolinez" +  "\n"); 
        Paragraph parrafo12= new Paragraph("Representante Legal"  +  "\n"); 
        Paragraph parrafo13= new Paragraph("Nit. 1143122047-1 "  +  "\n"); 

       

        documento.add(new Paragraph("\n")); 
        documento.add(new Paragraph("\n")); 
        documento.add(new Paragraph("\n")); 
        documento.add(new Paragraph("\n")); 
       

        documento.add(parrafo10);
        documento.add(parrafo11);
        documento.add(parrafo12);
        documento.add(parrafo13);



            documento.close();

            File path = new File("C:/Users/Gabokeybass/Desktop/Documentos/" +  idFactura + ".pdf");
            try {
                Desktop.getDesktop().open(path);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
    
            System.out.println("Documento impreso");

    }




    public String getIdFactura() {
        return idFactura;
    }



    public void setIdFactura(String idFactura) {
        this.idFactura = idFactura;
    }



    public String getHora() {
        return hora;
    }



    public void setHora(String hora) {
        this.hora = hora;
    }



    public String getIdCotizacion() {
        return idCotizacion;
    }



    public void setIdCotizacion(String idCotizacion) {
        this.idCotizacion = idCotizacion;
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






















    
   

    
}





    

