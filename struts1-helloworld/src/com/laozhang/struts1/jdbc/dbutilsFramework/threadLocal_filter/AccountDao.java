package com.laozhang.struts1.jdbc.dbutilsFramework.threadLocal_filter;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.laozhang.struts1.jdbc.myJdbcFramework.Account;

public class AccountDao {
	
	public void update(Account account) throws SQLException{
		QueryRunner qr = new QueryRunner();
		String sql = "update account set name=?,money=? where id=?";
		Object params[] = {account.getName(),account.getMoney(),account.getId()};
		//ConnectionContext.getInstance().getConnection()获取当前线程中的Connection对象
		qr.update(ConnectionContext.getInstance().getConnection(),sql, params);
	}
	
	public Account find(int id) throws SQLException{
        QueryRunner qr = new QueryRunner();
        String sql = "select * from account where id=?";
        //ConnectionContext.getInstance().getConnection()获取当前线程中的Connection对象
        return (Account) qr.query(ConnectionContext.getInstance().getConnection(),sql, id, new BeanHandler(Account.class));
    }
}
