package com.example.spring_awesome.common.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @Description:
 * @date: 2021/9/1 13:34
 */

@RestControllerAdvice(basePackages = "com.example.spring_awesome")
@Slf4j
public class ResponseAdvice implements ResponseBodyAdvice<Object> {

	@Autowired
	private ObjectMapper objectMapper;

	@Override
	public boolean supports(MethodParameter methodParameter, Class aClass) {
		return true;
	}

	@SneakyThrows
	@Override
	public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class aClass,
								  ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
		if (o instanceof ResultData) {
			return o;
		}
		return ResultData.success(o);
	}
}