package qg0;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0012\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u0004\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u0012\u0006\u0010\u0016\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0011\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000e\u0010\u0010R\u0017\u0010\u0015\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0012\u0010\u0014R\u0017\u0010\u0016\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0013\u001a\u0004\b\t\u0010\u0014\u00a8\u0006\u0019"}, d2 = {"Lqg0/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Z", "d", "()Z", "isSuccess", "b", "I", "()I", "errorCode", "c", "Ljava/lang/String;", "()Ljava/lang/String;", "errorMsg", "data", "<init>", "(ZILjava/lang/String;Ljava/lang/String;)V", "ecommerce_api_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: qg0.a, reason: from toString */
/* loaded from: classes5.dex */
public final /* data */ class ECQQLiveSSOResponse {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isSuccess;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final int errorCode;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String errorMsg;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String data;

    public ECQQLiveSSOResponse(boolean z16, int i3, @NotNull String str, @NotNull String str2) {
        this.isSuccess = z16;
        this.errorCode = i3;
        this.errorMsg = str;
        this.data = str2;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getData() {
        return this.data;
    }

    /* renamed from: b, reason: from getter */
    public final int getErrorCode() {
        return this.errorCode;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getErrorMsg() {
        return this.errorMsg;
    }

    /* renamed from: d, reason: from getter */
    public final boolean getIsSuccess() {
        return this.isSuccess;
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof ECQQLiveSSOResponse) {
                ECQQLiveSSOResponse eCQQLiveSSOResponse = (ECQQLiveSSOResponse) other;
                if (this.isSuccess != eCQQLiveSSOResponse.isSuccess || this.errorCode != eCQQLiveSSOResponse.errorCode || !Intrinsics.areEqual(this.errorMsg, eCQQLiveSSOResponse.errorMsg) || !Intrinsics.areEqual(this.data, eCQQLiveSSOResponse.data)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    public int hashCode() {
        int i3;
        boolean z16 = this.isSuccess;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        int i16 = ((r06 * 31) + this.errorCode) * 31;
        String str = this.errorMsg;
        int i17 = 0;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = 0;
        }
        int i18 = (i16 + i3) * 31;
        String str2 = this.data;
        if (str2 != null) {
            i17 = str2.hashCode();
        }
        return i18 + i17;
    }

    @NotNull
    public String toString() {
        return "ECQQLiveSSOResponse(isSuccess=" + this.isSuccess + ", errorCode=" + this.errorCode + ", errorMsg=" + this.errorMsg + ", data=" + this.data + ")";
    }
}
