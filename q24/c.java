package q24;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageButton;
import androidx.annotation.MainThread;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.tencent.aio.base.mvi.part.InputUIState;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.input.base.mvicompat.c;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.robot.aio.input.inputbar.emotionbtn.RobotInputEmotionBtnUIState;
import com.tencent.robot.aio.input.styleconfig.InputStyleType;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import q24.a;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00132$\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0001j\b\u0012\u0004\u0012\u00020\u0005`\u0006:\u00016B\u000f\u0012\u0006\u0010*\u001a\u00020\u0004\u00a2\u0006\u0004\b5\u0010)J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u000f\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u000eH\u0002J\u0010\u0010\u0011\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0010H\u0002J\u0010\u0010\u0013\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0012H\u0002J\u0010\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u000bH\u0002J\b\u0010\u0016\u001a\u00020\tH\u0002J\b\u0010\u0017\u001a\u00020\tH\u0002J\b\u0010\u0019\u001a\u00020\u0018H\u0002J\b\u0010\u001a\u001a\u00020\tH\u0002J\b\u0010\u001b\u001a\u00020\tH\u0002J\u0018\u0010\u001e\u001a\u0012\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u001d\u0018\u00010\u001cH\u0016J\u0010\u0010 \u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\u0005H\u0016J\u0010\u0010#\u001a\u00020\t2\u0006\u0010\"\u001a\u00020!H\u0016J\u0010\u0010$\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0003H\u0016R\"\u0010*\u001a\u00020\u00048\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b#\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u0016\u0010-\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00100\u001a\u00020.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010/R\u0018\u00102\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u00101R\u0016\u00104\u001a\u00020\u00058\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001a\u00103\u00a8\u00067"}, d2 = {"Lq24/c;", "Lcom/tencent/input/base/mvicompat/c;", "Lat/a;", "Lcom/tencent/aio/base/mvi/part/InputUIState;", "Lcom/tencent/mobileqq/aio/input/adorn/b;", "Lcom/tencent/mobileqq/aio/input/inputbar/viewbinding/a;", "Lcom/tencent/mobileqq/aio/input/adorn/IInputBarVBDelegate;", "Lcom/tencent/robot/aio/input/inputbar/emotionbtn/RobotInputEmotionBtnUIState$EmotionButtonEnable;", "state", "", "j", "", "enable", "t", "Lcom/tencent/robot/aio/input/inputbar/emotionbtn/RobotInputEmotionBtnUIState$InputStyleConfigChangedState;", "l", "Lcom/tencent/robot/aio/input/inputbar/emotionbtn/RobotInputEmotionBtnUIState$FullScreenModeChangedState;", "k", "Lcom/tencent/robot/aio/input/inputbar/emotionbtn/RobotInputEmotionBtnUIState$PanelStateChangedState;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "isSelected", "w", HippyTKDListViewAdapter.X, "v", "Landroid/widget/ImageButton;", "f", "i", "o", "", "Ljava/lang/Class;", "getObserverStates", "binding", "p", "Lcom/tencent/mvi/api/help/b;", "reuseParam", "d", DomainData.DOMAIN_NAME, "Lcom/tencent/mobileqq/aio/input/adorn/b;", h.F, "()Lcom/tencent/mobileqq/aio/input/adorn/b;", "u", "(Lcom/tencent/mobileqq/aio/input/adorn/b;)V", "mHost", "e", "Z", "mIsFullScreenMode", "Lcom/tencent/robot/aio/input/styleconfig/InputStyleType;", "Lcom/tencent/robot/aio/input/styleconfig/InputStyleType;", "mInputStyleType", "Landroid/widget/ImageButton;", "mEmotionButton", "Lcom/tencent/mobileqq/aio/input/inputbar/viewbinding/a;", "mBinding", "<init>", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class c implements com.tencent.input.base.mvicompat.c<at.a, InputUIState, com.tencent.mobileqq.aio.input.adorn.b, com.tencent.mobileqq.aio.input.inputbar.viewbinding.a> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private com.tencent.mobileqq.aio.input.adorn.b mHost;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean mIsFullScreenMode;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private InputStyleType mInputStyleType;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ImageButton mEmotionButton;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private com.tencent.mobileqq.aio.input.inputbar.viewbinding.a mBinding;

    public c(@NotNull com.tencent.mobileqq.aio.input.adorn.b mHost) {
        Intrinsics.checkNotNullParameter(mHost, "mHost");
        this.mHost = mHost;
        this.mInputStyleType = InputStyleType.STYLE_DEFAULT;
    }

    private final ImageButton f() {
        com.tencent.mobileqq.aio.input.inputbar.viewbinding.a aVar = this.mBinding;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            aVar = null;
        }
        ImageButton imageButton = new ImageButton(aVar.getRoot().getContext());
        imageButton.setId(R.id.f766842b);
        imageButton.setContentDescription(HardCodeUtil.qqStr(R.string.f171479f73));
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(ViewUtils.dpToPx(28.0f), ViewUtils.dpToPx(28.0f));
        layoutParams.bottomToBottom = 0;
        ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = ViewUtils.dpToPx(14.0f);
        ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = ViewUtils.dpToPx(4.0f);
        imageButton.setLayoutParams(layoutParams);
        imageButton.setOnClickListener(new View.OnClickListener() { // from class: q24.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                c.g(c.this, view);
            }
        });
        return imageButton;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(c this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.i();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void i() {
        boolean z16 = true;
        QLog.i("RobotInputEmotionBtnVBDelegate", 1, "handleEmotionButtonClick");
        if (this.mIsFullScreenMode) {
            return;
        }
        ImageButton imageButton = this.mEmotionButton;
        if (imageButton == null || imageButton.isSelected()) {
            z16 = false;
        }
        s(new a.OnEmotionBtnClickMviIntent(z16));
    }

    private final void j(RobotInputEmotionBtnUIState.EmotionButtonEnable state) {
        t(state.getEnable());
    }

    private final void k(RobotInputEmotionBtnUIState.FullScreenModeChangedState state) {
        if (this.mIsFullScreenMode == state.getIsFullScreenMode()) {
            return;
        }
        this.mIsFullScreenMode = state.getIsFullScreenMode();
        QLog.i("RobotInputEmotionBtnVBDelegate", 1, "handleFullScreenModeChangedState " + this.mInputStyleType);
        x();
    }

    private final void l(RobotInputEmotionBtnUIState.InputStyleConfigChangedState state) {
        if (this.mInputStyleType == state.getInputStyleConfig().getInputStyleType()) {
            return;
        }
        InputStyleType inputStyleType = state.getInputStyleConfig().getInputStyleType();
        this.mInputStyleType = inputStyleType;
        QLog.i("RobotInputEmotionBtnVBDelegate", 1, "handleInputStyleConfigChangedState " + inputStyleType);
        x();
    }

    private final void m(RobotInputEmotionBtnUIState.PanelStateChangedState state) {
        boolean z16 = true;
        QLog.i("RobotInputEmotionBtnVBDelegate", 1, "handlePanelStateChanged " + state.getIsShowPanel() + " " + state.getPanelId());
        if (state.getIsShowPanel()) {
            if (state.getPanelId() != 1001) {
                z16 = false;
            }
            w(z16);
        } else if (state.getPanelId() == 1001) {
            w(false);
        }
    }

    private final void o() {
        ViewParent viewParent;
        QLog.i("RobotInputEmotionBtnVBDelegate", 1, "hideEmotionButton");
        ImageButton imageButton = this.mEmotionButton;
        com.tencent.mobileqq.aio.input.inputbar.viewbinding.a aVar = null;
        if (imageButton != null) {
            viewParent = imageButton.getParent();
        } else {
            viewParent = null;
        }
        if (viewParent != null) {
            com.tencent.mobileqq.aio.input.inputbar.viewbinding.a aVar2 = this.mBinding;
            if (aVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            } else {
                aVar = aVar2;
            }
            aVar.getRoot().removeView(this.mEmotionButton);
        }
    }

    private final void t(boolean enable) {
        float f16;
        ImageButton imageButton = this.mEmotionButton;
        if (imageButton != null) {
            imageButton.setEnabled(enable);
        }
        ImageButton imageButton2 = this.mEmotionButton;
        if (imageButton2 != null) {
            if (enable) {
                f16 = 1.0f;
            } else {
                f16 = 0.3f;
            }
            imageButton2.setAlpha(f16);
        }
    }

    private final void v() {
        ConstraintLayout.LayoutParams layoutParams;
        int i3;
        QLog.i("RobotInputEmotionBtnVBDelegate", 1, "showEmotionButton");
        if (this.mEmotionButton == null) {
            this.mEmotionButton = f();
        }
        ImageButton imageButton = this.mEmotionButton;
        if (imageButton != null) {
            imageButton.setBackground(ContextCompat.getDrawable(imageButton.getContext(), R.drawable.lj7));
            ViewGroup.LayoutParams layoutParams2 = imageButton.getLayoutParams();
            com.tencent.mobileqq.aio.input.inputbar.viewbinding.a aVar = null;
            if (layoutParams2 instanceof ConstraintLayout.LayoutParams) {
                layoutParams = (ConstraintLayout.LayoutParams) layoutParams2;
            } else {
                layoutParams = null;
            }
            if (layoutParams != null) {
                if (this.mInputStyleType == InputStyleType.STYLE_SINGLE_PLUS) {
                    i3 = R.id.f772143r;
                } else {
                    i3 = R.id.send_btn;
                }
                layoutParams.rightToLeft = i3;
            } else {
                layoutParams = null;
            }
            imageButton.setLayoutParams(layoutParams);
            if (imageButton.getParent() == null) {
                com.tencent.mobileqq.aio.input.inputbar.viewbinding.a aVar2 = this.mBinding;
                if (aVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                } else {
                    aVar = aVar2;
                }
                aVar.getRoot().addView(this.mEmotionButton);
            }
        }
    }

    private final void w(boolean isSelected) {
        QLog.i("RobotInputEmotionBtnVBDelegate", 1, "updateEmotionBtnSelected " + isSelected);
        ImageButton imageButton = this.mEmotionButton;
        if (imageButton != null) {
            imageButton.setSelected(isSelected);
        }
    }

    private final void x() {
        if (!this.mIsFullScreenMode && com.tencent.robot.aio.input.styleconfig.c.a(this.mInputStyleType)) {
            v();
        } else {
            o();
        }
    }

    @Override // com.tencent.input.base.mvicompat.d
    public void a() {
        c.a.b(this);
    }

    @Override // com.tencent.input.base.mvicompat.d
    public void d(@NotNull com.tencent.mvi.api.help.b reuseParam) {
        Intrinsics.checkNotNullParameter(reuseParam, "reuseParam");
        c.a.e(this, reuseParam);
        this.mIsFullScreenMode = false;
        x();
        t(true);
    }

    @Override // androidx.core.util.Consumer
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public void accept(@NotNull InputUIState inputUIState) {
        c.a.a(this, inputUIState);
    }

    @Override // com.tencent.mvi.api.ability.c
    @MainThread
    @Nullable
    public Bundle generateVBState(@NotNull com.tencent.mvi.api.ability.d dVar) {
        return c.a.c(this, dVar);
    }

    @Override // com.tencent.input.base.mvicompat.c
    @Nullable
    public List<Class<? extends InputUIState>> getObserverStates() {
        List<Class<? extends InputUIState>> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Class[]{RobotInputEmotionBtnUIState.InputStyleConfigChangedState.class, RobotInputEmotionBtnUIState.FullScreenModeChangedState.class, RobotInputEmotionBtnUIState.PanelStateChangedState.class, RobotInputEmotionBtnUIState.EmotionButtonEnable.class});
        return listOf;
    }

    @Override // com.tencent.input.base.mvicompat.a
    @NotNull
    /* renamed from: h, reason: from getter */
    public com.tencent.mobileqq.aio.input.adorn.b getMHost() {
        return this.mHost;
    }

    @Override // com.tencent.input.base.mvicompat.c
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull InputUIState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        if (state instanceof RobotInputEmotionBtnUIState.InputStyleConfigChangedState) {
            l((RobotInputEmotionBtnUIState.InputStyleConfigChangedState) state);
            return;
        }
        if (state instanceof RobotInputEmotionBtnUIState.FullScreenModeChangedState) {
            k((RobotInputEmotionBtnUIState.FullScreenModeChangedState) state);
        } else if (state instanceof RobotInputEmotionBtnUIState.PanelStateChangedState) {
            m((RobotInputEmotionBtnUIState.PanelStateChangedState) state);
        } else if (state instanceof RobotInputEmotionBtnUIState.EmotionButtonEnable) {
            j((RobotInputEmotionBtnUIState.EmotionButtonEnable) state);
        }
    }

    @Override // com.tencent.input.base.mvicompat.d
    public void onDestroy() {
        c.a.d(this);
    }

    @Override // com.tencent.input.base.mvicompat.d
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public void c(@NotNull com.tencent.mobileqq.aio.input.inputbar.viewbinding.a binding) {
        Intrinsics.checkNotNullParameter(binding, "binding");
        this.mBinding = binding;
    }

    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public void s(@NotNull at.a aVar) {
        c.a.f(this, aVar);
    }

    @Override // com.tencent.input.base.mvicompat.a
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public void L0(@NotNull com.tencent.mobileqq.aio.input.adorn.b bVar) {
        Intrinsics.checkNotNullParameter(bVar, "<set-?>");
        this.mHost = bVar;
    }
}
