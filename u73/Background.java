package u73;

import com.google.gson.annotations.SerializedName;
import com.heytap.databaseengine.model.UserInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u000e\u001a\u00020\r8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\r8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0013\u0010\u0011R\u0011\u0010\u0015\u001a\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\fR\u0011\u0010\u0019\u001a\u00020\u00168F\u00a2\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001a"}, d2 = {"Lu73/b;", "", "", "toString", "", "hashCode", "other", "", "equals", "url", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "", "startTime", UserInfo.SEX_FEMALE, "getStartTime", "()F", "endTime", "b", "c", "path", "", "a", "()J", "durationUS", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: u73.b, reason: from toString */
/* loaded from: classes21.dex */
public final /* data */ class Background {

    @SerializedName("endTime")
    private final float endTime;

    @SerializedName("startTime")
    private final float startTime;

    @SerializedName("url")
    @NotNull
    private final String url;

    public final long a() {
        return (this.endTime - this.startTime) * 1000000;
    }

    /* renamed from: b, reason: from getter */
    public final float getEndTime() {
        return this.endTime;
    }

    @NotNull
    public final String c() {
        return d.a(this.url);
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Background)) {
            return false;
        }
        Background background = (Background) other;
        if (Intrinsics.areEqual(this.url, background.url) && Float.compare(this.startTime, background.startTime) == 0 && Float.compare(this.endTime, background.endTime) == 0) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((this.url.hashCode() * 31) + Float.floatToIntBits(this.startTime)) * 31) + Float.floatToIntBits(this.endTime);
    }

    @NotNull
    public String toString() {
        return "Background(url=" + this.url + ", startTime=" + this.startTime + ", endTime=" + this.endTime + ")";
    }
}
