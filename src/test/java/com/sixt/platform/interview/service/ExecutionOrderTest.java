package com.sixt.platform.interview.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class ExecutionOrderTest {

	ExecutionOrder executionOrder;

	@Before
	public void setUp() throws Exception {
		executionOrder = new ExecutionOrder();

	}

	@Test
	public void should_return_scriptId_when_script_has_no_dependencies() {
		Assert.assertEquals("1", executionOrder.run(new VulnerabilityScript(1, new ArrayList<Integer>())));
	}

	@Test
	public void should_return_first_dependency_if_only_one_then_current_script_id() {
		ArrayList<Integer> dependencies = new ArrayList<Integer>();
		dependencies.add(2);
		Assert.assertEquals("2,1", executionOrder.run(new VulnerabilityScript(1, dependencies)));


	}

	@Test
	public void should_return_all_dependencies_then_current_script_id() {
		ArrayList<Integer> dependencies = new ArrayList<Integer>();
		dependencies.add(2);
		dependencies.add(8);
		dependencies.add(5);
		Assert.assertEquals("5,8,2,1", executionOrder.run(new VulnerabilityScript(1, dependencies)));


	}
}
