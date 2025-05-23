package w64;

import android.view.View;
import android.widget.PopupWindow;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0004H&J\u0012\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u0004H&J\b\u0010\b\u001a\u00020\u0002H&J\b\u0010\n\u001a\u00020\tH&J\b\u0010\f\u001a\u00020\u000bH&R\u0014\u0010\u0010\u001a\u00020\r8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0014\u001a\u00020\u00118&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0015"}, d2 = {"Lw64/o;", "", "", "showDialog", "", "r", "needAnimation", "b", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Landroid/widget/PopupWindow;", "d", "Lcom/tencent/input/base/launch/b;", "c", "Landroid/view/View;", "a", "()Landroid/view/View;", "anchor", "", "e", "()I", "transitionState", "robot-core-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public interface o {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes25.dex */
    public static final class a {
        public static /* synthetic */ void a(o oVar, boolean z16, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 1) != 0) {
                    z16 = false;
                }
                oVar.b(z16);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: dismissDialog");
        }
    }

    @NotNull
    View a();

    void b(boolean needAnimation);

    @NotNull
    com.tencent.input.base.launch.b c();

    @NotNull
    PopupWindow d();

    int e();

    void onDestroy();

    boolean r();

    void showDialog();
}
