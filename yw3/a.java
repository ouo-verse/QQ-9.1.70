package yw3;

import android.content.Context;
import android.view.View;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH&J\b\u0010\r\u001a\u00020\fH&\u00a8\u0006\u000e"}, d2 = {"Lyw3/a;", "", "Landroid/content/Context;", "context", "", "uid", "", "chatType", "", "scale", "Landroid/view/View;", "a", "", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "aio_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public interface a {
    @NotNull
    View a(@NotNull Context context, @NotNull String uid, int chatType, float scale);

    void onDestroy();
}
