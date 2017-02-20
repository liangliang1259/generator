/*
 * Created by sunliangliang
 */
<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
<#assign shortName = table.shortName>
package ${basepackage}.${subpackage}.service.impl;

import com.alibaba.fastjson.JSON;
import ${basepackage}.${subpackage}.dao.${className}Mapper;
import ${basepackage}.${subpackage}.entity.${className};
import ${basepackage}.${subpackage}.exception.${subpackage}ErrorCode;
import ${basepackage}.${subpackage}.service.UserService;
import com.changyou.rampage.common.exception.BusinessException;
import com.changyou.rampage.common.service.LoggerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
/**
 * @version 1.0
 * @author
 */
@Service
public class ${className}ServiceImpl implements ${className}Service {
	private final Logger logger = LoggerFactory.getLogger(${className}Service.class);

	@Autowired
    ${className}Mapper ${classNameLower}Mapper;

	@Override
	public Boolean save(${className} ${classNameLower}) {
		${classNameLower}.setGmtCreate(new Date());
		${classNameLower}.setGmtModified(new Date());
		logger.debug("entity:{}", JSON.toJSONString(${classNameLower}));
		int count = ${classNameLower}Mapper.insert(${classNameLower});
		logger.debug("count:{}", count);
		return count > 0 ? true : false;
	}


	@Override
	public Boolean update(${className} ${classNameLower}) {
		entity.setGmtModified(new Date());
		int count = ${classNameLower}Mapper.updateByPrimaryKey(${classNameLower});
		return count > 0 ? true : false;
	}


	@Override
	public Boolean delete(Long id) {
		int count = ${classNameLower}Mapper.deleteByPrimaryKey(id);
		return count > 0 ? true : false;
	}

	@Override
	public ${className} getById(Long id) {
		${className} ${classNameLower} = ${classNameLower}Mapper.selectByPrimaryKey(id);
		if (user == null) {
			throw new BusinessException(${className}ErrorCode.${className}_NOT_EXISTS);
		}
		return ${classNameLower};
	}

	@Override
	public List<${className}> listAll() {
		return ${classNameLower}Mapper.list${className}s();
	}

}
