package com.dsr.java.java8;

@FunctionalInterface
interface StringOperation<A>{

	A opearation(A a, A b);
	//void opearation();
	
	default int testDefaultMethod() {
		return 100;
	}
}


@FunctionalInterface
interface GenericInterface<T>{
	T append(T a);
}

@FunctionalInterface
interface Finder {
    public int find(String s1, String s2);
}

public class LambdaExpression {
	
	public static int doFind(String s1, String s2){
        return 2;
    }
	
	public static int doFind1(String s1, String s2){
        return 2;
    }
	
	private void testMethodReference(){
		Finder finder = LambdaExpression::doFind1;
		System.out.println(finder.find("1", "2"));
		Finder finder1 = String::indexOf;
	}

	static String sampleInstance = "sample";
	
	public static void main(String[] in) {
		
		LambdaExpression exp = new LambdaExpression();
		
		exp.testMethodReference();
		
		GenericInterface<String> appendFunction = str -> str+" hellow ";
		
		System.out.println(appendFunction.append(" add "));
		String sampleLocale = "sample";
		
		StringOperation addOperaton = (a, b) -> { 
													int count = 0;
												   String res = a+""+b;
												   res = res+ sampleLocale;
												   return res;  };
		//MathOperation addOperaton = () -> {System.out.println("hello");};
		StringOperation operation = new StringOperation() {

			@Override
			public Object opearation(Object a, Object b) {
				return a+ " " +b;
			}
		};
		
		System.out.println(addOperaton.opearation(" one ", " two "));
		System.out.println(operation.opearation(" one ", " two "));

		
		System.out.println( addMethod("hello", "world") );
		
		
	}
	
	/**
	 * Generics usage.
	 * @param a
	 * @param b
	 * @return
	 */
	
	public static <T> T addMethod(T a, T b){
		
		return a;
		
		
	}
	
	
	
}
