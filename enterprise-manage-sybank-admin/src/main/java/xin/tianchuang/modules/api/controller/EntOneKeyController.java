package xin.tianchuang.modules.api.controller;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.io.Files;
import com.google.common.io.LineProcessor;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;
import xin.tianchuang.common.enums.tcxy.TcxyApiStatusCodeEnum;
import xin.tianchuang.common.exception.SpiderException;
import xin.tianchuang.common.utils.R;
import xin.tianchuang.modules.api.bean.api.tyc.response.*;
import xin.tianchuang.modules.api.bean.imports.ImportParseBaseDTO;
import xin.tianchuang.modules.api.dto.TycApiRespDTO;
import xin.tianchuang.modules.spider.entity.EntListInfoEntity;
import xin.tianchuang.modules.spider.entity.EntRefNodesEntity;
import xin.tianchuang.modules.spider.entity.EntRefRelationshipsEntity;
import xin.tianchuang.modules.spider.service.EntListInfoService;
import xin.tianchuang.modules.spider.service.EntRefNodesService;
import xin.tianchuang.modules.spider.service.EntRefRelationshipsService;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by yp-tc-m-7179 on 2019/3/1.
 */
@RestController
@RequestMapping("/api/import1")
@ApiIgnore
@Deprecated
public class EntOneKeyController {

    private static final Logger logger = LoggerFactory.getLogger(EntOneKeyController.class);
    private static final Splitter splitter = Splitter.on(",");

    private static final String rootPath = "/Users/lee/IdeaProjects/enterprise-manage-sybank/project/02_数据处理/12106_26_all";

    @Autowired
    private EntListInfoService entListInfoService;
    @Autowired
    private EntRefNodesService entRefNodesService;
    @Autowired
    private EntRefRelationshipsService entRefRelationshipsService;

    /**
     * 企业图谱（新版）
     *
     * @throws IOException
     */
    @GetMapping("/one_key_c")
    public R oneKeyC() throws IOException {
        String path = rootPath + "/企业图谱新版/";
        String fileName = "callSuccessful.txt_file3.txt";
        File file = new File(path, fileName);
        BufferedWriter bw = new BufferedWriter(new FileWriter(new File(path, "error.txt")));
        Files.asCharSource(file, Charset.defaultCharset()).readLines(new LineProcessor<String>() {
            public boolean processLine(String line) throws IOException {
                try {
                    Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
                    Type jsonType = new TypeToken<ImportParseBaseDTO<TycApiRespDTO<Open783OneKeyCDTO>>>() {
                    }.getType(); //
                    ImportParseBaseDTO<TycApiRespDTO<Open783OneKeyCDTO>> wrapper = gson.fromJson(line, jsonType);
                    TycApiRespDTO<Open783OneKeyCDTO> dtos = wrapper.getResult();
                    if (dtos == null) { // 成功
                        throw new SpiderException("数据返回为空");
                    }
                    Integer status = dtos.getStatus();
                    String uuid = dtos.getSeqNum();
                    String message = dtos.getMessage();
                    if (TcxyApiStatusCodeEnum.SUCCESS.key() == status) { // 查询成功 有数据
                        Open783OneKeyCDTO data = dtos.getData();
                        if (null == data) {
                            throw new SpiderException("data节点数据返回为空");
                        }
                        // 保存数据
                        // 先删除 在新增

                        EntListInfoEntity listInfoEntity = entListInfoService.selectOneByName(wrapper.getCname());
                        if (null == listInfoEntity) {
                            throw new SpiderException("系统异常，请稍后再试");
                        }

                        String entName = listInfoEntity.getName();

                        List<Open783OneKeyCNodesDTO> nodes = data.getNodes();
                        List<EntRefNodesEntity> refNodesEntityList = new ArrayList<EntRefNodesEntity>(nodes.size());
                        if (null != nodes && nodes.size() > 0) {
                            entRefNodesService.deleteByEntName(entName);
                            for (Open783OneKeyCNodesDTO dto : nodes) {
                                EntRefNodesEntity entity = new EntRefNodesEntity();
                                BeanUtils.copyProperties(dto, entity);
                                Open783OneKeyCNodesPropertiesDTO properties = dto.getProperties();
                                if (null != properties) {
                                    BeanUtils.copyProperties(properties, entity);
                                }
                                entity.setEntId(listInfoEntity.getId());
                                entity.setEntName(entName);
                                entity.setCreditCode(listInfoEntity.getCreditCode());
                                List<String> labelsList = dto.getLabels();
                                String labels = Joiner.on(",").join(labelsList);
                                entity.setLabels(labels);
                                refNodesEntityList.add(entity);
                            }
                            entRefNodesService.insertBatch(refNodesEntityList);
                        }
                        List<Open783OneKeyCRelationshipsDTO> relationships = data.getRelationships();
                        List<EntRefRelationshipsEntity> refRelationshipsEntityList = new ArrayList<EntRefRelationshipsEntity>(relationships.size());
                        if (null != relationships && relationships.size() > 0) {
                            entRefRelationshipsService.deleteByEntName(entName);
                            for (Open783OneKeyCRelationshipsDTO dto : relationships) {
                                EntRefRelationshipsEntity entity = new EntRefRelationshipsEntity();
                                BeanUtils.copyProperties(dto, entity);
                                Open783OneKeyCNodesRelationshipsPropertiesDTO properties = dto.getProperties();
                                if (null != properties) {
                                    List<String> labelsList = properties.getLabels();
                                    String labels = Joiner.on(",").join(labelsList);
                                    entity.setLabels(labels);
                                }
                                entity.setEntId(listInfoEntity.getId());
                                entity.setEntName(entName);
                                entity.setCreditCode(listInfoEntity.getCreditCode());
                                refRelationshipsEntityList.add(entity);
                            }
                            entRefRelationshipsService.insertBatch(refRelationshipsEntityList);
                        }
                    }
                } catch (Exception e) {
                    logger.error("数据异常", e);
                    try {
                        bw.write(line);
                        bw.newLine();
                    } catch (IOException e1) {
                        logger.error("写文件异常", e1);
                    }
                }

                return true;// 如果是false，则会中断读取操作
            }

            public String getResult() {
                return null;// 返回的结果。可以自定义
            }
        });

        return R.ok("导入成功");
    }
}
