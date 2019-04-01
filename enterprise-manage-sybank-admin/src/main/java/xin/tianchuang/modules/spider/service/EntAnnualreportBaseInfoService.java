package xin.tianchuang.modules.spider.service;

import java.util.Map;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.modules.spider.entity.EntAnnualreportBaseInfoEntity;

import com.baomidou.mybatisplus.service.IService;

/**
 * 
 *
 * @author hui.deng
 * @email 
 * @date 2019-01-28 16:31:09
 */
public interface EntAnnualreportBaseInfoService extends IService<EntAnnualreportBaseInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);

	Integer deleteByEntNameReportYear(String entName, String reportYear);

	EntAnnualreportBaseInfoEntity selectByEntNameReportYear(String entName, String reportYear);
}

