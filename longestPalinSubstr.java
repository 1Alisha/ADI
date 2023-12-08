import java.util.*;
public class longestPalinSubstr {
    public static String sol(String s){
        String t=toConvert(s);
        int n=t.length();

        int l=0;
        int r=-1;
        int c=0;
        int max=0;
        
        int p[]=new int[n];
        p[0]=0;

        for(int i=1;i<n;i++){
            int k;
            if(i>r){
                k=0;
            }else{
                int j=l+r-i;
                if(p[j]<r-i){
                    p[i]=p[j];
                    continue;
                }else{
                    k=r-i;
                }
            }

            while((i-k)>=0 && (i+k)<n && t.charAt(i+k)==t.charAt(i-k)){
                k++;
            }
            k--;
            p[i]=k;
            if(p[i]>max){
                max=p[i];
                c=i;
            }
            if(i+k>r){  //
                l=i-k;
                r=i+k;
            }
        }
        int start=(c-max)/2;
        int end=start+max;
        return s.substring(start,end);
    }
    public static String toConvert(String s){
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<s.length();i++){
            sb.append('#');
            sb.append(s.charAt(i));
        }
        sb.append("#");
        return sb.toString();
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();

       String ans=sol(str);
       System.out.println(ans);
    }
}
