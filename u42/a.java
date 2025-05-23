package u42;

import android.graphics.Rect;
import android.view.View;
import com.tencent.mobileqq.icgame.api.room.ITPPlayerVideoView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.view.ISPlayerVideoView;

/* compiled from: P */
/* loaded from: classes15.dex */
public class a implements ITPPlayerVideoView {

    /* renamed from: a, reason: collision with root package name */
    private ISPlayerVideoView f438215a;

    /* renamed from: b, reason: collision with root package name */
    private int f438216b = 0;

    public a(ISPlayerVideoView iSPlayerVideoView) {
        this.f438215a = iSPlayerVideoView;
    }

    @Override // com.tencent.mobileqq.icgame.api.room.ITPPlayerVideoView
    public void blackScreen(boolean z16) {
        int i3;
        Object obj = this.f438215a;
        if (obj instanceof View) {
            View view = (View) obj;
            if (z16) {
                i3 = 4;
            } else {
                i3 = 0;
            }
            view.setVisibility(i3);
        }
    }

    @Override // com.tencent.mobileqq.icgame.api.room.ITPPlayerVideoView
    public View getCurrentDisplayView() {
        Object obj = this.f438215a;
        if (obj instanceof View) {
            return (View) obj;
        }
        return null;
    }

    @Override // com.tencent.mobileqq.icgame.api.room.ITPPlayerVideoView
    public Rect getDisplayViewRect() {
        Rect rect = new Rect();
        View renderView = this.f438215a.getRenderView();
        if (renderView != null) {
            renderView.getGlobalVisibleRect(rect);
        }
        QLog.i("ICGameSuperPlayerVideoView", 1, "getDisplayViewRect viewRect:" + rect);
        return rect;
    }

    @Override // com.tencent.mobileqq.icgame.api.room.ITPPlayerVideoView
    public int getViewRenderMode() {
        return this.f438216b;
    }

    @Override // com.tencent.mobileqq.icgame.api.room.ITPPlayerVideoView
    public int getXYAxis() {
        QLog.i("ICGameSuperPlayerVideoView", 1, "getXYAxis type:" + this.f438216b);
        return this.f438216b;
    }

    @Override // com.tencent.mobileqq.icgame.api.room.ITPPlayerVideoView
    public boolean setDegree(int i3) {
        this.f438215a.setDegree(i3);
        return true;
    }

    @Override // com.tencent.mobileqq.icgame.api.room.ITPPlayerVideoView
    public void setFixedSize(int i3, int i16) {
        QLog.i("ICGameSuperPlayerVideoView", 1, "setFixedSize videoWidth:" + i3 + " videoHeight:" + i16);
        this.f438215a.setFixedSize(i3, i16);
    }

    @Override // com.tencent.mobileqq.icgame.api.room.ITPPlayerVideoView
    public void setScaleParam(float f16) {
        this.f438215a.setScaleParam(f16);
    }

    @Override // com.tencent.mobileqq.icgame.api.room.ITPPlayerVideoView
    public void setXYAxis(int i3) {
        QLog.i("ICGameSuperPlayerVideoView", 1, "setXYAxis type:" + i3);
        this.f438216b = i3;
        this.f438215a.setXYaxis(i3);
    }

    @Override // com.tencent.mobileqq.icgame.api.room.ITPPlayerVideoView
    public void release() {
    }

    @Override // com.tencent.mobileqq.icgame.api.room.ITPPlayerVideoView
    public void addSurfaceCallback(ITPPlayerVideoView.IVideoSurfaceCallback iVideoSurfaceCallback) {
    }

    @Override // com.tencent.mobileqq.icgame.api.room.ITPPlayerVideoView
    public void removeSurfaceCallback(ITPPlayerVideoView.IVideoSurfaceCallback iVideoSurfaceCallback) {
    }
}
