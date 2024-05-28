class RomanToInteger {
    public int romanToInt(String s) {
        int[] symbolVals = {1000, 500, 100, 50, 10, 5, 1};
        int i = 0;
        int ans = 0;
        while (i < s.length()) {
            if (i != (s.length()-1)) {
                if (indexOf(s.charAt(i)) > indexOf(s.charAt(i+1))) {
                    ans -= symbolVals[indexOf(s.charAt(i))];
                    ans += symbolVals[indexOf(s.charAt(i+1))];
                    i+=2;
                }
                else {
                    ans += symbolVals[indexOf(s.charAt(i))];
                    i++;
                }
            }
            else {
                ans += symbolVals[indexOf(s.charAt(i))];
                i++;
            }
        }
        return ans;
    }
    public int indexOf(char c) {
        char[] s = {'M', 'D', 'C', 'L', 'X', 'V', 'I'};
        for (int i = 0; i < s.length; i++) {
            if (s[i] == c) {
                return i;
            }
        }
        return 0;
    }
}
