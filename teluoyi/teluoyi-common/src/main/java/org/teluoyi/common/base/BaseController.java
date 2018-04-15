package org.teluoyi.common.base;

import java.text.SimpleDateFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
* @ClassName: BaseController
* @Description: TODO(公共的Controller)
* @author wenjin.zhu
* @date 2018年4月14日
*
 */
public class BaseController {
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	public  Logger logger = (Logger) LoggerFactory.getLogger(getClass());
	

}
