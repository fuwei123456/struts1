package com.laozhang.struts1.jdbc.myJdbcFramework;

import java.sql.ResultSet;

/**
 * 结果集处理器接口
 * @author Lenovo
 *
 */
public interface ResultSetHandler {
	/**
	 * 结果集处理方法
	 * @param rs 查询结果集
	 * @return
	 */
	Object handler(ResultSet rs);
}
