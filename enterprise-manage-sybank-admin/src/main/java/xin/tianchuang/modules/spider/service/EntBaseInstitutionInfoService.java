package xin.tianchuang.modules.spider.service;

import com.baomidou.mybatisplus.service.IService;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.modules.spider.entity.EntBaseInstitutionInfoEntity;

import java.util.Map;

/**
 * 
 *
 * @author hui.deng
 * @email 
 * @date 2019-02-23 10:02:09
 */
public interface EntBaseInstitutionInfoService extends IService<EntBaseInstitutionInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);

	EntBaseInstitutionInfoEntity selectOneByName(String entName);
}

