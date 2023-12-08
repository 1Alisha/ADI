public class lps{
   
        public static String longestPalindrome(String s) {
            String t = sConvert(s);
            int n = t.length();
            int l = 0;
            int r = -1;
            int c = 0;
            int max = 0;
            int[] p = new int[n];
            p[0] = 0;
    
            for (int i = 1; i < n; i++) {
                int k;
                if (i > r) {
                    k = 0;
                } else {
                    int j = l + (r - i);
                    if (p[j] < r - i) {
                        p[i] = p[j];
                        continue;
                    } else {
                        k = r - i;
                    }
                }
    
                while (i - k >= 0 && i + k < n && t.charAt(i - k) == t.charAt(i + k)) {
                    k++;
                }
    
                k--;
                p[i] = k;
    
                if (p[i] > max) {
                    max = p[i];
                    c = i;
                }
    
                if (i + k > r) {
                    l = i - k;
                    r = i + k;
                }
            }
    
            // Adjust indices for the original string
            int start = (c - max) / 2;
            int end = start + max;
            return s.substring(start, end);
        }
    
        public static String sConvert(String s) {
            StringBuilder res = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                res.append('#');
                res.append(s.charAt(i));
            }
            res.append('#');
            return res.toString();
        }

        public static void main(String[] args){
            String s = "ababacababa";
            // String con = sConvert(s);
            String res = longestPalindrome(s);
    
            System.out.println(res);
        }
}