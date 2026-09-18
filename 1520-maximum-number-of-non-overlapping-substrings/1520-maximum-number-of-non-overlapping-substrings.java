class Solution {

    public List<String> maxNumOfSubstrings(String s) {

        int n = s.length();

        // Har character ki first position
        int[] first = new int[26];

        // Har character ki last position
        int[] last = new int[26];

        // Initially kisi character ki first position nahi mili
        Arrays.fill(first, n);

        // Initially koi character mila hi nahi
        Arrays.fill(last, -1);


        // STEP 1:
        // Har character ki first aur last position find karo
        for (int i = 0; i < n; i++) {

            // a -> 0, b -> 1, c -> 2 ...
            int c = s.charAt(i) - 'a';

            // First occurrence save karo
            first[c] = Math.min(first[c], i);

            // Last occurrence update karo
            last[c] = i;
        }


        // Valid intervals store karenge
        // Example: [2,2], [3,3], [8,10]
        List<int[]> intervals = new ArrayList<>();


        // STEP 2:
        // Har character se smallest valid substring banane ki try
        for (int c = 0; c < 26; c++) {

            // Character string mein hai hi nahi
            if (last[c] == -1) {
                continue;
            }

            // Starting position
            int start = first[c];

            // Initially ending position
            int end = last[c];

            boolean valid = true;


            // Current substring ke andar characters check karo
            for (int i = start; i <= end; i++) {

                int current = s.charAt(i) - 'a';


                // Is character ki koi occurrence
                // substring ke bahar left side mein hai
                if (first[current] < start) {
                    valid = false;
                    break;
                }


                // Is character ki last occurrence bhi
                // substring ke andar honi chahiye
                end = Math.max(end, last[current]);
            }


            // Agar valid hai toh interval save karo
            if (valid) {
                intervals.add(new int[]{start, end});
            }
        }


        // STEP 3:
        // End position ke according sort
        intervals.sort(
            (a, b) -> Integer.compare(a[1], b[1])
        );


        // Final answer
        List<String> result = new ArrayList<>();

        // Last selected substring ka ending index
        int previousEnd = -1;


        // STEP 4:
        // Greedily non-overlapping intervals choose karo
        for (int[] interval : intervals) {

            int start = interval[0];
            int end = interval[1];


            // Current substring previous se overlap nahi kar rahi
            if (start > previousEnd) {

                // Actual substring result mein daalo
                result.add(
                    s.substring(start, end + 1)
                );

                // Current ko previous bana do
                previousEnd = end;
            }
        }


        return result;
    }
}