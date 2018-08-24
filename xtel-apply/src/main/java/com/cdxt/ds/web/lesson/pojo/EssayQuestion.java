/**
 * 
 * @ClassName: EssayQuestion.java
 * @Description: 
 * @author wangxiaolong
 * @Copyright: Copyright (c) 2017
 * @Company:成都信通网易医疗科技发展有限公司
 * @date 2018年8月23日
 */
package com.cdxt.ds.web.lesson.pojo;

/**
 * 
 * @ClassName: EssayQuestion.java
 * @Description: 问答题
 * @author wangxiaolong
 * @Copyright: Copyright (c) 2017
 * @Company:成都信通网易医疗科技发展有限公司
 * @date 2018年8月23日
 */
public class EssayQuestion {

	private Integer id;
	
	private String stem;
	
	private Integer MaxWordLimit;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStem() {
		return stem;
	}

	public void setStem(String stem) {
		this.stem = stem;
	}

	public Integer getMaxWordLimit() {
		return MaxWordLimit;
	}

	public void setMaxWordLimit(Integer maxWordLimit) {
		MaxWordLimit = maxWordLimit;
	}

	@Override
	public String toString() {
		return "EssayQuestion [id=" + id + ", stem=" + stem + ", MaxWordLimit=" + MaxWordLimit + "]";
	}
	
}
