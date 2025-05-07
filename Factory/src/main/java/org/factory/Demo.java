package org.factory;

import org.factory.factory.Dialog;
import org.factory.factory.HtmlDialog;
import org.factory.factory.WindowsDialog;

/**
 * The Demo class.
 */
public final class Demo {
  private static Dialog dialog;

  private Demo() {
    super();
  }

  public static void main(String[] args) {
    configure();
    runBusinessLogic();
  }

  /**
   * The concrete factory is usually chosen depending on configuration or
   * environment options.
   */
  static void configure() {
    if (System.getProperty("os.name").startsWith("Windows")) {
      dialog = new WindowsDialog();
    } else {
      dialog = new HtmlDialog();
    }
  }

  /**
   * All the client code should work with factories and products through
   * abstract interfaces. This way it does not care which factory it works
   * with and what kind of product it returns.
   */
  static void runBusinessLogic() {
    dialog.renderWindow();
  }
} 