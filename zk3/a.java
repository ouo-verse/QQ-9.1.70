package zk3;

import androidx.exifinterface.media.ExifInterface;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.zplan.video.api.bean.TXVideoInfo;
import com.tencent.mobileqq.zplan.video.api.bean.UpdateFrom;
import com.tencent.mobileqq.zplan.video.api.bean.VideoMediaInfo;
import com.tencent.mobileqq.zplan.video.api.bean.VideoParamInfo;
import com.tencent.mobileqq.zplan.video.api.bean.VideoPlayInfo;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J \u0010\u000e\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH&J\b\u0010\u0010\u001a\u00020\u000fH&J\b\u0010\u0011\u001a\u00020\u0004H&J\b\u0010\u0013\u001a\u00020\u0012H&J\u0010\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0014H&\u00a8\u0006\u0017"}, d2 = {"Lzk3/a;", "Lvb3/b;", "Lcom/tencent/mobileqq/zplan/video/api/bean/e;", "playInfo", "", "I0", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "L", "Lcom/tencent/mobileqq/zplan/video/api/bean/UpdateFrom;", "from", "", "componentId", "Lcom/tencent/mobileqq/zplan/video/api/bean/c;", "mediaInfo", "B0", "Lzk3/b;", "J0", "b", "Lcom/tencent/mobileqq/zplan/video/api/bean/d;", "a0", "Lcom/tencent/mobileqq/zplan/video/api/bean/b;", QCircleScheme.AttrDetail.VIDEO_INFO, "D0", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public interface a extends vb3.b {
    void A(VideoPlayInfo playInfo);

    void B0(UpdateFrom from, String componentId, VideoMediaInfo mediaInfo);

    void D0(TXVideoInfo videoInfo);

    void I0(VideoPlayInfo playInfo);

    b J0();

    void L(VideoPlayInfo playInfo);

    VideoParamInfo a0();

    void b();
}
