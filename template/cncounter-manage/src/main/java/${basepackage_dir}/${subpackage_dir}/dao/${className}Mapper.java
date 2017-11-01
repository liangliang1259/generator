<#include "/macro.include"/>
<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>
<#assign shortName = table.shortName>
package ${basepackage}.${subpackage}.dao;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;
import ${basepackage}.${subpackage}.entity.${className};

/**
 * @version 1.0
 * @author  sunliangliang generated
 */
@Mapper
public interface ${className}Mapper {
    
    ${className} getById(Long id);
    
    int insert(${className} ${classNameLower});

    int insertSelective(${className} ${classNameLower});

    int update(${className} ${classNameLower});

    int deleteById(Long id);

    List<${className}> listPage(${className} ${classNameLower});

    List<${className}> listAll();
}