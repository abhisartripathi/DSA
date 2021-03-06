/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

// Majority element

class Solution {
    public int majorityElement(int[] nums) {
        int count=0,ch=0;
        for(int i=0;i<nums.length;i++){
            if(count==0){ch=nums[i];}
            if(nums[i]==ch){
                count+=1;
            }else {
                count-=1;
            }
        }
        // if(count > 0){
            return ch;
        // }
        
    }
}

//Binary Sum

class Solution {
    public String addBinary(String a, String b) {
        String result = new String("");
        int length = Math.max(a.length(), b.length()), alen=a.length(), blen=b.length();
        char carry = '0';
        for(int i=0;i<length;i++){
            char ach = i>=alen ? '0': a.charAt(alen-i-1);
            char bch = i>=blen ? '0':b.charAt(blen-i-1);
            
            char sum = add(add(ach,bch), carry);
            carry = getCarry(ach, bch, carry);
            result=sum+result;
            System.out.println(" res"+result+" ach"+ach+" bch"+bch+" carry"+carry+" sum"+sum);
        }
        if(carry == '1'){
            return ('1'+result);
        }
        return result;
    }
    public char add(char a, char b){
        if((a=='0'&&b=='0') || (a=='1'&&b=='1')){
            return '0';
        }
        return '1';
    }
    public char getCarry(char a, char b, char c){
        if((a=='1'&&b=='1') || (c=='1'&&b=='1') || (a=='1'&&c=='1')){
            return '1';
        }
        return '0';
    }
}

// Plus one

class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 0;
        digits[digits.length-1]+=1;
        for(int i=digits.length-1;i>=0;i--){
            digits[i]+=(carry);
            if(digits[i]>9){
                digits[i]=0;
                carry=1;
            }else {
                carry = 0;
            }
        }
        if(carry==1){
            int[] res = new int[digits.length+1];
            res[0] = carry;
            for(int i=0;i<digits.length;i++){
                res[i+1] = digits[i];
            }
            return res;
        }
        
        return digits;
    }
}

//Buy and Sell stock

class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length==0){ return 0;}
        int maxProfit = Integer.MIN_VALUE, minPrice = prices[0];
        for(int i=0;i<prices.length;i++){
            if(prices[i]<minPrice){
                minPrice = prices[i];
            }
            if((prices[i] - minPrice)>maxProfit){
                maxProfit = (prices[i] - minPrice);
            }
        }
        return maxProfit;
    }
}

// Buy and Sell Stock 2

class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        int[][] profit = new int[len][len];
        for(int i=0;i<len;i++){
            for(int j=0;j<len;j++){
                profit[i][j] = -(prices[i]-prices[j]);
            }
        }
        int maxup = 0, maxdown=0, maxpro =0;
        getmax(profit, 0, len);
        for(int i=1;i<=len;i++){
            int up = getmax(profit, 0, i);
            int down = getmax(profit, i, len);
            if(up+down > maxpro){
                maxpro = up+down;
            }
        }
        return maxpro;
    }
    public int getmax(int[][] arr, int start, int end) {
        int max = 0;
        for(int i=start;i<end;i++){
            for(int j=i;j<end;j++){
                // System.out.println("up"+arr[i][j]);
                if(max < arr[i][j]){
                    max = arr[i][j];
                }
            }
        }
        return max;
    }
}
