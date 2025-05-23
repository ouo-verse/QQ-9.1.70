package t52;

import com.qzone.module.covercomponent.model.CoverDBCacheData;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qqmini.miniapp.widget.media.live.TXJSAdapterConstants;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0011\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u001e\b\u0086\b\u0018\u00002\u00020\u0001B\u008d\u0001\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0002\u0012\u0010\b\u0002\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0007\u0012\b\b\u0002\u0010$\u001a\u00020\u001e\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010,\u001a\u00020\u0007\u0012\b\b\u0002\u0010/\u001a\u00020\u0007\u0012\b\b\u0002\u00101\u001a\u00020\u0007\u0012\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u00107\u001a\u00020\u0004\u00a2\u0006\u0004\b8\u00109B\u001b\b\u0016\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b8\u0010:B+\b\u0016\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002\u0012\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0013\u00a2\u0006\u0004\b8\u0010;J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001f\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00138\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0019\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u000f\u001a\u0004\b\u000e\u0010\u0011R\"\u0010\u001a\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010$\u001a\u00020\u001e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b\t\u0010!\"\u0004\b\"\u0010#R$\u0010(\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\"\u0010\u000f\u001a\u0004\b%\u0010\u0011\"\u0004\b&\u0010'R\"\u0010,\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b)\u0010\u0019\u001a\u0004\b*\u0010\u001b\"\u0004\b+\u0010\u001dR\"\u0010/\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b-\u0010\u0019\u001a\u0004\b.\u0010\u001b\"\u0004\b\u001f\u0010\u001dR\"\u00101\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b+\u0010\u0019\u001a\u0004\b0\u0010\u001b\"\u0004\b-\u0010\u001dR$\u00103\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b&\u0010\u000f\u001a\u0004\b2\u0010\u0011\"\u0004\b)\u0010'R\"\u00107\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\n\u001a\u0004\b4\u0010\f\"\u0004\b5\u00106\u00a8\u0006<"}, d2 = {"Lt52/f;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "c", "()I", TXJSAdapterConstants.PLAYER_KEY_PLAY_TYPE, "b", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "vid", "", "[Ljava/lang/String;", "d", "()[Ljava/lang/String;", CoverDBCacheData.URLS, "pid", "Z", "isPreload", "()Z", "l", "(Z)V", "", "f", "J", "()J", "g", "(J)V", "duration", "getPlayMode", "k", "(Ljava/lang/String;)V", "playMode", h.F, "getKeepLastframe", "j", "keepLastframe", "i", "getCoverFrame", "coverFrame", "getHwCodec", "hwCodec", "getHwBackupUrls", "hwBackupUrls", "getPreloadDuration", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(I)V", "preloadDuration", "<init>", "(ILjava/lang/String;[Ljava/lang/String;Ljava/lang/String;ZJLjava/lang/String;ZZZLjava/lang/String;I)V", "(ILjava/lang/String;)V", "(ILjava/lang/String;[Ljava/lang/String;)V", "kandian-api_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: t52.f, reason: from toString */
/* loaded from: classes15.dex */
public final /* data */ class PlayerVideoInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int playType;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String vid;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String[] urls;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String pid;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean isPreload;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private long duration;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private String playMode;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean keepLastframe;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean coverFrame;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean hwCodec;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private String hwBackupUrls;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata and from toString */
    private int preloadDuration;

    public PlayerVideoInfo(int i3, @Nullable String str, @Nullable String[] strArr, @Nullable String str2, boolean z16, long j3, @Nullable String str3, boolean z17, boolean z18, boolean z19, @Nullable String str4, int i16) {
        this.playType = i3;
        this.vid = str;
        this.urls = strArr;
        this.pid = str2;
        this.isPreload = z16;
        this.duration = j3;
        this.playMode = str3;
        this.keepLastframe = z17;
        this.coverFrame = z18;
        this.hwCodec = z19;
        this.hwBackupUrls = str4;
        this.preloadDuration = i16;
    }

    /* renamed from: a, reason: from getter */
    public final long getDuration() {
        return this.duration;
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final String getPid() {
        return this.pid;
    }

    /* renamed from: c, reason: from getter */
    public final int getPlayType() {
        return this.playType;
    }

    @Nullable
    /* renamed from: d, reason: from getter */
    public final String[] getUrls() {
        return this.urls;
    }

    @Nullable
    /* renamed from: e, reason: from getter */
    public final String getVid() {
        return this.vid;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PlayerVideoInfo)) {
            return false;
        }
        PlayerVideoInfo playerVideoInfo = (PlayerVideoInfo) other;
        if (this.playType == playerVideoInfo.playType && Intrinsics.areEqual(this.vid, playerVideoInfo.vid) && Intrinsics.areEqual(this.urls, playerVideoInfo.urls) && Intrinsics.areEqual(this.pid, playerVideoInfo.pid) && this.isPreload == playerVideoInfo.isPreload && this.duration == playerVideoInfo.duration && Intrinsics.areEqual(this.playMode, playerVideoInfo.playMode) && this.keepLastframe == playerVideoInfo.keepLastframe && this.coverFrame == playerVideoInfo.coverFrame && this.hwCodec == playerVideoInfo.hwCodec && Intrinsics.areEqual(this.hwBackupUrls, playerVideoInfo.hwBackupUrls) && this.preloadDuration == playerVideoInfo.preloadDuration) {
            return true;
        }
        return false;
    }

    public final void f(boolean z16) {
        this.coverFrame = z16;
    }

    public final void g(long j3) {
        this.duration = j3;
    }

    public final void h(@Nullable String str) {
        this.hwBackupUrls = str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        int i3 = this.playType * 31;
        String str = this.vid;
        int i16 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int i17 = (i3 + hashCode) * 31;
        String[] strArr = this.urls;
        if (strArr == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = Arrays.hashCode(strArr);
        }
        int i18 = (i17 + hashCode2) * 31;
        String str2 = this.pid;
        if (str2 == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = str2.hashCode();
        }
        int i19 = (i18 + hashCode3) * 31;
        boolean z16 = this.isPreload;
        int i26 = 1;
        int i27 = z16;
        if (z16 != 0) {
            i27 = 1;
        }
        int a16 = (((i19 + i27) * 31) + androidx.fragment.app.a.a(this.duration)) * 31;
        String str3 = this.playMode;
        if (str3 == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = str3.hashCode();
        }
        int i28 = (a16 + hashCode4) * 31;
        boolean z17 = this.keepLastframe;
        int i29 = z17;
        if (z17 != 0) {
            i29 = 1;
        }
        int i36 = (i28 + i29) * 31;
        boolean z18 = this.coverFrame;
        int i37 = z18;
        if (z18 != 0) {
            i37 = 1;
        }
        int i38 = (i36 + i37) * 31;
        boolean z19 = this.hwCodec;
        if (!z19) {
            i26 = z19 ? 1 : 0;
        }
        int i39 = (i38 + i26) * 31;
        String str4 = this.hwBackupUrls;
        if (str4 != null) {
            i16 = str4.hashCode();
        }
        return ((i39 + i16) * 31) + this.preloadDuration;
    }

    public final void i(boolean z16) {
        this.hwCodec = z16;
    }

    public final void j(boolean z16) {
        this.keepLastframe = z16;
    }

    public final void k(@Nullable String str) {
        this.playMode = str;
    }

    public final void l(boolean z16) {
        this.isPreload = z16;
    }

    public final void m(int i3) {
        this.preloadDuration = i3;
    }

    @NotNull
    public String toString() {
        return "PlayerVideoInfo(playType=" + this.playType + ", vid=" + this.vid + ", urls=" + Arrays.toString(this.urls) + ", pid=" + this.pid + ", isPreload=" + this.isPreload + ", duration=" + this.duration + ", playMode=" + this.playMode + ", keepLastframe=" + this.keepLastframe + ", coverFrame=" + this.coverFrame + ", hwCodec=" + this.hwCodec + ", hwBackupUrls=" + this.hwBackupUrls + ", preloadDuration=" + this.preloadDuration + ')';
    }

    public /* synthetic */ PlayerVideoInfo(int i3, String str, String[] strArr, String str2, boolean z16, long j3, String str3, boolean z17, boolean z18, boolean z19, String str4, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, (i17 & 2) != 0 ? null : str, (i17 & 4) != 0 ? null : strArr, (i17 & 8) != 0 ? null : str2, (i17 & 16) != 0 ? false : z16, (i17 & 32) != 0 ? 0L : j3, (i17 & 64) != 0 ? null : str3, (i17 & 128) != 0 ? false : z17, (i17 & 256) != 0 ? false : z18, (i17 & 512) != 0 ? true : z19, (i17 & 1024) == 0 ? str4 : null, (i17 & 2048) == 0 ? i16 : 0);
    }

    public PlayerVideoInfo(int i3, @Nullable String str) {
        this(i3, str, null);
    }

    public PlayerVideoInfo(int i3, @Nullable String str, @Nullable String[] strArr) {
        this(i3, str, strArr, null, false, 0L, null, false, false, false, null, 0, 4080, null);
    }
}
