package v93;

import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.pb.MessageMicro;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\b\u0018\u0000*\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u00028\u00000\u00012\u00020\u0003B5\u0012\u0006\u0010\u000f\u001a\u00020\t\u0012\u0006\u0010\u0015\u001a\u00020\u0010\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u0019\u0012\b\u0010!\u001a\u0004\u0018\u00018\u0000\u00a2\u0006\u0004\b\"\u0010#J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\t\u0010\u0007\u001a\u00020\u0006H\u00d6\u0001J\u0013\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0003H\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0015\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0019\u0010\u0018\u001a\u0004\u0018\u00010\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0016\u001a\u0004\b\u000b\u0010\u0017R\u0019\u0010\u001d\u001a\u0004\u0018\u00010\u00198\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0019\u0010!\u001a\u0004\u0018\u00018\u00008\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u0011\u0010 \u00a8\u0006$"}, d2 = {"Lv93/a;", "Lcom/tencent/mobileqq/pb/MessageMicro;", "T", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Z", "d", "()Z", "isSuccess", "", "b", "J", "c", "()J", "retCode", "Ljava/lang/String;", "()Ljava/lang/String;", "msg", "Lcom/tencent/biz/richframework/network/request/BaseRequest;", "Lcom/tencent/biz/richframework/network/request/BaseRequest;", "getPbRequest", "()Lcom/tencent/biz/richframework/network/request/BaseRequest;", "pbRequest", "e", "Lcom/tencent/mobileqq/pb/MessageMicro;", "()Lcom/tencent/mobileqq/pb/MessageMicro;", "pbResponse", "<init>", "(ZJLjava/lang/String;Lcom/tencent/biz/richframework/network/request/BaseRequest;Lcom/tencent/mobileqq/pb/MessageMicro;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: v93.a, reason: from toString */
/* loaded from: classes21.dex */
public final /* data */ class WinkResponseData<T extends MessageMicro<T>> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isSuccess;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final long retCode;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String msg;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final BaseRequest pbRequest;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final T pbResponse;

    public WinkResponseData(boolean z16, long j3, @Nullable String str, @Nullable BaseRequest baseRequest, @Nullable T t16) {
        this.isSuccess = z16;
        this.retCode = j3;
        this.msg = str;
        this.pbRequest = baseRequest;
        this.pbResponse = t16;
    }

    @Nullable
    /* renamed from: a, reason: from getter */
    public final String getMsg() {
        return this.msg;
    }

    @Nullable
    public final T b() {
        return this.pbResponse;
    }

    /* renamed from: c, reason: from getter */
    public final long getRetCode() {
        return this.retCode;
    }

    /* renamed from: d, reason: from getter */
    public final boolean getIsSuccess() {
        return this.isSuccess;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WinkResponseData)) {
            return false;
        }
        WinkResponseData winkResponseData = (WinkResponseData) other;
        if (this.isSuccess == winkResponseData.isSuccess && this.retCode == winkResponseData.retCode && Intrinsics.areEqual(this.msg, winkResponseData.msg) && Intrinsics.areEqual(this.pbRequest, winkResponseData.pbRequest) && Intrinsics.areEqual(this.pbResponse, winkResponseData.pbResponse)) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    public int hashCode() {
        int hashCode;
        int hashCode2;
        boolean z16 = this.isSuccess;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        int a16 = ((r06 * 31) + androidx.fragment.app.a.a(this.retCode)) * 31;
        String str = this.msg;
        int i3 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int i16 = (a16 + hashCode) * 31;
        BaseRequest baseRequest = this.pbRequest;
        if (baseRequest == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = baseRequest.hashCode();
        }
        int i17 = (i16 + hashCode2) * 31;
        T t16 = this.pbResponse;
        if (t16 != null) {
            i3 = t16.hashCode();
        }
        return i17 + i3;
    }

    @NotNull
    public String toString() {
        return "WinkResponseData(isSuccess=" + this.isSuccess + ", retCode=" + this.retCode + ", msg=" + this.msg + ", pbRequest=" + this.pbRequest + ", pbResponse=" + this.pbResponse + ")";
    }
}
