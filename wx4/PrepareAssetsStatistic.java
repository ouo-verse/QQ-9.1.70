package wx4;

import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import wx4.d;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u001c\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u000b\u0012\u0006\u0010\u001d\u001a\u00020\t\u0012\u0006\u0010 \u001a\u00020\t\u0012\u0006\u0010$\u001a\u00020\t\u00a2\u0006\u0004\b%\u0010&J\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002J\t\u0010\u0005\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u0007\u001a\u00020\u0006H\u00d6\u0001J\u0013\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u0012\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0015\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\r\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\"\u0010\u0017\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\r\u001a\u0004\b\f\u0010\u000f\"\u0004\b\u0016\u0010\u0011R\"\u0010\u001d\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010 \u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0004\u0010\u0018\u001a\u0004\b\u001e\u0010\u001a\"\u0004\b\u001f\u0010\u001cR\"\u0010$\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\u0018\u001a\u0004\b\"\u0010\u001a\"\u0004\b#\u0010\u001c\u00a8\u0006'"}, d2 = {"Lwx4/e;", "", "", "", "e", "toString", "", "hashCode", "other", "", "equals", "", "a", "J", "b", "()J", "d", "(J)V", "totalTimeCost", "getNetReqTimeCost", "setNetReqTimeCost", "netReqTimeCost", "c", "downloadTimeCost", "Z", "getAnythingFromNet", "()Z", "setAnythingFromNet", "(Z)V", "anythingFromNet", "getAvatarOrStickerFormNet", "setAvatarOrStickerFormNet", "avatarOrStickerFormNet", "f", "getResourceFileFromNet", "setResourceFileFromNet", "resourceFileFromNet", "<init>", "(JJJZZZ)V", "record_debug"}, k = 1, mv = {1, 4, 2})
/* renamed from: wx4.e, reason: from toString */
/* loaded from: classes27.dex */
public final /* data */ class PrepareAssetsStatistic {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private long totalTimeCost;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private long netReqTimeCost;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private long downloadTimeCost;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean anythingFromNet;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean avatarOrStickerFormNet;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean resourceFileFromNet;

    public PrepareAssetsStatistic(long j3, long j16, long j17, boolean z16, boolean z17, boolean z18) {
        this.totalTimeCost = j3;
        this.netReqTimeCost = j16;
        this.downloadTimeCost = j17;
        this.anythingFromNet = z16;
        this.avatarOrStickerFormNet = z17;
        this.resourceFileFromNet = z18;
    }

    /* renamed from: a, reason: from getter */
    public final long getDownloadTimeCost() {
        return this.downloadTimeCost;
    }

    /* renamed from: b, reason: from getter */
    public final long getTotalTimeCost() {
        return this.totalTimeCost;
    }

    public final void c(long j3) {
        this.downloadTimeCost = j3;
    }

    public final void d(long j3) {
        this.totalTimeCost = j3;
    }

    @NotNull
    public final Map<String, String> e() {
        Map<String, String> mapOf;
        d.Companion companion = d.INSTANCE;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("assetsAnythingFromNet", String.valueOf(companion.b(this.anythingFromNet))), TuplesKt.to("assetsAvatarOrStickerFormNet", String.valueOf(companion.b(this.avatarOrStickerFormNet))), TuplesKt.to("assetsResourceFileFromNet", String.valueOf(companion.b(this.resourceFileFromNet))), TuplesKt.to("assetsTotalTimeCost", String.valueOf(this.totalTimeCost)), TuplesKt.to("assetsAvatarOrStickerTimeCost", String.valueOf(this.netReqTimeCost)), TuplesKt.to("assetsResourceFileTimeCost", String.valueOf(this.downloadTimeCost)));
        return mapOf;
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof PrepareAssetsStatistic) {
                PrepareAssetsStatistic prepareAssetsStatistic = (PrepareAssetsStatistic) other;
                if (this.totalTimeCost != prepareAssetsStatistic.totalTimeCost || this.netReqTimeCost != prepareAssetsStatistic.netReqTimeCost || this.downloadTimeCost != prepareAssetsStatistic.downloadTimeCost || this.anythingFromNet != prepareAssetsStatistic.anythingFromNet || this.avatarOrStickerFormNet != prepareAssetsStatistic.avatarOrStickerFormNet || this.resourceFileFromNet != prepareAssetsStatistic.resourceFileFromNet) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int a16 = ((((androidx.fragment.app.a.a(this.totalTimeCost) * 31) + androidx.fragment.app.a.a(this.netReqTimeCost)) * 31) + androidx.fragment.app.a.a(this.downloadTimeCost)) * 31;
        boolean z16 = this.anythingFromNet;
        int i3 = 1;
        int i16 = z16;
        if (z16 != 0) {
            i16 = 1;
        }
        int i17 = (a16 + i16) * 31;
        boolean z17 = this.avatarOrStickerFormNet;
        int i18 = z17;
        if (z17 != 0) {
            i18 = 1;
        }
        int i19 = (i17 + i18) * 31;
        boolean z18 = this.resourceFileFromNet;
        if (!z18) {
            i3 = z18 ? 1 : 0;
        }
        return i19 + i3;
    }

    @NotNull
    public String toString() {
        return "PrepareAssetsStatistic(totalTimeCost=" + this.totalTimeCost + ", netReqTimeCost=" + this.netReqTimeCost + ", downloadTimeCost=" + this.downloadTimeCost + ", anythingFromNet=" + this.anythingFromNet + ", avatarOrStickerFormNet=" + this.avatarOrStickerFormNet + ", resourceFileFromNet=" + this.resourceFileFromNet + ")";
    }

    public /* synthetic */ PrepareAssetsStatistic(long j3, long j16, long j17, boolean z16, boolean z17, boolean z18, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0L : j3, (i3 & 2) != 0 ? 0L : j16, (i3 & 4) != 0 ? 0L : j17, z16, z17, z18);
    }
}
