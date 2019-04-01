package xin.tianchuang.modules.spider.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import xin.tianchuang.common.enums.BizInterfaceTypeEnum;
import xin.tianchuang.common.enums.DataStatusEnum;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;
import xin.tianchuang.modules.api.bean.api.loan.request.RiskManageBizPageReqDTO;
import xin.tianchuang.modules.spider.dao.EntReportLogDao;
import xin.tianchuang.modules.spider.entity.EntReportLogEntity;
import xin.tianchuang.modules.spider.service.EntReportLogService;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

@Service("entReportLogService")
public class EntReportLogServiceImpl extends ServiceImpl<EntReportLogDao, EntReportLogEntity> implements EntReportLogService {

	@Override
	public PageUtils queryPage(Map<String, Object> params) {
		Page<EntReportLogEntity> page = this.selectPage(new Query<EntReportLogEntity>(params).getPage(), new EntityWrapper<EntReportLogEntity>());

		return new PageUtils(page);
	}

	@Override
	public EntReportLogEntity selectLastReportByTypeEntName(String name, BizInterfaceTypeEnum type, String creditCode) {
		Wrapper<EntReportLogEntity> ew = new EntityWrapper<EntReportLogEntity>();
		ew.eq("ent_name", name);
		ew.eq("credit_code", creditCode);
		ew.eq("data_status", DataStatusEnum.ACTIVE.key());
		if (null != type) {
			ew.eq("interface_type", type.key());
		}
		ew.orderBy("create_time desc ");
		List<EntReportLogEntity> entReportLogEntities = this.baseMapper.selectList(ew);
		if (null == entReportLogEntities || entReportLogEntities.size() == 0) {
			return null;
		}
		return entReportLogEntities.get(0);

	}

	@Override
	public List<EntReportLogEntity> selectReportByTypeEntName(String name, BizInterfaceTypeEnum type, String creditCode) {
		Wrapper<EntReportLogEntity> ew = new EntityWrapper<EntReportLogEntity>();
		ew.eq("ent_name", name);
		ew.eq("credit_code", creditCode);
		ew.eq("data_status", DataStatusEnum.ACTIVE.key());
		if (null != type) {
			ew.eq("interface_type", type.key());
		}
		ew.orderBy("create_time desc ");
		return this.baseMapper.selectList(ew);
	}

	@Override
	public EntReportLogEntity selectLastReportByTypeEntNameBizCode(String name, BizInterfaceTypeEnum type, String creditCode, String bizCode) {
		Wrapper<EntReportLogEntity> ew = new EntityWrapper<EntReportLogEntity>();
		ew.eq("ent_name", name);
		// ew.eq(StrUtil.isNotBlank(creditCode),"credit_code", creditCode);
		ew.eq("data_status", DataStatusEnum.ACTIVE.key());
		ew.eq("biz_code", bizCode);
		if (null != type) {
			ew.eq("interface_type", type.key());
		}
		ew.orderBy("create_time desc ");
		List<EntReportLogEntity> entReportLogEntities = this.baseMapper.selectList(ew);
		if (entReportLogEntities.size() == 0) {
			return null;
		}
		return entReportLogEntities.get(0);
	}

	@Override
	public List<EntReportLogEntity> selectLastEightReportByTypeEntName(String name, BizInterfaceTypeEnum type, String creditCode) {
		Wrapper<EntReportLogEntity> ew = new EntityWrapper<EntReportLogEntity>();
		ew.eq("ent_name", name);
		// ew.eq(StrUtil.isNotBlank(creditCode),"credit_code", creditCode);
		ew.eq("data_status", DataStatusEnum.ACTIVE.key());
		if (null != type) {
			ew.eq("interface_type", type.key());
		}
		ew.orderBy("create_time desc ");
		List<EntReportLogEntity> entReportLogEntities = this.baseMapper.selectList(ew);
		if (entReportLogEntities.size() > 8) {
			return entReportLogEntities.subList(0, 8);
		}
		return entReportLogEntities;
	}

	@Override
	public PageUtils queryPage(RiskManageBizPageReqDTO param, BizInterfaceTypeEnum type) {
		Integer pageSize = param.getPageSize();
		Integer currPage = param.getPage();
		pageSize = pageSize == null || pageSize < 1 ? 50 : pageSize;
		currPage = currPage == null || currPage < 1 ? 1 : currPage;
		int totalCount = getTotalCount(param, type);
		List<EntReportLogEntity> logEntityList = selectPageList(param, type, (currPage - 1) * pageSize, currPage * pageSize);

		return new PageUtils(logEntityList, totalCount, pageSize, currPage);
	}

	public List<EntReportLogEntity> selectPageList(RiskManageBizPageReqDTO param, BizInterfaceTypeEnum type, int startRows, int endRows) {
		Integer typeStr = null;
		if (null != type) {
			typeStr = type.key();
		}
		return baseMapper.selectPage(typeStr, param.getStartTime(), param.getEndTime(), startRows, endRows);
	}

	public int getTotalCount(RiskManageBizPageReqDTO param, BizInterfaceTypeEnum type) {
		Wrapper<EntReportLogEntity> ew = new EntityWrapper<EntReportLogEntity>();
		// ew.eq(StrUtil.isNotBlank(creditCode),"credit_code", creditCode);
		ew.eq("data_status", DataStatusEnum.ACTIVE.key());
		if (null != type) {
			ew.eq("interface_type", type.key());
		}
		ew.ge("create_time", param.getStartTime());
		ew.le("create_time", param.getEndTime());
		return selectCount(ew);
	}
}
