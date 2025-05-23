package rx.plugins;

import androidx.lifecycle.c;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicReference;
import rx.annotations.Experimental;

/* loaded from: classes29.dex */
public class RxJavaPlugins {
    private static final RxJavaPlugins INSTANCE = new RxJavaPlugins();
    static final RxJavaErrorHandler DEFAULT_ERROR_HANDLER = new RxJavaErrorHandler() { // from class: rx.plugins.RxJavaPlugins.1
    };
    private final AtomicReference<RxJavaErrorHandler> errorHandler = new AtomicReference<>();
    private final AtomicReference<RxJavaObservableExecutionHook> observableExecutionHook = new AtomicReference<>();
    private final AtomicReference<RxJavaSingleExecutionHook> singleExecutionHook = new AtomicReference<>();
    private final AtomicReference<RxJavaCompletableExecutionHook> completableExecutionHook = new AtomicReference<>();
    private final AtomicReference<RxJavaSchedulersHook> schedulersHook = new AtomicReference<>();

    RxJavaPlugins() {
    }

    @Deprecated
    public static RxJavaPlugins getInstance() {
        return INSTANCE;
    }

    static Object getPluginImplementationViaProperty(Class<?> cls, Properties properties) {
        Properties properties2 = (Properties) properties.clone();
        String simpleName = cls.getSimpleName();
        String property = properties2.getProperty("rxjava.plugin." + simpleName + ".implementation");
        if (property == null) {
            Iterator it = properties2.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry entry = (Map.Entry) it.next();
                String obj = entry.getKey().toString();
                if (obj.startsWith("rxjava.plugin.") && obj.endsWith(".class") && simpleName.equals(entry.getValue().toString())) {
                    String str = "rxjava.plugin." + obj.substring(0, obj.length() - 6).substring(14) + ".impl";
                    String property2 = properties2.getProperty(str);
                    if (property2 != null) {
                        property = property2;
                    } else {
                        throw new IllegalStateException("Implementing class declaration for " + simpleName + " missing: " + str);
                    }
                }
            }
        }
        if (property != null) {
            try {
                return Class.forName(property).asSubclass(cls).newInstance();
            } catch (ClassCastException e16) {
                throw new IllegalStateException(simpleName + " implementation is not an instance of " + simpleName + MsgSummary.STR_COLON + property, e16);
            } catch (ClassNotFoundException e17) {
                throw new IllegalStateException(simpleName + " implementation class not found: " + property, e17);
            } catch (IllegalAccessException e18) {
                throw new IllegalStateException(simpleName + " implementation not able to be accessed: " + property, e18);
            } catch (InstantiationException e19) {
                throw new IllegalStateException(simpleName + " implementation not able to be instantiated: " + property, e19);
            }
        }
        return null;
    }

    @Experimental
    public RxJavaCompletableExecutionHook getCompletableExecutionHook() {
        if (this.completableExecutionHook.get() == null) {
            Object pluginImplementationViaProperty = getPluginImplementationViaProperty(RxJavaCompletableExecutionHook.class, System.getProperties());
            if (pluginImplementationViaProperty == null) {
                c.a(this.completableExecutionHook, null, new RxJavaCompletableExecutionHook() { // from class: rx.plugins.RxJavaPlugins.2
                });
            } else {
                c.a(this.completableExecutionHook, null, (RxJavaCompletableExecutionHook) pluginImplementationViaProperty);
            }
        }
        return this.completableExecutionHook.get();
    }

    public RxJavaErrorHandler getErrorHandler() {
        if (this.errorHandler.get() == null) {
            Object pluginImplementationViaProperty = getPluginImplementationViaProperty(RxJavaErrorHandler.class, System.getProperties());
            if (pluginImplementationViaProperty == null) {
                c.a(this.errorHandler, null, DEFAULT_ERROR_HANDLER);
            } else {
                c.a(this.errorHandler, null, (RxJavaErrorHandler) pluginImplementationViaProperty);
            }
        }
        return this.errorHandler.get();
    }

    public RxJavaObservableExecutionHook getObservableExecutionHook() {
        if (this.observableExecutionHook.get() == null) {
            Object pluginImplementationViaProperty = getPluginImplementationViaProperty(RxJavaObservableExecutionHook.class, System.getProperties());
            if (pluginImplementationViaProperty == null) {
                c.a(this.observableExecutionHook, null, RxJavaObservableExecutionHookDefault.getInstance());
            } else {
                c.a(this.observableExecutionHook, null, (RxJavaObservableExecutionHook) pluginImplementationViaProperty);
            }
        }
        return this.observableExecutionHook.get();
    }

    public RxJavaSchedulersHook getSchedulersHook() {
        if (this.schedulersHook.get() == null) {
            Object pluginImplementationViaProperty = getPluginImplementationViaProperty(RxJavaSchedulersHook.class, System.getProperties());
            if (pluginImplementationViaProperty == null) {
                c.a(this.schedulersHook, null, RxJavaSchedulersHook.getDefaultInstance());
            } else {
                c.a(this.schedulersHook, null, (RxJavaSchedulersHook) pluginImplementationViaProperty);
            }
        }
        return this.schedulersHook.get();
    }

    public RxJavaSingleExecutionHook getSingleExecutionHook() {
        if (this.singleExecutionHook.get() == null) {
            Object pluginImplementationViaProperty = getPluginImplementationViaProperty(RxJavaSingleExecutionHook.class, System.getProperties());
            if (pluginImplementationViaProperty == null) {
                c.a(this.singleExecutionHook, null, RxJavaSingleExecutionHookDefault.getInstance());
            } else {
                c.a(this.singleExecutionHook, null, (RxJavaSingleExecutionHook) pluginImplementationViaProperty);
            }
        }
        return this.singleExecutionHook.get();
    }

    @Experimental
    public void registerCompletableExecutionHook(RxJavaCompletableExecutionHook rxJavaCompletableExecutionHook) {
        if (c.a(this.completableExecutionHook, null, rxJavaCompletableExecutionHook)) {
            return;
        }
        throw new IllegalStateException("Another strategy was already registered: " + this.singleExecutionHook.get());
    }

    public void registerErrorHandler(RxJavaErrorHandler rxJavaErrorHandler) {
        if (c.a(this.errorHandler, null, rxJavaErrorHandler)) {
            return;
        }
        throw new IllegalStateException("Another strategy was already registered: " + this.errorHandler.get());
    }

    public void registerObservableExecutionHook(RxJavaObservableExecutionHook rxJavaObservableExecutionHook) {
        if (c.a(this.observableExecutionHook, null, rxJavaObservableExecutionHook)) {
            return;
        }
        throw new IllegalStateException("Another strategy was already registered: " + this.observableExecutionHook.get());
    }

    public void registerSchedulersHook(RxJavaSchedulersHook rxJavaSchedulersHook) {
        if (c.a(this.schedulersHook, null, rxJavaSchedulersHook)) {
            return;
        }
        throw new IllegalStateException("Another strategy was already registered: " + this.schedulersHook.get());
    }

    public void registerSingleExecutionHook(RxJavaSingleExecutionHook rxJavaSingleExecutionHook) {
        if (c.a(this.singleExecutionHook, null, rxJavaSingleExecutionHook)) {
            return;
        }
        throw new IllegalStateException("Another strategy was already registered: " + this.singleExecutionHook.get());
    }

    @Experimental
    public void reset() {
        RxJavaPlugins rxJavaPlugins = INSTANCE;
        rxJavaPlugins.errorHandler.set(null);
        rxJavaPlugins.observableExecutionHook.set(null);
        rxJavaPlugins.singleExecutionHook.set(null);
        rxJavaPlugins.completableExecutionHook.set(null);
        rxJavaPlugins.schedulersHook.set(null);
    }
}
