package r02;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J$\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0004H&J\b\u0010\r\u001a\u00020\u000bH&J\b\u0010\u000e\u001a\u00020\u000bH&J\b\u0010\u000f\u001a\u00020\u000bH&J\u001a\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u001a\u0010\u0012\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\u0013"}, d2 = {"Lr02/a;", "", "Landroid/content/Context;", "context", "", "curFriendUin", "", "uinType", "Landroid/view/View;", "b", "selfUin", "", "a", "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Landroid/graphics/drawable/Drawable;", "getCurrentChatBackgroundDrawable", "getCurrentChatBackgroundBg", "qqguild-df-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public interface a {
    void a(@NotNull String selfUin);

    @Nullable
    View b(@Nullable Context context, @NotNull String curFriendUin, int uinType);

    @Nullable
    String getCurrentChatBackgroundBg(@NotNull String curFriendUin, int uinType);

    @Nullable
    Drawable getCurrentChatBackgroundDrawable(@NotNull String curFriendUin, int uinType);

    void onDestroy();

    void onPause();

    void onResume();
}
