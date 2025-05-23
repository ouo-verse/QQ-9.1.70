package vd3;

import com.tencent.component.media.image.ImageTaskConst;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0004\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u000f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\t\u0010\fR\u0017\u0010\u0012\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0010\u001a\u0004\b\u000e\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lvd3/e;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "c", "()I", ImageTaskConst.ERROR_TYPE, "b", "errCode", "Ljava/lang/String;", "()Ljava/lang/String;", "errMsg", "<init>", "(IILjava/lang/String;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: vd3.e, reason: from toString */
/* loaded from: classes36.dex */
public final /* data */ class PrepareErr {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int errType;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final int errCode;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final String errMsg;

    public PrepareErr(int i3, int i16, String errMsg) {
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        this.errType = i3;
        this.errCode = i16;
        this.errMsg = errMsg;
    }

    /* renamed from: a, reason: from getter */
    public final int getErrCode() {
        return this.errCode;
    }

    /* renamed from: b, reason: from getter */
    public final String getErrMsg() {
        return this.errMsg;
    }

    /* renamed from: c, reason: from getter */
    public final int getErrType() {
        return this.errType;
    }

    public int hashCode() {
        return (((this.errType * 31) + this.errCode) * 31) + this.errMsg.hashCode();
    }

    public String toString() {
        return "PrepareErr(errType=" + this.errType + ", errCode=" + this.errCode + ", errMsg=" + this.errMsg + ")";
    }

    public /* synthetic */ PrepareErr(int i3, int i16, String str, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, (i17 & 2) != 0 ? 0 : i16, str);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PrepareErr)) {
            return false;
        }
        PrepareErr prepareErr = (PrepareErr) other;
        return this.errType == prepareErr.errType && this.errCode == prepareErr.errCode && Intrinsics.areEqual(this.errMsg, prepareErr.errMsg);
    }
}
