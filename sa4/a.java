package sa4;

import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u001e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004J'\u0010\n\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0016\u0010\f\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004J\u0016\u0010\r\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004\u00a8\u0006\u0010"}, d2 = {"Lsa4/a;", "", "", "isIncrease", "", "position", "realCount", "b", "originalVirtualPosition", "totalItemCount", "a", "(III)Ljava/lang/Integer;", "d", "c", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f433598a = new a();

    a() {
    }

    public final int b(boolean isIncrease, int position, int realCount) {
        if (!isIncrease) {
            return position;
        }
        if (position == 0) {
            return realCount - 1;
        }
        if (position == realCount + 1) {
            return 0;
        }
        return position - 1;
    }

    public final int c(boolean isIncrease, int position) {
        if (!isIncrease) {
            return position;
        }
        return position + 1;
    }

    public final boolean d(int originalVirtualPosition, int totalItemCount) {
        if (originalVirtualPosition == 0 || originalVirtualPosition == totalItemCount - 1) {
            return true;
        }
        return false;
    }

    public final Integer a(int originalVirtualPosition, int realCount, int totalItemCount) {
        if (originalVirtualPosition == 0) {
            return Integer.valueOf(realCount);
        }
        return originalVirtualPosition == totalItemCount - 1 ? 1 : null;
    }
}
