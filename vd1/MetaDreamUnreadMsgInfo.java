package vd1;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0011\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u000f\u001a\u0004\b\t\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lvd1/c;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "b", "()I", "unreadCount", "", "J", "()J", "lastestMsgTime", "<init>", "(IJ)V", "qqgamecenter-qa-api_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: vd1.c, reason: from toString */
/* loaded from: classes12.dex */
public final /* data */ class MetaDreamUnreadMsgInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int unreadCount;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final long lastestMsgTime;

    public MetaDreamUnreadMsgInfo(int i3, long j3) {
        this.unreadCount = i3;
        this.lastestMsgTime = j3;
    }

    /* renamed from: a, reason: from getter */
    public final long getLastestMsgTime() {
        return this.lastestMsgTime;
    }

    /* renamed from: b, reason: from getter */
    public final int getUnreadCount() {
        return this.unreadCount;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MetaDreamUnreadMsgInfo)) {
            return false;
        }
        MetaDreamUnreadMsgInfo metaDreamUnreadMsgInfo = (MetaDreamUnreadMsgInfo) other;
        if (this.unreadCount == metaDreamUnreadMsgInfo.unreadCount && this.lastestMsgTime == metaDreamUnreadMsgInfo.lastestMsgTime) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.unreadCount * 31) + androidx.fragment.app.a.a(this.lastestMsgTime);
    }

    @NotNull
    public String toString() {
        return "MetaDreamUnreadMsgInfo(unreadCount=" + this.unreadCount + ", lastestMsgTime=" + this.lastestMsgTime + ')';
    }
}
