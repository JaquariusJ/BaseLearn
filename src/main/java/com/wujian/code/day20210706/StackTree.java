package com.wujian.code.day20210706;

import com.wujian.common.tree.Node;

import java.util.*;

public class StackTree {

    public List<Integer> list = new ArrayList<Integer>();

    public List<Integer> pre(Node root){
        if(root == null){
            return null;
        }
        Stack<Node> stack = new Stack<Node>();
        stack.push(root);
        while(!stack.empty()){
            Node popNode = stack.pop();
            list.add(popNode.data);
            if(popNode.right != null){
                stack.push(popNode.right);
            }
            if(popNode.left != null){
                stack.push(popNode.left);
            }
        }
        return list;
    }


    public List<Integer> in(Node root){
        if(root == null){
            return null;
        }
        Stack<Node> stack = new Stack<Node>();
        while(!stack.empty() || root!= null){
            if(root != null){
                stack.push(root);
                root = root.left;
            }else{
                root = stack.pop();
                list.add(root.data);
                root = root.right;
            }
        }
        return list;
    }

    public List<Integer> post(Node root){
        if(root == null){
            return null;
        }
        Stack<Node> s1 = new Stack<Node>();
        Stack<Node> s2 = new Stack<Node>();
        s1.push(root);
        while(!s1.empty()){
            Node popNode = s1.pop();
            s2.push(popNode);
            if(popNode.left != null){
                s1.push(popNode.left);
            }
            if(popNode.right != null){
                s1.push(popNode.right);
            }
        }
        while(!s2.empty()){
            list.add(s2.pop().data);
        }
        return list;
    }



    public static void level(Node head){
        if(head == null){
            return;
        }

        Queue<Node> queue = new LinkedList<Node>();
        queue.add(head);
        while(!queue.isEmpty()){
            Node pollNode = queue.poll();
            System.out.println(pollNode.data);
            if(pollNode.left != null){
                queue.add(pollNode.left);
            }
            if(pollNode.right != null){
                queue.add(pollNode.right);
            }
        }
    }





    public static Integer findMaxWidthByMap(Node head){
        if(head == null){
            return 0;
        }
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(head);
        Map<Node,Integer> levelMap = new HashMap<Node, Integer>();
        levelMap.put(head,1);
        int curLevel = 1;
        int curLevelNodes = 0;
        int max = 0;
        while(!queue.isEmpty()){
            Node popNode = queue.poll();
            //弹出节点所在的层数
            Integer cur = levelMap.get(popNode);
            if(popNode.left != null){
                queue.add(popNode.left);
                levelMap.put(popNode.left,cur+1);
            }
            if(popNode.right != null){
                queue.add(popNode.right);
                levelMap.put(popNode.right,cur+1);
            }

            //判断弹出的节点的层数是不是正在统计的层数
            if(cur == curLevel){
                curLevelNodes++;
            }else{
                //结算统计层
                max = Math.max(max,curLevelNodes);
                curLevel++;
                curLevelNodes=1;
            }
            //处理最后一层
            max = Math.max(max,curLevelNodes);


        }
        return max;

    }


    public static Integer findMaxWidthByVariable(Node head){
        if(head == null){
            return 0;
        }

        Queue<Node> queue = new LinkedList<Node>();
        Node curEnd = head;
        Node nextEnd = null;
        int curLevelNodes = 0;
        int max = 0;
        queue.add(head);
        while(!queue.isEmpty()){
            Node popNode = queue.poll();
            if(popNode.left != null){
                queue.add(popNode.left);
                nextEnd = popNode.left;
            }
            if(popNode.right != null){
                queue.add(popNode.right);
                nextEnd = popNode.right;
            }
            curLevelNodes++;
            //弹出的当前节点是否是最后一个节点
            if(popNode == curEnd){
                max = Math.max(max,curLevelNodes);
                curLevelNodes = 0;
                curEnd = nextEnd;
            }

        }
        return max;
    }

    //序列化
    public static Queue<Node> serialize(Node head){
        Queue<Node> queue = new LinkedList<Node>();
        serializeByPre(head,queue);
        return queue;


    }

    public static void serializeByPre(Node head,Queue<Node> queue){
        if(head == null){
            queue.add(null);
        }else{
            queue.add(head);
            serializeByPre(head.left,queue);
            serializeByPre(head.right,queue);
        }

    }

    //反序列化
    public static Node unserialize(Queue<Node> queue){
        if(queue == null || queue.size() == 0){
            return null;
        }
        return unserializeByPre(queue);
    }

    public static Node unserializeByPre(Queue<Node> queue){
        Node node = queue.poll();
        if(node == null){
            return null;
        }
        node.left = unserializeByPre(queue);
        node.right = unserializeByPre(queue);
        return node;

    }

    public static void main(String[] args) {
        Node root = new Node(1);
//        root.left = new Node(2);
//        root.right = new Node(3);
//        root.left.left = new Node(4);
//        root.left.right = new Node(5);
//        root.right.left = new Node(6);
//        root.right.right = new Node(7);
//        root.right.left.left = new Node(8);
//
//        Integer maxWidth = findMaxWidthByVariable(root);
//        System.out.println(maxWidth);
        root.right = new Node(1);
        root.right.left = new Node(1);
        Queue<Node> queue = serialize(root);
//        while(!queue.isEmpty()){
//            System.out.println(queue.poll());
//        }
        Node newroot = unserialize(queue);
        System.out.println("---------------");
        System.out.println(newroot.right.left);

    }


    public static Queue<Node> levelSerial(Node head){
        Queue<Node> q1 = new LinkedList<Node>();
        if(head ==null){
            q1.add(null);
        }else{
            q1.add(head);
            Queue<Node> q2 = new LinkedList<Node>();
            q2.add(head);
            while(!q2.isEmpty()){
                head = q2.poll();
                if(head.left != null){
                    q1.add(head.left);
                    q2.add(head.left);
                }else{
                    q1.add(head.left);
                }
                if(head.right != null){
                    q1.add(head.right);
                    q2.add(head.right);
                }else{
                    q1.add(head.right);
                }

            }
        }
        return q1;
    }

    public static Node unLevelSerialize(Queue<Node> levellist){
        if(levellist == null || levellist.size()==0){
            return null;
        }
        Node head = levellist.poll();
        Queue<Node> queue = new LinkedList<Node>();
        if(head != null){
            queue.add(head);
        }
        Node node = null;
        while(!queue.isEmpty()){
            node = queue.poll();
            node.left = levellist.poll();
            node.right = levellist.poll();
            if(node.left != null){
                queue.add(node.left);
            }
            if(node.right != null){
                queue.add(node.right);
            }
        }
        return head;
    }



}
