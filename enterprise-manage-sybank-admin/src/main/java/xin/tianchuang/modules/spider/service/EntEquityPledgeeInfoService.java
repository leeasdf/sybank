package xin.tianchuang.modules.spider.service;

import com.baomidou.mybatisplus.service.IService;

import xin.tianchuang.common.enums.EntEquityPledgeeTypeEnum;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.modules.api.bean.api.loan.response.loan.EquityInfoPledgeeListDTO;
import xin.tianchuang.modules.spider.entity.EntEquityPledgeeInfoEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author hui.deng
 * @email 
 * @date 2019-01-28 16:31:04
 */
public interface EntEquityPledgeeInfoService extends IService<EntEquityPledgeeInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);

    Integer deleteByEntName(String entName);
    
	Integer deleteByEntNameAndRegNumberAndType(String entName,String regNumber, int type);

    List<EntEquityPledgeeInfoEntity> selectListByEntNameAndTypeAndRegNumber(String name, EntEquityPledgeeTypeEnum company, String regNumber);
}

