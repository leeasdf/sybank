package xin.tianchuang.config;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.*;

/**
 * Created by lee on 2018/12/20.
 */
@Configuration
public class ThreadPoolConfig {
    //默认20个线程的线程池
    @Bean
    public ExecutorService getThreadPool(){
        ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("biz-sybank-pool-%d").build();
        ExecutorService executorService = new ThreadPoolExecutor(20, 20, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>(500), threadFactory);
        return executorService;
    }

}
