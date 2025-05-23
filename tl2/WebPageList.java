package tl2;

import com.google.gson.annotations.SerializedName;
import com.tencent.mobileqq.qwallet.web.WebPageData;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R*\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000b8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0010"}, d2 = {"Ltl2/e;", "", "", "toString", "", "hashCode", "other", "", "equals", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/qwallet/web/WebPageData;", "Lkotlin/collections/ArrayList;", "webList", "Ljava/util/ArrayList;", "a", "()Ljava/util/ArrayList;", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: tl2.e, reason: from toString */
/* loaded from: classes16.dex */
public final /* data */ class WebPageList {

    @SerializedName("webList")
    @NotNull
    private final ArrayList<WebPageData> webList;

    @NotNull
    public final ArrayList<WebPageData> a() {
        return this.webList;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if ((other instanceof WebPageList) && Intrinsics.areEqual(this.webList, ((WebPageList) other).webList)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.webList.hashCode();
    }

    @NotNull
    public String toString() {
        return "WebPageList(webList=" + this.webList + ")";
    }
}
