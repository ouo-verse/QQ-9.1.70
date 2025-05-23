package u11;

import androidx.annotation.CallSuper;
import com.tencent.localedit.fakenative.core.BaseManager;
import com.tencent.localedit.fakenative.resource.e;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\"\u0010#J%\u0010\u0006\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\r\u001a\u00020\f2\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\nJ\b\u0010\u000f\u001a\u00020\u000eH\u0017J\b\u0010\u0010\u001a\u00020\u000eH\u0017R\"\u0010\u0012\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR \u0010 \u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00020\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!\u00a8\u0006$"}, d2 = {"Lu11/a;", "Lu11/b;", "Lcom/tencent/localedit/fakenative/core/BaseManager;", "M", "Ljava/lang/Class;", "clazz", "getManager", "(Ljava/lang/Class;)Lcom/tencent/localedit/fakenative/core/BaseManager;", "Lu11/c;", "loader", "", "libName", "", "loadSo", "", "init", "dispose", "Lx11/c;", "logger", "Lx11/c;", "getLogger", "()Lx11/c;", "setLogger", "(Lx11/c;)V", "Lx11/d;", "reporter", "Lx11/d;", "getReporter", "()Lx11/d;", "setReporter", "(Lx11/d;)V", "", "managers", "Ljava/util/Map;", "<init>", "()V", "docx_local_edit_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes7.dex */
public abstract class a extends b {

    @NotNull
    private x11.c logger = x11.c.INSTANCE.a();

    @NotNull
    private final Map<String, BaseManager> managers = new ConcurrentHashMap();

    @Nullable
    private x11.d reporter;

    @NotNull
    public final x11.c getLogger() {
        return this.logger;
    }

    @NotNull
    public final <M extends BaseManager> M getManager(@NotNull Class<M> clazz) {
        M cast;
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        synchronized (this.managers) {
            BaseManager baseManager = this.managers.get(clazz.getName());
            if (baseManager == null) {
                cast = null;
            } else {
                cast = clazz.cast(baseManager);
            }
            if (cast == null) {
                M newInstance = clazz.getConstructor(new Class[0]).newInstance(new Object[0]);
                M it = newInstance;
                getLogger().d("BaseAPIBinding", Intrinsics.stringPlus("creating new manager ", clazz.getName()));
                Map<String, BaseManager> map = this.managers;
                String name = clazz.getName();
                Intrinsics.checkNotNullExpressionValue(name, "clazz.name");
                Intrinsics.checkNotNullExpressionValue(it, "it");
                map.put(name, it);
                Intrinsics.checkNotNullExpressionValue(newInstance, "clazz.getConstructor().n\u2026.name] = it\n            }");
                cast = newInstance;
            }
        }
        return cast;
    }

    @Nullable
    public final x11.d getReporter() {
        return this.reporter;
    }

    @Override // u11.b
    @CallSuper
    public void init() {
        setCache((e) getManager(e.class));
        setLocalServer((com.tencent.localedit.fakenative.localserver.b) getManager(com.tencent.localedit.fakenative.localserver.c.class));
        setPackageManager((com.tencent.localedit.fakenative.packages.a) getManager(com.tencent.localedit.fakenative.packages.a.class));
        setConvert((com.tencent.localedit.fakenative.convert.c) getManager(com.tencent.localedit.fakenative.convert.c.class));
    }

    public final boolean loadSo(@Nullable c loader, @NotNull String libName) {
        Object m476constructorimpl;
        Intrinsics.checkNotNullParameter(libName, "libName");
        try {
            Result.Companion companion = Result.INSTANCE;
            if (loader != null) {
                loader.loadLibrary(libName);
            } else {
                System.loadLibrary(libName);
            }
            m476constructorimpl = Result.m476constructorimpl(Unit.INSTANCE);
        } catch (Throwable th5) {
            Result.Companion companion2 = Result.INSTANCE;
            m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
        }
        Throwable m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
        if (m479exceptionOrNullimpl != null) {
            getLogger().e("loadSo failed", "", m479exceptionOrNullimpl);
        }
        return Result.m483isSuccessimpl(m476constructorimpl);
    }

    public final void setLogger(@NotNull x11.c cVar) {
        Intrinsics.checkNotNullParameter(cVar, "<set-?>");
        this.logger = cVar;
    }

    public final void setReporter(@Nullable x11.d dVar) {
        this.reporter = dVar;
    }

    @Override // u11.b
    @CallSuper
    public void dispose() {
    }
}
