package com.laozhang.struts1.jdbc.dbutilsFramework.threadLocal_filter;

import java.sql.SQLException;

import com.laozhang.struts1.jdbc.myJdbcFramework.Account;

public class AccountService {
	public void transfer(int sourceid, int tartgetid, float money)
            throws SQLException {
        AccountDao dao = new AccountDao();
        Account source = dao.find(sourceid);
        Account target = dao.find(tartgetid);
        source.setMoney(source.getMoney() - money);
        target.setMoney(target.getMoney() + money);
        dao.update(source);
        // 模拟程序出现异常让事务回滚
        int x = 1 / 0;
        dao.update(target);
    }
}
