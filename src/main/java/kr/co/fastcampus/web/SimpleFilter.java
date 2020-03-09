package kr.co.fastcampus.web;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;


@WebFilter(
		filterName = "simpleFilter",
		urlPatterns = "/simple"
)
@Slf4j
public class SimpleFilter implements Filter {
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		log.info("Filter - Hello World - log");

		HttpSession session = ((HttpServletRequest)request).getSession();
		String username = (String)session.getAttribute("username");
		if(username == null){
			log.info("New User");
			session.setAttribute("username","admin");
		}else{
			log.info("user --> "+ username);
		}

		chain.doFilter(request,response);
		PrintWriter writer = response.getWriter();
		writer.println("filter - Hello  - view");
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void destroy() {

	}
}
