package q03;

import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import xa1.VasSmallHomeCallbackConfig;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0004\u00a2\u0006\u0004\b\t\u0010\nJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0017\u0010\b\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u000b"}, d2 = {"Lq03/j;", "Lq03/d;", "", "a", "Lxa1/b;", "Lxa1/b;", "getConfig", "()Lxa1/b;", DownloadInfo.spKey_Config, "<init>", "(Lxa1/b;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class j implements d {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final VasSmallHomeCallbackConfig config;

    public j(VasSmallHomeCallbackConfig config) {
        Intrinsics.checkNotNullParameter(config, "config");
        this.config = config;
    }

    @Override // q03.d
    public int a() {
        return this.config.getDayLimit();
    }
}
