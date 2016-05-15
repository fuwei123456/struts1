package com.laozhang.struts1.jdbc.dbutilsFramework;

import java.sql.SQLException;

import com.laozhang.struts1.jdbc.myJdbcFramework.Account;

public class AccountService {
	public void transfer(int sourceid,int tartgetid,float money) throws SQLException{
		try {
			//开启事务，在业务层处理事务，保证dao层的多个操作在同一个事务中进行
			JdbcUtils.startTransaction();
			AccountDao dao = new AccountDao();
			Account source = dao.find(sourceid);
			Account target = dao.find(tartgetid);
			source.setMoney(source.getMoney()-money);
			target.setMoney(target.getMoney()+money);
			dao.update(source);
			dao.update(target);
			JdbcUtils.commit();
		} catch (Exception e) {
			//出现异常之后就回滚事务
			JdbcUtils.rollback();
		} finally {
			//关闭数据库连接
			JdbcUtils.close();
		}
	}
}
