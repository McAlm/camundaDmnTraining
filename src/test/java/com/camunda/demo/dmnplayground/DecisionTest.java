package com.camunda.demo.dmnplayground;

import static org.camunda.bpm.engine.test.assertions.bpmn.BpmnAwareTests.*;
import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.logging.LogFactory;
import org.camunda.bpm.dmn.engine.DmnDecisionResult;
import org.camunda.bpm.dmn.engine.DmnDecisionResultEntries;
import org.camunda.bpm.dmn.engine.test.DmnEngineRule;
import org.camunda.bpm.engine.test.Deployment;
import org.camunda.bpm.engine.test.ProcessEngineRule;
import org.camunda.bpm.spring.boot.starter.test.helper.StandaloneInMemoryTestConfiguration;
import org.junit.Rule;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * Test case starting an in-memory database-backed Process Engine.
 */

public class DecisionTest {


	static {
		LogFactory.useSlf4jLogging(); // MyBatis
	}

	@Rule
	public final ProcessEngineRule processEngine = new StandaloneInMemoryTestConfiguration().rule();
	
	
	
	@Test
	@Deployment(resources = { "YOUR_DMN_NAME.dmn" })
	public void testHappyPath() throws FileNotFoundException {


		Map<String, Object> variables = new HashMap<String, Object>();
		//put your variables here
		variables.put("name", "value");

		
		DmnDecisionResult result = decisionService().evaluateDecisionByKey("YOUR_DECISION_NAME")
				.variables(variables)
				.evaluate();
		
	    List<Map<String, Object>> resultList = result.getResultList();
	    
	    //make assertions here


	}

}
