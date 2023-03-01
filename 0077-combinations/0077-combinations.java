class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(1, k, n, new ArrayList<>(), res);
        return res;
    }
    
    private void backtrack(int start, int k, int n, List<Integer> comb, List<List<Integer>> res) {
        if (k == 0) {
            res.add(new ArrayList<>(comb));
            return;
        }
        for (int i = start; i <= n; i++) {
            comb.add(i);
            backtrack(i+1, k-1, n, comb, res);
            comb.remove(comb.size()-1);
        }
    }
}
