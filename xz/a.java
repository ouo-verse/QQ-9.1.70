package xz;

import com.tencent.biz.pubaccount.weishi.player.l;
import com.tencent.mobileqq.qqfloatingwindow.listener.IVideoOuterStatusListener;
import java.util.List;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&J\u0016\u0010\n\u001a\u00020\t2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H&J\b\u0010\u000b\u001a\u00020\tH&J\b\u0010\f\u001a\u00020\tH&J\b\u0010\r\u001a\u00020\tH&J\b\u0010\u000e\u001a\u00020\tH&J\b\u0010\u000f\u001a\u00020\tH&J\b\u0010\u0011\u001a\u00020\u0010H&J\b\u0010\u0012\u001a\u00020\tH&J\n\u0010\u0014\u001a\u0004\u0018\u00010\u0013H&J\b\u0010\u0015\u001a\u00020\tH&\u00a8\u0006\u0016"}, d2 = {"Lxz/a;", "", "Lcom/tencent/biz/pubaccount/weishi/player/e;", tl.h.F, "Lxz/d;", "d", "", "Lcom/tencent/biz/pubaccount/weishi/player/l;", "infoList", "", "a", "playVideo", "e", "pauseVideo", "c", "preloadVideo", "", "b", "g", "Lcom/tencent/mobileqq/qqfloatingwindow/listener/IVideoOuterStatusListener;", "f", "release", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public interface a {
    void a(List<l> infoList);

    boolean b();

    void c();

    d d();

    void e();

    IVideoOuterStatusListener f();

    void g();

    com.tencent.biz.pubaccount.weishi.player.e h();

    void pauseVideo();

    void playVideo();

    void preloadVideo();

    void release();
}
