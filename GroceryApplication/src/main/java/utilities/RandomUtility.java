package utilities;

import java.util.Random;

public class RandomUtility {
public int randomnumbers() {
	Random randomGenerator=new Random();
	int randomInt=randomGenerator.nextInt(10000);
	return randomInt;
	
}
public String randomPassword() {
	String upper="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	String lower="abcdefghijklmnopqrstuvwxyz";
	String number="0123456789";
	String character="!@#$%^&*><.,?";
	String combination=upper+lower+number+number+character;
	int lens =8;
	char[]pwd=new char[8];
	Random r=new Random();
	for(int i=0;i<lens;i++) {
		pwd[i]=combination.charAt(r.nextInt(combination.length()));
	}
	String password= new String(pwd);
	return password;
	
}
}
