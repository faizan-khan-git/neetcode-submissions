class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if(matrix == null || matrix.length == 0){
            return result;
        }

        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        while(top <= bottom && left <= right){
            // traverse from left to right across top boundary
            for(int i = left; i<=right; i++){
                result.add(matrix[top][i]);
            }
            top++;

            // traverse from top to bottom down the right boundary
            for(int i = top; i<=bottom; i++){
                result.add(matrix[i][right]);
            }
            right--;

            // ensure we haven't crossed horizontal boundary before going left
            if(top <= bottom){
                for(int i = right; i>=left; i--){
                    result.add(matrix[bottom][i]);
                }
                bottom--;
            }

            // ensure we haven't crossed the vertical boundary before going up
            if(left <= right){
                for(int i = bottom; i>=top; i--){
                    result.add(matrix[i][left]);
                }
                left++;
            }
        }

        return result;
    }
}
