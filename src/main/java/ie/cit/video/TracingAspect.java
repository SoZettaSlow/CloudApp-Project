package ie.cit.video;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class TracingAspect {
	
	private static Log log = LogFactory.getLog(TracingAspect.class);
	
	@Before("execution(* ie.cit.video.JdbcVideoRepository.*(..))")
	public void traceMethod(JoinPoint point){
		String className = point.getTarget().getClass().getName();
		String methodName = point.getSignature().getName();
		log.trace("method invoked: " +className+ "#"+methodName);
		
	}
	
	@Before("execution(* ie.cit.video.web.VideostoreController.*(..))")
	public void traceControllerMethod(JoinPoint point){
		String className = point.getTarget().getClass().getName();
		String methodName = point.getSignature().getName();
		log.trace("method invoked: " +className+ "#"+methodName);
		
	}
}
