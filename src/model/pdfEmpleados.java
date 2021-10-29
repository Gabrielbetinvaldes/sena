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

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Image;

import java.awt.Desktop;




public class pdfEmpleados {

    private String nombre;
    private String cedula;
    private String inicio;
    private String cargo;
    private LocalDate hoy;





    public pdfEmpleados(String nombre, String cedula, String inicio, String cargo, LocalDate hoy) {
            this.nombre = nombre;
            this.cedula = cedula;
            this.inicio = inicio;
            this.cargo = cargo;
            this.hoy = hoy;
        }

 

    public void  imprimirCertificado() throws FileNotFoundException, DocumentException{


        
                
            
        FileOutputStream archivo = new FileOutputStream("C:/Users/Gabokeybass/Desktop/Documentos/" + nombre + ".pdf");
        Document documento = new Document();
        PdfWriter.getInstance(documento, archivo);
        documento.open();
        
        Image image = null;
            try {
                image =  Image.getInstance("D:/GABO MUSIC/ADSI/MARIACHI/MariachiPasionMexicana/MPM/src/view/imagenes/Sin título-1.png");//carga imagen
            // image.scaleAbsolute(150, 150);//cambia tamaño
                image.setAbsolutePosition(180, 720);//coloca imagen en la posicion
            } catch (Exception e) {
                e.printStackTrace();
            }
            documento.add(image);//agrega la imagen al documento           
                        
        
        documento.add(new Paragraph("\n"));
        documento.add(new Paragraph("\n"));
        documento.add(new Paragraph("\n"));
        documento.add(new Paragraph("\n"));
        documento.add(new Paragraph("\n"));
        documento.add(new Paragraph("\n"));
        documento.add(new Paragraph("\n"));
        documento.add(new Paragraph("\n"));
        documento.add(new Paragraph("\n"));
        documento.add(new Paragraph("\n"));
        
    

        Paragraph parrafo1= new Paragraph("CERTIFICA QUE:" + "\n");
        parrafo1.setAlignment(1);       
        Paragraph parrafo2= new Paragraph("El señor(a) " + nombre +" identificado(a) con Cedula de Ciudadanía N° " + cedula + " de Barranquilla (Atlántico), se encuentra laborando desde el" + inicio + ", desempeñándose el cargo de ejecucion de" + cargo +", con un contrato de prestación de servicios." +  "\n");
        Paragraph parrafo3= new Paragraph("En constancia de lo antes mencionado se expide la presente petición a solicitud de la parte interesada en la fecha del: " + hoy +  "\n"); 
        Paragraph parrafo4= new Paragraph("Atentamente"  +  "\n"); 
        Paragraph parrafo5= new Paragraph("__________________________" +  "\n"); 
        Paragraph parrafo6= new Paragraph("Richard Lindarte Antolinez" +  "\n"); 
        Paragraph parrafo7= new Paragraph("Representante Legal"  +  "\n"); 
        Paragraph parrafo8= new Paragraph("Nit. 1143122047-1 "  +  "\n"); 
        
        documento.add(parrafo1);
        documento.add(new Paragraph("\n"));
        documento.add(new Paragraph("\n"));
                
        documento.add(parrafo2);
        documento.add(new Paragraph("\n"));
        documento.add(new Paragraph("\n"));
    
        
        documento.add(parrafo3);

        documento.add(new Paragraph("\n"));
        documento.add(new Paragraph("\n"));
        documento.add(new Paragraph("\n"));
        documento.add(new Paragraph("\n"));

        documento.add(parrafo4);        


        documento.add(new Paragraph("\n"));
        documento.add(new Paragraph("\n"));
        documento.add(new Paragraph("\n"));
        documento.add(new Paragraph("\n"));
        
        documento.add(parrafo5);        
        documento.add(parrafo6);        
        documento.add(parrafo7);        
        documento.add(parrafo8);        
        

        
        
        documento.close();

        File path = new File("C:/Users/Gabokeybass/Desktop/Documentos/" + nombre + ".pdf");
        try {
            Desktop.getDesktop().open(path);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println("Documento impreso");
    }


 

    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getCedula() {
        return cedula;
    }


    public void setCedula(String cedula) {
        this.cedula = cedula;
    }


    public String getInicio() {
        return inicio;
    }


    public void setInicio(String inicio) {
        this.inicio = inicio;
    }


    public String getCargo() {
        return cargo;
    }


    public void setCargo(String cargo) {
        this.cargo = cargo;
    }


    public LocalDate getHoy() {
        return hoy;
    }


    public void setHoy(LocalDate hoy) {
        this.hoy = hoy;
    }


    
}





    

