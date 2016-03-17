package bitcamp.java77.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class CosmeticInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		
		String requestPath = request.getRequestURI().toString();
		System.out.println("요청URI : " + requestPath);
		if(requestPath.equals("/second-life/cosmetic/ajax/mainReview.do")|| 
				requestPath.equals("/second-life/cosmetic/ajax/mainHospital.do")||
						requestPath.equals("/second-life/cosmetic/ajax/login.do")||
						requestPath.equals("/second-life/cosmetic/ajax/idCheck.do")||
						requestPath.equals("/second-life/cosmetic/ajax/join.do")){
			return true;
		}
		else{
			if(request.getSession().getAttribute("loginuser") == null){
				return false;
			}
			System.out.println("세션 : " + request.getSession().getAttribute("loginuser"));
			return true;
		}
	}
	
	
}
