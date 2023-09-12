import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ListPermutation {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3 };
        List<List<Integer>> ans = new ArrayList<>();
        List<String> str = new ArrayList<>();

        ListPermute(arr, 0, ans);
        System.out.println(ans);
        System.out.println(str);
    }

    static void ListPermute(int[] arr, int index, List<List<Integer>> ans) {
        if (index == arr.length - 1) {
            List<Integer> ar = Arrays.stream(arr)
                    .boxed()
                    .collect(Collectors.toList());
            ans.add(ar);
            return;
        }

        for (int i = index; i < arr.length; i++) {
            swap(arr, i, index);
            ListPermute(arr, index + 1, ans);
            swap(arr, i, index);
        }
    }

    static void swap(int[] arr, int i, int index) {

        int temp = arr[i];
        arr[i] = arr[index];
        arr[index] = temp;
    }

    // In String
}
