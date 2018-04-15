package org.teluoyi.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
* @ClassName: LogBackTest
* @Description: TODO(这里用一句话描述这个类的作用)
* @author wenjin.zhu
* @date 2018年4月14日
*
 */
public class LogBackTest {

	static Logger logger = LoggerFactory.getLogger(LogBackTest.class);

	public static void main(String[] args) {
		System.out.println("start");
		logger.info("logger.infoMessage.");
		logger.info("logger.infoMessage111.");	
		logger.info("logger.infoMessage222.");
	}

}
