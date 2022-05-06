## 代码

```java
class MaxQueue {

    Queue<Integer> q;
    Deque<Integer> m;

    public MaxQueue() {
        q = new LinkedList<>();
        m = new LinkedList<>();
    }
    
    public int max_value() {
        if (q.isEmpty()) return -1;
        return m.peekFirst();
    }
    
    public void push_back(int value) {
        q.offer(value);
        while (!m.isEmpty() && value > m.peekLast()) m.pollLast();
        m.offerLast(value);
    }
    
    public int pop_front() {
        if (q.isEmpty()) return -1;
        int val = q.poll();
        if (m.peekFirst().equals(val)) m.pollFirst();
        return val;
    }
}

/**
 * Your MaxQueue object will be instantiated and called as such:
 * MaxQueue obj = new MaxQueue();
 * int param_1 = obj.max_value();
 * obj.push_back(value);
 * int param_3 = obj.pop_front();
 */
```

## 思路

单调队列。

## 参考

无。