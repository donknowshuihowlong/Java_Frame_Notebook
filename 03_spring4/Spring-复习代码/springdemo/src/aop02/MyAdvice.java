package aop02;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

//通知类
@Aspect
public class MyAdvice {
	
	//前置通知	
//		|-目标方法运行之前调用
	//后置通知(如果出现异常不会调用)
//		|-在目标方法运行之后调用
	//环绕通知
//		|-在目标方法之前和之后都调用
	//异常拦截通知
//		|-如果出现异常,就会调用
	//后置通知(无论是否出现 异常都会调用)
//		|-在目标方法运行之后调用
//----------------------------------------------------------------
	//前置通知
	@Before("execution(* aop02.*ServiceImpl.*(..))")
	public void before(){
		System.out.println("这是前置通知!!");
	}
	//后置通知
	@AfterReturning("execution(* aop02.*ServiceImpl.*(..))")
	public void afterReturning(){
		System.out.println("这是后置通知(如果出现异常不会调用)!!");
	}
	//环绕通知
	@Around("execution(* aop02.*ServiceImpl.*(..))")
	public Object around(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("这是环绕通知之前的部分!!");
		Object proceed = pjp.proceed();//调用目标方法
		System.out.println("这是环绕通知之后的部分!!");
		return proceed;
	}
	//异常通知
	@AfterThrowing("execution(* aop02.*ServiceImpl.*(..))")
	public void afterException(){
		System.out.println("出事啦!出现异常了!!");
	}
	//后置通知
	@After("execution(* aop02.*ServiceImpl.*(..))")
	public void after(){
		System.out.println("这是后置通知(出现异常也会调用)!!");
	}
}
