package tv.danmaku.ijk.media.player;

import android.graphics.SurfaceTexture;

/* compiled from: P */
/* loaded from: classes30.dex */
public interface ISurfaceTextureHolder {
    SurfaceTexture getSurfaceTexture();

    void setSurfaceTexture(SurfaceTexture surfaceTexture);

    void setSurfaceTextureHost(ISurfaceTextureHost iSurfaceTextureHost);
}
