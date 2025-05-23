package r10;

import com.tencent.biz.pubaccount.weishi.util.bb;
import java.util.Map;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0002J\u0006\u0010\b\u001a\u00020\u0007J\u0006\u0010\n\u001a\u00020\tJ\u0006\u0010\u000b\u001a\u00020\tJ\u0006\u0010\r\u001a\u00020\f\u00a8\u0006\u0010"}, d2 = {"Lr10/a;", "", "", "key", "c", "default", "d", "", "f", "", "e", "b", "", "a", "<init>", "()V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f430463a = new a();

    a() {
    }

    private final String c(String key) {
        return d(key, "");
    }

    private final String d(String key, String r36) {
        String str;
        Map<String, String> e16 = com.tencent.biz.pubaccount.weishi.config.experiment.b.h().e();
        return (e16 == null || (str = e16.get(key)) == null) ? r36 : str;
    }

    public final long a() {
        return bb.Z(c("duration"), 2L) * 1000;
    }

    public final int b() {
        return bb.Y(c("type"), 0);
    }

    public final int e() {
        return bb.Y(c("show_time"), -1) * 1000;
    }

    public final boolean f() {
        return b() != 0;
    }
}
