package x64;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.tencent.robot.widget.bottomdialog.behavior.BottomSheetDialogGestureBehavior;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\u0007J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH&J\b\u0010\f\u001a\u00020\u000bH&\u00a8\u0006\r"}, d2 = {"Lx64/l;", "", "Lcom/tencent/robot/widget/bottomdialog/behavior/c;", "viewOperator", "Lx64/j;", "uiMeasureHelper", "Lcom/tencent/robot/widget/bottomdialog/behavior/BottomSheetDialogGestureBehavior;", "a", "Landroid/content/Context;", "context", "b", "Lx64/l$a;", "getConfiguration", "robot-core-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public interface l {
    @NotNull
    BottomSheetDialogGestureBehavior a(@NotNull com.tencent.robot.widget.bottomdialog.behavior.c viewOperator, @NotNull j uiMeasureHelper);

    @NotNull
    j b(@NotNull Context context);

    @NotNull
    a getConfiguration();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001BQ\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002\u0012\b\b\u0002\u0010\n\u001a\u00020\u0002\u0012\b\b\u0002\u0010\r\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0017\u00a2\u0006\u0004\b\u001b\u0010\u001cR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\n\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u0017\u0010\u0012\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\b\u0010\u0011R\u0019\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0013\u001a\u0004\b\u000b\u0010\u0014R\u0017\u0010\u0016\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011R\u0019\u0010\u001a\u001a\u0004\u0018\u00010\u00178\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\u0018\u001a\u0004\b\u0003\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lx64/l$a;", "", "", "a", "Z", "f", "()Z", "isFocusable", "b", "g", "isOutsideTouchable", "c", "e", "isClippingEnable", "", "d", "I", "()I", "inputMethodMode", "Ljava/lang/Boolean;", "()Ljava/lang/Boolean;", "laidOutInScreen", "smoothScrollDuration", "Landroid/graphics/drawable/Drawable;", "Landroid/graphics/drawable/Drawable;", "()Landroid/graphics/drawable/Drawable;", "background", "<init>", "(ZZZILjava/lang/Boolean;ILandroid/graphics/drawable/Drawable;)V", "robot-core-kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final boolean isFocusable;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final boolean isOutsideTouchable;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private final boolean isClippingEnable;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final int inputMethodMode;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final Boolean laidOutInScreen;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private final int smoothScrollDuration;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final Drawable background;

        public a(boolean z16, boolean z17, boolean z18, int i3, @Nullable Boolean bool, int i16, @Nullable Drawable drawable) {
            this.isFocusable = z16;
            this.isOutsideTouchable = z17;
            this.isClippingEnable = z18;
            this.inputMethodMode = i3;
            this.laidOutInScreen = bool;
            this.smoothScrollDuration = i16;
            this.background = drawable;
        }

        @Nullable
        /* renamed from: a, reason: from getter */
        public final Drawable getBackground() {
            return this.background;
        }

        /* renamed from: b, reason: from getter */
        public final int getInputMethodMode() {
            return this.inputMethodMode;
        }

        @Nullable
        /* renamed from: c, reason: from getter */
        public final Boolean getLaidOutInScreen() {
            return this.laidOutInScreen;
        }

        /* renamed from: d, reason: from getter */
        public final int getSmoothScrollDuration() {
            return this.smoothScrollDuration;
        }

        /* renamed from: e, reason: from getter */
        public final boolean getIsClippingEnable() {
            return this.isClippingEnable;
        }

        /* renamed from: f, reason: from getter */
        public final boolean getIsFocusable() {
            return this.isFocusable;
        }

        /* renamed from: g, reason: from getter */
        public final boolean getIsOutsideTouchable() {
            return this.isOutsideTouchable;
        }

        public /* synthetic */ a(boolean z16, boolean z17, boolean z18, int i3, Boolean bool, int i16, Drawable drawable, int i17, DefaultConstructorMarker defaultConstructorMarker) {
            this((i17 & 1) != 0 ? false : z16, (i17 & 2) != 0 ? false : z17, (i17 & 4) != 0 ? false : z18, (i17 & 8) == 0 ? i3 : 0, (i17 & 16) != 0 ? null : bool, (i17 & 32) != 0 ? 500 : i16, (i17 & 64) != 0 ? null : drawable);
        }
    }
}
