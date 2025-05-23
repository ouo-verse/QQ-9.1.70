package q63;

import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.light.listener.OnLoadAssetListener;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00152\u00020\u0001:\u0001\u000fB\u0011\b\u0016\u0012\u0006\u0010\u0012\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001e\u0010\t\u001a\u00020\u00042\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0016J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0016R\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0016"}, d2 = {"Lq63/a;", "Lorg/light/listener/OnLoadAssetListener;", "", "errorCode", "", "OnLoadAssetError", "Ljava/util/HashMap;", "", "hashMap", "OnAssetProcessing", "", "duration", "OnAssetDurationChange", "Ljava/lang/ref/WeakReference;", "Landroid/os/Handler;", "a", "Ljava/lang/ref/WeakReference;", "weakHandler", "handler", "<init>", "(Landroid/os/Handler;)V", "b", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class a implements OnLoadAssetListener {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final WeakReference<Handler> weakHandler;

    public a(@NotNull Handler handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        this.weakHandler = new WeakReference<>(handler);
    }

    @Override // org.light.listener.OnLoadAssetListener
    public void OnAssetDurationChange(long duration) {
        Handler handler = this.weakHandler.get();
        if (handler != null) {
            Message obtain = Message.obtain();
            obtain.what = 3;
            obtain.obj = Long.valueOf(duration);
            handler.sendMessage(obtain);
        }
    }

    @Override // org.light.listener.OnLoadAssetListener
    public void OnAssetProcessing(@Nullable HashMap<String, String> hashMap) {
        Handler handler = this.weakHandler.get();
        if (handler != null) {
            Message obtain = Message.obtain();
            obtain.what = 2;
            obtain.obj = hashMap;
            handler.sendMessage(obtain);
        }
    }

    @Override // org.light.listener.OnLoadAssetListener
    public void OnLoadAssetError(int errorCode) {
        Handler handler = this.weakHandler.get();
        if (handler != null) {
            handler.sendEmptyMessage(1);
        }
    }
}
