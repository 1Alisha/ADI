public class uglyNum {
  
        public static boolean isUgly(int num) {
            if (num <= 0) {
                return false;
            }
            
            while (num % 2 == 0) {
                num /= 2;
            }
            while (num % 3 == 0) {
                num /= 3;
            }
            while (num % 5 == 0) {
                num /= 5;
            }
            
            return num == 1;
        }
    
        public static int uglyNumber(int n) {
            int[] p = new int[n];
            p[0] = 1;
    
            int i2 = 0, f2 = 2;
            int i3 = 0, f3 = 3;
            int i5 = 0, f5 = 5;
    
            for (int i = 1; i < n; i++) {
                int min = Math.min(Math.min(f2, f3), f5);
                p[i] = min;
                if (f2 == min) {
                    f2 = 2 * p[++i2];
                }
                if (f3 == min) {
                    f3 = 3 * p[++i3];
                }
                if (f5 == min) {
                    f5 = 5 * p[++i5];
                }
            }
            return p[n - 1];
        }
    
        public static void main(String[] args) {
            int n = 10;
            System.out.println("Ugly Number at position " + n + ": " + uglyNumber(n));
            
            int numToCheck = 30;
            System.out.println(numToCheck + " is Ugly? " + isUgly(numToCheck));
        }
    
    
}
