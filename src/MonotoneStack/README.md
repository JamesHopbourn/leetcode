#### 单调栈代码模版
```java
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int result[] = new int[nums.length];
        // 根据情况决定是否要填充
        Arrays.fill(result,-1);

        for (int i = 0; i < nums.length; i++){
            while (!stack.isEmpty() && nums[i] > nums[stack.peek()]){
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
        int result[] = new int[temperatures.length];
        for(int i = 0; i < temperatures.length; i++) {
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
        int result[] = new int[temperatures.length];
        for(int i = temperatures.length - 1; i >= 1; i--) {
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
        int result[] = new int[temperatures.length];
        Stack<Integer> stack=new Stack<>();
        for (int i = 0; i < temperatures.length; i++){
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]){
                result[stack.peek()] = i - stack.peek();
                stack.pop();
            }
            stack.push(i);
        }
        return result;
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
        int result[] = new int[nums.length];
        Arrays.fill(result,-1);
        Deque<Integer> stack = new LinkedList<>();
        int size = nums.length;
        for(int i = 0; i < size * 2; i++){
            while(!stack.isEmpty() && nums[stack.peek()] < nums[i%size]){
                result[stack.peek()] = nums[i%size];
                stack.pop();
            }
            stack.push(i%size);
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