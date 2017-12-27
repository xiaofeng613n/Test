package com.xiaofeng.mybatis.plugin;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.plugin.*;

import java.sql.Connection;
import java.util.Properties;

/**
 * Created by xiao on 2017/6/12.
 */
@Intercepts({@Signature(type = StatementHandler.class,method = "prepare", args = { Connection.class, Integer.class}) })
public class SqlPrintPlugin implements Interceptor
{
	@Override
	public Object intercept(Invocation invocation) throws Throwable
	{
		StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
		BoundSql boundSql = statementHandler.getBoundSql();
		String sql = boundSql.getSql();
		System.out.println("sql:"+ sql);
		return invocation.proceed();
	}

	@Override
	public Object plugin(Object target)
	{
		return Plugin.wrap(target,this);
	}

	@Override
	public void setProperties(Properties properties)
	{
		String dialect = properties.getProperty("dialect");
		System.out.println("mybatis intercept dialect:" + dialect);
	}
}
