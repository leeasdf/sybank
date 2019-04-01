package xin.tianchuang.modules.spider.service;

import com.baomidou.mybatisplus.service.IService;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.modules.spider.entity.EntCourtAnnounceInfoEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author hui.deng
 * @email 
 * @date 2019-01-28 16:31:02
 */
public interface EntCourtAnnounceInfoService extends IService<EntCourtAnnounceInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);

	Integer deleteByEntName(String entName);

	List<EntCourtAnnounceInfoEntity> selectListByEntName(String name);

	List<EntCourtAnnounceInfoEntity> selectListByEntNameBltntype(String name, String bltntypename);

    Integer countAccused(String entName);
}

