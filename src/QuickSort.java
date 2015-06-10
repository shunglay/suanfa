import java.util.Arrays;

public class QuickSort {

	public static void main(String[] args) {
		int[] data = new int[] { 5, 6, 9, 1, 4, 2, 3 };
		System.out.println("����ǰ��" + Arrays.toString(data));
		quickSort(data);
		System.out.println("�����" + Arrays.toString(data));
	}

	private static void swap(int[] data, int i, int j) {
		int temp = data[i];
		data[i] = data[j];
		data[j] = temp;
	}

	static int partition(int[] data, int low, int high) {
		int key = low;  //֧��������±�
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
		if (low < high) { //�������ȴ���1
			int key = partition(data, low, high); //��ȡ֧��������±�
			subSort(data, low, key - 1); //�����ӱ���еݹ�����
			subSort(data, key + 1, high); //�����ӱ���еݹ�����
		}
	}

	public static void quickSort(int[] data) {
		subSort(data, 0, data.length - 1);
	}

}
