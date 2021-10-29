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




public class pdfNomina {

 
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
    private String nomEmpleado;
    private String cedulaEmpleado;




 

    public pdfNomina(String factura, String idEmpleado, String serenatas, String vNomina, String pension, String salud,
            String descuentos, String ahorros, String cultural, String fechaPago, String metodoPago,
            String totalLiquidar, String nomEmpleado, String cedulaEmpleado) {
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
        this.nomEmpleado = nomEmpleado;
        this.cedulaEmpleado = cedulaEmpleado;
    }




    public void  imprimirCertificado() throws FileNotFoundException, DocumentException{


        LocalDate hoy = LocalDate.now();
                
            
        FileOutputStream archivo = new FileOutputStream("C:/Users/Gabokeybass/Desktop/Documentos/" + nomEmpleado + ".pdf");
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
                        
        
     
    

        Paragraph parrafo1= new Paragraph("Comprobante de pago:                      Fecha: "+ hoy);
        parrafo1.setAlignment(1);                     
        Paragraph parrafo2= new Paragraph("______________________________________________________________________________"); 
        Paragraph parrafo3= new Paragraph("Empleado:" + nomEmpleado+ "                                    Documento de identidad: " + cedulaEmpleado );
        Paragraph parrafo4= new Paragraph("Ciudad:      Barranquilla                                                        Telefono: 3016013248                  Direccion: Calle 46 # 6 c sur"    ); 
        Paragraph parrafo5= new Paragraph("______________________________________________________________________________"); 
        Paragraph parrafo6= new Paragraph("__________________________" +  "                                   ____________________________"); 
        Paragraph parrafo7= new Paragraph("Richard Lindarte Antolinez" +  "                                             " + nomEmpleado );        
        Paragraph parrafo8= new Paragraph("Nit. 1143122047-1 "  +  "                                                        " + cedulaEmpleado);  
       
        
        documento.add(parrafo1);
        documento.add(parrafo2);                
        documento.add(parrafo3);  
        documento.add(parrafo4);
        documento.add(parrafo5);  
        
        documento.add(new Paragraph("\n"));
        documento.add(new Paragraph("\n"));
       

        
        
                      
             
        PdfPTable tabla = new PdfPTable(7);
        tabla.setWidthPercentage(100);
        PdfPCell cantSerenatas = new PdfPCell(new Phrase("Cantidad de serenatas"));
        cantSerenatas.setBackgroundColor(BaseColor.ORANGE);
        
        PdfPCell ValorNomina = new PdfPCell(new Phrase("Valor de la nomina"));
        ValorNomina.setBackgroundColor(BaseColor.ORANGE);
        PdfPCell vPension = new PdfPCell(new Phrase("Pension"));
        vPension.setBackgroundColor(BaseColor.ORANGE);
        PdfPCell vSalud = new PdfPCell(new Phrase("Salud"));
        vSalud.setBackgroundColor(BaseColor.ORANGE);
        PdfPCell vDescuento = new PdfPCell(new Phrase("Descuentos"));
        vDescuento.setBackgroundColor(BaseColor.ORANGE);
        PdfPCell vAhorro = new PdfPCell(new Phrase("Ahorros"));
        vAhorro.setBackgroundColor(BaseColor.ORANGE);
        PdfPCell vCultural = new PdfPCell(new Phrase("Cultural"));
        vCultural.setBackgroundColor(BaseColor.ORANGE);
         
        tabla.addCell(cantSerenatas);
        tabla.addCell(ValorNomina);
        tabla.addCell(vPension);
        tabla.addCell(vSalud);
        tabla.addCell(vDescuento);
        tabla.addCell(vAhorro);
        tabla.addCell(vCultural);

       
     
        

        tabla.addCell((serenatas));
        tabla.addCell(vNomina);
        tabla.addCell(pension);
        tabla.addCell(salud);
        tabla.addCell(descuentos);
        tabla.addCell(ahorros);
        tabla.addCell(cultural);

        documento.add(tabla);
        documento.add(new Paragraph("\n"));
        documento.add(new Paragraph("\n"));
        documento.add(new Paragraph("\n"));
        documento.add(new Paragraph("\n"));
        

        documento.add(parrafo6);  
        documento.add(parrafo7);
        documento.add(parrafo8);       
            
                
        documento.close();

        File path = new File("C:/Users/Gabokeybass/Desktop/Documentos/" + nomEmpleado + ".pdf");
        try {
            Desktop.getDesktop().open(path);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println("Documento impreso");
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




    public String getNomEmpleado() {
        return nomEmpleado;
    }




    public void setNomEmpleado(String nomEmpleado) {
        this.nomEmpleado = nomEmpleado;
    }




    public String getCedulaEmpleado() {
        return cedulaEmpleado;
    }




    public void setCedulaEmpleado(String cedulaEmpleado) {
        this.cedulaEmpleado = cedulaEmpleado;
    }


 

   

    
}





    

