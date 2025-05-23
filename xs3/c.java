package xs3;

import android.app.Activity;
import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import com.tencent.aio.base.route.msg.PanelMsg;
import com.tencent.aio.part.root.panel.mvx.result.a;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.mvi.base.route.k;
import com.tencent.mvi.mvvm.framework.FrameworkVM;
import com.tencent.qqguild.base.mvvm.AIOViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 \u00172\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u0018\u0019B\u000f\u0012\u0006\u0010\u0014\u001a\u00020\u000b\u00a2\u0006\u0004\b\u0015\u0010\u0016J\f\u0010\u0006\u001a\u00020\u0005*\u00020\u0004H\u0002J\f\u0010\b\u001a\u00020\u0007*\u00020\u0004H\u0002J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0016J\u0014\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\rH\u0016J\u0006\u0010\u000f\u001a\u00020\u0007R\u0017\u0010\u0014\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u001a"}, d2 = {"Lxs3/c;", "Lcom/tencent/aio/base/mvvm/a;", "Lol3/b;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "Landroid/app/Activity;", "", "e1", "", "d1", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "Landroid/view/View;", "onCreateView", "Lcom/tencent/aio/base/mvvm/b;", "b1", "c1", "d", "Landroid/view/View;", "getParentView", "()Landroid/view/View;", "parentView", "<init>", "(Landroid/view/View;)V", "e", "a", "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class c extends com.tencent.aio.base.mvvm.a<ol3.b, MviUIState> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View parentView;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004B\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\u0007H\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016\u00a8\u0006\u000e"}, d2 = {"Lxs3/c$b;", "Lcom/tencent/qqguild/base/mvvm/AIOViewModel;", "Lol3/b;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "Lcom/tencent/aio/api/runtime/emitter/a;", "Lcom/tencent/aio/api/runtime/a;", "context", "", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "onBackEvent", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final class b extends AIOViewModel<ol3.b, MviUIState> implements com.tencent.aio.api.runtime.emitter.a {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.aio.api.runtime.emitter.a
        public boolean onBackEvent() {
            k k3 = ((com.tencent.aio.api.runtime.a) getMContext()).e().k(PanelMsg.IsShowingPanelOrKeyboard.f69199d);
            Intrinsics.checkNotNull(k3, "null cannot be cast to non-null type com.tencent.aio.part.root.panel.mvx.result.PanelMsgResult.IsPanelShowResult");
            a.C0653a c0653a = (a.C0653a) k3;
            if (!Intrinsics.areEqual(c0653a.b(), Boolean.TRUE) && c0653a.a() == null) {
                return false;
            }
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new PanelMsg.HideAllPanelAndKeyboard(FrameworkVM.TAG, false, 2, null));
            return true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
        public void onDestroy() {
            super.onDestroy();
            ((com.tencent.aio.api.runtime.a) getMContext()).b().a(com.tencent.aio.api.runtime.emitter.a.class).c(this);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.aio.base.mvvm.b, com.tencent.mvi.mvvm.framework.FrameworkVM
        public void onCreate(@NotNull com.tencent.aio.api.runtime.a context) {
            Intrinsics.checkNotNullParameter(context, "context");
            ((com.tencent.aio.api.runtime.a) getMContext()).b().a(com.tencent.aio.api.runtime.emitter.a.class).a(this);
        }
    }

    public c(@NotNull View parentView) {
        Intrinsics.checkNotNullParameter(parentView, "parentView");
        this.parentView = parentView;
    }

    private final void d1(Activity activity) {
        activity.onKeyDown(4, new KeyEvent(1, 4));
    }

    private final boolean e1(Activity activity) {
        View currentFocus = activity.getCurrentFocus();
        if (currentFocus == null) {
            return false;
        }
        Object systemService = activity.getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        return ((InputMethodManager) systemService).hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    /* renamed from: b1, reason: merged with bridge method [inline-methods] */
    public com.tencent.aio.base.mvvm.b<ol3.b, MviUIState> createVM() {
        return new b();
    }

    public final void c1() {
        Context mContext = getMContext();
        Intrinsics.checkNotNull(mContext, "null cannot be cast to non-null type android.app.Activity");
        Activity activity = (Activity) mContext;
        if (e1(activity)) {
            return;
        }
        d1(activity);
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        FrameLayout frameLayout = new FrameLayout(createViewParams.a());
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(0, 0));
        return frameLayout;
    }
}
