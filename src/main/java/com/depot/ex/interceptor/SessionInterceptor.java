package com.depot.ex.interceptor;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.depot.ex.entity.User;
import com.depot.ex.utils.Constants;

/** * 
@author  作者 E-mail: * 
@date 创建时间：2017年10月7日 下午7:02:07 * 
@version 1.0 * 
@parameter  * 
@since  * 
@return  */
public class SessionInterceptor extends HandlerInterceptorAdapter{
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		request.setCharacterEncoding("UTF-8"); 
	    response.setCharacterEncoding("UTF-8"); 
	    response.setContentType("text/html;charset=UTF-8"); 

	    User user=(User) request.getSession().getAttribute("user");
	    if(null==user)
	    {
	    	// 未登录 
	          PrintWriter out = response.getWriter(); 
	          StringBuilder builder = new StringBuilder(); 
	          builder.append("<script type=\"text/javascript\" charset=\"UTF-8\">"); 
	          builder.append("alert(\"页面过期，请重新登录\");"); 
	          builder.append("window.top.location.href=\""); 
	          builder.append(Constants.basePath); 
	          builder.append("/login/login\";</script>"); 
	          out.print(builder.toString()); 
	          out.close(); 
	          return false;
	    }
		return super.preHandle(request, response, handler);
	}
}
