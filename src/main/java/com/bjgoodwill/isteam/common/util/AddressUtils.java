package com.bjgoodwill.isteam.common.util;

import org.lionsoul.ip2region.DataBlock;
import org.lionsoul.ip2region.DbConfig;
import org.lionsoul.ip2region.DbSearcher;
import org.lionsoul.ip2region.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.File;
import java.lang.reflect.Method;

/**
 * @ClassName AddressUtils
 * @Description 开源ip地址查询库 ip2region
 * @Author LI JUN
 * @Date 2018/11/7 11:24
 * @Version 0.0.1
 */
public class AddressUtils {

	private AddressUtils() {
	}

	private static Logger log = LoggerFactory.getLogger(AddressUtils.class);

	public static String getCityInfo(String ip) {
		try {
			Resource resource = new ClassPathResource("ip2region/ip2region.db");
			File file = resource.getFile();
			if (!file.exists()) {
				log.error("Error: Invalid ip2region.db file");
			}
			int algorithm = DbSearcher.BTREE_ALGORITHM;
			DbConfig config = new DbConfig();
			DbSearcher searcher = new DbSearcher(config, file.getPath());
			Method method = null;
			switch (algorithm) {
				case DbSearcher.BTREE_ALGORITHM:
					method = searcher.getClass().getMethod("btreeSearch", String.class);
					break;
				case DbSearcher.BINARY_ALGORITHM:
					method = searcher.getClass().getMethod("binarySearch", String.class);
					break;
				case DbSearcher.MEMORY_ALGORITYM:
					method = searcher.getClass().getMethod("memorySearch", String.class);
					break;
				default:
					method = searcher.getClass().getMethod("memorySearch", String.class);
					break;
			}
			DataBlock dataBlock = null;
			if (!Util.isIpAddress(ip)) {
				log.error("Error: Invalid ip address");
			}
			dataBlock = (DataBlock) method.invoke(searcher, ip);
			return dataBlock.getRegion();
		} catch (Exception e) {
			log.error("获取地址信息异常：{}", e);
		}
		return "";
	}

}