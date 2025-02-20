# StackDemo - Valid Parentheses Check
# Asciinema: https://asciinema.org/a/704412
## Overview

This Java program demonstrates how to check if a string containing parentheses (`()`, `{}`, `[]`) is valid. The string is considered valid if:
- Every opening parenthesis has a corresponding closing parenthesis.
- The parentheses are correctly nested and closed in the right order.

### Key Methods

1. **isValid(String s)**:
   - This method checks if the input string `s` containing parentheses is valid using a stack. It iterates through each character in the string and uses the stack to ensure that every opening parenthesis has a matching closing parenthesis.

2. **main(String[] args)**:
   - This method demonstrates the usage of the `isValid()` function by testing it with different input strings.

## Algorithm

### Valid Parentheses Algorithm:

1. **Input**: A string `s` containing parentheses.
2. **Process**:
   - Initialize an empty stack.
   - Loop through each character in the string:
     - If the character is an opening parenthesis (`'('`, `'{'`, `'['`), push it onto the stack.
     - If the character is a closing parenthesis (`')'`, `'}'`, `']'`):
       - If the stack is empty, return `false` (this means there's no matching opening parenthesis).
       - Pop the top of the stack and check if it matches the corresponding opening parenthesis.
       - If it doesn't match, return `false`.
   - After the loop, if the stack is empty, return `true` (all parentheses are validly paired). If the stack is not empty, return `false`.
3. **Output**: Returns `true` if the string has valid parentheses, otherwise `false`.

### Example Walkthrough

1. **Input**: `"{[()]}"`  
   - Step-by-step:
     - `'{'` is pushed onto the stack.
     - `'['` is pushed onto the stack.
     - `'('` is pushed onto the stack.
     - `')'` matches with `'('`, pop `'('` from the stack.
     - `']'` matches with `'['`, pop `'['` from the stack.
     - `'}'` matches with `'{'`, pop `'{'` from the stack.
     - Stack is empty, so the result is `true`.

2. **Input**: `"{[(])}"`  
   - Step-by-step:
     - `'{'` is pushed onto the stack.
     - `'['` is pushed onto the stack.
     - `'('` is pushed onto the stack.
     - `']'` does not match `'('`, return `false`.

   The output for the first input will be:

The output for the second input will be:

## Code

```java
import java.util.*;

class StackDemo {
 
 // Method to check if the parentheses in the string are valid
 public static boolean isValid(String s) {
     Stack<Character> stack = new Stack<>();
     
     // Loop through each character in the string
     for (char c : s.toCharArray()) {
         if (c == '(' || c == '{' || c == '[') {
             stack.push(c);  // Push opening parentheses onto the stack
         } else {
             // If the stack is empty or mismatched parentheses are found, return false
             if (stack.isEmpty()) return false;
             char top = stack.pop();
             if ((c == ')' && top != '(') ||
                 (c == '}' && top != '{') ||
                 (c == ']' && top != '[')) {
                 return false;
             }
         }
     }
     // Return true if the stack is empty (all parentheses matched)
     return stack.isEmpty();
 }

 // Main method to test the isValid function
 public static void main(String[] args) {
     System.out.println(isValid("{[()]}")); // true
     System.out.println(isValid("{[(])}")); // false
 }
}
