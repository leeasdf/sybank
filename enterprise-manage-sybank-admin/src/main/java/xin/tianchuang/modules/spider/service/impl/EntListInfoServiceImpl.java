package xin.tianchuang.modules.spider.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import xin.tianchuang.common.enums.DataStatusEnum;
import xin.tianchuang.common.enums.tcxy.TcxyApiStatusCodeEnum;
import xin.tianchuang.common.exception.ApiException;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;
import xin.tianchuang.modules.spider.dao.EntListInfoDao;
import xin.tianchuang.modules.spider.entity.EntListInfoEntity;
import xin.tianchuang.modules.spider.service.EntListInfoService;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

@Service("entListInfoService")
public class EntListInfoServiceImpl extends ServiceImpl<EntListInfoDao, EntListInfoEntity> implements EntListInfoService {

	@Override
	public PageUtils queryPage(Map<String, Object> params) {
		Page<EntListInfoEntity> page = this.selectPage(new Query<EntListInfoEntity>(params).getPage(), new EntityWrapper<EntListInfoEntity>());

		return new PageUtils(page);
	}

	@Override
	public EntListInfoEntity selectOneByName(String name) {
		EntListInfoEntity entity = new EntListInfoEntity();
		entity.setName(name);
		return this.baseMapper.selectOne(entity);
	}

	@Override
	public EntListInfoEntity selectOneByCreditCode(String creditCode) {
		EntListInfoEntity entity = new EntListInfoEntity();
		entity.setCreditCode(creditCode);
		return this.baseMapper.selectOne(entity);
	}

	@Override
	public List<EntListInfoEntity> selectByCreateDate(String beginDate) {
		Wrapper<EntListInfoEntity> ew = new EntityWrapper<EntListInfoEntity>();
		ew.ge("create_time", beginDate);
		ew.eq("data_status", DataStatusEnum.ACTIVE.key());
		ew.orderBy("create_time", false);
		return this.baseMapper.selectList(ew);
	}

	@Override
	public EntListInfoEntity selectOneByTycId(Long tycTableId) {
		EntListInfoEntity entity = new EntListInfoEntity();
		entity.setTycId(tycTableId);
		return this.baseMapper.selectOne(entity);
	}

	@Override
	public EntListInfoEntity selectByNameEntityType(String name, Integer entityType) {
		EntListInfoEntity entity = new EntListInfoEntity();
		entity.setName(name);
		entity.setEntityType(entityType);
		return this.baseMapper.selectOne(entity);
	}

	@Override
	public EntListInfoEntity selectByNameCreditCode(String name, String creditCode) {
		if (StringUtils.isBlank(name) && StringUtils.isBlank(creditCode)) {
			throw new ApiException("企业名称和统一社会信用代码不能同时为空", TcxyApiStatusCodeEnum.PARAM_ERR.key());
		}

		EntListInfoEntity entity = new EntListInfoEntity();
		if (StringUtils.isNotBlank(name)) {
			entity.setName(name);
		}

		if (StringUtils.isNotBlank(creditCode)) {
			entity.setCreditCode(creditCode);
		}
		return this.baseMapper.selectOne(entity);
	}

	@Override
	public Integer getCount() {
		Wrapper<EntListInfoEntity> ew = new EntityWrapper<EntListInfoEntity>();
		ew.eq("data_status", DataStatusEnum.ACTIVE.key());
		return  this.baseMapper.selectCount(ew);
	}

	@Override
	public List<EntListInfoEntity> getPageEntInfo(Integer startNum, Integer size) {
		return this.baseMapper.getPageEntListInfo(startNum,size);
	}

	@Override
	public List<EntListInfoEntity> getAllNameAndIndustry() {
		Wrapper<EntListInfoEntity> ew = new EntityWrapper<EntListInfoEntity>();
		ew.eq("data_status", DataStatusEnum.ACTIVE.key());
		ew.setSqlSelect("name, industry");
		return  this.baseMapper.selectList(ew);
	}

	@Override
	public int updateRowsById(EntListInfoEntity entListInfoEntity) {
		return  this.baseMapper.updateById(entListInfoEntity);
	}

	@Override
	public List<EntListInfoEntity> getEntListByCreateTime(Date startTime, Date endTime) {
		Wrapper<EntListInfoEntity> ew = new EntityWrapper<EntListInfoEntity>();
		ew.eq("data_status", DataStatusEnum.ACTIVE.key())
		.ge("create_time",startTime).lt("create_time",endTime)
				.orderBy("create_time", false);
		return  this.baseMapper.selectList(ew);
	}
}
