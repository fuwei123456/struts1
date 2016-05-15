package com.laozhang.struts1.jdbc.dbutilsFramework;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

/**
 * 使用dbutils框架的QueryRunner类完成CRUD,以及批处理
 * @author Lenovo
 *
 */

/**测试表
28      create table users(
29          id int primary key auto_increment, 
30          name varchar(40),
31          password varchar(40), 
32          email varchar(60), 
33          birthday date 
34      );*/

public class QueryRunnerCRUDTest {
	
	@Test
	public void add() throws SQLException {
		//将数据源传递给QueryRunner，QueryRunner内部通过数据源获取数据库连接
		QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
		String sql = "insert into users(name,password,email,birthday) values(?,?,?,?)";
		Object params[] = {"***","123", "gacl@sina.com", new Date()};
		//Object params[] = {"***","123", "gacl@sina.com", "1988-05-07"};
		qr.update(sql, params);
	}
	
	@Test
	public void delete() throws SQLException {
		QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
		String sql = "delete from users where id=?";
		qr.update(sql, 1);
	}
	
	@Test
	public void update() throws SQLException {
		QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
		String sql = "update users set name=? where id=?";
		Object params[] = { "ddd", 5};
		qr.update(sql, params);
	}
	
	@Test
	public void find() throws SQLException {
		QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
		String sql = "select * from users where id=?";
		Object params[] = {2};
		User user = (User)qr.query(sql, params, new BeanHandler(User.class));
	}
	
	@Test
	public void getAll() throws SQLException {
		QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
		String sql = "select * from users";
		List list = (List)qr.query(sql, new BeanListHandler(User.class));
	}
	
	@Test
	public void testBatch() throws SQLException {
		QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
		String sql = "insert into users(name,password,email,birthday) values(?,?,?,?)";
		Object params[][] = new Object[10][];
		for (int i = 0; i < 10; i++) {
			params[i] = new Object[] { "aa" + i, "123", "aa@sina.com",new Date() };
		}
		qr.batch(sql, params);
	}
}
