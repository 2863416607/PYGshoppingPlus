package com.shop.pyg.vo;

import com.shop.pyg.domain.Specification;
import com.shop.pyg.domain.SpecificationOption;

import java.io.Serializable;
import java.util.List;

/**
 * 组合实体类
 * @author jt
 *
 */

public class SpecificationVO implements Serializable{
	// 规格实体
	private Specification specification;
	// 规格选项集合
	private List<SpecificationOption> specificationOptionList;


	public Specification getSpecification() {
		return specification;
	}

	public void setSpecification(Specification specification) {
		this.specification = specification;
	}

	public List<SpecificationOption> getSpecificationOptionList() {
		return specificationOptionList;
	}
	public void setSpecificationOptionList(List<SpecificationOption> specificationOptionList) {
		this.specificationOptionList = specificationOptionList;
	}


}
