package kr.or.ddit.batch.hello;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;
									//processor�� ���� �Ѱܹ޴� Ÿ��
public class HelloWriter implements ItemWriter<String>{
	
	private Logger logger = LoggerFactory.getLogger(HelloWriter.class);
	
	//chunk : �ѹ��� ����� ����� ���� �� �ִ�.
	@Override
	public void write(List<? extends String> rangers) throws Exception {
		for(String ranger: rangers){
			logger.debug("writer: {}",ranger);
		}
		
	}

}
