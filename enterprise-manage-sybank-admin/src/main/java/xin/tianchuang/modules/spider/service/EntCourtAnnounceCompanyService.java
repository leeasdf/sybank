package xin.tianchuang.modules.spider.service;

import com.baomidou.mybatisplus.service.IService;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.modules.spider.entity.EntCourtAnnounceCompanyEntity;

import java.util.Map;

/**
 * 
 *
 * @author hui.deng
 * @email
 * @date 2019-01-28 16:31:02
 */
public interface EntCourtAnnounceCompanyService extends IService<EntCourtAnnounceCompanyEntity> {

	PageUtils queryPage(Map<String, Object> params);

	Integer deleteByTycTableId(Long tableId);
}
