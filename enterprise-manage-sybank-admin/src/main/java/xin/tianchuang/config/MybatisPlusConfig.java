package xin.tianchuang.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.baomidou.mybatisplus.enums.DBType;
import com.baomidou.mybatisplus.mapper.MetaObjectHandler;
import com.baomidou.mybatisplus.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.plugins.PaginationInterceptor;

/**
 * mybatis-plus配置
 *
 * @author xx
 * @since 2.0.0 2018-02-05
 */
@EnableTransactionManagement
@Configuration
public class MybatisPlusConfig {

	/**
	 * 分页插件
	 */
	@Bean
	public PaginationInterceptor paginationInterceptor() {
		PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
		paginationInterceptor.setDialectType(DBType.DB2.name());
		return paginationInterceptor;
	}

	// 乐观锁插件
	// 注解实体字段 @Version 必须要!
	// ①支持的数据类型只有:int,Integer,long,Long,Date,Timestamp,LocalDateTime，整数类型下 newVersion = oldVersion + 1,
	// newVersion 会回写到entity 中
	// ②仅支持 updateById(id) 与 update(entity, wrapper) 方法
	// ③在 update(entity, wrapper) 方法下, wrapper 不能复用
	@Bean
	public OptimisticLockerInterceptor optimisticLockerInterceptor() {
		return new OptimisticLockerInterceptor();
	}

	// 执行分析插件，仅仅用于开发环境
	// @Bean
	// public SqlExplainInterceptor sqlExplainInterceptor() {
	// return new SqlExplainInterceptor();
	// }

	// 性能分析插件，仅仅用于开发环境
	// @Bean
	// public PerformanceInterceptor performanceInterceptor() {
	// return new PerformanceInterceptor();
	// }

	/**
	 * 
	 * @return
	 */
	@Bean
	public MetaObjectHandler metaObjectHandler() {
		return new FillMetaObjectHandler();
	}

	/**
	 * 注入主键生成器
	 */
	// @Bean
	// public IKeyGenerator keyGenerator() {
	// return new H2KeyGenerator();
	// }

	/**
	 * 注入sql注入器
	 */
	// @Bean
	// public ISqlInjector sqlInjector(){
	// return new LogicSqlInjector();
	// }

//	@Bean
//	public GlobalConfiguration globalConfiguration() {
//		GlobalConfiguration conf = new GlobalConfiguration();
//		conf.setKeyGenerator(new DB2KeyGenerator());
//		conf.setDbType(DBType.DB2.name());
//		return conf;
//	}

}
