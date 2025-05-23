package yi;

import com.qzone.proxy.feedcomponent.model.n;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u0012\u001a\u00020\u000e\u0012\u0006\u0010\u0014\u001a\u00020\u000e\u0012\u0006\u0010\u0019\u001a\u00020\u0015\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0012\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011R\u0017\u0010\u0014\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0010\u001a\u0004\b\t\u0010\u0011R\u0017\u0010\u0019\u001a\u00020\u00158\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0013\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lyi/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "getMsgType", "()I", QQBrowserActivity.KEY_MSG_TYPE, "", "b", "J", "()J", "msgId", "c", "elementId", "Lyi/b;", "d", "Lyi/b;", "()Lyi/b;", "req", "<init>", "(IJJLyi/b;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: yi.a, reason: from toString */
/* loaded from: classes36.dex */
public final /* data */ class DownLoadParam {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int msgType;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final long msgId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final long elementId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final DownlandReq req;

    public DownLoadParam(int i3, long j3, long j16, DownlandReq req) {
        Intrinsics.checkNotNullParameter(req, "req");
        this.msgType = i3;
        this.msgId = j3;
        this.elementId = j16;
        this.req = req;
    }

    /* renamed from: a, reason: from getter */
    public final long getElementId() {
        return this.elementId;
    }

    /* renamed from: b, reason: from getter */
    public final long getMsgId() {
        return this.msgId;
    }

    /* renamed from: c, reason: from getter */
    public final DownlandReq getReq() {
        return this.req;
    }

    public int hashCode() {
        return (((((this.msgType * 31) + n.a(this.msgId)) * 31) + n.a(this.elementId)) * 31) + this.req.hashCode();
    }

    public String toString() {
        return "DownLoadParam(msgType=" + this.msgType + ", msgId=" + this.msgId + ", elementId=" + this.elementId + ", req=" + this.req + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DownLoadParam)) {
            return false;
        }
        DownLoadParam downLoadParam = (DownLoadParam) other;
        return this.msgType == downLoadParam.msgType && this.msgId == downLoadParam.msgId && this.elementId == downLoadParam.elementId && Intrinsics.areEqual(this.req, downLoadParam.req);
    }
}
