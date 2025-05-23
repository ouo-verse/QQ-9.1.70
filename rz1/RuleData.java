package rz1;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0018\u0010\u0019J'\u0010\u0007\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0004H\u00c6\u0001J\t\u0010\b\u001a\u00020\u0004H\u00d6\u0001J\t\u0010\t\u001a\u00020\u0002H\u00d6\u0001J\u0013\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0006\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0016\u0010\u0013\"\u0004\b\u0017\u0010\u0015\u00a8\u0006\u001a"}, d2 = {"Lrz1/d;", "", "", "originOrder", "", "title", "content", "a", "toString", "hashCode", "other", "", "equals", "I", "d", "()I", "b", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "g", "(Ljava/lang/String;)V", "c", "f", "<init>", "(ILjava/lang/String;Ljava/lang/String;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: rz1.d, reason: from toString */
/* loaded from: classes14.dex */
public final /* data */ class RuleData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int originOrder;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String title;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String content;

    public RuleData(int i3, @NotNull String title, @NotNull String content) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(content, "content");
        this.originOrder = i3;
        this.title = title;
        this.content = content;
    }

    public static /* synthetic */ RuleData b(RuleData ruleData, int i3, String str, String str2, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            i3 = ruleData.originOrder;
        }
        if ((i16 & 2) != 0) {
            str = ruleData.title;
        }
        if ((i16 & 4) != 0) {
            str2 = ruleData.content;
        }
        return ruleData.a(i3, str, str2);
    }

    @NotNull
    public final RuleData a(int originOrder, @NotNull String title, @NotNull String content) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(content, "content");
        return new RuleData(originOrder, title, content);
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    /* renamed from: d, reason: from getter */
    public final int getOriginOrder() {
        return this.originOrder;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RuleData)) {
            return false;
        }
        RuleData ruleData = (RuleData) other;
        if (this.originOrder == ruleData.originOrder && Intrinsics.areEqual(this.title, ruleData.title) && Intrinsics.areEqual(this.content, ruleData.content)) {
            return true;
        }
        return false;
    }

    public final void f(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.content = str;
    }

    public final void g(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.title = str;
    }

    public int hashCode() {
        return (((this.originOrder * 31) + this.title.hashCode()) * 31) + this.content.hashCode();
    }

    @NotNull
    public String toString() {
        return "RuleData(originOrder=" + this.originOrder + ", title=" + this.title + ", content=" + this.content + ")";
    }

    public /* synthetic */ RuleData(int i3, String str, String str2, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, (i16 & 2) != 0 ? "" : str, (i16 & 4) != 0 ? "" : str2);
    }
}
