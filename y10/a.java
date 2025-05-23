package y10;

import com.tencent.biz.pubaccount.weishi.config.experiment.b;
import com.tencent.biz.pubaccount.weishi.util.bb;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0006\u001a\u00020\u0005J\u0006\u0010\u0007\u001a\u00020\u0005J\u0006\u0010\b\u001a\u00020\u0002J\u0006\u0010\n\u001a\u00020\t\u00a8\u0006\r"}, d2 = {"Ly10/a;", "", "", "key", "c", "", "a", "b", "e", "", "d", "<init>", "()V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f449262a = new a();

    a() {
    }

    private final String c(String key) {
        String str;
        Map<String, String> A = b.h().A();
        return (A == null || (str = A.get(key)) == null) ? "" : str;
    }

    public final boolean a() {
        return Intrinsics.areEqual("1", c("hevc_hw_enable"));
    }

    public final boolean b() {
        return Intrinsics.areEqual("1", c("hevc_sw_enable"));
    }

    public final int d() {
        return bb.Y(c("video_spec_selected_type"), 0);
    }

    public final String e() {
        return c("video_spec_priority_chain");
    }
}
