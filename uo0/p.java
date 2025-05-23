package uo0;

import android.util.LruCache;
import androidx.annotation.NonNull;
import com.tencent.guild.aio.input.at.quickAt.search.SearchException;
import com.tencent.guild.aio.input.at.utils.RecentAtRobotCache;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function1;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import so0.c;
import uo0.k;

/* compiled from: P */
/* loaded from: classes6.dex */
public class p {

    /* renamed from: a, reason: collision with root package name */
    protected final LruCache<String, k> f439363a = new LruCache<>(10);

    /* renamed from: b, reason: collision with root package name */
    protected k f439364b;

    /* renamed from: c, reason: collision with root package name */
    protected boolean f439365c;

    /* renamed from: d, reason: collision with root package name */
    protected final b f439366d;

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public interface a {
        Boolean isWaiting();
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public interface b extends ze1.d {
    }

    public p(b bVar) {
        this.f439366d = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h(a aVar, String str, String str2, boolean z16, List list) {
        if (aVar.isWaiting().booleanValue()) {
            g(str, str2, list, z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object i(String str, String str2, List list, boolean z16, AppRuntime appRuntime) {
        q(new j(appRuntime, str, str2, list, z16));
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object j(String str, String str2, String str3, AppRuntime appRuntime) {
        q(new h(appRuntime, str, str2, str3));
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k(k kVar, SearchException searchException) {
        if (searchException == null) {
            m(kVar);
        } else {
            l(searchException);
        }
    }

    private void l(Throwable th5) {
        k kVar;
        if (!(th5 instanceof SearchException)) {
            return;
        }
        SearchException searchException = (SearchException) th5;
        k kVar2 = searchException.context;
        if (!this.f439365c && !kVar2.j() && (kVar = this.f439364b) != null && kVar == kVar2) {
            String h16 = kVar2.h();
            String str = searchException.errMsg;
            QLog.w("SearchSession", 1, "search " + kVar2.f() + " error=" + searchException.toString());
            this.f439366d.d(kVar2, h16, str, searchException.result);
        }
    }

    private void p(k kVar, String str, List<IGProUserInfo> list, Object obj) {
        ArrayList arrayList = new ArrayList(list);
        HashSet hashSet = new HashSet();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            IGProUserInfo iGProUserInfo = (IGProUserInfo) it.next();
            if (hashSet.contains(iGProUserInfo.getTinyId())) {
                it.remove();
            } else {
                hashSet.add(iGProUserInfo.getTinyId());
            }
        }
        this.f439366d.e(kVar, str, arrayList, obj);
    }

    public void e() {
        this.f439365c = true;
        this.f439363a.evictAll();
        this.f439364b = null;
    }

    public void f(@NonNull final String str, @NonNull final String str2, int i3, final boolean z16, final a aVar) {
        if (i3 == 7) {
            g(str, str2, RecentAtRobotCache.a(str), z16);
        } else {
            so0.c.e(str, str2, new c.d() { // from class: uo0.m
                @Override // so0.c.d
                public final void onResult(List list) {
                    p.this.h(aVar, str, str2, z16, list);
                }
            });
        }
    }

    public void g(@NonNull final String str, @NonNull final String str2, @NonNull final List<String> list, final boolean z16) {
        n("findRecentUserAndAdmin", new Function1() { // from class: uo0.o
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Object i3;
                i3 = p.this.i(str, str2, list, z16, (AppRuntime) obj);
                return i3;
            }
        });
    }

    protected void m(k kVar) {
        if (this.f439365c || kVar.j() || this.f439364b != kVar) {
            return;
        }
        p(kVar, kVar.h(), kVar.i(), kVar.g());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public <R> R n(String str, @NonNull Function1<AppRuntime, R> function1) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            QLog.e("SearchSession", 1, "[" + str + "] | peek null app runtime");
            return null;
        }
        return function1.invoke(peekAppRuntime);
    }

    public void o(@NonNull final String str, @NonNull final String str2, @NonNull final String str3) {
        n("searchMemberAndRolesList", new Function1() { // from class: uo0.n
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Object j3;
                j3 = p.this.j(str, str2, str3, (AppRuntime) obj);
                return j3;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void q(k kVar) {
        String f16 = kVar.f();
        k kVar2 = this.f439363a.get(f16);
        if (kVar2 != null && kVar2.k()) {
            if (!kVar2.l()) {
                this.f439364b = kVar2;
                m(kVar2);
                return;
            }
            this.f439363a.remove(f16);
        }
        r(kVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void r(k kVar) {
        this.f439363a.put(kVar.f(), kVar);
        this.f439364b = kVar;
        kVar.n(new k.a() { // from class: uo0.l
            @Override // uo0.k.a
            public final void a(k kVar2, SearchException searchException) {
                p.this.k(kVar2, searchException);
            }
        });
    }
}
