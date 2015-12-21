/*
 * PancakeController.java 1.0 Apr 29, 2015
 *
 *Copyright (c) 2015 David Han
 * Campus Box 2320, Elon University, Elon, NC 27244
 */
package edu.elon.pancake;

import java.io.File;
import java.util.Stack;

/**
 * The communicator of data and results between the PancakeGUI and the
 * PancakeController
 *
 * @author David Han
 * 
 * 
 * 
 */
public class PancakeController {
  /**
   * Top level control method that creates instance of view to retrieve a
   * correctly formatted file selected by the user, calls controller to read the
   * selected file, and records a Stack of integers of number of flips, the
   * original stack of pancake's integer diameter's, and new sorted stack from
   * least to greatest pancake diameters's.Then calls method from view to
   * display a message of results.
   *
   *
   */
  public void go() {
    PancakeGUI view = new PancakeGUI();
    PancakeModel model = new PancakeModel();
    boolean valid = false;
    while (!valid) {
      try {
        File selectedFile = view.getFile();
        model.readFile(selectedFile);
        model.flip();
        Stack<Integer> newstack = model.getNewstack();
        Stack<Integer> flipindex = model.getFlipindex();
        Stack<Integer> flippedstack = model.reverseflip(flipindex);
        Stack<Integer> s1 = model.getS1();

        view.finalMessage(s1, flippedstack, newstack);

      }

      catch (Exception exception) {
        view.getErrorMessage();
      }

    }

  }
}
