package xin.tianchuang.config;

import java.util.Date;

import org.apache.ibatis.reflection.MetaObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import xin.tianchuang.common.enums.DataStatusEnum;

import com.baomidou.mybatisplus.mapper.MetaObjectHandler;

@Component
public class FillMetaObjectHandler extends MetaObjectHandler {

	private static final Logger LOGGER = LoggerFactory.getLogger(FillMetaObjectHandler.class);

	@Override
	public void insertFill(MetaObject metaObject) {
		LOGGER.debug("insert fill");
		this.setFieldValByName("dataStatus", DataStatusEnum.ACTIVE.key(), metaObject);
		//判断是否有值 有值不处理
		Object createTime = this.getFieldValByName("createTime", metaObject);
		if(null == createTime) {
			this.setFieldValByName("createTime", new Date(), metaObject);
		}
	}

	@Override
	public void updateFill(MetaObject metaObject) {
		LOGGER.debug("update fill");
		this.setFieldValByName("updateTime", new Date(), metaObject);
	}

}