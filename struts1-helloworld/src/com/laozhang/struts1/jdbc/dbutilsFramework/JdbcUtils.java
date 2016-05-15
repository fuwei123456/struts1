package com.laozhang.struts1.jdbc.dbutilsFramework;

import java.sql.Connection;
import java.sql.SQLException;

import javax.management.RuntimeErrorException;
import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JdbcUtils {
	private static ComboPooledDataSource ds = null;
	//使用ThreadLocal存储当前线程的Connection对象
	private static ThreadLocal<Connection> threadLocal = new ThreadLocal<Connection>();
	
	//在静态代码块中创建数据库连接池
	static {
		try {
			//通过代码创建c3p0数据库连接池
			/*ds = new ComboPooledDataSource();
			ds.setDriverClass("com.mysql.jdbc.Driver");
			ds.setJdbcUrl("jdbc://mysql://localhost:3306/mysql");
			ds.setUser("Lenovo");
			ds.setPassword("123456");
			ds.setInitialPoolSize(10);
			ds.setMinPoolSize(5);
			ds.setMaxPoolSize(20);*/
			
			//通过读取c3p0的xml配置文件创建数据源，c3p0的xml配置文件c3p0-config.xml必须放在src目录下
			//ds = new ComboPooledDataSource();//使用c3p0的默认配置来创建数据源
			ds = new ComboPooledDataSource("MySql");
		} catch (Exception e) {
			throw new ExceptionInInitializerError(e);
		}
	}
	
	public static DataSource getDataSource() {
		//从数据源中获取数据库连接
		return ds;
	}
	
	public static Connection getConnection() throws SQLException {
		//从当前线程中获取Connection
		Connection conn = threadLocal.get();
		if (conn == null) {
			//从数据源中获取数据库连接
			conn = getDataSource().getConnection();
			//将conn绑定到当前线程
			threadLocal.set(conn);
		}
		return conn;
	}
	
	public static void startTransaction() {
		try {
			Connection conn = threadLocal.get();
			if (null == conn) {
				conn = getConnection();
				//把conn绑定到当前线程上
				threadLocal.set(conn);
			}
			//开启事务
			conn.setAutoCommit(false);
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}
	
	public static void rollback() {
		try {
			//从当前线程中获取Connection
			Connection conn = threadLocal.get();
			if (conn != null) {
				//回滚事务
				conn.rollback();
			}
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}
	
	public static void commit() {
		try {
			//从当前线程中获取Connection
			Connection conn = threadLocal.get();
			if (null != conn) {
				//提交事务
				conn.commit();
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public static void close() {
		try {
			//从当前线程中获取Connection
			Connection conn = threadLocal.get();
			if (null != conn) {
				conn.close();
				//解除当前线程上绑定Connection
				threadLocal.remove();
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
