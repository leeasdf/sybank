package xin.tianchuang.modules.api.dto;

import java.io.Serializable;

/**
 * Created by lee on 2019/3/9.
 */
public class SysTaskRespDTO implements Serializable {
    private static final long serialVersionUID = 7963516610611203287L;

    /**
     * 返回的结果状态码
     */
    private Integer code;

    /**
     * 返回的结果消息
     */
    private String msg;

    /**
     * 企业id
     */
    private Integer entId;

    /**
     * 接口名称
     */
    private String interfaceName;


    /**
     * 结果状态 1-成功 2 失败 3 未知
     * @return
     */
    private Integer resStatus;

    public static final int SUCCESS=1;
    public static final int FAIL=2;
    public static final int UNKNOWN=3;

    public void success(){
        resStatus = SUCCESS;
    }
    public void fail(){
        resStatus = FAIL;
    }
    public void unknown(){
        resStatus = UNKNOWN;
    }


    public Integer getEntId() {
        return entId;
    }

    public Integer getResStatus() {
        return resStatus;
    }

    public void setResStatus(Integer resStatus) {
        this.resStatus = resStatus;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setEntId(Integer entId) {
        this.entId = entId;
    }

    public String getInterfaceName() {
        return interfaceName;
    }

    public void setInterfaceName(String interfaceName) {
        this.interfaceName = interfaceName;
    }
}
