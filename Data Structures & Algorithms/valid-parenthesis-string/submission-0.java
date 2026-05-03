class Solution {
    public boolean checkValidString(String s) {
        int maxOpen = 0;
        int minOpen = 0;

        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                maxOpen++;
                minOpen++;
            } else if(s.charAt(i) == ')') {
                maxOpen--;
                minOpen--;
                if(maxOpen < 0) return false;
            } else {
                maxOpen++;
                minOpen--;
            }
            if(minOpen < 0) minOpen = 0;
        }
        return minOpen == 0;
    }
}
