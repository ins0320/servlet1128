package com.test.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

//모든 주소에 대하여 filter를 적용
@WebFilter("/*")
public class CharacterEncodingFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		// 필터를 통과할 때 인코딩 설정
		// filter 실행 흐름: 브라우저 -> filter -> servlet
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		//지정한 방식으로 chain에 걸어 filter를 사용하겠다.
		chain.doFilter(request, response);
	}

}
