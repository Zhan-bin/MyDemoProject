package org.example.problem.history;

/**
 * 1. 如何得到这样的排列顺序？这是本文的重点。我们可以这样来分析：
 * 2. 我们希望下一个数 比当前数大，这样才满足 “下一个排列” 的定义。因此只需要 将后面的「大数」与前面的「小数」交换，就能得到一个更大的数。比如 123456，将 5 和 6 交换就能得到一个更大的数 123465。
 * 我们还希望下一个数 增加的幅度尽可能的小，这样才满足“下一个排列与当前排列紧邻“的要求。为了满足这个要求，我们需要：
 * a. 在尽可能靠右的低位 进行交换，需要从后向前查找
 * b. 将一个 尽可能小的「大数」 与前面的「小数」交换。比如 123465，下一个排列应该把 5 和 4 交换而不是把 6 和 4 交换
 * c. 将「大数」换到前面后，需要将「大数」后面的所有数 重置为升序，升序排列就是最小的排列。以 123465 为例：首先按照上一步，交换 5 和 4，得到 123564；然后需要将 5 之后的数重置为升序，得到 123546。显然 123546 比 123564 更小，123546 就是 123465 的下一个排列
 */
public class NextPermutation {
    /**
     * 1. 从后向前 查找第一个 相邻升序 的元素对 (i,j)，满足 A[i] < A[j]。此时 [j,end) 必然是降序
     * 2. 在[j,end)从后向前 查找第一个满足 A[i] < A[k] 的 k。A[i]、A[k] 分别就是上文所说的「小数」、「大数」
     * 3. 将 A[i] 与 A[k] 交换
     * 4. 可以断定这时 [j,end) 必然是降序，逆置 [j,end)，使其升序
     * 5. 如果在步骤 1 找不到符合的相邻元素对，说明当前 [begin,end) 为一个降序顺序，则直接跳到步骤 4
     */
    public void nextPermutation(int[] array) {
        if (array == null || array.length == 0) return;

        // 用于保存array[index]小于array[index+1]的元素下标
        int index = array.length - 2;

        // 从后往前找到第一个array[index]小于array[index+1]的元素
        while (index >= 0 && array[index + 1] <= array[index]) {
            index--;
        }

        // 如果能找到符合条件的index
        if (index >= 0) {
            int i = array.length - 1;
            // 从后面的逆序序列中的寻找大于array[index]的最小的元素
            while (i > index && array[i] <= array[index]) {
                i--;
            }
            swap(array, i, index);
        }

        // 反转后面的逆序序列
        reverse(index + 1, array);
    }

    /**
     * 翻转start下标之后的元素
     */
    public void reverse(int start, int[] array) {
        int i = start, j = array.length - 1;
        while (i < j) {
            swap(array, i, j);
            i++;
            j--;
        }
    }

    public void swap(int[] array, int i, int j) {
        if (i == -1 || j == -1) return;
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static void main(String[] args) {
        NextPermutation permutation = new NextPermutation();
        int[] arr = new int[]{5,4,3,2,1};
        permutation.nextPermutation(arr);
        for (int num : arr) System.out.println(num);
    }
}
