package yi;

import com.tencent.qqnt.kernel.nativeinterface.FileTransNotifyInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0080\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\t\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lyi/m;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/qqnt/kernel/nativeinterface/FileTransNotifyInfo;", "a", "Lcom/tencent/qqnt/kernel/nativeinterface/FileTransNotifyInfo;", "()Lcom/tencent/qqnt/kernel/nativeinterface/FileTransNotifyInfo;", "notifyInfo", "<init>", "(Lcom/tencent/qqnt/kernel/nativeinterface/FileTransNotifyInfo;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: yi.m, reason: from toString */
/* loaded from: classes36.dex */
public final /* data */ class PicPayLoad {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final FileTransNotifyInfo notifyInfo;

    public PicPayLoad(FileTransNotifyInfo notifyInfo) {
        Intrinsics.checkNotNullParameter(notifyInfo, "notifyInfo");
        this.notifyInfo = notifyInfo;
    }

    /* renamed from: a, reason: from getter */
    public final FileTransNotifyInfo getNotifyInfo() {
        return this.notifyInfo;
    }

    public int hashCode() {
        return this.notifyInfo.hashCode();
    }

    public String toString() {
        return "PicPayLoad(notifyInfo=" + this.notifyInfo + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof PicPayLoad) && Intrinsics.areEqual(this.notifyInfo, ((PicPayLoad) other).notifyInfo);
    }
}
