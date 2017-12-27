package com.xiaofeng.rulebook;

import com.google.common.collect.Maps;
import groovy.lang.Binding;
import groovy.lang.GroovyCodeSource;
import groovy.lang.GroovyShell;
import groovy.lang.Script;
import lombok.Data;
import org.codehaus.groovy.control.CompilationFailedException;

import java.util.Map;

/**
 * Created by xiaofeng on 2017/12/23
 * Description:
 */
public class TestGroovy {
    public static void main(String[] args) {

        /* key 业务id */
//        Map<String,Rule> ruleMap = Maps.newHashMap();
//        ruleMap.put("1",new Rule("Long.parseLong(str.responseTime) > 100 && str.status == \"running\""));
//        ruleMap.put("2",new Rule("Long.parseLong(str.responseTime) > 10 && str.status == \"running\""));

        Map<String, Object> logMap = Maps.newHashMap();
		logMap.put("responseTime", "200");
		logMap.put("status", "running");


        Rule rule = new Rule("Long.parseLong(str.responseTime) > 10 && str.status == \"running\"");
        Object value;
        value = rule.getShell().cal(logMap);
        System.out.println(value);

        Map<String, Object> logMap1 = Maps.newHashMap();
        logMap1.put("responseTime", "1");
        logMap1.put("status", "running");
        value = rule.getShell().cal(logMap1);
        System.out.println(value);


    }

    @Data
    static class Rule{
        private String md5;
        private MyShell shell;

        Rule(String script){
            md5 = script;
            shell = new MyShell(script);
        }
    }

    static class MyShell extends GroovyShell{

        private String txt;
        private String scriptMd5;

        private Script script;

        MyShell(String txt){
            super(new Binding());
            evaluate(txt);
        }

        public Object cal(Map<String, Object> logMap){
            this.getContext().setVariable("str",logMap);
            //script.setBinding(this.getContext());
            return script.run();
        }

        public Object evaluate(GroovyCodeSource codeSource) throws CompilationFailedException {
            Script script = parse(codeSource);
            this.script = script;
            return null;
        }
//        protected synchronized String generateScriptName() {
//            return "Script" + scriptMd5 + ".groovy";
//        }

    }
}
