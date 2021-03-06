package zz.itcast.ecservice.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import zz.itcast.ecservice.domain.ErrorMessage;
import zz.itcast.ecservice.utils.CommonUtil;

public class CartDeleteServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("response", "error");
		data.put("error", new ErrorMessage("删除失败"));
		CommonUtil.renderJson(response, data);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
