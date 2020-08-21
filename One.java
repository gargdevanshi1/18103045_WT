import java.util.*;
public class One {
	public static void print(String str)
	{
		System.out.print(str);
	}
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		String s1= sc.next();
		String s2= sc.next();
		if(s2.length()> s1.length())
		{
			print("Invalid input \n");
			return;
		}
		char st2[]= s2.toCharArray();
		Arrays.sort(st2);
		s2 = new String(st2);
		int l2= s2.length();
		int count=0;
		for(int i=0;i<s1.length()-l2+1;)
		{
			String temp= s1.substring(i,i+l2);
			st2= temp.toCharArray();
			Arrays.sort(st2);
			temp= new String(st2);
			if(temp.equals(s2))
			{
				count++;
				i+=l2;
			}
			else
			{
				i++;
			}
		}
		print("Number of substrings in s1: " + count);
	}

}