class Solution {

    public int largestOverlap(int[][] img1, int[][] img2) {
        return Math.max(
            maxOverlap(img1, img2),
            maxOverlap(img2, img1)
        );
    }

    public int maxOverlap(int[][] A, int[][] B) {

        int n = A.length;
        int count = 0;

        for (int x_shift = -(n - 1); x_shift <= n - 1; x_shift++) {

            for (int y_shift = -(n - 1); y_shift <= n - 1; y_shift++) {

                int temp = 0;

                for (int i = 0; i < n; i++) {

                    for (int j = 0; j < n; j++) {

                        int row = i - y_shift;
                        int col = j - x_shift;

                        if (row >= 0 && row < n &&
                            col >= 0 && col < n) {

                            if (A[i][j] == 1 &&
                                B[row][col] == 1) {

                                temp++;
                            }
                        }
                    }
                }

                count = Math.max(count, temp);
            }
        }

        return count;
    }
}