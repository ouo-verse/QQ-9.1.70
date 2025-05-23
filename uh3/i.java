package uh3;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.zplan.event.api.Event;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c0\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ&\u0010\t\u001a\u00020\b2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H\u0002J$\u0010\u000b\u001a\u00020\b2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\n0\u00022\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005J+\u0010\f\u001a\u00020\b2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0000\u00a2\u0006\u0004\b\f\u0010\r\u00a8\u0006\u0010"}, d2 = {"Luh3/i;", "", "", "Lvu4/c;", "eventList", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lvu4/b;", "cb", "", "d", "Lcom/tencent/mobileqq/zplan/event/api/Event;", "b", "e", "(Ljava/util/List;Lcom/tencent/mobileqq/zootopia/api/e;)V", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public static final i f438976a = new i();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"uh3/i$a", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lvu4/b;", "result", "", "a", "", "error", "", "message", "onResultFailure", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes36.dex */
    public static final class a implements com.tencent.mobileqq.zootopia.api.e<vu4.b> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.zootopia.api.e<vu4.b> f438977d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ List<vu4.c> f438978e;

        a(com.tencent.mobileqq.zootopia.api.e<vu4.b> eVar, List<vu4.c> list) {
            this.f438977d = eVar;
            this.f438978e = list;
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(vu4.b result) {
            Intrinsics.checkNotNullParameter(result, "result");
            QLog.i("ZPlanEventReporterV2", 1, "reportInner#onResultSuccess error:" + result.f443552a + ", message:" + result.f443553b);
            com.tencent.mobileqq.zootopia.api.e<vu4.b> eVar = this.f438977d;
            if (eVar != null) {
                eVar.onResultSuccess(result);
            }
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            QLog.e("ZPlanEventReporterV2", 1, "reportInner#onResultFailure error:" + error + ", message:" + message);
            sh3.c.f433814b.i(this.f438978e);
            com.tencent.mobileqq.zootopia.api.e<vu4.b> eVar = this.f438977d;
            if (eVar != null) {
                eVar.onResultFailure(error, message);
            }
        }
    }

    i() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(List eventList, com.tencent.mobileqq.zootopia.api.e eVar) {
        Intrinsics.checkNotNullParameter(eventList, "$eventList");
        f438976a.d(com.tencent.mobileqq.zplan.event.impl.a.f333441a.c(eventList), eVar);
    }

    private final void d(List<vu4.c> eventList, com.tencent.mobileqq.zootopia.api.e<vu4.b> cb5) {
        if (!NetworkUtil.isNetworkAvailable()) {
            QLog.e("ZPlanEventReporterV2", 1, "reportInner eventList:" + eventList + ", net unavailable!");
            if (cb5 != null) {
                cb5.onResultFailure(-15, "net unavailable");
            }
            sh3.c.f433814b.i(eventList);
            return;
        }
        e(eventList, new a(cb5, eventList));
    }

    public final void b(final List<Event> eventList, final com.tencent.mobileqq.zootopia.api.e<vu4.b> cb5) {
        Intrinsics.checkNotNullParameter(eventList, "eventList");
        ThreadManagerV2.excute(new Runnable() { // from class: uh3.h
            @Override // java.lang.Runnable
            public final void run() {
                i.c(eventList, cb5);
            }
        }, 16, null, false);
    }

    public final void e(List<vu4.c> eventList, com.tencent.mobileqq.zootopia.api.e<vu4.b> cb5) {
        Intrinsics.checkNotNullParameter(eventList, "eventList");
        Intrinsics.checkNotNullParameter(cb5, "cb");
        if (eventList.isEmpty()) {
            QLog.e("ZPlanEventReporterV2", 1, "reportToServer eventList is empty!");
            return;
        }
        vu4.a aVar = new vu4.a();
        Object[] array = eventList.toArray(new vu4.c[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        aVar.f443551a = (vu4.c[]) array;
        g.b(g.f438972a, aVar, cb5, 0, 4, null);
    }
}
