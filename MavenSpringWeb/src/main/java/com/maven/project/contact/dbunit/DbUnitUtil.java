package com.maven.project.contact.dbunit;

import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;

import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.database.QueryDataSet;
import org.dbunit.dataset.excel.XlsDataSet;
import org.dbunit.dataset.xml.FlatXmlWriter;

public class DbUnitUtil
{
 public static void main(String[] args)
  throws Exception
 {
  //Connect to the database
  DriverManager.registerDriver(new com.mysql.jdbc.Driver());
  Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Contacts_demo", "root", "sailesh123");

  IDatabaseConnection connection = new DatabaseConnection( conn );

  QueryDataSet partialDataSet = new QueryDataSet(connection);
  //Specify the SQL to run to retrieve the data
  partialDataSet.addTable("contacts");
  FileOutputStream out = new FileOutputStream("src/main/test/resources/temp.xml");
  //Specify the location of the flat file(XML)
  FlatXmlWriter datasetWriter = new FlatXmlWriter(out);

  //Export the data
     datasetWriter.write( partialDataSet );
     out.flush();
     out.close();
     
     try {
    	 System.out.println("1 ");
		 FileOutputStream outXls = new FileOutputStream("src/main/test/resources/myTestXls.xls");

		 XlsDataSet.write(partialDataSet,outXls); 
		 outXls.flush();
		 outXls.close();
		 System.out.println("2");
	} catch (Exception e) {
		e.printStackTrace();
	}
     System.out.println("Done ");
 }
}