package uk3;

import com.tencent.mobileqq.zplan.model.AccessibleDetail;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import mqq.util.WeakReference;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u001c\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0006J\u001a\u0010\u000e\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000bRH\u0010\u0012\u001a6\u0012\u0004\u0012\u00020\u0002\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00040\u000fj\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004`\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Luk3/h;", "", "", "appid", "", "Lmqq/util/WeakReference;", "Lji3/i;", "b", "listener", "", "a", "Lcom/tencent/mobileqq/zplan/model/AccessibleDetail;", "before", "after", "c", "Ljava/util/LinkedHashMap;", "Lkotlin/collections/LinkedHashMap;", "Ljava/util/LinkedHashMap;", "mObserver", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public static final h f439122a = new h();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final LinkedHashMap<Long, List<WeakReference<ji3.i>>> mObserver = new LinkedHashMap<>();

    h() {
    }

    private final synchronized List<WeakReference<ji3.i>> b(long appid) {
        List<WeakReference<ji3.i>> list;
        LinkedHashMap<Long, List<WeakReference<ji3.i>>> linkedHashMap = mObserver;
        list = linkedHashMap.get(Long.valueOf(appid));
        if (list == null) {
            list = new ArrayList<>();
            linkedHashMap.put(Long.valueOf(appid), list);
        }
        Iterator<WeakReference<ji3.i>> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().get() == null) {
                it.remove();
            }
        }
        return list;
    }

    public final synchronized void a(long appid, ji3.i listener) {
        if (listener == null) {
            return;
        }
        b(appid).add(new WeakReference<>(listener));
    }

    public final void c(AccessibleDetail before, AccessibleDetail after) {
        if (after == null) {
            return;
        }
        Iterator<T> it = b(after.getAppid()).iterator();
        while (it.hasNext()) {
            ji3.i iVar = (ji3.i) ((WeakReference) it.next()).get();
            if (iVar != null) {
                iVar.a(after);
            }
        }
    }
}
