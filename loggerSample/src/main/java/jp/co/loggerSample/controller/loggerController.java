package jp.co.loggerSample.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;


@RestController
@RequestMapping("/")
public class loggerController {
	
private static final Logger logger = LoggerFactory.getLogger(loggerController.class);
	
	 @RequestMapping(method = RequestMethod.GET)
	    public void logExport(HttpServletRequest request,HttpServletResponse responce) {
		 	String sessionId = request.getRequestedSessionId();
	       logger.info("RequestID:"+MDC.get("id")+" ステータス："+responce.getStatus());
	    }
}
