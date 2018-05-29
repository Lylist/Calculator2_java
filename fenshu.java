package test2;

import java.util.Random;
import java.util.Scanner;

public class fenshu {
	public static int cuowu=0;
    public static String suanshi;
    public static String z;
	public static void main(String args[]){
		int n,i=0,fenzia,fenzib,fenmua,fenmub,num;
		Random rand = new Random();
		String s="+-*/";
		char op;
		Scanner in=new Scanner(System.in);
		num=rand.nextInt(4);
		op=s.charAt(num);
		do{
			fenzia=rand.nextInt(10)+1;
			fenmua=rand.nextInt(10)+1;
		}while((fenzia>fenmua)||(fenzia==fenmua));
		do{
			fenzib=rand.nextInt(10)+1;
			fenmub=rand.nextInt(10)+1;
		}while((fenzib>fenmub)||(fenzib==fenmub));
		int c=f(fenzia,fenmua);
		fenzia=fenzia/c;
		fenmua=fenmua/c;
		c=f(fenzib,fenmub);
		fenzib=fenzib/c;
		fenmub=fenmub/c;
		if(op=='+')
		{
            suanshi=fenzia+"/"+fenmua+"+"+fenzib+"/"+fenmub+"=";
			//System.out.printf(suanshi);
			int temp1=fenzia*fenmub+fenzib*fenmua;
			int temp2=fenmua*fenmub;
			int temp3=f(temp1,temp2);
			temp1=temp1/temp3;
			temp2=temp2/temp3;
			if(temp1==temp2)
			{
				z="1";
			}
			else
			{
				z=temp1+"/"+temp2;
			}
			/*String ans=in.next();
			if(ans.equals(z))
				{
					System.out.println("true");
				}
				else
				{
					System.out.println("false");
					cuowu=cuowu+1;
				}*/
			}
			if(op=='-')
			{
                suanshi=fenzia+"/"+fenmua+"-"+fenzib+"/"+fenmub+"=";
				//System.out.printf(suanshi);
				int temp1=fenzia*fenmub-fenzib*fenmua;
				int temp2=fenmua*fenmub;
				if(temp1==0)
				{
					z="0";
				}
				else
				{
				int temp3=Math.abs(f(temp1,temp2));
				temp1=temp1/temp3;
				temp2=temp2/temp3;
				if(temp1==temp2)
				{
					z="1";
				}
				else
				{
					z=temp1+"/"+temp2;
				}
				}
				/*String ans=in.next();
				if(ans.equals(z))
				{
					System.out.println("true");
				}
				else
				{
					System.out.println("false");
					cuowu=cuowu+1;
				}*/
			}
			if(op=='*')
			{
                suanshi=fenzia+"/"+fenmua+"*"+fenzib+"/"+fenmub+"=";
				//System.out.printf(suanshi);
				int temp1=fenzia*fenzib;
				int temp2=fenmua*fenmub;
				int temp3=f(temp1,temp2);
				temp1=temp1/temp3;
				temp2=temp2/temp3;
				if(temp1==temp2)
				{
					z="1";
				}
				else
				{
					z=temp1+"/"+temp2;
				}

			}
			if(op=='/')
			{
                suanshi=fenzia+"/"+fenmua+"÷"+fenzib+"/"+fenmub+"=";
				
				int temp1=fenzia*fenmub;
				int temp2=fenmua*fenzib;
				int temp3=f(temp1,temp2);
				temp1=temp1/temp3;
				temp2=temp2/temp3;
				if(temp1==temp2)
				{
					z="1";
				}
				else
				{
					z=temp1+"/"+temp2;
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
