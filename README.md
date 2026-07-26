# CodePractice

A growing collection of coding problems and exercises practised for technical interviews, covering data structures, algorithms, and Java fundamentals.

---

## Repository Structure

```
CodePractice/
├── ProgAndAlgo/      – Algorithm & problem-solving exercises (AlgoExpert-style)
│   ├── com/java/array/
│   ├── com/java/linkedlist/
│   ├── com/java/recursion/
│   ├── com/java/sorting/
│   ├── com/java/string/
│   └── com/java/tree/
├── DataStructures/   – Data structure implementations and classic DS problems
│   ├── com/java/collection/
│   ├── com/java/graph1/
│   ├── com/java/linkedlist/
│   ├── com/java/sorting/methods/
│   ├── com/java/string/problems/
│   ├── com/java/tree/problems/
│   └── com/java/tryyourself/
└── JavaBasices/      – Java language basics (generics, lambdas, streams, etc.)
    └── src/
```

---

## Problems Index

### ProgAndAlgo

#### Arrays

| File | Problem | Description |
|------|---------|-------------|
| `ArrayOfProduct.java` | Array of Products | Return an array where each element is the product of all other elements. Two solutions: O(n²) brute-force and O(n) left-right pass. |
| `ArraySpiralTraverse.java` | Spiral Traverse | Traverse a 2-D matrix in spiral (clockwise) order and return the element sequence. |
| `Find3LargestNumberInArray.java` | Find 3 Largest Numbers | Find the three largest numbers in an array without sorting; return them in ascending order. |
| `FindTargetSumFor2Element.java` | Two Number Sum | Find two elements in an array whose sum equals a given target. |
| `FirstDuplicateValue.java` | First Duplicate Value | Find the first value that appears twice, scanning left-to-right. Returns -1 if no duplicate exists. |
| `Merge3SortedArray.java` | Merge 3 Sorted Arrays | Merge three sorted integer arrays into a single sorted array in O(n) time. |
| `MinDiffBitween2ArrayElements.java` | Smallest Difference | Find the pair of numbers (one from each of two arrays) with the smallest absolute difference. Efficient O(n log n) solution sorts both arrays first. |
| `MinimumWaitingTime.java` | Minimum Waiting Time | Given query durations, find the minimum total waiting time by executing the shortest queries first. |
| `MinSum.java` | Minimize Array Sum | Perform k operations where each operation halves (ceiling) the largest element. Minimize the final sum using a max-heap. |
| `MoveElementAtEnd.java` | Move Element to End | Move all occurrences of a given value to the end of the array in-place using two pointers. |
| `PrintArrayDiagonally.java` | Print Array Diagonally | Print elements of a square 2-D matrix along its diagonals. |
| `PrintArrayElementsSpiral.java` | Print Array Row-Alternating | Print a 2-D matrix row by row, alternating left-to-right and right-to-left (boustrophedon). |
| `PrintArrayElementsZigZag.java` | Zigzag Traverse | Traverse a 2-D matrix in a diagonal zigzag pattern. |
| `ValidateSequence.java` | Validate Subsequence | Check whether a second array is a subsequence of the first array. |

#### Linked Lists

| File | Problem | Description |
|------|---------|-------------|
| `LinkedListPalindrome.java` | Linked List Palindrome | Determine whether a singly linked list of integers is a palindrome. |
| `RemoveKthNodeInLinkedList.java` | Remove Kth Node from End | Remove the Kth node from the end of a linked list using a two-pointer sliding window. |
| `ReverseLinkedList.java` | Reverse Linked List | Reverse a singly linked list in-place and return the new head. |

#### Recursion

| File | Problem | Description |
|------|---------|-------------|
| `NthFibonacci.java` | Nth Fibonacci | Return the Nth Fibonacci number using pure recursion (0-indexed). |
| `PowXToN.java` | Power(x, n) | Compute x raised to the power n using recursive fast exponentiation (O(log n)). |
| `ProductSumInList.java` | Product Sum | Compute the sum of a nested list where each sub-list at depth d is multiplied by d+1. |

#### Sorting

| File | Problem | Description |
|------|---------|-------------|
| `BubbleSort.java` | Bubble Sort | Sort an array by repeatedly swapping adjacent out-of-order elements. O(n²) with an early-exit optimisation. |
| `InsertionSort.java` | Insertion Sort | Sort an array by inserting each element into its correct position in the already-sorted left portion. O(n²). |
| `SelectionSort.java` | Selection Sort | Sort an array by repeatedly selecting the minimum of the unsorted portion and placing it at the front. O(n²). |

#### Strings

| File | Problem | Description |
|------|---------|-------------|
| `CaesarCypherEncryptor.java` | Caesar Cipher Encryptor | Shift each character of a string by a given key, wrapping around the alphabet. |
| `PalindromeCheck.java` | Palindrome Check | Check whether a string is a palindrome using a two-pointer approach. O(n) time, O(1) space. |
| `PhoneMnemonics.java` | Phone Mnemonics | Generate all possible letter combinations for a given phone number string (like T9 keyboard). |
| `StringPermutations.java` | String Permutations | Generate all unique permutations of the characters in a string using recursive backtracking. |

#### Trees

