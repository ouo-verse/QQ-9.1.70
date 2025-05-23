package qe3;

import android.app.Activity;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mobileqq.zplan.authorize.impl.manager.CheckPhoneManager;
import gw4.g;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import se3.d;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ&\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004J\u0006\u0010\t\u001a\u00020\u0006R\u0016\u0010\u000b\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lqe3/a;", "", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lkotlin/Function1;", "", "", "callback", "c", "b", "Z", "isShowedDialog", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f428883a = new a();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static boolean isShowedDialog;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"qe3/a$a", "Lcom/tencent/mobileqq/zplan/authorize/impl/manager/CheckPhoneManager$a;", "", "result", "", "b", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: qe3.a$a, reason: collision with other inner class name */
    /* loaded from: classes36.dex */
    public static final class C11072a implements CheckPhoneManager.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Activity f428885a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function1<Boolean, Unit> f428886b;

        /* JADX WARN: Multi-variable type inference failed */
        C11072a(Activity activity, Function1<? super Boolean, Unit> function1) {
            this.f428885a = activity;
            this.f428886b = function1;
        }

        @Override // com.tencent.mobileqq.zplan.authorize.impl.manager.CheckPhoneManager.a
        public void a(boolean z16, boolean z17, String str) {
            CheckPhoneManager.a.C9150a.b(this, z16, z17, str);
        }

        @Override // com.tencent.mobileqq.zplan.authorize.impl.manager.CheckPhoneManager.a
        public void b(boolean result) {
            g l3 = CheckPhoneManager.f331491a.l();
            if (result && l3 != null) {
                new d(this.f428885a).k(l3);
                a.isShowedDialog = true;
                Function1<Boolean, Unit> function1 = this.f428886b;
                if (function1 != null) {
                    function1.invoke(Boolean.TRUE);
                    return;
                }
                return;
            }
            Function1<Boolean, Unit> function12 = this.f428886b;
            if (function12 != null) {
                function12.invoke(Boolean.FALSE);
            }
        }
    }

    a() {
    }

    public final void b() {
        g l3 = CheckPhoneManager.f331491a.l();
        if (l3 == null || l3.f403475a) {
            isShowedDialog = false;
        }
    }

    public final void c(Activity activity, Function1<? super Boolean, Unit> callback) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (!isShowedDialog) {
            CheckPhoneManager.f331491a.g(1, CheckPhoneManager.EntryType.AVATAR, new C11072a(activity, callback));
        } else if (callback != null) {
            callback.invoke(Boolean.FALSE);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void d(a aVar, Activity activity, Function1 function1, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            function1 = null;
        }
        aVar.c(activity, function1);
    }
}
