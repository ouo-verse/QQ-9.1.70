package xo3;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\t\b\u0016\u00a2\u0006\u0004\b\u0017\u0010\u0018B\u001d\b\u0016\u0012\u0012\u0010\u0013\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u0019\"\u00020\u0002\u00a2\u0006\u0004\b\u0017\u0010\u001aJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0006\u0010\u0006\u001a\u00020\u0004J\u0016\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J!\u0010\f\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u000b*\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007\u00a2\u0006\u0004\b\f\u0010\rR \u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000fR\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0012R\u0016\u0010\u0016\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0015\u00a8\u0006\u001b"}, d2 = {"Lxo3/b;", "", "Lcom/tencent/ntcompose/lifecycle/viewmodel/a;", "closeable", "", "d", "c", "", "key", "b", "a", "T", "e", "(Ljava/lang/String;)Lcom/tencent/ntcompose/lifecycle/viewmodel/a;", "", "Ljava/util/Map;", "keyToCloseables", "", "Ljava/util/Set;", "closeables", "", "Z", "isCleared", "<init>", "()V", "", "([Lcom/tencent/ntcompose/lifecycle/viewmodel/a;)V", "ntcompose_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Map<String, com.tencent.ntcompose.lifecycle.viewmodel.a> keyToCloseables;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final Set<com.tencent.ntcompose.lifecycle.viewmodel.a> closeables;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private boolean isCleared;

    public b() {
        this.keyToCloseables = new LinkedHashMap();
        this.closeables = new LinkedHashSet();
    }

    public final void a(com.tencent.ntcompose.lifecycle.viewmodel.a closeable) {
        Intrinsics.checkNotNullParameter(closeable, "closeable");
        if (this.isCleared) {
            d(closeable);
        } else {
            this.closeables.add(closeable);
        }
    }

    public final void b(String key, com.tencent.ntcompose.lifecycle.viewmodel.a closeable) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(closeable, "closeable");
        if (this.isCleared) {
            d(closeable);
        } else {
            d(this.keyToCloseables.put(key, closeable));
        }
    }

    public final void c() {
        if (this.isCleared) {
            return;
        }
        this.isCleared = true;
        Iterator<com.tencent.ntcompose.lifecycle.viewmodel.a> it = this.keyToCloseables.values().iterator();
        while (it.hasNext()) {
            d(it.next());
        }
        Iterator<com.tencent.ntcompose.lifecycle.viewmodel.a> it5 = this.closeables.iterator();
        while (it5.hasNext()) {
            d(it5.next());
        }
        this.closeables.clear();
    }

    public final <T extends com.tencent.ntcompose.lifecycle.viewmodel.a> T e(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        com.tencent.ntcompose.lifecycle.viewmodel.a aVar = this.keyToCloseables.get(key);
        if (aVar instanceof com.tencent.ntcompose.lifecycle.viewmodel.a) {
            return (T) aVar;
        }
        return null;
    }

    private final void d(com.tencent.ntcompose.lifecycle.viewmodel.a closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception e16) {
                throw new RuntimeException(e16);
            }
        }
    }

    public b(com.tencent.ntcompose.lifecycle.viewmodel.a... closeables) {
        Intrinsics.checkNotNullParameter(closeables, "closeables");
        this.keyToCloseables = new LinkedHashMap();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        this.closeables = linkedHashSet;
        CollectionsKt__MutableCollectionsKt.addAll(linkedHashSet, closeables);
    }
}
