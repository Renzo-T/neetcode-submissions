class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int boats = 0;
        int l = 0;
        int r = people.length - 1;
        // pairs obviously go together (a + b  = limit)
        while (l < r) {
            int sum = people[l] + people[r];
            if (sum == limit) {
                boats++;
                people[l++] = 0;
                people[r--] = 0;
            } else if (people[r] == limit) {
                boats++;
                people[r--] = 0;
            } else if (sum > limit) {
                r--;
            } else {
                l++;
            }
        }
        // greedily largest with next smallest
        l = people.length - 2;
        r = people.length - 1;
        while (r >= 0) {

            if (people[r] == 0) {
                r--;
                if (r == l) {
                    l--;
                }
                continue;
            }
            while (l >= 0 && (people[l] == 0 || people[l] + people[r] > limit)) {
                l--;
            }
            if (l >= 0) {
                people[r--] = 0;
                people[l--] = 0;
                boats++;
            } else {
                people[r--] = 0;
                boats++;
            }
        } 
        return boats;
    }
}