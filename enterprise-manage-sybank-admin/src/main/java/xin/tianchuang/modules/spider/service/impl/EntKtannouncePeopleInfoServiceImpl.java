package xin.tianchuang.modules.spider.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import xin.tianchuang.common.enums.DataStatusEnum;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;
import xin.tianchuang.modules.spider.dao.EntKtannouncePeopleInfoDao;
import xin.tianchuang.modules.spider.entity.EntAbnormalInfoEntity;
import xin.tianchuang.modules.spider.entity.EntKtannouncePeopleInfoEntity;
import xin.tianchuang.modules.spider.service.EntKtannouncePeopleInfoService;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

@Service("entKtannouncePeopleInfoService")
public class EntKtannouncePeopleInfoServiceImpl extends ServiceImpl<EntKtannouncePeopleInfoDao, EntKtannouncePeopleInfoEntity> implements EntKtannouncePeopleInfoService {

	@Override
	public PageUtils queryPage(Map<String, Object> params) {
		Page<EntKtannouncePeopleInfoEntity> page = this.selectPage(new Query<EntKtannouncePeopleInfoEntity>(params).getPage(), new EntityWrapper<EntKtannouncePeopleInfoEntity>());

		return new PageUtils(page);
	}

	@Override
	public Integer deleteByTableIdAndType(String tableId, int key) {
		Wrapper<EntKtannouncePeopleInfoEntity> ew = new EntityWrapper<EntKtannouncePeopleInfoEntity>();
		ew.eq("table_id", tableId);
		ew.eq("people_type", key);
		return this.baseMapper.delete(ew);
	}

	@Override
	public List<EntKtannouncePeopleInfoEntity> selectListByTableIdPeopleType(String tableId, int peopleType) {
		Wrapper<EntKtannouncePeopleInfoEntity> ew = new EntityWrapper<EntKtannouncePeopleInfoEntity>();
		ew.eq("table_id", tableId);
		ew.eq("data_status", DataStatusEnum.ACTIVE.key());
		ew.eq("people_type", peopleType);
		return this.baseMapper.selectList(ew);
	}
	@Override
	public boolean insertBatch(List<EntKtannouncePeopleInfoEntity> list) {
		return baseMapper.insertBatch(list);
		
	}

}
