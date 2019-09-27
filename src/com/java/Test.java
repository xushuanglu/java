package com.java;

public class Test {

	public static void main(String[] args) {
		//装箱 调用了 Integer.valueOf(2)
		Integer x = Integer.valueOf(2);
		System.out.println("装箱后：Integer.valueOf(" + x + ")");
		//拆箱 调用了 X.intValue()
		System.out.println("拆箱后：" + x.intValue() + ".intValue()");
		
		//缓存池
	    //new Integer(123) 每次都会新建一个对象；
	    //Integer.valueOf(123) 会使用缓存池中的对象，多次调用会取得同一个对象的引用。

		Integer a = new Integer(123);
		Integer b = new Integer(123);
		System.out.println(a == b);    // false
		Integer z = Integer.valueOf(123);
		Integer k = Integer.valueOf(123);
		System.out.println(z == k);   // true
		System.out.println(a == k);   // false
		
		Integer m = Integer.valueOf(123);
		Integer n = Integer.valueOf(123);;
		System.out.println(m == n); // true
		
		
		String c = "cc";
		String d = "cc";
		System.out.println(c == d);// true
		
		String s1 = new String("aaa");
		String s2 = new String("aaa");
		System.out.println(s1 == s2);           // false
		String s3 = s1.intern();
		String s4 = s1.intern();
		System.out.println(s3 == s4);           // true
		
		//如果是采用 "bbb" 这种字面量的形式创建字符串，会自动地将字符串放入 String Pool 中。
		String s5 = "bbb";
		String s6 = "bbb";
		System.out.println(s5 == s6);  // true
		
		
		float f = 1.1f;
		System.out.println(f);
		
		String s = "a";
		switch (s) {
		    case "a":
		        System.out.println("aaa");
		        break;
		    case "b":
		        System.out.println("bbb");
		        break;
		}
		
		
		Integer x1 = new Integer(1);
		Integer y  = new Integer(1);
		System.out.println(x1.equals(y)); // true
		System.out.println(x1 == y);      // false
		
		
		//浅拷贝
		ShallowCloneExample e1 = new ShallowCloneExample();
		ShallowCloneExample e2 = null;
		try {
		    e2 = e1.clone();
		} catch (CloneNotSupportedException e) {
		    e.printStackTrace();
		}
		e1.set(2, 222);
		System.out.println(e2.get(2)); // 222
		
		
		//深拷贝
		DeepCloneExample e3 = new DeepCloneExample();
		DeepCloneExample e4 = null;
		try {
		    e4 = e3.clone();
		} catch (CloneNotSupportedException e) {
		    e.printStackTrace();
		}
		e3.set(2, 222);
		System.out.println(e4.get(2)); // 2
		
		//拷贝构造函数
		CloneConstructorExample e11 = new CloneConstructorExample();
		CloneConstructorExample e22 = new CloneConstructorExample(e11);
		e11.set(2, 222);
		System.out.println(e22.get(2)); // 2
		
		//静态变量
		/*public class A {

		    private int x;         // 实例变量
		    private static int y;  // 静态变量

		    public static void main(String[] args) {
		        // int x = A.x;  // Non-static field 'x' cannot be referenced from a static context
		        A a = new A();
		        int x = a.x;
		        int y = A.y;
		    }
		}*/
		
		//静态方法
		/*public abstract  class A {
		    public static void func1(){
		    }
		}*/
		
		
		//静态语句块
		/*public class A {
		    static {
		        System.out.println("123");
		    }

		    public static void main(String[] args) {
		        A a1 = new A();
		        A a2 = new A();
		    }
		    
		    123
		}*/
		
		
		/*public class OuterClass {

		    class InnerClass {
		    }

		    static class StaticInnerClass {
		    }

		    public static void main(String[] args) {
		        // InnerClass innerClass = new InnerClass(); // 'OuterClass.this' cannot be referenced from a static context
		        OuterClass outerClass = new OuterClass();
		        InnerClass innerClass = outerClass.new InnerClass();
		        StaticInnerClass staticInnerClass = new StaticInnerClass();
		    }
		}*/
		
		
		
		
		
	}
}
