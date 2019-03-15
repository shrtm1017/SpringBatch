package kr.or.ddit.batch;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.scheduling.annotation.Scheduled;

public class YogultTask {
	@Resource(name="jobLauncher")
		private JobLauncher jobLauncher;
	@Resource(name="yogultJJob")
		private Job yogultJob;
	//매당 1일 일실적 생성 배치잡 실행
	//초 분 시간 일 월 요일
	@Scheduled(cron="* * 1 1 * *")
		public void yogultDaitlyJob(){
		Map<String, JobParameter> map = new HashMap<String,JobParameter>();
		
		Date today =new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
		String ym =sdf.format(today);
		
//		yogtService.deleteDaily(ym);
		
		map.put("ym",new JobParameter(ym));
		try {
			jobLauncher.run(yogultJob,new JobParameters(map));
		} catch (JobExecutionAlreadyRunningException | JobRestartException | JobInstanceAlreadyCompleteException
				| JobParametersInvalidException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			
		}

}
