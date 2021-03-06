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
 * 获得最新上架商品列表
 * Servlet implementation class LimitBuyProdListServlet
 */
@WebServlet("/newproduct")
public class NewProdListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewProdListServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest  request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("test NewProdListServlet");
		
		String pageStr = request.getParameter("page");
		pageStr = DefaultUtils.defalut(pageStr, "1");
		int page = Integer.parseInt(pageStr);
		String pageNumStr = request.getParameter("pageNum");
		pageNumStr = DefaultUtils.defalut(pageNumStr, "10");
		int pageNum = Integer.parseInt(pageNumStr);
		String orderby = request.getParameter("orderby");
		
		ProductListDaoImpl dao = new ProductListDaoImpl();
		List<Map<String,Object>> newProdList = dao.getNewProdList(page, pageNum, orderby);
		
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("response", "newProduct");
		data.put("listCount",newProdList.size());
		data.put("productList", newProdList);
		
		
		CommonUtil.renderJson(response, data);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
