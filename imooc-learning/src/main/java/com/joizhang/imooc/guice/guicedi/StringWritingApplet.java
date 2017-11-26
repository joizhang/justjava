package com.joizhang.imooc.guice.guicedi;

import com.google.inject.Provider;

import javax.inject.Inject;

/**
 * @author joizhang
 */
public class StringWritingApplet implements MyApplet {

    private MyDestination destination;

    private Provider<String> stringProvider;

    @Inject
    public StringWritingApplet(MyDestination destination, Provider<String> stringProvider) {
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
