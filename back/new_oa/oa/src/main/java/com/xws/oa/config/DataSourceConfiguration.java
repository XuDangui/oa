package com.xws.oa.config;

import java.sql.SQLException;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

/**
 * 
 * 数据连接池配置
 *
 */
@Configuration
@MapperScan("com.xws.oa.dao")//指定dao层代码在哪个包
public class DataSourceConfiguration {
	
	//驱动
	@Value("${spring.datasource.driverClassName}")
	private String jdbcDriver;
	
	//数据库连接地址
	@Value("${spring.datasource.url}")
	private String jdbcUrl;
	
	//数据库用户名
	@Value("${spring.datasource.username}")
	private String username;
	
	//数据库密码
	@Value("${spring.datasource.password}")
	private String password;
	
	@Value("${loggerConfig}")
	private String loggerConfig;

	/**
	 * 配置数据库源连接池
	 * @return
	 * @throws SQLException
	 */
	@Bean(name="dataSource")
	public DruidDataSource createDataSource() throws SQLException{
		DruidDataSource dataSource = new DruidDataSource();
		dataSource.setDriverClassName(jdbcDriver);
		dataSource.setUrl(jdbcUrl);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		dataSource.setDefaultAutoCommit(false);
		dataSource.setFilters(loggerConfig);
		return dataSource;
	}

}
