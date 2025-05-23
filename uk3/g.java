package uk3;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.zplan.model.AccessibleDetail;
import com.tencent.mobileqq.zplan.servlet.k;
import com.tencent.mobileqq.zplan.servlet.o;
import com.tencent.mobileqq.zplan.utils.af;
import com.tencent.mobileqq.zplan.utils.bb;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import nk3.n;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u000e\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\u0018\u0010\r\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bJ\u0016\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0002J\u0016\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\tJ\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\tJ\"\u0010\u0017\u001a\u0004\u0018\u00010\u00132\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\t2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015J\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00132\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\tJ\u000e\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u0013J\u0016\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u0013\u00a8\u0006\u001e"}, d2 = {"Luk3/g;", "", "", "i", "Lcom/tencent/common/app/AppInterface;", "appRuntime", "", "k", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "appid", "Lji3/i;", "listener", "d", "forceUpload", "p", "scene", "uin", "j", "Lcom/tencent/mobileqq/zplan/model/AccessibleDetail;", tl.h.F, "Lnk3/n;", "callback", "e", "g", "detailResult", "o", DomainData.DOMAIN_NAME, "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public static final g f439121a = new g();

    g() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(long j3, long j16, n nVar) {
        List<Long> listOf;
        List<Long> listOf2;
        o oVar = o.f335425a;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(Long.valueOf(j3));
        listOf2 = CollectionsKt__CollectionsJVMKt.listOf(Long.valueOf(j16));
        oVar.f(listOf, listOf2, nVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(AppInterface appInterface) {
        c cVar = c.f439112a;
        if (cVar.d()) {
            j71.a.b(appInterface);
            cVar.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(AppInterface appRuntime, boolean z16) {
        Intrinsics.checkNotNullParameter(appRuntime, "$appRuntime");
        if (c.f439112a.a(appRuntime.getLongAccountUin()) || z16) {
            k.f335419a.d();
        }
    }

    public final void d(long appid, ji3.i listener) {
        h.f439122a.a(appid, listener);
    }

    public final boolean i() {
        AppRuntime d16 = bb.f335811a.d();
        AccessibleDetail b16 = af.f335758a.b(d16 != null ? d16.getLongAccountUin() : 0L, 1000L);
        if (b16 == null) {
            QLog.w("[zplan]ZPlanAccessibleManager", 1, "isZPlanEnable get detail null");
            return false;
        }
        return b16.isDevicePass();
    }

    public final boolean j(long scene, long uin) {
        AccessibleDetail g16 = g(scene, uin);
        if (g16 == null) {
            return false;
        }
        QLog.i("[zplan]ZPlanAccessibleManager", 1, "isZplanAccessibleWithoutSetting detailResult:" + g16);
        return g16.isPassWithoutSetting();
    }

    public final void m(AppInterface appRuntime) {
        List<Long> listOf;
        List<Long> emptyList;
        Intrinsics.checkNotNullParameter(appRuntime, "appRuntime");
        long longAccountUin = appRuntime.getLongAccountUin();
        if (longAccountUin < 0) {
            QLog.e("[zplan]ZPlanAccessibleManager", 1, "getZPlanWhiteListFromNet error, uin : " + longAccountUin);
            return;
        }
        o oVar = o.f335425a;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(Long.valueOf(longAccountUin));
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        oVar.f(listOf, emptyList, null);
    }

    public final void n(long uin, AccessibleDetail detailResult) {
        Intrinsics.checkNotNullParameter(detailResult, "detailResult");
        QLog.i("[zplan]ZPlanAccessibleManager", 1, "update detailResult :" + detailResult + ", uin:" + com.tencent.zplan.common.utils.i.a(String.valueOf(uin)));
        af.h(af.f335758a, uin, detailResult, false, 4, null);
    }

    public final void o(AccessibleDetail detailResult) {
        Intrinsics.checkNotNullParameter(detailResult, "detailResult");
        AppRuntime d16 = bb.f335811a.d();
        if (d16 == null) {
            return;
        }
        n(d16.getLongAccountUin(), detailResult);
    }

    public final void p(final AppInterface appRuntime, final boolean forceUpload) {
        Intrinsics.checkNotNullParameter(appRuntime, "appRuntime");
        ThreadManagerV2.excute(new Runnable() { // from class: uk3.e
            @Override // java.lang.Runnable
            public final void run() {
                g.q(AppInterface.this, forceUpload);
            }
        }, 128, null, false);
    }

    public final void k(final AppInterface appRuntime) {
        if (appRuntime == null) {
            return;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: uk3.f
            @Override // java.lang.Runnable
            public final void run() {
                g.l(AppInterface.this);
            }
        }, 128, null, false);
    }

    public final AccessibleDetail g(long appid, long uin) {
        return e(appid, uin, null);
    }

    public final AccessibleDetail h(long appid, long uin) {
        if (uin < 0) {
            QLog.e("[zplan]ZPlanAccessibleManager", 1, "uin is invalid");
            return null;
        }
        return af.f335758a.c(uin, appid);
    }

    public final AccessibleDetail e(final long appid, final long uin, final n callback) {
        if (uin < 0) {
            QLog.e("[zplan]ZPlanAccessibleManager", 1, "uin is invalid");
            return null;
        }
        AccessibleDetail b16 = af.f335758a.b(uin, appid);
        if (callback != null) {
            if (b16 != null) {
                callback.a(b16);
            } else {
                QLog.i("[zplan]ZPlanAccessibleManager", 1, "getAccessibleDetail request form network");
                ThreadManagerV2.excute(new Runnable() { // from class: uk3.d
                    @Override // java.lang.Runnable
                    public final void run() {
                        g.f(uin, appid, callback);
                    }
                }, 128, null, true);
            }
        }
        return b16;
    }
}
