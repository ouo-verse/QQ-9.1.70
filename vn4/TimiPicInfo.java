package vn4;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\b\u0086\b\u0018\u0000 \u00132\u00020\u0001:\u0001\tB\u0019\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0010\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u000e\u001a\u0004\b\t\u0010\u000f\u00a8\u0006\u0014"}, d2 = {"Lvn4/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "url", "I", "()I", "picType", "<init>", "(Ljava/lang/String;I)V", "c", "timi-game-api_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: vn4.a, reason: from toString */
/* loaded from: classes26.dex */
public final /* data */ class TimiPicInfo {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String url;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final int picType;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lvn4/a$a;", "", "", "typeStr", "", "a", "<init>", "()V", "timi-game-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: vn4.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes26.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a(@NotNull String typeStr) {
            Intrinsics.checkNotNullParameter(typeStr, "typeStr");
            String lowerCase = typeStr.toLowerCase();
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase()");
            if (Intrinsics.areEqual(lowerCase, "apng")) {
                return 3;
            }
            return 2;
        }

        Companion() {
        }
    }

    public TimiPicInfo(@NotNull String url, int i3) {
        Intrinsics.checkNotNullParameter(url, "url");
        this.url = url;
        this.picType = i3;
    }

    /* renamed from: a, reason: from getter */
    public final int getPicType() {
        return this.picType;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TimiPicInfo)) {
            return false;
        }
        TimiPicInfo timiPicInfo = (TimiPicInfo) other;
        if (Intrinsics.areEqual(this.url, timiPicInfo.url) && this.picType == timiPicInfo.picType) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.url.hashCode() * 31) + this.picType;
    }

    @NotNull
    public String toString() {
        return "TimiPicInfo(url=" + this.url + ", picType=" + this.picType + ')';
    }

    public /* synthetic */ TimiPicInfo(String str, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i16 & 2) != 0 ? 2 : i3);
    }
}
