package model;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import model.Empleado;
import model.cliente;
import model.cotizacion;
import model.factura;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


import connection.Connect;



import org.apache.log4j.BasicConfigurator;


public class reportes {



public  void  exportarCotizacion() {

        String datos;
        String[] vector;
      
      
        BasicConfigurator.configure();
      
        
        Workbook book = new XSSFWorkbook();
        Sheet sheet = book.createSheet("Cotizaciones");
        

        CellStyle headerStyle = book.createCellStyle();
        headerStyle.setFillForegroundColor(IndexedColors.LIGHT_ORANGE.getIndex());
        headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        headerStyle.setBorderBottom(BorderStyle.THIN);
        headerStyle.setBorderLeft(BorderStyle.THIN);
        headerStyle.setBorderRight(BorderStyle.THIN);
        headerStyle.setBorderBottom(BorderStyle.THIN);

        Font font = book.createFont();
        font.setFontName("Arial");
        font.setBold(true);
        font.setColor(IndexedColors.AUTOMATIC.getIndex());
        font.setFontHeightInPoints((short) 12);
        headerStyle.setFont(font);

        String[] cabecera = new String[]{"Id Cotizacion","Id Cliente","Nombre del cliente","Documento de identidad","Email del cliente",
        "Telefono del cliente","Telefono del cliente","Whatsapp del cliente","Referencias","Barrio","Ciudad",
        "Direccion","Motivo","Homenajeado","Parentezco","Quien obsequia","Obsequio","Precio de venta",
        "Costo del sonido","Costo del obsequio","Costo del transporte","Cantidad de musico","Fecha de cotizacion",
        "Costo total","Hora"};

      
        Row filaEncabezados = sheet.createRow(0);

        

        for (int i = 0; i < cabecera.length; i++) {
            Cell celdaEnzabezado = filaEncabezados.createCell(i);
            celdaEnzabezado.setCellStyle(headerStyle);
            celdaEnzabezado.setCellValue(cabecera[i]);
        }





        String mostrar = "";
        String cadenaSQL = "Select  * from clientes INNER JOIN cotizacion ON cotizacion.CotIdCliente = clientes.CliIdClientes " ;
        try {
            Connect objConexion = new Connect();    
            Connection conn = objConexion.connect(); // devuelve el objeto conectado a la URL
            Statement stmt =  conn.createStatement(); // permiten realizar consultas SQL en la B.D.
    
            ResultSet resultSet = stmt.executeQuery(cadenaSQL);

            int index = 1;
            while (resultSet.next()) {

                Row filaDatos = sheet.createRow(index);

                filaDatos.createCell(0).setCellValue(resultSet.getString("CotIdCotizacion"));
                filaDatos.createCell(1).setCellValue(resultSet.getString("CliIdClientes"));
                filaDatos.createCell(2).setCellValue(resultSet.getString("CliNombres"));
                filaDatos.createCell(3).setCellValue(resultSet.getString("CliDocIdentidad"));
                filaDatos.createCell(4).setCellValue(resultSet.getString("CliEmail"));
                filaDatos.createCell(5).setCellValue(resultSet.getString("CliTelefonoUno"));
                filaDatos.createCell(6).setCellValue(resultSet.getString("CliTelefonoDos"));
                filaDatos.createCell(7).setCellValue(resultSet.getString("CliWhatSapp"));
                filaDatos.createCell(8).setCellValue(resultSet.getString("CliReferencias"));
                filaDatos.createCell(9).setCellValue(resultSet.getString("CotBarrio"));
                filaDatos.createCell(10).setCellValue(resultSet.getString("CotCiudad"));
                filaDatos.createCell(11).setCellValue(resultSet.getString("CotDireccion"));
                filaDatos.createCell(12).setCellValue(resultSet.getString("CotMotivo"));
                filaDatos.createCell(13).setCellValue(resultSet.getString("CotHomenajeado"));
                filaDatos.createCell(14).setCellValue(resultSet.getString("CotParentezco"));
                filaDatos.createCell(15).setCellValue(resultSet.getString("CotQuienObsequia"));
                filaDatos.createCell(16).setCellValue(resultSet.getString("CotObsequio"));
                filaDatos.createCell(17).setCellValue(resultSet.getString("CotPrecioVenta"));
                filaDatos.createCell(18).setCellValue(resultSet.getString("CotSonido"));
                filaDatos.createCell(19).setCellValue(resultSet.getString("CotPrecioObsequio"));
                filaDatos.createCell(20).setCellValue(resultSet.getString("CotTransporte"));
                filaDatos.createCell(21).setCellValue(resultSet.getString("CotCantidadMusicos"));
                filaDatos.createCell(22).setCellValue(resultSet.getString("CotFechaCotizacion"));
                filaDatos.createCell(23).setCellValue(resultSet.getString("CotTotal"));
                filaDatos.createCell(24).setCellValue(resultSet.getString("CotHora"));
                
                

           


                index++;




            
            }      
                                  
            
            conn.close();
            stmt.close();
            System.out.println("Encontrado.");  
            System.out.println(mostrar);            
        } catch (Exception e) {
            System.out.println(e.getMessage()); 
        }          


        
                    

       

       

        try {
            FileOutputStream fileout = new FileOutputStream("ReporteCotizaciones.xlsx");
            book.write(fileout);
            fileout.close();
           

        } catch (FileNotFoundException ex) {
            Logger.getLogger(reportes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(reportes.class.getName()).log(Level.SEVERE, null, ex);
        }





}
    
    








    
}
