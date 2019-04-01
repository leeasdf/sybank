package xin.tianchuang.modules.spider.service;

import com.baomidou.mybatisplus.service.IService;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.modules.spider.entity.EntAnnualreportOutGuaranteeInfoEntity;

import java.util.Map;

/**
 * 
 *
 * @author hui.deng
 * @email 
 * @date 2019-01-28 16:31:08
 */
public interface EntAnnualreportOutGuaranteeInfoService extends IService<EntAnnualreportOutGuaranteeInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);

	Integer deleteByEntNameBelongYear(String entName, String belongYear);
}

