package src;

/** Program to print
 *   #
    ##
   ###
  ####
 #####
######
 * @author negib
 *
 */
public class ForLoopProgram {
	public static void main(String[] str)
	{
		int n =6;
		int j=n-1;
		for(int a=0 ; a<n; a++)
		{
			
			for(int i =0; i <n ; i++)
			{
				if(i>=j)
				{
					System.out.print("#");
				} else {
					System.out.print(" ");
				}
			}
			j--;
			System.out.print("\n");
		}
	}
}
