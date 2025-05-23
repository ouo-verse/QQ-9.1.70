package yh3;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0013\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u000f\u001a\u00020\u0007\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018B\t\b\u0016\u00a2\u0006\u0004\b\u0017\u0010\u0019J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001a\u0010\t\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\fR\u001a\u0010\u000f\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lyh3/d;", "", "", "toString", "", "hashCode", "other", "", "equals", "mViewType", "I", "c", "()I", "mErrorCode", "a", "mNeedReload", "Z", "getMNeedReload", "()Z", "mVersion", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "<init>", "(IIZLjava/lang/String;)V", "()V", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: yh3.d, reason: from toString */
/* loaded from: classes21.dex */
public final /* data */ class ZPlanHotPatchResult {

    @SerializedName("Error")
    private final int mErrorCode;

    @SerializedName("NeedReload")
    private final boolean mNeedReload;

    @SerializedName("Version")
    @NotNull
    private final String mVersion;

    @SerializedName("ViewType")
    private final int mViewType;

    public ZPlanHotPatchResult(int i3, int i16, boolean z16, @NotNull String mVersion) {
        Intrinsics.checkNotNullParameter(mVersion, "mVersion");
        this.mViewType = i3;
        this.mErrorCode = i16;
        this.mNeedReload = z16;
        this.mVersion = mVersion;
    }

    /* renamed from: a, reason: from getter */
    public final int getMErrorCode() {
        return this.mErrorCode;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getMVersion() {
        return this.mVersion;
    }

    /* renamed from: c, reason: from getter */
    public final int getMViewType() {
        return this.mViewType;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ZPlanHotPatchResult)) {
            return false;
        }
        ZPlanHotPatchResult zPlanHotPatchResult = (ZPlanHotPatchResult) other;
        if (this.mViewType == zPlanHotPatchResult.mViewType && this.mErrorCode == zPlanHotPatchResult.mErrorCode && this.mNeedReload == zPlanHotPatchResult.mNeedReload && Intrinsics.areEqual(this.mVersion, zPlanHotPatchResult.mVersion)) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int i3 = ((this.mViewType * 31) + this.mErrorCode) * 31;
        boolean z16 = this.mNeedReload;
        int i16 = z16;
        if (z16 != 0) {
            i16 = 1;
        }
        return ((i3 + i16) * 31) + this.mVersion.hashCode();
    }

    @NotNull
    public String toString() {
        return "ZPlanHotPatchResult(mViewType=" + this.mViewType + ", mErrorCode=" + this.mErrorCode + ", mNeedReload=" + this.mNeedReload + ", mVersion=" + this.mVersion + ')';
    }

    public ZPlanHotPatchResult() {
        this(0, 0, false, "");
    }
}
