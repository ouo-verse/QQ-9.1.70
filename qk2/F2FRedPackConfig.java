package qk2;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u0000 \u00112\u00020\u0001:\u0002\u0011\u0003B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\n\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0006\u0010\u0003\u001a\u00020\u0002J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\t\u0010\u0007\u001a\u00020\u0006H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001a\u0010\u000b\u001a\u00020\n8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lqk2/d;", "", "", "b", "", "toString", "", "hashCode", "other", "equals", "Lqk2/d$b;", "redPack", "Lqk2/d$b;", "getRedPack", "()Lqk2/d$b;", "<init>", "(Lqk2/d$b;)V", "a", "qqpay-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: qk2.d, reason: from toString */
/* loaded from: classes16.dex */
public final /* data */ class F2FRedPackConfig {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @SerializedName("F2FRedpack")
    @NotNull
    private final RedPack redPack;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0003\u001a\u00020\u0002H\u0007R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006\u00a8\u0006\t"}, d2 = {"Lqk2/d$a;", "", "Lqk2/d;", "a", "", "QR_CHECK_DEFAULT_VALUE", "I", "<init>", "()V", "qqpay-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: qk2.d$a, reason: from kotlin metadata */
    /* loaded from: classes16.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final F2FRedPackConfig a() {
            return new F2FRedPackConfig(new RedPack(1));
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\t\u001a\u00020\u0004\u00a2\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001a\u0010\t\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u000f"}, d2 = {"Lqk2/d$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "qrCheck", "I", "a", "()I", "<init>", "(I)V", "qqpay-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: qk2.d$b, reason: from toString */
    /* loaded from: classes16.dex */
    public static final /* data */ class RedPack {

        @SerializedName("F2FRedpackQRCheck")
        private final int qrCheck;

        public RedPack() {
            this(0, 1, null);
        }

        /* renamed from: a, reason: from getter */
        public final int getQrCheck() {
            return this.qrCheck;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof RedPack) && this.qrCheck == ((RedPack) other).qrCheck) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.qrCheck;
        }

        @NotNull
        public String toString() {
            return "RedPack(qrCheck=" + this.qrCheck + ")";
        }

        public RedPack(int i3) {
            this.qrCheck = i3;
        }

        public /* synthetic */ RedPack(int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
            this((i16 & 1) != 0 ? 1 : i3);
        }
    }

    public F2FRedPackConfig(@NotNull RedPack redPack) {
        Intrinsics.checkNotNullParameter(redPack, "redPack");
        this.redPack = redPack;
    }

    @JvmStatic
    @NotNull
    public static final F2FRedPackConfig a() {
        return INSTANCE.a();
    }

    public final boolean b() {
        if (this.redPack.getQrCheck() == 1) {
            return true;
        }
        return false;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if ((other instanceof F2FRedPackConfig) && Intrinsics.areEqual(this.redPack, ((F2FRedPackConfig) other).redPack)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.redPack.hashCode();
    }

    @NotNull
    public String toString() {
        return "F2FRedPackConfig(redPack=" + this.redPack + ")";
    }
}
