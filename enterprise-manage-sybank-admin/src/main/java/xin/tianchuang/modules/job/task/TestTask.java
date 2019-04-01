package xin.tianchuang.modules.job.task;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import xin.tianchuang.modules.api.dto.SysTaskRespDTO;
import xin.tianchuang.modules.sys.entity.SysUserEntity;
import xin.tianchuang.modules.sys.service.SysUserService;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 测试定时任务(演示Demo，可删除)
 *
 * testTask为spring bean的名称
 *
 * @author xx
 * @since 1.2.0 2016-11-28
 */
@Component("testTask")
public class TestTask {
	private static  Logger logger = LoggerFactory.getLogger(TestTask.class);

	@Autowired
	private SysUserService sysUserService;

	public void test(String params){
		logger.info("我是带参数的test方法，正在被执行，参数为：" + params);



		SysUserEntity user = sysUserService.selectById(1L);
		logger.info(ToStringBuilder.reflectionToString(user));

	}


	public void test2(){
		logger.info("我是不带参数的test2方法，正在被执行");
	}


	public static void main(String[] arg){
		try {
			ExecutorService executor = Executors.newFixedThreadPool(5);
			List<Future<Integer>> futureList = new ArrayList<Future<Integer>>(5);
			for(int i=0; i<5;i++) {
				Future future = executor.submit(() -> {
					try {
						Thread.sleep(5000L);
					} catch (Exception e) {

					}
					return 1;
				});
				futureList.add(future);
			}
			int total=0;
			logger.info(" future.size()={}" ,futureList.size());
			// 遍历一遍
			while (futureList.size()>0) {
				Iterator<Future<Integer>> futureIterable = futureList.iterator();
				while (futureIterable.hasNext()) {
					Future<Integer> future = futureIterable.next();
					if (future.isDone() && !future.isCancelled()) {
						Integer i = future.get();
						total+=i;
						logger.info("子线程 结束了 {}", total);
						futureIterable.remove();
						logger.info(" future.size()={}" ,futureList.size());
					} else {
						// 避免CPU高速轮循，可以休息一下。
						Thread.sleep(1);
					}
				}

			}

			logger.info("全部 结束了 {}, future.size()={}" , total ,futureList.size());
		} catch (Exception e) {
			logger.info("异常 结束了" );
		}
	}
}
