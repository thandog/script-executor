package com.sixt.platform.interview.service;

/**
 * Execute the scripts in the given order and make an
 * assumption that they are inserted in the intended order
 * of dependency into the database
 */
public class ExecutionOrder {

	public String run(VulnerabilityScript vulnerabilityScript) {

		String result = String.valueOf(vulnerabilityScript.getScriptId());

		for (int scriptId :vulnerabilityScript.getDependencies()) {
			result = scriptId+","+result;
        }
		return result;
	}
}

