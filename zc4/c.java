package zc4;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.Surface;
import android.view.View;
import com.tencent.qqlive.tvkplayer.api.render.ITVKVideoViewBase;
import com.tencent.qqlive.tvkplayer.view.TVKPlayerVideoView;
import com.tencent.superplayer.view.ISPlayerVideoView;
import com.tencent.superplayer.view.SPlayerVideoView;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes26.dex */
public class c implements ISPlayerVideoView {

    /* renamed from: i, reason: collision with root package name */
    private static final AtomicInteger f452310i = new AtomicInteger(1000);

    /* renamed from: d, reason: collision with root package name */
    private int f452311d;

    /* renamed from: e, reason: collision with root package name */
    private TVKPlayerVideoView f452312e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f452313f;

    /* renamed from: h, reason: collision with root package name */
    private Map<ISPlayerVideoView.IVideoViewCallBack, ITVKVideoViewBase.IVideoViewCallback> f452314h = new HashMap();

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class a implements ITVKVideoViewBase.IVideoViewCallback {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ISPlayerVideoView.IVideoViewCallBack f452315d;

        a(ISPlayerVideoView.IVideoViewCallBack iVideoViewCallBack) {
            this.f452315d = iVideoViewCallBack;
        }

        @Override // com.tencent.qqlive.tvkplayer.api.render.ITVKVideoViewBase.IVideoViewCallback
        public void onSurfaceChanged(ITVKVideoViewBase iTVKVideoViewBase, Surface surface, int i3, int i16) {
            this.f452315d.onSurfaceChanged(surface);
        }

        @Override // com.tencent.qqlive.tvkplayer.api.render.ITVKVideoViewBase.IVideoViewCallback
        public void onSurfaceCreated(ITVKVideoViewBase iTVKVideoViewBase, Surface surface) {
            this.f452315d.onSurfaceCreated(surface);
        }

        @Override // com.tencent.qqlive.tvkplayer.api.render.ITVKVideoViewBase.IVideoViewCallback
        public void onSurfaceDestroyed(ITVKVideoViewBase iTVKVideoViewBase, Surface surface) {
            this.f452315d.onSurfaceDestroy(surface);
        }
    }

    @SuppressLint({"ObsoleteSdkInt"})
    public c(Context context, boolean z16) {
        this.f452311d = 0;
        this.f452312e = null;
        this.f452313f = false;
        this.f452313f = z16;
        this.f452312e = new TVKPlayerVideoView(context, this.f452313f);
        this.f452311d = f452310i.addAndGet(1);
    }

    @Override // com.tencent.superplayer.view.ISPlayerVideoView
    public void addViewCallBack(ISPlayerVideoView.IVideoViewCallBack iVideoViewCallBack) {
        a aVar = new a(iVideoViewCallBack);
        this.f452312e.addViewCallback(aVar);
        this.f452314h.put(iVideoViewCallBack, aVar);
    }

    @Override // com.tencent.superplayer.view.ISPlayerVideoView
    public boolean disableViewCallback() {
        return this.f452312e.storeSurfaceTexture();
    }

    @Override // com.tencent.superplayer.view.ISPlayerVideoView
    public boolean enableViewCallback() {
        return this.f452312e.resumeSurfaceTexture();
    }

    @Override // com.tencent.superplayer.view.ISPlayerVideoView
    public String getLogTag() {
        return "SPlayerVideoView-" + this.f452311d + "|SPlayerTextureView-" + this.f452311d;
    }

    @Override // com.tencent.superplayer.view.ISPlayerVideoView
    public View getRenderView() {
        return this.f452312e;
    }

    @Override // com.tencent.superplayer.view.ISPlayerVideoView
    public int getRenderViewHeight() {
        return this.f452312e.getHeight();
    }

    @Override // com.tencent.superplayer.view.ISPlayerVideoView
    public int getRenderViewWidth() {
        return this.f452312e.getWidth();
    }

    @Override // com.tencent.superplayer.view.ISPlayerVideoView
    public Surface getSurface() {
        return this.f452312e.getRenderSurface();
    }

    @Override // com.tencent.superplayer.view.ISPlayerVideoView
    public boolean isSurfaceReady() {
        return this.f452312e.isSurfaceReady();
    }

    @Override // com.tencent.superplayer.view.ISPlayerVideoView
    public boolean isTextureView() {
        return this.f452313f;
    }

    @Override // com.tencent.superplayer.view.ISPlayerVideoView
    public void removeViewCallBack(ISPlayerVideoView.IVideoViewCallBack iVideoViewCallBack) {
        if (this.f452314h.containsKey(iVideoViewCallBack)) {
            this.f452312e.removeViewCallback(this.f452314h.get(iVideoViewCallBack));
            this.f452314h.remove(iVideoViewCallBack);
        }
    }

    @Override // com.tencent.superplayer.view.ISPlayerVideoView
    public void setDegree(int i3) {
        this.f452312e.setDegree(i3);
    }

    @Override // com.tencent.superplayer.view.ISPlayerVideoView
    public void setFixedSize(int i3, int i16) {
        this.f452312e.setFixedSize(i3, i16);
    }

    @Override // com.tencent.superplayer.view.ISPlayerVideoView
    public void setScaleParam(float f16) {
        this.f452312e.setDisplayScale(f16);
    }

    @Override // com.tencent.superplayer.view.ISPlayerVideoView
    public void setXYaxis(int i3) {
        this.f452312e.setXYaxis(i3);
    }

    @Override // com.tencent.superplayer.view.ISPlayerVideoView
    public void changeSurfaceObject(SPlayerVideoView.SurfaceObject surfaceObject) {
    }
}
