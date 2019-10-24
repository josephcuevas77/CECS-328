package project1;

public class Algorithms {
	
	private int[] array;
	
	public Algorithms(int[] array)
	{
		this.array = array;
	}
	
	public Algorithms()
	{
		this(null);
	}
	
	public void setArray(int[] array)
	{
		this.array = array;
	}
	
	public int[] getArray()
	{
		return this.array;
	}
	
	public int Solution1() {
		int maxSum = 0;
		int thisSum;
		int n = array.length;
		
		// i = the starting index of sum
		for(int i = 0; i < n; i++)
		{
			// j = ending index of sum
			for(int j = i; j < n; j++)
			{
				thisSum = 0;
				
				for(int k = i; k <= j; k++)
				{
					thisSum += array[k];
					
					if(thisSum > maxSum)
					{
						maxSum = thisSum;
					}
				}
			}
		}
		
		return maxSum;
	}
}
