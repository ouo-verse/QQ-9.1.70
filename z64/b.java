package z64;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleOwner;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mvi.api.runtime.b;
import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.mvi.mvvm.BaseVB;
import com.tencent.mvi.mvvm.BaseVM;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ol3.b;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import x64.m;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b'\u0018\u0000 2*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0004*\u00020\u0003*\b\b\u0002\u0010\u0006*\u00020\u00052\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0007:\u000234B\u0007\u00a2\u0006\u0004\b0\u00101J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016J\u001a\u0010\r\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\fH\u0016R\"\u0010\u0014\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0002\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u0018\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0002\u001a\u0004\b\u0016\u0010\u0011\"\u0004\b\u0017\u0010\u0013R\"\u0010\u001c\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u0002\u001a\u0004\b\u001a\u0010\u0011\"\u0004\b\u001b\u0010\u0013R\"\u0010 \u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u0002\u001a\u0004\b\u001e\u0010\u0011\"\u0004\b\u001f\u0010\u0013R\"\u0010$\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\u0002\u001a\u0004\b\"\u0010\u0011\"\u0004\b#\u0010\u0013R\"\u0010(\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b%\u0010\u0002\u001a\u0004\b&\u0010\u0011\"\u0004\b'\u0010\u0013R\"\u0010+\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\u0002\u001a\u0004\b)\u0010\u0011\"\u0004\b*\u0010\u0013R\"\u0010/\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b,\u0010\u0002\u001a\u0004\b-\u0010\u0011\"\u0004\b.\u0010\u0013\u00a8\u00065"}, d2 = {"Lz64/b;", "Lol3/b;", "I", "Lcom/tencent/mvi/base/mvi/MviUIState;", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/mvi/api/runtime/b;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mvi/mvvm/BaseVB;", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "Landroid/view/View;", "onCreateView", "Lcom/tencent/mvi/mvvm/BaseVM;", "createVM", "", "d", "f1", "()I", "i1", "(I)V", "tongueViewHeight", "e", "getTongueViewWidth", "setTongueViewWidth", "tongueViewWidth", "f", "c1", "setIconGravity", "iconGravity", h.F, "d1", "setIconXOffset", "iconXOffset", "i", "e1", "setIconYOffset", "iconYOffset", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "getTongueBackgroundColorRes", "h1", "tongueBackgroundColorRes", "getTongueBackgroundColorInt", "setTongueBackgroundColorInt", "tongueBackgroundColorInt", "D", "b1", "g1", "iconColorRes", "<init>", "()V", "E", "a", "b", "robot-core-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class b<I extends ol3.b, S extends MviUIState, C extends com.tencent.mvi.api.runtime.b> extends BaseVB<I, S, C> {

    @NotNull
    private static final a E = new a(null);

    /* renamed from: D, reason: from kotlin metadata */
    @ColorRes
    private int iconColorRes;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int iconXOffset;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int iconYOffset;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @ColorRes
    private int tongueBackgroundColorRes;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int tongueViewHeight = 57;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int tongueViewWidth = -1;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int iconGravity = 17;

    /* renamed from: C, reason: from kotlin metadata */
    @ColorInt
    private int tongueBackgroundColorInt = -1;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\t\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\nR\u0014\u0010\f\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0004R\u0014\u0010\r\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\nR\u0014\u0010\u000e\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0004\u00a8\u0006\u0011"}, d2 = {"Lz64/b$a;", "", "", "BACKGROUND_RADIUS_DP", "I", "", "FOREGROUND_COLOR", "J", "", "FOREGROUND_HEIGHT_DP", UserInfo.SEX_FEMALE, "FOREGROUND_RADIUS_DP", "FOREGROUND_TOP_DP", "FOREGROUND_WIDTH_DP", "TONGUE_HEIGHT_DP", "<init>", "()V", "robot-core-kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    private static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        a() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u00a2\u0006\u0004\b\u001f\u0010 J0\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004H\u0014J\u0012\u0010\r\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0014R\u001c\u0010\u0012\u001a\n \u000f*\u0004\u0018\u00010\u000e0\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0016\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0018\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0015R\u0014\u0010\u001c\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u00a8\u0006!"}, d2 = {"Lz64/b$b;", "Landroid/view/View;", "", "changed", "", "left", "top", "right", "bottom", "", "onLayout", "Landroid/graphics/Canvas;", PM.CANVAS, "onDraw", "Landroid/util/DisplayMetrics;", "kotlin.jvm.PlatformType", "d", "Landroid/util/DisplayMetrics;", "mDisplayMetrics", "Landroid/graphics/Rect;", "e", "Landroid/graphics/Rect;", "mTempRect1", "f", "mTempRect2", "Landroid/graphics/drawable/GradientDrawable;", h.F, "Landroid/graphics/drawable/GradientDrawable;", "mForeground", "Landroid/content/Context;", "context", "<init>", "(Lz64/b;Landroid/content/Context;)V", "robot-core-kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: z64.b$b, reason: collision with other inner class name */
    /* loaded from: classes25.dex */
    private final class C11661b extends View {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final DisplayMetrics mDisplayMetrics;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Rect mTempRect1;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Rect mTempRect2;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final GradientDrawable mForeground;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ b<I, S, C> f452102i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C11661b(@NotNull b bVar, Context context) {
            super(context);
            ColorStateList valueOf;
            Intrinsics.checkNotNullParameter(context, "context");
            this.f452102i = bVar;
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            this.mDisplayMetrics = displayMetrics;
            this.mTempRect1 = new Rect();
            this.mTempRect2 = new Rect();
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            gradientDrawable.setCornerRadius(y64.a.b(displayMetrics, 2.5f));
            if (bVar.getIconColorRes() != 0) {
                valueOf = context.getColorStateList(bVar.getIconColorRes());
            } else {
                valueOf = ColorStateList.valueOf(-3223342);
            }
            gradientDrawable.setColor(valueOf);
            gradientDrawable.setSize((int) y64.a.b(displayMetrics, 36.0f), (int) y64.a.b(displayMetrics, 5.0f));
            this.mForeground = gradientDrawable;
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            float c16 = y64.a.c(displayMetrics, 8);
            gradientDrawable2.setCornerRadii(new float[]{c16, c16, c16, c16, 0.0f, 0.0f, 0.0f, 0.0f});
            gradientDrawable2.setShape(0);
            setBackground(gradientDrawable2);
        }

        @Override // android.view.View
        protected void onDraw(@Nullable Canvas canvas) {
            if (canvas != null) {
                this.mForeground.draw(canvas);
            }
        }

        @Override // android.view.View
        protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
            Rect rect = this.mTempRect1;
            rect.set(left, top, right, bottom);
            Rect rect2 = this.mTempRect2;
            Gravity.apply(this.f452102i.getIconGravity(), this.mForeground.getIntrinsicWidth(), this.mForeground.getIntrinsicHeight(), rect, this.f452102i.getIconXOffset(), this.f452102i.getIconYOffset(), rect2, 0);
            this.mForeground.setBounds(rect2);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0001J\u0017\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0002H\u0016\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"z64/b$c", "Lcom/tencent/mvi/mvvm/BaseVM;", "context", "", "onCreate", "(Lcom/tencent/mvi/api/runtime/b;)V", "robot-core-kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class c extends BaseVM<I, S, C> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ b<I, S, C> f452103d;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J \u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\t"}, d2 = {"z64/b$c$a", "Lx64/m;", "", "isHalfMode", "", "accumulatedValue", "totalAvailableHint", "w0", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "robot-core-kit_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes25.dex */
        public static final class a implements m {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ b<I, S, C> f452104d;

            a(b<I, S, C> bVar) {
                this.f452104d = bVar;
            }

            @Override // x64.m
            public int Q(boolean isHalfMode, int accumulatedValue, int totalAvailableHint) {
                return this.f452104d.getTongueViewHeight();
            }

            @Override // x64.m
            public int m() {
                return m.a.a(this);
            }

            @Override // x64.m
            public int w0(boolean isHalfMode, int accumulatedValue, int totalAvailableHint) {
                return this.f452104d.getTongueViewHeight();
            }
        }

        c(b<I, S, C> bVar) {
            this.f452103d = bVar;
        }

        @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
        public void onCreate(@NotNull C context) {
            Intrinsics.checkNotNullParameter(context, "context");
            super.onCreate((c) context);
            ml3.a a16 = context.b().a(m.class);
            a aVar = new a(this.f452103d);
            LifecycleOwner d16 = context.d();
            Intrinsics.checkNotNullExpressionValue(d16, "context.lifecycleOwner");
            a16.b(aVar, d16);
        }
    }

    /* renamed from: b1, reason: from getter */
    public final int getIconColorRes() {
        return this.iconColorRes;
    }

    /* renamed from: c1, reason: from getter */
    public final int getIconGravity() {
        return this.iconGravity;
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    public BaseVM<I, S, C> createVM() {
        return new c(this);
    }

    /* renamed from: d1, reason: from getter */
    public final int getIconXOffset() {
        return this.iconXOffset;
    }

    /* renamed from: e1, reason: from getter */
    public final int getIconYOffset() {
        return this.iconYOffset;
    }

    /* renamed from: f1, reason: from getter */
    public final int getTongueViewHeight() {
        return this.tongueViewHeight;
    }

    public final void g1(int i3) {
        this.iconColorRes = i3;
    }

    public final void h1(int i3) {
        this.tongueBackgroundColorRes = i3;
    }

    public final void i1(int i3) {
        this.tongueViewHeight = i3;
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        ColorStateList valueOf;
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        C11661b c11661b = new C11661b(this, createViewParams.a());
        c11661b.setLayoutParams(new ViewGroup.LayoutParams(this.tongueViewWidth, this.tongueViewHeight));
        Drawable background = c11661b.getBackground();
        Intrinsics.checkNotNull(background, "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
        GradientDrawable gradientDrawable = (GradientDrawable) background;
        if (this.tongueBackgroundColorRes != 0) {
            valueOf = c11661b.getContext().getColorStateList(this.tongueBackgroundColorRes);
        } else {
            valueOf = ColorStateList.valueOf(this.tongueBackgroundColorInt);
        }
        gradientDrawable.setColor(valueOf);
        return c11661b;
    }
}
