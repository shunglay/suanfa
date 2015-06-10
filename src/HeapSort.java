import java.util.Arrays;


public class HeapSort {
	public static void main(String[] args) {
		int[] data = new int[] { 5, 6, 9, 1, 4, 2, 3 ,10 };
		System.out.println("����ǰ��"+Arrays.toString(data));
		heapSort(data);
		System.out.println("�����"+Arrays.toString(data));
	}

	public static void heapSort(int[] data) {
		// ѭ������
		for (int i = 0; i < data.length - 1; i++) {
			builMaxdHeap(data, data.length - 1 - i);
			// �����Ѷ������һ��Ԫ��
			swap(data, 0, data.length - 1 - i);
		}
	}

	// ��data�����0��lastIndex�������
	private static void builMaxdHeap(int[] data, int lastIndex) {
		// �����һ���ڵ�ĸ��ڵ㿪ʼ
		for (int i = (lastIndex - 1) / 2; i >= 0; i--) {
			// k���浱ǰ�����жϵĽڵ�
			int k = i;
			// �жϵ�ǰk�ڵ���ӽڵ��Ƿ���ڣ�����ʱ����λ�õ���
			while (k * 2 + 1 <= lastIndex) {
				// k�ڵ�����ӽڵ���±�
				int biggerIndex = 2 * k + 1;
				// if����������ʾk�ڵ�����ӽڵ���ڣ����ӽڵ�ΪbiggerIndex +1
				if (biggerIndex < lastIndex) {
					// ������ӽڵ��ֵ�ϴ�
					if (data[biggerIndex]<data[biggerIndex + 1]) {
						// biggerIndex���Ǽ�¼�ϴ��ӽڵ���±�
						biggerIndex++;
					}
				}
				// ���k�ڵ��ֵС����ϴ��ӽڵ��ֵ
				if (data[k]<data[biggerIndex]) {
					// ��������
					swap(data, k, biggerIndex);
					// ��biggerIndex����k����ʼwhileѭ������һ��ѭ��
					// ȷ��k�ڵ��ֵ���������ҽڵ��ֵ 
					k = biggerIndex;
				} else {
					break;
				}
			}
		}
	}
	
	// ����data������i��j�����±괦��Ԫ��
	private static void swap(int[] data, int i, int j) {
		int temp = data[i];
		data[i] = data[j];
		data[j] = temp;
	}
}
