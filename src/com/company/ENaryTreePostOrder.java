package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ENaryTreePostOrder {

    static class Node {
            int val;
            List<Node> children;

            Node(int x, List<Node> children) {
                val = x;
                children = children;
            }
        }

        List<Integer> postOrder(Node root) {
            Stack<Node> stack = new Stack<>();
            List<Integer> output = new ArrayList<>();

            if(root == null) {
                return output;
            }

            stack.add(root);
            while(!stack.isEmpty()) {
                Node node = stack.pop();
                output.add(0, node.val);
                for(Node child : node.children) {
                    stack.add(child);
                }
            }
            return output;
        }


}
