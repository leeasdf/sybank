package xin.tianchuang.modules.spider.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.modules.spider.entity.EntListInfoEntity;

import com.baomidou.mybatisplus.service.IService;

/**
 * 企业名录信息
 *
 * @author hui.deng
 * @email 
 * @date 2019-02-23 10:02:11
 */
public interface EntListInfoService extends IService<EntListInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);

	List<EntListInfoEntity> selectByCreateDate(String beginDate);

	EntListInfoEntity selectOneByName(String entName);

	EntListInfoEntity selectOneByCreditCode(String creditCode);

	EntListInfoEntity selectOneByTycId(Long tycTableId);

	EntListInfoEntity selectByNameEntityType(String name, Integer entityType);

	EntListInfoEntity selectByNameCreditCode(String name, String creditCode);

	Integer getCount();

	List<EntListInfoEntity> getPageEntInfo(Integer startNum, Integer pageSize);

    List<EntListInfoEntity> getAllNameAndIndustry();

	int updateRowsById(EntListInfoEntity entListInfoEntity);

    List<EntListInfoEntity> getEntListByCreateTime(Date startTime, Date endTime);
}

