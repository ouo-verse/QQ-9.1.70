package qp1;

import android.util.Log;
import com.tencent.mobileqq.guild.homev2.misc.scroll.ScrollStateType;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.cw;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b.\b\u0086\b\u0018\u0000 \u001a2\u00020\u0001:\u0001\u0018BC\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0002\u0012\b\b\u0002\u0010\b\u001a\u00020\u0002\u0012\b\b\u0003\u0010\u0006\u001a\u00020\u0002\u0012\b\b\u0002\u0010*\u001a\u00020\t\u0012\b\b\u0002\u0010.\u001a\u00020\u0002\u0012\b\b\u0002\u00101\u001a\u00020\u0002\u00a2\u0006\u0004\b5\u00106J\u0012\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0002H\u0002J\u000e\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0002J\u000e\u0010\f\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0002J\"\u0010\u0010\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00042\b\b\u0002\u0010\u000f\u001a\u00020\u0002J\u000e\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\tJ\u0006\u0010\u0013\u001a\u00020\tJ\b\u0010\u0014\u001a\u00020\u0004H\u0016J\t\u0010\u0015\u001a\u00020\u0002H\u00d6\u0001J\u0013\u0010\u0017\u001a\u00020\t2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u001e\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010\b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010\u0019\u001a\u0004\b \u0010\u001b\"\u0004\b!\u0010\u001dR\"\u0010\u0006\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\"\u0010\u0019\u001a\u0004\b#\u0010\u001b\"\u0004\b$\u0010\u001dR\"\u0010*\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\"\u0010.\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b+\u0010\u0019\u001a\u0004\b,\u0010\u001b\"\u0004\b-\u0010\u001dR\"\u00101\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010\u0019\u001a\u0004\b/\u0010\u001b\"\u0004\b0\u0010\u001dR\u0011\u00104\u001a\u00020\u00048F\u00a2\u0006\u0006\u001a\u0004\b2\u00103\u00a8\u00067"}, d2 = {"Lqp1/b;", "", "", "direction", "", "d", "state", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "collapseHeight", "", DomainData.DOMAIN_NAME, "newDirection", "p", "newOffset", "from", "newState", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "newIsTouching", "o", "k", "toString", "hashCode", "other", "equals", "a", "I", "g", "()I", "setOffset", "(I)V", "offset", "b", "f", "setCollapseHeight", "c", "i", "setState", "Z", "l", "()Z", "setTouching", "(Z)V", "isTouching", "e", "getMovingDirection", "setMovingDirection", "movingDirection", h.F, "setPullRefreshHeight", "pullRefreshHeight", "j", "()Ljava/lang/String;", "stateDesc", "<init>", "(IIIZII)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: qp1.b, reason: from toString */
/* loaded from: classes13.dex */
public final /* data */ class ScrollStateData {

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: h, reason: collision with root package name */
    private static final int f429159h = (int) cw.b(70);

    /* renamed from: i, reason: collision with root package name */
    private static final int f429160i = (int) cw.b(70);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private int offset;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private int collapseHeight;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private int state;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean isTouching;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private int movingDirection;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private int pullRefreshHeight;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lqp1/b$a;", "", "", "DEFAULT_PULL_DOWN_MAX_RANGE", "I", "a", "()I", "DEFAULT_PULL_DOWN_THRESHOLD", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: qp1.b$a, reason: from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return ScrollStateData.f429160i;
        }

        Companion() {
        }
    }

    public ScrollStateData() {
        this(0, 0, 0, false, 0, 0, 63, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String d(int direction) {
        if (direction != -1) {
            if (direction != 0) {
                if (direction != 1) {
                    return QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER;
                }
                return "\u2191";
            }
            return "\u23f9";
        }
        return "\u2193";
    }

    static /* synthetic */ String e(ScrollStateData scrollStateData, int i3, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            i3 = scrollStateData.movingDirection;
        }
        return scrollStateData.d(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String m(int state) {
        return ScrollStateType.INSTANCE.b(state);
    }

    public static /* synthetic */ boolean r(ScrollStateData scrollStateData, int i3, String str, int i16, int i17, Object obj) {
        if ((i17 & 2) != 0) {
            str = "";
        }
        if ((i17 & 4) != 0) {
            i16 = scrollStateData.state;
        }
        return scrollStateData.q(i3, str, i16);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ScrollStateData)) {
            return false;
        }
        ScrollStateData scrollStateData = (ScrollStateData) other;
        if (this.offset == scrollStateData.offset && this.collapseHeight == scrollStateData.collapseHeight && this.state == scrollStateData.state && this.isTouching == scrollStateData.isTouching && this.movingDirection == scrollStateData.movingDirection && this.pullRefreshHeight == scrollStateData.pullRefreshHeight) {
            return true;
        }
        return false;
    }

    /* renamed from: f, reason: from getter */
    public final int getCollapseHeight() {
        return this.collapseHeight;
    }

    /* renamed from: g, reason: from getter */
    public final int getOffset() {
        return this.offset;
    }

    /* renamed from: h, reason: from getter */
    public final int getPullRefreshHeight() {
        return this.pullRefreshHeight;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int i3 = ((((this.offset * 31) + this.collapseHeight) * 31) + this.state) * 31;
        boolean z16 = this.isTouching;
        int i16 = z16;
        if (z16 != 0) {
            i16 = 1;
        }
        return ((((i3 + i16) * 31) + this.movingDirection) * 31) + this.pullRefreshHeight;
    }

    /* renamed from: i, reason: from getter */
    public final int getState() {
        return this.state;
    }

    @NotNull
    public final String j() {
        return m(this.state);
    }

    public final boolean k() {
        return ScrollStateType.INSTANCE.a(this.state);
    }

    /* renamed from: l, reason: from getter */
    public final boolean getIsTouching() {
        return this.isTouching;
    }

    public final boolean n(int collapseHeight) {
        if (this.collapseHeight == collapseHeight) {
            return false;
        }
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("Guild.NewHome.ScrollStateData", "updateCollapseHeight: from " + getCollapseHeight() + " to " + collapseHeight);
        }
        this.collapseHeight = collapseHeight;
        return true;
    }

    public final boolean o(boolean newIsTouching) {
        if (this.isTouching == newIsTouching) {
            return false;
        }
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("Guild.NewHome.ScrollStateData", "updateIsTouching: isTouching:" + getIsTouching() + " -> " + newIsTouching);
        }
        this.isTouching = newIsTouching;
        return true;
    }

    public final boolean p(int newDirection) {
        if (this.movingDirection == newDirection) {
            return false;
        }
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("Guild.NewHome.ScrollStateData", "updateMovingDirection: from " + e(this, 0, 1, null) + " to " + d(newDirection));
        }
        this.movingDirection = newDirection;
        return true;
    }

    public final boolean q(int newOffset, @NotNull String from, int newState) {
        int i3;
        Intrinsics.checkNotNullParameter(from, "from");
        int i16 = 2;
        if (newOffset > 0) {
            if (!ScrollStateType.INSTANCE.a(newState)) {
                newState = 1;
            }
            if (!this.isTouching && this.offset <= 0) {
                i3 = 0;
            } else {
                i16 = newState;
                i3 = newOffset;
            }
        } else {
            if (newOffset < 0) {
                int i17 = this.collapseHeight;
                if (newOffset <= (-i17)) {
                    i3 = -i17;
                    i16 = 0;
                } else {
                    i3 = newOffset;
                    i16 = 1;
                }
            }
            i3 = newOffset;
        }
        if (this.state == i16 && this.offset == i3) {
            return false;
        }
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("Guild.NewHome.ScrollStateData", "[" + from + "]updateOffset(" + newOffset + ") offset:(old:" + getOffset() + " new:" + i3 + ") state:(old:" + m(getState()) + " new:" + m(i16) + ")");
        }
        this.offset = i3;
        this.state = i16;
        return true;
    }

    @NotNull
    public String toString() {
        int i3 = this.pullRefreshHeight;
        int i16 = this.offset;
        int i17 = this.collapseHeight;
        int i18 = this.state;
        return "ScrollStateData(pullRefreshHeight=" + i3 + ", offset=" + i16 + ", collapseHeight=" + i17 + ", state=" + i18 + ", isTouching=" + this.isTouching + ", movingDirection=" + this.movingDirection + ", stateDesc='" + m(i18) + "')";
    }

    public ScrollStateData(int i3, int i16, @ScrollStateType int i17, boolean z16, int i18, int i19) {
        this.offset = i3;
        this.collapseHeight = i16;
        this.state = i17;
        this.isTouching = z16;
        this.movingDirection = i18;
        this.pullRefreshHeight = i19;
    }

    public /* synthetic */ ScrollStateData(int i3, int i16, int i17, boolean z16, int i18, int i19, int i26, DefaultConstructorMarker defaultConstructorMarker) {
        this((i26 & 1) != 0 ? 0 : i3, (i26 & 2) != 0 ? 0 : i16, (i26 & 4) != 0 ? 2 : i17, (i26 & 8) != 0 ? false : z16, (i26 & 16) == 0 ? i18 : 0, (i26 & 32) != 0 ? f429159h : i19);
    }
}
