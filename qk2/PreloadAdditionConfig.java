package qk2;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u0000 \f2\u00020\u0001:\u0002\f\u0010B\u0011\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001a\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lqk2/i;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lqk2/i$b;", "content", "Lqk2/i$b;", "a", "()Lqk2/i$b;", "<init>", "(Lqk2/i$b;)V", "b", "qqpay-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: qk2.i, reason: from toString */
/* loaded from: classes16.dex */
public final /* data */ class PreloadAdditionConfig {

    @SerializedName("preload_config")
    @NotNull
    private final Content content;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0004\u0012\b\b\u0002\u0010\r\u001a\u00020\u0004\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001a\u0010\t\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\f\u00a8\u0006\u0011"}, d2 = {"Lqk2/i$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "delayInterval", "I", "a", "()I", "needWaitSize", "b", "<init>", "(II)V", "qqpay-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: qk2.i$b, reason: from toString */
    /* loaded from: classes16.dex */
    public static final /* data */ class Content {

        @SerializedName("deal_delay_interval")
        private final int delayInterval;

        @SerializedName("need_wait_size")
        private final int needWaitSize;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Content() {
            this(r2, r2, 3, null);
            int i3 = 0;
        }

        /* renamed from: a, reason: from getter */
        public final int getDelayInterval() {
            return this.delayInterval;
        }

        /* renamed from: b, reason: from getter */
        public final int getNeedWaitSize() {
            return this.needWaitSize;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Content)) {
                return false;
            }
            Content content = (Content) other;
            if (this.delayInterval == content.delayInterval && this.needWaitSize == content.needWaitSize) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (this.delayInterval * 31) + this.needWaitSize;
        }

        @NotNull
        public String toString() {
            return "Content(delayInterval=" + this.delayInterval + ", needWaitSize=" + this.needWaitSize + ")";
        }

        public Content(int i3, int i16) {
            this.delayInterval = i3;
            this.needWaitSize = i16;
        }

        public /* synthetic */ Content(int i3, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
            this((i17 & 1) != 0 ? 30 : i3, (i17 & 2) != 0 ? 1024 : i16);
        }
    }

    public PreloadAdditionConfig() {
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
        if ((other instanceof PreloadAdditionConfig) && Intrinsics.areEqual(this.content, ((PreloadAdditionConfig) other).content)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.content.hashCode();
    }

    @NotNull
    public String toString() {
        return "PreloadAdditionConfig(content=" + this.content + ")";
    }

    public PreloadAdditionConfig(@NotNull Content content) {
        Intrinsics.checkNotNullParameter(content, "content");
        this.content = content;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ PreloadAdditionConfig(Content content, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(content);
        if ((i3 & 1) != 0) {
            int i16 = 0;
            content = new Content(i16, i16, 3, null);
        }
    }
}
