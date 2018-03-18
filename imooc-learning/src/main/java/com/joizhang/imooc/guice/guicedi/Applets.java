package com.joizhang.imooc.guice.guicedi;

import com.google.common.base.Joiner;
import com.google.inject.Binder;
import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.TypeLiteral;
import com.google.inject.binder.LinkedBindingBuilder;
import com.google.inject.multibindings.MapBinder;

import java.util.Map;


/**
 * MapBinder.newMapBinder(binder(), String.class, MyApplet.class)
 * .addBinding("hello")
 * .to(StringWritingApplet.class);
 * <p>
 * MapBinder.newMapBinder(binder(), String.class, MyApplet.class)
 * .addBinding("println")
 * .to(PrintLineApplet.class);
 *
 * @author imooc
 */
public class Applets {

    public static AppletRegister register(Binder binder) {
        return new AppletRegister(binder);
    }

    public static MyApplet get(Injector injector, String name) {
        Map<String, MyApplet> applets = injector.getInstance(
                Key.get(new TypeLiteral<Map<String, MyApplet>>() {
                }));
        if (!applets.containsKey(name)) {
            throw new IllegalArgumentException("Unable to find applet [" + name + "]." +
                    "valid applets are " +
                    Joiner.on(", ").join(applets.keySet()));
        }
        return applets.get(name);
    }

    public static class AppletRegister {
        private final Binder binder;

        private AppletRegister(Binder binder) {
            this.binder = binder;
        }

        public LinkedBindingBuilder<MyApplet> named(String name) {
            return MapBinder.newMapBinder(binder, String.class, MyApplet.class)
                    .addBinding(name);
        }
    }

}
