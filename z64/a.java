package z64;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mvi.api.runtime.b;
import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.mvi.mvvm.BaseVB;
import com.tencent.mvi.mvvm.BaseVM;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ol3.b;
import org.jetbrains.annotations.NotNull;
import tl.h;
import x64.m;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0019\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0004*\u00020\u0003*\b\b\u0002\u0010\u0006*\u00020\u00052\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0007B\u0007\u00a2\u0006\u0004\b%\u0010&J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016J\u001a\u0010\r\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\fH\u0016R\"\u0010\u0014\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0002\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u0018\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0002\u001a\u0004\b\u0016\u0010\u0011\"\u0004\b\u0017\u0010\u0013R\"\u0010\u001c\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u0002\u001a\u0004\b\u001a\u0010\u0011\"\u0004\b\u001b\u0010\u0013R\"\u0010 \u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u0002\u001a\u0004\b\u001e\u0010\u0011\"\u0004\b\u001f\u0010\u0013R\"\u0010$\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\u0002\u001a\u0004\b\"\u0010\u0011\"\u0004\b#\u0010\u0013\u00a8\u0006'"}, d2 = {"Lz64/a;", "Lol3/b;", "I", "Lcom/tencent/mvi/base/mvi/MviUIState;", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/mvi/api/runtime/b;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mvi/mvvm/BaseVB;", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "Landroid/view/View;", "onCreateView", "Lcom/tencent/mvi/mvvm/BaseVM;", "createVM", "", "d", "getBackgroundColorResId", "()I", "c1", "(I)V", "backgroundColorResId", "e", "getBackgroundColorInt", "setBackgroundColorInt", "backgroundColorInt", "f", "b1", "d1", "layoutHeight", h.F, "getLayoutWidth", "setLayoutWidth", "layoutWidth", "i", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "setLayoutSequence", "layoutSequence", "<init>", "()V", "robot-core-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class a<I extends ol3.b, S extends MviUIState, C extends com.tencent.mvi.api.runtime.b> extends BaseVB<I, S, C> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @ColorRes
    private int backgroundColorResId;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int layoutHeight;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @ColorInt
    private int backgroundColorInt = -1;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int layoutWidth = -1;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int layoutSequence = Integer.MAX_VALUE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0001J\u0017\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0002H\u0016\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"z64/a$a", "Lcom/tencent/mvi/mvvm/BaseVM;", "context", "", "onCreate", "(Lcom/tencent/mvi/api/runtime/b;)V", "robot-core-kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: z64.a$a, reason: collision with other inner class name */
    /* loaded from: classes25.dex */
    public static final class C11659a extends BaseVM<I, S, C> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ a<I, S, C> f452090d;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J \u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\t\u001a\u00020\u0004H\u0016\u00a8\u0006\n"}, d2 = {"z64/a$a$a", "Lx64/m;", "", "isHalfMode", "", "accumulatedValue", "totalAvailableHint", "w0", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "robot-core-kit_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: z64.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes25.dex */
        public static final class C11660a implements m {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ a<I, S, C> f452091d;

            C11660a(a<I, S, C> aVar) {
                this.f452091d = aVar;
            }

            @Override // x64.m
            public int Q(boolean isHalfMode, int accumulatedValue, int totalAvailableHint) {
                return 0;
            }

            @Override // x64.m
            public int m() {
                return this.f452091d.getLayoutSequence();
            }

            @Override // x64.m
            public int w0(boolean isHalfMode, int accumulatedValue, int totalAvailableHint) {
                ViewGroup.LayoutParams layoutParams;
                boolean z16;
                View safetyGetHostView = this.f452091d.safetyGetHostView();
                if (safetyGetHostView != null && (layoutParams = safetyGetHostView.getLayoutParams()) != null) {
                    Integer valueOf = Integer.valueOf(layoutParams.height);
                    if (valueOf.intValue() >= 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (!z16) {
                        valueOf = null;
                    }
                    if (valueOf != null) {
                        return valueOf.intValue();
                    }
                }
                return this.f452091d.getLayoutHeight();
            }
        }

        C11659a(a<I, S, C> aVar) {
            this.f452090d = aVar;
        }

        @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
        public void onCreate(@NotNull C context) {
            Intrinsics.checkNotNullParameter(context, "context");
            super.onCreate((C11659a) context);
            ml3.a a16 = context.b().a(m.class);
            C11660a c11660a = new C11660a(this.f452090d);
            LifecycleOwner d16 = context.d();
            Intrinsics.checkNotNullExpressionValue(d16, "context.lifecycleOwner");
            a16.b(c11660a, d16);
        }
    }

    /* renamed from: b1, reason: from getter */
    public final int getLayoutHeight() {
        return this.layoutHeight;
    }

    public final void c1(int i3) {
        this.backgroundColorResId = i3;
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    public BaseVM<I, S, C> createVM() {
        return new C11659a(this);
    }

    public final void d1(int i3) {
        this.layoutHeight = i3;
    }

    /* renamed from: m, reason: from getter */
    public final int getLayoutSequence() {
        return this.layoutSequence;
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        int i3;
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        View view = new View(createViewParams.a());
        view.setLayoutParams(new ViewGroup.LayoutParams(this.layoutWidth, this.layoutHeight));
        if (this.backgroundColorResId != 0) {
            i3 = view.getContext().getColor(this.backgroundColorResId);
        } else {
            i3 = this.backgroundColorInt;
        }
        view.setBackgroundColor(i3);
        return view;
    }
}
