package cn.mldn.mybatis.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import cn.mldn.mybatis.vo.Member;

public class TestMember {

	@Test
	public void testInsert() {

		try {
			InputStream inputstream = Resources.getResourceAsStream("mybatis/mybatis.cfg.xml");
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputstream);
			SqlSession session = factory.openSession();
			Member vo = new Member();
			vo.setMid("mldnjava001321");
			vo.setAge(32);
			System.out.println(session.insert("cn.mldn.mapping.MemberNS.doCreate", vo));
			session.commit();
			session.close();
			inputstream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
