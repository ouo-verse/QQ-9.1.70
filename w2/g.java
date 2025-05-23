package w2;

import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class g<TResult> extends y2.c<TResult> {

    /* renamed from: c, reason: collision with root package name */
    public boolean f444438c;

    /* renamed from: d, reason: collision with root package name */
    public TResult f444439d;

    /* renamed from: e, reason: collision with root package name */
    public Exception f444440e;

    /* renamed from: a, reason: collision with root package name */
    public final Object f444436a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public final Object f444437b = new Object();

    /* renamed from: f, reason: collision with root package name */
    public final List<y2.b> f444441f = new ArrayList();

    /* renamed from: g, reason: collision with root package name */
    public final List<y2.a> f444442g = new ArrayList();

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i(y2.a aVar) {
        synchronized (this.f444437b) {
            if (aVar != null) {
                aVar.onFailure(this.f444440e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j(y2.a aVar, Exception exc) {
        synchronized (this.f444436a) {
            aVar.onFailure(exc);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k(y2.b bVar) {
        synchronized (this.f444437b) {
            if (bVar != null) {
                bVar.onSuccess(this.f444439d);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l(y2.b bVar, Object obj) {
        synchronized (this.f444436a) {
            bVar.onSuccess(obj);
        }
    }

    @Override // y2.c
    public y2.c<TResult> a(final y2.a aVar) {
        synchronized (this.f444436a) {
            boolean z16 = this.f444438c;
            if (!z16) {
                this.f444442g.add(aVar);
                return this;
            }
            if (z16 && !m()) {
                b.a().execute(new Runnable() { // from class: w2.e
                    @Override // java.lang.Runnable
                    public final void run() {
                        g.this.i(aVar);
                    }
                });
            }
            return this;
        }
    }

    @Override // y2.c
    public y2.c<TResult> b(final y2.b bVar) {
        synchronized (this.f444436a) {
            if (!this.f444438c) {
                this.f444441f.add(bVar);
                return this;
            }
            if (m()) {
                b.a().execute(new Runnable() { // from class: w2.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        g.this.k(bVar);
                    }
                });
            }
            return this;
        }
    }

    @Override // y2.c
    public void c(final Exception exc) {
        synchronized (this.f444436a) {
            if (!this.f444438c) {
                this.f444438c = true;
                this.f444440e = exc;
                this.f444436a.notifyAll();
                for (final y2.a aVar : this.f444442g) {
                    try {
                        if (!m() && aVar != null) {
                            b.a().execute(new Runnable() { // from class: w2.f
                                @Override // java.lang.Runnable
                                public final void run() {
                                    g.this.j(aVar, exc);
                                }
                            });
                        }
                    } catch (RuntimeException e16) {
                        throw e16;
                    } catch (Exception e17) {
                        throw new RuntimeException(e17);
                    }
                }
                this.f444442g.clear();
            }
        }
    }

    @Override // y2.c
    public void d(final TResult tresult, boolean z16) {
        synchronized (this.f444436a) {
            if (!this.f444438c) {
                this.f444438c = z16;
                this.f444439d = tresult;
                this.f444436a.notifyAll();
                for (final y2.b bVar : this.f444441f) {
                    if (bVar != null) {
                        try {
                            b.a().execute(new Runnable() { // from class: w2.d
                                @Override // java.lang.Runnable
                                public final void run() {
                                    g.this.l(bVar, tresult);
                                }
                            });
                        } catch (RuntimeException e16) {
                            throw e16;
                        } catch (Exception e17) {
                            throw new RuntimeException(e17);
                        }
                    }
                }
                if (z16) {
                    this.f444441f.clear();
                }
            }
        }
    }

    public boolean m() {
        boolean z16;
        synchronized (this.f444436a) {
            if (this.f444438c && this.f444440e == null) {
                z16 = true;
            } else {
                z16 = false;
            }
        }
        return z16;
    }
}
