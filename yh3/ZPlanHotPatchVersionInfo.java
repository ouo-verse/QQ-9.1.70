package yh3;

import com.google.gson.annotations.SerializedName;
import com.heytap.databaseengine.model.UserInfo;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\n\b\u0086\b\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB'\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\u0006\u0010\u0016\u001a\u00020\u0011\u00a2\u0006\u0004\b\u0018\u0010\u0019B\t\b\u0016\u00a2\u0006\u0004\b\u0018\u0010\u001aJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001a\u0010\t\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0012\u001a\u00020\u00118\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u00118\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0013\u001a\u0004\b\u0017\u0010\u0015\u00a8\u0006\u001b"}, d2 = {"Lyh3/e;", "", "", "toString", "", "hashCode", "other", "", "equals", "mViewType", "I", "getMViewType", "()I", "mNeedUpdate", "Z", "a", "()Z", "", "mUpdateSize", UserInfo.SEX_FEMALE, "b", "()F", "mNoticeSize", "getMNoticeSize", "<init>", "(IZFF)V", "()V", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: yh3.e, reason: from toString */
/* loaded from: classes21.dex */
public final /* data */ class ZPlanHotPatchVersionInfo {

    @SerializedName("NeedUpdate")
    private final boolean mNeedUpdate;

    @SerializedName("NoticeSize")
    private final float mNoticeSize;

    @SerializedName("UpdateSize")
    private final float mUpdateSize;

    @SerializedName("ViewType")
    private final int mViewType;

    public ZPlanHotPatchVersionInfo(int i3, boolean z16, float f16, float f17) {
        this.mViewType = i3;
        this.mNeedUpdate = z16;
        this.mUpdateSize = f16;
        this.mNoticeSize = f17;
    }

    /* renamed from: a, reason: from getter */
    public final boolean getMNeedUpdate() {
        return this.mNeedUpdate;
    }

    /* renamed from: b, reason: from getter */
    public final float getMUpdateSize() {
        return this.mUpdateSize;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ZPlanHotPatchVersionInfo)) {
            return false;
        }
        ZPlanHotPatchVersionInfo zPlanHotPatchVersionInfo = (ZPlanHotPatchVersionInfo) other;
        if (this.mViewType == zPlanHotPatchVersionInfo.mViewType && this.mNeedUpdate == zPlanHotPatchVersionInfo.mNeedUpdate && Float.compare(this.mUpdateSize, zPlanHotPatchVersionInfo.mUpdateSize) == 0 && Float.compare(this.mNoticeSize, zPlanHotPatchVersionInfo.mNoticeSize) == 0) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int i3 = this.mViewType * 31;
        boolean z16 = this.mNeedUpdate;
        int i16 = z16;
        if (z16 != 0) {
            i16 = 1;
        }
        return ((((i3 + i16) * 31) + Float.floatToIntBits(this.mUpdateSize)) * 31) + Float.floatToIntBits(this.mNoticeSize);
    }

    @NotNull
    public String toString() {
        return "ZPlanHotPatchVersionInfo(mViewType=" + this.mViewType + ", mNeedUpdate=" + this.mNeedUpdate + ", mUpdateSize=" + this.mUpdateSize + ", mNoticeSize=" + this.mNoticeSize + ')';
    }

    public ZPlanHotPatchVersionInfo() {
        this(0, false, 0.0f, 5120.0f);
    }
}
