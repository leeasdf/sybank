package xin.tianchuang.modules.api.bean.api.tyc.response;

import java.io.Serializable;

/**
 * Created by lee on 2019/3/25.
 */
public class SubTm  implements Serializable{

    private static final long serialVersionUID = -2195897211663428736L;

    private String cat;

    private String time;

    public String getCat() {
        return cat;
    }

    public void setCat(String cat) {
        this.cat = cat;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
