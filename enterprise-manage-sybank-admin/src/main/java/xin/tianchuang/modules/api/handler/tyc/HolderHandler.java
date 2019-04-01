package xin.tianchuang.modules.api.handler.tyc;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import xin.tianchuang.common.enums.HolderCaptialEnum;
import xin.tianchuang.common.enums.tcxy.TcxyApiStatusCodeEnum;
import xin.tianchuang.modules.api.bean.api.tyc.BaseRespnseDTO;
import xin.tianchuang.modules.api.bean.api.tyc.request.BaseApiRequestDTO;
import xin.tianchuang.modules.api.bean.api.tyc.response.Open368HolderCapitalActlDTO;
import xin.tianchuang.modules.api.bean.api.tyc.response.Open368HolderCapitalDTO;
import xin.tianchuang.modules.api.bean.api.tyc.response.Open368HolderDTO;
import xin.tianchuang.modules.api.bean.api.tyc.response.ResponsePageNumResultDTO;
import xin.tianchuang.modules.api.dto.TycApiRespDTO;
import xin.tianchuang.modules.api.handler.QueryHandler;
import xin.tianchuang.modules.spider.entity.EntHolderCapitalEntity;
import xin.tianchuang.modules.spider.entity.EntHolderInfoEntity;

import xin.tianchuang.modules.spider.service.EntHolderCapitalService;
import xin.tianchuang.modules.spider.service.EntHolderInfoService;

import com.google.common.collect.Lists;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

/**
 * @author denghui
 */
public class HolderHandler implements QueryHandler<List<Open368HolderDTO>> {

    private static final Logger logger = LoggerFactory.getLogger(HolderHandler.class);

    @Autowired
    private EntHolderInfoService entHolderInfoService;
    @Autowired
    private EntHolderCapitalService entHolderCapitalService;

