class Solution {
public:
    vector<int> plusOne(vector<int>& digits) {
        int n = digits.size() - 1;
        int carry = 1;
        for(int i=n;i>=0;i--){
            if(digits[i] + carry == 10){
                carry = 1;
                digits[i] = 0;
            }
            else{
                digits[i] = digits[i] + carry;
                carry = 0;
                break;
            }
        }
        if(carry == 1){
            digits.insert(digits.begin(), 1); 
        }
        return digits;
    }
};