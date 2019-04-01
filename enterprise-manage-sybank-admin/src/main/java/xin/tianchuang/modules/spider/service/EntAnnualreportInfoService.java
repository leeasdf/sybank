package xin.tianchuang.modules.spider.service;

import com.baomidou.mybatisplus.service.IService;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.modules.spider.entity.EntAnnualreportInfoEntity;

import java.util.Map;

/**
 * 
 *
 * @author hui.deng
 * @email
 * @date 2019-01-28 16:31:09
 */
public interface EntAnnualreportInfoService extends IService<EntAnnualreportInfoEntity> {

	PageUtils queryPage(Map<String, Object> params);

	Integer deleteByEntNameBlongYear(String entName, String belongYear);

	EntAnnualreportInfoEntity selectByEntNameBelongYear(String entName, String belongYear);
}
