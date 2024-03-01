#### 单调栈代码模版

```java
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] result = new int[nums.length];
        // 根据情况决定是否要填充以及填充什么数字
        Arrays.fill(result, -1);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                // 具体代码逻辑......
            }
            stack.push(i);
        }
        return result;
    }
}
```

#### 739 每日温度
##### 正序暴力穷举

```java
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            for (int j = i + 1; j < temperatures.length; j++) {
                if (temperatures[j] > temperatures[i]) {
                    result[i] = j - i;
                    break;
                }
            }
        }
        return result;
    }
}
```

##### 倒序暴力穷举

```java
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        for (int i = temperatures.length - 1; i >= 1; i--) {
            for (int j = i - 1; j >= 0; j--) {
                if (temperatures[i] > temperatures[j]) {
                    result[j] = i - j;
                } else {
                    break;
                }
            }
        }
        return result;
    }
}
```

##### 引入单调栈

```java
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                result[stack.peek()] = i - stack.peek();
                stack.pop();
            }
            stack.push(i);
        }
        return result;
    }
}
```
#### 四个模版
##### 右边下一个更大的元素
```java
import java.util.Arrays;
import java.util.Stack;

public class nextGreaterElement {
    public static void main(String[] args) {
        int[] nums = new int[]{6, 7, 4, 5, 2, 8};
        int[] result = new int[nums.length];
        Arrays.fill(result, -1);

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            // > 下一个比他更大的元素 [7, 8, 5, 8, 8, -1]
            while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                result[stack.peek()] = nums[i];
                stack.pop();
            }
            stack.push(i);
        }
        System.out.println(Arrays.toString(result));
    }
}
```

##### 右边下一个更小的元素
```java
import java.util.Arrays;
import java.util.Stack;

public class nextSmallerElement {
    public static void main(String[] args) {
        int[] nums = new int[]{6, 7, 4, 5, 2, 8};
        int[] result = new int[nums.length];
        Arrays.fill(result, -1);

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            // < 下一个比他更小的元素 [4, 4, 2, 2, -1, -1]
            while (!stack.isEmpty() && nums[i] < nums[stack.peek()]) {
                result[stack.peek()] = nums[i];
                stack.pop();
            }
            stack.push(i);
        }
        System.out.println(Arrays.toString(result));
    }
}
```

##### 左边下一个更小的元素索引
```java
import java.util.Arrays;
import java.util.Stack;

public class prevSmallerElement {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6};
        int[] result = new int[nums.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < nums.length; i++) {
            // > 下一个比他更小的元素 [-1, 0, 1, 2, 3, 4]
            while (!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
                stack.pop();
            }
            result[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        System.out.println(Arrays.toString(result));
    }
}
```

##### 左边下一个更大的元素索引
```java
import java.util.Arrays;
import java.util.Stack;

public class prevGreaterElement {
    public static void main(String[] args) {
        int[] nums = new int[]{6, 5, 4, 3, 2, 1};
        int[] result = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        // < 下一个比他更大的元素 [-1, 0, 1, 2, 3, 4]
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                result[i] = stack.pop();
            }
            result[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        System.out.println(Arrays.toString(result));
    }
}
```

---

#### 496 下一个更大元素 I
```java
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++){
            map.put(nums1[i], i);
        }

        int[] res = new int[nums1.length];
        Arrays.fill(res, -1);
        
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums2.length; i++){
            while (!stack.isEmpty() && nums2[stack.peek()] < nums2[i]){
                int pre = nums2[stack.pop()];
                if (map.containsKey(pre)){
                    res[map.get(pre)] = nums2[i];
                }
            }
            stack.push(i);
        }
        return res;
    }
}
```

#### 503 下一个更大元素 II

```java
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] result = new int[nums.length];
        Arrays.fill(result, -1);
        Deque<Integer> stack = new LinkedList<>();
        int size = nums.length;
        for (int i = 0; i < size * 2; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i % size]) {
                result[stack.peek()] = nums[i % size];
                stack.pop();
            }
            stack.push(i % size);
        }
        return result;
    }
}
```

#### 42 接雨水
```java
class Solution {
    public int trap(int[] height) {
        LinkedList<Integer> stack = new LinkedList<>();
        int sum = 0;
        for (int i = 0; i < height.length; i++) {
            while(!stack.isEmpty() && height[i] > height[stack.peek()]){
                int mid = stack.pop();
                if (!stack.isEmpty()){
                    int heightDiff = Math.min(height[i], height[stack.peek()]) - height[mid];
                    int width = i - stack.peek() - 1;
                    sum += heightDiff * width;
                }
            }
            stack.push(i);
        }
        return sum;
    }
}
```

#### 84 柱状图中最大的矩形
```java
class Solution {
    public int largestRectangleArea(int[] heights) {
        int[] nums = new int[heights.length + 2];
        Arrays.fill(nums, 0);
        for (int i = 0; i < heights.length; i++){
            nums[i+1] = heights[i];
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int result = 0;
        for (int i = 1; i < nums.length; i++){
            while (!stack.isEmpty() && nums[i] < nums[stack.peek()]){
                int height = nums[stack.pop()];
                int width = i - stack.peek() - 1;
                result = Math.max(result, height * width);
            }
            stack.push(i);
        }
        return result;
    }
}
```

#### 参考资料
- [高频算法面试题：每日温度（力扣 739）](https://www.bilibili.com/video/BV1sN4y1a7yz/)  