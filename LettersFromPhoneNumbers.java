class LettersFromPhoneNumbers {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<String>();
        int val = 0;
        int len = 0;
        int finished = 1;
        for (int i = 0; i < digits.length(); i++) {
            val = digits.charAt(i) - 48;
            if (len == 0) {
                len += findNumLet(val);
            }
            else {
                len *= findNumLet(val);
            }
        }
        for (int i = 0; i < digits.length(); i++) {
            val = digits.charAt(i)-48;
            ans = updateList(ans, val, len, finished);
            finished *= findNumLet(val);
        }
        return ans;
    }
    public List<String> updateList(List<String> cur, int num, int len, int finished) {
        if (cur.size() == 0) {
            for (int i = 0; i < findNumLet(num); i++) {
                for (int j = 0; j < len/findNumLet(num); j++) {
                    cur.add(Character.toString(numToChar(num, i)));
                }
            }
            return cur;
        }
        int index = 0;
        while (index < cur.size()) {
            for (int i = 0; i < findNumLet(num); i++) {
                for (int j = 0; j < ((len/finished)/findNumLet(num)); j++) {
                    cur.set(index, (cur.get(index)+numToChar(num, i)));
                    index++;
                }
            }
        }
        return cur;
    }
    public char numToChar(int val, int place) {
        char[] letters = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        if (val <= 7) {
            return letters[((val-2)*3)+place];
        }
        else if (val == 8) {
            return letters[19+place];
        }
        return letters[22+place];
    }
    public int findNumLet(int val) {
        if (val < 7 || val == 8) {
            return 3;
        }
        return 4;
    }
}
