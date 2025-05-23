package qp2;

import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0004\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0002H&J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H&\u00a8\u0006\t"}, d2 = {"Lqp2/d;", "", "", "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "onFirstFrame", "", "clickId", "onClickMiniApp", "qqsearch-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public interface d {
    void onClickMiniApp(@NotNull String clickId);

    void onFirstFrame();

    void onPause();

    void onResume();
}
