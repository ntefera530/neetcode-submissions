class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int ROW = matrix.length;
        int COL = matrix[0].length;

        int END = ROW * COL;

        int top = 0;
        int bot = ROW - 1;

        while(top <= bot){
            int mid = top + ((bot - top) / 2);
            int front = matrix[mid][0];
            int end = matrix[mid][COL - 1];

            if(front == target || end == target){
                return true;
            }
            //found the correct row
            else if(front < target && target < end){
                break;
            }
            else if(target < front){
                bot = mid - 1;
            }
            else if(target > end){
                top = mid + 1;
            }

        }

        int left = 0;
        int right = COL - 1;
        int row = top + ((bot - top) / 2);

        if (!(top <= bot)) {
            return false;
        }
        int[] correct_row = matrix[row];

        while(left <= right){
            int mid = left + ((right - left) / 2);

            if(correct_row[mid] == target){
                return true;
            }
            else if(correct_row[mid] > target){
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }

        return false;

    }
}
