package yi3;

import android.net.Uri;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u001a\u0010\u000e\u001a\u00020\u00048\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0012\u001a\u00020\u000f8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u0004\u0018\u00010\u00138VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0018\u001a\u00020\u00048VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0017\u0010\r\u00a8\u0006\u001b"}, d2 = {"Lyi3/b;", "Lyi3/e;", "", "toString", "", "hashCode", "", "other", "", "equals", "a", "I", "d", "()I", "showExpire", "", "b", "()J", "id", "Landroid/net/Uri;", "c", "()Landroid/net/Uri;", WadlProxyConsts.KEY_JUMP_URL, "e", "type", "<init>", "(I)V", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: yi3.b, reason: from toString */
/* loaded from: classes21.dex */
public final /* data */ class ZPlanMiniHomeGuidanceBubbleInfo extends e {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int showExpire;

    public ZPlanMiniHomeGuidanceBubbleInfo() {
        this(0, 1, null);
    }

    @Override // yi3.e
    public long b() {
        return 0L;
    }

    @Override // yi3.e
    @Nullable
    public Uri c() {
        return null;
    }

    @Override // yi3.e
    /* renamed from: d, reason: from getter */
    public int getShowExpire() {
        return this.showExpire;
    }

    @Override // yi3.e
    public int e() {
        return 3;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if ((other instanceof ZPlanMiniHomeGuidanceBubbleInfo) && getShowExpire() == ((ZPlanMiniHomeGuidanceBubbleInfo) other).getShowExpire()) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return getShowExpire();
    }

    @NotNull
    public String toString() {
        return "ZPlanMiniHomeGuidanceBubbleInfo(showExpire=" + getShowExpire() + ')';
    }

    public /* synthetic */ ZPlanMiniHomeGuidanceBubbleInfo(int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? 6 : i3);
    }

    public ZPlanMiniHomeGuidanceBubbleInfo(int i3) {
        super(null);
        this.showExpire = i3;
    }
}
