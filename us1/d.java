package us1;

import android.util.ArrayMap;
import android.util.Size;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.mobileqq.guild.media.core.data.p;
import com.tencent.mobileqq.guild.media.core.f;
import com.tencent.mobileqq.guild.media.core.logic.video.MediaVideoTextureView;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import us1.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \b2\u00020\u0001:\u0001\"B\u000f\u0012\u0006\u0010\u001b\u001a\u00020\u0019\u00a2\u0006\u0004\b \u0010!J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0016J \u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rH\u0016J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0012\u001a\u00020\tH\u0016J\b\u0010\u0014\u001a\u00020\u0006H\u0016J\u0010\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\tH\u0016J\b\u0010\u0016\u001a\u00020\tH\u0016J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0012\u001a\u00020\tH\u0016R\u0014\u0010\u001b\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u001aR \u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u001d0\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u001e\u00a8\u0006#"}, d2 = {"Lus1/d;", "Lus1/b;", "", "userId", "Landroid/util/Size;", "d", "", "e", "f", "", "needShowVideo", "Landroid/view/View;", "l", "", "w", h.F, "N", DomainData.DOMAIN_NAME, "ignoreSelf", "L", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/guild/media/core/data/p;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/guild/media/core/f;", "Lcom/tencent/mobileqq/guild/media/core/f;", "core", "Landroid/util/ArrayMap;", "Lus1/e;", "Landroid/util/ArrayMap;", "userVideos", "<init>", "(Lcom/tencent/mobileqq/guild/media/core/f;)V", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class d implements us1.b {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final f core;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayMap<String, VideoViewTextureViewStruct> userVideos;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0016J\u0012\u0010\n\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u000b"}, d2 = {"us1/d$b", "Lus1/a;", "Landroid/view/Surface;", "surface", "", "onSurfaceCreated", "", "width", "height", "onSurfaceSizeChanged", "onSurfaceDestroyed", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b implements a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f439967a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ d f439968b;

        b(String str, d dVar) {
            this.f439967a = str;
            this.f439968b = dVar;
        }

        @Override // us1.a
        public void onSurfaceCreated(@NotNull Surface surface) {
            Intrinsics.checkNotNullParameter(surface, "surface");
            QLog.i("QGMC.TRTCVideoViewTextureViewImpl", 1, "onSurfaceCreated," + this.f439967a);
            VideoViewTextureViewStruct videoViewTextureViewStruct = (VideoViewTextureViewStruct) this.f439968b.userVideos.get(this.f439967a);
            if (videoViewTextureViewStruct != null) {
                videoViewTextureViewStruct.e(surface);
            }
            this.f439968b.e(this.f439967a);
        }

        @Override // us1.a
        public void onSurfaceDestroyed(@Nullable Surface surface) {
            QLog.i("QGMC.TRTCVideoViewTextureViewImpl", 1, "onSurfaceDestroyed," + this.f439967a);
            this.f439968b.f(this.f439967a);
        }

        @Override // us1.a
        public void onSurfaceSizeChanged(int width, int height) {
            QLog.i("QGMC.TRTCVideoViewTextureViewImpl", 1, "onSurfaceSizeChanged," + this.f439967a + ", " + width + ", " + height);
        }
    }

    public d(@NotNull f core) {
        Intrinsics.checkNotNullParameter(core, "core");
        this.core = core;
        this.userVideos = new ArrayMap<>();
    }

    private final Size d(String userId) {
        Object obj;
        List<p> list = this.core.D0().f228125a;
        Intrinsics.checkNotNullExpressionValue(list, "core.getUserInfoList().anchors");
        Iterator<T> it = list.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (((p) obj).f228103k) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        p pVar = (p) obj;
        if (pVar != null) {
            return new Size(pVar.f228106n, pVar.f228107o);
        }
        return new Size(0, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e(String userId) {
        VideoViewTextureViewStruct videoViewTextureViewStruct = this.userVideos.get(userId);
        if (videoViewTextureViewStruct != null && videoViewTextureViewStruct.getSurface() != null && videoViewTextureViewStruct.getNeedShowVideo()) {
            this.core.y0().w(userId, videoViewTextureViewStruct.getSurface());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f(String userId) {
        this.core.y0().e(userId);
    }

    @Override // us1.b
    public boolean A(boolean ignoreSelf) {
        Object obj;
        boolean z16;
        String f16 = ch.f();
        Intrinsics.checkNotNullExpressionValue(f16, "accountTinyId()");
        List<p> list = this.core.D0().f228125a;
        Intrinsics.checkNotNullExpressionValue(list, "core.getUserInfoList().anchors");
        Iterator<T> it = list.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                p pVar = (p) obj;
                if (ignoreSelf) {
                    if (pVar.f228103k && !Intrinsics.areEqual(pVar.f228093a, f16)) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                } else {
                    z16 = pVar.f228103k;
                }
                if (z16) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        if (obj != null) {
            return true;
        }
        return false;
    }

    @Override // us1.b
    public boolean C() {
        return this.core.getSelfUserInfo().f228103k;
    }

    @Override // us1.b
    @Nullable
    public View L(boolean ignoreSelf) {
        Object obj;
        String str;
        boolean z16;
        String f16 = ch.f();
        Intrinsics.checkNotNullExpressionValue(f16, "accountTinyId()");
        List<p> list = this.core.D0().f228125a;
        Intrinsics.checkNotNullExpressionValue(list, "core.getUserInfoList().anchors");
        Iterator<T> it = list.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                p pVar = (p) obj;
                if (ignoreSelf) {
                    if (pVar.f228103k && !Intrinsics.areEqual(pVar.f228093a, f16)) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                } else {
                    z16 = pVar.f228103k;
                }
                if (z16) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        p pVar2 = (p) obj;
        if (pVar2 != null) {
            str = pVar2.f228093a;
        } else {
            str = null;
        }
        if (str == null) {
            return null;
        }
        return b.a.a(this, str, false, 2, null);
    }

    @Override // us1.b
    public void N(@NotNull String userId, int w3, int h16) {
        TextureView textureView;
        Intrinsics.checkNotNullParameter(userId, "userId");
        VideoViewTextureViewStruct videoViewTextureViewStruct = this.userVideos.get(userId);
        MediaVideoTextureView mediaVideoTextureView = null;
        if (videoViewTextureViewStruct != null) {
            textureView = videoViewTextureViewStruct.getTextureView();
        } else {
            textureView = null;
        }
        if (textureView instanceof MediaVideoTextureView) {
            mediaVideoTextureView = (MediaVideoTextureView) textureView;
        }
        if (mediaVideoTextureView != null) {
            mediaVideoTextureView.setVideoSize(w3, h16);
        }
    }

    @Override // us1.b
    @NotNull
    public View l(@NotNull String userId, boolean needShowVideo) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        ViewGroup viewGroup = null;
        if (!this.userVideos.containsKey(userId)) {
            MediaVideoTextureView mediaVideoTextureView = new MediaVideoTextureView(this.core.getAppContext(), null, 2, null);
            mediaVideoTextureView.setSurfaceListener(new b(userId, this));
            Size d16 = d(userId);
            mediaVideoTextureView.setVideoSize(d16.getWidth(), d16.getHeight());
            this.userVideos.put(userId, new VideoViewTextureViewStruct(mediaVideoTextureView, null, needShowVideo));
        } else {
            VideoViewTextureViewStruct videoViewTextureViewStruct = this.userVideos.get(userId);
            if (videoViewTextureViewStruct != null) {
                videoViewTextureViewStruct.d(needShowVideo);
            }
        }
        if (needShowVideo) {
            e(userId);
        } else {
            f(userId);
        }
        VideoViewTextureViewStruct videoViewTextureViewStruct2 = this.userVideos.get(userId);
        Intrinsics.checkNotNull(videoViewTextureViewStruct2);
        View textureView = videoViewTextureViewStruct2.getTextureView();
        ViewParent parent = textureView.getParent();
        if (parent instanceof ViewGroup) {
            viewGroup = (ViewGroup) parent;
        }
        if (viewGroup != null) {
            viewGroup.removeView(textureView);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        textureView.setLayoutParams(layoutParams);
        return textureView;
    }

    @Override // us1.b
    @Nullable
    public p m(boolean ignoreSelf) {
        Object obj;
        boolean z16;
        String f16 = ch.f();
        Intrinsics.checkNotNullExpressionValue(f16, "accountTinyId()");
        List<p> list = this.core.D0().f228125a;
        Intrinsics.checkNotNullExpressionValue(list, "core.getUserInfoList().anchors");
        Iterator<T> it = list.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                p pVar = (p) obj;
                if (ignoreSelf) {
                    if (pVar.f228103k && !Intrinsics.areEqual(pVar.f228093a, f16)) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                } else {
                    z16 = pVar.f228103k;
                }
                if (z16) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        return (p) obj;
    }

    @Override // us1.b
    public void n(@NotNull String userId) {
        ViewGroup viewGroup;
        Intrinsics.checkNotNullParameter(userId, "userId");
        QLog.i("QGMC.TRTCVideoViewTextureViewImpl", 1, "releaseVideoView:" + userId);
        VideoViewTextureViewStruct remove = this.userVideos.remove(userId);
        if (remove != null) {
            f(userId);
            ViewParent parent = remove.getTextureView().getParent();
            if (parent instanceof ViewGroup) {
                viewGroup = (ViewGroup) parent;
            } else {
                viewGroup = null;
            }
            if (viewGroup != null) {
                viewGroup.removeView(remove.getTextureView());
            }
            TextureView textureView = remove.getTextureView();
            Intrinsics.checkNotNull(textureView, "null cannot be cast to non-null type com.tencent.mobileqq.guild.media.core.logic.video.MediaVideoTextureView");
            ((MediaVideoTextureView) textureView).g();
        }
    }

    @Override // us1.b
    public void z() {
        ViewGroup viewGroup;
        QLog.i("QGMC.TRTCVideoViewTextureViewImpl", 1, "releaseAllVideoView:" + this.userVideos.keySet());
        for (Map.Entry<String, VideoViewTextureViewStruct> entry : this.userVideos.entrySet()) {
            String key = entry.getKey();
            Intrinsics.checkNotNullExpressionValue(key, "userVideo.key");
            f(key);
            VideoViewTextureViewStruct value = entry.getValue();
            ViewParent parent = value.getTextureView().getParent();
            if (parent instanceof ViewGroup) {
                viewGroup = (ViewGroup) parent;
            } else {
                viewGroup = null;
            }
            if (viewGroup != null) {
                viewGroup.removeView(value.getTextureView());
            }
            TextureView textureView = value.getTextureView();
            Intrinsics.checkNotNull(textureView, "null cannot be cast to non-null type com.tencent.mobileqq.guild.media.core.logic.video.MediaVideoTextureView");
            ((MediaVideoTextureView) textureView).g();
        }
        this.userVideos.clear();
    }
}
