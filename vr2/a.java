package vr2;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopUnitedConfigApi;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0004\u00a8\u0006\b"}, d2 = {"Lvr2/a;", "", "", "a", "", "b", "<init>", "()V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f443197a = new a();

    a() {
    }

    public final int a() {
        return ((ITroopUnitedConfigApi) QRoute.api(ITroopUnitedConfigApi.class)).getInt("105422", "maxWordCount", 100);
    }

    public final boolean b() {
        return ((ITroopUnitedConfigApi) QRoute.api(ITroopUnitedConfigApi.class)).getBoolean("105422", "aioReqLimit", false);
    }
}
