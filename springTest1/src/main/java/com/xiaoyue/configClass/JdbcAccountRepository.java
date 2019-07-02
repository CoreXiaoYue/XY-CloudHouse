package com.xiaoyue.configClass;

import javax.sql.DataSource;

public class JdbcAccountRepository implements AccountRepository {
	DataSource dataSource;

	public JdbcAccountRepository(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
}
