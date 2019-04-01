package xin.tianchuang.modules.spider.service;

import com.baomidou.mybatisplus.service.IService;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.modules.spider.entity.EntKtannouncePeopleInfoEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author hui.deng
 * @email 
 * @date 2019-01-28 16:31:02
 */
public interface EntKtannouncePeopleInfoService extends IService<EntKtannouncePeopleInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);

	Integer deleteByTableIdAndType(String tableId, int key);

	List<EntKtannouncePeopleInfoEntity> selectListByTableIdPeopleType(String tableId, int peopleType);
}

