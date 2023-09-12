public class permutationString {

    public static void main(String[] args) {
        System.out.println(checkInclusion("mart", "karma"));
    }
        public static boolean checkInclusion(String s1, String s2) {
            for(int i = 0; i <= s2.length()-s1.length(); i++){
                String temp = s2.substring(i,i+s1.length());
                for(int j = 0; j < s1.length(); j++){
                    for(int k = 0; k < temp.length(); k++){
                        if(s1.charAt(j) == temp.charAt(k)){
                            String first = temp.substring(0,k);
                            String last = temp.substring(k+1,temp.length());
                            temp = first + last;
                            break;
                        }
                    }
                }
                if(temp.isEmpty()){
                    return true;
                }
            }
            return false;
        }
    }

