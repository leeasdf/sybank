package xin.tianchuang.modules.spider.service;

import com.baomidou.mybatisplus.service.IService;

import xin.tianchuang.common.enums.BizInterfaceTypeEnum;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.modules.api.bean.api.loan.request.RiskManageBizPageReqDTO;
import xin.tianchuang.modules.spider.entity.EntReportLogEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author hui.deng
 * @email 
 * @date 2019-02-27 11:17:27
 */
public interface EntReportLogService extends IService<EntReportLogEntity> {

    PageUtils queryPage(Map<String, Object> params);

	EntReportLogEntity selectLastReportByTypeEntName(String name, BizInterfaceTypeEnum type, String creditCode);

	List<EntReportLogEntity> selectReportByTypeEntName(String name, BizInterfaceTypeEnum type, String creditCode);

	EntReportLogEntity selectLastReportByTypeEntNameBizCode(String name, BizInterfaceTypeEnum type, String creditCode,String bizCode);

	List<EntReportLogEntity> selectLastEightReportByTypeEntName(String name,
			BizInterfaceTypeEnum type, String creditCode);

	PageUtils queryPage(RiskManageBizPageReqDTO param, BizInterfaceTypeEnum type);
}

