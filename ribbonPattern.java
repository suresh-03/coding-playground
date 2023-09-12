class ribbonPattern{
	public static void main(String[] args) {
			int n = 11;


		int first = 1;
		int second = n;

			for(int row = 1; row <= n; row++){
			for(int col = 1; col <= n; col++){
				if(col == 1 || col == n || row == col && col <= n/2+1 || col == first || col == second){
					System.out.print("+");
				}
				else{

					System.out.print(" ");
				}
			}
			first++;
			second--;
			System.out.println();
		}
	}
	}
