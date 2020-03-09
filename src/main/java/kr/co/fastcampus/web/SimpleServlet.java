package kr.co.fastcampus.web;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(
		name="simple",
		urlPatterns = "/simple"
)
@Slf4j
public class SimpleServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.info("SimpleServlet Start..");
		PrintWriter writer = resp.getWriter();
		writer.println("Hello JSP Servlet");
	}
}
