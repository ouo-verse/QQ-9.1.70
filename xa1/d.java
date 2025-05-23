package xa1;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b/\u00100R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u0010\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u0003\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0017\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0012\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u001e\u001a\u00020\u00188\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0019\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010%\u001a\u00020\u001f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b \u0010\"\"\u0004\b#\u0010$R\"\u0010,\u001a\u00020&8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b\u000b\u0010)\"\u0004\b*\u0010+R\"\u0010.\u001a\u00020\u001f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010!\u001a\u0004\b'\u0010\"\"\u0004\b-\u0010$\u00a8\u00061"}, d2 = {"Lxa1/d;", "", "Lxa1/f;", "a", "Lxa1/f;", "g", "()Lxa1/f;", "l", "(Lxa1/f;)V", "woTransitPageConfig", "Lxa1/a;", "b", "Lxa1/a;", "()Lxa1/a;", h.F, "(Lxa1/a;)V", "badgeBrandRedDotConfig", "Lxa1/b;", "c", "Lxa1/b;", "()Lxa1/b;", "i", "(Lxa1/b;)V", "smallHomeCallbackConfig", "Lxa1/e;", "d", "Lxa1/e;", "()Lxa1/e;", "setSquareConfig", "(Lxa1/e;)V", "squareConfig", "", "e", "Ljava/lang/String;", "()Ljava/lang/String;", "j", "(Ljava/lang/String;)V", "squareMsgBoxConfigJson", "Lxa1/c;", "f", "Lxa1/c;", "()Lxa1/c;", "setQZoneFeedsConfig", "(Lxa1/c;)V", "qZoneFeedsConfig", "k", "squarePerformanceConfigJson", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private f woTransitPageConfig = new f(null, null, null, null, false, null, null, null, 255, null);

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private VasBadgeBrandRedDotConfig badgeBrandRedDotConfig = new VasBadgeBrandRedDotConfig(0, 1, null);

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private VasSmallHomeCallbackConfig smallHomeCallbackConfig = new VasSmallHomeCallbackConfig(0, 1, null);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private e squareConfig = new e(0, false, false, false, false, 0, 0, 0, false, 0, false, 2047, null);

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String squareMsgBoxConfigJson = "";

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private c qZoneFeedsConfig = new c(null, 0, null, 7, null);

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String squarePerformanceConfigJson = "";

    @NotNull
    /* renamed from: a, reason: from getter */
    public final VasBadgeBrandRedDotConfig getBadgeBrandRedDotConfig() {
        return this.badgeBrandRedDotConfig;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final c getQZoneFeedsConfig() {
        return this.qZoneFeedsConfig;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final VasSmallHomeCallbackConfig getSmallHomeCallbackConfig() {
        return this.smallHomeCallbackConfig;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final e getSquareConfig() {
        return this.squareConfig;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final String getSquareMsgBoxConfigJson() {
        return this.squareMsgBoxConfigJson;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final String getSquarePerformanceConfigJson() {
        return this.squarePerformanceConfigJson;
    }

    @NotNull
    /* renamed from: g, reason: from getter */
    public final f getWoTransitPageConfig() {
        return this.woTransitPageConfig;
    }

    public final void h(@NotNull VasBadgeBrandRedDotConfig vasBadgeBrandRedDotConfig) {
        Intrinsics.checkNotNullParameter(vasBadgeBrandRedDotConfig, "<set-?>");
        this.badgeBrandRedDotConfig = vasBadgeBrandRedDotConfig;
    }

    public final void i(@NotNull VasSmallHomeCallbackConfig vasSmallHomeCallbackConfig) {
        Intrinsics.checkNotNullParameter(vasSmallHomeCallbackConfig, "<set-?>");
        this.smallHomeCallbackConfig = vasSmallHomeCallbackConfig;
    }

    public final void j(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.squareMsgBoxConfigJson = str;
    }

    public final void k(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.squarePerformanceConfigJson = str;
    }

    public final void l(@NotNull f fVar) {
        Intrinsics.checkNotNullParameter(fVar, "<set-?>");
        this.woTransitPageConfig = fVar;
    }
}
