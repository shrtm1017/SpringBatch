package kr.or.ddit.batch;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Value;

import kr.or.ddit.yogult.model.CycleVo;
import kr.or.ddit.yogult.model.DailyVo;

public class yogultItemProcessor implements ItemProcessor<CycleVo, List<DailyVo>>{
	//spel�� ����jobParameter�� ���� �ޱ� ���ؼ��� �ش� bean�� �������� "step"
	@Value("#{jobParameters[ym]}")
	private String ym;
	@Override
	public List<DailyVo> process(CycleVo CycleVo) throws Exception {
//		String ym="201903";
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
		return dailyVoList;
	}


}
