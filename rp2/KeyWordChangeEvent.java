package rp2;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0010\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u000e\u001a\u0004\b\t\u0010\u000fR\u0017\u0010\u0012\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\n\u001a\u0004\b\u0011\u0010\fR\u0017\u0010\u0014\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\n\u001a\u0004\b\u0013\u0010\f\u00a8\u0006\u0017"}, d2 = {"Lrp2/b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "keyword", "I", "()I", "keyWordFrom", "c", "sugTraceId", "d", "sugWxSuggestionId", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: rp2.b, reason: from toString */
/* loaded from: classes18.dex */
public final /* data */ class KeyWordChangeEvent {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String keyword;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final int keyWordFrom;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String sugTraceId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String sugWxSuggestionId;

    public KeyWordChangeEvent(@NotNull String keyword, int i3, @NotNull String sugTraceId, @NotNull String sugWxSuggestionId) {
        Intrinsics.checkNotNullParameter(keyword, "keyword");
        Intrinsics.checkNotNullParameter(sugTraceId, "sugTraceId");
        Intrinsics.checkNotNullParameter(sugWxSuggestionId, "sugWxSuggestionId");
        this.keyword = keyword;
        this.keyWordFrom = i3;
        this.sugTraceId = sugTraceId;
        this.sugWxSuggestionId = sugWxSuggestionId;
    }

    /* renamed from: a, reason: from getter */
    public final int getKeyWordFrom() {
        return this.keyWordFrom;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getKeyword() {
        return this.keyword;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getSugTraceId() {
        return this.sugTraceId;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getSugWxSuggestionId() {
        return this.sugWxSuggestionId;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof KeyWordChangeEvent)) {
            return false;
        }
        KeyWordChangeEvent keyWordChangeEvent = (KeyWordChangeEvent) other;
        if (Intrinsics.areEqual(this.keyword, keyWordChangeEvent.keyword) && this.keyWordFrom == keyWordChangeEvent.keyWordFrom && Intrinsics.areEqual(this.sugTraceId, keyWordChangeEvent.sugTraceId) && Intrinsics.areEqual(this.sugWxSuggestionId, keyWordChangeEvent.sugWxSuggestionId)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((this.keyword.hashCode() * 31) + this.keyWordFrom) * 31) + this.sugTraceId.hashCode()) * 31) + this.sugWxSuggestionId.hashCode();
    }

    @NotNull
    public String toString() {
        return "KeyWordChangeEvent(keyword=" + this.keyword + ", keyWordFrom=" + this.keyWordFrom + ", sugTraceId=" + this.sugTraceId + ", sugWxSuggestionId=" + this.sugWxSuggestionId + ")";
    }

    public /* synthetic */ KeyWordChangeEvent(String str, int i3, String str2, String str3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i3, (i16 & 4) != 0 ? "" : str2, (i16 & 8) != 0 ? "" : str3);
    }
}
