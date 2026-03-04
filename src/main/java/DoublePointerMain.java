import java.util.*;

/**
 * 双指针算法题
 *
 * @author hu.wang
 * @date 2026-03-03
 */
public class DoublePointerMain {

    public void sortColors(int[] nums) {
        int low = 0;
        int i = 0;
        int high = nums.length - 1;
        while (i <= high) {
            if (nums[i] == 0) {
                int temp = nums[low];
                nums[low++] = nums[i];
                nums[i++] = temp;
            } else if (nums[i] == 1) {
                i++;
            } else {
                int temp = nums[high];
                nums[high--] = nums[i];
                nums[i] = temp;
            }
        }
    }

    public String reverseStr(String s, int k) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        for (int i = 0; i < n; i += 2 * k) {
            int l = i, r = Math.min(i + k - 1, n - 1);
            while (l < r) {
                char temp = arr[l];
                arr[l++] = arr[r];
                arr[r--] = temp;
            }
        }
        return new String(arr);
    }

    public void reverseString(char[] s) {
        int l = 0, r = s.length - 1;
        while (l < r) {
            char temp = s[l];
            s[l++] = s[r];
            s[r--] = temp;
        }
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Integer> res = new ArrayList<>();
        for (int num : nums2) {
            if (map.containsKey(num) && map.get(num) > 0) {
                res.add(num);
                map.put(num, map.get(num) - 1);
            }
        }
        return res.stream().mapToInt(x -> x).toArray();
    }

    public int[] intersect2(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i1 = 0, i2 = 0;
        List<Integer> arr = new ArrayList<>();
        while (i1 < nums1.length && i2 < nums2.length) {
            if (nums1[i1] < nums2[i2]) {
                i1++;
            } else if (nums1[i1] > nums2[i2]) {
                i2++;
            } else {
                arr.add(nums1[i1]);
                i1++;
                i2++;
            }
        }
        return arr.stream().mapToInt(x -> x).toArray();
    }

    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return intersection(nums2, nums1);
        }
        Set<Integer> set = new HashSet<>(nums1.length);
        for (int num : nums1) {
            set.add(num);
        }
        Set<Integer> res = new HashSet<>();
        for (int num : nums2) {
            if (set.contains(num)) {
                res.add(num);
            }
        }
        return res.stream().mapToInt(x -> x).toArray();
    }

    public int[] intersection2(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i1 = 0, i2 = 0;
        Set<Integer> set = new HashSet<>();
        while (i1 < nums1.length && i2 < nums2.length) {
            if (nums1[i1] < nums2[i2]) {
                i1++;
            } else if (nums1[i1] > nums2[i2]) {
                i2++;
            } else {
                set.add(nums1[i1]);
                i1++;
                i2++;
            }
        }
        return set.stream().mapToInt(x -> x).toArray();
    }

    public String compressString(String S) {
        if (null == S || S.length() <= 1) {
            return S;
        }
        int count = 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < S.length(); i++) {
            if (S.charAt(i) == S.charAt(i - 1)) {
                count++;
            } else {
                sb.append(S.charAt(i - 1)).append(count);
                count = 1;
            }
        }
        if (sb.length() <= S.length()) {
            sb.append(S.charAt(S.length() - 1)).append(count);
            return sb.toString();
        } else {
            return S;
        }
    }

}
