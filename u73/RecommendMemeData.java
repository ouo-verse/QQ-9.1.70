package u73;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R \u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u000f"}, d2 = {"Lu73/g;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "Lu73/h;", "memeData", "Ljava/util/List;", "a", "()Ljava/util/List;", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: u73.g, reason: from toString */
/* loaded from: classes21.dex */
public final /* data */ class RecommendMemeData {

    @SerializedName("MemeData")
    @NotNull
    private final List<RecommendText> memeData;

    @NotNull
    public final List<RecommendText> a() {
        return this.memeData;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if ((other instanceof RecommendMemeData) && Intrinsics.areEqual(this.memeData, ((RecommendMemeData) other).memeData)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.memeData.hashCode();
    }

    @NotNull
    public String toString() {
        return "RecommendMemeData(memeData=" + this.memeData + ")";
    }
}
