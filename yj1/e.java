package yj1;

import android.view.View;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0006\u0018\u0000 \r2\u00020\u0001:\u0001\tB\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u000b\u001a\u00020\bJ\u0006\u0010\f\u001a\u00020\bJ\u0006\u0010\r\u001a\u00020\bR(\u0010\u0011\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u000f0\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0010R&\u0010\u0014\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u000f0\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0013R&\u0010\u0015\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u000f0\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0013\u00a8\u0006\u0018"}, d2 = {"Lyj1/e;", "", "", "position", "Landroid/view/View;", "videoView", "Leo1/a;", "controller", "", "a", "e", "b", "c", "d", "Lkotlin/Pair;", "Lmqq/util/WeakReference;", "Lkotlin/Pair;", "playingPosition", "", "Ljava/util/Map;", "mVideoViewMap", "mVideoControllerMap", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Pair<Integer, ? extends WeakReference<eo1.a>> playingPosition = TuplesKt.to(-1, new WeakReference(null));

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Map<Integer, WeakReference<View>> mVideoViewMap = new LinkedHashMap();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Map<Integer, WeakReference<eo1.a>> mVideoControllerMap = new LinkedHashMap();

    public final void a(int position, @NotNull View videoView, @NotNull eo1.a controller) {
        Intrinsics.checkNotNullParameter(videoView, "videoView");
        Intrinsics.checkNotNullParameter(controller, "controller");
        QLog.d("GuildFeedSquareVideoPlayManager", 1, "add videoView pos:" + position);
        this.mVideoViewMap.put(Integer.valueOf(position), new WeakReference<>(videoView));
        this.mVideoControllerMap.put(Integer.valueOf(position), new WeakReference<>(controller));
        b();
    }

    public final void c() {
        eo1.a aVar;
        QLog.d("GuildFeedSquareVideoPlayManager", 1, " pause playingPosition: " + this.playingPosition.getFirst());
        if (this.playingPosition.getFirst().intValue() != -1 && (aVar = this.playingPosition.getSecond().get()) != null) {
            aVar.pause();
        }
        this.playingPosition = TuplesKt.to(-1, new WeakReference(null));
    }

    public final void d() {
        Iterator<Map.Entry<Integer, WeakReference<eo1.a>>> it = this.mVideoControllerMap.entrySet().iterator();
        while (it.hasNext()) {
            eo1.a aVar = it.next().getValue().get();
            if (aVar != null) {
                aVar.a();
            }
        }
        uj1.a.f439069a.b();
    }

    public final void e(int position) {
        QLog.d("GuildFeedSquareVideoPlayManager", 1, "remove videoView pos:" + position + ", playingPosition:" + this.playingPosition.getFirst());
        this.mVideoViewMap.remove(Integer.valueOf(position));
        this.mVideoControllerMap.remove(Integer.valueOf(position));
        if (this.playingPosition.getFirst().intValue() == position) {
            eo1.a aVar = this.playingPosition.getSecond().get();
            if (aVar != null) {
                aVar.pause();
            }
            this.playingPosition = TuplesKt.to(-1, new WeakReference(null));
        }
    }

    public final void b() {
    }
}
