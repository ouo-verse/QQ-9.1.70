package ww2;

import android.view.View;
import androidx.annotation.NonNull;
import tw2.b;

/* compiled from: P */
/* loaded from: classes19.dex */
public class g<Controller extends tw2.b> extends f<Controller> implements b, xw2.b {

    /* renamed from: e, reason: collision with root package name */
    protected View f446620e;

    /* renamed from: f, reason: collision with root package name */
    protected xw2.d f446621f;

    /* renamed from: h, reason: collision with root package name */
    protected xw2.a f446622h;

    /* renamed from: i, reason: collision with root package name */
    protected sv2.a f446623i;

    public g(Controller controller) {
        super(controller);
    }

    public void a(xw2.a aVar) {
        this.f446622h = aVar;
    }

    @Override // ww2.b
    public void c(@NonNull View view) {
        this.f446620e = view;
    }

    public void e(xw2.d dVar, boolean z16, sv2.a aVar) {
        this.f446623i = aVar;
    }

    @Override // ww2.b
    public xw2.a getPlayer() {
        return this.f446622h;
    }

    public void j(xw2.d dVar, sv2.a aVar) {
        this.f446623i = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public long n() {
        sv2.a aVar = this.f446623i;
        if (aVar == null) {
            return 0L;
        }
        return aVar.f434835d;
    }

    public xw2.d o() {
        return this.f446621f;
    }

    public void b(xw2.d dVar) {
    }

    @Override // xw2.b
    public void f(xw2.c cVar) {
    }

    public void g(xw2.d dVar) {
    }

    public void l(int i3, String str) {
    }
}
