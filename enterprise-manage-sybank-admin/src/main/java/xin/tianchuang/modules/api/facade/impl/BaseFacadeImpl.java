package xin.tianchuang.modules.api.facade.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xin.tianchuang.common.component.dozer.EjbDozerGenerator;

/**
 * 天眼查对外-公司背景接口
 * 
 * @author denghui
 *
 */
@Service
public class BaseFacadeImpl {
	@Autowired
	protected EjbDozerGenerator ejbGenerator;

	protected final Logger logger = LoggerFactory.getLogger(getClass());

}
