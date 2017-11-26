package com.joizhang.imooc.guice.general;

import com.joizhang.imooc.guice.guicedi.StringProvider;

/**
 * @author joizhang
 */
public class StringWritingApplet implements MyApplet {

    private MyDestination destination;

    private StringProvider stringProvider;

    public StringWritingApplet(MyDestination destination, StringProvider stringProvider) {
        this.destination = destination;
        this.stringProvider = stringProvider;
    }

    private void writeString() {
        destination.write(stringProvider.get());
    }

    @Override
    public void run() {
        writeString();
    }
}
