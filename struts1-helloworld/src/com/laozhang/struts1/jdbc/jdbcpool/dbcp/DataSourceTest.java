package com.laozhang.struts1.jdbc.jdbcpool.dbcp;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.Test;

public class DataSourceTest {
	
	@Test
	public void dbcpDataSourceTest() {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			//获取数据库连接
			conn = JdbcUtils_DBCP.getConnection();
			String sql = "insert into test1(name) values(?)";
			st = conn.prepareStatement(sql);
			st.setString(1, "gacl");
			st.executeUpdate();
			//获取数据库自动生成的主键
			rs = st.getGeneratedKeys();
			if(rs.next()){
				System.out.println(rs.getInt(1));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//释放资源
			JdbcUtils_DBCP.release(conn, st, rs);
		}
	}
}
