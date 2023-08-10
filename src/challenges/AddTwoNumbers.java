package challenges;

import models.ListNode;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class AddTwoNumbers {

    /*
        You are given two non-empty linked lists representing two non-negative integers.
        The digits are stored in reverse order, and each of their nodes contains a single digit.
        Add the two numbers and return the sum as a linked list.
        You may assume the two numbers do not contain any leading zero, except the number 0 itself.
        Example:
        Input: l1 = [2,4,3], l2 = [5,6,4]
        Output: [7,0,8]
        Explanation: 342 + 465 = 807.
    */
    public ListNode addTwoNumbersLessThanBigIntegerMaxValue(ListNode l1, ListNode l2) {

        // Declare a list that will contain the two numbers
        List<Integer> numbers = new ArrayList<>();
        // Declare a list for looping through the list of nodes
        List<ListNode> lists = List.of(l1, l2);

        // Loop through each element of the list
        lists.forEach(listNode -> {
            // Add each node to a stack, so we can retrieve the ordered digits
            Stack<ListNode> numbersBox = new Stack();
            ListNode currentNode = listNode;
            while (currentNode != null) {
                numbersBox.push(currentNode);
                currentNode = currentNode.next;
            }

            // Retrieve from the ordered digits a string that represent the number
            StringBuilder stringNumber = new StringBuilder();
            while (!numbersBox.isEmpty()) {
                stringNumber.append(numbersBox.pop().val);
            }

            //TODO: Add calculation digit by digit

            // Convert the string into a real integer
            int number = Integer.parseInt(String.valueOf(stringNumber));

            // Add the number to a list
            numbers.add(number);
        });


        // Calculate the sum of the two integers
        Integer result = numbers.stream().reduce(0, Integer::sum);

        // Convert the result into a char array
        char[] resultChars = String.valueOf(result).toCharArray();

        // Add all the digits to a ListNode in reversed order
        int lastCharIndex = resultChars.length-1;
        ListNode resultNode = null;
        for (int j = lastCharIndex; j >= 0; j--) {
            resultNode = addDigitToNode(resultNode, Integer.parseInt(String.valueOf(resultChars[j])));
        }

        return resultNode;
    }

    // Add new values to ListNode
    private ListNode addDigitToNode(ListNode node, int num) {
        if (node == null) {
            node = new ListNode(num);
            return node;
        } else if (node.next == null) {
            node.next = new ListNode(num);
            return node;
        } else {
            node.next = addDigitToNode(node.next, num);
            return node;
        }
    }

}
