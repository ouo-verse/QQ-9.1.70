package q03;

import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\f\u00a2\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\b\u001a\u00020\u0002H\u0016J\b\u0010\t\u001a\u00020\u0002H\u0016J\b\u0010\n\u001a\u00020\u0002H\u0016J\b\u0010\u000b\u001a\u00020\u0002H\u0016R\u0017\u0010\u0010\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\r\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lq03/l;", "Lq03/f;", "", tl.h.F, "e", "a", "", "f", "g", "d", "c", "b", "Lxa1/f;", "Lxa1/f;", "getConfig", "()Lxa1/f;", DownloadInfo.spKey_Config, "<init>", "(Lxa1/f;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class l implements f {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final xa1.f config;

    public l(xa1.f config) {
        Intrinsics.checkNotNullParameter(config, "config");
        this.config = config;
    }

    @Override // q03.f
    public String a() {
        return this.config.getDesTitleDefault();
    }

    @Override // q03.f
    public String b() {
        return this.config.toString();
    }

    @Override // q03.f
    public String c() {
        return this.config.getTipsIconUrl();
    }

    @Override // q03.f
    public String d() {
        return this.config.getTipsDefault();
    }

    @Override // q03.f
    public String e() {
        return this.config.getDesTitleNeedUpdate();
    }

    @Override // q03.f
    public boolean f() {
        return this.config.getCanShowTips();
    }

    @Override // q03.f
    public String g() {
        return this.config.getTipsDownloading();
    }

    @Override // q03.f
    public String h() {
        return this.config.getDesTitleNeedDownload();
    }
}
