package kr.or.ddit.yogult.batch;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.yogult.model.CycleVo;
import kr.or.ddit.yogult.model.DailyVo;

public class DateTest {

private Logger logger = LoggerFactory.getLogger(DateTest.class);
	@Test
	public void test() throws ParseException {
		String ym = "201903";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		
		Date stDate =sdf.parse(ym+"01");//��������
		Calendar cal = Calendar.getInstance();
		cal.setTime(stDate);
		int lastDay=cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		Date edDate = sdf.parse(ym+lastDay);
		assertEquals("20190301", sdf.format(stDate));
		assertEquals("20190331", sdf.format(edDate));
	}
	
	@Test
	public void testDt() throws ParseException{
		String ym="201903";
		CycleVo CycleVo = new CycleVo();
		CycleVo.setCid(1);
		CycleVo.setPid(100);
		CycleVo.setDay(2);
		CycleVo.setCnt(2);
		//�ش����� ���� ���� : 1��
		//�ش����� �������� : 28��,29��,30��,31��
		//1�� ���� 100�� ��ǰ�� 2(������)���ϳ� 3���� �Դ´�.
		//1 100 2 3
		//1 100 2019304 3
		//1 100 2019311 3
		//1 100 2019318 3
		//1 100 2019325 3
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Date stDate = sdf.parse(ym+"01");
		Calendar cal = Calendar.getInstance();
		int lastDay =cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		Date edDate = sdf.parse(ym+lastDay);
		
		
		//��������,��������
		
		List<DailyVo> dailyVoList = new ArrayList<DailyVo>();
		while(cal.getTimeInMillis()<=edDate.getTime()){
			int dayofWeek=cal.get(Calendar.DAY_OF_WEEK);
			//�ָ��ֱ� �����̶� cal ��¥������ ������ �Ͻ������� ������ ��� ����
			if(dayofWeek == CycleVo.getDay()){
				DailyVo dailyvo =new DailyVo();
				dailyvo .setCid(CycleVo.getCid());
				dailyvo .setCnt(CycleVo.getCnt());
				dailyvo .setPid(CycleVo.getPid());
				dailyvo .setDt(sdf.format(cal.getTime()));
				dailyVoList.add(dailyvo);
			}
			cal.add(Calendar.DAY_OF_MONTH,1);
		}
		logger.debug(""+dailyVoList);
	}


}
