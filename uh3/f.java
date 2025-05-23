package uh3;

import com.tencent.mobileqq.zplan.event.impl.db.ZPlanRealtimeEventEntity;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0016\u0010\u0007\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Luh3/f;", "Luh3/a;", "", "a", "Ljava/util/concurrent/atomic/AtomicBoolean;", "b", "Ljava/util/concurrent/atomic/AtomicBoolean;", "mRequestingFlag", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class f implements uh3.a {

    /* renamed from: a, reason: collision with root package name */
    public static final f f438969a = new f();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static AtomicBoolean mRequestingFlag = new AtomicBoolean(false);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"uh3/f$a", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lvu4/b;", "result", "", "a", "", "error", "", "message", "onResultFailure", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes36.dex */
    public static final class a implements com.tencent.mobileqq.zootopia.api.e<vu4.b> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ List<ZPlanRealtimeEventEntity> f438971d;

        a(List<ZPlanRealtimeEventEntity> list) {
            this.f438971d = list;
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(vu4.b result) {
            Intrinsics.checkNotNullParameter(result, "result");
            QLog.i("ZPlanEventCacheHandler_", 1, "handleCacheData#onResultSuccess  delete entity:" + this.f438971d);
            sh3.c.f433814b.c(this.f438971d);
            f.mRequestingFlag.set(false);
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            QLog.e("ZPlanEventCacheHandler_", 1, "handleCacheData#onResultFailure error:" + error + ", message:" + message);
            f.mRequestingFlag.set(false);
        }
    }

    f() {
    }

    @Override // uh3.a
    public boolean a() {
        QLog.i("ZPlanEventCacheHandler_", 1, "handleCacheData mRequestingFlag:" + mRequestingFlag.get());
        List<ZPlanRealtimeEventEntity> e16 = sh3.c.f433814b.e();
        if (e16.isEmpty()) {
            QLog.w("ZPlanEventCacheHandler_", 1, "handleCacheData empty!");
            return false;
        }
        if (mRequestingFlag.get()) {
            QLog.w("ZPlanEventCacheHandler_", 1, "handleCacheData mRequestingFlag is true!");
            return true;
        }
        mRequestingFlag.set(true);
        i.f438976a.e(com.tencent.mobileqq.zplan.event.impl.a.f333441a.e(e16), new a(e16));
        return true;
    }
}
