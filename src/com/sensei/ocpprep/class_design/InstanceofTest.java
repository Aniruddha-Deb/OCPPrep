package com.sensei.ocpprep.class_design;

class Animal {}

class Hippo extends Animal {}

class Elephant extends Animal {}

public class InstanceofTest {
	
	public static void main(String[] args) {
		Animal a1 = new Hippo();
		Animal a2 = new Elephant();
		Animal a3 = new Animal();
		
		boolean[] bools = new boolean[12];
		
		bools[0] = a1 instanceof Hippo;    // true
		bools[1] = a1 instanceof Animal;   // true
		bools[2] = a1 instanceof Elephant; // false
		
		bools[3] = a2 instanceof Hippo;    // false
		bools[4] = a2 instanceof Animal;   // true
		bools[5] = a2 instanceof Elephant; // true
		
		bools[6] = a3 instanceof Hippo;    // false 
		bools[7] = a3 instanceof Animal;   // true   - a supertype is not an 
		bools[8] = a3 instanceof Elephant; // false    instance of a subtype
		
		Hippo h1 = new Hippo();
		// bools[9] = h1 instanceof Elephant; // - Does not compile
		// an explicitly incompatiable object reference cannot be used with 
		// instanceof
		
		Animal a4 = null;
		bools[9] = a4 instanceof Animal;  // false - a null reference is not an 
		bools[10] = a4 instanceof Object; // false   instance of anything.
		
		// bools[11] = 5 instanceof Integer; // - does not compile
		// autoboxing is not supported by integer
		
		for( boolean b : bools ) {
			System.out.println( b );
		}
	}

}
