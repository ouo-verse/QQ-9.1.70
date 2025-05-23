package yd3;

import android.os.Bundle;
import android.view.View;
import android.view.ViewStub;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\b&\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b,\u0010-J\b\u0010\u0003\u001a\u00020\u0002H'J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0014J\u0012\u0010\u000b\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\f\u001a\u00020\u0006H\u0014J\u0012\u0010\r\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0014J\b\u0010\u000e\u001a\u00020\u0006H\u0016J\b\u0010\u000f\u001a\u00020\u0006H\u0014J\n\u0010\u0010\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016R\u001c\u0010\u0016\u001a\n \u0013*\u0004\u0018\u00010\u00110\u00118\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R$\u0010\u001d\u001a\u0004\u0018\u00010\u00048\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0018\u0010!\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\"\u0010)\u001a\u00020\"8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u0016\u0010+\u001a\u00020\"8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010$\u00a8\u0006."}, d2 = {"Lyd3/e;", "Lcom/tencent/biz/richframework/part/Part;", "", "z9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "onInitView", "initAfterInflation", "Landroid/os/Bundle;", "args", "C9", "A9", "B9", "x9", "onDismiss", "getRootView", "", "getLogTag", "kotlin.jvm.PlatformType", "d", "Ljava/lang/String;", "TAG", "e", "Landroid/view/View;", "getPartRootView", "()Landroid/view/View;", "setPartRootView", "(Landroid/view/View;)V", "partRootView", "Landroid/view/ViewStub;", "f", "Landroid/view/ViewStub;", "partRootViewStub", "", h.F, "Z", "getViewStubIsInflated", "()Z", "setViewStubIsInflated", "(Z)V", "viewStubIsInflated", "i", NodeProps.VISIBLE, "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public abstract class e extends Part {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final String TAG = getClass().getSimpleName();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private View partRootView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ViewStub partRootViewStub;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean viewStubIsInflated;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public boolean visible;

    protected void A9() {
        ViewStub viewStub;
        if (this.viewStubIsInflated || (viewStub = this.partRootViewStub) == null) {
            return;
        }
        try {
            this.viewStubIsInflated = true;
            if (viewStub != null && viewStub.getParent() != null) {
                this.partRootView = viewStub.inflate();
            }
            View view = this.partRootView;
            if (view != null) {
                view.setVisibility(4);
                initAfterInflation(view);
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void B9(Bundle args) {
        if (this.visible) {
            return;
        }
        this.visible = true;
        View view = this.partRootView;
        if (view == null) {
            return;
        }
        view.setVisibility(0);
    }

    public void C9(Bundle args) {
        if (this.visible || this.partRootView == null) {
            return;
        }
        A9();
        B9(args);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public String getLogTag() {
        String TAG = this.TAG;
        Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
        return TAG;
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getRootView, reason: from getter */
    public View getPartRootView() {
        return this.partRootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.Part
    public abstract void initAfterInflation(View rootView);

    /* JADX INFO: Access modifiers changed from: protected */
    public void onDismiss() {
        if (this.visible) {
            this.visible = false;
            View view = this.partRootView;
            if (view == null) {
                return;
            }
            view.setVisibility(4);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        View findViewById = rootView.findViewById(z9());
        this.partRootView = findViewById;
        if (findViewById instanceof ViewStub) {
            Intrinsics.checkNotNull(findViewById, "null cannot be cast to non-null type android.view.ViewStub");
            this.partRootViewStub = (ViewStub) findViewById;
        } else {
            this.visible = true;
            this.viewStubIsInflated = true;
        }
    }

    public void x9() {
        if (this.visible && getPartRootView() != null) {
            onDismiss();
        }
    }

    public abstract int z9();
}
