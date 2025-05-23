package q03;

import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016R\u0017\u0010\u000b\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\b\u001a\u0004\b\t\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lq03/g;", "Lq03/a;", "", "c", "", "b", "a", "Lxa1/c;", "Lxa1/c;", "getConfig", "()Lxa1/c;", DownloadInfo.spKey_Config, "<init>", "(Lxa1/c;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class g implements a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final xa1.c config;

    public g(xa1.c config) {
        Intrinsics.checkNotNullParameter(config, "config");
        this.config = config;
    }

    @Override // q03.a
    public String a() {
        return this.config.getQZoneBubbleText();
    }

    @Override // q03.a
    public int b() {
        return this.config.getPrivacyDialogShowLimitDay();
    }

    @Override // q03.a
    public String c() {
        return this.config.getHomePageUrl();
    }
}
