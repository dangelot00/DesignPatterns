package org.abstract_factory;

import org.abstract_factory.app.Application;
import org.abstract_factory.factories.impl.MacOSFactory;
import org.abstract_factory.factories.impl.WindowsFactory;
import org.abstract_factory.factories.interfaces.GUIFactory;

/**
 * The Demo class.
 */
public final class Demo {

  private Demo() {
    super();
  }

  /**
   * Application picks the factory type and creates it at run time (during initialization),
   * depending on the configuration or environment variables.
   */
  private static Application configureApplication() {
    final GUIFactory guiFactory = createFactory();
    return new Application(guiFactory);
  }

  private static GUIFactory createFactory() {
    final String osName = System.getProperty("os.name").toLowerCase();

    if (osName.contains("mac")) {
      return new MacOSFactory();
    } else {
      return new WindowsFactory();
    }
  }

  public static void main(String[] args) {
    final Application app = configureApplication();
    app.interact();
  }
}