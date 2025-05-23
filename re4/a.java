package re4;

import android.content.Context;
import com.tencent.tbs.one.TBSOneManager;

/* compiled from: P */
/* loaded from: classes26.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private boolean f431166a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f431167b;

    /* renamed from: c, reason: collision with root package name */
    private TBSOneManager f431168c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f431169d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f431170e;

    /* renamed from: f, reason: collision with root package name */
    private Context f431171f;

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private boolean f431172a = true;

        /* renamed from: b, reason: collision with root package name */
        private boolean f431173b = true;

        /* renamed from: c, reason: collision with root package name */
        private boolean f431174c = true;

        /* renamed from: d, reason: collision with root package name */
        private boolean f431175d = true;

        /* renamed from: e, reason: collision with root package name */
        private Context f431176e;

        public b(Context context) {
            this.f431176e = context;
        }

        public a f() {
            return new a(this);
        }
    }

    public TBSOneManager a() {
        return this.f431168c;
    }

    public boolean b() {
        return this.f431169d;
    }

    public boolean c() {
        return this.f431170e;
    }

    public boolean d() {
        return this.f431166a;
    }

    public boolean e() {
        return this.f431167b;
    }

    public String toString() {
        return "LogHandlerOptions{logTBSFileSdk=" + this.f431166a + ", logTBSOne=" + this.f431167b + ", logTBSBase=" + this.f431169d + '}';
    }

    a(b bVar) {
        this.f431167b = bVar.f431173b;
        this.f431168c = bVar.f431173b ? TBSOneManager.getDefaultInstance(bVar.f431176e) : null;
        this.f431166a = bVar.f431172a;
        this.f431169d = bVar.f431174c;
        this.f431170e = bVar.f431175d;
        this.f431171f = bVar.f431176e;
    }
}
