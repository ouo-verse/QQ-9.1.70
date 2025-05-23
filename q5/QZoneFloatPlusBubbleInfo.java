package q5;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import cooperation.vip.pb.TianShuAccess;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001f\b\u0086\b\u0018\u0000 '2\u00020\u0001:\u0001\nBS\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u0012\u0006\u0010\u0016\u001a\u00020\u0002\u0012\u0006\u0010\u0018\u001a\u00020\u0002\u0012\u0006\u0010\u001b\u001a\u00020\u0007\u0012\u0006\u0010\u001e\u001a\u00020\u0007\u0012\u0006\u0010!\u001a\u00020\u0002\u0012\u0006\u0010$\u001a\u00020\u0002\u00a2\u0006\u0004\b%\u0010&J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0019\u0010\r\u001a\u0004\u0018\u00010\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\fR\u0017\u0010\u0011\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000e\u0010\u0010R\u0017\u0010\u0014\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0013\u0010\u0010R\u0017\u0010\u0016\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u000f\u001a\u0004\b\u0015\u0010\u0010R\u0017\u0010\u0018\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u000f\u001a\u0004\b\u0012\u0010\u0010R\u0017\u0010\u001b\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0019\u001a\u0004\b\u0017\u0010\u001aR\u0017\u0010\u001e\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u0019\u001a\u0004\b\u001d\u0010\u001aR\u0017\u0010!\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010\u000f\u001a\u0004\b \u0010\u0010R\u0017\u0010$\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\"\u0010\u000f\u001a\u0004\b#\u0010\u0010\u00a8\u0006("}, d2 = {"Lq5/b;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcooperation/vip/pb/TianShuAccess$AdItem;", "a", "Lcooperation/vip/pb/TianShuAccess$AdItem;", "()Lcooperation/vip/pb/TianShuAccess$AdItem;", "adItem", "b", "Ljava/lang/String;", "()Ljava/lang/String;", "icon", "c", "d", "name", "f", "text", "e", WadlProxyConsts.KEY_JUMP_URL, "Z", "()Z", "reddot", "g", "getOuter", "outer", h.F, "getOuterIcon", "outerIcon", "i", "getOuterText", "outerText", "<init>", "(Lcooperation/vip/pb/TianShuAccess$AdItem;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLjava/lang/String;Ljava/lang/String;)V", "j", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: q5.b, reason: from toString */
/* loaded from: classes36.dex */
public final /* data */ class QZoneFloatPlusBubbleInfo {

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final TianShuAccess.AdItem adItem;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final String icon;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final String name;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final String text;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final String jumpUrl;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean reddot;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean outer;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    private final String outerIcon;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    private final String outerText;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ$\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004R\u0014\u0010\t\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lq5/b$a;", "", "Lcooperation/vip/pb/TianShuAccess$AdItem;", "adItem", "", "", "argMap", "Lq5/b;", "a", "STR_TRUE", "Ljava/lang/String;", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: q5.b$a, reason: from kotlin metadata */
    /* loaded from: classes36.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final QZoneFloatPlusBubbleInfo a(TianShuAccess.AdItem adItem, Map<String, String> argMap) {
            Intrinsics.checkNotNullParameter(argMap, "argMap");
            String str = argMap.get("icon");
            String str2 = str == null ? "" : str;
            String str3 = argMap.get("name");
            String str4 = str3 == null ? "" : str3;
            String str5 = argMap.get("text");
            String str6 = str5 == null ? "" : str5;
            String str7 = argMap.get("jumpurl");
            String str8 = str7 == null ? "" : str7;
            boolean areEqual = Intrinsics.areEqual(argMap.get("reddot"), "yes");
            boolean areEqual2 = Intrinsics.areEqual(argMap.get("outer"), "yes");
            String str9 = argMap.get("outericon");
            String str10 = str9 == null ? "" : str9;
            String str11 = argMap.get("outertext");
            if (str11 == null) {
                str11 = "";
            }
            return new QZoneFloatPlusBubbleInfo(adItem, str2, str4, str6, str8, areEqual, areEqual2, str10, str11);
        }

        Companion() {
        }
    }

    public QZoneFloatPlusBubbleInfo(TianShuAccess.AdItem adItem, String icon, String name, String text, String jumpUrl, boolean z16, boolean z17, String outerIcon, String outerText) {
        Intrinsics.checkNotNullParameter(icon, "icon");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(jumpUrl, "jumpUrl");
        Intrinsics.checkNotNullParameter(outerIcon, "outerIcon");
        Intrinsics.checkNotNullParameter(outerText, "outerText");
        this.adItem = adItem;
        this.icon = icon;
        this.name = name;
        this.text = text;
        this.jumpUrl = jumpUrl;
        this.reddot = z16;
        this.outer = z17;
        this.outerIcon = outerIcon;
        this.outerText = outerText;
    }

    /* renamed from: a, reason: from getter */
    public final TianShuAccess.AdItem getAdItem() {
        return this.adItem;
    }

    /* renamed from: b, reason: from getter */
    public final String getIcon() {
        return this.icon;
    }

    /* renamed from: c, reason: from getter */
    public final String getJumpUrl() {
        return this.jumpUrl;
    }

    /* renamed from: d, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: e, reason: from getter */
    public final boolean getReddot() {
        return this.reddot;
    }

    /* renamed from: f, reason: from getter */
    public final String getText() {
        return this.text;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        TianShuAccess.AdItem adItem = this.adItem;
        int hashCode = (((((((((adItem == null ? 0 : adItem.hashCode()) * 31) + this.icon.hashCode()) * 31) + this.name.hashCode()) * 31) + this.text.hashCode()) * 31) + this.jumpUrl.hashCode()) * 31;
        boolean z16 = this.reddot;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        int i16 = (hashCode + i3) * 31;
        boolean z17 = this.outer;
        return ((((i16 + (z17 ? 1 : z17 ? 1 : 0)) * 31) + this.outerIcon.hashCode()) * 31) + this.outerText.hashCode();
    }

    public String toString() {
        return "QZoneFloatPlusBubbleInfo(adItem=" + this.adItem + ", icon=" + this.icon + ", name=" + this.name + ", text=" + this.text + ", jumpUrl=" + this.jumpUrl + ", reddot=" + this.reddot + ", outer=" + this.outer + ", outerIcon=" + this.outerIcon + ", outerText=" + this.outerText + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof QZoneFloatPlusBubbleInfo)) {
            return false;
        }
        QZoneFloatPlusBubbleInfo qZoneFloatPlusBubbleInfo = (QZoneFloatPlusBubbleInfo) other;
        return Intrinsics.areEqual(this.adItem, qZoneFloatPlusBubbleInfo.adItem) && Intrinsics.areEqual(this.icon, qZoneFloatPlusBubbleInfo.icon) && Intrinsics.areEqual(this.name, qZoneFloatPlusBubbleInfo.name) && Intrinsics.areEqual(this.text, qZoneFloatPlusBubbleInfo.text) && Intrinsics.areEqual(this.jumpUrl, qZoneFloatPlusBubbleInfo.jumpUrl) && this.reddot == qZoneFloatPlusBubbleInfo.reddot && this.outer == qZoneFloatPlusBubbleInfo.outer && Intrinsics.areEqual(this.outerIcon, qZoneFloatPlusBubbleInfo.outerIcon) && Intrinsics.areEqual(this.outerText, qZoneFloatPlusBubbleInfo.outerText);
    }
}
