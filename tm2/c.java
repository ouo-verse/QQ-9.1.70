package tm2;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.cache.api.util.ImageCacheHelper;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.richmediabrowser.model.AIOFileVideoData;
import com.tencent.mobileqq.richmediabrowser.view.AIOFileVideoView;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mtt.hippy.bridge.HippyBridge;
import java.io.File;

/* compiled from: P */
/* loaded from: classes18.dex */
public class c implements c04.a {
    private boolean c(AIOFileVideoData aIOFileVideoData) {
        if (i(aIOFileVideoData) || aIOFileVideoData == null || aIOFileVideoData.K || !AppNetConnInfo.isMobileConn()) {
            return false;
        }
        if (!TextUtils.isEmpty(aIOFileVideoData.f281837d)) {
            long j3 = aIOFileVideoData.size;
            if (j3 > 0 && j3 > aIOFileVideoData.f281840h) {
                return true;
            }
        }
        if (aIOFileVideoData.size <= 1048576) {
            return false;
        }
        return true;
    }

    public void b(AIOFileVideoData aIOFileVideoData, Context context, AIOFileVideoView aIOFileVideoView) {
        if (!c(aIOFileVideoData)) {
            aIOFileVideoView.z0();
        }
    }

    public Drawable d(AIOFileVideoData aIOFileVideoData) {
        File e16 = e(aIOFileVideoData);
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        Drawable drawable = com.tencent.mobileqq.urldrawable.b.f306350a;
        obtain.mLoadingDrawable = drawable;
        obtain.mFailedDrawable = drawable;
        if (e16 != null && ImageCacheHelper.f98636a.g(f(aIOFileVideoData)) != null) {
            return URLDrawable.getDrawable(f(aIOFileVideoData), obtain);
        }
        if (e16 != null) {
            URLDrawable drawable2 = URLDrawable.getDrawable(f(aIOFileVideoData), obtain);
            drawable2.downloadImediatly();
            return drawable2;
        }
        return null;
    }

    public File e(AIOFileVideoData aIOFileVideoData) {
        if (aIOFileVideoData != null && FileUtils.fileExistsAndNotEmpty(aIOFileVideoData.f281838e)) {
            return new File(aIOFileVideoData.f281838e);
        }
        return null;
    }

    public String f(AIOFileVideoData aIOFileVideoData) {
        if (aIOFileVideoData != null && !TextUtils.isEmpty(aIOFileVideoData.f281838e)) {
            if (!aIOFileVideoData.f281838e.startsWith("/")) {
                return "file:/" + aIOFileVideoData.f281838e;
            }
            if (aIOFileVideoData.f281838e.startsWith("//")) {
                return HippyBridge.URI_SCHEME_FILE + aIOFileVideoData.f281838e;
            }
            return HippyBridge.URI_SCHEME_FILE + aIOFileVideoData.f281838e;
        }
        return "";
    }

    public f g(AIOFileVideoData aIOFileVideoData, boolean z16) {
        String str;
        f fVar = new f();
        fVar.f436609c = new String[]{aIOFileVideoData.C};
        fVar.f436610d = aIOFileVideoData.D;
        boolean z17 = !i(aIOFileVideoData);
        fVar.f436607a = z17;
        if (z17) {
            str = "";
        } else {
            str = aIOFileVideoData.f281839f;
        }
        fVar.f436608b = str;
        fVar.f436621o = aIOFileVideoData.progress;
        fVar.f436614h = true;
        fVar.f436620n = aIOFileVideoData.size;
        fVar.f436617k = aIOFileVideoData.msgId;
        fVar.f436618l = aIOFileVideoData.subId;
        fVar.f436619m = z16;
        fVar.f436624r = aIOFileVideoData.U;
        return fVar;
    }

    public boolean h(AIOFileVideoData aIOFileVideoData) {
        return !TextUtils.isEmpty(aIOFileVideoData.J);
    }

    public boolean i(AIOFileVideoData aIOFileVideoData) {
        Bundle bundle;
        if (aIOFileVideoData != null) {
            if (TextUtils.isEmpty(aIOFileVideoData.f281839f) && (bundle = aIOFileVideoData.U) != null) {
                aIOFileVideoData.f281839f = bundle.getString("savepath");
            }
            if (FileUtils.fileExistsAndNotEmpty(aIOFileVideoData.f281839f)) {
                aIOFileVideoData.G = true;
                return true;
            }
        }
        if (aIOFileVideoData != null && aIOFileVideoData.C == null) {
            aIOFileVideoData.G = false;
        }
        return false;
    }

    public boolean j(AIOFileVideoData aIOFileVideoData, d04.a aVar) {
        if (aIOFileVideoData == null || i(aIOFileVideoData) || !(aVar instanceof com.tencent.mobileqq.richmediabrowser.f)) {
            return false;
        }
        if (aIOFileVideoData.D != null && !TextUtils.isEmpty(aIOFileVideoData.C)) {
            return false;
        }
        ((com.tencent.mobileqq.richmediabrowser.f) aVar).y(aIOFileVideoData.msgId, aIOFileVideoData.subId, 16842753);
        return true;
    }

    @Override // c04.a
    public void a(f04.a aVar) {
    }
}
