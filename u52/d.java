package u52;

import android.view.View;
import com.tencent.superplayer.view.ISPlayerVideoView;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016R\u0016\u0010\t\u001a\u0004\u0018\u00010\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\b\u00a8\u0006\f"}, d2 = {"Lu52/d;", "Lo52/d;", "Landroid/view/View;", "a", "", "b", "c", "Lcom/tencent/superplayer/view/ISPlayerVideoView;", "Lcom/tencent/superplayer/view/ISPlayerVideoView;", "videoView", "<init>", "(Lcom/tencent/superplayer/view/ISPlayerVideoView;)V", "kandian_feature_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class d implements o52.d {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final ISPlayerVideoView videoView;

    public d(ISPlayerVideoView iSPlayerVideoView) {
        this.videoView = iSPlayerVideoView;
    }

    @Override // o52.d
    public View a() {
        Object obj = this.videoView;
        if (obj instanceof View) {
            return (View) obj;
        }
        return null;
    }

    @Override // o52.d
    public void b() {
        ISPlayerVideoView iSPlayerVideoView = this.videoView;
        if (iSPlayerVideoView != null) {
            iSPlayerVideoView.disableViewCallback();
        }
    }

    @Override // o52.d
    public void c() {
        ISPlayerVideoView iSPlayerVideoView = this.videoView;
        if (iSPlayerVideoView != null) {
            iSPlayerVideoView.enableViewCallback();
        }
    }
}
