package BubleSort;

public class Main {

	public static void main(String[] args) {
		int[] a = { 2, 0, 1, 6, 8, 4, 7 };

		BubbleSort.print(a);
		System.out.println();

		BubbleSort bubble = new BubbleSort();

		int[] b = bubble.bubbleSort(a, "desc");
		System.out.print("내림차순 : ");
		BubbleSort.print(b);

		b = bubble.bubbleSort(a, "asc");
		System.out.print("오름차순 : ");
		BubbleSort.print(b);
	}
}
