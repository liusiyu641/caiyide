package com.caiyide.primary.config.converter;

import org.springframework.core.convert.converter.Converter;

/**
 * <code>
 *
 * </code>
 * @author liujixiang
 * @date 2018/08/05
 */
public class StringToIntegerConverter implements Converter<String, Integer> {

	@Override
	public Integer convert(String source) {
		return StringToIntegerUtil.convert(source);
	}
}
