package kr.or.ddit.batch.task;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import kr.or.ddit.batch.service.IBatchService;

@Component
public class DailyBatchTask {
	@Resource(name="batchService")
	private IBatchService batchService;
	//�Ŵ�1�� ���� 1�ÿ� ����
	
	@Scheduled(cron="* * 1 1 * *")
	public void dailyBatch(){
		batchService.dailyBatchYm(new SimpleDateFormat("yyyyMM").format(new Date()));
		
	}

}
