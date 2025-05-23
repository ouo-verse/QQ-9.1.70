package st;

import android.content.Context;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.android.androidbypass.codeblock.config.c;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\b\u0010\t\u001a\u00020\bH&J\b\u0010\u000b\u001a\u00020\nH&J\n\u0010\r\u001a\u0004\u0018\u00010\fH&\u00a8\u0006\u000e"}, d2 = {"Lst/a;", "", "Landroid/content/Context;", "context", "", IjkMediaMeta.IJKM_KEY_LANGUAGE, "Lcom/tencent/android/androidbypass/codeblock/config/c;", "d", "", "c", "", "a", "Landroidx/lifecycle/LifecycleOwner;", "b", "bypass_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public interface a {
    int a();

    @Nullable
    LifecycleOwner b();

    boolean c();

    @NotNull
    c d(@NotNull Context context, @NotNull String language);
}
