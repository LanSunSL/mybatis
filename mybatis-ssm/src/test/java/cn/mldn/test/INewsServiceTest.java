package cn.mldn.test;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.mldn.service.INewsService;
import cn.mldn.vo.News;
import junit.framework.TestCase;
@ContextConfiguration(locations={"classpath:spring/spring-common.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class INewsServiceTest {
	@Resource
	private INewsService newService;
	@Test
	public void testAdd() {
		News vo = new News();
		vo.setTitle("hello");
		vo.setNote("iphone");
		TestCase.assertTrue(newService.add(vo));
	}

	@Test
	public void testList() {
		List<News> all = this.newService.list(1, 10, "note", "");
		System.out.println(all);
		TestCase.assertTrue(all.size() > 0);
	}

}
