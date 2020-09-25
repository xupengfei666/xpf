package test.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.mayidb.MallAppApplication;
import com.mayidb.pojo.DemoData;
import com.mayidb.service.impl.DemoService;

import common.enums.ConditionEnum;
import common.pojo.Where;

@SpringBootTest(classes = { MallAppApplication.class })
public class TestCommonService {
	
	public static final Logger log = LoggerFactory.getLogger(TestCommonService.class);
	
	public List<DemoData> list;

	public static int dataCount=10;
	@Before
	public void addDemoDatas() {
		long startTime=new Date().getTime();
		log.info("数据生产开始=="+ startTime);
		this.list = DemoService.getInstance().addDatas(dataCount);
		long endTime=new Date().getTime();
		long timeMllisecond=endTime-startTime;
		log.info("数据生产共用时间"+timeMllisecond+"毫秒！");
		JSONArray array= JSONArray.parseArray(JSON.toJSONString(list));
        log.info("数据生产成功"+array);
	}
	
	//@Test
	public void query() {
		long startTime=new Date().getTime();
		log.info("数据查询开始=="+ startTime);
		Where where=new Where("type","正式");
		try {
			@SuppressWarnings("unchecked")
			List<DemoData> plist = (List<DemoData>) DemoService.getInstance().query(list, where, null, null, null);
			long endTime=new Date().getTime();
			long timeMllisecond=endTime-startTime;
			log.info("数据查询共用时间"+timeMllisecond+"毫秒！");
			JSONArray array= JSONArray.parseArray(JSON.toJSONString(plist));
	        log.info("数据查询成功"+array);
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void queryWheres() {
		long startTime=new Date().getTime();
		log.info("多条件数据查询开始=="+ startTime);
		Where where=new Where("type","正式");
		Where where1=new Where(ConditionEnum.GE.toString(),"count","4");
		List<Where> wheres=new ArrayList<Where>();
		try {
			wheres.add(where);
			wheres.add(where1);
			@SuppressWarnings("unchecked")
			List<DemoData> plist = (List<DemoData>) DemoService.getInstance().query(list, wheres, null, null, null);
			long endTime=new Date().getTime();
			long timeMllisecond=endTime-startTime;
			log.info("多条件数据查询共用时间"+timeMllisecond+"毫秒！");
			JSONArray array= JSONArray.parseArray(JSON.toJSONString(plist));
	        log.info("多条件数据查询成功"+array);
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
