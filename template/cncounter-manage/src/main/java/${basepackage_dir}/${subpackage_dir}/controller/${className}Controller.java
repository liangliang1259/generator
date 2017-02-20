<#include "/java_copyright.include">
<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
<#assign shortName = table.shortName>
package ${basepackage}.admin.controller.${subpackage};

import ${basepackage}.common.model.RestResult;
import ${basepackage}.common.model.RestResultBuilder;
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
@RequestMapping("/${subpackage}/${urlpackage}/")
public class ${className}Controller extends BaseController {
    
    @Autowired
    private ${className}Service ${classNameLower}Service;

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public RestResult create(@RequestBody @Valid ${className} ${classNameLower}) {
		Boolean result = ${classNameLower}Service.save(${classNameLower});
		if (result) {
		return RestResultBuilder.builder().success().build();
		}
		return RestResultBuilder.builder().failure().build();
	}


	@RequestMapping(value = "/update/{id}",method = RequestMethod.POST)
	public RestResult update(@PathVariable Long id,@RequestBody @Valid ${className} ${classNameLower}){
		${classNameLower}.setId(id);
		${classNameLower}Service.update(${classNameLower});
		return RestResultBuilder.builder().success().build();
	}

	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	public RestResult get(@PathVariable Long id) {
		${className} ${classNameLower} = ${classNameLower}Service.getById(id);
		return RestResultBuilder.builder().success(user).build();
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public RestResult list() {
		List<${className}> ${classNameLower}s = ${classNameLower}Service.listAll();
		return RestResultBuilder.builder().success(${classNameLower}s).build();
	}

	@RequestMapping("/delete/{id}", method = RequestMethod.GET)
		public RestResult delete(@PathVariable Long id) {
		${classNameLower}Service.delete(id);
		return RestResultBuilder.builder().success().build();
	}
}
