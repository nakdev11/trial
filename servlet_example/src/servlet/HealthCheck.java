package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Health;
import model.HealthCheckLogic;

/**
 * Servlet implementation class HealthCheck
 */
@WebServlet("/HealthCheck")
public class HealthCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/healthCheck.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// リクエストパラメータ取得
		String weight = request.getParameter("weight");
		String height = request.getParameter("height");

		// JavaBeansに詰める
		Health health = new Health();
		health.setWeight(Double.parseDouble(weight));
		health.setHeight(Double.parseDouble(height));

		// 健康チェックを実行し結果をJavaBeansに詰める
		HealthCheckLogic healthCheckLogic = new HealthCheckLogic();
		healthCheckLogic.execute(health);

		// リクエストスコープに保存
		request.setAttribute("health", health);

		RequestDispatcher dispatcher = request.getRequestDispatcher(
				"/WEB-INF/jsp/healthCheckResult.jsp");
		dispatcher.forward(request, response);
	}

}
