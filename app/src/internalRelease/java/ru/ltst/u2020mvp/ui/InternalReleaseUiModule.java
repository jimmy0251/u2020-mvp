package ru.ltst.u2020mvp.ui;

import dagger.Module;
import dagger.Provides;
import ru.ltst.u2020mvp.ApplicationScope;
import ru.ltst.u2020mvp.base.mvp.Registry;
import ru.ltst.u2020mvp.ui.annotation.ActivityScreenSwitcherServer;

@Module(includes = UiModule.class)
public final class InternalReleaseUiModule {
    @Provides
    @ApplicationScope
    AppContainer provideAppContainer(TelescopeAppContainer telescopeAppContainer) {
        return telescopeAppContainer;
    }

    @Provides
    @ApplicationScope
    ActivityHierarchyServer provideActivityHierarchyServer(@ActivityScreenSwitcherServer ActivityHierarchyServer server) {
        final ActivityHierarchyServer.Proxy proxy = new ActivityHierarchyServer.Proxy();
        proxy.addServer(server);
        proxy.addServer(Registry.SERVER);
        return proxy;
    }
}
