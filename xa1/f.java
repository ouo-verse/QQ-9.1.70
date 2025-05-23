package xa1;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\r\u0018\u0000  2\u00020\u0001:\u0001\u0006Bg\u0012\u0018\b\u0002\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u0004j\b\u0012\u0004\u0012\u00020\u0002`\u0005\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0014\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0002\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R'\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u0004j\b\u0012\u0004\u0012\u00020\u0002`\u00058\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u0017\u0010\u000f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0012\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\f\u001a\u0004\b\u0011\u0010\u000eR\u0017\u0010\u0013\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\f\u001a\u0004\b\u0010\u0010\u000eR\u0017\u0010\u0017\u001a\u00020\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0015\u001a\u0004\b\u000b\u0010\u0016R\u0017\u0010\u001a\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\f\u001a\u0004\b\u0019\u0010\u000eR\u0017\u0010\u001b\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\f\u001a\u0004\b\u0018\u0010\u000eR\u0017\u0010\u001d\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\f\u001a\u0004\b\u001c\u0010\u000e\u00a8\u0006!"}, d2 = {"Lxa1/f;", "", "", "toString", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "a", "Ljava/util/ArrayList;", "getBackgroundImageUrls", "()Ljava/util/ArrayList;", "backgroundImageUrls", "b", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "desTitleNeedDownload", "c", "e", "desTitleNeedUpdate", "desTitleDefault", "", "Z", "()Z", "canShowTips", "f", "g", "tipsDownloading", "tipsDefault", h.F, "tipsIconUrl", "<init>", "(Ljava/util/ArrayList;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "i", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class f {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: j, reason: collision with root package name */
    @NotNull
    private static final ArrayList<String> f447555j;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<String> backgroundImageUrls;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String desTitleNeedDownload;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String desTitleNeedUpdate;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String desTitleDefault;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final boolean canShowTips;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String tipsDownloading;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String tipsDefault;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String tipsIconUrl;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001c\u0010\u001dR'\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00038\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u00038\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\nR\u0014\u0010\f\u001a\u00020\u00038\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\nR\u0014\u0010\r\u001a\u00020\u00038\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\nR\u0014\u0010\u000e\u001a\u00020\u00038\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\nR\u0014\u0010\u000f\u001a\u00020\u00038\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\nR\u0014\u0010\u0010\u001a\u00020\u00038\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\nR\u0014\u0010\u0011\u001a\u00020\u00038\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\nR\u0014\u0010\u0012\u001a\u00020\u00038\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\nR\u0014\u0010\u0013\u001a\u00020\u00038\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\nR\u0014\u0010\u0015\u001a\u00020\u00148\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0018\u001a\u00020\u00178\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\u00038\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\nR\u0014\u0010\u001b\u001a\u00020\u00038\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\n\u00a8\u0006\u001e"}, d2 = {"Lxa1/f$a;", "", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "URL_DEFAULT", "Ljava/util/ArrayList;", "a", "()Ljava/util/ArrayList;", "DES_DEFAULT", "Ljava/lang/String;", "KEY_BACKGROUND", "KEY_DES_DEFAULT", "KEY_DES_DOWNLOAD", "KEY_DES_UPDATE", "KEY_SHOW_TIPS", "KEY_TIPS_DEFAULT", "KEY_TIPS_DOWNLOADING", "KEY_TIPS_ICON", "MAIN_TAG", "", "SHOW_TIPS_DEFAULT", "Z", "", "SHOW_TIPS_VALUE_DEFAULT", "I", "TIPS_DEFAULT", "TIPS_ICON_DEFAULT", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: xa1.f$a, reason: from kotlin metadata */
    /* loaded from: classes10.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ArrayList<String> a() {
            return f.f447555j;
        }

        Companion() {
        }
    }

    static {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("https://imgcache.gtimg.cn/mie/act/img/public/202203/m1646966291_Group-37.jpg");
        arrayList.add("https://imgcache.gtimg.cn/mie/act/img/public/202203/m1646966276_Group-36.jpg");
        arrayList.add("https://imgcache.gtimg.cn/mie/act/img/public/202203/m1646966261_Group-35.jpg");
        arrayList.add("https://imgcache.gtimg.cn/mie/act/img/public/202203/m1646966247_Group-34.jpg");
        arrayList.add("https://imgcache.gtimg.cn/mie/act/img/public/202203/m1646966232_Group-33.jpg");
        arrayList.add("https://imgcache.gtimg.cn/mie/act/img/public/202203/m1646966306_Group-32.jpg");
        f447555j = arrayList;
    }

    public f(@NotNull ArrayList<String> backgroundImageUrls, @NotNull String desTitleNeedDownload, @NotNull String desTitleNeedUpdate, @NotNull String desTitleDefault, boolean z16, @NotNull String tipsDownloading, @NotNull String tipsDefault, @NotNull String tipsIconUrl) {
        Intrinsics.checkNotNullParameter(backgroundImageUrls, "backgroundImageUrls");
        Intrinsics.checkNotNullParameter(desTitleNeedDownload, "desTitleNeedDownload");
        Intrinsics.checkNotNullParameter(desTitleNeedUpdate, "desTitleNeedUpdate");
        Intrinsics.checkNotNullParameter(desTitleDefault, "desTitleDefault");
        Intrinsics.checkNotNullParameter(tipsDownloading, "tipsDownloading");
        Intrinsics.checkNotNullParameter(tipsDefault, "tipsDefault");
        Intrinsics.checkNotNullParameter(tipsIconUrl, "tipsIconUrl");
        this.backgroundImageUrls = backgroundImageUrls;
        this.desTitleNeedDownload = desTitleNeedDownload;
        this.desTitleNeedUpdate = desTitleNeedUpdate;
        this.desTitleDefault = desTitleDefault;
        this.canShowTips = z16;
        this.tipsDownloading = tipsDownloading;
        this.tipsDefault = tipsDefault;
        this.tipsIconUrl = tipsIconUrl;
    }

    /* renamed from: b, reason: from getter */
    public final boolean getCanShowTips() {
        return this.canShowTips;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getDesTitleDefault() {
        return this.desTitleDefault;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getDesTitleNeedDownload() {
        return this.desTitleNeedDownload;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final String getDesTitleNeedUpdate() {
        return this.desTitleNeedUpdate;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final String getTipsDefault() {
        return this.tipsDefault;
    }

    @NotNull
    /* renamed from: g, reason: from getter */
    public final String getTipsDownloading() {
        return this.tipsDownloading;
    }

    @NotNull
    /* renamed from: h, reason: from getter */
    public final String getTipsIconUrl() {
        return this.tipsIconUrl;
    }

    @NotNull
    public String toString() {
        String str = "WoTransitPageConfig:\nbackgroundUrls.size: " + this.backgroundImageUrls.size() + "\ndesTitleNeedDownload: " + this.desTitleNeedDownload + "\ndesTitleNeedUpdate: " + this.desTitleNeedUpdate + "\ndesTitleDefault: " + this.desTitleDefault + "\ncanShowTips: " + this.canShowTips + "\ntipsDownloading: " + this.tipsDownloading + "\ntipsDefault: " + this.tipsDefault + "\ntipsIcon: " + this.tipsIconUrl;
        Intrinsics.checkNotNullExpressionValue(str, "StringBuilder()\n        \u2026)\n            .toString()");
        return str;
    }

    public /* synthetic */ f(ArrayList arrayList, String str, String str2, String str3, boolean z16, String str4, String str5, String str6, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? f447555j : arrayList, (i3 & 2) != 0 ? "\u6b22\u8fce\u5149\u4e34\u6211\u7684\u5c0f\u7a9d\uff0c\u6765\u4e00\u573a\u5076\u9047\u5427~" : str, (i3 & 4) != 0 ? "\u6b22\u8fce\u5149\u4e34\u6211\u7684\u5c0f\u7a9d\uff0c\u6765\u4e00\u573a\u5076\u9047\u5427~" : str2, (i3 & 8) == 0 ? str3 : "\u6b22\u8fce\u5149\u4e34\u6211\u7684\u5c0f\u7a9d\uff0c\u6765\u4e00\u573a\u5076\u9047\u5427~", (i3 & 16) != 0 ? true : z16, (i3 & 32) != 0 ? "\u81ea\u7531\u5e03\u7f6e\u4f60\u60f3\u8981\u7684\u88c5\u4fee\u98ce\u683c" : str4, (i3 & 64) == 0 ? str5 : "\u81ea\u7531\u5e03\u7f6e\u4f60\u60f3\u8981\u7684\u88c5\u4fee\u98ce\u683c", (i3 & 128) != 0 ? "https://imgcache.gtimg.cn/mie/act/img/public/202203/m1646384615_liwu@3x.png" : str6);
    }
}
