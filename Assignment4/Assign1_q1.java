package Assignment4;
import java.util.*;

public class Assign1_q1 {

	public static void main(String[] args) {
		int n;
		System.out.println("Enter number of rows: ");
		Scanner in = new Scanner(System.in);
		n= in.nextInt();
		in.nextLine();
		String[] crops= new String[n];
		System.out.println("Enter plot values: ");
		for(int i=0;i<n;i++)
		{
			crops[i]= in.nextLine().trim();
		}
		char[][] crop_grid= new char[n][crops[0].length()];
		// to count the rows and columns that have been updated
		// the plots in which new crop is planted is made true
		// initially as no crop is replaced so false
		boolean[][] visited= new boolean[n][crops[0].length()];
		
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<crops[i].length();j++)
			{
				crop_grid[i][j]= crops[i].charAt(j);
				visited[i][j]= false;
			}
		}
		
		int min= replant(crop_grid,0,0,visited);
		System.out.println("Min: "+min);
		if(min==Integer.MAX_VALUE)
		{
			System.out.print("Not Possible");
			// no such field possible where neighbours are always different
		}
		int ans=0;// counts the number of plots replanted
		for(int i=0;i<crop_grid.length;i++)
		{
			for(int j=0;j<crop_grid[0].length;j++)
			{
				if(visited[i][j])
				{
					ans++;
				}
			}
		}
		
		System.out.print("Minimum replacements required are: "+ ans);

	}
	
	private static int replant(char[][] crop_grid, int row, int col,boolean[][] visited)
	{
		//System.out.println(row+" "+col);
		
		// base case
		if(row== crop_grid.length)
		{
			return 0;
		}
		char left='\0',right='\0',down='\0',up='\0';
		if(row!=0)
		{
			up= crop_grid[row-1][col];
		}
		if(row!=crop_grid.length-1)
		{
			down= crop_grid[row+1][col];
		}
		if(col!=0)
		{
			left= crop_grid[row][col-1];
		}
		if(col!=crop_grid[0].length-1)
		{
			right= crop_grid[row][col+1];
		}
		
		// if either left or up is same then we update the current plot(row-col value) with
		// a character which satisifies the condition that no neighbour must be same
		// if left and up both are different from current plot then we just move further to the next plot
		// in the left to right direction (i.e. start from row=0 and col=0 till row= n-1 and col=m-1 
		
		if(left== crop_grid[row][col] || up== crop_grid[row][col])
		{
			int min = Integer.MAX_VALUE;
			char f_char='\0'; // this will store the final updated character
			for(char ch='a';ch<='z';ch++)
			{
				if(crop_grid[row][col]!=ch && left!=ch && up!=ch && right!=ch && down!=ch )
				{
					char[][] temp= crop_grid;
					temp[row][col]= ch;
					int count ;
					if(col== crop_grid[0].length-1)
					{
						count = replant(temp,row+1,0,visited);// recursive call
					}
					else
					{
						count= replant(temp,row,col+1,visited);// recursive call
					}
					if(count<min)
					{
						min= count;
						f_char= ch;
					}
					
				}
			}
			
			// if a replacement is required in the current plot then we mark that particular plot
			// as true in the visited matrix.
			if(f_char!='\0')
			{
				//System.out.println("Updated: "+f_char+" "+row+" "+col);
				crop_grid[row][col]= f_char;
				if(visited[row][col])
				{
					return min;
				}
				visited[row][col]=true;
				
			}
			// case where it is not possible to create such a field
			if(min == Integer.MAX_VALUE)
			{
				return min;
			}
			return min+1;
		}
		else
		{
			int count= Integer.MAX_VALUE;
			if(col== crop_grid[0].length-1)
			{
				count = replant(crop_grid,row+1,0,visited);// recursive call
			}
			else
			{
				count= replant(crop_grid,row,col+1,visited);// recursive call
			}
			if(count == Integer.MAX_VALUE)
			{
				return count;
			}
			return count;
			
		}
		
	}

}
