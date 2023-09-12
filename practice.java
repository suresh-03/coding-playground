class practice{
    public static void main(String[] args) {
        recursion(4);
    }

    static int recursion(int n){
        if(n == 0){
             return n;
        }

        int i = 1;

        for(; i <= n; i++){
            System.out.println(i);
            recursion(n-1);

        }

        return n;
    }
}