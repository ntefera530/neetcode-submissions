class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashMap<Integer, Set<Character>> row = new HashMap<>();
        HashMap<Integer, Set<Character>> col = new HashMap<>();
        HashMap<Integer, Set<Character>> box = new HashMap<>();

        // Set<Character> row = new HashSet<>();
        // Set<Character> col = new HashSet<>();
        // Set<Character> box = new HashSet<>();
        
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                char digit = board[i][j];
                if(digit == '.'){
                    continue;
                }

                int box_key = (i / 3) * 3 + (j / 3);
                if(row.computeIfAbsent(i, k -> new HashSet<>()).contains(digit) || 
                    col.computeIfAbsent(j, k -> new HashSet<>()).contains(digit) ||
                    box.computeIfAbsent(box_key, k -> new HashSet<>()).contains(digit)){
                    return false;
                }

                row.get(i).add(digit);
                col.get(j).add(digit);
                box.get(box_key).add(digit);
            }
        }

        return true;
        
    }
}
