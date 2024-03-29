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
	
	public static int Solution1(int[] a) {
		int maxSum = 0;
		int thisSum;
		int n = a.length;
		
		// i = the starting index of sum
		for(int i = 0; i < n; i++)
		{
			// j = ending index of sum
			for(int j = i; j < n; j++)
			{
				thisSum = 0;
				
				for(int k = i; k <= j; k++)
				{
					thisSum += 	a[k];
					
					if(thisSum > maxSum)
					{
						maxSum = thisSum;
					}
				}
			}
		}
		
		return maxSum;
	}
	
	public int Solution2(int[] a) {
		int maxSum = 0; 
		int thisSum = 0;
		int n = array.length;
		//i: starting index of sum 
		for(int i=0; i< n; i++) {     
			thisSum= 0;     
			//compute all sums that begin with index i     
			for(int j=i; j< n; j++){
				thisSum += a[j];
			}
			}
		 
        if(thisSum > maxSum)              
        	maxSum = thisSum;  
	return maxSum; 
	}
	
	public int Solution3(int a[], int left, int right) {
		//Base case 1     
		if(right == left)         
			return a[left]; 
		 
	    //Base case 2
		if(right == left+1)
			return max(a[left],a[right],a[left]+a[right]) ;
	 
	     int mid = (left+right)/2;      
	     //Find the MSS that occurs in the left half of a      
	     int mss_left = Solution3(a,left,mid); 
	 
	     //Find the MSS that occurs in the right half of a     
	     int mss_right = Solution3(a,mid+1,right); 
	 
	     //Find the MSS that intersects both the left and right halves
	     double mss_middle = mss_junior_middle(a,left,mid,right);       
	     
	     return max(mss_left,mss_right,mss_middle) 
	}
	
	double mss_junior_middle(int[] a,int left,int mid,int right) {     
		double max_left_sum = Double.NEGATIVE_INFINITY;     
		int sum = 0;     int i; 
		for(i=mid; i >= left; i--)     {
			sum += a[i]; 
			if(sum > max_left_sum)
				max_left_sum = sum;     
			} 
		double max_right_sum = Double.NEGATIVE_INFINITY;     
		sum = 0; 
		for(i=mid+1; i <= right; i++){ 
			sum += a[i]; 
			if(sum > max_right_sum)
				max_right_sum = sum;     
			}      
		return max_left_sum + max_right_sum;
	}
	
	public int Solution4(int a[]) {
		int maxSum = 0; 
		int thisSum = 0; 
		int n = a.length;
		 
		for(int i=0; i< n; i++) {
			thisSum += a[i];
			if(thisSum > maxSum)
				maxSum = thisSum;
			else if(thisSum < 0)
				thisSum = 0; 
		} return maxSum; 
	}
 
}
