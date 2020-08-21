import java.util.*;
public class Two{
	public static void print(String str)
	{
		System.out.print(str);
	}
    	public static void main(String args[])
	{
    		Scanner sc = new Scanner(System.in);
    		print("Enter size of array: ");
    		int n = sc.nextInt();
    		print("Enter words: ");
    		Set<String> arr = new HashSet<String>();
    		for(int i = 0;i<n;i++)
		{
    			arr.add(sc.next());
    		}
    		print("Write -1 to end \n");
    		print("Write the para:\n");
    		String word = sc.next();
    		StringBuffer para = new StringBuffer();
    		while(!word.equals("-1")){
    		if(arr.contains(word)){
    			para.append(word.charAt(0)+"");
    			for(int i = 1;i<word.length();i++){
    				para.append("*");
    			}
    			para.append(" ");
    		}
    		else{
    			para.append(word);
    			para.append(" ");
    		}
    		word = sc.next();
    	}
    	print(para.toString().trim());
    	//print("\n");
    	
    }   
}