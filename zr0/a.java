package zr0;

import com.tencent.hippy.qq.api.TabPreloadItem;
import fn0.GuildLiveAioMsgListWrap;
import fn0.c;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0014\u0010\t\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006R \u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u000b0\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lzr0/a;", "", "Lfn0/c;", "listener", "", "b", "", "Lcom/tencent/aio/data/msglist/a;", TabPreloadItem.TAB_NAME_MESSAGE, "a", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lmqq/util/WeakReference;", "Ljava/util/concurrent/CopyOnWriteArrayList;", "listenerList", "<init>", "()V", "aio-guild-live_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f453068a = new a();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final CopyOnWriteArrayList<WeakReference<c>> listenerList = new CopyOnWriteArrayList<>();

    a() {
    }

    public final void a(@NotNull List<? extends com.tencent.aio.data.msglist.a> msgList) {
        Intrinsics.checkNotNullParameter(msgList, "msgList");
        if (msgList.isEmpty()) {
            return;
        }
        Iterator<T> it = listenerList.iterator();
        while (it.hasNext()) {
            c cVar = (c) ((WeakReference) it.next()).get();
            if (cVar != null) {
                cVar.L0(new GuildLiveAioMsgListWrap(msgList, false, null, 6, null));
            }
        }
    }

    public void b(@NotNull c listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        listenerList.add(new WeakReference<>(listener));
    }
}
