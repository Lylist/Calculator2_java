package test2;


import java.util.Random;
import java.util.Scanner;

public class zhengshu {
	public static int cuowu;
	public static String suanshi,z;
	public  static void main(String args[]){
		int n,i=0,x,y,num;
		Random rand = new Random();
		String s="+-*/";
		char op;
		Scanner in=new Scanner(System.in);
		num=rand.nextInt(4);
		x=rand.nextInt(10) + 1;
		y=rand.nextInt(10) + 1;
		op=s.charAt(num);
		if(op=='+')
		{
			suanshi=x+"+"+y+"=";
			z=x+y+"";
			}
			if(op=='-')
			{
				suanshi=x+"-"+y+"=";
				int temp=x-y;
				z=temp+"";
			}
			if(op=='*')
			{
				suanshi=x+"*"+y+"=";
				int temp=x*y;
				z=temp+"";
			}
			if(op=='/')
			{
				suanshi=x+"÷"+y+"=";
				if(x%y==0)
				{
					int temp=x/y;
					z=temp+"";
				}
				else
				{
					int c=f(x,y);
					int fenzi=x/c;
					int fenmu=y/c;
					z=fenzi+"/"+fenmu;
					
				}
		}
	}
	public static int f(int a,int b){ 
		if(a < b){
			int c = a;
			a = b;
			b = c;
		}
		int r = a % b;
		while(r != 0){
			a = b;
			b = r;;
			r = a % b;
		}
		return b;
	}

}
