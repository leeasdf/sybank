package xin.tianchuang.modules.api.bean.v1;

import java.io.Serializable;
import java.util.List;

public class RptTcxyIPRDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4504395066342058669L;

	private List<RptTcxyCompanyCopyrightDTO> copyRight;
	private List<RptTcxyCompanySoftwareCopyrightDTO> softwareCopyRight;
	private List<RptTcxyPatentBaseDTO> patent;

	public List<RptTcxyCompanyCopyrightDTO> getCopyRight() {
		return copyRight;
	}

	public void setCopyRight(List<RptTcxyCompanyCopyrightDTO> copyRight) {
		this.copyRight = copyRight;
	}

	public List<RptTcxyCompanySoftwareCopyrightDTO> getSoftwareCopyRight() {
		return softwareCopyRight;
	}

	public void setSoftwareCopyRight(List<RptTcxyCompanySoftwareCopyrightDTO> softwareCopyRight) {
		this.softwareCopyRight = softwareCopyRight;
	}

	public List<RptTcxyPatentBaseDTO> getPatent() {
		return patent;
	}

	public void setPatent(List<RptTcxyPatentBaseDTO> patent) {
		this.patent = patent;
	}

}
