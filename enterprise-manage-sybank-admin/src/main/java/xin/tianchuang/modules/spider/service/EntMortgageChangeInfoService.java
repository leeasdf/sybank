package xin.tianchuang.modules.spider.service;

import com.baomidou.mybatisplus.service.IService;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.modules.spider.entity.EntMortgageChangeInfoEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author hui.deng
 * @email 
 * @date 2019-01-28 16:31:04
 */
public interface EntMortgageChangeInfoService extends IService<EntMortgageChangeInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<EntMortgageChangeInfoEntity> selectListByEntNameAndRegNum(String name, String regNum);

    Integer deleteByEntNameAndRegNum(String entName, String regNum);
}

