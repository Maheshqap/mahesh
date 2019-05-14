package Java;

import java.util.Scanner;

public class PrimeNumber {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.print("Enter a Number : ");
	int num = sc.nextInt();
	int flag =1;
	for(int i=2; i<num; i++)
	{
		int rem = num%i;
		if(rem==1)
			flag = 0;
			return;
	}
	if(flag==1)
	{
		System.out.println(num+"is a PN");
	}
	else
		System.out.println(num+"is not a PN");
}
}
