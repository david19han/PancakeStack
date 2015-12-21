/*
 * Main.java 1.0 Apr 29, 2015
 *
 * Copyright (c) 2015 David Han
 * Campus Box 2320, Elon University, Elon, NC 27244
 */
package edu.elon.pancake;

/**
 * 
 * Driver class that has a single main method to instantiate the
 * PancakeController and call top controller method
 * 
 * @author David Han
 *
 */
public class Main {
  /**
   * 
   * Driver method that starts application
   * 
   * @param String
   *        array of command line arguments not used by application
   * 
   */
  public static void main(String[] args) {
    PancakeController controller = new PancakeController();
    controller.go();
    System.exit(0);
  }
}
