package qx3;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.aio.msg.k;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J \u0010\u000e\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH&J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\bH&J\u0010\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u000fH&J\u0010\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0004H&\u00a8\u0006\u0015"}, d2 = {"Lqx3/a;", "", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "width", "Landroid/view/View;", "e", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "position", "Lcom/tencent/mobileqq/aio/msg/k;", "shopArkMsgItem", "", "d", "", "b", "stop", "c", "newState", "a", "qwallet_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public interface a {
    void a(int newState);

    boolean b(@NotNull MsgRecord msgRecord);

    void c(boolean stop);

    void d(@NotNull MsgRecord msgRecord, int position, @NotNull k shopArkMsgItem);

    @NotNull
    View e(@NotNull ViewGroup parent, int width);
}
