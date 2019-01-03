package com.xws.oa;

import static org.junit.Assert.*;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.runtime.ProcessInstance;
import org.junit.Before;
import org.junit.Test;

public class StartProcessTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	@Test
    public void startProcessInstance(){
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
        String processDefinitionKey = "myProcess"; // 使用Key的启动，默认按照对心版本的流程定义启动
        ProcessInstance pi = processEngine.getRuntimeService() // 与正在执行的流程实例和执行对象相关的Service
                        .startProcessInstanceByKey(processDefinitionKey); // 使用流程定义的Key启动流程实例，key对应helloworld.bpmn文件中的流程名称
        
        System.out.println("流程实例Id"+pi.getId()); // 流程实例Id：57501
        System.out.println("流程定义Id"+pi.getProcessDefinitionId()); // 流程定义Id：psocessVariables:1:55004
    }

}
