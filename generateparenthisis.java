import java.util.*;

public class generateparenthisis {

    public static void main(String[] args) {
        generateparenthisis obj = new generateparenthisis();
        List<String> ans = obj.generate(3);
        System.out.println(ans);
    }

    public void generateparen(int n, int l, int r, String s, List<String> ans) {
        if (l == n && r == n) {
            ans.add(s);
            return;
        }

        if (l < n)
            generateparen(n, l + 1, r, s + "(", ans);

        if (r < l)
            generateparen(n, l, r + 1, s + ")", ans);

    }

    public List<String> generate(int n) {
        List<String> ans = new ArrayList<>();
        generateparen(n, 0, 0, "", ans); 
        return ans;
    }
}