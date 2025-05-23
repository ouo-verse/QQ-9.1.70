package tm2;

import android.graphics.drawable.Drawable;
import com.tencent.cache.api.util.ImageCacheHelper;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.richmediabrowser.AIOBrowserBaseData;
import com.tencent.mobileqq.richmediabrowser.model.AIOPictureData;
import com.tencent.mtt.hippy.bridge.HippyBridge;
import com.tencent.richmediabrowser.model.pic.PictureModel;
import java.io.File;
import java.net.MalformedURLException;

/* compiled from: P */
/* loaded from: classes18.dex */
public class d implements c04.a {

    /* renamed from: a, reason: collision with root package name */
    private PictureModel f436606a;

    @Override // c04.a
    public void a(f04.a aVar) {
        if (aVar instanceof PictureModel) {
            this.f436606a = (PictureModel) aVar;
        }
    }

    public Drawable b(AIOPictureData aIOPictureData) {
        File c16 = c(aIOPictureData, 2);
        File c17 = c(aIOPictureData, 4);
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        Drawable drawable = com.tencent.mobileqq.urldrawable.b.f306350a;
        obtain.mLoadingDrawable = drawable;
        obtain.mFailedDrawable = drawable;
        if (c16 != null && ImageCacheHelper.f98636a.g(e(aIOPictureData, 2)) != null) {
            return URLDrawable.getDrawable(e(aIOPictureData, 2), obtain);
        }
        if (c17 != null && ImageCacheHelper.f98636a.g(e(aIOPictureData, 4)) != null) {
            return URLDrawable.getDrawable(e(aIOPictureData, 4), obtain);
        }
        if (c(aIOPictureData, 1) != null) {
            URLDrawable drawable2 = URLDrawable.getDrawable(e(aIOPictureData, 1), obtain);
            drawable2.downloadImediatly();
            return drawable2;
        }
        return null;
    }

    public File c(AIOPictureData aIOPictureData, int i3) {
        String str;
        if (aIOPictureData == null) {
            return null;
        }
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 4) {
                    if (i3 != 8) {
                        str = null;
                    } else {
                        str = aIOPictureData.mDisplayFile;
                    }
                } else {
                    str = aIOPictureData.originImageFile;
                }
            } else {
                str = aIOPictureData.largeImageFile;
            }
        } else {
            str = aIOPictureData.thumbImageFile;
        }
        if (str != null && !str.equals(AIOBrowserBaseData.MEDIA_FILE_NONE)) {
            File file = new File(str);
            if (file.exists()) {
                return file;
            }
        }
        return null;
    }

    public int d(AIOPictureData aIOPictureData, String str) {
        if (str == null || aIOPictureData == null) {
            return 0;
        }
        String str2 = aIOPictureData.thumbImageFile;
        if (str2 != null && str.contains(str2)) {
            return 1;
        }
        String str3 = aIOPictureData.largeImageFile;
        if (str3 != null && str.contains(str3)) {
            return 2;
        }
        String str4 = aIOPictureData.originImageFile;
        if (str4 == null || !str.contains(str4)) {
            return 0;
        }
        return 4;
    }

    public String e(AIOPictureData aIOPictureData, int i3) {
        String str;
        if (aIOPictureData == null) {
            return "";
        }
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 4) {
                    if (i3 != 8) {
                        str = null;
                    } else {
                        str = aIOPictureData.mDisplayFile;
                    }
                } else {
                    str = aIOPictureData.originImageFile;
                }
            } else {
                str = aIOPictureData.largeImageFile;
            }
        } else {
            str = aIOPictureData.thumbImageFile;
        }
        if (str != null && !str.equals(AIOBrowserBaseData.MEDIA_FILE_NONE)) {
            if (aIOPictureData.mBusinessType == 3) {
                try {
                    return new File(str).toURI().toURL().toString();
                } catch (MalformedURLException e16) {
                    e16.printStackTrace();
                }
            } else {
                if (!str.startsWith("/")) {
                    return "file:/" + str;
                }
                if (str.startsWith("//")) {
                    return HippyBridge.URI_SCHEME_FILE + str;
                }
                return HippyBridge.URI_SCHEME_FILE + str;
            }
        }
        return null;
    }

    public boolean f(AIOPictureData aIOPictureData, int i3) {
        if (aIOPictureData == null) {
            return false;
        }
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 4) {
                    return false;
                }
                if (aIOPictureData.mBusinessType == 3) {
                    return true;
                }
                return !aIOPictureData.originImageFile.equals(AIOBrowserBaseData.MEDIA_FILE_NONE);
            }
            return !aIOPictureData.largeImageFile.equals(AIOBrowserBaseData.MEDIA_FILE_NONE);
        }
        return !aIOPictureData.thumbImageFile.equals(AIOBrowserBaseData.MEDIA_FILE_NONE);
    }

    public void g(AIOPictureData aIOPictureData, int i3, String str, String str2) {
        if (AIOBrowserBaseData.MEDIA_FILE_ERROR.equals(str)) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 4) {
                        aIOPictureData.mOriginError = true;
                        return;
                    }
                    return;
                } else {
                    aIOPictureData.mLargeError = true;
                    aIOPictureData.mLargeErrorDesc = str2;
                    return;
                }
            }
            aIOPictureData.mThumbError = true;
            return;
        }
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 4) {
                    if (i3 == 8) {
                        aIOPictureData.mDisplayFile = str;
                        return;
                    }
                    return;
                }
                aIOPictureData.originImageFile = str;
                return;
            }
            aIOPictureData.largeImageFile = str;
            if (!aIOPictureData.isPicFile) {
                if (new File(aIOPictureData.thumbImageFile + "_hd").exists()) {
                    aIOPictureData.thumbImageFile += "_hd";
                    return;
                }
                return;
            }
            return;
        }
        aIOPictureData.thumbImageFile = str;
    }
}
