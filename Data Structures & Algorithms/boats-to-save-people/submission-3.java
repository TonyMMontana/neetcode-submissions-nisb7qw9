class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int maxVal = 0;
        for(int num : people) {
            maxVal = Math.max(maxVal, num);
        }

        int[] countArr = new int[maxVal + 1];
        for(int num : people) {
            countArr[num]++;
        }

        int pointer = 0;

        for(int i = 0; i < countArr.length; i++) {
            while(countArr[i] > 0) {
                people[pointer] = i;
                countArr[i]--;
                pointer++;
            }
        }

        int l = 0;
        int r = people.length - 1;
        int res = 0;

        while(l <= r) {
            if(people[l] + people[r] <= limit) {
                res++;
                r--;
                l++;
            } else {
                res++;
                r--;
            }
        }
        return res;
    }
}