public class Assign4_q2 {

	public static void main(String[] args) {
		int val= -1; // 32 bits integer
		System.out.println("Original Integer: "+ val);
		byte b= (byte)val; // 8 bits byte
		System.out.println("Byte: "+b);
		char c= (char)b; // 16 bits character
		System.out.println("Char: "+c);
		val = (int) c; // Back to 32 bits
		System.out.println("Final Integer: "+ val+ " (Not same)"); // val is not same as the original one.
		
	}

}
