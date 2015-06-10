import java.util.Arrays;


public class HeapSort {
	public static void main(String[] args) {
		int[] data = new int[] { 5, 6, 9, 1, 4, 2, 3 ,10 };
		System.out.println("排序前："+Arrays.toString(data));
		heapSort(data);
		System.out.println("排序后："+Arrays.toString(data));
	}

	public static void heapSort(int[] data) {
		// 循环建堆
		for (int i = 0; i < data.length - 1; i++) {
			builMaxdHeap(data, data.length - 1 - i);
			// 交换堆顶和最后一个元素
			swap(data, 0, data.length - 1 - i);
		}
	}

	// 对data数组从0到lastIndex建大根堆
	private static void builMaxdHeap(int[] data, int lastIndex) {
		// 从最后一个节点的父节点开始
		for (int i = (lastIndex - 1) / 2; i >= 0; i--) {
			// k保存当前正在判断的节点
			int k = i;
			// 判断当前k节点的子节点是否存在，存在时进行位置调整
			while (k * 2 + 1 <= lastIndex) {
				// k节点的左子节点的下标
				int biggerIndex = 2 * k + 1;
				// if条件成立表示k节点的右子节点存在，右子节点为biggerIndex +1
				if (biggerIndex < lastIndex) {
					// 如果右子节点的值较大
					if (data[biggerIndex]<data[biggerIndex + 1]) {
						// biggerIndex总是记录较大子节点的下标
						biggerIndex++;
					}
				}
				// 如果k节点的值小于其较大子节点的值
				if (data[k]<data[biggerIndex]) {
					// 交换它们
					swap(data, k, biggerIndex);
					// 将biggerIndex赋给k，开始while循环的下一次循环
					// 确保k节点的值大于其左、右节点的值 
					k = biggerIndex;
				} else {
					break;
				}
			}
		}
	}
	
	// 交换data数组中i、j两个下标处的元素
	private static void swap(int[] data, int i, int j) {
		int temp = data[i];
		data[i] = data[j];
		data[j] = temp;
	}
}
