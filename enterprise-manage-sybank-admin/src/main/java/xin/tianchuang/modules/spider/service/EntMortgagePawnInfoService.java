package xin.tianchuang.modules.spider.service;

import com.baomidou.mybatisplus.service.IService;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.modules.spider.entity.EntMortgagePawnInfoEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author hui.deng
 * @email 
 * @date 2019-01-28 16:31:05
 */
public interface EntMortgagePawnInfoService extends IService<EntMortgagePawnInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<EntMortgagePawnInfoEntity> selectListByEntNameAndRegNum(String name, String regNum);

    Integer deleteByEntNameAndRegNum(String entName, String regNum);
}

