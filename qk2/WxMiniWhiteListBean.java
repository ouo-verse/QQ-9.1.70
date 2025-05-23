package qk2;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\t\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\t8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0010"}, d2 = {"Lqk2/o;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "wxIdList", "Ljava/util/List;", "a", "()Ljava/util/List;", "<init>", "(Ljava/util/List;)V", "qqpay-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: qk2.o, reason: from toString */
/* loaded from: classes16.dex */
public final /* data */ class WxMiniWhiteListBean {

    @SerializedName("wxMiniAppWhiteList")
    @Nullable
    private final List<String> wxIdList;

    public WxMiniWhiteListBean() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Nullable
    public final List<String> a() {
        return this.wxIdList;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if ((other instanceof WxMiniWhiteListBean) && Intrinsics.areEqual(this.wxIdList, ((WxMiniWhiteListBean) other).wxIdList)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        List<String> list = this.wxIdList;
        if (list == null) {
            return 0;
        }
        return list.hashCode();
    }

    @NotNull
    public String toString() {
        return "WxMiniWhiteListBean(wxIdList=" + this.wxIdList + ")";
    }

    public WxMiniWhiteListBean(@Nullable List<String> list) {
        this.wxIdList = list;
    }

    public /* synthetic */ WxMiniWhiteListBean(List list, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : list);
    }
}
