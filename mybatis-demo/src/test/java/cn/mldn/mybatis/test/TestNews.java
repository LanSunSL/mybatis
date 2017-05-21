package cn.mldn.mybatis.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import cn.mldn.mybatis.util.MyBatisSessionFactory;
import cn.mldn.mybatis.vo.News;

public class TestNews {

	@Test
	public void testInsert() {
		News vo = new News();
		vo.setTitle("Hello World");
		vo.setNote("News, Big News");
		System.out.println(MyBatisSessionFactory.getSession().insert("cn.mldn.mapping.NewsNS.doCreate", vo));
		System.out.println(vo);
		MyBatisSessionFactory.getSession().commit();
		MyBatisSessionFactory.close();

	}

	@Test
	public void testUpdate() {
		News vo = new News();
		vo.setNid(17L);
		vo.setTitle("XXX");
		vo.setNote("dodododo");
		System.out.println(MyBatisSessionFactory.getSession().update("cn.mldn.mapping.NewsNS.doUpdate", vo));
		System.out.println(vo);
		MyBatisSessionFactory.getSession().commit();
		MyBatisSessionFactory.close();
	}

	@Test
	public void testDelete() {
		System.out.println(MyBatisSessionFactory.getSession().delete("cn.mldn.mapping.NewsNS.doRemove", 14L));
		MyBatisSessionFactory.getSession().commit();
		MyBatisSessionFactory.close();
	}

	@Test
	public void testGet() {
		News vo = MyBatisSessionFactory.getSession().selectOne("cn.mldn.mapping.NewsNS.findById", 18L);
		System.out.println(vo);
		MyBatisSessionFactory.close();
	}

	@Test
	public void testList() {
		List<News> all = MyBatisSessionFactory.getSession().selectList("cn.mldn.mapping.NewsNS.findAll");
		System.out.println(all);
		MyBatisSessionFactory.close();
	}

	@Test
	public void testMap() {
		System.out.println(MyBatisSessionFactory.getSession().selectMap("cn.mldn.mapping.NewsNS.findMap", "nid"));
		MyBatisSessionFactory.close();
	}

	@Test
	public void testSplitAndCount() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("column", "title");
		map.put("keyWord", "%e%");
		map.put("start", 1);
		map.put("lineSize", 10);
		System.out.println(MyBatisSessionFactory.getSession().selectList("cn.mldn.mapping.NewsNS.findAllSplit", map));
		long count = MyBatisSessionFactory.getSession().selectOne("cn.mldn.mapping.NewsNS.getAllCount", map);
		System.out.println(count);
	}
}
