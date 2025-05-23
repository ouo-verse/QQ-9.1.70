package tk2;

import com.tencent.qqlive.module.videoreport.constants.EventKey;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001:\u0003\t\u000f\u0011B'\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u0012\u0006\u0010\u001b\u001a\u00020\u0018\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0013\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0017\u001a\u00020\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0015\u001a\u0004\b\t\u0010\u0016R\u0017\u0010\u001b\u001a\u00020\u00188\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0019\u001a\u0004\b\u000f\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Ltk2/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "d", "()I", "skinId", "Ltk2/a$c;", "b", "Ltk2/a$c;", "c", "()Ltk2/a$c;", "info", "Ltk2/a$a;", "Ltk2/a$a;", "()Ltk2/a$a;", EventKey.ACT, "Ltk2/a$b;", "Ltk2/a$b;", "()Ltk2/a$b;", "anim", "<init>", "(ILtk2/a$c;Ltk2/a$a;Ltk2/a$b;)V", "qwallet-api_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: tk2.a, reason: from toString */
/* loaded from: classes16.dex */
public final /* data */ class FestivalHbData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int skinId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final BaseInfo info;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Extra act;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final Anim anim;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R$\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR$\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\n\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR$\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\n\u001a\u0004\b\t\u0010\f\"\u0004\b\u0013\u0010\u000e\u00a8\u0006\u0017"}, d2 = {"Ltk2/a$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "setActivityName", "(Ljava/lang/String;)V", "activityName", "c", "setActivityUrl", "activityUrl", "setActivityLogoUrl", "activityLogoUrl", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "qwallet-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: tk2.a$a, reason: collision with other inner class name and from toString */
    /* loaded from: classes16.dex */
    public static final /* data */ class Extra {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private String activityName;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private String activityUrl;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private String activityLogo;

        public Extra(@Nullable String str, @Nullable String str2, @Nullable String str3) {
            this.activityName = str;
            this.activityUrl = str2;
            this.activityLogo = str3;
        }

        @Nullable
        /* renamed from: a, reason: from getter */
        public final String getActivityLogo() {
            return this.activityLogo;
        }

        @Nullable
        /* renamed from: b, reason: from getter */
        public final String getActivityName() {
            return this.activityName;
        }

        @Nullable
        /* renamed from: c, reason: from getter */
        public final String getActivityUrl() {
            return this.activityUrl;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Extra)) {
                return false;
            }
            Extra extra = (Extra) other;
            if (Intrinsics.areEqual(this.activityName, extra.activityName) && Intrinsics.areEqual(this.activityUrl, extra.activityUrl) && Intrinsics.areEqual(this.activityLogo, extra.activityLogo)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int hashCode;
            int hashCode2;
            String str = this.activityName;
            int i3 = 0;
            if (str == null) {
                hashCode = 0;
            } else {
                hashCode = str.hashCode();
            }
            int i16 = hashCode * 31;
            String str2 = this.activityUrl;
            if (str2 == null) {
                hashCode2 = 0;
            } else {
                hashCode2 = str2.hashCode();
            }
            int i17 = (i16 + hashCode2) * 31;
            String str3 = this.activityLogo;
            if (str3 != null) {
                i3 = str3.hashCode();
            }
            return i17 + i3;
        }

        @NotNull
        public String toString() {
            return "Extra(activityName=" + this.activityName + ", activityUrl=" + this.activityUrl + ", activityLogo=" + this.activityLogo + ')';
        }

        public /* synthetic */ Extra(String str, String str2, String str3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i3 & 2) != 0 ? null : str2, (i3 & 4) != 0 ? null : str3);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0018\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0019\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\fR\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\n\u001a\u0004\b\u0012\u0010\fR\u001a\u0010\u0015\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u0012\u0010\n\u001a\u0004\b\u0014\u0010\fR\u001a\u0010\u0017\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0016\u0010\fR\u001a\u0010\u0019\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\u0018\u0010\fR\u001a\u0010\u001a\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u0016\u0010\n\u001a\u0004\b\t\u0010\fR\u001a\u0010\u001b\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u0018\u0010\n\u001a\u0004\b\u000e\u0010\fR\u001a\u0010\u001c\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u0011\u0010\f\u00a8\u0006\u001f"}, d2 = {"Ltk2/a$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "f", "()Ljava/lang/String;", "bgUrl", "b", "i", "fgUrl", "c", "d", "aioUrl", "e", "bgSuffix", "g", "fgEnterSuffix", h.F, "fgLoopSuffix", "aioAnimSuffix", "aioBgSuffix", "aioOpenedBgSuffix", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "qwallet-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: tk2.a$b, reason: from toString */
    /* loaded from: classes16.dex */
    public static final /* data */ class Anim {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final String bgUrl;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final String fgUrl;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final String aioUrl;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String bgSuffix = "festival_bg.pag";

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String fgEnterSuffix = "festival_fg_enter.pag";

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String fgLoopSuffix = "festival_fg_loop.pag";

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String aioAnimSuffix = "festival_aio.pag";

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String aioBgSuffix = "festival_aio_bg.png";

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String aioOpenedBgSuffix = "festival_aio_opened_bg.png";

        public Anim(@Nullable String str, @Nullable String str2, @Nullable String str3) {
            this.bgUrl = str;
            this.fgUrl = str2;
            this.aioUrl = str3;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final String getAioAnimSuffix() {
            return this.aioAnimSuffix;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final String getAioBgSuffix() {
            return this.aioBgSuffix;
        }

        @NotNull
        /* renamed from: c, reason: from getter */
        public final String getAioOpenedBgSuffix() {
            return this.aioOpenedBgSuffix;
        }

        @Nullable
        /* renamed from: d, reason: from getter */
        public final String getAioUrl() {
            return this.aioUrl;
        }

        @NotNull
        /* renamed from: e, reason: from getter */
        public final String getBgSuffix() {
            return this.bgSuffix;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Anim)) {
                return false;
            }
            Anim anim = (Anim) other;
            if (Intrinsics.areEqual(this.bgUrl, anim.bgUrl) && Intrinsics.areEqual(this.fgUrl, anim.fgUrl) && Intrinsics.areEqual(this.aioUrl, anim.aioUrl)) {
                return true;
            }
            return false;
        }

        @Nullable
        /* renamed from: f, reason: from getter */
        public final String getBgUrl() {
            return this.bgUrl;
        }

        @NotNull
        /* renamed from: g, reason: from getter */
        public final String getFgEnterSuffix() {
            return this.fgEnterSuffix;
        }

        @NotNull
        /* renamed from: h, reason: from getter */
        public final String getFgLoopSuffix() {
            return this.fgLoopSuffix;
        }

        public int hashCode() {
            int hashCode;
            int hashCode2;
            String str = this.bgUrl;
            int i3 = 0;
            if (str == null) {
                hashCode = 0;
            } else {
                hashCode = str.hashCode();
            }
            int i16 = hashCode * 31;
            String str2 = this.fgUrl;
            if (str2 == null) {
                hashCode2 = 0;
            } else {
                hashCode2 = str2.hashCode();
            }
            int i17 = (i16 + hashCode2) * 31;
            String str3 = this.aioUrl;
            if (str3 != null) {
                i3 = str3.hashCode();
            }
            return i17 + i3;
        }

        @Nullable
        /* renamed from: i, reason: from getter */
        public final String getFgUrl() {
            return this.fgUrl;
        }

        @NotNull
        public String toString() {
            return "Anim(bgUrl='" + this.bgUrl + "', fgUrl='" + this.fgUrl + "', aioUrl='" + this.aioUrl + "')";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0004\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0019\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0011\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\t\u0010\u0010R\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\u000e\u0010\f\u00a8\u0006\u0015"}, d2 = {"Ltk2/a$c;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "wish", "b", "I", "()I", "amount", "tailText", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "qwallet-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: tk2.a$c, reason: from toString */
    /* loaded from: classes16.dex */
    public static final /* data */ class BaseInfo {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final String wish;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final int amount;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final String tailText;

        public BaseInfo(@Nullable String str, int i3, @Nullable String str2) {
            this.wish = str;
            this.amount = i3;
            this.tailText = str2;
        }

        /* renamed from: a, reason: from getter */
        public final int getAmount() {
            return this.amount;
        }

        @Nullable
        /* renamed from: b, reason: from getter */
        public final String getTailText() {
            return this.tailText;
        }

        @Nullable
        /* renamed from: c, reason: from getter */
        public final String getWish() {
            return this.wish;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof BaseInfo)) {
                return false;
            }
            BaseInfo baseInfo = (BaseInfo) other;
            if (Intrinsics.areEqual(this.wish, baseInfo.wish) && this.amount == baseInfo.amount && Intrinsics.areEqual(this.tailText, baseInfo.tailText)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int hashCode;
            String str = this.wish;
            int i3 = 0;
            if (str == null) {
                hashCode = 0;
            } else {
                hashCode = str.hashCode();
            }
            int i16 = ((hashCode * 31) + this.amount) * 31;
            String str2 = this.tailText;
            if (str2 != null) {
                i3 = str2.hashCode();
            }
            return i16 + i3;
        }

        @NotNull
        public String toString() {
            return "BaseInfo(wish='" + this.wish + "', amount=" + this.amount + ", tailText='" + this.tailText + "')";
        }
    }

    public FestivalHbData(int i3, @NotNull BaseInfo info, @NotNull Extra act, @NotNull Anim anim) {
        Intrinsics.checkNotNullParameter(info, "info");
        Intrinsics.checkNotNullParameter(act, "act");
        Intrinsics.checkNotNullParameter(anim, "anim");
        this.skinId = i3;
        this.info = info;
        this.act = act;
        this.anim = anim;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final Extra getAct() {
        return this.act;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final Anim getAnim() {
        return this.anim;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final BaseInfo getInfo() {
        return this.info;
    }

    /* renamed from: d, reason: from getter */
    public final int getSkinId() {
        return this.skinId;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FestivalHbData)) {
            return false;
        }
        FestivalHbData festivalHbData = (FestivalHbData) other;
        if (this.skinId == festivalHbData.skinId && Intrinsics.areEqual(this.info, festivalHbData.info) && Intrinsics.areEqual(this.act, festivalHbData.act) && Intrinsics.areEqual(this.anim, festivalHbData.anim)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((this.skinId * 31) + this.info.hashCode()) * 31) + this.act.hashCode()) * 31) + this.anim.hashCode();
    }

    @NotNull
    public String toString() {
        return "FestivalHbData(skinId='" + this.skinId + "', info=" + this.info + ", anim=" + this.anim + ')';
    }
}
