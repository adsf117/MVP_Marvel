package com.puzzlebench.mvp_marvel.bus;

import com.squareup.otto.Bus;

/**
 * Created by andresdavid on 21/02/17.
 */

public class BusProvider {

    private static final Bus BUS_INSTANCE = new MainPostingBus();

    private BusProvider() {
    }

    public static Bus getInstance() {
        return BUS_INSTANCE;
    }

    public static void register(Object... objects) {
        for (Object o : objects) {
            if (o != null) {
                BUS_INSTANCE.register(o);
            }
        }
    }

    public static void unregister(Object... objects) {
        for (Object o : objects) {
            if (o != null) {
                BUS_INSTANCE.unregister(o);
            }
        }
    }
}
