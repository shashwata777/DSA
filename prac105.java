public class prac105 {



    public boolean  anagram(String s1, String s2) {


        if(s1.length() !=s2.length()){
            return false;
        }

        int[] arr = new int[26];
        for(int i = 0; i< s1.length(); i++){
            arr[s1.charAt(i) - 'a']++;
        }
        for(int i = 0 ; i<s1.length(); i++){
            arr[s2.charAt(i) - 'a']--;
        }

        for(int j : arr){
            if(j < 0) return false;
        }



        return true;

    }

    public static void main (String[]args){

        String s1 = "earth";
        String s2 = "heart";
        prac105 obj = new prac105();
        System.out.println(obj.anagram(s1,s2));
    }
}


