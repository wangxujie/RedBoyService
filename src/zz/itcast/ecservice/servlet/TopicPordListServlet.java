package zz.itcast.ecservice.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import zz.itcast.ecservice.dao.ProductListDaoImpl;
import zz.itcast.ecservice.utils.CommonUtil;
import zz.itcast.ecservice.utils.DefaultUtils;

/**
 * Servlet implementation class TopicPordListServlet
 * 
 * 请求topic对应商品列表.
 */
@WebServlet("/topic/plist")
public class TopicPordListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TopicPordListServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("test TopicPordListServlet");
		
		String pageStr = request.getParameter("page");
		pageStr = DefaultUtils.defalut(pageStr, "1");
		int page = Integer.parseInt(pageStr);
		String pageNumStr = request.getParameter("pageNum");
		pageNumStr = DefaultUtils.defalut(pageNumStr, "10");
		int pageNum = Integer.parseInt(pageNumStr);
		String id = request.getParameter("id");
		if (null== id || "".equals(id)) {
			DefaultUtils.defalutError(response, "id 不能为空");
			return;
		}
		int topic = Integer.parseInt(id);
		
		String orderby = request.getParameter("orderby");
		
		ProductListDaoImpl dao = new ProductListDaoImpl();
		List<Map<String,Object>> topicProdList = dao.getTopicProdList(page, pageNum, topic, orderby);
		Map<String, Object> data = new HashMap<String, Object>();
//		"response": "topic_productlist",  "list_count":"15"  productlist
		data.put("response", "topicProductList");
		data.put("listCount",topicProdList.size());
		data.put("productList", topicProdList);
		
		
		CommonUtil.renderJson(response, data);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
