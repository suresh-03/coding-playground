class sandClockPattern{
	public static void main(String[] args) {
		int num = 9;
		int start = 1;
		int end = num * 2 - 1;
		int first = start;
		int second = end;
		int a = 0;

		for(int row = start; row <= end; row++){
			for(int col = start; col <= end; col++){
				if(row == start || col == start || row == end || col == end){
					System.out.print(num+" ");
				}
				else{
					if(col >= first && col <= second){
						System.out.print(num-a+" ");
					}
					else{
						
					}
				}
			}
		
			if(row == num){
				a = num-2;
				first = num-1;
				second = num+1;
			}
			else if(row > num){
				first--;
				second++;
				a--;
			}
			else{
			first++;
			second--;
			a++;
			}
			System.out.println();
		}
	}
}