package wo2;

import android.view.View;
import android.view.ViewTreeObserver;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ListView;
import e80.g;
import java.lang.ref.WeakReference;
import r90.b;

/* compiled from: P */
/* loaded from: classes18.dex */
public class a implements AbsListView.OnScrollListener, b.InterfaceC11125b {
    private long C;

    /* renamed from: e, reason: collision with root package name */
    private ListView f445999e;

    /* renamed from: f, reason: collision with root package name */
    private int f446000f;

    /* renamed from: h, reason: collision with root package name */
    private int f446001h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f446002i;

    /* renamed from: m, reason: collision with root package name */
    private boolean f446003m;

    /* renamed from: d, reason: collision with root package name */
    private final r90.b f445998d = new r90.b();
    private final ViewTreeObserver.OnGlobalLayoutListener D = new ViewTreeObserverOnGlobalLayoutListenerC11499a(this);

    /* compiled from: P */
    /* renamed from: wo2.a$a, reason: collision with other inner class name */
    /* loaded from: classes18.dex */
    private static class ViewTreeObserverOnGlobalLayoutListenerC11499a implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: d, reason: collision with root package name */
        private final WeakReference<a> f446004d;

        ViewTreeObserverOnGlobalLayoutListenerC11499a(a aVar) {
            this.f446004d = new WeakReference<>(aVar);
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            boolean isShown;
            a aVar = this.f446004d.get();
            if (aVar != null && aVar.f446003m != (isShown = aVar.f445999e.isShown())) {
                aVar.f446003m = isShown;
                if (aVar.f446003m) {
                    aVar.o();
                } else {
                    aVar.n();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        if (this.f446002i && this.f446003m) {
            return;
        }
        this.f445998d.u();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        if (this.f446002i && this.f446003m) {
            this.f445998d.onResume();
        }
    }

    @Override // r90.b.InterfaceC11125b
    public View a(int i3) {
        if (this.f446001h == 0) {
            this.f446001h = this.f445999e.getChildCount();
        }
        int i16 = this.f446000f;
        if (i3 >= i16 && i3 <= this.f446001h) {
            return this.f445999e.getChildAt(i3 - i16);
        }
        return null;
    }

    @Override // r90.b.InterfaceC11125b
    public boolean c() {
        return this.f445999e.canScrollVertically(1);
    }

    @Override // r90.b.InterfaceC11125b
    public int[] d() {
        return new int[]{this.f446000f, this.f446001h};
    }

    public void j(ListView listView) {
        this.f445999e = listView;
        listView.addOnScrollListener(this);
        this.f445998d.e(listView, this);
        listView.getViewTreeObserver().removeOnGlobalLayoutListener(this.D);
        listView.getViewTreeObserver().addOnGlobalLayoutListener(this.D);
    }

    public void k() {
        this.f445998d.onDestroy();
        ListView listView = this.f445999e;
        if (listView != null) {
            listView.getViewTreeObserver().removeOnGlobalLayoutListener(this.D);
        }
    }

    public void l() {
        this.f446002i = false;
        n();
    }

    public void m() {
        this.f446002i = true;
        o();
    }

    @Override // com.tencent.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i3, int i16, int i17) {
        this.f446000f = i3;
        this.f446001h = (i16 + i3) - 1;
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.C > 500) {
            this.C = currentTimeMillis;
            this.f445998d.C(i3, this.f446001h);
        }
    }

    @Override // com.tencent.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i3) {
        this.f445998d.v(i3, this.f446000f, this.f446001h);
    }

    public void onDestroy() {
    }

    @Override // r90.b.InterfaceC11125b
    public void b(Iterable<g> iterable, g gVar, int i3, int i16) {
    }
}
