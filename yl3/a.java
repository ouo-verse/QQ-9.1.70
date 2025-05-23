package yl3;

import android.content.Context;
import android.widget.FrameLayout;
import com.tencent.mobileqq.qqlive.AccompanyLibraryLoader;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.now.app.music.controller.MusicControlView;
import com.tencent.now.app.music.model.manager.MusicPlayMgr;
import com.tencent.qqlive.common.api.IAegisLogApi;

/* compiled from: P */
/* loaded from: classes22.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private IAegisLogApi f450643a = (IAegisLogApi) QRoute.api(IAegisLogApi.class);

    /* renamed from: b, reason: collision with root package name */
    private MusicControlView f450644b;

    public void a(Context context) {
        this.f450643a.i("MusicLogic", "init");
        AccompanyLibraryLoader.d();
    }

    public void b(FrameLayout frameLayout) {
        this.f450643a.i("MusicLogic", "onEnterRoom");
        MusicControlView musicControlView = new MusicControlView(frameLayout.getContext());
        this.f450644b = musicControlView;
        frameLayout.addView(musicControlView);
        MusicPlayMgr.o().N(this.f450644b);
    }

    public void c() {
        this.f450643a.i("MusicLogic", "onExitRoom");
        MusicControlView musicControlView = this.f450644b;
        if (musicControlView != null) {
            musicControlView.d(true);
        }
        MusicPlayMgr.o().y();
    }

    public void d() {
        this.f450643a.i("MusicLogic", "playPause");
        MusicControlView musicControlView = this.f450644b;
        if (musicControlView != null) {
            musicControlView.y();
        }
    }

    public void e() {
        this.f450643a.i("MusicLogic", "playResume");
        MusicControlView musicControlView = this.f450644b;
        if (musicControlView != null) {
            musicControlView.z();
        }
    }
}
