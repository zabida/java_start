package com.atguigu.boot.modules.my.handler;


import cn.afterturn.easypoi.excel.entity.result.ExcelVerifyHandlerResult;
import cn.afterturn.easypoi.handler.inter.IExcelDataHandler;
import cn.afterturn.easypoi.handler.inter.IExcelVerifyHandler;
import cn.hutool.core.util.StrUtil;
import com.atguigu.boot.modules.my.enums.BiomedicalZoneModeEnum;
import com.atguigu.boot.modules.my.enums.CorpusModeEnum;
import com.atguigu.boot.modules.my.enums.InternationalZoneModeEnum;
import com.atguigu.boot.modules.my.enums.ZonesTypeEnum;
import com.atguigu.boot.modules.my.req.ImportParamProcessVersion2Req;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class RegisterPV2Handler implements IExcelVerifyHandler<ImportParamProcessVersion2Req> {
    @Override
    public ExcelVerifyHandlerResult verifyHandler(ImportParamProcessVersion2Req obj) {
        StringJoiner joiner = new StringJoiner(",");
        String zonesOri = obj.getZones();
        Map<String, String> corpusModeMap = CorpusModeEnum.getNameMap();
        ArrayList<String> corpusModeList = CorpusModeEnum.getAllName();
        Map<String, String> internationalZoneModeMap = InternationalZoneModeEnum.getNameMap();
        ArrayList<String> internationalZoneModeList = InternationalZoneModeEnum.getAllName();
        Map<String, String> bioZoneModeMap = BiomedicalZoneModeEnum.getNameMap();
        ArrayList<String> bioZoneModeList = BiomedicalZoneModeEnum.getAllName();

        String[] zoneArrs = zonesOri.split(";");
        for (String zoneOriStr:zoneArrs){
            if (zoneOriStr.startsWith("以上均不属于")){
                continue;
            }
            String[] onePair = zoneOriStr.split("&");
            if(onePair.length<=1){
                String a = "产品名为【"+obj.getDataName()+"】的数据专区格式错误，缺少必填参数: " + zonesOri;
                joiner.add(a);
            }

            String zone = onePair[0];
            String zRela = onePair[1];

            if(StrUtil.equals(zone, ZonesTypeEnum.INTERNATIONAL_ZONE.getName())){
                if (!internationalZoneModeList.containsAll(Arrays.asList(zRela.split(",")))){
                    joiner.add("数据专区格式错误，非法mode: " + zoneOriStr);
                }
            }else if(StrUtil.equals(zone, ZonesTypeEnum.CORPUS_ZONE.getName())){
                if (!corpusModeList.containsAll(Arrays.asList(zRela.split(",")))){
                    joiner.add("数据专区格式错误，非法mode: " + zoneOriStr);
                }
            }
            else if (StrUtil.equals(zone, ZonesTypeEnum.BIOMEDICAL_ZONE.getName())) {
                if (!bioZoneModeList.containsAll(Arrays.asList(zRela.split(",")))){
                    joiner.add("数据专区格式错误，非法mode: " + zoneOriStr);
                }
            }else {
                joiner.add("数据专区格式错误: " + zoneOriStr);
            }
        }
        if (joiner.length() > 0){
            return new ExcelVerifyHandlerResult(false, joiner.toString());
        }
        return new ExcelVerifyHandlerResult(true);
    }
}
