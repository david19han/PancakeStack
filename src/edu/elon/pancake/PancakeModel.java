/*
 * PancakeModel.java 1.0 Apr 29, 2015
 *
 * Copyright (c) 2015 David Han
 * Campus Box 2320, Elon University, Elon, NC 27244
 */
package edu.elon.pancake;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

/**
 * Model that uses methods from the Stack interface to sort through a user's
 * stack of integers and creates an instance of a new stack sorting the integers
 * from least to greatest, while recording the number of method actions,
 * "flips", taken.
 * 
 *
 * @author David Han
 * @version 1.0
 * @since 1.0
 * 
 */
public class PancakeModel {

  private Stack<Integer> s1 = new Stack<Integer>();
  private Stack<Integer> flipindex = new Stack<Integer>();
  private Stack<Integer> newstack = new Stack<Integer>();

  /**
   * Creates an instance of an arbitrary stack to hold the size of the orginal
   * stack of integers read from the user's file. Creates a new stack that
   * clones the orginial stack file. Searches for the largest number in the
   * clone stack. Poping that number, the stack will be pushed into one holding
   * stack and then pushed again into another holding stack, saving the amount
   * of push and pop actions in a stack of integers as the loop goes. Finally
   * pushes holding stack with larger number at the bottom and smaller numbers
   * on the top of popped largest integer.
   */

  /**
   * Takes a given stack s1 and goes through different iterations and flips
   * until it returns a stack that is sorted by ascending order. It first finds
   * size of the stack. Then, enters a loop that finds the largest number and
   * flips it to the top of the stack then to the bottom of the stack. Once this
   * iteration ends, the loop repeats but finds the next largest number and so
   * on. At the end the loop updates a newstack, containing the numbers sorted
   * by ascending order and flipstack, all the indices but in reverse order.
   * 
   */
  public void flip() {

    Stack<Integer> s2 = null;
    s2 = (Stack<Integer>) s1.clone();

    int truesize = 0;
    while (!s2.empty()) {
      s2.pop();
      truesize++;
    }

    int countersize = truesize;
    newstack = (Stack<Integer>) s1.clone();

    while (countersize > 0) {

      Stack<Integer> s3 = (Stack<Integer>) newstack.clone();
      int largestnumber = newstack.peek();

      for (int i = 0; i < countersize; i++) {
        if (largestnumber <= s3.peek()) {
          largestnumber = s3.peek();
        }
        s3.pop();
      }
      int positionoflargest = newstack.search(largestnumber);

      Stack<Integer> original = null;
      original = (Stack<Integer>) newstack.clone();

      Stack<Integer> hold1 = new Stack<Integer>();
      Stack<Integer> hold2 = new Stack<Integer>();

      if (positionoflargest != 1) {
        for (int i = 0; i < positionoflargest; i++) {
          int popped = original.pop();
          int pushed = hold1.push(popped);
        }
        while (!hold1.empty()) {
          int popped = hold1.pop();
          int pushed = hold2.push(popped);
        }
        while (!hold2.empty()) {
          int popped = hold2.pop();
          int pushed = original.push(popped);
        }
        flipindex.push(truesize - positionoflargest + 1);

      }
      Stack<Integer> hold3 = null;
      hold3 = (Stack<Integer>) original.clone();

      for (int i = 0; i < countersize; i++) {
        original.pop();
      }

      for (int i = 0; i < countersize; i++) {
        int popped = hold3.pop();
        int pushed = original.push(popped);
      }

      int indexofflip = truesize - countersize + 1;

      if (indexofflip != truesize) {
        flipindex.push(-1*(truesize - countersize) + 1);
        //flipindex.push((truesize - countersize) + 1);
      }
      newstack = original;
      countersize--;
    }

  }

  /**
   * Gets amount of "flips" or method actions taken to create sorted stack
   * 
   * @return Stack integers of amount of flips
   */

  public Stack<Integer> getFlipindex() {
    return flipindex;
  }

  /**
   * Gets stack of pancake diameters sorted from least to greatest
   * 
   * @return Stack integers of pancake diameters sorted from least to greatest
   */
  public Stack<Integer> getNewstack() {
    return newstack;
  }

  /**
   * Gets stack of pancake diameters read from user's file
   * 
   * @return Stack integers of pancake diameters read from user's file
   */
  public Stack<Integer> getS1() {
    return s1;
  }

  /**
   * Pushes a chosen number onto the top of user's stack of pancake diameters
   * adds the data values from the file into an instance of a file
   * 
   * @param arbitrary
   *        File selectedfile
   */
  public void readFile(File selectedfile) throws FileNotFoundException {
    Scanner in = null;
    Stack<Integer> stacked = new Stack<Integer>();
    in = new Scanner(selectedfile);
    while (in.hasNext()) {
      in.useDelimiter(" ");
      String numberstring = in.next();
      int number = Integer.parseInt(numberstring);
      stacked.push(number);
    }

    while (!stacked.empty()) {
      int popped = stacked.pop();
      int pushed = s1.push(popped);
    }

  }

  /**
   * Creates an instance of a stack and individually pops each object in stack
   * and pushes it on top of another instance of a new stack reversing the order
   * 
   * @param arbritary
   *        Stack of integers
   * @return Stack of integers in reverse order of integers in parameter Stack
   */
  public Stack reverseflip(Stack<Integer> astack) {
    Stack<Integer> reversedflipstack = new Stack<Integer>();
    reversedflipstack.push(0);
    while (!astack.empty()) {
      int popped = astack.pop();
      int pushed = reversedflipstack.push(popped);
    }
    return reversedflipstack;
  }

  /**
   * Sets an arbritary Stack of integers to indicated class variable
   * 
   * @param aFlipindex
   *        the flipindex to set
   */
  public void setFlipindex(Stack<Integer> aFlipindex) {
    flipindex = aFlipindex;
  }

  /**
   * Sets an arbritary Stack of integers to indicated class variable
   * 
   * @param aNewstack
   *        the newstack to set
   */
  public void setNewstack(Stack<Integer> aNewstack) {
    newstack = aNewstack;
  }

  /**
   * Sets an arbritary Stack of integers to indicated class variable
   * 
   * @param aS1
   *        the s1 to set
   */
  public void setS1(Stack<Integer> aS1) {
    s1 = aS1;
  }
}
