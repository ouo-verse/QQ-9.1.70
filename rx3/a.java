package rx3;

import android.content.Context;
import android.view.View;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0004H&J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H&J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u000bH&\u00a8\u0006\r"}, d2 = {"Lrx3/a;", "", "Landroid/content/Context;", "context", "Landroid/view/View;", "c", "b", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "", "a", "Lcom/tencent/aio/api/runtime/a;", "d", "qwallet_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public interface a {
    void a(@NotNull MsgRecord msgRecord);

    @Nullable
    View b();

    @NotNull
    View c(@NotNull Context context);

    void d(@NotNull com.tencent.aio.api.runtime.a context);
}
