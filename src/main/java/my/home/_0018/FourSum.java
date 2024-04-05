package my.home._0018;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {

    public static void main(String[] args) {
        int[] nums = new int[]{1000000000, 1000000000, 1000000000, 1000000000};
        int target = -294967296;
        System.out.println(fourSum(nums, target));
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int length = nums.length;
        Arrays.sort(nums);
        int _1Index = 0;
        int _2Index = _1Index + 1;
        int _3Index = _2Index + 1;
        int _4Index = _3Index + 1;
        while (_4Index < length) {
            if (_1Index != 0 && nums[_1Index - 1] == nums[_1Index]) {
                _1Index++;
                _2Index = _1Index + 1;
                _3Index = _2Index + 1;
                _4Index = _3Index + 1;
                continue;
            }
            if ((long) nums[_1Index] + nums[_2Index] + nums[_3Index] + nums[_4Index] == target) {
                res.add(Arrays.asList(nums[_1Index], nums[_2Index], nums[_3Index], nums[_4Index]));
            }
            _4Index++;

            if (_4Index >= length) {
                _3Index++;
                _4Index = _3Index + 1;
                if (_4Index >= length) {
                    _2Index++;
                    _3Index = _2Index + 1;
                    _4Index = _3Index + 1;
                    if (_4Index >= length) {
                        _1Index++;
                        _2Index = _1Index + 1;
                        _3Index = _2Index + 1;
                        _4Index = _3Index + 1;
                    }
                }
            }
        }
        return res.stream().distinct().toList();
    }
}