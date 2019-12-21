package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution1 {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        //把数据拷到一个二维集合
        List<List<Integer>> lists = copy(grid);
        //进行第一次移动，把最后一列移到第一行
        moveFirst(lists);
        //判断k的值来决定移动几次
        k = k - 1;
        k = k % (grid.length * grid[0].length);
        //进行k次移动
        move(lists, k);
        return lists;
    }

    //进行k此移动
    private void move(List<List<Integer>> lists, int k) {
        int h = k / lists.get(0).size();
        int l = k % lists.get(0).size();
        for (int i = 0; i < h; i++) {
            lists.add(0, lists.remove(lists.size() - 1));
        }
        ArrayList<Integer> tempList = new ArrayList<>();
        for (int i = 0; i < lists.size(); i++) {
            for (int j = 0; j < l; j++) {
                if ((i + 1) < lists.size()) {
                    lists.get(i + 1).add(0, lists.get(i).remove(lists.get(i).size() - 1));
                } else {
                    lists.get(0).add(0, lists.get(i).remove(lists.get(i).size() - 1));
                }
            }
        }
    }

    //第一次移动
    private void moveFirst(List<List<Integer>> lists) {
        for (int i = 0; i < lists.size(); i++) {
            if ((i + 1) < lists.size()) {
                lists.get(i + 1).add(0, lists.get(i).remove(lists.get(i).size() - 1));
            } else {
                lists.get(0).add(0, lists.get(i).remove(lists.get(i).size() - 1));
            }
        }
    }

    //存元素
    private List<List<Integer>> copy(int[][] grid) {
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int j = 0; j < grid[i].length; j++) {
                list.add(grid[i][j]);
            }
            lists.add(list);
        }
        return lists;
    }
}
