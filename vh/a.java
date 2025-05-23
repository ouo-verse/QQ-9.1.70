package vh;

import com.qzone.reborn.albumx.common.convert.bean.CommonStMedia;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReportParams;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\b\u00a2\u0006\u0004\b\f\u0010\rR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\u000b\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\t\u001a\u0004\b\u0003\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lvh/a;", "", "", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "timeId", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStMedia;", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStMedia;", "()Lcom/qzone/reborn/albumx/common/convert/bean/CommonStMedia;", QAdVrReportParams.ParamKey.MEDIA, "<init>", "(Ljava/lang/String;Lcom/qzone/reborn/albumx/common/convert/bean/CommonStMedia;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String timeId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final CommonStMedia media;

    public a(String timeId, CommonStMedia media) {
        Intrinsics.checkNotNullParameter(timeId, "timeId");
        Intrinsics.checkNotNullParameter(media, "media");
        this.timeId = timeId;
        this.media = media;
    }

    /* renamed from: a, reason: from getter */
    public final CommonStMedia getMedia() {
        return this.media;
    }

    /* renamed from: b, reason: from getter */
    public final String getTimeId() {
        return this.timeId;
    }
}
