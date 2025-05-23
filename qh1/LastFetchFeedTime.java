package qh1;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\r\u001a\u00020\t\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lqh1/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "a", "J", "()J", "time", "<init>", "(J)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: qh1.a, reason: from toString */
/* loaded from: classes13.dex */
public final /* data */ class LastFetchFeedTime {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final long time;

    public LastFetchFeedTime() {
        this(0L, 1, null);
    }

    /* renamed from: a, reason: from getter */
    public final long getTime() {
        return this.time;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if ((other instanceof LastFetchFeedTime) && this.time == ((LastFetchFeedTime) other).time) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return androidx.fragment.app.a.a(this.time);
    }

    @NotNull
    public String toString() {
        return "LastFetchFeedTime(time=" + this.time + ")";
    }

    public LastFetchFeedTime(long j3) {
        this.time = j3;
    }

    public /* synthetic */ LastFetchFeedTime(long j3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0L : j3);
    }
}
