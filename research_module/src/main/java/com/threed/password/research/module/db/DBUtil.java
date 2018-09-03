package com.threed.password.research.module.db;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import tech.sqldao.dbcon.DBConfig;
import tech.sqldao.dbcon.DBConfigException;


public class DBUtil {
	private static DataSource dataSource;
	static Logger logger = LoggerFactory.getLogger(DBUtil.class);

	/**
	 * Create a new data source
	 * 
	 * @return datasource
	 * @throws DBConfigException
	 */
	public static DataSource createDataSource() throws DBConfigException {

		DBConfig dbConf = DBConfig.loadDBConfig();

		String jdbcUrl = createJdbcUrl(dbConf);

		HikariConfig hikariConfig = new HikariConfig();
		hikariConfig.setJdbcUrl(jdbcUrl);
		hikariConfig.setUsername(dbConf.getDbUser());
		hikariConfig.setPassword(dbConf.getDbPasswd());
		hikariConfig.setConnectionTimeout(dbConf.getConTimeout() * 1000);
		hikariConfig.setMinimumIdle(dbConf.getMinIdleCons());
		hikariConfig.setMaximumPoolSize(dbConf.getMaxPoolSize());
		hikariConfig.setPoolName(dbConf.getPoolName());
		hikariConfig.setTransactionIsolation(dbConf.getTxIsolation());

		dataSource = new HikariDataSource(hikariConfig);
		return dataSource;
	}

	/**
	 * Create JDBC url using server addresses in db_config.xml, If it contains
	 * more than one server url consider first url as loadbalancer url and
	 * others as DB instance addresses
	 * 
	 * @param dbConf
	 * @return jdbc url
	 */
	private static String createJdbcUrl(DBConfig dbConf) {
		String[] addresses = dbConf.getServerAddresses();
		String jdbcUrl;
		if (addresses.length == 1) {
			jdbcUrl = "jdbc:mysql://" + addresses[0];
		} else {
			jdbcUrl = "jdbc:mysql:loadbalance://" + addresses[0];
			for (int i = 1; i < addresses.length; i++) {
				jdbcUrl += ',' + addresses[i];
			}
		}
		jdbcUrl += '/' + dbConf.getDbName();

		return jdbcUrl;
	}

	/**
	 * Cleanup created datasource
	 */
	public static void clean() {

		if (dataSource != null) {
			if (dataSource instanceof HikariDataSource) {
				((HikariDataSource) dataSource).close();
			}
			dataSource = null;
		} else {
			logger.warn("Data source is not setup. Did you call DBConnectionManager.init(DataSource dataSource)?");
		}

	}
}
