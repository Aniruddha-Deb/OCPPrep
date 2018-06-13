package com.sensei.ocpprep.class_design;

public class InnerClassTest {
	
	// static inner class
	static class StaticInnerClass {
		// static classes can also declare instance variables.
		int instanceVar = 31;
		static int staticVar = 43;
		
		void print() {
			System.out.println( "This is a static inner class" );
			System.out.println( "Instance var = " + instanceVar + 
					            ", static var = " + staticVar );
		}
	}
	
	// instance inner class
	class InstanceInnerClass {
		void print() {
			System.out.println( "This is an instance inner class" );
		}
	}
	
	// abstract inner class (used as an anonymous inner class)
	abstract class AbstractInnerClass {
		int num = 12;
		abstract void print();
	}
	
	// inner interface
	interface InnerInterface {
		int num = 17;
		void print();
	}
	
	void methodInnerClass() {
		// note that this variable is Effectively final - introduced in Java 8
		int accessingALocalVariable = 5;
		
		// method inner class
		// this can extend classes unlike an anonymous inner class
		class MethodInnerClass extends AbstractInnerClass{
			// note that these classes can declare constructors - unlike anonymous
			// inner classes
			MethodInnerClass() { 
				System.out.println("This is a method inner class constructor"); 
			}
			void print() { 
				System.out.println("This is a method inner class");
				System.out.println("Local variable value is " + accessingALocalVariable );
			}
		}
		
		MethodInnerClass mic = new MethodInnerClass();
		mic.print();
	}
	
	void anonInnerClass() {
		InnerInterface ai = new InnerInterface() {
			public void print() { 
				System.out.println( "This is an anon interface" );
				// note that the num variable can be accessed here - it is public,
				// static and final
				System.out.println( "The num is " + num );
			}
		};
		AbstractInnerClass aic = new AbstractInnerClass() {
			// this is an initializer block: similar to a constructor, but used 
			// in anon inner classes
			// note the order of execution of this statement in the test
			{ System.out.println( "This is an anon inner class init block" ); }
			
			void print() { 
				System.out.println( "This is an anon inner class" );
				// Note that if num is private, it cannot be accessed here.
				System.out.println( "The num is " + num );
			}
		};
		ai.print();
		aic.print();
	}
	
	void runTest() {
		InstanceInnerClass iic = new InstanceInnerClass();
		iic.print();
		StaticInnerClass sic = new StaticInnerClass();
		sic.print();
		// Static vars in the static inner class can be accessed as so : they have 
		// a namespace of their own.
		System.out.println( StaticInnerClass.staticVar );
		methodInnerClass();
		anonInnerClass();
	}
	
	public static void main( String[] args ) {
		InnerClassTest ict = new InnerClassTest();
		ict.runTest();
	}
}
