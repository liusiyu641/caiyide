package com.caiyide.primary.config.converter;

import org.apache.commons.lang.StringUtils;

/**
 * <code>
 * <pre>
 * 空字符串("")转换成Double的null
 *
 * </pre>
 * </code>
 * @author liujixiang
 * @date 2018/08/05
 */
public class StringToDoubleUtil {

	public static Double convert(String source) {
		if (StringUtils.isBlank(source)){
			return null;
		}
		Double d = Double.parseDouble(source);
		return d;
	}
}
