package yb3;

import com.tencent.mtt.hippy.views.hippylist.ViewStickEventHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b#\b\u0086\b\u0018\u00002\u00020\u0001B[\u0012\u0006\u0010\f\u001a\u00020\u0004\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u001c\u001a\u00020\u0007\u0012\u0006\u0010\u001f\u001a\u00020\u0007\u0012\u0006\u0010!\u001a\u00020\u0007\u0012\u0006\u0010$\u001a\u00020\u0002\u0012\u0006\u0010'\u001a\u00020\u0002\u00a2\u0006\u0004\b(\u0010)J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0017\u0010\u000e\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\r\u0010\u000bR\u0017\u0010\u0013\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0010\u001a\u0004\b\u0015\u0010\u0012R\u0019\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0010\u001a\u0004\b\u0018\u0010\u0012R\u0017\u0010\u001c\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010\u001f\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001b\u001a\u0004\b\u001f\u0010\u001dR\u0017\u0010!\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b \u0010\u001b\u001a\u0004\b\u000f\u0010\u001dR\u0017\u0010$\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\"\u0010\u0010\u001a\u0004\b#\u0010\u0012R\u0017\u0010'\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b%\u0010\u0010\u001a\u0004\b&\u0010\u0012\u00a8\u0006*"}, d2 = {"Lyb3/h;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "()I", "id", "b", "index", "c", "Ljava/lang/String;", "getText", "()Ljava/lang/String;", "text", "d", "getSelectIcon", "selectIcon", "e", "getNormalIcon", "normalIcon", "f", "Z", "isDefaultSelect", "()Z", "g", "isJump", tl.h.F, ViewStickEventHelper.IS_SHOW, "i", "getJumpTarget", "jumpTarget", "j", "getToastText", "toastText", "<init>", "(IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZZLjava/lang/String;Ljava/lang/String;)V", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: yb3.h, reason: from toString */
/* loaded from: classes21.dex */
public final /* data */ class ZootopiaTabItemConfig {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int id;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final int index;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String text;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String selectIcon;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String normalIcon;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isDefaultSelect;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isJump;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isShow;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String jumpTarget;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String toastText;

    public ZootopiaTabItemConfig(int i3, int i16, @NotNull String text, @Nullable String str, @Nullable String str2, boolean z16, boolean z17, boolean z18, @NotNull String jumpTarget, @NotNull String toastText) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(jumpTarget, "jumpTarget");
        Intrinsics.checkNotNullParameter(toastText, "toastText");
        this.id = i3;
        this.index = i16;
        this.text = text;
        this.selectIcon = str;
        this.normalIcon = str2;
        this.isDefaultSelect = z16;
        this.isJump = z17;
        this.isShow = z18;
        this.jumpTarget = jumpTarget;
        this.toastText = toastText;
    }

    /* renamed from: a, reason: from getter */
    public final int getId() {
        return this.id;
    }

    /* renamed from: b, reason: from getter */
    public final int getIndex() {
        return this.index;
    }

    /* renamed from: c, reason: from getter */
    public final boolean getIsShow() {
        return this.isShow;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ZootopiaTabItemConfig)) {
            return false;
        }
        ZootopiaTabItemConfig zootopiaTabItemConfig = (ZootopiaTabItemConfig) other;
        if (this.id == zootopiaTabItemConfig.id && this.index == zootopiaTabItemConfig.index && Intrinsics.areEqual(this.text, zootopiaTabItemConfig.text) && Intrinsics.areEqual(this.selectIcon, zootopiaTabItemConfig.selectIcon) && Intrinsics.areEqual(this.normalIcon, zootopiaTabItemConfig.normalIcon) && this.isDefaultSelect == zootopiaTabItemConfig.isDefaultSelect && this.isJump == zootopiaTabItemConfig.isJump && this.isShow == zootopiaTabItemConfig.isShow && Intrinsics.areEqual(this.jumpTarget, zootopiaTabItemConfig.jumpTarget) && Intrinsics.areEqual(this.toastText, zootopiaTabItemConfig.toastText)) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode;
        int hashCode2 = ((((this.id * 31) + this.index) * 31) + this.text.hashCode()) * 31;
        String str = this.selectIcon;
        int i3 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int i16 = (hashCode2 + hashCode) * 31;
        String str2 = this.normalIcon;
        if (str2 != null) {
            i3 = str2.hashCode();
        }
        int i17 = (i16 + i3) * 31;
        boolean z16 = this.isDefaultSelect;
        int i18 = 1;
        int i19 = z16;
        if (z16 != 0) {
            i19 = 1;
        }
        int i26 = (i17 + i19) * 31;
        boolean z17 = this.isJump;
        int i27 = z17;
        if (z17 != 0) {
            i27 = 1;
        }
        int i28 = (i26 + i27) * 31;
        boolean z18 = this.isShow;
        if (!z18) {
            i18 = z18 ? 1 : 0;
        }
        return ((((i28 + i18) * 31) + this.jumpTarget.hashCode()) * 31) + this.toastText.hashCode();
    }

    @NotNull
    public String toString() {
        return "ZootopiaTabItemConfig(id=" + this.id + ", index=" + this.index + ", text=" + this.text + ", selectIcon=" + this.selectIcon + ", normalIcon=" + this.normalIcon + ", isDefaultSelect=" + this.isDefaultSelect + ", isJump=" + this.isJump + ", isShow=" + this.isShow + ", jumpTarget=" + this.jumpTarget + ", toastText=" + this.toastText + ')';
    }
}
