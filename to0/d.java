package to0;

import android.text.TextUtils;
import android.view.View;
import androidx.collection.ArraySet;
import com.tencent.guild.aio.input.at.quickAt.dialogui.framework.a;
import com.tencent.guild.aio.input.at.utils.j;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import no0.h;
import po0.h;
import uo0.p;

/* compiled from: P */
/* loaded from: classes6.dex */
public class d implements ze1.b, ze1.d<IGProUserInfo>, a.InterfaceC1190a {
    private ze1.c D;

    /* renamed from: d, reason: collision with root package name */
    private final xe1.b f437015d;

    /* renamed from: e, reason: collision with root package name */
    private h f437016e;

    /* renamed from: h, reason: collision with root package name */
    private View f437018h;

    /* renamed from: i, reason: collision with root package name */
    private String f437019i;

    /* renamed from: m, reason: collision with root package name */
    private List<IGProUserInfo> f437020m;
    private final Set<ye1.a> C = new ArraySet();
    private boolean E = false;
    private boolean F = false;
    private boolean G = false;
    private boolean H = false;

    /* renamed from: f, reason: collision with root package name */
    private final p f437017f = new p(new b(this));

    /* compiled from: P */
    /* loaded from: classes6.dex */
    private static class b implements p.b {

        /* renamed from: d, reason: collision with root package name */
        private final WeakReference<ze1.d<IGProUserInfo>> f437022d;

        public b(ze1.d<IGProUserInfo> dVar) {
            this.f437022d = new WeakReference<>(dVar);
        }

        @Override // ze1.d
        public void d(ze1.c cVar, String str, String str2, int i3) {
            ze1.d<IGProUserInfo> dVar = this.f437022d.get();
            if (dVar != null) {
                dVar.d(cVar, str, str2, i3);
            }
        }

        @Override // ze1.d
        public void e(ze1.c cVar, String str, List list, Object obj) {
            ze1.d<IGProUserInfo> dVar = this.f437022d.get();
            if (dVar != null) {
                dVar.e(cVar, str, list, obj);
            }
        }
    }

    public d(xe1.b bVar) {
        this.f437015d = bVar;
    }

