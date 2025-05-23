package zf3;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richmediabrowser.utils.ScreenUtils;
import com.tencent.sqshow.zootopia.utils.i;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import t74.u;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b1\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b3\u00104J\u0006\u0010\u0003\u001a\u00020\u0002R\"\u0010\u000b\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0017\u0010\u000e\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0006\u001a\u0004\b\r\u0010\bR\u0017\u0010\u0011\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0006\u001a\u0004\b\u0010\u0010\bR\u0014\u0010\u0013\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0006R\u0017\u0010\u0016\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0006\u001a\u0004\b\u0015\u0010\bR\u0017\u0010\u0019\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0006\u001a\u0004\b\u0018\u0010\bR\"\u0010\u001b\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0006\u001a\u0004\b\u0014\u0010\b\"\u0004\b\u001a\u0010\nR\u0017\u0010\u001d\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u0006\u001a\u0004\b\u001c\u0010\bR\u0017\u0010\u001f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0006\u001a\u0004\b\u001e\u0010\bR\u0017\u0010!\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0006\u001a\u0004\b \u0010\bR\u0017\u0010#\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0006\u001a\u0004\b\"\u0010\bR\"\u0010&\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b$\u0010\u0006\u001a\u0004\b$\u0010\b\"\u0004\b%\u0010\nR\u0017\u0010(\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\"\u0010\u0006\u001a\u0004\b'\u0010\bR\u0017\u0010*\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b \u0010\u0006\u001a\u0004\b)\u0010\bR\u0017\u0010,\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u0006\u001a\u0004\b+\u0010\bR\u0017\u0010-\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b+\u0010\u0006\u001a\u0004\b\u0012\u0010\bR\u0017\u0010.\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b)\u0010\u0006\u001a\u0004\b\u0017\u0010\bR\u0017\u0010/\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b'\u0010\u0006\u001a\u0004\b\f\u0010\bR\u0017\u00100\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0006\u001a\u0004\b\u000f\u0010\bR\u0017\u00102\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b1\u0010\u0006\u001a\u0004\b\u0005\u0010\b\u00a8\u00065"}, d2 = {"Lzf3/d;", "", "", "t", "", "b", "I", "l", "()I", "setMScreenWidth", "(I)V", "mScreenWidth", "c", "i", "mLeftPadding", "d", "k", "mRightPadding", "e", "mCenterMargin", "f", h.F, "mItemTopMargin", "g", "j", "mOffScreenSize", "setMItemPicAreaHeight", "mItemPicAreaHeight", "a", "mDescTopMarin", "p", "mTitleTopMargin", "o", "mTitleBottomMargin", DomainData.DOMAIN_NAME, "mStaggerItemTxvMargin", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "setMSingleCardWidth", "mSingleCardWidth", ReportConstant.COSTREPORT_PREFIX, "mTopLabelHeight", "r", "mTopLabelContentMargin", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "mTopLabelAreaHeight", "mItemLeftTopLabelHeight", "mItemRightTopLabelHeight", "mItemLeftBtmLabelHeight", "mItemLeftBtmLabelIconWidth", "u", "mItemBtmLabelHeight", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final d f452428a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static int mScreenWidth;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final int mLeftPadding;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static final int mRightPadding;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static final int mCenterMargin;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static final int mItemTopMargin;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private static final int mOffScreenSize;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private static int mItemPicAreaHeight;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private static final int mDescTopMarin;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private static final int mTitleTopMargin;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private static final int mTitleBottomMargin;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private static final int mStaggerItemTxvMargin;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private static int mSingleCardWidth;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private static final int mTopLabelHeight;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private static final int mTopLabelContentMargin;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    private static final int mTopLabelAreaHeight;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    private static final int mItemLeftTopLabelHeight;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    private static final int mItemRightTopLabelHeight;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    private static final int mItemLeftBtmLabelHeight;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata */
    private static final int mItemLeftBtmLabelIconWidth;

    /* renamed from: u, reason: collision with root package name and from kotlin metadata */
    private static final int mItemBtmLabelHeight;

    static {
        d dVar = new d();
        f452428a = dVar;
        mLeftPadding = i.b(15);
        mRightPadding = i.b(15);
        mCenterMargin = i.b(6);
        mItemTopMargin = i.b(9);
        mOffScreenSize = ScreenUtils.getScreenWidth(BaseApplication.context);
        mDescTopMarin = i.b(9);
        mTitleTopMargin = i.b(7);
        mTitleBottomMargin = i.b(11);
        mStaggerItemTxvMargin = i.b(2);
        int b16 = i.b(24);
        mTopLabelHeight = b16;
        mTopLabelContentMargin = i.b(20);
        mTopLabelAreaHeight = b16 + (i.b(4) * 2);
        mItemLeftTopLabelHeight = i.b(20);
        mItemRightTopLabelHeight = i.b(22);
        mItemLeftBtmLabelHeight = i.a(12.5f);
        mItemLeftBtmLabelIconWidth = i.b(10);
        mItemBtmLabelHeight = i.b(14);
        dVar.t();
    }

    d() {
    }

    public final int a() {
        return mDescTopMarin;
    }

    public final int b() {
        return mItemBtmLabelHeight;
    }

    public final int c() {
        return mItemLeftBtmLabelHeight;
    }

    public final int d() {
        return mItemLeftBtmLabelIconWidth;
    }

    public final int e() {
        return mItemLeftTopLabelHeight;
    }

    public final int f() {
        return mItemPicAreaHeight;
    }

    public final int g() {
        return mItemRightTopLabelHeight;
    }

    public final int h() {
        return mItemTopMargin;
    }

    public final int i() {
        return mLeftPadding;
    }

    public final int j() {
        return mOffScreenSize;
    }

    public final int k() {
        return mRightPadding;
    }

    public final int l() {
        return mScreenWidth;
    }

    public final int m() {
        return mSingleCardWidth;
    }

    public final int n() {
        return mStaggerItemTxvMargin;
    }

    public final int o() {
        return mTitleBottomMargin;
    }

    public final int p() {
        return mTitleTopMargin;
    }

    public final int q() {
        return mTopLabelAreaHeight;
    }

    public final int r() {
        return mTopLabelContentMargin;
    }

    public final int s() {
        return mTopLabelHeight;
    }

    public final void t() {
        u.Companion companion = u.INSTANCE;
        BaseApplication context = BaseApplication.context;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        QLog.e("StaggerDimenConstant", 1, "updateLayoutParams - " + u.Companion.e(companion, context, false, 2, null));
        int c16 = companion.c(BaseApplication.context);
        mScreenWidth = c16;
        int i3 = (((c16 - mLeftPadding) - mRightPadding) - mCenterMargin) / 2;
        mSingleCardWidth = i3;
        mItemPicAreaHeight = (int) (i3 * 1.336f);
    }
}
