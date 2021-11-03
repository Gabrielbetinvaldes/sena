package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import javax.swing.JEditorPane;
import javax.swing.JFileChooser;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Image;

import java.awt.Desktop;




public class pdfCotizacion {

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

    
    public pdfCotizacion(String fechaCotizacion, String idCliente, String nombreCliente, String emailCliente,
            String wtCliente, String telDosClie, String telUnoClie, String barrio, String ciudad, String direccion,
            String motivo, String homenajeado, String parentezco, String quien, String obsequio, String precioVenta,
            String sonido, String preObsequio, String cantMusico, String estado, String transporte,
            String totalCotizacion,String idCotizacion) {
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
    }



    public void  imprimirCertificado() throws FileNotFoundException, DocumentException{

        LocalDate hoy = LocalDate.now();
                
            
        FileOutputStream archivo = new FileOutputStream("C:/Users/Gabokeybass/Desktop/Documentos/" + idCotizacion + ".pdf");
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
            
            Paragraph parrafo1= new Paragraph("                                                Cotizacion No " +  idCotizacion +                    "                                        Fecha: "+ hoy);
            parrafo1.setAlignment(1); 
             
            
            Paragraph parrafo2= new Paragraph("______________________________________________________________________________"); 
            Paragraph parrafo3= new Paragraph("Proveedor: Mariachi Pasion Mexicana                                               Nit:                1143122047-1  ",fuente2);
            Paragraph parrafo4= new Paragraph("Ciudad:      Barranquilla                                                                      Telefono:          3016013248", fuente2    );
            Paragraph parrafo5= new Paragraph("Email:        gerenciaBquilla@mariachipasionmexicana.co                 Direccion: Calle 46 # 6 c sur " ,fuente2   );  
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
        clienteId.setBackgroundColor(BaseColor.ORANGE);  
        clienteId.setBorder(PdfPCell.NO_BORDER);      
        PdfPCell clienteNombre= new PdfPCell(new Phrase("Nombres del cliente", fuente2));
        clienteNombre.setBackgroundColor(BaseColor.ORANGE);
        clienteNombre.setBorder(PdfPCell.NO_BORDER); 
        PdfPCell clienteEmail = new PdfPCell(new Phrase("Email ", fuente2));
        clienteEmail.setBackgroundColor(BaseColor.ORANGE);
        clienteEmail.setBorder(PdfPCell.NO_BORDER); 
        PdfPCell telefonoCliente= new PdfPCell(new Phrase("Telefono", fuente2));
        telefonoCliente.setBackgroundColor(BaseColor.ORANGE);
        telefonoCliente.setBorder(PdfPCell.NO_BORDER); 
        PdfPCell clienteCelular = new PdfPCell(new Phrase("Celular", fuente2));
        clienteCelular.setBackgroundColor(BaseColor.ORANGE);
        clienteCelular.setBorder(PdfPCell.NO_BORDER); 
        PdfPCell clienteWt = new PdfPCell(new Phrase("Whatsapp", fuente2));
        clienteWt.setBackgroundColor(BaseColor.ORANGE);
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
        tablaDatosCliente.addCell(identado);
        tablaDatosCliente.addCell(identado);
        tablaDatosCliente.addCell(identado);
        tablaDatosCliente.addCell(identado);
        tablaDatosCliente.addCell(identado);
        tablaDatosCliente.addCell(identado);
        tablaDatosCliente.addCell(identado);
        tablaDatosCliente.addCell(identado);

        
       

        PdfPTable tablaDatosSerenata = new PdfPTable(7);
        tablaDatosSerenata.setWidthPercentage(100);

        PdfPCell celdaCiudad= new PdfPCell(new Phrase("Ciudad", fuente2));
        celdaCiudad.setBackgroundColor(BaseColor.ORANGE);  
        celdaCiudad.setBorder(PdfPCell.NO_BORDER);      
        PdfPCell celdaBarrio= new PdfPCell(new Phrase("Barrio", fuente2));
        celdaBarrio.setBackgroundColor(BaseColor.ORANGE);
        celdaBarrio.setBorder(PdfPCell.NO_BORDER); 
        PdfPCell celdaDireccion = new PdfPCell(new Phrase("Direccion ", fuente2));
        celdaDireccion.setBackgroundColor(BaseColor.ORANGE);
        celdaDireccion.setBorder(PdfPCell.NO_BORDER); 
        PdfPCell celdaHomenajeada= new PdfPCell(new Phrase("Homenajeado(a)", fuente2));
        celdaHomenajeada.setBackgroundColor(BaseColor.ORANGE);
        celdaHomenajeada.setBorder(PdfPCell.NO_BORDER); 
        PdfPCell celdaHora = new PdfPCell(new Phrase("Hora", fuente2));
        celdaHora.setBackgroundColor(BaseColor.ORANGE);
        celdaHora.setBorder(PdfPCell.NO_BORDER); 
        PdfPCell celdaQuien = new PdfPCell(new Phrase("Responsable", fuente2));
        celdaQuien.setBackgroundColor(BaseColor.ORANGE);
        celdaQuien.setBorder(PdfPCell.NO_BORDER); 
        PdfPCell celdaMotivo = new PdfPCell(new Phrase("Motivo", fuente2));
        celdaMotivo.setBackgroundColor(BaseColor.ORANGE);
        celdaMotivo.setBorder(PdfPCell.NO_BORDER); 

        
       
         
        tablaDatosSerenata.addCell(celdaCiudad);
        tablaDatosSerenata.addCell(celdaBarrio);
        tablaDatosSerenata.addCell(celdaDireccion );
        tablaDatosSerenata.addCell(celdaHomenajeada);
        tablaDatosSerenata.addCell(celdaHora );
        tablaDatosSerenata.addCell(celdaQuien);
        tablaDatosSerenata.addCell(celdaMotivo);

        

        PdfPCell celdaCiudad2 = new PdfPCell(new Phrase(ciudad, fuente));        
        celdaCiudad2.setBorder(PdfPCell.NO_BORDER);           
        PdfPCell celdaBarrio2= new PdfPCell(new Phrase(barrio, fuente));        
        celdaBarrio2.setBorder(PdfPCell.NO_BORDER); 
        PdfPCell celdaDireccion2 = new PdfPCell(new Phrase(direccion, fuente));        
        celdaDireccion2.setBorder(PdfPCell.NO_BORDER); 
        PdfPCell celdaHomenajeada2= new PdfPCell(new Phrase(homenajeado,fuente));        
        celdaHomenajeada2.setBorder(PdfPCell.NO_BORDER); 
        PdfPCell celdaHora2 = new PdfPCell(new Phrase("10:00 AM",fuente));       
        celdaHora2.setBorder(PdfPCell.NO_BORDER); 
        PdfPCell celdaQuien2= new PdfPCell(new Phrase(quien,fuente));        
        celdaQuien2.setBorder(PdfPCell.NO_BORDER);
        PdfPCell celdaMotivo2 = new PdfPCell(new Phrase(motivo, fuente2));
        celdaMotivo2.setBorder(PdfPCell.NO_BORDER);  


        tablaDatosSerenata.addCell(celdaCiudad2);
        tablaDatosSerenata.addCell(celdaBarrio2);
        tablaDatosSerenata.addCell(celdaDireccion2);
        tablaDatosSerenata.addCell(celdaHomenajeada2);
        tablaDatosSerenata.addCell(celdaHora2);
        tablaDatosSerenata.addCell(celdaQuien2);
        tablaDatosSerenata.addCell(celdaMotivo2);



       
       
       
               
        documento.add(tablaDatosCliente);        
        
        documento.add(tablaDatosSerenata);      



            documento.close();

            File path = new File("C:/Users/Gabokeybass/Desktop/Documentos/" +  idCotizacion + ".pdf");
            try {
                Desktop.getDesktop().open(path);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
    
            System.out.println("Documento impreso");

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





    

