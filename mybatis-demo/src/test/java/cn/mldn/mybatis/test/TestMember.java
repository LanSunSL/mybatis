package cn.mldn.mybatis.test;

import org.junit.Test;

import cn.mldn.mybatis.util.MyBatisSessionFactory;
import cn.mldn.mybatis.vo.Member;

public class TestMember {

	@Test
	public void testInsert() {
		Member vo = new Member();
		vo.setMid("mldnjava");
		vo.setAge(32);
		System.out.println(MyBatisSessionFactory.getSession().insert("cn.mldn.mapping.MemberNS.doCreate", vo));
		MyBatisSessionFactory.getSession().commit();
		MyBatisSessionFactory.close();
	}

}
