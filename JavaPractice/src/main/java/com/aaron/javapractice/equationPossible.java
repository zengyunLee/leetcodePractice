package com.aaron.javapractice;

public class equationPossible {
    public static void main(String[] args) {
        String[] sourceArr = new String[] {"a==c", "b==d", "x!=z","a==b","b!=a"};
        boolean res = isEquationPossible(sourceArr);
        System.out.println(res);
    }

    private static boolean isEquationPossible(String[] equations) {
        int[] eq = new int[26];
        for (int i = 0; i < 26; i++) {
            eq[i] = i;
        }
        for (String str : equations) {
            if (str.charAt(1) == '=') {
                int index1 = str.charAt(0) - 'a';
                int index2 = str.charAt(3) - 'a';
                union(eq, index1, index2);
            }
        }
        for (String str : equations) {
            if(str.charAt(1) == '!') {
                int index1 = str.charAt(0) - 'a';
                int index2 = str.charAt(3) - 'a';
                if(find(eq,index1) == find(eq,index2)) {
                    return false;
                }
            }
        }
        return true;
    }


    public static void union(int[] parent, int index1, int index2) {
        parent[find(parent, index1)] = find(parent, index2);
    }

    public static int find(int[] parent, int index) {
        while (parent[index] != index) {
            parent[index] = parent[parent[index]];
            index = parent[index];
        }
        return index;
    }
}
