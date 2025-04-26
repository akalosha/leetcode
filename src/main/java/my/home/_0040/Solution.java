package my.home._0040;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        int[] candidates = new int[]{1, 1, 1, 3, 3, 5};
        int target = 8;
        System.out.println(combinationSum2(candidates, target));
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        getResultWithCandidate(candidates, target, res, 0, new ArrayList<>());
        return res;
    }

    private static void getResultWithCandidate(int[] candidates, int target, List<List<Integer>> res, int startIndex, List<Integer> current) {
        if (0 == target) {
            res.add(new ArrayList<>(current));
        }
        for (int i = startIndex; i < candidates.length; i++) {
            int candidate = candidates[i];
            if (target < candidate) {
                break;
            } else if (i > startIndex && candidate == candidates[i - 1]) {
                continue;
            }
            current.add(candidate);
            getResultWithCandidate(candidates, target - candidate, res, i + 1, current);
            current.remove(current.size() - 1);
        }
    }
}