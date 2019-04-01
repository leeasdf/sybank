package xin.tianchuang.modules.api.service;

import xin.tianchuang.modules.api.bean.api.tyc.response.Open365BaseinfoV3DTO;
import xin.tianchuang.modules.api.dto.TycApiRespDTO;

public interface Open365BaseinfoV3Handler {

	public Open365BaseinfoV3DTO saveData(TycApiRespDTO<Open365BaseinfoV3DTO> data);

}
