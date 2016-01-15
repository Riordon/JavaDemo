package com.luffy.btrace;

import com.sun.btrace.annotations.BTrace;
import com.sun.btrace.annotations.Kind;
import com.sun.btrace.annotations.Location;
import com.sun.btrace.annotations.OnMethod;
import com.sun.btrace.annotations.ProbeClassName;
import com.sun.btrace.annotations.ProbeMethodName;
import com.sun.btrace.annotations.TLS;

@BTrace(unsafe = true)
public class TraceHelloWorld {
	
	@TLS
	private static long startTime = 0;
	
	@OnMethod(clazz = "com.luffy.btrace.HelloWorld", method = "execute")
	public static void startMethod() {
		startTime = System.currentTimeMillis();
	}
	
	@OnMethod(clazz = "com.luffy.btrace.HelloWorld", method = "execute", location = @Location(Kind.RETURN))
	public static void endMethod() {
		System.out.println("the class method execute time=>" + String.valueOf((System.currentTimeMillis()-startTime)));
		System.out.println("--------------------------------------------------------");
	}
	
	@OnMethod(clazz = "com.luffy.btrace.HelloWorld", method = "execute", location = @Location(Kind.RETURN))
	public static void traceExecute(@ProbeClassName String name,@ProbeMethodName String method,int sleepTime) {
		System.out.println("the class name=>" + name);
		System.out.println("the class method=>" + method);
		System.out.println("the class sleepTime=>" + sleepTime);
		System.out.println("--------------------------------------------------------");
	}
}
