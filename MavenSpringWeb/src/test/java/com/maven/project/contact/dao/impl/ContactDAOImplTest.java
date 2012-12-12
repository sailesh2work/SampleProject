package com.maven.project.contact.dao.impl;

import java.io.FileInputStream;
import java.sql.Connection;

import javax.sql.DataSource;

import junit.framework.Assert;

import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.excel.XlsDataSet;
import org.dbunit.operation.DatabaseOperation;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import com.maven.project.contact.dao.ContactDAO;

@ContextConfiguration(locations = { "/spring-servlet-test.xml" })
public class ContactDAOImplTest extends
		AbstractTransactionalJUnit4SpringContextTests {
	@Autowired
	protected DataSource dataSource;

	@Autowired
	protected ContactDAO contactDAO;

	protected final String DATASET_PATH = "src/test/";

	@Before
	public void setUp() throws Exception {
		Connection con = DataSourceUtils.getConnection(dataSource);
		IDatabaseConnection dbUnitCon = new DatabaseConnection(con);
		IDataSet dataSet = new XlsDataSet(new FileInputStream(DATASET_PATH
				+ "myTestXls.xls"));
		DatabaseOperation.CLEAN_INSERT.execute(dbUnitCon, dataSet);
		DataSourceUtils.releaseConnection(con, dataSource);
	}

	@Test
	public void testListContact() {
		Assert.assertEquals(5, contactDAO.listContact().size());
	}

}
