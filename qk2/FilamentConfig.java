package qk2;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u0000 \f2\u00020\u0001:\u0002\f\u0010B\u0011\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001a\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lqk2/e;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lqk2/e$b;", "content", "Lqk2/e$b;", "a", "()Lqk2/e$b;", "<init>", "(Lqk2/e$b;)V", "b", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: qk2.e, reason: from toString */
/* loaded from: classes16.dex */
public final /* data */ class FilamentConfig {

    @SerializedName("filamentConfig")
    @NotNull
    private final Content content;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u000f"}, d2 = {"Lqk2/e$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "defaultResUrl", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: qk2.e$b, reason: from toString */
    /* loaded from: classes16.dex */
    public static final /* data */ class Content {

        @SerializedName("defaultResourceURL")
        @NotNull
        private final String defaultResUrl;

        public Content() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final String getDefaultResUrl() {
            return this.defaultResUrl;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof Content) && Intrinsics.areEqual(this.defaultResUrl, ((Content) other).defaultResUrl)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.defaultResUrl.hashCode();
        }

        @NotNull
        public String toString() {
            return "Content(defaultResUrl=" + this.defaultResUrl + ")";
        }

        public Content(@NotNull String defaultResUrl) {
            Intrinsics.checkNotNullParameter(defaultResUrl, "defaultResUrl");
            this.defaultResUrl = defaultResUrl;
        }

        public /* synthetic */ Content(String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? "https://moggy-image-1251316161.file.myqcloud.com/202210/upload_0233e8087cb57eb5d88849d54e0fc4ea.zip" : str);
        }
    }

    public FilamentConfig() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final Content getContent() {
        return this.content;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if ((other instanceof FilamentConfig) && Intrinsics.areEqual(this.content, ((FilamentConfig) other).content)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.content.hashCode();
    }

    @NotNull
    public String toString() {
        return "FilamentConfig(content=" + this.content + ")";
    }

    public FilamentConfig(@NotNull Content content) {
        Intrinsics.checkNotNullParameter(content, "content");
        this.content = content;
    }

    public /* synthetic */ FilamentConfig(Content content, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? new Content(null, 1, 0 == true ? 1 : 0) : content);
    }
}
