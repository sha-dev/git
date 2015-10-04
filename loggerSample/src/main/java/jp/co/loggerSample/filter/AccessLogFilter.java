package jp.co.loggerSample.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang.RandomStringUtils;

import jp.co.loggerSample.controller.loggerController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

public class AccessLogFilter implements Filter{

	private static final Logger logger = LoggerFactory.getLogger(loggerController.class);
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		
			HttpServletRequest request = (HttpServletRequest)req;
			
			String requestId = RandomStringUtils.randomAlphanumeric(8);
			
			MDC.put("id",requestId);
	        logger.info("RequestID:"+requestId+" リクエストURI："+request.getRequestURI());
	        
	        try{
	        	System.out.println("sleep開始");
	        	Thread.sleep(5000); //3000ミリ秒Sleepする
	        	System.out.println("sleep終了");
	        	}catch(InterruptedException e){}
	        
	        
			 try {
		            chain.doFilter(req, res);
		        } finally {
		            MDC.remove("id");
		        }
					
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	
}
