/*
 *      Copyright (c) 2018-2028, Chill Zhuang All rights reserved.
 *
 *  Redistribution and use in source and binary forms, with or without
 *  modification, are permitted provided that the following conditions are met:
 *
 *  Redistributions of source code must retain the above copyright notice,
 *  this list of conditions and the following disclaimer.
 *  Redistributions in binary form must reproduce the above copyright
 *  notice, this list of conditions and the following disclaimer in the
 *  documentation and/or other materials provided with the distribution.
 *  Neither the name of the dreamlu.net developer nor the names of its
 *  contributors may be used to endorse or promote products derived from
 *  this software without specific prior written permission.
 *  Author: Chill 庄骞 (smallchill@163.com)
 */
package cn.citms.icw.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import org.springblade.core.mp.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 单元信息实体类
 *
 * @author Blade
 * @since 2020-04-22
 */
@Data
@TableName("sq_unit")
@ApiModel(value = "Unit对象", description = "单元信息")
public class Unit {

	private static final long serialVersionUID = 1L;

	/**
	* ID
	*/
		@ApiModelProperty(value = "ID")
		private String id;
	/**
	* 单元编码
	*/
		@ApiModelProperty(value = "单元编码")
		private String dyBm;
	/**
	* 单元名称
	*/
		@ApiModelProperty(value = "单元名称")
		private String dyMc;
	/**
	* 单元标识
	*/
		@ApiModelProperty(value = "单元标识")
		private String dyBs;
	/**
	* 每层楼户数量
	*/
		@ApiModelProperty(value = "每层楼户数量")
		private String mclhSl;
	/**
	* 楼栋ID
	*/
		@ApiModelProperty(value = "楼栋ID")
		private String buildingId;
	/**
	* 社区ID
	*/
		@ApiModelProperty(value = "社区ID")
		private String communityId;


}
