<#include "/java_copyright.include">
<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
<#assign shortName = table.shortName>
package ${basepackage}.admin.controller.${subpackage};

import ${basepackage}.common.model.RestResult;
import ${basepackage}.common.model.RestResultBuilder;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import ${basepackage}.common.web.controller.BaseController;
import ${basepackage}.${subpackage}.entity.${className};
import ${basepackage}.${subpackage}.service.${className}Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

/**
 * @version 1.0
 * @author sunliangliang generated
 */
@RestController
@RequestMapping("/${subpackage}/${urlpackage}")
public class ${className}Controller extends BaseController {
    
    @Autowired
    private ${className}Service ${classNameLower}Service;

	@ApiOperation(value="添加${table.tableAlias}", notes="添加${table.tableAlias}")
	@ApiImplicitParam(name = "${classNameLower}", value = "${table.tableAlias}实体", required = true, dataType = "${className}")
	@PostMapping(value = "/create")
	public RestResult create(@RequestBody @Valid ${className} ${classNameLower}) {
		Boolean result = ${classNameLower}Service.save(${classNameLower});
		if (result) {
		return RestResultBuilder.builder().success().build();
		}
		return RestResultBuilder.builder().failure().build();
	}

	@ApiOperation(value="修改${table.tableAlias}信息", notes="根据url的id来指定更新对象，并根据传过来的信息来更新${table.tableAlias}详细信息")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "id", value = "${table.tableAlias}id", required = true, dataType = "Long"),
			@ApiImplicitParam(name = "robot", value = "${table.tableAlias}${classNameLower}", required = true, dataType = "${className}")
	})
	@PutMapping(value = "/update/{id}")
	public RestResult update(@PathVariable Long id,@RequestBody @Valid ${className} ${classNameLower}){
		${classNameLower}.setId(id);
		${classNameLower}Service.update(${classNameLower});
		return RestResultBuilder.builder().success().build();
	}

	@ApiOperation(value="获取${table.tableAlias}信息", notes="根据url的id来获取${table.tableAlias}详细信息")
	@GetMapping(value = "/get/{id}")
	public RestResult get(@PathVariable Long id) {
		${className} ${classNameLower} = ${classNameLower}Service.getById(id);
		return RestResultBuilder.builder().success(${classNameLower}).build();
	}

	@ApiOperation(value="获取${table.tableAlias}列表", notes="")
	@GetMapping(value = "/list")
	public RestResult list() {
		List<${className}> ${classNameLower}s = ${classNameLower}Service.listAll();
		return RestResultBuilder.builder().success(${classNameLower}s).build();
	}

	@ApiOperation(value="删除${table.tableAlias}", notes="根据url的id来指定删除对象")
	@ApiImplicitParam(name = "id", value = "${table.tableAlias}id", required = true, dataType = "Long")
	@DeleteMapping("/delete/{id}")
	public RestResult delete(@PathVariable Long id) {
		${classNameLower}Service.delete(id);
		return RestResultBuilder.builder().success().build();
	}
}
