package ${basepackage}.common.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * Spring Controller基类，只添加loggger处理，
 */

/**
 * Spring MVC控制器的基类, 对Session访问提供统一方法,<br/>
 * 子类应该使用基类提供的方法,以方便今后的集群部署[届时只需要修改此类中的实现即可]。
 */
public abstract class BaseController {
	protected final Logger logger = LoggerFactory.getLogger(this.getClass());
}

