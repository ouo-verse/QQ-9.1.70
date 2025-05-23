package q03;

import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0011\u001a\u00020\r\u00a2\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\t\u001a\u00020\u0002H\u0016J\b\u0010\n\u001a\u00020\u0002H\u0016J\b\u0010\u000b\u001a\u00020\u0004H\u0016J\b\u0010\f\u001a\u00020\u0002H\u0016R\u0017\u0010\u0011\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lq03/k;", "Lq03/e;", "", tl.h.F, "", "e", "a", "", "d", "c", "f", "b", "g", "Lxa1/e;", "Lxa1/e;", "i", "()Lxa1/e;", DownloadInfo.spKey_Config, "<init>", "(Lxa1/e;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class k implements e {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final xa1.e config;

    public k(xa1.e config) {
        Intrinsics.checkNotNullParameter(config, "config");
        this.config = config;
    }

    @Override // q03.e
    public boolean a() {
        return this.config.getUseSticker();
    }

    @Override // q03.e
    public boolean b() {
        return this.config.getCanCodecReUse();
    }

    @Override // q03.e
    public int c() {
        return this.config.getAaLevel();
    }

    @Override // q03.e
    public long d() {
        return this.config.getMp4FileSizeLimit();
    }

    @Override // q03.e
    public boolean e() {
        return this.config.getIpConnect();
    }

    @Override // q03.e
    public int f() {
        return this.config.getAaType();
    }

    @Override // q03.e
    public int g() {
        return this.config.getSoftEncodeMode();
    }

    @Override // q03.e
    public int h() {
        return this.config.getEncodeType();
    }

    /* renamed from: i, reason: from getter */
    public final xa1.e getConfig() {
        return this.config;
    }
}
