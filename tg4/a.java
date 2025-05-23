package tg4;

import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0002J\u0017\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00018\u0000\u00a2\u0006\u0004\b\t\u0010\nJ\u0006\u0010\u000b\u001a\u00020\bJ\u0014\u0010\f\u001a\u00020\b2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003J\u0014\u0010\r\u001a\u00020\b2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003R\u0014\u0010\u0010\u001a\u00020\u000e8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\f\u0010\u000fR)\u0010\u0016\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\u00120\u00118\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Ltg4/a;", "T", "", "Ltg4/b;", "listener", "", "b", "data", "", "d", "(Ljava/lang/Object;)V", "c", "a", "e", "", "Ljava/lang/String;", "tag", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lmqq/util/WeakReference;", "Ljava/util/concurrent/CopyOnWriteArrayList;", "getListenerList", "()Ljava/util/concurrent/CopyOnWriteArrayList;", "listenerList", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public abstract class a<T> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String tag = "BaseDbNotifyManager";

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final CopyOnWriteArrayList<WeakReference<b<T>>> listenerList = new CopyOnWriteArrayList<>();

    private final boolean b(b<T> listener) {
        Iterator<T> it = this.listenerList.iterator();
        while (it.hasNext()) {
            if (Intrinsics.areEqual(listener, ((WeakReference) it.next()).get())) {
                return true;
            }
        }
        return false;
    }

    public final void a(@NotNull b<T> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (b(listener)) {
            QLog.i(this.tag, 2, "bindListener already in list return ");
        } else {
            this.listenerList.add(new WeakReference<>(listener));
        }
    }

    public final void c() {
        this.listenerList.clear();
    }

    public final void d(@Nullable T data) {
        Iterator<T> it = this.listenerList.iterator();
        while (it.hasNext()) {
            b bVar = (b) ((WeakReference) it.next()).get();
            if (bVar != null) {
                bVar.a(data);
            }
        }
    }

    public final void e(@NotNull b<T> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = this.listenerList.iterator();
        while (it.hasNext()) {
            WeakReference it5 = (WeakReference) it.next();
            if (it5.get() == null) {
                Intrinsics.checkNotNullExpressionValue(it5, "it");
                arrayList.add(it5);
            } else if (Intrinsics.areEqual(listener, it5.get())) {
                Intrinsics.checkNotNullExpressionValue(it5, "it");
                arrayList.add(it5);
            }
        }
        if (arrayList.size() > 0) {
            this.listenerList.removeAll(arrayList);
        }
    }
}
