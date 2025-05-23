package u73;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001a\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\u00a8\u0006\u000e"}, d2 = {"Lu73/e;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lu73/f;", "memeData", "Lu73/f;", "a", "()Lu73/f;", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: u73.e, reason: from toString */
/* loaded from: classes21.dex */
public final /* data */ class JsonContent {

    @SerializedName("content")
    @NotNull
    private final MemeData memeData;

    @NotNull
    /* renamed from: a, reason: from getter */
    public final MemeData getMemeData() {
        return this.memeData;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if ((other instanceof JsonContent) && Intrinsics.areEqual(this.memeData, ((JsonContent) other).memeData)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.memeData.hashCode();
    }

    @NotNull
    public String toString() {
        return "JsonContent(memeData=" + this.memeData + ")";
    }
}
