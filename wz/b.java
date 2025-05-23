package wz;

import com.tencent.biz.pubaccount.weishi.event.WSSimpleBaseEvent;
import com.tencent.biz.pubaccount.weishi.util.x;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes36.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private final ConcurrentHashMap<String, Map<Integer, WeakReference<c>>> f446777a = new ConcurrentHashMap<>();

    /* compiled from: P */
    /* loaded from: classes36.dex */
    private static class a {

        /* renamed from: a, reason: collision with root package name */
        private static final b f446778a = new b();
    }

    b() {
    }

    public static b b() {
        return a.f446778a;
    }

    private void c(String str, c cVar) {
        Map<Integer, WeakReference<c>> map = this.f446777a.get(str);
        if (map == null) {
            map = Collections.synchronizedMap(new LinkedHashMap());
        }
        map.put(Integer.valueOf(cVar.hashCode()), new WeakReference<>(cVar));
        this.f446777a.put(str, map);
        x.a("WSSimpleEventBus", 2, "registerReceiver event Name:" + str + ",key\uff1a[" + cVar.getClass().getSimpleName() + ":" + cVar.hashCode() + "], subscribers size:" + map.size());
    }

    private void e(String str, c cVar) {
        Map<Integer, WeakReference<c>> map = this.f446777a.get(str);
        if (map == null) {
            return;
        }
        map.remove(Integer.valueOf(cVar.hashCode()));
        if (map.size() == 0) {
            this.f446777a.remove(str);
        }
        x.a("WSSimpleEventBus", 2, "unRegisterReceiver event Name:" + str + ",key\uff1a[" + cVar.getClass().getSimpleName() + ":" + cVar.hashCode() + "], subscribers size:" + map.size());
    }

    public void a(WSSimpleBaseEvent wSSimpleBaseEvent) {
        Map<Integer, WeakReference<c>> map = this.f446777a.get(wSSimpleBaseEvent.getClass().getName());
        if (map == null) {
            return;
        }
        for (WeakReference<c> weakReference : map.values()) {
            if (weakReference != null && weakReference.get() != null) {
                weakReference.get().b(wSSimpleBaseEvent);
            }
        }
    }

    public void d(c cVar) {
        if (cVar == null) {
            return;
        }
        Iterator it = cVar.getEventClass().iterator();
        while (it.hasNext()) {
            c(((Class) it.next()).getName(), cVar);
        }
    }

    public void f(c cVar) {
        if (cVar == null) {
            return;
        }
        Iterator it = cVar.getEventClass().iterator();
        while (it.hasNext()) {
            e(((Class) it.next()).getName(), cVar);
        }
    }
}
