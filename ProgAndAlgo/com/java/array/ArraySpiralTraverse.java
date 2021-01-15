package com.java.array;

import java.util.ArrayList;
import java.util.List;
/** Traverse a given 2 dimension array in spiral way as given in example
 * 
 *  "array": [
    [19, 32, 33, 34, 25, 8],
    [16, 15, 14, 13, 12, 11],
    [18, 31, 36, 35, 26, 9],
    [1, 2, 3, 4, 5, 6],
    [20, 21, 22, 23, 24, 7],
    [17, 30, 29, 28, 27, 10]
  ]
  
  output = [  19,  32,  33,  34,  25,  8,  11,  9,  6,  7,  10,  27,  28,  29,  30,  17,  20,  1,  18,  16,  15,  14,  13,  12,
  			26,  5,  24,  23,  22,  21,  2,  31,  36,  35,  4,  3]
 *
 */
public class ArraySpiralTraverse {
	public static List<Integer> spiralTraverse(int[][] array) {
		// Write your code here.
		List<Integer> spiral = new ArrayList<Integer>();
		int m = array.length;
		int n = array[0].length;
		int left = 0, up = 0, mstart = 0, nstart = 0;
		int elements = 0;
		int totalElements = m * n;
		int side = 1;
		if (totalElements == 1) {
			spiral.add(array[up][left]);
			return spiral;
		}
		while (elements < totalElements) {
			// System.out.println("Elements ="+ elements);
			if (side == 1) {
				if (left < n) {
					spiral.add(array[up][left]);
					// System.out.println("Side1 "+ array[up][left]+ " up= " +up + " left= "+left);
					left++;
					elements++;
				} else {
					side = 2;
					left--;
					up++;
					n--;
				}
			}

			if (side == 2) {
				if (up < m) {
					spiral.add(array[up][left]);
					// System.out.println("Side2 "+ array[up][left]+ " up= " +up + " left= "+left);
					up++;
					elements++;
				} else {
					side = 3;
					up--;
					left--;
					m--;
				}

			}

			if (side == 3) {
				if (left >= nstart) {
					spiral.add(array[up][left]);
					// System.out.println("Side3 "+ array[up][left]+ " up= " +up + " left= "+left);
					left--;
					elements++;
				} else {
					side = 4;
					nstart++;
					left++;
					up--;
				}

			}

			if (side == 4) {
				if (up > mstart) {
					spiral.add(array[up][left]);
					// System.out.println("Side4 "+ array[up][left]+ " up= " +up + " left= "+left);
					up--;
					elements++;
				} else {
					side = 1;
					up++;
					mstart++;
					left++;
				}

				// elements = elements == totalElements ? elements-1:elements;

			}

		}
		return spiral;
	}
}
