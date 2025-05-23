package ws1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import vp1.ay;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\n"}, d2 = {"Lws1/b;", "Lvs1/b;", "Landroid/content/Context;", "context", "Landroid/view/View;", OperateCustomButton.OPERATE_CREATE, "", "size", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class b implements vs1.b {
    @Override // vs1.b
    @NotNull
    public View create(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ConstraintLayout constraintLayout = ay.g(LayoutInflater.from(context)).C;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "inflate(LayoutInflater.from(context)).root");
        return constraintLayout;
    }

    @Override // vs1.b
    public int size() {
        return 10;
    }
}
