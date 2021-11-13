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
import controller.InformeController;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


import connection.Connect;



import org.apache.log4j.BasicConfigurator;


public class reportes {



public  void  exportarCotizacion(String fechaI, String fechaR) {

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
        "Costo total","Hora","Estado de la cotizacion"};

      
        Row filaEncabezados = sheet.createRow(0);

        

        for (int i = 0; i < cabecera.length; i++) {
            Cell celdaEnzabezado = filaEncabezados.createCell(i);
            celdaEnzabezado.setCellStyle(headerStyle);
            celdaEnzabezado.setCellValue(cabecera[i]);
            sheet.setColumnWidth(i, 8000);    
        }





        String mostrar = "";
        String cadenaSQL = "Select  * from clientes INNER JOIN cotizacion ON cotizacion.CotIdCliente = clientes.CliIdClientes  WHERE cotizacion.CotFechaCotizacion >= " + fechaI + " AND cotizacion.CotFechaCotizacion <= " + fechaR ;
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
                filaDatos.createCell(25).setCellValue(resultSet.getString("CotEstado"));
                
                

           


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
            FileOutputStream fileout = new FileOutputStream("C:/Users/Gabokeybass/Desktop/ReporteCotizaciones.xlsx");
            book.write(fileout);
            fileout.close();
           

        } catch (FileNotFoundException ex) {
            Logger.getLogger(reportes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(reportes.class.getName()).log(Level.SEVERE, null, ex);
        }





}
    
    




