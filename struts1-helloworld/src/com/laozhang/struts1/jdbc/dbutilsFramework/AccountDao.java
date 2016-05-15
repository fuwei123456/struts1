package com.laozhang.struts1.jdbc.dbutilsFramework;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;

import com.laozhang.struts1.jdbc.myJdbcFramework.Account;

public class AccountDao {
	public void update(Account account) throws SQLException {
		QueryRunner qr = new QueryRunner();
		String sql = "update accout set name=?,money=? where id=?";
		Object params[] = {account.getName(),account.getMoney(),account.getId()};
		//JdbcUtils.getConnection()获取当前线程中的Connection对象
		qr.update(JdbcUtils.getConnection(), sql, params);
	}
	
	public Account find(int id) throws SQLException {
		QueryRunner qr = new QueryRunner();
		String sql = "select * from account where id = ?";
		//JdbcUtils.getConnection()获取当前线程中的Connection对象
		return (Account) qr.query(JdbcUtils.getConnection(),sql, id, new org.apache.commons.dbutils.handlers.BeanHandler(Account.class));
	}
}
