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
package cn.citms.icw.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperationSupport;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import javax.validation.Valid;

import org.springblade.core.mp.support.Condition;
import org.springblade.core.mp.support.Query;
import org.springblade.core.tool.api.R;
import org.springblade.core.tool.utils.Func;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestParam;
import com.baomidou.mybatisplus.core.metadata.IPage;
import cn.citms.icw.entity.Patroltask;
import cn.citms.icw.vo.PatroltaskVO;
import cn.citms.icw.wrapper.PatroltaskWrapper;
import cn.citms.icw.service.IPatroltaskService;
import org.springblade.core.boot.ctrl.BladeController;

/**
 *  控制器
 *
 * @author Blade
 * @since 2020-04-22
 */
@RestController
@AllArgsConstructor
@RequestMapping("icw/patroltask")
@Api(value = "", tags = "接口")
public class PatroltaskController extends BladeController {

	private IPatroltaskService patroltaskService;

	/**
	 * 详情
	 */
	@GetMapping("/detail")
	@ApiOperationSupport(order = 1)
	@ApiOperation(value = "详情", notes = "传入patroltask")
	public R<PatroltaskVO> detail(Patroltask patroltask) {
		Patroltask detail = patroltaskService.getOne(Condition.getQueryWrapper(patroltask));
		return R.data(PatroltaskWrapper.build().entityVO(detail));
	}

	/**
	 * 分页 
	 */
	@GetMapping("/list")
	@ApiOperationSupport(order = 2)
	@ApiOperation(value = "分页", notes = "传入patroltask")
	public R<IPage<PatroltaskVO>> list(Patroltask patroltask, Query query) {
		IPage<Patroltask> pages = patroltaskService.page(Condition.getPage(query), Condition.getQueryWrapper(patroltask));
		return R.data(PatroltaskWrapper.build().pageVO(pages));
	}


	/**
	 * 自定义分页 
	 */
	@GetMapping("/page")
	@ApiOperationSupport(order = 3)
	@ApiOperation(value = "分页", notes = "传入patroltask")
	public R<IPage<PatroltaskVO>> page(PatroltaskVO patroltask, Query query) {
		IPage<PatroltaskVO> pages = patroltaskService.selectPatroltaskPage(Condition.getPage(query), patroltask);
		return R.data(pages);
	}

	/**
	 * 新增 
	 */
	@PostMapping("/save")
	@ApiOperationSupport(order = 4)
	@ApiOperation(value = "新增", notes = "传入patroltask")
	public R save(@Valid @RequestBody Patroltask patroltask) {
		return R.status(patroltaskService.save(patroltask));
	}

	/**
	 * 修改 
	 */
	@PostMapping("/update")
	@ApiOperationSupport(order = 5)
	@ApiOperation(value = "修改", notes = "传入patroltask")
	public R update(@Valid @RequestBody Patroltask patroltask) {
		return R.status(patroltaskService.updateById(patroltask));
	}

	/**
	 * 新增或修改 
	 */
	@PostMapping("/submit")
	@ApiOperationSupport(order = 6)
	@ApiOperation(value = "新增或修改", notes = "传入patroltask")
	public R submit(@Valid @RequestBody Patroltask patroltask) {
		return R.status(patroltaskService.saveOrUpdate(patroltask));
	}

	
	/**
	 * 删除 
	 */
	@PostMapping("/remove")
	@ApiOperationSupport(order = 7)
	@ApiOperation(value = "逻辑删除", notes = "传入ids")
	public R remove(@ApiParam(value = "主键集合", required = true) @RequestParam String ids) {
		return R.status(true);
	}

	
}
