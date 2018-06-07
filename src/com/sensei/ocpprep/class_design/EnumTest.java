package com.sensei.ocpprep.class_design;

import java.util.Arrays;
import java.util.List;

enum AbstractMethodEnum {
	
	SUMMER {
		// note that other enum methods can be called in here
		void printSeasonalFruit() { System.out.println( name() + " : Mango" ); }
	},
	MONSOON {
		void printSeasonalFruit() { System.out.println( name() + " : Jamun" ); }		
	},
	WINTER {
		void printSeasonalFruit() { System.out.println( name() + " : Grape" ); }		
	};

	abstract void printSeasonalFruit();
}

enum EnumUnderTest {
	
	// declaring constructors. Note that each constructor is called only once
	CLASSES( "java", "python", "C#" ), 
	INTERFACES( "java", "C#" ), 
	ENUMS( "java" ), 
	ANNOTATIONS( "java" ), 
	MONADS( "haskell" );
	
	List<String> languages = null;
	// this can only be private; watch out!
	private EnumUnderTest( String... strings ) {
		languages = Arrays.asList( strings );
	}
	
	public void printLanguages() {
		for( String language : languages ) {
			System.out.println( "\t"+language );
		}
	}
}

public class EnumTest {

	public static void main( String[] args ) {
		// default methods in an enum
		// this returns all the values in the enum as an array
		EnumUnderTest[] enumValues = EnumUnderTest.values();
		// this converts a string to an enum value
		EnumUnderTest stringConvertedEnumValue = EnumUnderTest.valueOf( "ENUMS" );
		
		for( EnumUnderTest e : enumValues ) {
			// gives the enum name
			System.out.println( e.name() );
			// gives the enum name (again)
			System.out.println( e.toString() );
			// gives the index of the enum value in the enum
			System.out.println( e.ordinal() );
			// returns the difference in the ordinal of the two enum values
			System.out.println( e.compareTo( stringConvertedEnumValue ) );
			
			// calling a user defined enum method
			System.out.println( "Languages: " );
			e.printLanguages();
		}
		
		System.out.println( "Seasonal fruits: " );
		// testing the abstract enum
		for( AbstractMethodEnum e : AbstractMethodEnum.values() ) {
			e.printSeasonalFruit();
		}
	}
}
