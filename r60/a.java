package r60;

import com.tencent.biz.qqcircle.utils.k;
import com.tencent.mobileqq.qcircle.api.IQCircle571ABTestApi;
import com.tencent.mobileqq.qroute.QRoute;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\b\u001a\u00020\u0002J\u0006\u0010\t\u001a\u00020\u0002J\u0006\u0010\n\u001a\u00020\u0002\u00a8\u0006\r"}, d2 = {"Lr60/a;", "", "", "c", "d", "e", "", "f", "g", "a", "b", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f430818a = new a();

    a() {
    }

    private final boolean c() {
        return k.g("exp_xsj_searchpage_feed_exp", "exp_xsj_searchpage_feed_exp_B");
    }

    private final boolean d() {
        return k.g("exp_xsj_searchpage_feed_exp", "exp_xsj_searchpage_feed_exp_C");
    }

    private final boolean e() {
        return k.g("exp_xsj_searchpage_feed_exp", "exp_xsj_searchpage_feed_exp_D");
    }

    public final boolean a() {
        if (!d() && !e()) {
            return false;
        }
        return true;
    }

    public final boolean b() {
        return !e();
    }

    public final void f() {
        ((IQCircle571ABTestApi) QRoute.api(IQCircle571ABTestApi.class)).reportExperimentExport("exp_xsj_searchpage_feed_exp");
    }

    public final boolean g() {
        if (!c() && !d() && !e()) {
            return false;
        }
        return true;
    }
}
