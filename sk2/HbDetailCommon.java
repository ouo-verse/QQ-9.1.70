package sk2;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\f\u00a8\u0006\u0011"}, d2 = {"Lsk2/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "knowSkinTitle", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "knowSkinUrl", "b", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "qqpay-api_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: sk2.a, reason: from toString */
/* loaded from: classes16.dex */
public final /* data */ class HbDetailCommon {

    @SerializedName("know_skin_title")
    @Nullable
    private final String knowSkinTitle;

    @SerializedName("know_skin_url")
    @Nullable
    private final String knowSkinUrl;

    public HbDetailCommon() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    @Nullable
    /* renamed from: a, reason: from getter */
    public final String getKnowSkinTitle() {
        return this.knowSkinTitle;
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final String getKnowSkinUrl() {
        return this.knowSkinUrl;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HbDetailCommon)) {
            return false;
        }
        HbDetailCommon hbDetailCommon = (HbDetailCommon) other;
        if (Intrinsics.areEqual(this.knowSkinTitle, hbDetailCommon.knowSkinTitle) && Intrinsics.areEqual(this.knowSkinUrl, hbDetailCommon.knowSkinUrl)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        String str = this.knowSkinTitle;
        int i3 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int i16 = hashCode * 31;
        String str2 = this.knowSkinUrl;
        if (str2 != null) {
            i3 = str2.hashCode();
        }
        return i16 + i3;
    }

    @NotNull
    public String toString() {
        return "HbDetailCommon(knowSkinTitle=" + this.knowSkinTitle + ", knowSkinUrl=" + this.knowSkinUrl + ')';
    }

    public HbDetailCommon(@Nullable String str, @Nullable String str2) {
        this.knowSkinTitle = str;
        this.knowSkinUrl = str2;
    }

    public /* synthetic */ HbDetailCommon(String str, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : str, (i3 & 2) != 0 ? null : str2);
    }
}
