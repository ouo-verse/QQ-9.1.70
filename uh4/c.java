package uh4;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.activity.miniaio.MiniChatConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u001a\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b3\u0018\u00002\u00020\u0001:\u0001:B\u0007\u00a2\u0006\u0004\b8\u00109J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0006\u0010\u0007\u001a\u00020\u0004J\u000e\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bJ\u0006\u0010\u000b\u001a\u00020\bJ\u000e\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\bJ\u0006\u0010\u000e\u001a\u00020\bJ\u000e\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\bJ\u000e\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\bJ\u000e\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0013\u001a\u00020\bJ\u0006\u0010\u0014\u001a\u00020\bJ\b\u0010\u0015\u001a\u00020\u0000H\u0016R\"\u0010\u001c\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0017\u0010\u001e\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0017\u001a\u0004\b\u001d\u0010\u0019R\u0017\u0010 \u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0017\u001a\u0004\b\u001f\u0010\u0019R\u0017\u0010\"\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0017\u001a\u0004\b!\u0010\u0019R\u0016\u0010#\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0017R\u0016\u0010$\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0017R\u0016\u0010&\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010\u0017R\u0016\u0010(\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010\u0017R\u0016\u0010*\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010\u0017R\u0016\u0010-\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0016\u0010\u0005\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010,R\u0016\u00100\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u0010,R\u0016\u00101\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0017R\u0016\u00103\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u0010\u0017R\u0016\u00105\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u0010\u0017R\u0016\u00107\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u0010\u0017\u00a8\u0006;"}, d2 = {"Luh4/c;", "", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", MiniChatConstants.MINI_APP_LANDSCAPE, "l", "f", "", "floatingCenterX", "o", h.F, "floatingCenterY", "p", "i", "w", ReportConstant.COSTREPORT_PREFIX, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, DomainData.DOMAIN_NAME, "k", "j", "e", "d", "I", "getShadowOffset", "()I", "r", "(I)V", NodeProps.SHADOW_OFFSET, "getDEFAULT_TOP_PADDING_DP", "DEFAULT_TOP_PADDING_DP", "getDEFAULT_BOTTOM_PADDING_DP", "DEFAULT_BOTTOM_PADDING_DP", "getDEFAULT_LEFT_PADDING_DP", "DEFAULT_LEFT_PADDING_DP", "mWidth", "mHeight", BdhLogUtil.LogTag.Tag_Conn, "mRoundCorner", "D", "mFloatingCenterX", "E", "mFloatingCenterY", UserInfo.SEX_FEMALE, "Z", "mCanMove", "G", "H", "visibleWhenBackground", "topPadding", "J", "bottomPadding", "K", "leftPadding", "L", "rightPadding", "<init>", "()V", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class c implements Cloneable {

    /* renamed from: C, reason: from kotlin metadata */
    private int mRoundCorner;

    /* renamed from: G, reason: from kotlin metadata */
    private boolean isLandscape;

    /* renamed from: H, reason: from kotlin metadata */
    private boolean visibleWhenBackground;

    /* renamed from: I, reason: from kotlin metadata */
    private int topPadding;

    /* renamed from: J, reason: from kotlin metadata */
    private int bottomPadding;

    /* renamed from: K, reason: from kotlin metadata */
    private int leftPadding;

    /* renamed from: L, reason: from kotlin metadata */
    private int rightPadding;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int DEFAULT_TOP_PADDING_DP;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final int DEFAULT_BOTTOM_PADDING_DP;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final int DEFAULT_LEFT_PADDING_DP;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int shadowOffset = 6;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int mWidth = 128;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int mHeight = 128;

    /* renamed from: D, reason: from kotlin metadata */
    private int mFloatingCenterX = 1;

    /* renamed from: E, reason: from kotlin metadata */
    private int mFloatingCenterY = 200;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean mCanMove = true;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 \u001b2\u00020\u0001:\u0001\u0010B\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u000e\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005J\u000e\u0010\t\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0005J\u000e\u0010\u000b\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0002J\u0016\u0010\u000e\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0002J\u0006\u0010\u0010\u001a\u00020\u000fR\u0016\u0010\u0006\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0012\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0011R\u0016\u0010\u0013\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0011R\u0016\u0010\u0015\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0014R\u0016\u0010\u0016\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0014R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0014R\u0016\u0010\u0018\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0014\u00a8\u0006\u001c"}, d2 = {"Luh4/c$a;", "", "", "shadowPadding", "d", "", "canMove", "b", NodeProps.VISIBLE, "f", "corner", "c", "width", "height", "e", "Luh4/c;", "a", "Z", MiniChatConstants.MINI_APP_LANDSCAPE, "visibleWhenBackground", "I", "customWidth", "customHeight", "g", "roundCorner", "<init>", "()V", h.F, "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class a {

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private boolean isLandscape;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private boolean visibleWhenBackground;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        private int roundCorner;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private boolean canMove = true;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private int customWidth = Integer.MIN_VALUE;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private int customHeight = Integer.MIN_VALUE;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private int shadowPadding = 6;

        @NotNull
        public final c a() {
            c cVar = new c();
            int i3 = this.customWidth;
            if (i3 != Integer.MIN_VALUE && this.customHeight != Integer.MIN_VALUE) {
                cVar.s(i3);
                cVar.q(this.customHeight);
            }
            cVar.n(this.isLandscape);
            cVar.mCanMove = this.canMove;
            cVar.visibleWhenBackground = this.visibleWhenBackground;
            cVar.r(this.shadowPadding);
            cVar.mRoundCorner = this.roundCorner;
            cVar.m();
            return cVar;
        }

        @NotNull
        public final a b(boolean canMove) {
            this.canMove = canMove;
            return this;
        }

        @NotNull
        public final a c(int corner) {
            this.roundCorner = corner;
            return this;
        }

        @NotNull
        public final a d(int shadowPadding) {
            this.shadowPadding = shadowPadding;
            return this;
        }

        @NotNull
        public final a e(int width, int height) {
            this.customWidth = width;
            this.customHeight = height;
            return this;
        }

        @NotNull
        public final a f(boolean visible) {
            this.visibleWhenBackground = visible;
            return this;
        }
    }

    public c() {
        int i3 = 74 - 6;
        this.DEFAULT_TOP_PADDING_DP = i3;
        int i16 = 70 - 6;
        this.DEFAULT_BOTTOM_PADDING_DP = i16;
        int i17 = 14 - 6;
        this.DEFAULT_LEFT_PADDING_DP = i17;
        this.topPadding = ViewUtils.dpToPx(i3);
        this.bottomPadding = ViewUtils.dpToPx(i16);
        this.leftPadding = ViewUtils.dpToPx(i17);
        this.rightPadding = ViewUtils.dpToPx(i17);
    }

    private final void l(boolean isLandscape) {
        if (isLandscape) {
            this.topPadding = ViewUtils.dpToPx(this.DEFAULT_LEFT_PADDING_DP);
            this.bottomPadding = ViewUtils.dpToPx(this.DEFAULT_LEFT_PADDING_DP);
            this.leftPadding = ViewUtils.dpToPx(this.DEFAULT_TOP_PADDING_DP);
            this.rightPadding = ViewUtils.dpToPx(this.DEFAULT_BOTTOM_PADDING_DP);
            return;
        }
        this.topPadding = ViewUtils.dpToPx(this.DEFAULT_TOP_PADDING_DP);
        this.bottomPadding = ViewUtils.dpToPx(this.DEFAULT_BOTTOM_PADDING_DP);
        this.leftPadding = ViewUtils.dpToPx(this.DEFAULT_LEFT_PADDING_DP);
        this.rightPadding = ViewUtils.dpToPx(this.DEFAULT_LEFT_PADDING_DP);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m() {
        if (QLog.isColorLevel()) {
            QLog.d("YseFloatParams", 2, ", width:", Integer.valueOf(this.mWidth), ", height:", Integer.valueOf(this.mHeight));
        }
        l(this.isLandscape);
    }

    @NotNull
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public c clone() {
        c cVar = null;
        try {
            Object clone = super.clone();
            if (clone instanceof c) {
                cVar = (c) clone;
            }
        } catch (CloneNotSupportedException e16) {
            e16.printStackTrace();
        }
        if (cVar == null) {
            return new c();
        }
        return cVar;
    }

    /* renamed from: f, reason: from getter */
    public final boolean getMCanMove() {
        return this.mCanMove;
    }

    /* renamed from: h, reason: from getter */
    public final int getMFloatingCenterX() {
        return this.mFloatingCenterX;
    }

    /* renamed from: i, reason: from getter */
    public final int getMFloatingCenterY() {
        return this.mFloatingCenterY;
    }

    /* renamed from: j, reason: from getter */
    public final int getMHeight() {
        return this.mHeight;
    }

    /* renamed from: k, reason: from getter */
    public final int getMWidth() {
        return this.mWidth;
    }

    public final void n(boolean isLandscape) {
        this.isLandscape = isLandscape;
        l(isLandscape);
    }

    public final void o(int floatingCenterX) {
        this.mFloatingCenterX = floatingCenterX;
    }

    public final void p(int floatingCenterY) {
        this.mFloatingCenterY = floatingCenterY;
    }

    public final void q(int h16) {
        this.mHeight = h16;
    }

    public final void r(int i3) {
        this.shadowOffset = i3;
    }

    public final void s(int w3) {
        this.mWidth = w3;
    }
}