| File | Problem | Description |
|------|---------|-------------|
| `BranchSumInBST.java` | Branch Sums | Return a list of the sums of all root-to-leaf paths in a binary tree. |
| `CountGoodNodesInBT.java` | Count Good Nodes | Count nodes where no ancestor has a greater value than the node itself (LeetCode 1448). |
| `DepthFirstSearchTree.java` | Depth First Search | Print all node names of an N-ary tree using iterative DFS with a stack. |
| `FinClosestValueInBST.java` | Find Closest Value in BST | Find the node value in a BST that is closest to a given target integer. |
| `InvertBinaryTree.java` | Invert Binary Tree | Mirror a binary tree by recursively swapping left and right children (LeetCode 226). |
| `SumOfTreeNodeDefth.java` | Sum of Node Depths | Return the sum of depths of all nodes in a binary tree (AlgoExpert). |
| `ValidateBST.java` | Validate BST | Determine whether a binary tree is a valid BST using min/max bound propagation (LeetCode 98). |

---

### DataStructures

#### Collections

| File | Problem | Description |
|------|---------|-------------|
| `CustomHashMap.java` | Custom HashMap | Generic HashMap implementation using separate chaining (linked-list buckets) with `put`, `get`, and `remove` operations. |

#### Graph

| File | Problem | Description |
|------|---------|-------------|
| `Graph.java` | Graph BFS & DFS | Adjacency-matrix graph that supports Breadth-First Search and Depth-First Search traversals. |
| `GraphMain.java` | Graph Demo | Driver that constructs a sample graph and runs both BFS and DFS. |

#### Linked Lists

| File | Problem | Description |
|------|---------|-------------|
| `BuildLinkedList.java` | Build Linked List | Utility to construct a singly linked list from an integer array. |
| `LinkedListProblems.java` | Reverse & Print | Reverse and print a linked list using both recursive and stack-based approaches. |
| `RemovingDuplicatesFromLinkedLlist.java` | Remove Duplicates | Remove consecutive duplicate values from a sorted linked list. |

#### Sorting

| File | Problem | Description |
|------|---------|-------------|
| `QuickSort.java` | Quick Sort | In-place Quick Sort using a last-element pivot and Lomuto partition scheme. |

#### Strings

| File | Problem | Description |
|------|---------|-------------|
| `IsUniqueCharInString.java` | Is Unique Characters | Check whether all characters in a string are unique using an ASCII boolean array. O(n) time, O(1) space. |
| `MaxPalindrome.java` | Maximum Palindrome Length | Find the length of the longest palindromic substring using brute-force comparison. O(n³). |
| `MaxSumInArray.java` | Maximum Subarray Sum | Find the maximum sum of a contiguous subarray (Kadane's algorithm). O(n). |
| `RemoveDuplicte.java` | Remove Duplicate Characters | Remove duplicate characters from a string in O(n) time, preserving order of first occurrence. |
| `ReverserWords.java` | Reverse Words in String | Reverse the order of words in a string while preserving spaces. |

#### Trees

| File | Problem | Description |
|------|---------|-------------|
| `BalancedBST.java` | Check Balanced BST | Verify that a BST is balanced by comparing max depth and min depth (difference ≤ 1). |
| `BinaryTreeProblems.java` | Validate BST (basic) | Check the BST property (left < parent < right) using a recursive pre-order traversal. |
| `BSTfromInOrderAndPostOrder.java` | BST from Inorder & Postorder | Reconstruct a binary tree from its inorder and postorder traversal sequences. |
| `BSTKthMin.java` | Kth Minimum in BST | Find the Kth smallest element in a BST using both recursive inorder traversal and an iterative stack. |
| `BSTMaxHeight.java` | BST Maximum Height | Compute the maximum height (longest root-to-leaf path) of a BST recursively. |
| `InorderTraversal.java` | Inorder Traversal | Perform inorder (left → root → right) traversal of a BST. |
| `LowestCommonAncestor.java` | Lowest Common Ancestor | Find the LCA of two nodes in a BST and compute their depth difference from the ancestor. |
| `PreorderTraversal.java` | Preorder Traversal | Perform preorder (root → left → right) traversal of a BST. |

#### Try Yourself

| File | Problem | Description |
|------|---------|-------------|
| `FindRepeatedSubstring.java` | Find Repeated Substring | Check whether a string can be expressed as a substring repeated ≥ 2 times. Also includes bracket-validation with a stack. |
| `Java8Sroting.java` | Java 8 Sorting & Grouping | Demonstrates Java 8 streams: `filter`, `groupingBy`, custom `Comparator`, and hierarchical parent-child sorting of customers by membership level. |

---

### JavaBasics

| File | Topic |
|------|-------|
| `ForLoopProgram.java` | Loop constructs |
| `Generics.java` | Java Generics |
| `LambdaAndStream.java` | Lambda expressions and Stream API |
| `Page.java` | POJO / model class example |
| `Parantehsis.java` | Bracket / parenthesis matching |
| `Solution.java` / `Solution1.java` / `Solution2.java` | Miscellaneous problem solutions |
| `TryYourself.java` | Scratch pad for experiments |
| `Winner.java` | Voting / winner determination |

---

## How to Run

Each class is a standalone Java program. To compile and run a specific file (e.g., `MinimumWaitingTime`):

```bash
# From the ProgAndAlgo directory
javac com/java/array/MinimumWaitingTime.java
java com.java.array.MinimumWaitingTime
```

No external dependencies are required — all solutions use the Java Standard Library only.

