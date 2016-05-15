package com.laozhang.struts1.jdbc.jdbcpool.dbcp;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;

/**
 * DBCP 是 Apache 软件基金组织下的开源连接池实现，要使用DBCP数据源，需要应用程序应在系统中增加如下两个 jar 文件：
 * Commons-dbcp.jar：连接池的实现
 * Commons-pool.jar：连接池实现的依赖库
 * 
 * 
 * 导入相关jar包	commons-dbcp-1.2.2.jar、commons-pool.jar
 * 
 * @author Lenovo
 *
 */




public class JdbcUtils_DBCP {
	
	private static DataSource ds = null;
	//在静态代码块中创建数据库连接池
	static {
		try {
			//加载dbcpconfig.properties配置文件
			InputStream in = JdbcUtils_DBCP.class.getClassLoader().getResourceAsStream("dbcpconfig.properties");
			Properties prop = new Properties();
			prop.load(in);
			//创建数据源
			ds = BasicDataSourceFactory.createDataSource(prop);
		} catch (Exception e) {
			throw new ExceptionInInitializerError(e);
		}
	}
	
	public static Connection getConnection() throws SQLException{
		return ds.getConnection();
	}
	
	public static void release(Connection conn,Statement st,ResultSet rs){
		if (rs != null) {
			try {
				//关闭存储查询结果的ResultSet对象
				rs.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
			rs = null;
		}
		
		if (st != null) {
			try {
				//关闭负责执行SQL命令的Statement对象
				st.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		if (conn != null) {
			try {
				//将Connection连接对象还给数据库连接池
				conn.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
}
