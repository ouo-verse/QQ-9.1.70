package x64;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.robot.widget.bottomdialog.behavior.BottomSheetDialogGestureBehavior;
import com.tencent.robot.widget.list.vb.CommonListVB;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import x64.l;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \n2\u00020\u0001:\u0001\u0007B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016R\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lx64/k;", "Lx64/l;", "Lcom/tencent/robot/widget/bottomdialog/behavior/c;", "viewOperator", "Lx64/j;", "uiMeasureHelper", "Lcom/tencent/robot/widget/bottomdialog/behavior/BottomSheetDialogGestureBehavior;", "a", "Landroid/content/Context;", "context", "b", "Lx64/l$a;", "getConfiguration", "Lx64/l$a;", "mConfiguration", "<init>", "()V", "robot-core-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class k implements l {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final l.a mConfiguration;

    public k() {
        boolean equals;
        Boolean bool;
        ColorDrawable colorDrawable = new ColorDrawable(Color.argb(104, 0, 0, 0));
        equals = StringsKt__StringsJVMKt.equals("M2105K81AC", DeviceInfoMonitor.getModel(), true);
        if (equals) {
            bool = Boolean.TRUE;
        } else {
            bool = null;
        }
        this.mConfiguration = new l.a(false, false, false, 0, bool, 0, colorDrawable, 47, null);
    }

    @Override // x64.l
    @NotNull
    public BottomSheetDialogGestureBehavior a(@NotNull com.tencent.robot.widget.bottomdialog.behavior.c viewOperator, @NotNull j uiMeasureHelper) {
        Intrinsics.checkNotNullParameter(viewOperator, "viewOperator");
        Intrinsics.checkNotNullParameter(uiMeasureHelper, "uiMeasureHelper");
        BottomSheetDialogGestureBehavior bottomSheetDialogGestureBehavior = new BottomSheetDialogGestureBehavior(viewOperator);
        bottomSheetDialogGestureBehavior.A(CommonListVB.INSTANCE.c());
        bottomSheetDialogGestureBehavior.B(uiMeasureHelper.g());
        return bottomSheetDialogGestureBehavior;
    }

    @Override // x64.l
    @NotNull
    public j b(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new j(context.getResources().getDisplayMetrics());
    }

    @Override // x64.l
    @NotNull
    /* renamed from: getConfiguration, reason: from getter */
    public l.a getMConfiguration() {
        return this.mConfiguration;
    }
}
