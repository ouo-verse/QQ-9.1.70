package pw0;

import fu0.c;
import fu0.e;
import kotlin.Metadata;
import pw0.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0016R\u0016\u0010\f\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lpw0/a;", "Lpw0/b;", "", "uid", "", "c", "roomId", "", "isOpenAnchorProfile", "acquireAnchorUid", "a", "J", "anchorUid", "<init>", "()V", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public class a implements b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private long anchorUid;

    @Override // pw0.b
    public long a() {
        return b.a.a(this);
    }

    @Override // pw0.b
    public long acquireAnchorUid(long roomId) {
        e n3;
        long j3 = this.anchorUid;
        if (j3 > 0) {
            return j3;
        }
        c cVar = (c) qx0.a.b(c.class);
        if (cVar == null || (n3 = cVar.n(roomId)) == null) {
            return 0L;
        }
        return n3.getAnchorUid();
    }

    @Override // pw0.b
    public boolean b(long j3) {
        return b.a.b(this, j3);
    }

    @Override // pw0.b
    public void c(long uid) {
        this.anchorUid = uid;
    }

    @Override // pw0.b
    public boolean isOpenAnchorProfile(long roomId, long uid) {
        if (acquireAnchorUid(roomId) == uid) {
            return true;
        }
        return false;
    }

    @Override // pw0.b
    public boolean isShowGiftBtn() {
        return b.a.c(this);
    }
}
