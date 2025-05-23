package qk2;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\fB\u0011\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001a\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0010"}, d2 = {"Lqk2/m;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lqk2/m$a;", "content", "Lqk2/m$a;", "a", "()Lqk2/m$a;", "<init>", "(Lqk2/m$a;)V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: qk2.m, reason: from toString */
/* loaded from: classes16.dex */
public final /* data */ class ServiceManagerConfig {

    @SerializedName("qqwallet_service_manager_config")
    @NotNull
    private final Content content;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u000f"}, d2 = {"Lqk2/m$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "text", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: qk2.m$a, reason: from toString */
    /* loaded from: classes16.dex */
    public static final /* data */ class Content {

        @SerializedName("text")
        @NotNull
        private final String text;

        public Content() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final String getText() {
            return this.text;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof Content) && Intrinsics.areEqual(this.text, ((Content) other).text)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.text.hashCode();
        }

        @NotNull
        public String toString() {
            return "Content(text=" + this.text + ")";
        }

        public Content(@NotNull String text) {
            Intrinsics.checkNotNullParameter(text, "text");
            this.text = text;
        }

        public /* synthetic */ Content(String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? "\u4f60\u53ef\u5b9a\u5236\u51fa\u73b0\u5728\u201cQQ \u94b1\u5305\u201d\u9875\u9762\u7684\u670d\u52a1\uff0c\u82e5\u5173\u95ed\u90e8\u5206\u670d\u52a1\uff0c\u5219\u9690\u85cf\u76f8\u5e94\u5165\u53e3\uff0c\u4f46\u4e0d\u4f1a\u6e05\u9664\u6570\u636e\uff0c\u5982\u9700\u518d\u6b21\u4f7f\u7528\u53ef\u5728\u6b64\u9875\u91cd\u542f\u3002" : str);
        }
    }

    public ServiceManagerConfig() {
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
        if ((other instanceof ServiceManagerConfig) && Intrinsics.areEqual(this.content, ((ServiceManagerConfig) other).content)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.content.hashCode();
    }

    @NotNull
    public String toString() {
        return "ServiceManagerConfig(content=" + this.content + ")";
    }

    public ServiceManagerConfig(@NotNull Content content) {
        Intrinsics.checkNotNullParameter(content, "content");
        this.content = content;
    }

    public /* synthetic */ ServiceManagerConfig(Content content, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? new Content(null, 1, 0 == true ? 1 : 0) : content);
    }
}
