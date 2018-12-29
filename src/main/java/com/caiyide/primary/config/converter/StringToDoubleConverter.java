package com.caiyide.primary.config.converter;

import org.springframework.core.convert.converter.Converter;

/**
 * <code>
 *
 * </code>
 * @author liujixiang
 * @date 2018/08/05
 */
public class StringToDoubleConverter implements Converter<String, Double> {

	@Override
	public Double convert(String source) {
		return StringToDoubleUtil.convert(source);
	}
}
