package u42;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import com.tencent.icgame.common.api.IAegisLogApi;
import com.tencent.mobileqq.icgame.api.room.ITPPlayerVideoView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.rtmp.ui.TXCloudVideoView;
import com.tencent.trtc.TRTCCloud;

/* compiled from: P */
/* loaded from: classes15.dex */
public class b implements ITPPlayerVideoView {

    /* renamed from: b, reason: collision with root package name */
    private final TRTCCloud f438218b;

    /* renamed from: c, reason: collision with root package name */
    private final TXCloudVideoView f438219c;

    /* renamed from: a, reason: collision with root package name */
    private final IAegisLogApi f438217a = (IAegisLogApi) QRoute.api(IAegisLogApi.class);

    /* renamed from: d, reason: collision with root package name */
    private int f438220d = 2;

    public b(TRTCCloud tRTCCloud, Context context) {
        this.f438218b = tRTCCloud;
        TXCloudVideoView tXCloudVideoView = new TXCloudVideoView(context);
        this.f438219c = tXCloudVideoView;
        tXCloudVideoView.setVisibility(0);
    }

    public TXCloudVideoView a() {
        return this.f438219c;
    }

    @Override // com.tencent.mobileqq.icgame.api.room.ITPPlayerVideoView
    public void addSurfaceCallback(ITPPlayerVideoView.IVideoSurfaceCallback iVideoSurfaceCallback) {
        this.f438217a.i("TRTCVideoView", "addSurfaceCallback " + iVideoSurfaceCallback);
    }

    @Override // com.tencent.mobileqq.icgame.api.room.ITPPlayerVideoView
    public void blackScreen(boolean z16) {
        this.f438217a.i("TRTCVideoView", "blackScreen isBlack:" + z16);
    }

    @Override // com.tencent.mobileqq.icgame.api.room.ITPPlayerVideoView
    public View getCurrentDisplayView() {
        this.f438217a.i("TRTCVideoView", "getCurrentDisplayView videoView:" + this.f438219c);
        return this.f438219c;
    }

    @Override // com.tencent.mobileqq.icgame.api.room.ITPPlayerVideoView
    public Rect getDisplayViewRect() {
        Rect rect = new Rect();
        this.f438219c.getGlobalVisibleRect(rect);
        this.f438217a.i("TRTCVideoView", "getDisplayViewRect:" + rect);
        return rect;
    }

    @Override // com.tencent.mobileqq.icgame.api.room.ITPPlayerVideoView
    public int getViewRenderMode() {
        this.f438217a.i("TRTCVideoView", "getViewRenderMode 2");
        return 2;
    }

    @Override // com.tencent.mobileqq.icgame.api.room.ITPPlayerVideoView
    public int getXYAxis() {
        this.f438217a.i("TRTCVideoView", "getXYAxis 0");
        return this.f438220d;
    }

    @Override // com.tencent.mobileqq.icgame.api.room.ITPPlayerVideoView
    public void release() {
        this.f438217a.i("TRTCVideoView", "release");
    }

    @Override // com.tencent.mobileqq.icgame.api.room.ITPPlayerVideoView
    public void removeSurfaceCallback(ITPPlayerVideoView.IVideoSurfaceCallback iVideoSurfaceCallback) {
        this.f438217a.i("TRTCVideoView", "removeSurfaceCallback " + iVideoSurfaceCallback);
    }

    @Override // com.tencent.mobileqq.icgame.api.room.ITPPlayerVideoView
    public boolean setDegree(int i3) {
        this.f438217a.i("TRTCVideoView", "setDegree degree:" + i3);
        return false;
    }

    @Override // com.tencent.mobileqq.icgame.api.room.ITPPlayerVideoView
    public void setFixedSize(int i3, int i16) {
        this.f438217a.i("TRTCVideoView", "setFixedSize videoWidth:" + i3 + " videoHeight:" + i16);
    }

    @Override // com.tencent.mobileqq.icgame.api.room.ITPPlayerVideoView
    public void setScaleParam(float f16) {
        this.f438217a.i("TRTCVideoView", "setScaleParam scale:" + f16);
    }

    @Override // com.tencent.mobileqq.icgame.api.room.ITPPlayerVideoView
    public void setXYAxis(int i3) {
        this.f438220d = i3;
        this.f438217a.i("TRTCVideoView", "setXYAxis mXYAxis:" + i3);
    }
}
