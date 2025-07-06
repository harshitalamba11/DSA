// class Solution {
//     public void helper(List<String> res, String num, int target, String str, int cal, int idx, int prev) {
        
//         if (idx == num.length()) {
//             if (cal == target) {
//                 res.add(str);
//             }
//             return;
//         }

//         int digit = num.charAt(idx) - '0';
//         char ch = num.charAt(idx);
//         // '+' operator
//         helper(res, num, target, str + "+" + ch, cal + digit, idx + 1, digit);

//         // '-' operator
//         helper(res, num, target, str + "-" + ch, cal - digit, idx + 1, -digit);

//         // '*' operator — fix: apply precedence
//         helper(res, num, target, str + "*" + ch, cal - prev + prev * digit, idx + 1, prev * digit);
//     }

//     public List<String> addOperators(String num, int target) {
//         List<String> res = new ArrayList<>();
//         int first = num.charAt(0) - '0';
//         String s = String.valueOf(num.charAt(0));
//         helper(res, num, target, s, first, 1, first); // str, cal, idx, prev
//         return res;
//     }
// }



class Solution {
    public void helper(List<String> res, String num, int target, String str, long cal, int idx, long prev) {
        
        if (idx == num.length()) {
            if (cal == target) {
                res.add(str);
            }
            return;
        }
for(int i=idx;i<num.length();i++){
    if (i != idx && num.charAt(idx) == '0') break;
    String part=num.substring(idx,i+1);
    Long curr=Long.parseLong(part);
        if (idx == 0) {
            helper(res, num, target, part, curr,i+1 ,curr);
        }
        else{
        // '+' operator
        helper(res, num, target, str + "+" + part, cal + curr, i + 1, curr);

        // '-' operator
        helper(res, num, target, str + "-" +part, cal - curr, i + 1, -curr);

        // '*' operator — fix: apply precedence
        helper(res, num, target, str + "*" + part, cal - prev + prev * curr, i + 1, prev * curr);
        }
    }
    }

    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        helper(res, num, target, "", 0, 0, 0); // str, cal, idx, prev
        return res;
    }
}
