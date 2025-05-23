package t24;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import androidx.annotation.MainThread;
import com.tencent.aio.base.mvi.part.InputUIState;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.input.base.mvicompat.c;
import com.tencent.mobileqq.aio.utils.au;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mvi.api.ability.d;
import com.tencent.qphone.base.util.QLog;
import com.tencent.robot.aio.input.inputbar.sendbtn.RobotInputSendBtnExtUIState;
import com.tencent.robot.aio.input.styleconfig.InputStyleType;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\u0018\u0000 /2$\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0001j\b\u0012\u0004\u0012\u00020\u0005`\u0006:\u00010B\u000f\u0012\u0006\u0010!\u001a\u00020\u0004\u00a2\u0006\u0004\b.\u0010 J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u000bH\u0002J\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\rH\u0002J\u0010\u0010\u0010\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u000fH\u0002J\b\u0010\u0011\u001a\u00020\tH\u0002J\b\u0010\u0012\u001a\u00020\tH\u0002J\u0018\u0010\u0015\u001a\u0012\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0014\u0018\u00010\u0013H\u0016J\u0010\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u0005H\u0016J\u0010\u0010\u001a\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\u0010\u0010\u001b\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0003H\u0016R\"\u0010!\u001a\u00020\u00048\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u0016\u0010$\u001a\u00020\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010#R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010#R\u0016\u0010(\u001a\u00020&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010'R\u0016\u0010+\u001a\u00020)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010*R\u0016\u0010-\u001a\u00020\u00058\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001f\u0010,\u00a8\u00061"}, d2 = {"Lt24/b;", "Lcom/tencent/input/base/mvicompat/c;", "Lat/a;", "Lcom/tencent/aio/base/mvi/part/InputUIState;", "Lcom/tencent/mobileqq/aio/input/adorn/b;", "Lcom/tencent/mobileqq/aio/input/inputbar/viewbinding/a;", "Lcom/tencent/mobileqq/aio/input/adorn/IInputBarVBDelegate;", "Lcom/tencent/robot/aio/input/inputbar/sendbtn/RobotInputSendBtnExtUIState$OnPictureNumberChanged;", "state", "", "i", "Lcom/tencent/robot/aio/input/inputbar/sendbtn/RobotInputSendBtnExtUIState$InputStyleConfigChangedState;", h.F, "Lcom/tencent/robot/aio/input/inputbar/sendbtn/RobotInputSendBtnExtUIState$PttRecordModeChangedState;", "j", "Lcom/tencent/robot/aio/input/inputbar/sendbtn/RobotInputSendBtnExtUIState$FullScreenModeChangedState;", "g", "f", DomainData.DOMAIN_NAME, "", "Ljava/lang/Class;", "getObserverStates", "binding", "l", "Lcom/tencent/mvi/api/help/b;", "reuseParam", "d", "k", "Lcom/tencent/mobileqq/aio/input/adorn/b;", "e", "()Lcom/tencent/mobileqq/aio/input/adorn/b;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(Lcom/tencent/mobileqq/aio/input/adorn/b;)V", "mHost", "", "Z", "mIsPttRecordMode", "mIsFullScreenMode", "Lcom/tencent/robot/aio/input/styleconfig/InputStyleType;", "Lcom/tencent/robot/aio/input/styleconfig/InputStyleType;", "mInputStyleType", "", "I", "selectedPictureNumber", "Lcom/tencent/mobileqq/aio/input/inputbar/viewbinding/a;", "mBinding", "<init>", BdhLogUtil.LogTag.Tag_Conn, "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class b implements com.tencent.input.base.mvicompat.c<at.a, InputUIState, com.tencent.mobileqq.aio.input.adorn.b, com.tencent.mobileqq.aio.input.inputbar.viewbinding.a> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private com.tencent.mobileqq.aio.input.adorn.b mHost;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean mIsPttRecordMode;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean mIsFullScreenMode;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private InputStyleType mInputStyleType;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int selectedPictureNumber;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private com.tencent.mobileqq.aio.input.inputbar.viewbinding.a mBinding;

    public b(@NotNull com.tencent.mobileqq.aio.input.adorn.b mHost) {
        Intrinsics.checkNotNullParameter(mHost, "mHost");
        this.mHost = mHost;
        this.mInputStyleType = InputStyleType.STYLE_DEFAULT;
    }

    private final void f() {
        QLog.i("RobotInputSendBtnExtVBDelegate", 1, "handleEditTextContentChangedState");
        n();
    }

    private final void g(RobotInputSendBtnExtUIState.FullScreenModeChangedState state) {
        if (this.mIsFullScreenMode == state.getIsFullScreenMode()) {
            return;
        }
        this.mIsFullScreenMode = state.getIsFullScreenMode();
        QLog.i("RobotInputSendBtnExtVBDelegate", 1, "handleFullScreenModeChangedState mIsFullScreenMode");
        n();
    }

    private final void h(RobotInputSendBtnExtUIState.InputStyleConfigChangedState state) {
        if (this.mInputStyleType == state.getInputStyleConfig().getInputStyleType()) {
            return;
        }
        this.mInputStyleType = state.getInputStyleConfig().getInputStyleType();
        QLog.i("RobotInputSendBtnExtVBDelegate", 1, "handleInputStyleConfigChangedState mInputStyleType");
        n();
    }

    private final void i(RobotInputSendBtnExtUIState.OnPictureNumberChanged state) {
        this.selectedPictureNumber = state.getCount();
        n();
    }

    private final void j(RobotInputSendBtnExtUIState.PttRecordModeChangedState state) {
        if (this.mIsPttRecordMode == state.getIsPttRecordMode()) {
            return;
        }
        this.mIsPttRecordMode = state.getIsPttRecordMode();
        QLog.i("RobotInputSendBtnExtVBDelegate", 1, "handlePttRecordModeChangedState mIsPttRecordMode");
        n();
    }

    private final void n() {
        boolean z16;
        if (this.mIsFullScreenMode) {
            return;
        }
        com.tencent.mobileqq.aio.input.inputbar.viewbinding.a aVar = null;
        if (!com.tencent.robot.aio.input.styleconfig.c.a(this.mInputStyleType)) {
            com.tencent.mobileqq.aio.input.inputbar.viewbinding.a aVar2 = this.mBinding;
            if (aVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            } else {
                aVar = aVar2;
            }
            aVar.d().setVisibility(0);
            return;
        }
        if (this.mIsPttRecordMode) {
            com.tencent.mobileqq.aio.input.inputbar.viewbinding.a aVar3 = this.mBinding;
            if (aVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            } else {
                aVar = aVar3;
            }
            aVar.d().setVisibility(8);
            return;
        }
        com.tencent.mobileqq.aio.input.inputbar.viewbinding.a aVar4 = this.mBinding;
        if (aVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            aVar4 = null;
        }
        View d16 = aVar4.d();
        com.tencent.mobileqq.aio.input.inputbar.viewbinding.a aVar5 = this.mBinding;
        if (aVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            aVar = aVar5;
        }
        Editable editableText = aVar.a().getEditableText();
        boolean z17 = true;
        if (editableText != null && editableText.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16 || this.selectedPictureNumber > 0) {
            z17 = false;
        }
        Boolean valueOf = Boolean.valueOf(z17);
        d16.setVisibility(8);
        if (((View) au.a(valueOf, d16)) == null) {
            d16.setVisibility(0);
        }
    }

    @Override // com.tencent.input.base.mvicompat.d
    public void a() {
        c.a.b(this);
    }

    @Override // androidx.core.util.Consumer
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void accept(@NotNull InputUIState inputUIState) {
        c.a.a(this, inputUIState);
    }

    @Override // com.tencent.input.base.mvicompat.d
    public void d(@NotNull com.tencent.mvi.api.help.b reuseParam) {
        Intrinsics.checkNotNullParameter(reuseParam, "reuseParam");
        c.a.e(this, reuseParam);
        this.mIsPttRecordMode = false;
        this.mIsFullScreenMode = false;
        com.tencent.mobileqq.aio.input.inputbar.viewbinding.a aVar = this.mBinding;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            aVar = null;
        }
        View d16 = aVar.d();
        Intrinsics.checkNotNull(d16, "null cannot be cast to non-null type com.tencent.biz.qui.quibutton.QUIButton");
        ((QUIButton) d16).setType(0);
        this.selectedPictureNumber = 0;
        n();
    }

    @Override // com.tencent.input.base.mvicompat.a
    @NotNull
    /* renamed from: e, reason: from getter */
    public com.tencent.mobileqq.aio.input.adorn.b getMHost() {
        return this.mHost;
    }

    @Override // com.tencent.mvi.api.ability.c
    @MainThread
    @Nullable
    public Bundle generateVBState(@NotNull d dVar) {
        return c.a.c(this, dVar);
    }

    @Override // com.tencent.input.base.mvicompat.c
    @Nullable
    public List<Class<? extends InputUIState>> getObserverStates() {
        List<Class<? extends InputUIState>> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Class[]{RobotInputSendBtnExtUIState.InputStyleConfigChangedState.class, RobotInputSendBtnExtUIState.PttRecordModeChangedState.class, RobotInputSendBtnExtUIState.FullScreenModeChangedState.class, RobotInputSendBtnExtUIState.EditTextContentChangedState.class, RobotInputSendBtnExtUIState.OnPictureNumberChanged.class});
        return listOf;
    }

    @Override // com.tencent.input.base.mvicompat.c
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull InputUIState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        if (state instanceof RobotInputSendBtnExtUIState.InputStyleConfigChangedState) {
            h((RobotInputSendBtnExtUIState.InputStyleConfigChangedState) state);
            return;
        }
        if (state instanceof RobotInputSendBtnExtUIState.PttRecordModeChangedState) {
            j((RobotInputSendBtnExtUIState.PttRecordModeChangedState) state);
            return;
        }
        if (state instanceof RobotInputSendBtnExtUIState.FullScreenModeChangedState) {
            g((RobotInputSendBtnExtUIState.FullScreenModeChangedState) state);
        } else if (state instanceof RobotInputSendBtnExtUIState.EditTextContentChangedState) {
            f();
        } else if (state instanceof RobotInputSendBtnExtUIState.OnPictureNumberChanged) {
            i((RobotInputSendBtnExtUIState.OnPictureNumberChanged) state);
        }
    }

    @Override // com.tencent.input.base.mvicompat.d
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public void c(@NotNull com.tencent.mobileqq.aio.input.inputbar.viewbinding.a binding) {
        Intrinsics.checkNotNullParameter(binding, "binding");
        this.mBinding = binding;
    }

    @Override // com.tencent.input.base.mvicompat.a
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public void L0(@NotNull com.tencent.mobileqq.aio.input.adorn.b bVar) {
        Intrinsics.checkNotNullParameter(bVar, "<set-?>");
        this.mHost = bVar;
    }

    @Override // com.tencent.input.base.mvicompat.d
    public void onDestroy() {
        c.a.d(this);
    }
}
