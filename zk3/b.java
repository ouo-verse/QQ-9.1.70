package zk3;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.zplan.video.api.bean.TXVideoInfo;
import com.tencent.mobileqq.zplan.video.api.bean.VideoMediaInfo;
import com.tencent.mobileqq.zplan.video.api.bean.VideoPlayInfo;
import java.util.List;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u0005H&J\u001a\u0010\f\u001a\u0004\u0018\u00010\u00032\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH&J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\bH&J\u0010\u0010\u0010\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0003H&J\b\u0010\u0011\u001a\u00020\rH&\u00a8\u0006\u0012"}, d2 = {"Lzk3/b;", "", "", "Lcom/tencent/mobileqq/zplan/video/api/bean/b;", "a", "Lcom/tencent/mobileqq/zplan/video/api/bean/e;", "playInfo", "e", "", "componentId", "Lcom/tencent/mobileqq/zplan/video/api/bean/c;", "mediaInfo", "b", "", "c", QCircleScheme.AttrDetail.VIDEO_INFO, "d", "f", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public interface b {
    List<TXVideoInfo> a();

    TXVideoInfo b(String componentId, VideoMediaInfo mediaInfo);

    void c(String componentId);

    void d(TXVideoInfo videoInfo);

    TXVideoInfo e(VideoPlayInfo playInfo);

    void f();
}
