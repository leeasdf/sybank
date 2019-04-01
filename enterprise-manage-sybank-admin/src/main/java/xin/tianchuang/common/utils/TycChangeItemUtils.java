package xin.tianchuang.common.utils;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Iterator;

import xin.tianchuang.common.constant.TycWeightPointsConstant;
import xin.tianchuang.common.enums.ChangeItemTypeEnum;
import xin.tianchuang.modules.api.bean.api.tyc.response.Open370ChangeinfoDTO;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;

/**
 * Created by lee on 2019/3/19.
 */
public class TycChangeItemUtils {

    /**
     * 根据传入的更新事项 changeItem 值判断是什么变更类型
     *
     * @param changeItem 变更值
     * @return
     */
    public static ChangeItemTypeEnum getChangeItemType(String changeItem) {


        if (TycWeightPointsConstant.ENTPRISE_NAME_WORDS_EQ.containsKey(changeItem)) {
            return ChangeItemTypeEnum.NAME;
        }
        if (TycWeightPointsConstant.SHAREHOLDER_OR_INVESTOR_WORDS_EQ.containsKey(changeItem)) {
            return ChangeItemTypeEnum.HOLDER;
        }
        if (TycWeightPointsConstant.LEGAL_WORDS_EQ.containsKey(changeItem)) {
            return ChangeItemTypeEnum.LEGAL;
        }
        // 先全匹配 后模糊匹配 indexof
        Iterator<String> it = TycWeightPointsConstant.REGISTERED_CAPITAL_DIRECTION_WORDS.iterator();
        // 注册资本
        while (it.hasNext()) {
            if (changeItem.indexOf(it.next()) != -1) {
                return ChangeItemTypeEnum.REG_CAPITAL;
            }
        }
        // 法定代表人变量
        it = TycWeightPointsConstant.LEGAL_WORDS.iterator();
        while (it.hasNext()) {
            if (changeItem.indexOf(it.next()) != -1) {
                return ChangeItemTypeEnum.LEGAL;
            }
        }
        // 股东/投资人变量
        it = TycWeightPointsConstant.SHAREHOLDER_OR_INVESTOR_WORDS.iterator();
        while (it.hasNext()) {
            if (changeItem.indexOf(it.next()) != -1) {
                return ChangeItemTypeEnum.HOLDER;
            }
        }
        // 经营范围变量
        it = TycWeightPointsConstant.SCOPE_OF_BUSINESS_WORDS.iterator();
        while (it.hasNext()) {
            if (changeItem.indexOf(it.next()) != -1) {
                return ChangeItemTypeEnum.BUSINESS_SCOPE;
            }
        }
        // 董监高变量
        it = TycWeightPointsConstant.DONG_JIAN_GAO_WORDS.iterator();
        while (it.hasNext()) {
            if (changeItem.indexOf(it.next()) != -1) {
                return ChangeItemTypeEnum.DONGJIANGAO;
            }
        }

        // 企业类型变量
        it = TycWeightPointsConstant.ENTPRISE_TYPE_WORDS.iterator();
        while (it.hasNext()) {
            if (changeItem.indexOf(it.next()) != -1) {
                return ChangeItemTypeEnum.ENTERPRISETYPE;
            }
        }
        //行业类型变更
        it = TycWeightPointsConstant.INDUSTRY_TYPE_WORDS.iterator();
        while (it.hasNext()) {
            if (changeItem.indexOf(it.next()) != -1) {
                return ChangeItemTypeEnum.INDUSTRY;
            }
        }

        // 企业名称变量
        it = TycWeightPointsConstant.ENTPRISE_NAME_WORDS.iterator();
        while (it.hasNext()) {
            if (changeItem.indexOf(it.next()) != -1) {
                return ChangeItemTypeEnum.NAME;
            }
        }
        // 住所变量
        it = TycWeightPointsConstant.ADDRESS_WORDS.iterator();
        while (it.hasNext()) {
            if (changeItem.indexOf(it.next()) != -1) {
                return ChangeItemTypeEnum.REG_LOCATION;
            }
        }
        return null;
    }


    /**
     * 计算变更的权重方法
     *
     * @param changeItem
     * @param changeTime
     * @param contentBefore
     * @param contentAfter
     * @return
     * @throws ParseException 
     * @throws Exception
     */
    public static BigDecimal calcChangeItemWeight(Open370ChangeinfoDTO changeInfoDto) throws ParseException {
    	String changeTime = changeInfoDto.getChangeTime();
    	String changeItem = changeInfoDto.getChangeItem();
    	String contentAfter = changeInfoDto.getContentAfter();
    	String contentBefore = changeInfoDto.getContentBefore();
        ChangeItemTypeEnum changeItemTypeEnum = getChangeItemType(changeItem);
        if (changeItemTypeEnum == null) {
            return null;
        }
        BigDecimal weight = BigDecimal.ZERO;
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        contentBefore = clearTab(contentBefore);
        contentAfter = clearTab(contentAfter);

        Long betMonth = DateUtil.betweenMonth(df.parse(DateUtil.today()), df.parse(changeTime), true);
        switch (changeItemTypeEnum) {
            case NAME:
                BigDecimal entpriseBigDecimal = TycWeightPointsConstant.ENTPRISE_NAME.get(betMonth.intValue());
                weight = entpriseBigDecimal.multiply(new BigDecimal("0.5"));
                break;
            case REG_CAPITAL:
                Double direction = Double.valueOf(contentAfter) - Double.valueOf(contentBefore);
                BigDecimal directionWeight = TycWeightPointsConstant.REGISTERED_CAPITAL_DIRECTION.get(direction);
                BigDecimal monthWeight = TycWeightPointsConstant.REGISTERED_CAPITAL_DURATION_TIME.get(betMonth.intValue());
                weight = directionWeight.multiply(monthWeight);
                break;
            case LEGAL:
                weight = TycWeightPointsConstant.LEGAL.get(betMonth.intValue());
                break;
            case HOLDER:
                weight = TycWeightPointsConstant.SHAREHOLDER_OR_INVESTOR.get(betMonth.intValue());
                break;
            case BUSINESS_SCOPE:
                weight = TycWeightPointsConstant.SCOPE_OF_BUSINESS.get(betMonth.intValue());
                break;
            case DONGJIANGAO:
                weight = TycWeightPointsConstant.DONG_JIAN_GAO.get(betMonth.intValue());
                break;
            case REG_LOCATION:
                weight = TycWeightPointsConstant.ADDRESS.get(betMonth.intValue());
                break;
            case ENTERPRISETYPE:
                weight = TycWeightPointsConstant.ENTPRISE_TYPE.get(betMonth.intValue());
                break;
            default:
                weight = BigDecimal.ZERO;
                break;
        }
        return weight;
    }

    private static String clearTab(String content) {
        if (StrUtil.isBlank(content)) {
            return null;
        }
        return content
                .replaceAll("</em>", "")
                .replaceAll("<em>", "")
                .replaceAll("人民币", "")
                .replaceAll("元", "")
                .replaceAll("万元", "")
                .replaceAll("万", "")
                .replaceAll(" ", "");
    }
}
