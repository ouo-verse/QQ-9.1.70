package tm2;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.cache.api.util.ImageCacheHelper;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.richmediabrowser.AIOBrowserBaseData;
import com.tencent.mobileqq.richmediabrowser.l;
import com.tencent.mobileqq.richmediabrowser.model.AIOFilePictureData;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mtt.hippy.bridge.HippyBridge;
import java.io.File;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes18.dex */
public class b implements c04.a {
    public Drawable b(AIOFilePictureData aIOFilePictureData) {
        File c16 = c(aIOFilePictureData, 2);
        File c17 = c(aIOFilePictureData, 4);
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        Drawable drawable = com.tencent.mobileqq.urldrawable.b.f306350a;
        obtain.mLoadingDrawable = drawable;
        obtain.mFailedDrawable = drawable;
        if (c16 != null && ImageCacheHelper.f98636a.g(d(aIOFilePictureData, 2)) != null) {
            if (l.a(c16.getAbsolutePath()) != 0) {
                return null;
            }
            return URLDrawable.getDrawable(d(aIOFilePictureData, 2), obtain);
        }
        if (c17 != null && ImageCacheHelper.f98636a.g(d(aIOFilePictureData, 4)) != null) {
            if (l.a(c17.getAbsolutePath()) != 0) {
                return null;
            }
            return URLDrawable.getDrawable(d(aIOFilePictureData, 4), obtain);
        }
        if (c(aIOFilePictureData, 1) == null) {
            return null;
        }
        return URLDrawable.getDrawable(d(aIOFilePictureData, 1), obtain);
    }

    public File c(AIOFilePictureData aIOFilePictureData, int i3) {
        String str;
        if (aIOFilePictureData == null) {
            return null;
        }
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 4) {
                    str = null;
                } else {
                    str = aIOFilePictureData.f281834h;
                }
            } else {
                str = aIOFilePictureData.f281833f;
            }
        } else {
            str = aIOFilePictureData.f281832e;
        }
        if (str != null && !str.equals(AIOBrowserBaseData.MEDIA_FILE_NONE)) {
            File file = new File(str);
            if (file.exists()) {
                return file;
            }
        }
        return null;
    }

    public String d(AIOFilePictureData aIOFilePictureData, int i3) {
        String str;
        if (aIOFilePictureData == null) {
            return null;
        }
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 4) {
                    str = null;
                } else {
                    str = aIOFilePictureData.f281834h;
                }
            } else {
                str = aIOFilePictureData.f281833f;
            }
        } else {
            str = aIOFilePictureData.f281832e;
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

    public boolean e(AIOFilePictureData aIOFilePictureData, int i3) {
        if (aIOFilePictureData == null) {
            return false;
        }
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 4) {
                    return false;
                }
                return true;
            }
            return !aIOFilePictureData.f281833f.equals(AIOBrowserBaseData.MEDIA_FILE_NONE);
        }
        return !aIOFilePictureData.f281832e.equals(AIOBrowserBaseData.MEDIA_FILE_NONE);
    }

    public void f(AIOFilePictureData aIOFilePictureData, int i3, String str) {
        String str2 = "";
        int i16 = 0;
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ERROR_TYPE)) {
                    str2 = jSONObject.getString(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ERROR_TYPE);
                }
                if (jSONObject.has("errorCode")) {
                    i16 = jSONObject.getInt("errorCode");
                }
            } catch (Exception unused) {
            }
        }
        if (i3 == 2) {
            if (str2 != null && str2.equals("thumb_download")) {
                aIOFilePictureData.M = i16;
                return;
            }
            return;
        }
        if (i3 == 1 && str2 != null && str2.equals("thumb_download")) {
            aIOFilePictureData.M = i16;
        }
    }

    public void g(AIOFilePictureData aIOFilePictureData, int i3, String str) {
        if (aIOFilePictureData != null && str != null) {
            if (AIOBrowserBaseData.MEDIA_FILE_ERROR.equals(str)) {
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 == 4) {
                            aIOFilePictureData.C = true;
                            return;
                        }
                        return;
                    }
                    aIOFilePictureData.f281836m = true;
                    return;
                }
                aIOFilePictureData.D = true;
                return;
            }
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 4) {
                        aIOFilePictureData.f281834h = str;
                        return;
                    }
                    return;
                }
                aIOFilePictureData.f281833f = str;
                return;
            }
            aIOFilePictureData.f281832e = str;
        }
    }

    @Override // c04.a
    public void a(f04.a aVar) {
    }
}
