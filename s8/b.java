package s8;

import com.qzone.common.event.Event;

/* compiled from: P */
/* loaded from: classes36.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    Event f433423a;

    public b(Event event) {
        this.f433423a = event;
    }

    public static b d(Event event) {
        return new b(event);
    }

    public String a() {
        return this.f433423a.source.getName();
    }

    public Object b() {
        return this.f433423a.params;
    }

    public int c() {
        return this.f433423a.what;
    }
}
