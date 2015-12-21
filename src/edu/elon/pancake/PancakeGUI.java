/*
 * PancakeGUI.java 1.0 Apr 29, 2015
 *
 *Copyright (c) 2015 David Han
 * Campus Box 2320, Elon University, Elon, NC 27244
 */
package edu.elon.pancake;

import java.io.File;
import java.util.Stack;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 * ElonStockGUI to prompt for a file and displays final results
 *
 * @author David Han
 * 
 * 
 */
public class PancakeGUI {

  private File selectedFile;

  /**
   * Displays message dialog window of orginal pancakes integer radius's
   * unsorted, the integer number of flips taken to sort, and the sorted stack
   * of pancake radius's from least to greatest
   *
   * @param Stack
   *        of pancake diameter integers read from file
   * @param Stack
   *        of integers number of flips to create sorted stack
   * @param Stack
   *        of pancake diameter integers sorted from least to greatest
   */
  public void finalMessage(Stack<Integer> s1, Stack<Integer> flippedstack,
      Stack<Integer> newstack) {
    String intialresults = "";
    String numberofflips = "";
    String finalanswer = "";
    while (!s1.empty()) {
      intialresults = intialresults + s1.pop() + " ";
    }
    while (!flippedstack.empty()) {
      numberofflips = numberofflips + flippedstack.pop() + " ";
    }

    while (!newstack.empty()) {
      finalanswer = finalanswer + newstack.pop() + " ";
    }

    JOptionPane.showMessageDialog(null, "Starting Stack Order: "
        + intialresults + " \n" + "Flip indices: " + numberofflips + " \n"
        + "Ending Stack Order: " + finalanswer, "Pancake Results",
        JOptionPane.INFORMATION_MESSAGE);

    System.exit(0);

  }

  /**
   * 
   * Displays error message if file is not in correct format
   *
   * 
   */
  public void getErrorMessage() {
    String title = "Invalid File";
    String message = "The file" + selectedFile + " is not in proper format";
    JOptionPane.showMessageDialog(null, message, title,
        JOptionPane.INFORMATION_MESSAGE);
  }

  /**
   * Reads file selected by the user integer by integer and
   *
   * @param File
   *        chosen by user named selectedFile
   * 
   */
  public File getFile() {
    JFileChooser chooser = new JFileChooser();
    chooser.setDialogTitle("File of pancake ordering");
    if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
      selectedFile = chooser.getSelectedFile();
    }
    if (selectedFile == null) {
      System.exit(0);
    }
    return selectedFile;
  }
}
