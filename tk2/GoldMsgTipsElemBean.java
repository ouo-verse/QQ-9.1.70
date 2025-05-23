package tk2;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0086\b\u0018\u0000 \u00162\u00020\u0001:\u0001\tB\u001f\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0004\u0012\u0006\u0010\u0013\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0014\u0010\u0015J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0010\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u000e\u001a\u0004\b\t\u0010\u000fR\u0017\u0010\u0013\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0012\u0010\u000f\u00a8\u0006\u0017"}, d2 = {"Ltk2/b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "billNo", "I", "()I", "action", "c", "getType", "type", "<init>", "(Ljava/lang/String;II)V", "d", "qwallet-api_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: tk2.b, reason: from toString */
/* loaded from: classes16.dex */
public final /* data */ class GoldMsgTipsElemBean {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String billNo;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final int action;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final int type;

    public GoldMsgTipsElemBean(@NotNull String billNo, int i3, int i16) {
        Intrinsics.checkNotNullParameter(billNo, "billNo");
        this.billNo = billNo;
        this.action = i3;
        this.type = i16;
    }

    /* renamed from: a, reason: from getter */
    public final int getAction() {
        return this.action;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getBillNo() {
        return this.billNo;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GoldMsgTipsElemBean)) {
            return false;
        }
        GoldMsgTipsElemBean goldMsgTipsElemBean = (GoldMsgTipsElemBean) other;
        if (Intrinsics.areEqual(this.billNo, goldMsgTipsElemBean.billNo) && this.action == goldMsgTipsElemBean.action && this.type == goldMsgTipsElemBean.type) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((this.billNo.hashCode() * 31) + this.action) * 31) + this.type;
    }

    @NotNull
    public String toString() {
        return "GoldMsgTipsElemBean(billNo=" + this.billNo + ", action=" + this.action + ", type=" + this.type + ')';
    }
}