    private void B(ze1.c cVar, List<IGProUserInfo> list, boolean z16) {
        if (this.f437016e == null) {
            return;
        }
        final WeakReference weakReference = new WeakReference(this.f437016e);
        final WeakReference weakReference2 = new WeakReference(cVar);
        List<com.tencent.guild.aio.input.at.quickAt.selectmember.data.a> h16 = xo0.d.h(list, this.f437015d.j(), z16, this.f437015d.b(), this.f437015d.i(), new Function1() { // from class: to0.a
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit x16;
                x16 = d.x(weakReference, weakReference2, (List) obj);
                return x16;
            }
        });
        if (h16.isEmpty()) {
            if (this.f437016e.h0().f420569o) {
                r(false);
                QLog.d("GuildAtPanelImpl", 1, "showPanelBusinessLogic number count=0");
                return;
            }
            h16.add(new com.tencent.guild.aio.input.at.quickAt.selectmember.data.c());
        }
        this.f437016e.B0(cVar, h16);
        this.f437016e.Q(this.f437018h);
    }

    private h.c t() {
        return new a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v() {
        no0.h hVar = this.f437016e;
        if (hVar != null) {
            hVar.u0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Boolean w() {
        return Boolean.valueOf(this.F);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Unit x(WeakReference weakReference, WeakReference weakReference2, List list) {
        ze1.c cVar;
        no0.h hVar = (no0.h) weakReference.get();
        if (hVar == null || (cVar = (ze1.c) weakReference2.get()) == null) {
            return null;
        }
        hVar.B0(cVar, list);
        return null;
    }

    private void y() {
        boolean a16 = so0.d.a();
        if (this.f437016e == null || a16) {
            h.d dVar = new h.d(this.f437015d);
            no0.h hVar = this.f437016e;
            if (hVar != null && a16) {
                hVar.H();
            }
            this.f437016e = dVar.a();
            if (!this.C.isEmpty()) {
                this.f437016e.i0().a(this.C);
            }
            this.f437016e.O(this);
            ((po0.h) this.f437016e.l(po0.h.class)).J(t());
        }
        if (!this.G) {
            no0.h hVar2 = this.f437016e;
            hVar2.x0(hVar2.h0().f420568n);
        }
        this.f437016e.z0(0);
        this.f437016e.v0();
    }

    private void z() {
        j.e(this.f437015d.i(), s());
        this.f437019i = null;
        this.f437020m = null;
        this.E = false;
        this.G = false;
    }

    public void A(String str) {
        if (str != null && !this.H) {
            this.F = true;
            this.f437019i = str;
            String a16 = this.f437015d.a();
            String d16 = this.f437015d.d();
            if (str.isEmpty()) {
                this.f437017f.f(d16, a16, this.f437015d.b(), this.f437015d.k(), new p.a() { // from class: to0.b
                    @Override // uo0.p.a
                    public final Boolean isWaiting() {
                        Boolean w3;
                        w3 = d.this.w();
                        return w3;
                    }
                });
            } else {
                this.f437017f.o(d16, a16, str);
            }
        }
    }

    @Override // com.tencent.guild.aio.input.at.quickAt.dialogui.framework.a.InterfaceC1190a
    public void H0(int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("GuildAtPanelImpl", 2, "onDismiss");
        }
        z();
        no0.h hVar = this.f437016e;
        if (hVar != null) {
            hVar.s0(i3);
            this.f437016e.g0();
        }
    }

    @Override // ze1.a
    public boolean a() {
        no0.h hVar = this.f437016e;
        if (hVar != null && hVar.B()) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.guild.aio.input.at.quickAt.dialogui.framework.a.InterfaceC1190a
    public void b() {
        no0.h hVar = this.f437016e;
        if (hVar != null) {
            hVar.i0().h();
        }
    }

    @Override // com.tencent.guild.aio.input.at.quickAt.dialogui.framework.a.InterfaceC1190a
    public void c() {
        j.c(this.f437015d.i(), s());
        if (QLog.isDevelopLevel()) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: to0.c
                @Override // java.lang.Runnable
                public final void run() {
                    d.this.v();
                }
            });
        }
        no0.h hVar = this.f437016e;
        if (hVar != null) {
            hVar.i0().g();
            this.f437016e.f0();
        }
    }

    @Override // ze1.d
    public void d(ze1.c cVar, String str, String str2, int i3) {
        no0.h hVar;
        if (u() && (hVar = this.f437016e) != null) {
            hVar.B0(cVar, null);
        }
    }

    public void destroy() {
        r(false);
        no0.h hVar = this.f437016e;
        if (hVar != null) {
            hVar.H();
            this.f437016e = null;
        }
        this.f437017f.e();
        this.C.clear();
        this.H = true;
        this.f437019i = null;
        this.f437020m = null;
    }

    @Override // ze1.a
    public void dismiss() {
        boolean z16;
        no0.h hVar = this.f437016e;
        if (hVar != null) {
            z16 = hVar.h0().f429113c;
        } else {
            z16 = false;
        }
        r(z16);
    }

    @Override // ze1.d
    public void e(ze1.c cVar, String str, List<IGProUserInfo> list, Object obj) {
        int size;
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("searchResultSize: ");
            if (list == null) {
                size = 0;
            } else {
                size = list.size();
            }
            sb5.append(size);
            QLog.i("GuildAtPanelImpl", 2, sb5.toString());
        }
        this.f437020m = list;
        this.D = cVar;
        if (list == null) {
            return;
        }
        boolean z16 = this.E;
        if (z16 && this.F && this.f437016e != null) {
            B(cVar, list, !TextUtils.isEmpty(str));
        } else {
            QLog.i("GuildAtPanelImpl", 1, String.format("onSearchResult: ready:%s waiting:%s dialog:%s", Boolean.valueOf(z16), Boolean.valueOf(this.F), this.f437016e));
        }
    }

    @Override // ze1.b
    public void f(String str) {
        y();
    }

    @Override // ze1.b
    public boolean h() {
        no0.h hVar = this.f437016e;
        if (hVar != null && hVar.l0()) {
            return true;
        }
        return false;
    }

    @Override // ze1.a
    public void i(View view) {
        y();
        this.f437018h = view;
        this.f437016e.Q(view);
    }

    @Override // ze1.b
    public void j(String str, View view) {
        boolean z16;
        List<IGProUserInfo> list;
        ze1.c cVar;
        if (QLog.isColorLevel()) {
            QLog.i("GuildAtPanelImpl", 2, "searchAndShowPanel");
        }
        no0.h hVar = this.f437016e;
        if (hVar != null && hVar.l0() && TextUtils.isEmpty(str)) {
            z16 = false;
        } else {
            z16 = true;
        }
        this.G = z16;
        this.E = true;
        this.f437018h = view;
        y();
        if (TextUtils.equals(str, this.f437019i) && (list = this.f437020m) != null && (cVar = this.D) != null) {
            B(cVar, list, !TextUtils.isEmpty(str));
            this.f437020m = null;
        } else {
            A(str);
        }
        this.G = true;
    }

    @Override // ze1.a
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public void k(ye1.a aVar) {
        no0.h hVar = this.f437016e;
        if (hVar != null) {
            hVar.i0().b(aVar);
        }
        this.C.add(aVar);
    }

    public boolean q() {
        if (!this.F) {
            return false;
        }
        this.F = false;
        return true;
    }

    public void r(boolean z16) {
        boolean q16 = q();
        if (a()) {
            this.f437016e.n(z16);
            return;
        }
        if (q16) {
            H0(1);
        } else {
            z();
        }
        QLog.d("GuildAtPanelImpl", 1, "dismissPanel before being showed");
    }

    public int s() {
        return 1;
    }

    public boolean u() {
        return this.F;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public class a implements h.c {
        a() {
        }

        @Override // po0.h.c
        public void a(IGProUserInfo iGProUserInfo) {
            d.this.f437016e.A0(iGProUserInfo);
        }

        @Override // po0.h.c
        public void c(String str) {
            d.this.A(str);
        }

        @Override // po0.h.c
        public void b(IGProUserInfo iGProUserInfo) {
        }
    }
}
