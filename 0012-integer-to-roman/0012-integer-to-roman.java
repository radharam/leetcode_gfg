class Solution {
    public String intToRoman(int num) {
        //first we create a table of roman word and their values..
        String romanWord[] = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
        int value[] = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
        //initialize and set the index i...
        int i = romanWord.length - 1;
        //create the solution which will be in string format...
        String sol = "";
        //a loop will be made to begin the procedure...
        while(num>0){
            //this loop is working untill the the vslue of integer is less or equal to num...
            while(value[i]<=num){
                //Append the roman numeral into an solution string...
                sol += romanWord[i];
                //subtract the integral value from the given integer...
                //Subtract the current number until the given integer is greater than the current number.
                num -= value[i];
            }
            i--;
        }
        //Once we are done with all the roman numerals, we return the solution.
        return sol;
    }
}