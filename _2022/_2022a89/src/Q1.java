/**
 * Written by Koren Ben Ezra
 * In 2022b
 */
public class Q1 {

    public static boolean isJump (String str1, String str2, int step){
        if(str2.equals(""))
            return true;

        if(str1.charAt(0) == str2.charAt(0))
            return isJump(str1.substring(step),str2.substring(1),step);

        return false;
    }

    // -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- //

    public static int strStep (String str1, String str2){
        return strStep(str1,str2,1);
    }
    private static int strStep (String str1, String str2, int currStep){
        int maxStep = str1.length() / str2.length();
        if(currStep > maxStep)
            return -1;

        if(isJump(str1,str2,currStep))
            return currStep;

        return strStep(str1,str2,currStep+1);
    }




    public static void main (String [] args){

        System.out.println("true: " + isJump("adbrcfa", "abc", 2));
        System.out.println("false: " + isJump("cbdadbrcfa", "abc", 2));
        System.out.println("true: " + isJump("adcfbaagcxabc", "abc", 4));
        System.out.println("false: " + isJump("adcfbaagcxabc", "abc", 1));
        System.out.println("true: " + isJump("abcfbaagcxabcd", "abc", 1));
        System.out.println("true: " + isJump("abcfbaagcxabcd", "abc", 4));

        System.out.println("is 2: " + strStep("adbrcfa", "abc"));
        System.out.println("is -1: " + strStep("cbdadbrcfa", "abc"));
        System.out.println("is 4: " + strStep("adcfbaagcxabc", "abc"));
        System.out.println("is 1: " + strStep("abcfbaagcxabcd", "abc"));
    }
}
