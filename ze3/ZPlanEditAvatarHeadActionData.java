package ze3;

import com.tencent.mobileqq.zplan.avatar.edit.ClipperInfo;
import com.tencent.mobileqq.zplan.avatar.edit.d;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import nu4.g;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001c\b\u0086\b\u0018\u0000 $2\u00020\u0001:\u0001\nB5\u0012\u0006\u0010\r\u001a\u00020\t\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0007\u00a2\u0006\u0004\b\"\u0010#J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\fR\u0017\u0010\u0012\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\"\u0010\u0017\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u000f\u001a\u0004\b\u0014\u0010\u0011\"\u0004\b\u0015\u0010\u0016R\"\u0010\u001b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u000f\u001a\u0004\b\u0019\u0010\u0011\"\u0004\b\u001a\u0010\u0016R\"\u0010\u001e\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!\u00a8\u0006%"}, d2 = {"Lze3/c;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lnu4/g;", "a", "Lnu4/g;", "()Lnu4/g;", "headConfig", "b", "Ljava/lang/String;", "getAppearancekey", "()Ljava/lang/String;", "appearancekey", "c", "getInBoundAvatarPath", "setInBoundAvatarPath", "(Ljava/lang/String;)V", "inBoundAvatarPath", "d", "getOutBoundAvatarPath", "setOutBoundAvatarPath", "outBoundAvatarPath", "e", "Z", "isSelected", "()Z", "setSelected", "(Z)V", "<init>", "(Lnu4/g;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "f", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: ze3.c, reason: from toString */
/* loaded from: classes36.dex */
public final /* data */ class ZPlanEditAvatarHeadActionData {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final g headConfig;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final String appearancekey;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private String inBoundAvatarPath;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private String outBoundAvatarPath;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean isSelected;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004\u00a8\u0006\n"}, d2 = {"Lze3/c$a;", "", "Lze3/c;", "headActionData", "", "gender", "Lcom/tencent/mobileqq/zplan/avatar/edit/d;", "a", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: ze3.c$a, reason: from kotlin metadata */
    /* loaded from: classes36.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        Companion() {
        }

        public final d a(ZPlanEditAvatarHeadActionData headActionData, int gender) {
            int i3;
            List mutableListOf;
            Intrinsics.checkNotNullParameter(headActionData, "headActionData");
            g headConfig = headActionData.getHeadConfig();
            if (!((gender == 0 && headConfig.gender == 2) || headConfig.gender == gender) || (i3 = headActionData.getHeadConfig().f421361id) == -1) {
                return null;
            }
            String str = headConfig.name;
            String str2 = headConfig.defaultUrl;
            double d16 = headConfig.maskRate;
            nu4.b bVar = headConfig.inBoundsClipper;
            ClipperInfo clipperInfo = new ClipperInfo(bVar.f421349x, bVar.f421350y, bVar.width, bVar.height);
            nu4.b bVar2 = headConfig.outBoundsClipper;
            ClipperInfo clipperInfo2 = new ClipperInfo(bVar2.f421349x, bVar2.f421350y, bVar2.width, bVar2.height);
            mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(Integer.valueOf((int) headConfig.event.tag));
            return new d(null, i3, str, str2, null, 0, null, d16, clipperInfo, clipperInfo2, mutableListOf, headConfig.event.info, 113, null);
        }
    }

    public ZPlanEditAvatarHeadActionData(g headConfig, String appearancekey, String inBoundAvatarPath, String outBoundAvatarPath, boolean z16) {
        Intrinsics.checkNotNullParameter(headConfig, "headConfig");
        Intrinsics.checkNotNullParameter(appearancekey, "appearancekey");
        Intrinsics.checkNotNullParameter(inBoundAvatarPath, "inBoundAvatarPath");
        Intrinsics.checkNotNullParameter(outBoundAvatarPath, "outBoundAvatarPath");
        this.headConfig = headConfig;
        this.appearancekey = appearancekey;
        this.inBoundAvatarPath = inBoundAvatarPath;
        this.outBoundAvatarPath = outBoundAvatarPath;
        this.isSelected = z16;
    }

    /* renamed from: a, reason: from getter */
    public final g getHeadConfig() {
        return this.headConfig;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((((this.headConfig.hashCode() * 31) + this.appearancekey.hashCode()) * 31) + this.inBoundAvatarPath.hashCode()) * 31) + this.outBoundAvatarPath.hashCode()) * 31;
        boolean z16 = this.isSelected;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return hashCode + i3;
    }

    public String toString() {
        return "ZPlanEditAvatarHeadActionData(headConfig=" + this.headConfig + ", appearancekey=" + this.appearancekey + ", inBoundAvatarPath=" + this.inBoundAvatarPath + ", outBoundAvatarPath=" + this.outBoundAvatarPath + ", isSelected=" + this.isSelected + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ZPlanEditAvatarHeadActionData)) {
            return false;
        }
        ZPlanEditAvatarHeadActionData zPlanEditAvatarHeadActionData = (ZPlanEditAvatarHeadActionData) other;
        return Intrinsics.areEqual(this.headConfig, zPlanEditAvatarHeadActionData.headConfig) && Intrinsics.areEqual(this.appearancekey, zPlanEditAvatarHeadActionData.appearancekey) && Intrinsics.areEqual(this.inBoundAvatarPath, zPlanEditAvatarHeadActionData.inBoundAvatarPath) && Intrinsics.areEqual(this.outBoundAvatarPath, zPlanEditAvatarHeadActionData.outBoundAvatarPath) && this.isSelected == zPlanEditAvatarHeadActionData.isSelected;
    }
}
