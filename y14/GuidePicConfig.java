package y14;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002\u0012\b\b\u0002\u0010\r\u001a\u00020\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\f\u00a8\u0006\u0011"}, d2 = {"Ly14/e;", "", "", "toString", "", "hashCode", "other", "", "equals", "dayUrl", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "nightUrl", "b", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: y14.e, reason: from toString */
/* loaded from: classes25.dex */
public final /* data */ class GuidePicConfig {

    @SerializedName("dayUrl")
    @NotNull
    private final String dayUrl;

    @SerializedName("nightUrl")
    @NotNull
    private final String nightUrl;

    public GuidePicConfig() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getDayUrl() {
        return this.dayUrl;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getNightUrl() {
        return this.nightUrl;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuidePicConfig)) {
            return false;
        }
        GuidePicConfig guidePicConfig = (GuidePicConfig) other;
        if (Intrinsics.areEqual(this.dayUrl, guidePicConfig.dayUrl) && Intrinsics.areEqual(this.nightUrl, guidePicConfig.nightUrl)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.dayUrl.hashCode() * 31) + this.nightUrl.hashCode();
    }

    @NotNull
    public String toString() {
        return "GuidePicConfig(dayUrl=" + this.dayUrl + ", nightUrl=" + this.nightUrl + ")";
    }

    public GuidePicConfig(@NotNull String dayUrl, @NotNull String nightUrl) {
        Intrinsics.checkNotNullParameter(dayUrl, "dayUrl");
        Intrinsics.checkNotNullParameter(nightUrl, "nightUrl");
        this.dayUrl = dayUrl;
        this.nightUrl = nightUrl;
    }

    public /* synthetic */ GuidePicConfig(String str, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "https://bot-resource-1251316161.file.myqcloud.com/media/guide_pic_1.jpg" : str, (i3 & 2) != 0 ? "https://bot-resource-1251316161.file.myqcloud.com/media/guide_pic_2.jpg" : str2);
    }
}
