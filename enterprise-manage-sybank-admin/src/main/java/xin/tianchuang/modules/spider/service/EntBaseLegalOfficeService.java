package xin.tianchuang.modules.spider.service;

import com.baomidou.mybatisplus.service.IService;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.modules.spider.entity.EntBaseLegalOfficeEntity;

import java.util.Map;

/**
 * 企业法人所有公司信息
 *
 * @author hui.deng
 * @email 
 * @date 2019-02-23 10:02:12
 */
public interface EntBaseLegalOfficeService extends IService<EntBaseLegalOfficeEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

