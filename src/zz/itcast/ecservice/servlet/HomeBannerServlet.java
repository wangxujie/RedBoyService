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

import zz.itcast.ecservice.dao.HomeBannerDaoImpl;
import zz.itcast.ecservice.utils.CommonUtil;

/**
 * Servlet implementation class HomeBannerServlet
 */
@WebServlet("/home")
public class HomeBannerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeBannerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		data(request,response);
	}
	private void data(HttpServletRequest request,  HttpServletResponse response) {
		HomeBannerDaoImpl daoImpl=new HomeBannerDaoImpl();
		List<Map<String, Object>> bannerList = daoImpl.getHomeBannerList();
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("response", "home");
		data.put("home_banner", bannerList);
		CommonUtil.renderJson(response, data);
		
	}



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
