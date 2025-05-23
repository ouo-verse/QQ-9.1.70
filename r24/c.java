package r24;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.ImageButton;
import androidx.annotation.MainThread;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.tencent.aio.base.mvi.part.InputUIState;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.input.base.mvicompat.c;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.robot.aio.input.inputbar.plusbtn.RobotInputPlusBtnUIState;
import com.tencent.robot.aio.input.styleconfig.InputStyleType;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import r24.a;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 =2$\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0001j\b\u0012\u0004\u0012\u00020\u0005`\u0006:\u0001>B\u000f\u0012\u0006\u0010)\u001a\u00020\u0004\u00a2\u0006\u0004\b<\u0010(J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\u000b\u001a\u00020\tH\u0002J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\fH\u0002J\u0010\u0010\u000f\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u000eH\u0002J\u0010\u0010\u0011\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0010H\u0002J\b\u0010\u0012\u001a\u00020\tH\u0002J\b\u0010\u0013\u001a\u00020\tH\u0002J\u0010\u0010\u0015\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0014H\u0002J\b\u0010\u0016\u001a\u00020\tH\u0002J\b\u0010\u0017\u001a\u00020\tH\u0002J\b\u0010\u0019\u001a\u00020\u0018H\u0002J\b\u0010\u001a\u001a\u00020\tH\u0002J\u0018\u0010\u001d\u001a\u0012\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u001c\u0018\u00010\u001bH\u0016J\u0010\u0010\u001f\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u0005H\u0016J\u0010\u0010\"\u001a\u00020\t2\u0006\u0010!\u001a\u00020 H\u0016J\u0010\u0010#\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0003H\u0016R\"\u0010)\u001a\u00020\u00048\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\"\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0016\u0010.\u001a\u00020*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010,R\u0016\u00101\u001a\u00020/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u00100R\u0016\u00102\u001a\u00020*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010,R\u0018\u00104\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u00103R\u0016\u00107\u001a\u00020\u00058\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0016\u0010;\u001a\u0002088\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010:\u00a8\u0006?"}, d2 = {"Lr24/c;", "Lcom/tencent/input/base/mvicompat/c;", "Lat/a;", "Lcom/tencent/aio/base/mvi/part/InputUIState;", "Lcom/tencent/mobileqq/aio/input/adorn/b;", "Lcom/tencent/mobileqq/aio/input/inputbar/viewbinding/a;", "Lcom/tencent/mobileqq/aio/input/adorn/IInputBarVBDelegate;", "Lcom/tencent/robot/aio/input/inputbar/plusbtn/RobotInputPlusBtnUIState$OnPictureNumberChanged;", "state", "", "l", "j", "Lcom/tencent/robot/aio/input/inputbar/plusbtn/RobotInputPlusBtnUIState$InputStyleConfigChangedState;", "k", "Lcom/tencent/robot/aio/input/inputbar/plusbtn/RobotInputPlusBtnUIState$FullScreenModeChangedState;", "i", "Lcom/tencent/robot/aio/input/inputbar/plusbtn/RobotInputPlusBtnUIState$PttRecordModeChangedState;", "o", "y", "t", "Lcom/tencent/robot/aio/input/inputbar/plusbtn/RobotInputPlusBtnUIState$PanelStateChangedState;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, HippyTKDListViewAdapter.X, "r", "Landroid/widget/ImageButton;", "f", DomainData.DOMAIN_NAME, "", "Ljava/lang/Class;", "getObserverStates", "binding", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/mvi/api/help/b;", "reuseParam", "d", "p", "Lcom/tencent/mobileqq/aio/input/adorn/b;", h.F, "()Lcom/tencent/mobileqq/aio/input/adorn/b;", "w", "(Lcom/tencent/mobileqq/aio/input/adorn/b;)V", "mHost", "", "e", "Z", "mIsPttRecordMode", "mIsFullScreenMode", "Lcom/tencent/robot/aio/input/styleconfig/InputStyleType;", "Lcom/tencent/robot/aio/input/styleconfig/InputStyleType;", "mCurInputStyleType", "isInManualLayoutStack", "Landroid/widget/ImageButton;", "mPlusButton", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/aio/input/inputbar/viewbinding/a;", "mBinding", "", "D", "I", "selectedPictureNumber", "<init>", "E", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class c implements com.tencent.input.base.mvicompat.c<at.a, InputUIState, com.tencent.mobileqq.aio.input.adorn.b, com.tencent.mobileqq.aio.input.inputbar.viewbinding.a> {

    /* renamed from: C, reason: from kotlin metadata */
    private com.tencent.mobileqq.aio.input.inputbar.viewbinding.a mBinding;

    /* renamed from: D, reason: from kotlin metadata */
    private int selectedPictureNumber;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private com.tencent.mobileqq.aio.input.adorn.b mHost;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean mIsPttRecordMode;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean mIsFullScreenMode;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private InputStyleType mCurInputStyleType;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean isInManualLayoutStack;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ImageButton mPlusButton;

    public c(@NotNull com.tencent.mobileqq.aio.input.adorn.b mHost) {
        Intrinsics.checkNotNullParameter(mHost, "mHost");
        this.mHost = mHost;
        this.mCurInputStyleType = InputStyleType.STYLE_DEFAULT;
    }

    private final ImageButton f() {
        com.tencent.mobileqq.aio.input.inputbar.viewbinding.a aVar = this.mBinding;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            aVar = null;
        }
        ImageButton imageButton = new ImageButton(aVar.getRoot().getContext());
        imageButton.setId(R.id.f772143r);
        imageButton.setContentDescription(HardCodeUtil.qqStr(R.string.f7g));
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(ViewUtils.dpToPx(28.0f), ViewUtils.dpToPx(28.0f));
        layoutParams.bottomToBottom = 0;
        layoutParams.rightToLeft = R.id.send_btn;
        ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = ViewUtils.dpToPx(16.0f);
        ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = ViewUtils.dpToPx(4.0f);
        imageButton.setLayoutParams(layoutParams);
        imageButton.setVisibility(8);
        imageButton.setOnClickListener(new View.OnClickListener() { // from class: r24.b
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
        this$0.n();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void i(RobotInputPlusBtnUIState.FullScreenModeChangedState state) {
        if (this.mIsFullScreenMode == state.getIsFullScreenMode()) {
            return;
        }
        boolean isFullScreenMode = state.getIsFullScreenMode();
        this.mIsFullScreenMode = isFullScreenMode;
        QLog.i("RobotInputPlusBtnVBDelegate", 1, "handleFullScreenModeChangedState " + isFullScreenMode);
        y();
    }

    private final void j() {
        QLog.i("RobotInputPlusBtnVBDelegate", 1, "handleInputEditTextChangedState");
        y();
    }

    private final void k(RobotInputPlusBtnUIState.InputStyleConfigChangedState state) {
        if (this.mCurInputStyleType == state.getInputStyleConfig().getInputStyleType()) {
            return;
        }
        InputStyleType inputStyleType = state.getInputStyleConfig().getInputStyleType();
        this.mCurInputStyleType = inputStyleType;
        QLog.i("RobotInputPlusBtnVBDelegate", 1, "handleInputStyleConfigChangedState " + inputStyleType);
        y();
    }

    private final void l(RobotInputPlusBtnUIState.OnPictureNumberChanged state) {
        this.selectedPictureNumber = state.getCount();
        y();
    }

    private final void m(RobotInputPlusBtnUIState.PanelStateChangedState state) {
        boolean z16;
        float f16;
        if (this.mPlusButton == null) {
            return;
        }
        QLog.i("RobotInputPlusBtnVBDelegate", 1, "handlePanelStateChangedState " + state.getIsShowPanel() + " " + state.getPanelId());
        if (state.getIsShowPanel() && state.getPanelId() == 1006) {
            z16 = true;
        } else {
            z16 = false;
        }
        ImageButton imageButton = this.mPlusButton;
        Intrinsics.checkNotNull(imageButton);
        if (imageButton.isSelected() == z16) {
            return;
        }
        ImageButton imageButton2 = this.mPlusButton;
        Intrinsics.checkNotNull(imageButton2);
        imageButton2.setSelected(z16);
        if (z16) {
            f16 = 45.0f;
        } else {
            f16 = 0.0f;
        }
        ImageButton imageButton3 = this.mPlusButton;
        Intrinsics.checkNotNull(imageButton3);
        ImageButton imageButton4 = this.mPlusButton;
        Intrinsics.checkNotNull(imageButton4);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageButton3, BasicAnimation.KeyPath.ROTATION, imageButton4.getRotation(), f16);
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.setDuration(150L);
        ofFloat.start();
    }

    private final void n() {
        ImageButton imageButton = this.mPlusButton;
        boolean z16 = false;
        if (imageButton != null && !imageButton.isSelected()) {
            z16 = true;
        }
        v(new a.OnFunBtnClickedMviIntent(z16));
    }

    private final void o(RobotInputPlusBtnUIState.PttRecordModeChangedState state) {
        if (this.mIsPttRecordMode == state.getIsPttRecordMode()) {
            return;
        }
        boolean isPttRecordMode = state.getIsPttRecordMode();
        this.mIsPttRecordMode = isPttRecordMode;
        QLog.i("RobotInputPlusBtnVBDelegate", 1, "handlePttRecordModeChangedState " + isPttRecordMode);
        y();
    }

    private final void r() {
        ImageButton imageButton = this.mPlusButton;
        if (imageButton != null && imageButton != null) {
            imageButton.setVisibility(8);
        }
    }

    private final void t() {
        if (com.tencent.robot.aio.input.styleconfig.c.a(this.mCurInputStyleType)) {
            com.tencent.mobileqq.aio.input.inputbar.viewbinding.a aVar = this.mBinding;
            com.tencent.mobileqq.aio.input.inputbar.viewbinding.a aVar2 = null;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                aVar = null;
            }
            if (aVar.getRoot().isInLayout() && !this.isInManualLayoutStack) {
                QLog.i("RobotInputPlusBtnVBDelegate", 1, "performLayoutIfInLayoutPass");
                ImageButton imageButton = this.mPlusButton;
                if (imageButton != null) {
                    imageButton.requestLayout();
                }
                com.tencent.mobileqq.aio.input.inputbar.viewbinding.a aVar3 = this.mBinding;
                if (aVar3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                    aVar3 = null;
                }
                aVar3.d().forceLayout();
                this.isInManualLayoutStack = true;
                com.tencent.mobileqq.aio.input.inputbar.viewbinding.a aVar4 = this.mBinding;
                if (aVar4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                } else {
                    aVar2 = aVar4;
                }
                ConstraintLayout root = aVar2.getRoot();
                root.measure(View.MeasureSpec.makeMeasureSpec(root.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(root.getMeasuredHeight(), 1073741824));
                root.layout(root.getLeft(), root.getTop(), root.getRight(), root.getBottom());
                this.isInManualLayoutStack = false;
            }
        }
    }

    private final void x() {
        QLog.i("RobotInputPlusBtnVBDelegate", 1, "showPlusButton");
        if (this.mPlusButton == null) {
            this.mPlusButton = f();
        }
        ImageButton imageButton = this.mPlusButton;
        Intrinsics.checkNotNull(imageButton);
        imageButton.setBackground(ContextCompat.getDrawable(imageButton.getContext(), R.drawable.qui_add_circle_aio_oversized_icon_aio_toolbar_normal));
        if (imageButton.getParent() == null) {
            com.tencent.mobileqq.aio.input.inputbar.viewbinding.a aVar = this.mBinding;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                aVar = null;
            }
            aVar.getRoot().addView(this.mPlusButton);
        }
        imageButton.setVisibility(0);
    }

    private final void y() {
        boolean z16;
        if (!this.mIsFullScreenMode && com.tencent.robot.aio.input.styleconfig.c.b(this.mCurInputStyleType)) {
            if (this.mIsPttRecordMode) {
                x();
            } else {
                com.tencent.mobileqq.aio.input.inputbar.viewbinding.a aVar = this.mBinding;
                if (aVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                    aVar = null;
                }
                Editable editableText = aVar.a().getEditableText();
                if (editableText != null && editableText.length() != 0) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (z16 && this.selectedPictureNumber <= 0) {
                    x();
                } else {
                    r();
                }
            }
        } else {
            r();
        }
        t();
    }

    @Override // com.tencent.input.base.mvicompat.d
    public void a() {
        c.a.b(this);
    }

    @Override // com.tencent.input.base.mvicompat.d
    public void d(@NotNull com.tencent.mvi.api.help.b reuseParam) {
        Intrinsics.checkNotNullParameter(reuseParam, "reuseParam");
        c.a.e(this, reuseParam);
        this.mIsPttRecordMode = false;
        this.mIsFullScreenMode = false;
        this.selectedPictureNumber = 0;
        y();
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
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Class[]{RobotInputPlusBtnUIState.InputEditTextChangedState.class, RobotInputPlusBtnUIState.InputStyleConfigChangedState.class, RobotInputPlusBtnUIState.PanelStateChangedState.class, RobotInputPlusBtnUIState.FullScreenModeChangedState.class, RobotInputPlusBtnUIState.PttRecordModeChangedState.class, RobotInputPlusBtnUIState.OnPictureNumberChanged.class});
        return listOf;
    }

    @Override // com.tencent.input.base.mvicompat.a
    @NotNull
    /* renamed from: h, reason: from getter */
    public com.tencent.mobileqq.aio.input.adorn.b getMHost() {
        return this.mHost;
    }

    @Override // com.tencent.input.base.mvicompat.d
    public void onDestroy() {
        c.a.d(this);
    }

    @Override // com.tencent.input.base.mvicompat.c
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull InputUIState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        if (state instanceof RobotInputPlusBtnUIState.InputEditTextChangedState) {
            j();
            return;
        }
        if (state instanceof RobotInputPlusBtnUIState.InputStyleConfigChangedState) {
            k((RobotInputPlusBtnUIState.InputStyleConfigChangedState) state);
            return;
        }
        if (state instanceof RobotInputPlusBtnUIState.FullScreenModeChangedState) {
            i((RobotInputPlusBtnUIState.FullScreenModeChangedState) state);
            return;
        }
        if (state instanceof RobotInputPlusBtnUIState.PanelStateChangedState) {
            m((RobotInputPlusBtnUIState.PanelStateChangedState) state);
        } else if (state instanceof RobotInputPlusBtnUIState.PttRecordModeChangedState) {
            o((RobotInputPlusBtnUIState.PttRecordModeChangedState) state);
        } else if (state instanceof RobotInputPlusBtnUIState.OnPictureNumberChanged) {
            l((RobotInputPlusBtnUIState.OnPictureNumberChanged) state);
        }
    }

    @Override // com.tencent.input.base.mvicompat.d
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public void c(@NotNull com.tencent.mobileqq.aio.input.inputbar.viewbinding.a binding) {
        Intrinsics.checkNotNullParameter(binding, "binding");
        this.mBinding = binding;
    }

    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public void v(@NotNull at.a aVar) {
        c.a.f(this, aVar);
    }

    @Override // com.tencent.input.base.mvicompat.a
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public void L0(@NotNull com.tencent.mobileqq.aio.input.adorn.b bVar) {
        Intrinsics.checkNotNullParameter(bVar, "<set-?>");
        this.mHost = bVar;
    }
}
