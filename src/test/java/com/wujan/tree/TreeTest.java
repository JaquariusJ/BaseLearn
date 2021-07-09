package com.wujan.tree;

import com.wujian.code.day20210706.RecursionForeachTree;
import com.wujian.code.day20210706.StackTree;
import com.wujian.common.tree.TreeUtils;
import org.junit.Test;
import sun.reflect.generics.tree.Tree;

public class TreeTest {

    @Test
    public void preTest(){
        //TreeUtils.checkPre(RecursionForeachTree.class);
        TreeUtils.checkPre(StackTree.class);
    }

    @Test
    public void inTest(){
        //TreeUtils.checkIn(RecursionForeachTree.class);
        TreeUtils.checkIn(StackTree.class);
    }

    @Test
    public void postTest(){
        //TreeUtils.checkPost(RecursionForeachTree.class);
        TreeUtils.checkPost(StackTree.class);
    }
}
