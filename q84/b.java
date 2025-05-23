package q84;

import com.tencent.mobileqq.vas.theme.ThemeReporter;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u0000 \u001b2\u00020\u0001:\u0001\u0005B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0019\u0010\nB\u0019\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\u0004\u0012\u0006\u0010\u0011\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\"\u0010\u000b\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\u000e\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\u0006\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\"\u0010\u0011\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0006\u001a\u0004\b\u0005\u0010\b\"\u0004\b\u0010\u0010\nR\"\u0010\u0015\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lq84/b;", "", "", "toString", "", "a", "I", "b", "()I", "setPosition", "(I)V", "position", ThemeReporter.BUNDLE_KEY_TASK_GET_STATUS, "setStatus", "status", "c", "setNextPosition", "nextPosition", "", "d", "Z", "isFullVideo", "()Z", "setFullVideo", "(Z)V", "<init>", "(II)V", "e", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private int mPosition;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private int status;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private int mNextPosition;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean isFullVideo;

    public b(int i3) {
        this.mPosition = i3;
        this.mNextPosition = -1;
    }

    /* renamed from: a, reason: from getter */
    public final int getMNextPosition() {
        return this.mNextPosition;
    }

    /* renamed from: b, reason: from getter */
    public final int getMPosition() {
        return this.mPosition;
    }

    public String toString() {
        return "QFSFeedSelectInfo{mStatus=" + this.status + ", mPosition=" + this.mPosition + ", mNextPosition=" + this.mNextPosition + ", isFullVideo=" + this.isFullVideo + "}";
    }

    public b(int i3, int i16) {
        this(i3);
        this.mNextPosition = i16;
    }
}
