package my.home._0039;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        int[] candidates = new int[]{2, 3, 6, 7};
        int target = 7;
        System.out.println(combinationSum(candidates, target));
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int startCandidateIndex = 0;
        for (int candidate : candidates) {
            res.addAll(getResultWithCandidate(candidates, target-candidate, candidate, new ArrayList<>(), startCandidateIndex++));
        }
        return res;
    }

    private static Collection<List<Integer>> getResultWithCandidate(int[] candidates, int target, int candidate, List<Integer> previousCandidates, int startCandidateIndex) {
        previousCandidates.add(candidate);
        if (0 == target) {
            return Collections.singleton(previousCandidates);
        }
        if (target<0) {
            return Collections.emptyList();
        }
        List<List<Integer>> res = new ArrayList<>();
        int candidateIndex = startCandidateIndex;
        for (int i = candidateIndex; i < candidates.length; i++) {
            res.addAll(getResultWithCandidate(candidates, target-candidates[i], candidates[i], new ArrayList<>(previousCandidates), candidateIndex++));
        }
        return res;
    }
}