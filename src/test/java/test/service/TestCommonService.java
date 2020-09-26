package test.service;

import java.math.BigDecimal;
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
import common.pojo.GroupBy;
import common.pojo.OrderBy;
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
	
	/**
	 * @Title: query
	 * @Description: 重点测试多个条件
	 * @author: 许鹏飞
	 * @param:  参数说明
	 * @return: void 返回类型
	 * @throws
	 */
	@Test
	public void query() {
		long startTime=new Date().getTime();
		log.info("数据查询开始=="+ startTime);
		Where where=new Where();
		where.set("type", "正式");
		where.set("count", 3,ConditionEnum.GE.toString());
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
	
	
	/**
	 * @Title: queryOrderBy
	 * @Description: 重点测试多个排序
	 * @author: 许鹏飞
	 * @param:  参数说明
	 * @return: void 返回类型
	 * @throws
	 */
	@Test
	public void queryOrderBy() {
		long startTime=new Date().getTime();
		log.info("排序-->数据查询开始=="+ startTime);
		Where where=new Where();
		where.set("type", "正式");
		OrderBy orderBy=new OrderBy();
		orderBy.setProperty(new String[] {"count","money"});
		orderBy.setOrderType(new boolean[] {false,true});
		for(int i=0;i<dataCount;i++) {
			DemoData demoData = new DemoData();
			demoData.setName("正式"+i);
			demoData.setCount(i);
			demoData.setMoney(new BigDecimal(dataCount));
			demoData.setType("正式");
			list.add(demoData);
		}
		try {
			@SuppressWarnings("unchecked")
			List<DemoData> plist = (List<DemoData>) DemoService.getInstance().query(list, where, orderBy, null, null);
			long endTime=new Date().getTime();
			long timeMllisecond=endTime-startTime;
			log.info("排序-->数据查询共用时间"+timeMllisecond+"毫秒！");
			JSONArray array= JSONArray.parseArray(JSON.toJSONString(plist));
	        log.info("排序-->数据查询成功"+array);
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	/**
	 * @Title: queryGroupBy
	 * @Description: 多个group By的处理方式
	 * @author: 许鹏飞
	 * @param:  参数说明
	 * @return: void 返回类型
	 * @throws
	 */
	@Test
	public void queryGroupBy() {
		long startTime=new Date().getTime();
		log.info("GroupBy-->数据查询开始=="+ startTime);
		String[] propertys=new String[] {"type","moneyType"};
		GroupBy groupBy=new GroupBy(propertys);
		try {
			@SuppressWarnings("unchecked")
			List<DemoData> plist = (List<DemoData>) DemoService.getInstance().query(list, null, null, groupBy, null);
			long endTime=new Date().getTime();
			long timeMllisecond=endTime-startTime;
			log.info("GroupBy-->数据查询共用时间"+timeMllisecond+"毫秒！");
			JSONArray array= JSONArray.parseArray(JSON.toJSONString(plist));
	        log.info("GroupBy-->数据查询成功"+array);
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
