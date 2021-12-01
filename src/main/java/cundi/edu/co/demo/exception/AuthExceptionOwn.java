package cundi.edu.co.demo.exception;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;


public class AuthExceptionOwn implements AuthenticationEntryPoint {

	@Override
	public void commence(HttpServletRequest request,HttpServletResponse response, AuthenticationException arg2)
			throws IOException, ServletException {
		//final Map<String, Object> mapException = new HashMap<>();

		arg2.printStackTrace();
		ExceptionWrapper ew = new ExceptionWrapper(HttpStatus.UNAUTHORIZED.value(), HttpStatus.UNAUTHORIZED.toString(), 
				arg2.getMessage(),request.getServletPath());
		
		response.setContentType("application/json");
		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

		final ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(new JavaTimeModule());
		mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
		mapper.writeValue(response.getOutputStream(), ew);
	}

}