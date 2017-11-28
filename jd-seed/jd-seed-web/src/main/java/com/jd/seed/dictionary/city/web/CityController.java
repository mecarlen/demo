package com.jd.seed.dictionary.city.web;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jd.seed.dictionary.city.domain.CityVO;
import com.jd.seed.dictionary.city.service.CityService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import springfox.documentation.annotations.ApiIgnore;

/**
 * <pre>
 * 城市
 * 
 * </pre>
 * 
 * @author mecarlen 2017年11月23日 下午2:06:10
 */
@ApiIgnore
@Api(tags = "城市", description = "城市操作相关接口")
@RestController
@RequestMapping(value = "/dictionary/city", produces = { "application/json" })
public class CityController {
	@Resource
	private CityService cityService;

	@ApiOperation("创建城市")
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public Long create(@ApiParam("城市对象") @RequestBody CityVO city) {
		return cityService.create(city);
	}

	@ApiOperation("更新城市")
	@RequestMapping(value = "/modify/{cityId}", method = RequestMethod.PUT)
	public boolean modify(@ApiParam("城市id") @PathVariable(value = "cityId", required = true) Long id, @RequestBody CityVO city) {
		return cityService.modify(city.id(id));
	}
}
