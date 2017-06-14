package ru.buyanov.study.algo;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Alexander Buyanov
 * @created 6/14/17
 */
public class BalancedBrackets {
    public boolean solution(String s) {
        if (s == null || s.isEmpty()) {
            return true;
        }
        Deque<Character> queue = new LinkedList<>();
        for (char c : s.toCharArray()) {
            switch (c) {
                case '{':
                    queue.offer('}');
                    break;
                case '[':
                    queue.offer(']');
                    break;
                case '(':
                    queue.offer(')');
                    break;
                case '}':
                case ']':
                case ')':
                    Character prev = queue.pollLast();
                    if (prev == null || prev != c) {
                        return false;
                    }
            }

        }
        return queue.isEmpty();
    }
}
