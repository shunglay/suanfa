import java.util.Arrays;

public class QuickSort {

	public static void main(String[] args) {
		int[] data = new int[] { 5, 6, 9, 1, 4, 2, 3 };
		System.out.println("排序前：" + Arrays.toString(data));
		quickSort(data);
		System.out.println("排序后：" + Arrays.toString(data));
	}

	private static void swap(int[] data, int i, int j) {
		int temp = data[i];
		data[i] = data[j];
		data[j] = temp;
	}

	static int partition(int[] data, int low, int high) {
		int key = low;  //支点的数组下标
		while (low < high) {
			while (low < high && data[high] >= data[key]) {
				--high;
			}
			swap(data, key, high);
			key = high;
			while (low < high && data[low] <= data[key]) {
				++low;
			}
			swap(data, key, low);
			key = low;
		}
		return key;
	}

	private static void subSort(int[] data, int low, int high) {
		if (low < high) { //表明长度大于1
			int key = partition(data, low, high); //获取支点的数组下标
			subSort(data, low, key - 1); //对左子表进行递归排序
			subSort(data, key + 1, high); //对右子表进行递归排序
		}
	}

	public static void quickSort(int[] data) {
		subSort(data, 0, data.length - 1);
	}

}
