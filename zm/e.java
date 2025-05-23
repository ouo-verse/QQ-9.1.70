package zm;

import com.qzone.proxy.feedcomponent.model.ShuoshuoVideoInfo;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0018\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u001a\u0010\u000b\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00022\b\u0010\n\u001a\u0004\u0018\u00010\tJ\u001a\u0010\r\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\t\u00a8\u0006\u0010"}, d2 = {"Lzm/e;", "", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "info", "", "isUseQQVideoExportConfig", "", "c", "mediaInfo", "Lcom/qzone/proxy/feedcomponent/model/ShuoshuoVideoInfo;", QCircleScheme.AttrDetail.VIDEO_INFO, "b", "otherVideoInfo", "a", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public static final e f452772a = new e();

    e() {
    }

    public final boolean a(ShuoshuoVideoInfo videoInfo, ShuoshuoVideoInfo otherVideoInfo) {
        if (videoInfo != null && otherVideoInfo != null) {
            String publishParamsType = videoInfo.getPublishParamsType();
            String publishParamsType2 = otherVideoInfo.getPublishParamsType();
            QLog.d("QZQQVideoExportUtil", 1, "isSameExportTaskType, publishParamsType:" + publishParamsType + ", otherPublishParamsType:" + publishParamsType2);
            return Intrinsics.areEqual(publishParamsType, publishParamsType2);
        }
        QLog.d("QZQQVideoExportUtil", 1, "isSameExportTaskType, videoInfo or otherVideoInfo is null");
        return false;
    }

    public final void c(LocalMediaInfo info, boolean isUseQQVideoExportConfig) {
        if (info == null) {
            return;
        }
        if (info.extData == null) {
            info.extData = new HashMap<>();
        }
        HashMap<String, Serializable> hashMap = info.extData;
        Intrinsics.checkNotNullExpressionValue(hashMap, "info.extData");
        hashMap.put("key_use_qqvideo_export_config", Boolean.valueOf(isUseQQVideoExportConfig));
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0037, code lost:
    
        if (r3 != false) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void b(LocalMediaInfo mediaInfo, ShuoshuoVideoInfo videoInfo) {
        String str;
        boolean isBlank;
        if (mediaInfo == null || videoInfo == null) {
            return;
        }
        HashMap<String, Serializable> hashMap = mediaInfo.extData;
        Serializable serializable = hashMap != null ? hashMap.get("key_use_qqvideo_export_config") : null;
        Boolean bool = serializable instanceof Boolean ? (Boolean) serializable : null;
        boolean z16 = false;
        if (bool != null ? bool.booleanValue() : false) {
            str = "MOOD_QQVIDEO_SINGLE_VIDEO";
        } else {
            String publishParamsType = videoInfo.getPublishParamsType();
            if (publishParamsType != null) {
                isBlank = StringsKt__StringsJVMKt.isBlank(publishParamsType);
            }
            z16 = true;
            String str2 = z16 ^ true ? publishParamsType : null;
            str = str2 == null ? "MOOD_NORMAL_VIDEO" : str2;
        }
        videoInfo.setPublishParamsType(str);
    }
}