    @Override
    public BaseRespnseDTO<List<Open368HolderDTO>> parseData(BaseApiRequestDTO param, String apiData) {
        // http://124.207.122.29:18080/dmp-service-web/service/tianyancha/holder?appId=a8e319a8b6f64b3e91024e7792a2c701&companyName=%E8%85%BE%E8%AE%AF%E7%A7%91%E6%8A%80%EF%BC%88%E6%B7%B1%E5%9C%B3%EF%BC%89%E6%9C%89%E9%99%90%E5%85%AC%E5%8F%B8&sign=ce7d7a9af35c3a02da77650103dd0ae4
        // String apiData =
        // "{\"data\":{\"total\":2,\"items\":[{\"id\":1984012283,\"toco\":13,\"logo\":\"http://img.tianyancha.com/logo/human/2/345609db75383b411884a401a6f3665e.png@!z_200x200\",\"name\":\"李彦宏\",\"capitalActl\":[],\"type\":2,\"capital\":[{\"amomon\":\"638917.36万元\",\"time\":\"2018-12-31\",\"percent\":\"99.50%\",\"paymet\":\"货币\"}]},{\"id\":1839080315,\"toco\":36,\"logo\":\"http://img.tianyancha.com/logo/human2/bdfe53ae98a2256d988da372ba8d879c.png@!z_200x200\",\"name\":\"向海龙\",\"capitalActl\":[],\"type\":2,\"capital\":[{\"amomon\":\"3210.64万元\",\"time\":\"2018-12-31\",\"percent\":\"0.50%\",\"paymet\":\"货币\"}]}]},\"seqNum\":\"43ab4e39bbf94c0c9b7747b86ac56cd3\",\"bizCode\":\"\",\"message\":\"查询成功\",\"status\":10}";
        //
        Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
        Type jsonType = new TypeToken<TycApiRespDTO<ResponsePageNumResultDTO<Open368HolderDTO>>>() {
        }.getType(); //
        TycApiRespDTO<ResponsePageNumResultDTO<Open368HolderDTO>> dtos = gson.fromJson(apiData, jsonType);
        if (dtos == null) { // 成功
            BaseRespnseDTO<List<Open368HolderDTO>> rtnDTO = new BaseRespnseDTO<List<Open368HolderDTO>>();
            rtnDTO.setCode(TcxyApiStatusCodeEnum.SYS_BUZY.key());
            rtnDTO.setMsg("接口响应数据为空");
            return rtnDTO;
        }

        Integer status = dtos.getStatus();
        String uuid = dtos.getSeqNum();
        String message = dtos.getMessage();

        BaseRespnseDTO<List<Open368HolderDTO>> rtnDTO = new BaseRespnseDTO<List<Open368HolderDTO>>();
        rtnDTO.setRtnSerialNo(uuid);
        rtnDTO.setCode(status);
        rtnDTO.setMsg(message);
        rtnDTO.setRespStr(apiData);
        //如果查询不成功或者结果是成功无数据，那么直接返回查询失败
        if (TcxyApiStatusCodeEnum.SUCCESS.key() != status && TcxyApiStatusCodeEnum.SUCCESS_NO_DATA.key() != status) { // 非正常情况
            rtnDTO.setRemark("查询失败");
            return rtnDTO;
        }
        //更新状态
        String entName = param.getName();
        // 先删除
        entHolderInfoService.deleteByEntName(entName);
        entHolderCapitalService.deleteByEntName(entName);
        //节点数据为空
        ResponsePageNumResultDTO<Open368HolderDTO> data = dtos.getData();
        if (null == data) {
            logger.error("[{}]data节点数据返回为空", param.getSeqNum());
            rtnDTO.setCode(TcxyApiStatusCodeEnum.SUCCESS_NO_DATA.key());
            rtnDTO.setMsg(TcxyApiStatusCodeEnum.SUCCESS_NO_DATA.desc());
            return rtnDTO;
        }
        //查询成功无数据
        if (TcxyApiStatusCodeEnum.SUCCESS_NO_DATA.key() == status) {
            rtnDTO.setRemark("查询成功无数据");
            return rtnDTO;
        }
        // 保存数据
        List<Open368HolderDTO> items = data.getItems();
        if (null == items || items.isEmpty()) {
            rtnDTO.setCode(TcxyApiStatusCodeEnum.SUCCESS_NO_DATA.key());
            rtnDTO.setMsg(TcxyApiStatusCodeEnum.SUCCESS_NO_DATA.desc());
            rtnDTO.setRemark("查询成功，返回节点无数据");
            return rtnDTO;
        }

        //  在新增
        List<EntHolderInfoEntity> list = new ArrayList<EntHolderInfoEntity>(items.size());
        List<EntHolderCapitalEntity> entHolderInfolist = Lists.newArrayList();
        EntHolderInfoEntity holderInfoEntity = null;
        List<Open368HolderCapitalDTO> capitalLs = null;
        List<Open368HolderCapitalActlDTO> capitalActlLs = null;
        for (Open368HolderDTO item : items) {
            holderInfoEntity = new EntHolderInfoEntity();
            BeanUtils.copyProperties(item, holderInfoEntity);
            holderInfoEntity.setEntId(param.getEntListInfo().getId());
            holderInfoEntity.setEntName(entName);
            holderInfoEntity.setCreditCode(param.getEntListInfo().getCreditCode());
            list.add(holderInfoEntity);

            capitalLs = item.getCapital();
            if (null != capitalLs && capitalLs.size() > 0) {
            	EntHolderCapitalEntity capitalEntity = null;
                for (Open368HolderCapitalDTO capital : capitalLs) {
                    capitalEntity = new EntHolderCapitalEntity();
                    BeanUtils.copyProperties(capital, capitalEntity);
                    capitalEntity.setEntName(entName);
                    capitalEntity.setHolderName(holderInfoEntity.getName());
                    capitalEntity.setType(HolderCaptialEnum.CAPITAL.key());

                    entHolderInfolist.add(capitalEntity);
                }
            }
            capitalActlLs = item.getCapitalActl();
            if (null != capitalActlLs && capitalActlLs.size() > 0) {
            	EntHolderCapitalEntity capitalActlEntity = null;
                for (Open368HolderCapitalActlDTO capitalActl : capitalActlLs) {
                    capitalActlEntity = new EntHolderCapitalEntity();
                    BeanUtils.copyProperties(capitalActl, capitalActlEntity);
                    capitalActlEntity.setEntName(entName);
                    capitalActlEntity.setHolderName(holderInfoEntity.getName());
                    capitalActlEntity.setType(HolderCaptialEnum.CAPITAL_ACTL.key());

                    entHolderInfolist.add(capitalActlEntity);
                }
            }
        }
        if (entHolderInfolist.size() > 0) {
            entHolderCapitalService.insertBatch(entHolderInfolist);
        }
        entHolderInfoService.insertBatch(list);

        rtnDTO.setData(items);
        rtnDTO.setRemark("查询成功");
        logger.info("统一响应数据：{}", new Gson().toJson(rtnDTO));
        return rtnDTO;

    }
}
