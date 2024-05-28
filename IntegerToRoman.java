class IntegerToRoman {
    public String intToRoman(int num) {
        String ans = "*";

        ans = reps((num/1000), "M", "M", "M", ans);
        num -= ((num/1000) * 1000);

        ans = reps((num/100), "M", "D", "C", ans);
        num -= ((num/100) * 100);

        ans = reps((num/10), "C", "L", "X", ans);
        num -= ((num/10) * 10);

        return reps(num, "X", "V", "I", ans);
    }
    public String updateStr(String ans, String temp) {
        if (ans.equals("*")) {
            return temp;
        }
        return ans + temp;
    }
    public String reps(int temp, String high, String med, String low, String ans) {
        if (temp == 9) {
            ans = updateStr(ans, (low + high));
        }
        else if (temp >= 5) {
            ans = updateStr(ans, med);
            while ((temp-1) >= 5) {
                ans = updateStr(ans, low);
                temp--;
            }
        }
        else if (temp == 4) {
            ans = updateStr(ans, (low + med));
        }
        else if (temp > 0) {
            while (temp > 0) {
                ans = updateStr(ans, low);
                temp--;
            }
        }
        return ans;
    }
}
