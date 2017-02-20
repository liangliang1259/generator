<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>
<#assign shortName = table.shortName>
package ${basepackage}.${subpackage}.service;

import java.util.List;
import java.util.Map;

import ${basepackage}.${subpackage}.entity.${className};

/**
 * @version 1.0
 * @author 
 */
public interface ${className}Service extends BaseService<${className}>{

}
