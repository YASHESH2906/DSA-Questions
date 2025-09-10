package Opmial_storage_on_tape;
import java.util.*;
public class OSOT 
{
 	public static void bubble(int arr[])
	{
        	for(int turn = 0; turn < arr.length-1;turn ++)
		{
           	 	for (int j = 0; j < arr.length-1-turn; j++)
			{
                		if( arr[j]> arr[j+1])
				{
                  			  //swapping the function

                   			int temp = arr[j];
                   			arr[j] = arr[j+1];
                   			arr[j+1] = temp; 
                		}
            		}
        	}
   	}

//main function of the Program

	public static void main(String[]args)
	{
        	Scanner sc = new Scanner(System.in);
        	System.out.print("Enter the number of programs: ");
        	int n = sc.nextInt(); // number of programs

        	int arr[] = new int[n]; 
        	System.out.println("enter the array element : ");
        	for(int i = 0;i < arr.length; i++)
		{
            		arr[i] = sc.nextInt();
        	}
       		bubble(arr);
        	System.out.print("Optimal order in which programs are to be stored is: ");
        	for (int i = 0; i < n; i++)
		{
            		System.out.print(arr[i] + " ");
        	}
        	System.out.println();

            // MRT - Minimum Retrieval Time
      		double MRT = 0;
       		for (int i = 0; i < n; i++) 
        	{
           		 int sum = 0;
            		for (int j = 0; j <= i; j++)
               		sum += arr[j];
            		MRT += sum;
		}
        	MRT /= n;
        	System.out.print( "Minimum Retrieval Time of this order is " + MRT);

    	}
}
