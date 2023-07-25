package arrays;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that
    i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
    Notice that the solution set must not contain duplicate triplets.
*/

//  Example:
//  Input: nums = [-1,0,1,2,-1,-4]
//  Output: [[-1,-1,2],[-1,0,1]]
public class Sum3 {
    private List<List<Integer>> res;

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int l = i + 1, r = n - 1;
            while (l < r) {
                if (nums[l] + nums[r] == -nums[i]) {
                    List<Integer> t= new ArrayList<>();
                    t.add(nums[i]);
                    t.add(nums[l]);
                    t.add(nums[r]);
                    ans.add(t);
                    while((l + 1 < r) &&  nums[l + 1] == nums[l]) l++;
                    while((r - 1 > l) &&  nums[r - 1] == nums[r]) r--;
                    l++; r--;
                }
                else if(nums[l]+nums[r] < -nums[i]) l++;
                else r--;
            }
            while ((i + 1 < n) && nums[i + 1] == nums[i]) i++;
        }
        return ans;
    }

    public List<List<Integer>> _threeSum(int[] nums) {
        return new AbstractList<>() {
            public List<Integer> get(int index) {
                initialize();
                return res.get(index);
            }

            public int size() {
                initialize();
                return res.size();
            }

            private void initialize() {
                if (res != null) return;
                Arrays.sort(nums);
                res = new ArrayList<>();

                for (int i = 0; i < nums.length; i++) {
                    if (i != 0 && nums[i] == nums[i - 1])
                        continue;
                    int j = i + 1;
                    int k = nums.length - 1;

                    while (j < k) {
                        int sum = nums[i] + nums[j] + nums[k];
                        if (sum == 0) {
                            res.add(new Sum3.Triple(nums[i], nums[j], nums[k]));
                            j++;
                            k--;
                            while (j < k && nums[j] == nums[j - 1]) j++;
                            while (j < k && nums[k] == nums[k + 1]) k--;
                        } else if (sum < 0) {
                            j++;
                        } else {
                            k--;
                        }
                    }
                }
            }
        };
    }

    public static class Triple extends AbstractList<Integer> {
        private int[] data;

        public Triple(int i, int j, int k) {
            data = new int[]{i, j, k};
        }

        public Integer get(int index) {
            return data[index];
        }

        public int size() {
            return 3;
        }
    }
}
