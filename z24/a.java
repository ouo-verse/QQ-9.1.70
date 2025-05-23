package z24;

import android.view.View;
import android.widget.FrameLayout;
import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.robot.aio.playvideo.PlayVideoVB;
import com.tencent.robot.aio.stopgeneratingbutton.RobotStopGenerateUIState;
import com.tencent.robot.aio.stopgeneratingbutton.d;
import com.tencent.robot.aio.story.RobotStoryAnimatorVB;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import ol3.b;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J&\u0010\f\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0006\b\u0001\u0012\u00020\n\u0012\u0006\b\u0001\u0012\u00020\u000b0\u00010\t2\u0006\u0010\b\u001a\u00020\u0006H\u0016\u00a8\u0006\u000f"}, d2 = {"Lz24/a;", "Lcom/tencent/aio/base/mvvm/a;", "Lcom/tencent/robot/aio/stopgeneratingbutton/a;", "Lcom/tencent/robot/aio/stopgeneratingbutton/RobotStopGenerateUIState;", "Lcom/tencent/mvi/api/help/a;", "params", "Landroid/view/View;", "onCreateView", "hostView", "", "Lol3/b;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "initializeChildVB", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class a extends com.tencent.aio.base.mvvm.a<com.tencent.robot.aio.stopgeneratingbutton.a, RobotStopGenerateUIState> {
    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    public List<com.tencent.aio.base.mvvm.a<? extends b, ? extends MviUIState>> initializeChildVB(@NotNull View hostView) {
        List<com.tencent.aio.base.mvvm.a<? extends b, ? extends MviUIState>> listOf;
        Intrinsics.checkNotNullParameter(hostView, "hostView");
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new com.tencent.aio.base.mvvm.a[]{new d(), new com.tencent.qqnt.aio.reserve2.animation.a(), new PlayVideoVB(), new RobotStoryAnimatorVB()});
        return listOf;
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a params) {
        Intrinsics.checkNotNullParameter(params, "params");
        return new FrameLayout(params.a());
    }
}
