package com.xws.oa.config;

import java.io.IOException;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

@Configuration
public class SessionFactoryConfiguration {
	
	//mybatis配置文件
	@Value("${mybatisConfiguration}")
	private Resource myBatisConfigLocation;
	
	//mybatis xml文件路径
	@Value("${mybatis.mapper-locations}")
	private String mapperPath;
	
	//数据库连接池
	@Autowired
	@Qualifier("dataSource")
	private DataSource dataSource;
	
	//实体类包路径
	@Value("${mybatis.type-aliases-package}")
	private String entityPackage;

	/**
	 * session构建
	 * @return
	 * @throws IOException
	 */
	@Bean(name="sqlSessionFactory")
	public SqlSessionFactoryBean createSqlSessionFactory() throws IOException{
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setConfigLocation(myBatisConfigLocation);
		PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		String packageSeachPath = PathMatchingResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX + mapperPath;
		sqlSessionFactoryBean.setMapperLocations(resolver.getResources(packageSeachPath));
		sqlSessionFactoryBean.setDataSource(dataSource);
		sqlSessionFactoryBean.setTypeAliasesPackage(entityPackage);
		return sqlSessionFactoryBean;
	}

}
