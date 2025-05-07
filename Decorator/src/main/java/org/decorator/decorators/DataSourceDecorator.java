package org.decorator.decorators;

public abstract class DataSourceDecorator implements DataSource {
    private final DataSource wrapper;

    DataSourceDecorator(DataSource source) {
      super();
      this.wrapper = source;
    }

    @Override
    public void writeData(String data) {
        wrapper.writeData(data);
    }

    @Override
    public String readData() {
        return wrapper.readData();
    }
} 