public  void  exportarFactura(String fechaI, String fechaR) {

 
  
  
    BasicConfigurator.configure();
  
    
    Workbook book = new XSSFWorkbook();
    Sheet sheet = book.createSheet("Facturas");
    

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

    String[] cabecera = new String[]{ "Id Factura","Fecha Factura","Estado de la factura","Id Cotizacion","Id Cliente","Nombre del cliente","Documento de identidad","Email del cliente",
    "Telefono del cliente","Telefono del cliente","Whatsapp del cliente","Referencias","Barrio","Ciudad",
    "Direccion","Motivo","Homenajeado","Parentezco","Quien obsequia","Obsequio","Precio de venta",
    "Costo del sonido","Costo del obsequio","Costo del transporte","Cantidad de musico","Fecha de cotizacion",
    "Costo total","Hora","Estado de la cotizacion"};

  
    Row filaEncabezados = sheet.createRow(0);

    

    for (int i = 0; i < cabecera.length; i++) {
        Cell celdaEnzabezado = filaEncabezados.createCell(i);
        celdaEnzabezado.setCellStyle(headerStyle);
        celdaEnzabezado.setCellValue(cabecera[i]);
        sheet.setColumnWidth(i, 8000);    
    }





    String mostrar = "";
    String cadenaSQL = "Select  * from clientes INNER JOIN cotizacion ON cotizacion.CotIdCliente = clientes.CliIdClientes INNER JOIN factura ON cotizacion.CotIdCotizacion = factura.facIdCotizacion  WHERE factura.FacFechaFactura >= " + fechaI + " AND factura.FacFechaFactura <= " + fechaR ;
    try {
        Connect objConexion = new Connect();    
        Connection conn = objConexion.connect(); // devuelve el objeto conectado a la URL
        Statement stmt =  conn.createStatement(); // permiten realizar consultas SQL en la B.D.

        ResultSet resultSet = stmt.executeQuery(cadenaSQL);       
       
        int index = 1;
        while (resultSet.next()) {

            Row filaDatos = sheet.createRow(index);

            filaDatos.createCell(0).setCellValue(resultSet.getString("FacIdFactura"));
            filaDatos.createCell(1).setCellValue(resultSet.getString("FacFechaFactura"));
            filaDatos.createCell(2).setCellValue(resultSet.getString("FacEstado"));

            filaDatos.createCell(3).setCellValue(resultSet.getString("CotIdCotizacion"));
            filaDatos.createCell(4).setCellValue(resultSet.getString("CliIdClientes"));
            filaDatos.createCell(5).setCellValue(resultSet.getString("CliNombres"));
            filaDatos.createCell(6).setCellValue(resultSet.getString("CliDocIdentidad"));
            filaDatos.createCell(7).setCellValue(resultSet.getString("CliEmail"));
            filaDatos.createCell(8).setCellValue(resultSet.getString("CliTelefonoUno"));
            filaDatos.createCell(9).setCellValue(resultSet.getString("CliTelefonoDos"));
            filaDatos.createCell(10).setCellValue(resultSet.getString("CliWhatSapp"));
            filaDatos.createCell(11).setCellValue(resultSet.getString("CliReferencias"));
            filaDatos.createCell(12).setCellValue(resultSet.getString("CotBarrio"));
            filaDatos.createCell(13).setCellValue(resultSet.getString("CotCiudad"));
            filaDatos.createCell(14).setCellValue(resultSet.getString("CotDireccion"));
            filaDatos.createCell(15).setCellValue(resultSet.getString("CotMotivo"));
            filaDatos.createCell(16).setCellValue(resultSet.getString("CotHomenajeado"));
            filaDatos.createCell(17).setCellValue(resultSet.getString("CotParentezco"));
            filaDatos.createCell(18).setCellValue(resultSet.getString("CotQuienObsequia"));
            filaDatos.createCell(19).setCellValue(resultSet.getString("CotObsequio"));
            filaDatos.createCell(20).setCellValue(resultSet.getString("CotPrecioVenta"));
            filaDatos.createCell(21).setCellValue(resultSet.getString("CotSonido"));
            filaDatos.createCell(22).setCellValue(resultSet.getString("CotPrecioObsequio"));
            filaDatos.createCell(23).setCellValue(resultSet.getString("CotTransporte"));
            filaDatos.createCell(24).setCellValue(resultSet.getString("CotCantidadMusicos"));
            filaDatos.createCell(25).setCellValue(resultSet.getString("CotFechaCotizacion"));
            filaDatos.createCell(26).setCellValue(resultSet.getString("CotTotal"));
            filaDatos.createCell(27).setCellValue(resultSet.getString("CotHora"));
            filaDatos.createCell(28).setCellValue(resultSet.getString("CotEstado"));
            
            

       


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
        FileOutputStream fileout = new FileOutputStream("C:/Users/Gabokeybass/Desktop/ReporteFacturas.xlsx");
        book.write(fileout);
        fileout.close();
       

    } catch (FileNotFoundException ex) {
        Logger.getLogger(reportes.class.getName()).log(Level.SEVERE, null, ex);
    } catch (Exception ex) {
        Logger.getLogger(reportes.class.getName()).log(Level.SEVERE, null, ex);
    }





}



public  void  exportarEmpleados(String fechaI, String fechaR) {

         
      
        BasicConfigurator.configure();
      
        
        Workbook book = new XSSFWorkbook();
        Sheet sheet = book.createSheet("Empleados");
        

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

        String[] cabecera = new String[]{"Id Empleado","Nombres del empleado","Documento de identidad","Direccion",
        "Ciudad","Estado Civil","Numeros Telefonicos","Cargo","Sueldo","Cantidad de hijos",
        "Genero","Edad","Fecha de Nacimiento","Fecha de Ingreso","Estado","Fecha de retiro"};

      
        Row filaEncabezados = sheet.createRow(0);

        

        for (int i = 0; i < cabecera.length; i++) {
            Cell celdaEnzabezado = filaEncabezados.createCell(i);
            celdaEnzabezado.setCellStyle(headerStyle);
            celdaEnzabezado.setCellValue(cabecera[i]);
            sheet.setColumnWidth(i, 8000);    
        }





        String mostrar = "";
        String cadenaSQL = "Select  * from empleados  WHERE EmpIngreso >= " + fechaI + " AND EmpIngreso <= " + fechaR ;
        try {
            Connect objConexion = new Connect();    
            Connection conn = objConexion.connect(); // devuelve el objeto conectado a la URL
            Statement stmt =  conn.createStatement(); // permiten realizar consultas SQL en la B.D.
    
            ResultSet resultSet = stmt.executeQuery(cadenaSQL);

            int index = 1;
            while (resultSet.next()) {

                Row filaDatos = sheet.createRow(index);

                filaDatos.createCell(0).setCellValue(resultSet.getString("EmpIdEmpleados"));
                filaDatos.createCell(1).setCellValue(resultSet.getString("EmpNombres"));
                filaDatos.createCell(2).setCellValue(resultSet.getString("EmpDocIdentidad"));
                filaDatos.createCell(3).setCellValue(resultSet.getString("EmpDireccion"));
                filaDatos.createCell(4).setCellValue(resultSet.getString("EmpCiudad"));
                filaDatos.createCell(5).setCellValue(resultSet.getString("EmpEstadoCivil"));
                filaDatos.createCell(6).setCellValue(resultSet.getString("EmpNumerosTelefono"));
                filaDatos.createCell(7).setCellValue(resultSet.getString("EmpCargo"));
                filaDatos.createCell(8).setCellValue(resultSet.getString("EmpSueldo"));
                filaDatos.createCell(9).setCellValue(resultSet.getString("EmpHijos"));
                filaDatos.createCell(10).setCellValue(resultSet.getString("EmpGenero"));
                filaDatos.createCell(11).setCellValue(resultSet.getString("EmpEdad"));
                 filaDatos.createCell(12).setCellValue(resultSet.getString("EmpNacimiento"));
                filaDatos.createCell(13).setCellValue(resultSet.getString("EmpIngreso"));
                filaDatos.createCell(14).setCellValue(resultSet.getString("EmpEstado"));
                filaDatos.createCell(15).setCellValue(resultSet.getString("EmpRetiro"));
             
                
                

           


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
            FileOutputStream fileout = new FileOutputStream("C:/Users/Gabokeybass/Desktop/ReporteEmpleados.xlsx");
            book.write(fileout);
            fileout.close();
           

        } catch (FileNotFoundException ex) {
            Logger.getLogger(reportes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(reportes.class.getName()).log(Level.SEVERE, null, ex);
        }





}

public  void  exportarEmpleadosIngreso(String fechaI, String fechaR) {

         
      
    BasicConfigurator.configure();
  
    
    Workbook book = new XSSFWorkbook();
    Sheet sheet = book.createSheet("Empleados");
    

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

    String[] cabecera = new String[]{"Id Empleado","Nombres del empleado","Documento de identidad","Numeros Telefonicos","Cargo","Fecha de Ingreso","Estado"};

  
    Row filaEncabezados = sheet.createRow(0);

    

    for (int i = 0; i < cabecera.length; i++) {
        Cell celdaEnzabezado = filaEncabezados.createCell(i);
        celdaEnzabezado.setCellStyle(headerStyle);
        celdaEnzabezado.setCellValue(cabecera[i]);
        sheet.setColumnWidth(i, 8000);    
    }





    String mostrar = "";
    String cadenaSQL = "Select  * from empleados  WHERE EmpIngreso >= " + fechaI + " AND EmpIngreso <= " + fechaR ;
    try {
        Connect objConexion = new Connect();    
        Connection conn = objConexion.connect(); // devuelve el objeto conectado a la URL
        Statement stmt =  conn.createStatement(); // permiten realizar consultas SQL en la B.D.

        ResultSet resultSet = stmt.executeQuery(cadenaSQL);

        int index = 1;
        while (resultSet.next()) {

            Row filaDatos = sheet.createRow(index);

            filaDatos.createCell(0).setCellValue(resultSet.getString("EmpIdEmpleados"));
            filaDatos.createCell(1).setCellValue(resultSet.getString("EmpNombres"));
            filaDatos.createCell(2).setCellValue(resultSet.getString("EmpDocIdentidad"));            
            filaDatos.createCell(3).setCellValue(resultSet.getString("EmpNumerosTelefono"));
            filaDatos.createCell(4).setCellValue(resultSet.getString("EmpCargo"));           
            filaDatos.createCell(5).setCellValue(resultSet.getString("EmpIngreso"));
            filaDatos.createCell(6).setCellValue(resultSet.getString("EmpEstado"));          
         
            
                  


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
        FileOutputStream fileout = new FileOutputStream("C:/Users/Gabokeybass/Desktop/ReporteEmpleados.xlsx");
        book.write(fileout);
        fileout.close();
       

    } catch (FileNotFoundException ex) {
        Logger.getLogger(reportes.class.getName()).log(Level.SEVERE, null, ex);
    } catch (Exception ex) {
        Logger.getLogger(reportes.class.getName()).log(Level.SEVERE, null, ex);
    }





}


public  void  exportarEmpleadosRetirados(String fechaI, String fechaR) {

         
      
    BasicConfigurator.configure();
  
    
    Workbook book = new XSSFWorkbook();
    Sheet sheet = book.createSheet("Empleados");
    

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

    String[] cabecera = new String[]{"Id Empleado","Nombres del empleado","Documento de identidad","Numeros Telefonicos","Cargo","Fecha de Ingreso","Estado", "Fecha de retiro"};

  
    Row filaEncabezados = sheet.createRow(0);

    

    for (int i = 0; i < cabecera.length; i++) {
        Cell celdaEnzabezado = filaEncabezados.createCell(i);
        celdaEnzabezado.setCellStyle(headerStyle);
        celdaEnzabezado.setCellValue(cabecera[i]);
        sheet.setColumnWidth(i, 8000);    
    }





    String mostrar = "";
    String cadenaSQL = "Select  * from empleados  WHERE EmpRetiro >= " + fechaI + " AND EmpRetiro <= " + fechaR ;
    try {
        Connect objConexion = new Connect();    
        Connection conn = objConexion.connect(); // devuelve el objeto conectado a la URL
        Statement stmt =  conn.createStatement(); // permiten realizar consultas SQL en la B.D.

        ResultSet resultSet = stmt.executeQuery(cadenaSQL);

        int index = 1;
        while (resultSet.next()) {

            Row filaDatos = sheet.createRow(index);

            filaDatos.createCell(0).setCellValue(resultSet.getString("EmpIdEmpleados"));
            filaDatos.createCell(1).setCellValue(resultSet.getString("EmpNombres"));
            filaDatos.createCell(2).setCellValue(resultSet.getString("EmpDocIdentidad"));            
            filaDatos.createCell(3).setCellValue(resultSet.getString("EmpNumerosTelefono"));
            filaDatos.createCell(4).setCellValue(resultSet.getString("EmpCargo"));           
            filaDatos.createCell(5).setCellValue(resultSet.getString("EmpIngreso"));
            filaDatos.createCell(6).setCellValue(resultSet.getString("EmpEstado")); 
            filaDatos.createCell(7).setCellValue(resultSet.getString("EmpRetiro"));         
         
            
                  


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
        FileOutputStream fileout = new FileOutputStream("C:/Users/Gabokeybass/Desktop/ReporteEmpleados.xlsx");
        book.write(fileout);
        fileout.close();
       

    } catch (FileNotFoundException ex) {
        Logger.getLogger(reportes.class.getName()).log(Level.SEVERE, null, ex);
    } catch (Exception ex) {
        Logger.getLogger(reportes.class.getName()).log(Level.SEVERE, null, ex);
    }





}






public  void  exportarFacturaBarrios(String fechaI, String fechaR, String datos) {

 
  
  
    BasicConfigurator.configure();
  
    
    Workbook book = new XSSFWorkbook();
    Sheet sheet = book.createSheet("Barrios");
    

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

    String[] cabecera = new String[]{ "Id Factura","Fecha Factura","Estado de la factura","Id Cotizacion","Id Cliente","Nombre del cliente","Documento de identidad","Email del cliente",
    "Telefono del cliente","Telefono del cliente","Whatsapp del cliente","Referencias","Barrio","Ciudad",
    "Direccion","Motivo","Homenajeado","Parentezco","Quien obsequia","Obsequio","Precio de venta",
    "Costo del sonido","Costo del obsequio","Costo del transporte","Cantidad de musico","Fecha de cotizacion",
    "Costo total","Hora","Estado de la cotizacion"};

  
    Row filaEncabezados = sheet.createRow(0);

    

    for (int i = 0; i < cabecera.length; i++) {
        Cell celdaEnzabezado = filaEncabezados.createCell(i);
        celdaEnzabezado.setCellStyle(headerStyle);
        celdaEnzabezado.setCellValue(cabecera[i]);
        sheet.setColumnWidth(i, 8000);    
    }





    String mostrar = "";
    String cadenaSQL = "Select  * from clientes INNER JOIN cotizacion ON cotizacion.CotIdCliente = clientes.CliIdClientes INNER JOIN factura ON cotizacion.CotIdCotizacion = factura.facIdCotizacion  WHERE factura.FacFechaFactura >= " + fechaI + " AND factura.FacFechaFactura <= " + fechaR + " AND cotizacion.CotBarrio LIKE " + datos  ;
    try {
        Connect objConexion = new Connect();    
        Connection conn = objConexion.connect(); // devuelve el objeto conectado a la URL
        Statement stmt =  conn.createStatement(); // permiten realizar consultas SQL en la B.D.

        ResultSet resultSet = stmt.executeQuery(cadenaSQL);       
       
        int index = 1;
        while (resultSet.next()) {

            Row filaDatos = sheet.createRow(index);

            filaDatos.createCell(0).setCellValue(resultSet.getString("FacIdFactura"));
            filaDatos.createCell(1).setCellValue(resultSet.getString("FacFechaFactura"));
            filaDatos.createCell(2).setCellValue(resultSet.getString("FacEstado"));

            filaDatos.createCell(3).setCellValue(resultSet.getString("CotIdCotizacion"));
            filaDatos.createCell(4).setCellValue(resultSet.getString("CliIdClientes"));
            filaDatos.createCell(5).setCellValue(resultSet.getString("CliNombres"));
            filaDatos.createCell(6).setCellValue(resultSet.getString("CliDocIdentidad"));
            filaDatos.createCell(7).setCellValue(resultSet.getString("CliEmail"));
            filaDatos.createCell(8).setCellValue(resultSet.getString("CliTelefonoUno"));
            filaDatos.createCell(9).setCellValue(resultSet.getString("CliTelefonoDos"));
            filaDatos.createCell(10).setCellValue(resultSet.getString("CliWhatSapp"));
            filaDatos.createCell(11).setCellValue(resultSet.getString("CliReferencias"));
            filaDatos.createCell(12).setCellValue(resultSet.getString("CotBarrio"));
            filaDatos.createCell(13).setCellValue(resultSet.getString("CotCiudad"));
            filaDatos.createCell(14).setCellValue(resultSet.getString("CotDireccion"));
            filaDatos.createCell(15).setCellValue(resultSet.getString("CotMotivo"));
            filaDatos.createCell(16).setCellValue(resultSet.getString("CotHomenajeado"));
            filaDatos.createCell(17).setCellValue(resultSet.getString("CotParentezco"));
            filaDatos.createCell(18).setCellValue(resultSet.getString("CotQuienObsequia"));
            filaDatos.createCell(19).setCellValue(resultSet.getString("CotObsequio"));
            filaDatos.createCell(20).setCellValue(resultSet.getString("CotPrecioVenta"));
            filaDatos.createCell(21).setCellValue(resultSet.getString("CotSonido"));
            filaDatos.createCell(22).setCellValue(resultSet.getString("CotPrecioObsequio"));
            filaDatos.createCell(23).setCellValue(resultSet.getString("CotTransporte"));
            filaDatos.createCell(24).setCellValue(resultSet.getString("CotCantidadMusicos"));
            filaDatos.createCell(25).setCellValue(resultSet.getString("CotFechaCotizacion"));
            filaDatos.createCell(26).setCellValue(resultSet.getString("CotTotal"));
            filaDatos.createCell(27).setCellValue(resultSet.getString("CotHora"));
            filaDatos.createCell(28).setCellValue(resultSet.getString("CotEstado"));
            
            

       


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
        FileOutputStream fileout = new FileOutputStream("C:/Users/Gabokeybass/Desktop/ReporteBarrios.xlsx");
        book.write(fileout);
        fileout.close();
       

    } catch (FileNotFoundException ex) {
        Logger.getLogger(reportes.class.getName()).log(Level.SEVERE, null, ex);
    } catch (Exception ex) {
        Logger.getLogger(reportes.class.getName()).log(Level.SEVERE, null, ex);
    }





}


public  void  exportarFacturaMotivos(String fechaI, String fechaR, String datos) {

 
  
  
    BasicConfigurator.configure();
  
    
    Workbook book = new XSSFWorkbook();
    Sheet sheet = book.createSheet("Motivos");
    

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

    String[] cabecera = new String[]{ "Id Factura","Fecha Factura","Estado de la factura","Id Cotizacion","Id Cliente","Nombre del cliente","Documento de identidad","Email del cliente",
    "Telefono del cliente","Telefono del cliente","Whatsapp del cliente","Referencias","Barrio","Ciudad",
    "Direccion","Motivo","Homenajeado","Parentezco","Quien obsequia","Obsequio","Precio de venta",
    "Costo del sonido","Costo del obsequio","Costo del transporte","Cantidad de musico","Fecha de cotizacion",
    "Costo total","Hora","Estado de la cotizacion"};

  
    Row filaEncabezados = sheet.createRow(0);

    

    for (int i = 0; i < cabecera.length; i++) {
        Cell celdaEnzabezado = filaEncabezados.createCell(i);
        celdaEnzabezado.setCellStyle(headerStyle);
        celdaEnzabezado.setCellValue(cabecera[i]);
        sheet.setColumnWidth(i, 8000);    
    }





    String mostrar = "";
    String cadenaSQL = "Select  * from clientes INNER JOIN cotizacion ON cotizacion.CotIdCliente = clientes.CliIdClientes INNER JOIN factura ON cotizacion.CotIdCotizacion = factura.facIdCotizacion  WHERE factura.FacFechaFactura >= " + fechaI + " AND factura.FacFechaFactura <= " + fechaR + " AND cotizacion.CotMotivo LIKE " + datos  ;
    try {
        Connect objConexion = new Connect();    
        Connection conn = objConexion.connect(); // devuelve el objeto conectado a la URL
        Statement stmt =  conn.createStatement(); // permiten realizar consultas SQL en la B.D.

        ResultSet resultSet = stmt.executeQuery(cadenaSQL);       
       
        int index = 1;
        while (resultSet.next()) {

            Row filaDatos = sheet.createRow(index);

            filaDatos.createCell(0).setCellValue(resultSet.getString("FacIdFactura"));
            filaDatos.createCell(1).setCellValue(resultSet.getString("FacFechaFactura"));
            filaDatos.createCell(2).setCellValue(resultSet.getString("FacEstado"));

            filaDatos.createCell(3).setCellValue(resultSet.getString("CotIdCotizacion"));
            filaDatos.createCell(4).setCellValue(resultSet.getString("CliIdClientes"));
            filaDatos.createCell(5).setCellValue(resultSet.getString("CliNombres"));
            filaDatos.createCell(6).setCellValue(resultSet.getString("CliDocIdentidad"));
            filaDatos.createCell(7).setCellValue(resultSet.getString("CliEmail"));
            filaDatos.createCell(8).setCellValue(resultSet.getString("CliTelefonoUno"));
            filaDatos.createCell(9).setCellValue(resultSet.getString("CliTelefonoDos"));
            filaDatos.createCell(10).setCellValue(resultSet.getString("CliWhatSapp"));
            filaDatos.createCell(11).setCellValue(resultSet.getString("CliReferencias"));
            filaDatos.createCell(12).setCellValue(resultSet.getString("CotBarrio"));
            filaDatos.createCell(13).setCellValue(resultSet.getString("CotCiudad"));
            filaDatos.createCell(14).setCellValue(resultSet.getString("CotDireccion"));
            filaDatos.createCell(15).setCellValue(resultSet.getString("CotMotivo"));
            filaDatos.createCell(16).setCellValue(resultSet.getString("CotHomenajeado"));
            filaDatos.createCell(17).setCellValue(resultSet.getString("CotParentezco"));
            filaDatos.createCell(18).setCellValue(resultSet.getString("CotQuienObsequia"));
            filaDatos.createCell(19).setCellValue(resultSet.getString("CotObsequio"));
            filaDatos.createCell(20).setCellValue(resultSet.getString("CotPrecioVenta"));
            filaDatos.createCell(21).setCellValue(resultSet.getString("CotSonido"));
            filaDatos.createCell(22).setCellValue(resultSet.getString("CotPrecioObsequio"));
            filaDatos.createCell(23).setCellValue(resultSet.getString("CotTransporte"));
            filaDatos.createCell(24).setCellValue(resultSet.getString("CotCantidadMusicos"));
            filaDatos.createCell(25).setCellValue(resultSet.getString("CotFechaCotizacion"));
            filaDatos.createCell(26).setCellValue(resultSet.getString("CotTotal"));
            filaDatos.createCell(27).setCellValue(resultSet.getString("CotHora"));
            filaDatos.createCell(28).setCellValue(resultSet.getString("CotEstado"));
            
            

       


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
        FileOutputStream fileout = new FileOutputStream("C:/Users/Gabokeybass/Desktop/ReporteMotivos.xlsx");
        book.write(fileout);
        fileout.close();
       

    } catch (FileNotFoundException ex) {
        Logger.getLogger(reportes.class.getName()).log(Level.SEVERE, null, ex);
    } catch (Exception ex) {
        Logger.getLogger(reportes.class.getName()).log(Level.SEVERE, null, ex);
    }





}


public  void  exportarNomina(String fechaI, String fechaR) {

     
    BasicConfigurator.configure();
  
    
    Workbook book = new XSSFWorkbook();
    Sheet sheet = book.createSheet("Nomina");
    
    

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

    String[] cabecera = new String[]{"Id Nomina","Id Factura","Id Empleado","Nombre del empleado",
    "Documento de identidad","Cantidad de Serenatas",
    "Nomina","Pension","Salud","Descuentos","Ahorro","Cultural",
    "Fecha de pago","Metodo de pago","Pago total"};

  
    Row filaEncabezados = sheet.createRow(0);
   
        
   

    for (int i = 0; i < cabecera.length; i++) {
        Cell celdaEnzabezado = filaEncabezados.createCell(i);
        celdaEnzabezado.setCellStyle(headerStyle);
        celdaEnzabezado.setCellValue(cabecera[i]);
        sheet.setColumnWidth(i, 8000);       
    }


    String mostrar = "";
    String cadenaSQL = "Select  * from empleados INNER JOIN nomina ON nomina.NomIdEmpleado = empleados.EmpIdEmpleados WHERE nomina.NomFechaPago >= " + fechaI + " AND nomina.NomFechaPago <= " + fechaR ;
    try {
        Connect objConexion = new Connect();    
        Connection conn = objConexion.connect(); // devuelve el objeto conectado a la URL
        Statement stmt =  conn.createStatement(); // permiten realizar consultas SQL en la B.D.

        ResultSet resultSet = stmt.executeQuery(cadenaSQL);

        int index = 1;
        while (resultSet.next()) {

            Row filaDatos = sheet.createRow(index);

            filaDatos.createCell(0).setCellValue(resultSet.getString("NomIdNomina"));
            filaDatos.createCell(1).setCellValue(resultSet.getString("NomIdfactura"));
            filaDatos.createCell(2).setCellValue(resultSet.getString("NomIdEmpleado"));
            filaDatos.createCell(3).setCellValue(resultSet.getString("EmpNombres"));
            filaDatos.createCell(4).setCellValue(resultSet.getString("EmpDocIdentidad"));
            filaDatos.createCell(5).setCellValue(resultSet.getString("NomCantidadSerenatas"));
            filaDatos.createCell(6).setCellValue(resultSet.getString("NompagoNomina"));
            filaDatos.createCell(7).setCellValue(resultSet.getString("NomPension"));
            filaDatos.createCell(8).setCellValue(resultSet.getString("NomSalud"));
            filaDatos.createCell(9).setCellValue(resultSet.getString("NomDescuentos"));
            filaDatos.createCell(10).setCellValue(resultSet.getString("NomAhorros"));
            filaDatos.createCell(11).setCellValue(resultSet.getString("NomCultural"));
            filaDatos.createCell(12).setCellValue(resultSet.getString("NomFechaPago"));
            filaDatos.createCell(13).setCellValue(resultSet.getString("NomMetodoPAgo"));
            filaDatos.createCell(14).setCellValue(resultSet.getString("NomTotalPago"));
            
            

       


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
        FileOutputStream fileout = new FileOutputStream("C:/Users/Gabokeybass/Desktop/Nomina.xlsx");
        book.write(fileout);
        fileout.close();
       

    } catch (FileNotFoundException ex) {
        Logger.getLogger(reportes.class.getName()).log(Level.SEVERE, null, ex);
    } catch (Exception ex) {
        Logger.getLogger(reportes.class.getName()).log(Level.SEVERE, null, ex);
    }





}


    
}
