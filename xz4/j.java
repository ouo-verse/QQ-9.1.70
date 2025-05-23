package xz4;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.xingin.xhssharesdk.XhsShareSdkTools;
import com.xingin.xhssharesdk.core.XhsShareSdk;
import com.xingin.xhssharesdk.model.sharedata.XhsImageInfo;
import com.xingin.xhssharesdk.model.sharedata.XhsImageResourceBean;
import com.xingin.xhssharesdk.model.sharedata.XhsNote;
import com.xingin.xhssharesdk.model.sharedata.XhsShareDeeplinkData;
import com.xingin.xhssharesdk.model.sharedata.XhsVideoInfo;
import com.xingin.xhssharesdk.model.sharedata.XhsVideoResourceBean;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class j {
    public static Uri a(Context context, @NonNull XhsNote xhsNote, @NonNull String str, long j3) {
        XhsShareDeeplinkData xhsShareDeeplinkData = new XhsShareDeeplinkData();
        xhsShareDeeplinkData.noteInfo = xhsNote;
        xhsShareDeeplinkData.shareType = "note";
        xhsShareDeeplinkData.sdkVersion = XhsShareSdkTools.getSdkVersion();
        xhsShareDeeplinkData.thirdAppPackage = XhsShareSdkTools.getCurrentAppPackageName(context);
        try {
            xhsShareDeeplinkData.thirdAppVersion = XhsShareSdkTools.getCurrentAppVersionName(context);
        } catch (PackageManager.NameNotFoundException unused) {
        }
        xhsShareDeeplinkData.shareSessionId = str;
        xhsShareDeeplinkData.startShareTimestamp = j3;
        xhsShareDeeplinkData.did = XhsShareSdkTools.getDid(context);
        return Uri.parse("xhsdiscover://share_sdk").buildUpon().appendQueryParameter("data", Base64.encodeToString(xhsShareDeeplinkData.toJson().toString().getBytes(StandardCharsets.UTF_8), 2)).build();
    }

    @WorkerThread
    public static XhsImageResourceBean b(Context context, String str, @NonNull XhsImageResourceBean xhsImageResourceBean, @NonNull String str2) {
        File createTempFile = XhsShareSdkTools.createTempFile(str2);
        if (!TextUtils.isEmpty(xhsImageResourceBean.getNetworkUrl())) {
            return xhsImageResourceBean;
        }
        if (xhsImageResourceBean.getUri() != null) {
            XhsShareSdkTools.copyFile(context, xhsImageResourceBean.getUri(), createTempFile);
            Uri convertAvailableUri = XhsShareSdkTools.convertAvailableUri(context, str, createTempFile);
            if (convertAvailableUri != null) {
                return new XhsImageResourceBean(convertAvailableUri);
            }
            throw new com.xingin.xhssharesdk.l.a(5, "[processImageResource] ConvertAvailableUri error. Path is " + createTempFile.getPath());
        }
        throw new com.xingin.xhssharesdk.l.a(4, "[processImageResource] The imageResource is invalid!");
    }

    @WorkerThread
    public static XhsNote c(Context context, String str, @NonNull XhsNote xhsNote, @NonNull String str2) {
        XhsImageResourceBean xhsImageResourceBean;
        Uri convertAvailableUri;
        if (xhsNote.getImageInfo() != null && xhsNote.getImageInfo().isValid()) {
            ArrayList arrayList = new ArrayList();
            for (XhsImageResourceBean xhsImageResourceBean2 : xhsNote.getImageInfo().getImageResourceList()) {
                if (xhsImageResourceBean2.isValid()) {
                    arrayList.add(b(context, str, xhsImageResourceBean2, str2));
                }
            }
            return new XhsNote().setTitle(xhsNote.getTitle()).setContent(xhsNote.getContent()).setImageInfo(new XhsImageInfo(arrayList));
        }
        if (xhsNote.getVideoInfo() != null) {
            XhsImageResourceBean cover = xhsNote.getVideoInfo().getCover();
            if (cover != null && cover.isValid()) {
                xhsImageResourceBean = b(context, str, cover, str2);
            } else {
                xhsImageResourceBean = null;
            }
            XhsVideoResourceBean video = xhsNote.getVideoInfo().getVideo();
            if (TextUtils.isEmpty(video.getNetworkUrl())) {
                if (video.getUri() != null) {
                    long fileLength = XhsShareSdkTools.getFileLength(context, video.getUri());
                    XhsShareSdk.b("XhsShare_XhsShareDataProcessor", "The video file length is " + fileLength);
                    if (fileLength >= 0 && fileLength < 5242880) {
                        File createTempFile = XhsShareSdkTools.createTempFile(str2);
                        XhsShareSdkTools.copyFile(context, video.getUri(), createTempFile);
                        convertAvailableUri = XhsShareSdkTools.convertAvailableUri(context, str, createTempFile);
                        if (convertAvailableUri == null) {
                            throw new com.xingin.xhssharesdk.l.a(5, "[processVideoResource] ConvertAvailableUri error. (with copy)");
                        }
                    } else {
                        Uri uri = video.getUri();
                        if (TextUtils.equals(uri.getScheme(), "content")) {
                            XhsShareSdkTools.grantUriPermission(context, uri);
                            XhsShareSdk.b("XhsShare_XhsShareDataProcessor", "Real uri, it is " + uri);
                            convertAvailableUri = uri;
                        } else {
                            convertAvailableUri = XhsShareSdkTools.convertAvailableUri(context, str, new File(uri.getPath()));
                            XhsShareSdk.b("XhsShare_XhsShareDataProcessor", "Fake uri, it is " + uri);
                        }
                        if (convertAvailableUri == null) {
                            throw new com.xingin.xhssharesdk.l.a(5, "[processVideoResource] ConvertAvailableUri error. (without copy)");
                        }
                    }
                    video = new XhsVideoResourceBean(convertAvailableUri);
                } else {
                    throw new com.xingin.xhssharesdk.l.a(6, "[processVideoResource] The videoResource is invalid!");
                }
            }
            return new XhsNote().setTitle(xhsNote.getTitle()).setContent(xhsNote.getContent()).setVideoInfo(new XhsVideoInfo(video, xhsImageResourceBean));
        }
        throw new com.xingin.xhssharesdk.l.a(7, "[process] The note is invalid!");
    }

    public static boolean d(@NonNull XhsNote xhsNote) {
        boolean z16 = false;
        if (xhsNote.getImageInfo() != null && xhsNote.getImageInfo().isValid()) {
            Iterator<XhsImageResourceBean> it = xhsNote.getImageInfo().getImageResourceList().iterator();
            while (it.hasNext()) {
                if (it.next().isValid()) {
                    z16 = true;
                }
            }
            return z16;
        }
        if (xhsNote.getVideoInfo() == null) {
            return false;
        }
        return xhsNote.getVideoInfo().getVideo().isValid();
    }
}
