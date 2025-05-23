package u73;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\f\u00a8\u0006\u000f"}, d2 = {"Lu73/h;", "", "", "toString", "", "hashCode", "other", "", "equals", "title", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "content", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: u73.h, reason: from toString */
/* loaded from: classes21.dex */
public final /* data */ class RecommendText {

    @SerializedName("content")
    @NotNull
    private final String content;

    @SerializedName("title")
    @NotNull
    private final String title;

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RecommendText)) {
            return false;
        }
        RecommendText recommendText = (RecommendText) other;
        if (Intrinsics.areEqual(this.title, recommendText.title) && Intrinsics.areEqual(this.content, recommendText.content)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.title.hashCode() * 31) + this.content.hashCode();
    }

    @NotNull
    public String toString() {
        return "RecommendText(title=" + this.title + ", content=" + this.content + ")";
    }
}
