package wb4;

import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import od3.c;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b*\b&\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\bC\u0010DJ*\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\bJ,\u0010\f\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\bH&J\b\u0010\r\u001a\u00020\nH\u0016J\b\u0010\u000e\u001a\u00020\nH\u0016J\b\u0010\u000f\u001a\u00020\nH\u0016J\b\u0010\u0010\u001a\u00020\nH\u0016J\b\u0010\u0011\u001a\u00020\nH\u0016J\b\u0010\u0012\u001a\u00020\nH\u0016J\u0010\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\u0010\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u0013H\u0016J\n\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010\u001a\u001a\u00020\nH\u0016J\u0010\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u001bH\u0016J\u0006\u0010\u001e\u001a\u00020\nJ\b\u0010\u001f\u001a\u00020\nH&R$\u0010&\u001a\u0004\u0018\u00010\u00028\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R$\u0010-\u001a\u0004\u0018\u00010\u00048\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R$\u00103\u001a\u0004\u0018\u00010\u00068\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R$\u00109\u001a\u0004\u0018\u00010\b8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\"\u0010?\u001a\u00020\u00138\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\"\u0010B\u001a\u00020\u00138\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010:\u001a\u0004\b@\u0010<\"\u0004\bA\u0010>\u00a8\u0006E"}, d2 = {"Lwb4/a;", "Lod3/c;", "Landroidx/fragment/app/FragmentActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/app/QBaseFragment;", "fragment", "Lod3/b;", "portal", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "", "j", UserInfo.SEX_FEMALE, "y", "r", "i", "H", h.F, "t", "", "hidden", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "hasFocus", "onWindowFocusChanged", "Landroid/view/View;", "getView", "show", "", "outDuration", "f", "destroy", "G", "d", "Landroidx/fragment/app/FragmentActivity;", BdhLogUtil.LogTag.Tag_Conn, "()Landroidx/fragment/app/FragmentActivity;", "setAttachedActivity", "(Landroidx/fragment/app/FragmentActivity;)V", "attachedActivity", "e", "Lcom/tencent/mobileqq/app/QBaseFragment;", "getAttachedFragment", "()Lcom/tencent/mobileqq/app/QBaseFragment;", "setAttachedFragment", "(Lcom/tencent/mobileqq/app/QBaseFragment;)V", "attachedFragment", "Lod3/b;", "getAttachedPortal", "()Lod3/b;", "setAttachedPortal", "(Lod3/b;)V", "attachedPortal", "Landroid/view/ViewGroup;", "D", "()Landroid/view/ViewGroup;", "setContainerView", "(Landroid/view/ViewGroup;)V", "containerView", "Z", "E", "()Z", "setResumed", "(Z)V", "isResumed", "getHasWindowFocus", "setHasWindowFocus", "hasWindowFocus", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public abstract class a implements c {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private FragmentActivity attachedActivity;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private QBaseFragment attachedFragment;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private od3.b attachedPortal;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private ViewGroup containerView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean isResumed;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean hasWindowFocus;

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: C, reason: from getter */
    public final FragmentActivity getAttachedActivity() {
        return this.attachedActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: D, reason: from getter */
    public final ViewGroup getContainerView() {
        return this.containerView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: E, reason: from getter */
    public final boolean getIsResumed() {
        return this.isResumed;
    }

    public abstract void F(FragmentActivity activity, QBaseFragment fragment, od3.b portal, ViewGroup container);

    public abstract void G();

    @Override // od3.c
    public final void destroy() {
        G();
        this.attachedActivity = null;
        this.attachedFragment = null;
        this.attachedPortal = null;
        this.containerView = null;
    }

    @Override // od3.c
    public void f(long outDuration) {
        View view = getView();
        if (view == null) {
            return;
        }
        view.setVisibility(8);
    }

    public View getView() {
        return this.containerView;
    }

    @Override // od3.c
    public final void j(FragmentActivity activity, QBaseFragment fragment, od3.b portal, ViewGroup container) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(container, "container");
        this.attachedActivity = activity;
        this.attachedFragment = fragment;
        this.attachedPortal = portal;
        this.containerView = container;
        F(activity, fragment, portal, container);
    }

    @Override // od3.d
    public void onWindowFocusChanged(boolean hasFocus) {
        this.hasWindowFocus = hasFocus;
    }

    @Override // od3.c
    public void show() {
        View view = getView();
        if (view == null) {
            return;
        }
        view.setVisibility(0);
    }

    @Override // od3.d
    public void r() {
        this.isResumed = false;
    }

    @Override // od3.d
    public void y() {
        this.isResumed = true;
    }

    public void H() {
    }

    @Override // od3.d
    public void h() {
    }

    @Override // od3.d
    public void i() {
    }

    @Override // od3.d
    public void t() {
    }

    @Override // od3.d
    public void m(boolean hidden) {
    }
}
