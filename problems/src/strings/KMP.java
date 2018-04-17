package strings;

import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;

/**
 * Created by aambasth on 17/04/18.
 */
public class KMP {

    static int[] buildPrefixArray(char[] pattern){
        int[] prefix = new int[pattern.length];
        int k = -2;
        for(int i=0; i<pattern.length; i++){
            while(k >= -1 && pattern[k+1] != pattern[i]){
                k = (k==-1) ? -2: prefix[k];
            }

            prefix[i] = ++k;
        }

        return prefix;
    }

    static void match(String text, String pat){

        char[] pattern = pat.toCharArray();
        int[] prefix = buildPrefixArray(pattern);
        char[] inp = text.toCharArray();

        int k = -1;
        for(int i=0; i<inp.length; i++){
            while(k>=-1 && pattern[k+1] != inp[i]){
                k = (k==-1) ? -2 : prefix[k];
            }
            k++;

            if(k == pattern.length - 1){
                System.out.println("matched at" + (i-k));
                k = (k==-1) ? -2: prefix[k];
            }
        }

    }

    public static void main(String[] args) {
        String text = "AABAACAADAABAABA";
        String pattern = "AABA";

        match(text, pattern);
    }
}
