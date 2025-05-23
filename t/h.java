package t;

import java.util.Collections;
import java.util.Map;
import t.j;

/* compiled from: P */
/* loaded from: classes.dex */
public interface h {

    /* renamed from: a, reason: collision with root package name */
    @Deprecated
    public static final h f435102a = new a();

    /* renamed from: b, reason: collision with root package name */
    public static final h f435103b = new j.a().a();

    /* compiled from: P */
    /* loaded from: classes.dex */
    class a implements h {
        a() {
        }

        @Override // t.h
        public Map<String, String> getHeaders() {
            return Collections.emptyMap();
        }
    }

    Map<String, String> getHeaders();
}
