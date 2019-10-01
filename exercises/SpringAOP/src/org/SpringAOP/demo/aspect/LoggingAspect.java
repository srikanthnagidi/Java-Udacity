package org.SpringAOP.demo.aspect;

//import org.SpringAOP.demo.model.Triangle;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect

public class LoggingAspect {
	
	// loggingAdvice  method will be called before all the getters execute  
	
	@Before("allTriangleMethods() && allGetters()") 
	public void loggingAdvice(JoinPoint joinPoint) {
		System.out.println("Advice run: Triangle method is called");
		System.out.println(joinPoint.getTarget());
		//Triangle triangle = (Triangle) joinPoint.getTarget();
	}

	@Before("args(name)")
	public void stringArgumentMethods(String name) {
		System.out.println("A method that takes String argument is called by object named: " + name);
	}
	/*
	 * @Before("allGetters()") public void secondAdvice() {
	 * System.out.println("Second Advice executed"); }
	 */
	
	@Pointcut("execution(* get*())") 
	public void allGetters() {}
	  
	 
	@Before("allCircleMethods()") 
	public void circleMethodCalledAdvice() {
		System.out.println("Circle method called: "); 
	}
	  
	//this will be called for all the methods in circle
	  
	@Pointcut("within(org.SpringAOP.demo.model.Circle)") 
	public void allCircleMethods(){}
	
	@Pointcut("within(org.SpringAOP.demo.model.Triangle)") 
	public void allTriangleMethods() {}
	 
}