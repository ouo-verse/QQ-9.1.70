package uz3;

import android.graphics.Canvas;
import android.graphics.SurfaceTexture;
import android.os.Build;
import android.view.TextureView;
import android.view.View;
import uz3.b;

/* compiled from: P */
/* loaded from: classes25.dex */
public class j implements b, TextureView.SurfaceTextureListener {

    /* renamed from: d, reason: collision with root package name */
    private TextureView f440686d;

    /* renamed from: e, reason: collision with root package name */
    private b.a f440687e;

    public j(TextureView textureView) {
        this.f440686d = textureView;
        if (textureView != null) {
            textureView.setOpaque(false);
            this.f440686d.setSurfaceTextureListener(this);
        }
    }

    @Override // uz3.b
    public float a() {
        TextureView textureView = this.f440686d;
        if (textureView == null) {
            return 0.0f;
        }
        return textureView.getY();
    }

    @Override // uz3.b
    public void b(b.a aVar) {
        this.f440687e = aVar;
    }

    @Override // uz3.b
    public void destroy() {
        SurfaceTexture surfaceTexture;
        this.f440687e = null;
        TextureView textureView = this.f440686d;
        if (textureView == null) {
            surfaceTexture = null;
        } else {
            surfaceTexture = textureView.getSurfaceTexture();
        }
        if (surfaceTexture != null) {
            surfaceTexture.release();
            wz3.b.a("TextureBarrageView", "[destroy] texture release, hashCode: " + hashCode());
        }
        TextureView textureView2 = this.f440686d;
        if (textureView2 != null) {
            textureView2.setOnTouchListener(null);
            this.f440686d = null;
        }
        wz3.b.a("TextureBarrageView", "[destroy] surface texture destroyed, hashCode: " + hashCode());
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001e, code lost:
    
        if (r0 != false) goto L13;
     */
    @Override // uz3.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Canvas lockCanvas() {
        boolean isReleased;
        TextureView textureView = this.f440686d;
        if (textureView == null || !textureView.isAvailable()) {
            return null;
        }
        if (Build.VERSION.SDK_INT >= 26) {
            SurfaceTexture surfaceTexture = this.f440686d.getSurfaceTexture();
            if (surfaceTexture != null) {
                isReleased = surfaceTexture.isReleased();
            }
            return null;
        }
        return this.f440686d.lockCanvas();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i3, int i16) {
        wz3.b.a("TextureBarrageView", "[onSurfaceTextureAvailable] surface texture available, hashCode: " + hashCode());
        TextureView textureView = this.f440686d;
        if (textureView != null) {
            textureView.setOpaque(false);
        }
        b.a aVar = this.f440687e;
        if (aVar != null) {
            aVar.c();
            this.f440687e.a();
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        wz3.b.a("TextureBarrageView", "[onSurfaceTextureDestroyed] surface texture destroyed, hashCode: " + hashCode());
        b.a aVar = this.f440687e;
        if (aVar != null) {
            aVar.b();
            return false;
        }
        return false;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i3, int i16) {
        wz3.b.a("TextureBarrageView", "[onSurfaceTextureSizeChanged] surface texture size changed, hashCode: " + hashCode());
        b.a aVar = this.f440687e;
        if (aVar != null) {
            aVar.a();
        }
    }

    @Override // uz3.b
    public void setOnTouchListener(View.OnTouchListener onTouchListener) {
        TextureView textureView = this.f440686d;
        if (textureView == null) {
            return;
        }
        textureView.setOnTouchListener(onTouchListener);
    }

    @Override // uz3.b
    public void unlockCanvasAndPost(Canvas canvas) {
        TextureView textureView = this.f440686d;
        if (textureView == null) {
            return;
        }
        textureView.unlockCanvasAndPost(canvas);
    }

    @Override // uz3.b
    public void unlock() {
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }
}
