package kr.or.ddit.yogult.batch;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.or.ddit.yogult.dao.IYogultDao;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:kr/or/ddit/config/spring/context-batch.xml"})
public class YogultDaoTest {
	@Resource(name="yogultDao")
	private IYogultDao yogultDao;
	@Test
	public void testDailybatchYm() {
		String ym = "201904";
		yogultDao.deleteDailyYm(ym);
		int insertCnt =yogultDao.dailyBatchYm(ym);
		assertTrue(insertCnt >50);
	}

}
