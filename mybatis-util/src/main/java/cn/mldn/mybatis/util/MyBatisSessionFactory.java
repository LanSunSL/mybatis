package cn.mldn.mybatis.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisSessionFactory {
	private static final String CONFIG_FILE = "mybatis/mybatis.cfg.xml";
	private static final ThreadLocal<SqlSession> threadLocal = new ThreadLocal<SqlSession>();
	private static InputStream inputstream;
	private static SqlSessionFactory factory;
	static {
		try {
			inputstream = Resources.getResourceAsStream(CONFIG_FILE);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static SqlSessionFactory getSessionFactory() {
		if (factory == null) {
			createSessionFactory();
		}
		return factory;
	}
	public static void createSessionFactory() {
		factory = new SqlSessionFactoryBuilder().build(inputstream);
	}
	public static SqlSession getSession() {
		SqlSession session = threadLocal.get();
		if (session == null) {
			if (factory == null) {
				createSessionFactory();
			}
			session = factory.openSession();
			threadLocal.set(session);
		}
		return session;
	}

	public static void close() {
		SqlSession session = threadLocal.get();
		if (session != null) {
			session.close();
			threadLocal.remove();
		}
	}
}
