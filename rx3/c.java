package rx3;

import android.content.Context;
import android.view.View;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J \u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH&J\b\u0010\u000e\u001a\u00020\fH&J\b\u0010\u000f\u001a\u00020\fH&\u00a8\u0006\u0010"}, d2 = {"Lrx3/c;", "", "Landroid/content/Context;", "context", "Landroid/view/View;", "createPanelView", "", "chatType", "", "chatId", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "", "c", "a", "b", "qwallet_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public interface c {
    void a();

    void b();

    void c(int chatType, @NotNull String chatId, @NotNull com.tencent.aio.api.runtime.a aioContext);

    @NotNull
    View createPanelView(@NotNull Context context);
}
