import java.util.*;
public class Four{
	public static void print(String str){
		System.out.print(str);
	}
    public static void main(String args[]){
    	Scanner sc = new Scanner(System.in);
    	print("Enter two Strings:\n");
        char str1[] = sc.next().toCharArray();
        char str2[] = sc.next().toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        print(Arrays.equals(str1,str2)+"\n");    	
    }   
                             
}