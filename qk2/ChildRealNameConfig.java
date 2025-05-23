package qk2;

import com.google.gson.annotations.SerializedName;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tenpay.idverify.model.ChildrenRealNameConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001a\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0010"}, d2 = {"Lqk2/c;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tenpay/idverify/model/ChildrenRealNameConfig;", DownloadInfo.spKey_Config, "Lcom/tenpay/idverify/model/ChildrenRealNameConfig;", "a", "()Lcom/tenpay/idverify/model/ChildrenRealNameConfig;", "<init>", "(Lcom/tenpay/idverify/model/ChildrenRealNameConfig;)V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: qk2.c, reason: from toString */
/* loaded from: classes16.dex */
public final /* data */ class ChildRealNameConfig {

    @SerializedName("childRealNameConfig")
    @NotNull
    private final ChildrenRealNameConfig config;

    public ChildRealNameConfig() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final ChildrenRealNameConfig getConfig() {
        return this.config;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if ((other instanceof ChildRealNameConfig) && Intrinsics.areEqual(this.config, ((ChildRealNameConfig) other).config)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.config.hashCode();
    }

    @NotNull
    public String toString() {
        return "ChildRealNameConfig(config=" + this.config + ")";
    }

    public ChildRealNameConfig(@NotNull ChildrenRealNameConfig config) {
        Intrinsics.checkNotNullParameter(config, "config");
        this.config = config;
    }

    public /* synthetic */ ChildRealNameConfig(ChildrenRealNameConfig childrenRealNameConfig, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? ChildrenRealNameConfig.Companion.getDEFAULT() : childrenRealNameConfig);
    }
}
