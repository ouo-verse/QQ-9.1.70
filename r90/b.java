package r90;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.annotation.Nullable;
import androidx.collection.ArraySet;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.immersive.views.search.event.QFSSearchCheckPlayEvent;
import com.tencent.biz.qqcircle.immersive.views.search.optimise.video.QFSSearchPrerenderManager;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.biz.richframework.compat.ImmersiveUtils;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.qphone.base.util.QLog;
import e80.e;
import e80.g;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes4.dex */
public class b implements ViewTreeObserver.OnWindowFocusChangeListener, SimpleEventReceiver {
    private InterfaceC11125b C;

    /* renamed from: d, reason: collision with root package name */
    private WeakReference<g> f430969d;

    /* renamed from: f, reason: collision with root package name */
    private long f430971f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f430972h;

    /* renamed from: m, reason: collision with root package name */
    private View f430974m;

    /* renamed from: e, reason: collision with root package name */
    private final a f430970e = new a();

    /* renamed from: i, reason: collision with root package name */
    private final Rect f430973i = new Rect();
    private final Runnable D = new Runnable() { // from class: r90.a
        @Override // java.lang.Runnable
        public final void run() {
            b.this.s();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a {

        /* renamed from: b, reason: collision with root package name */
        g f430976b;

        /* renamed from: d, reason: collision with root package name */
        private boolean f430978d;

        /* renamed from: a, reason: collision with root package name */
        final Collection<g> f430975a = new ArraySet();

        /* renamed from: c, reason: collision with root package name */
        int f430977c = -1;

        a() {
        }

        void a(int i3) {
            g z16 = b.this.z(this.f430975a, b.this.C.a(i3), this.f430978d, this.f430976b);
            if (z16 != null) {
                this.f430976b = z16;
                this.f430977c = i3;
            }
        }

        void b() {
            this.f430975a.clear();
            this.f430976b = null;
            this.f430977c = -1;
            this.f430978d = b.this.B();
        }
    }

    /* compiled from: P */
    /* renamed from: r90.b$b, reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC11125b {
        View a(int i3);

        void b(Iterable<g> iterable, g gVar, int i3, int i16);

        boolean c();

        int[] d();
    }

    private static void A(com.tencent.biz.qqcircle.immersive.scrollers.a aVar) {
        if (aVar == null) {
            return;
        }
        aVar.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean B() {
        if (!this.f430974m.isShown()) {
            t("#shouldStop: view is invisible");
            return true;
        }
        if (!QCirclePluginUtil.isSharePanelOnShow()) {
            if (!this.f430974m.hasWindowFocus()) {
                t("#shouldStop: no window focus");
                return true;
            }
            if (!this.f430972h) {
                t("#shouldStop: isResume=false");
                return true;
            }
        }
        return false;
    }

    private void f(int i3, int i16, a aVar) {
        while (i16 >= i3) {
            aVar.a(i16);
            i16--;
        }
    }

    private void g(int i3, int i16, a aVar) {
        while (i3 <= i16) {
            aVar.a(i3);
            i3++;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean h(View view) {
        if (((view instanceof e80.b) && !((e80.b) view).hasData()) || view == 0 || view.getHeight() == 0) {
            return false;
        }
        return true;
    }

    private void i(int i3, int i16, boolean z16) {
        long currentTimeMillis = System.currentTimeMillis();
        if (!z16 && currentTimeMillis - this.f430971f < 200) {
            return;
        }
        this.f430971f = currentTimeMillis;
        this.f430970e.b();
        if (this.C.c()) {
            g(i3, i16, this.f430970e);
        } else {
            f(i3, i16, this.f430970e);
        }
        a aVar = this.f430970e;
        y(aVar.f430975a, aVar.f430976b, i3, aVar.f430977c);
        this.f430970e.b();
    }

    private void j() {
        int[] d16 = this.C.d();
        if (d16 != null && d16.length >= 2) {
            i(d16[0], d16[1], true);
        }
    }

    private void k(g gVar) {
        t("#doPlay");
        if (gVar == null) {
            return;
        }
        gVar.play();
        this.f430969d = new WeakReference<>(gVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    private g l(Collection<g> collection, View view, boolean z16, g gVar) {
        if (view instanceof g) {
            g gVar2 = (g) view;
            View n3 = n(view);
            if (gVar == null && !z16 && q(n3)) {
                return gVar2;
            }
            collection.add(gVar2);
            return null;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    private static View n(View view) {
        if (view instanceof e80.a) {
            View c16 = ((e80.a) view).c();
            if (!h(c16)) {
                return null;
            }
            return c16;
        }
        return view;
    }

    private float o(View view) {
        int i3 = 0;
        this.f430973i.set(0, 0, ImmersiveUtils.getScreenWidth(), ImmersiveUtils.getScreenHeight());
        view.getGlobalVisibleRect(this.f430973i);
        int height = view.getHeight();
        int i16 = this.f430973i.bottom;
        if (i16 > 0) {
            if (i16 > DisplayUtil.getScreenHeight()) {
                this.f430973i.bottom = DisplayUtil.getScreenHeight();
            }
            Rect rect = this.f430973i;
            i3 = rect.bottom - rect.top;
        }
        return i3 / height;
    }

    private void p() {
        this.f430974m.removeCallbacks(this.D);
        this.f430974m.post(this.D);
    }

    private boolean q(@Nullable View view) {
        if (view == null) {
            return false;
        }
        return r(view);
    }

    private boolean r(View view) {
        if (o(view) > 0.5f) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void s() {
        g gVar;
        WeakReference<g> weakReference = this.f430969d;
        if (weakReference != null && (gVar = weakReference.get()) != null && gVar.isPlaying()) {
            return;
        }
        j();
    }

    private static void t(String str) {
        if (QLog.isColorLevel()) {
            QLog.d("QFSSearchPlayController", 2, str);
        }
    }

    private void x() {
        g gVar;
        WeakReference<g> weakReference = this.f430969d;
        if (weakReference != null && (gVar = weakReference.get()) != null) {
            gVar.stop();
        }
    }

    private void y(Iterable<g> iterable, g gVar, int i3, int i16) {
        boolean z16;
        for (g gVar2 : iterable) {
            if (gVar2.isPlaying()) {
                gVar2.stop();
            }
        }
        if (gVar != null && !gVar.isPlaying()) {
            if (gVar instanceof e80.c) {
                z16 = ((e80.c) gVar).l();
            } else {
                z16 = false;
            }
            if (!z16) {
                k(gVar);
            }
        }
        this.C.b(iterable, gVar, i3, i16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    public g z(Collection<g> collection, View view, boolean z16, g gVar) {
        if (!h(view)) {
            return null;
        }
        if (view instanceof e) {
            e eVar = (e) view;
            int rowCount = eVar.getRowCount();
            for (int i3 = 0; i3 < rowCount; i3++) {
                g z17 = z(collection, eVar.a(i3), z16, gVar);
                if (z17 != null) {
                    gVar = z17;
                }
            }
            return gVar;
        }
        g l3 = l(collection, view, z16, gVar);
        if (l3 != null) {
            return l3;
        }
        return gVar;
    }

    public void C(int i3, int i16) {
        i(i3, i16, false);
    }

    public void e(View view, InterfaceC11125b interfaceC11125b) {
        this.f430974m = view;
        this.C = interfaceC11125b;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(QFSSearchCheckPlayEvent.class);
        return arrayList;
    }

    @Nullable
    public g m() {
        WeakReference<g> weakReference = this.f430969d;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public void onDestroy() {
        g gVar;
        t("#onDestroy");
        WeakReference<g> weakReference = this.f430969d;
        if (weakReference != null && (gVar = weakReference.get()) != null) {
            A(gVar);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QFSSearchCheckPlayEvent) {
            p();
        }
    }

    public void onResume() {
        t("#onResume");
        this.f430972h = true;
        QFSSearchPrerenderManager.E(this.f430974m.getContext()).Q();
        j();
        this.f430974m.getViewTreeObserver().addOnWindowFocusChangeListener(this);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    public void onStop() {
        t("#onStop");
        x();
    }

    @Override // android.view.ViewTreeObserver.OnWindowFocusChangeListener
    public void onWindowFocusChanged(boolean z16) {
        if (z16) {
            t("#onWindowFocusChanged: hasFocus");
            j();
        }
    }

    public void u() {
        t("#onPause");
        this.f430972h = false;
        this.f430974m.getViewTreeObserver().removeOnWindowFocusChangeListener(this);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        if (!QCirclePluginUtil.isSharePanelOnShow()) {
            x();
        }
    }

    public void v(int i3, int i16, int i17) {
        if (i3 != 0) {
            return;
        }
        i(i16, i17, true);
    }

    public void w(com.tencent.biz.qqcircle.immersive.scrollers.a aVar) {
        A(aVar);
    }
}
