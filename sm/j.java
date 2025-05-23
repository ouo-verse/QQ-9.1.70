package sm;

import android.content.Context;
import android.webkit.URLUtil;
import com.qzone.proxy.feedcomponent.model.ShuoshuoVideoInfo;
import com.qzone.publish.business.task.QZoneBaseUploadTask;
import com.qzone.publish.ui.model.MediaWrapper;
import com.qzone.util.ag;
import com.qzone.util.image.ImageInfo;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import cooperation.qzone.model.Size;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: P */
/* loaded from: classes36.dex */
public class j {
    private static MediaWrapper a(LocalMediaInfo localMediaInfo) {
        ImageInfo imageInfo;
        if (URLUtil.isNetworkUrl(localMediaInfo.path)) {
            imageInfo = new ImageInfo();
            imageInfo.mPath = localMediaInfo.path;
        } else {
            imageInfo = new ImageInfo(localMediaInfo.path);
            imageInfo.panoramaType = localMediaInfo.panoramaPhotoType;
        }
        imageInfo.photoWidth = localMediaInfo.mediaWidth;
        imageInfo.photoHeight = localMediaInfo.mediaHeight;
        return new MediaWrapper(imageInfo);
    }

    private static List<LocalMediaInfo> b(List<String> list, HashMap<String, LocalMediaInfo> hashMap, boolean z16) {
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < list.size(); i3++) {
            LocalMediaInfo localMediaInfo = hashMap.get(list.get(i3));
            if (localMediaInfo != null) {
                arrayList.add(localMediaInfo);
                if (QAlbumUtil.getMediaType(localMediaInfo) == 1) {
                    localMediaInfo.needProcess = !z16;
                }
            } else {
                LocalMediaInfo localMediaInfo2 = new LocalMediaInfo();
                localMediaInfo2.path = list.get(i3);
                arrayList.add(localMediaInfo2);
            }
        }
        return arrayList;
    }

    public static QZoneBaseUploadTask.UploadParams d(Context context, String str, List<String> list, HashMap<String, LocalMediaInfo> hashMap, boolean z16) {
        QZLog.d("upload2_QZonePublishMediaParamsUtils", 1, "fullMediaInfo");
        return e(context, str, b(list, hashMap, z16), z16);
    }

    public static QZoneBaseUploadTask.UploadParams e(Context context, String str, List<LocalMediaInfo> list, boolean z16) {
        MediaWrapper c16;
        if (list != null && list.size() != 0) {
            ArrayList arrayList = new ArrayList();
            for (LocalMediaInfo localMediaInfo : list) {
                if (QAlbumUtil.getMediaType(localMediaInfo) == 0) {
                    arrayList.add(a(localMediaInfo));
                } else if (QAlbumUtil.getMediaType(localMediaInfo) == 1 && (c16 = c(localMediaInfo, context, str)) != null) {
                    arrayList.add(c16);
                }
            }
            QZoneBaseUploadTask.UploadParams uploadParams = new QZoneBaseUploadTask.UploadParams();
            uploadParams.mediaWrapperList.addAll(arrayList);
            uploadParams.photoQuality = 0;
            return uploadParams;
        }
        QZLog.d("upload2_QZonePublishMediaParamsUtils", 1, "fullMediaUploadInfo mediaList is null");
        return new QZoneBaseUploadTask.UploadParams();
    }

    private static MediaWrapper c(LocalMediaInfo localMediaInfo, Context context, String str) {
        Size b16 = f6.b.b(localMediaInfo);
        int i3 = b16.width;
        int i16 = b16.height;
        long j3 = localMediaInfo._id;
        String str2 = localMediaInfo.path;
        long j16 = localMediaInfo.fileSize;
        String str3 = localMediaInfo.thumbnailPath;
        long j17 = localMediaInfo.mDuration;
        ShuoshuoVideoInfo p16 = ag.p(context, j3, str2, j16, 1, str3, i16, i3, 0L, j17, j17, localMediaInfo.needProcess, null);
        if (p16 == null) {
            long j18 = localMediaInfo._id;
            String str4 = localMediaInfo.path;
            long j19 = localMediaInfo.fileSize;
            String str5 = localMediaInfo.thumbnailPath;
            long j26 = localMediaInfo.mDuration;
            p16 = ag.z(context, j18, str4, j19, 1, str5, i16, i3, 0L, j26, j26, localMediaInfo.needProcess, null, false);
        }
        if (p16 == null) {
            return null;
        }
        p16.setPublishParamsType(str);
        p16.mProcessMissionID = localMediaInfo.missionID;
        MediaWrapper mediaWrapper = new MediaWrapper(p16);
        if (mediaWrapper.getVideoInfo().mNeedProcess) {
            mediaWrapper.getVideoInfo().mNeedProcess = localMediaInfo.needProcess;
            mediaWrapper.getVideoInfo().mIsOriginalVideo = !localMediaInfo.needProcess ? 1 : 0;
            mediaWrapper.getVideoInfo().mIsUploadOrigin = !localMediaInfo.needProcess;
        } else if (!localMediaInfo.needProcess) {
            mediaWrapper.getVideoInfo().mNeedProcess = false;
            mediaWrapper.getVideoInfo().mIsOriginalVideo = 1;
            mediaWrapper.getVideoInfo().mIsUploadOrigin = true;
        }
        return mediaWrapper;
    }
}
