package com.xiaofeng.rulebook;

import com.google.common.collect.Maps;
import groovy.lang.GroovyObject;
import groovy.util.GroovyScriptEngine;
import groovy.util.ResourceException;
import groovy.util.ScriptException;

import java.io.IOException;
import java.util.Map;

public class GroovyInJava {

	public static void main(String[] args) throws IOException, ResourceException, ScriptException, IllegalAccessException, InstantiationException {

		String[] roots = new String[] { "forest-prome/src/main/resources/" };
		//通过指定的roots来初始化GroovyScriptEngine
		GroovyScriptEngine gse = new GroovyScriptEngine(roots);
		GroovyObject groovyObject = (GroovyObject) gse.loadScriptByName("groovy/TestScript.groovy").newInstance();

		Map<String, Object> logMap = Maps.newHashMap();

		logMap.put("responseTime", "200");
		logMap.put("status", "running");

		Boolean result = (Boolean) groovyObject.invokeMethod("output", logMap);
		System.out.println(result);


	}
}
