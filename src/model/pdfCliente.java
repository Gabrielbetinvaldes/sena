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
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Image;

import java.awt.Desktop;




public class pdfCliente {

 
    private String  nomCliente;
    private String  docCliente;
    private String  emailCliente;
    private String  telUnoClie;
    private String  telDosClie;
    private String  wtCliente;
    private String  refCliente;
    private String  idCliente;
   

   

    public pdfCliente(String nomCliente, String docCliente, String emailCliente, String telUnoClie, String telDosClie,
            String wtCliente, String refCliente, String idCliente) {
        this.nomCliente = nomCliente;
        this.docCliente = docCliente;
        this.emailCliente = emailCliente;
        this.telUnoClie = telUnoClie;
        this.telDosClie = telDosClie;
        this.wtCliente = wtCliente;
        this.refCliente = refCliente;
        this.idCliente = idCliente;
    }







    public void  imprimirCertificado() throws FileNotFoundException, DocumentException{

        LocalDate hoy = LocalDate.now();
       
                
            
        FileOutputStream archivo = new FileOutputStream("C:/Users/Gabokeybass/Desktop/Documentos/" + nomCliente + ".pdf");
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
        Paragraph parrafo2= new Paragraph("El señor(a) " + nomCliente +" identificado(a) con Cedula de Ciudadanía N° " + docCliente + " de Barranquilla (Atlántico)," + "mantiene relaciones comerciales con nostros, las cuales ha cumplido con sus pagos  de una forma resposanble y puntual  pudiendole recomendar ampliamente " +"\n");
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

        File path = new File("C:/Users/Gabokeybass/Desktop/Documentos/" + nomCliente + ".pdf");
        try {
            Desktop.getDesktop().open(path);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println("Documento impreso");
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







    public String getIdCliente() {
        return idCliente;
    }







    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }    


 

   

    
}





    

