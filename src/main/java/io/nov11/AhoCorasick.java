package io.nov11;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AhoCorasick {
    private Node root;

    static class Node {
        boolean isRoot = false;
        Map<Character, Node> hash = new HashMap<>();
        Set<String> output = new HashSet<>();
        Node failNode;

        //if there's a connection, return the connected node
        //if not and this is the root node, return root node itself.
        //otherwise return null, which means 'fail'
        Node go(Character c) {
            Node node = hash.get(c);
            if (node != null) {
                return node;
            }
            if (isRoot) {
                return this;
            }
            return null;
        }
    }

    public AhoCorasick(List<String> needles) {
        this.root = buildTrieAndSetOutput(needles);
        buildFailNode(root);
    }

    private static Node buildTrieAndSetOutput(List<String> needles) {
        Node root = new Node();
        for (String s : needles) {
            addNode(root, s);
        }
        root.isRoot = true;
        //update root node's goto table
        return root;
    }

    private static void addNode(Node root, String s) {
        assert root != null;
        Node cur = root;
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            Map<Character, Node> map = cur.hash;
            if (map.containsKey(c)) {
                cur = map.get(c);
            } else {
                cur = new Node();
                map.put(c, cur);
            }
        }
        cur.output.add(s);
    }

    private static void buildFailNode(Node root) {
        assert root != null;

        //'failNode' value of nodes directly connected by root node all equal to 'root'
        root.hash.forEach((key, value) -> value.failNode = root);


        List<Node> bfs = new ArrayList<>(root.hash.values());
        while (!bfs.isEmpty()) {

            List<Node> next = new ArrayList<>();

            for (Node n : bfs) {
                Map<Character, Node> fanOut = n.hash;
                for (Map.Entry<Character, Node> entry : fanOut.entrySet()) {
                    Node to = entry.getValue();
                    Character c = entry.getKey();

                    Node f = n.failNode;
                    while (f.go(c) == null) {
                        f = f.failNode;
                    }
                    to.failNode = f.go(c);

                    to.output.addAll(to.failNode.output);

                    next.add(to);
                }
            }

            bfs = next;
        }
    }

    public Set<String> match(String target) {
        Set<String> result = new HashSet<>();
        Node cur = root;
        for (int i = 0; i < target.length(); i++) {
            Character c = target.charAt(i);
            Node next = cur.go(c);
            if (next == null) {
                Node f = cur.failNode;
                while (f.go(c) == null) {
                    f = f.failNode;
                }
                cur = f.go(c);
            } else {
                cur = next;
            }
            if (!cur.output.isEmpty()) {
                result.addAll(cur.output);
            }
        }

        return result;
    }
}
