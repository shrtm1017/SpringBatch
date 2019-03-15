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
	//spel을 통해jobParameter를 주입 받기 위해서는 해당 bean의 스코프가 "step"
	@Value("#{jobParameters[ym]}")
	private String ym;
	@Override
	public List<DailyVo> process(CycleVo CycleVo) throws Exception {
//		String ym="201903";
		//해당년월의 시작 일자 : 1일
		//해당년웡의 종료일자 : 28일,29일,30일,31일
		//1번 고객이 100번 제품으 2(월요일)요일날 3개를 먹는다.
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
		
		
		//시작일자,종료일자
		
		List<DailyVo> dailyVoList = new ArrayList<DailyVo>();
		while(cal.getTimeInMillis()<=edDate.getTime()){
			int dayofWeek=cal.get(Calendar.DAY_OF_WEEK);
			//애름주기 요일이랑 cal 날짜요일이 같으면 일실적으로 생성할 대상 일자
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
