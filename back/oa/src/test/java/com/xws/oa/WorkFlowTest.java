package com.xws.oa;

import static org.junit.Assert.*;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.repository.Deployment;
import org.junit.Before;
import org.junit.Test;

public class WorkFlowTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	/**部署流程定义*/
    @Test
    public void deploymentProcessDefinition_classpath(){
    	ProcessEngineConfiguration processEngineConfiguration = ProcessEngineConfiguration.createStandaloneProcessEngineConfiguration();
        //连接数据库的配置
        processEngineConfiguration.setJdbcDriver("com.mysql.jdbc.Driver");
        processEngineConfiguration.setJdbcUrl("jdbc:mysql://localhost:3306/xws?useUnicode=true&characterEncoding=utf8");
        processEngineConfiguration.setJdbcUsername("root");
        processEngineConfiguration.setJdbcPassword("root");
        
        /**
             public static final String DB_SCHEMA_UPDATE_FALSE = "false";不能自动创建表，需要表存在
              public static final String DB_SCHEMA_UPDATE_CREATE_DROP = "create-drop";先删除表再创建表
              public static final String DB_SCHEMA_UPDATE_TRUE = "true";如果表不存在，自动创建表
         */
        processEngineConfiguration.setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);
        //工作流的核心对象，ProcessEnginee对象
        ProcessEngine processEngine = processEngineConfiguration.buildProcessEngine();
        Deployment deployment = processEngine.getRepositoryService() // 与流程定义和部署对象相关的Service
                            .createDeployment() // 创建一个部署对象
                            .name("breakApply") // 设置对应流程的名称
                            .addClasspathResource("diagrams/breakApply.bpmn") // 从Classpath的资源中加载，一次只能加载一个文件(windows与linux下面要区分)
                            .addClasspathResource("diagrams/breakApply.png") // 从Classpath的资源中加载，图片
                            .deploy(); // 完成部署

        System.out.println("部署Id："+deployment.getId()); // 部署Id：20001
        System.out.println("部署名称："+deployment.getName()); // 部署名称：流程定义
    }

}
