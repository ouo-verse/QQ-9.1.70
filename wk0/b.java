package wk0;

import android.content.Context;
import android.view.View;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.filament.zplan.business.api.IBusinessScene;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import kotlin.Deprecated;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import uk0.c;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J#\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH&J\n\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u000f\u001a\u00020\u000bH&J\b\u0010\u0010\u001a\u00020\u000bH&J\b\u0010\u0011\u001a\u00020\u000bH&J\b\u0010\u0012\u001a\u00020\u000bH'\u00a8\u0006\u0013"}, d2 = {"Lwk0/b;", "", "Landroid/content/Context;", "context", "", "enableTouch", "Landroid/view/View;", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "(Landroid/content/Context;Ljava/lang/Boolean;)Landroid/view/View;", "Luk0/c;", "listener", "", "a", "Lcom/tencent/filament/zplan/business/api/IBusinessScene;", "getScene", "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "onFinish", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public interface b {

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
    /* loaded from: classes6.dex */
    public static final class a {
        public static /* synthetic */ View a(b bVar, Context context, Boolean bool, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    bool = Boolean.FALSE;
                }
                return bVar.z(context, bool);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getView");
        }
    }

    void a(@Nullable c listener);

    @Nullable
    IBusinessScene getScene();

    void onDestroy();

    @Deprecated(message = "\u5e9f\u5f03\uff0cdestroy\u540e\u5df2\u7ecf\u9500\u6bc1\uff0c\u4e0d\u80fd\u518d\u4f7f\u7528")
    void onFinish();

    void onPause();

    void onResume();

    @NotNull
    View z(@NotNull Context context, @Nullable Boolean enableTouch);
}
