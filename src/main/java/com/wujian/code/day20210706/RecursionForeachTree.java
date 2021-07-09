package com.wujian.code.day20210706;

import com.wujian.common.tree.Node;

import java.util.ArrayList;
import java.util.List;

public class RecursionForeachTree {

    public List<Integer> list = new ArrayList<Integer>();

    public List<Integer> pre(Node root){
        if(root == null){
            return list;
        }
        list.add(root.data);
        pre(root.left);
        pre(root.right);
        return list;
    }

    public List<Integer> in(Node root){
        if(root == null){
            return list;
        }
        in(root.left);
        list.add(root.data);
        in(root.right);
        return list;
    }

    public List<Integer> post(Node root){
        if(root == null){
            return list;
        }
        post(root.left);
        post(root.right);
        list.add(root.data);
        return list;
    }
}
