import java.util.Arrays;

class Printpermutation{
    public static void main(String[] args) {
        permute(new int[]{1,2,3}, 0);
    }

    static void permute(int[] arr,int index){
        if(index == arr.length-1){
            System.out.println(Arrays.toString(arr));
            return;
        }

        for(int i = index; i < arr.length; i++){
            int temp = arr[i];
            arr[i] = arr[index];
            arr[index] = temp;
            permute(arr, index+1);
            temp = arr[i];
            arr[i] = arr[index];
            arr[index] = temp;
        }
    }
}