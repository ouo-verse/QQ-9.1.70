package s24;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import androidx.annotation.MainThread;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.tencent.aio.base.mvi.part.InputUIState;
import com.tencent.input.base.mvicompat.c;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.robot.aio.input.inputbar.pttbtn.RobotInputPttBtnUIState;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import s24.a;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 52$\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0001j\b\u0012\u0004\u0012\u00020\u0005`\u0006:\u00016B\u000f\u0012\u0006\u0010(\u001a\u00020\u0004\u00a2\u0006\u0004\b4\u0010'J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u000f\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u000eH\u0002J\u0010\u0010\u0011\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0010H\u0002J\u0010\u0010\u0013\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0012H\u0002J\b\u0010\u0014\u001a\u00020\tH\u0002J\b\u0010\u0015\u001a\u00020\tH\u0002J\b\u0010\u0016\u001a\u00020\tH\u0002J\b\u0010\u0018\u001a\u00020\u0017H\u0002J\b\u0010\u0019\u001a\u00020\tH\u0002J\u0018\u0010\u001c\u001a\u0012\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u001b\u0018\u00010\u001aH\u0016J\u0010\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u0005H\u0016J\u0010\u0010!\u001a\u00020\t2\u0006\u0010 \u001a\u00020\u001fH\u0016J\u0010\u0010\"\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0003H\u0016R\"\u0010(\u001a\u00020\u00048\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u0016\u0010+\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010,\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010*R\u0016\u0010/\u001a\u00020-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010.R\u0018\u00101\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u00100R\u0016\u00103\u001a\u00020\u00058\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0013\u00102\u00a8\u00067"}, d2 = {"Ls24/c;", "Lcom/tencent/input/base/mvicompat/c;", "Lat/a;", "Lcom/tencent/aio/base/mvi/part/InputUIState;", "Lcom/tencent/mobileqq/aio/input/adorn/b;", "Lcom/tencent/mobileqq/aio/input/inputbar/viewbinding/a;", "Lcom/tencent/mobileqq/aio/input/adorn/IInputBarVBDelegate;", "Lcom/tencent/robot/aio/input/inputbar/pttbtn/RobotInputPttBtnUIState$PttRecordButtonEnable;", "state", "", "l", "", "enable", "u", "Lcom/tencent/robot/aio/input/inputbar/pttbtn/RobotInputPttBtnUIState$InputStyleConfigChangedState;", "j", "Lcom/tencent/robot/aio/input/inputbar/pttbtn/RobotInputPttBtnUIState$FullScreenModeChangedState;", "i", "Lcom/tencent/robot/aio/input/inputbar/pttbtn/RobotInputPttBtnUIState$PttRecordModeChangedState;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "w", "v", "o", "Landroid/widget/ImageButton;", "f", "k", "", "Ljava/lang/Class;", "getObserverStates", "binding", "p", "Lcom/tencent/mvi/api/help/b;", "reuseParam", "d", DomainData.DOMAIN_NAME, "Lcom/tencent/mobileqq/aio/input/adorn/b;", h.F, "()Lcom/tencent/mobileqq/aio/input/adorn/b;", "t", "(Lcom/tencent/mobileqq/aio/input/adorn/b;)V", "mHost", "e", "Z", "mIsPttRecordMode", "mIsFullScreenMode", "Lcom/tencent/robot/aio/input/styleconfig/a;", "Lcom/tencent/robot/aio/input/styleconfig/a;", "mInputStyleConfig", "Landroid/widget/ImageButton;", "mPttButton", "Lcom/tencent/mobileqq/aio/input/inputbar/viewbinding/a;", "mBinding", "<init>", BdhLogUtil.LogTag.Tag_Conn, "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class c implements com.tencent.input.base.mvicompat.c<at.a, InputUIState, com.tencent.mobileqq.aio.input.adorn.b, com.tencent.mobileqq.aio.input.inputbar.viewbinding.a> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private com.tencent.mobileqq.aio.input.adorn.b mHost;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean mIsPttRecordMode;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean mIsFullScreenMode;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private com.tencent.robot.aio.input.styleconfig.a mInputStyleConfig;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ImageButton mPttButton;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private com.tencent.mobileqq.aio.input.inputbar.viewbinding.a mBinding;

    public c(@NotNull com.tencent.mobileqq.aio.input.adorn.b mHost) {
        Intrinsics.checkNotNullParameter(mHost, "mHost");
        this.mHost = mHost;
        this.mInputStyleConfig = new com.tencent.robot.aio.input.styleconfig.a(null, null, null, false, 15, null);
    }

    private final ImageButton f() {
        com.tencent.mobileqq.aio.input.inputbar.viewbinding.a aVar = this.mBinding;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            aVar = null;
        }
        ImageButton imageButton = new ImageButton(aVar.getRoot().getContext());
        imageButton.setId(R.id.f772243s);
        imageButton.setContentDescription(HardCodeUtil.qqStr(R.string.f7k));
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(ViewUtils.dpToPx(28.0f), ViewUtils.dpToPx(28.0f));
        layoutParams.bottomToBottom = 0;
        layoutParams.leftToLeft = 0;
        ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = ViewUtils.dpToPx(16.0f);
        ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = ViewUtils.dpToPx(4.0f);
        imageButton.setLayoutParams(layoutParams);
        imageButton.setVisibility(0);
        imageButton.setOnClickListener(new View.OnClickListener() { // from class: s24.b
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
        this$0.k();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void i(RobotInputPttBtnUIState.FullScreenModeChangedState state) {
        if (state.getIsFullScreenMode() == this.mIsFullScreenMode) {
            return;
        }
        boolean isFullScreenMode = state.getIsFullScreenMode();
        this.mIsFullScreenMode = isFullScreenMode;
        QLog.i("RobotInputPttBtnVBDelegate", 1, "handleFullScreenModeChangedState " + isFullScreenMode);
        w();
    }

    private final void j(RobotInputPttBtnUIState.InputStyleConfigChangedState state) {
        if (Intrinsics.areEqual(this.mInputStyleConfig, state.getInputStyleConfig())) {
            return;
        }
        com.tencent.robot.aio.input.styleconfig.a inputStyleConfig = state.getInputStyleConfig();
        this.mInputStyleConfig = inputStyleConfig;
        QLog.i("RobotInputPttBtnVBDelegate", 1, "handleInputStyleConfigChangedState " + inputStyleConfig);
        w();
    }

    private final void k() {
        boolean z16 = true;
        if (this.mIsFullScreenMode) {
            QLog.e("RobotInputPttBtnVBDelegate", 1, "handlePttButtonClick mIsFullScreenMode is true");
        }
        ImageButton imageButton = this.mPttButton;
        if (imageButton == null || imageButton.isSelected()) {
            z16 = false;
        }
        s(new a.OnPttBtnClickMviIntent(z16));
    }

    private final void l(RobotInputPttBtnUIState.PttRecordButtonEnable state) {
        u(state.getEnable());
    }

    private final void m(RobotInputPttBtnUIState.PttRecordModeChangedState state) {
        if (state.getIsPttRecordMode() == this.mIsPttRecordMode) {
            return;
        }
        boolean isPttRecordMode = state.getIsPttRecordMode();
        this.mIsPttRecordMode = isPttRecordMode;
        QLog.i("RobotInputPttBtnVBDelegate", 1, "handlePttRecordModeChangedState " + isPttRecordMode);
        w();
    }

    private final void o() {
        QLog.i("RobotInputPttBtnVBDelegate", 1, "hidePttButton");
        ImageButton imageButton = this.mPttButton;
        if (imageButton != null) {
            imageButton.setVisibility(8);
        }
    }

    private final void u(boolean enable) {
        float f16;
        ImageButton imageButton = this.mPttButton;
        if (imageButton != null) {
            imageButton.setEnabled(enable);
        }
        ImageButton imageButton2 = this.mPttButton;
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
        QLog.i("RobotInputPttBtnVBDelegate", 1, "showPttButton");
        if (this.mPttButton == null) {
            this.mPttButton = f();
        }
        ImageButton imageButton = this.mPttButton;
        Intrinsics.checkNotNull(imageButton);
        imageButton.setBackground(ContextCompat.getDrawable(imageButton.getContext(), R.drawable.lj9));
        if (imageButton.getParent() == null) {
            com.tencent.mobileqq.aio.input.inputbar.viewbinding.a aVar = this.mBinding;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                aVar = null;
            }
            aVar.getRoot().addView(imageButton);
        }
        imageButton.setVisibility(0);
        imageButton.setSelected(this.mIsPttRecordMode);
    }

    private final void w() {
        if (!this.mIsFullScreenMode && com.tencent.robot.aio.input.styleconfig.c.a(this.mInputStyleConfig.getInputStyleType())) {
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
        this.mIsPttRecordMode = false;
        this.mIsFullScreenMode = false;
        w();
        u(true);
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
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Class[]{RobotInputPttBtnUIState.InputStyleConfigChangedState.class, RobotInputPttBtnUIState.FullScreenModeChangedState.class, RobotInputPttBtnUIState.PttRecordModeChangedState.class, RobotInputPttBtnUIState.PttRecordButtonEnable.class});
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
        if (state instanceof RobotInputPttBtnUIState.InputStyleConfigChangedState) {
            j((RobotInputPttBtnUIState.InputStyleConfigChangedState) state);
            return;
        }
        if (state instanceof RobotInputPttBtnUIState.FullScreenModeChangedState) {
            i((RobotInputPttBtnUIState.FullScreenModeChangedState) state);
        } else if (state instanceof RobotInputPttBtnUIState.PttRecordModeChangedState) {
            m((RobotInputPttBtnUIState.PttRecordModeChangedState) state);
        } else if (state instanceof RobotInputPttBtnUIState.PttRecordButtonEnable) {
            l((RobotInputPttBtnUIState.PttRecordButtonEnable) state);
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
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public void L0(@NotNull com.tencent.mobileqq.aio.input.adorn.b bVar) {
        Intrinsics.checkNotNullParameter(bVar, "<set-?>");
        this.mHost = bVar;
    }
}
