package vi1;

import androidx.annotation.UiThread;
import androidx.lifecycle.LiveData;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import xi1.BatchManageOperate;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H'J(\u0010\u000e\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0004H'J\b\u0010\u000f\u001a\u00020\bH&J\b\u0010\u0010\u001a\u00020\u000bH&J\u0010\u0010\u0011\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH&J\u0010\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0002H&J\b\u0010\u0014\u001a\u00020\u0002H&J\b\u0010\u0015\u001a\u00020\u000bH&R\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00170\u00168&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001b"}, d2 = {"Lvi1/f;", "", "", "feedId", "", "j", "", "mode", "", "d", com.tencent.luggage.wxa.c8.c.G, "", "channelId", "isChecked", "c", "f", "g", tl.h.F, "channelName", "a", "b", "e", "Landroidx/lifecycle/LiveData;", "Lxi1/a;", "i", "()Landroidx/lifecycle/LiveData;", "batchManageOperateState", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public interface f {
    void a(@NotNull String channelName);

    @NotNull
    String b();

    @UiThread
    void c(int pos, @NotNull String feedId, long channelId, boolean isChecked);

    @UiThread
    void d(int mode);

    long e();

    void f();

    long g();

    void h(long channelId);

    @NotNull
    LiveData<BatchManageOperate> i();

    boolean j(@NotNull String feedId);
}
