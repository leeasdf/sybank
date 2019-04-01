package xin.tianchuang.modules.spider.service.impl;


import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import xin.tianchuang.common.enums.DataStatusEnum;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;
import xin.tianchuang.modules.spider.dao.EntCopyRegWorksDao;
import xin.tianchuang.modules.spider.entity.EntCopyRegWorksEntity;
import xin.tianchuang.modules.spider.service.EntCopyRegWorksService;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;


@Service("entCopyRegWorksService")
public class EntCopyRegWorksServiceImpl extends ServiceImpl<EntCopyRegWorksDao, EntCopyRegWorksEntity> implements EntCopyRegWorksService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<EntCopyRegWorksEntity> page = this.selectPage(
                new Query<EntCopyRegWorksEntity>(params).getPage(),
                new EntityWrapper<EntCopyRegWorksEntity>()
        );

        return new PageUtils(page);
    }

	@Override
	public Integer deleteByEntName(String entName) {
		Wrapper<EntCopyRegWorksEntity> ew = new EntityWrapper<EntCopyRegWorksEntity>();
		ew.eq("ent_name", entName);
		return this.baseMapper.delete(ew);
	}

	@Override
	public List<EntCopyRegWorksEntity> selectByEntName(String entName) {
		Wrapper<EntCopyRegWorksEntity> ew = new EntityWrapper<EntCopyRegWorksEntity>();
		ew.eq("ent_name", entName);
		ew.eq("data_status", DataStatusEnum.ACTIVE.key());
		return this.baseMapper.selectList(ew);
	}
	@Override
	public boolean insertBatch(List<EntCopyRegWorksEntity> list) {
		return baseMapper.insertBatch(list);
		
	}
}
