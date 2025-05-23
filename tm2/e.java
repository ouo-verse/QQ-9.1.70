package tm2;

import android.graphics.drawable.Drawable;
import com.tencent.cache.api.util.ImageCacheHelper;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.richmediabrowser.AIOBrowserBaseData;
import com.tencent.mobileqq.richmediabrowser.model.AIOVideoData;
import com.tencent.mtt.hippy.bridge.HippyBridge;
import java.io.File;

/* compiled from: P */
/* loaded from: classes18.dex */
public class e implements c04.a {
    public Drawable b(AIOVideoData aIOVideoData) {
        File c16 = c(aIOVideoData, 0);
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        Drawable drawable = com.tencent.mobileqq.urldrawable.b.f306350a;
        obtain.mLoadingDrawable = drawable;
        obtain.mFailedDrawable = drawable;
        if (c16 != null && ImageCacheHelper.f98636a.g(d(aIOVideoData, 0)) != null) {
            return URLDrawable.getDrawable(d(aIOVideoData, 0), obtain);
        }
        if (c16 != null) {
            URLDrawable drawable2 = URLDrawable.getDrawable(d(aIOVideoData, 0), obtain);
            drawable2.downloadImediatly();
            return drawable2;
        }
        return null;
    }

    public File c(AIOVideoData aIOVideoData, int i3) {
        String str;
        if (aIOVideoData == null) {
            return null;
        }
        if (i3 != 0) {
            if (i3 != 1) {
                str = null;
            } else {
                str = aIOVideoData.f281844e;
            }
        } else {
            str = aIOVideoData.f281843d;
        }
        if (str != null && !str.equals(AIOBrowserBaseData.MEDIA_FILE_NONE)) {
            File file = new File(str);
            if (file.exists()) {
                return file;
            }
        }
        return null;
    }

    public String d(AIOVideoData aIOVideoData, int i3) {
        String str;
        if (aIOVideoData == null) {
            return null;
        }
        if (i3 != 0) {
            if (i3 != 1) {
                str = null;
            } else {
                str = aIOVideoData.f281844e;
            }
        } else {
            str = aIOVideoData.f281843d;
        }
        if (str == null || str.equals(AIOBrowserBaseData.MEDIA_FILE_NONE)) {
            return null;
        }
        if (!str.startsWith("/")) {
            return "file:/" + str;
        }
        if (str.startsWith("//")) {
            return HippyBridge.URI_SCHEME_FILE + str;
        }
        return HippyBridge.URI_SCHEME_FILE + str;
    }

    public void e(AIOVideoData aIOVideoData, int i3, String str) {
        if (AIOBrowserBaseData.MEDIA_FILE_ERROR.equals(str)) {
            if (i3 != 0) {
                if (i3 == 1) {
                    aIOVideoData.f281848m = true;
                    return;
                }
                return;
            }
            aIOVideoData.f281847i = true;
            return;
        }
        if (i3 != 0) {
            if (i3 == 1) {
                aIOVideoData.f281844e = str;
                return;
            }
            return;
        }
        aIOVideoData.f281843d = str;
    }

    @Override // c04.a
    public void a(f04.a aVar) {
    }
}
