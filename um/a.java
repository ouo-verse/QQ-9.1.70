package um;

import com.qzone.common.event.ui.model.PublishEventTag;
import com.qzone.reborn.publish.bean.QZonePublishTagBean;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u000e\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u0004\u0018\u00010\u0000\u001a\u000e\u0010\u0003\u001a\u0004\u0018\u00010\u0000*\u0004\u0018\u00010\u0001\u00a8\u0006\u0004"}, d2 = {"Lcom/qzone/common/event/ui/model/PublishEventTag;", "Lcom/qzone/reborn/publish/bean/QZonePublishTagBean;", "b", "a", "qzone_df_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class a {
    public static final PublishEventTag a(QZonePublishTagBean qZonePublishTagBean) {
        if (qZonePublishTagBean == null) {
            return null;
        }
        PublishEventTag publishEventTag = new PublishEventTag();
        publishEventTag.title = qZonePublishTagBean.getTitle();
        publishEventTag.desc = qZonePublishTagBean.getDesc();
        publishEventTag.descTruncateNum = qZonePublishTagBean.getDescTruncateNum();
        publishEventTag.f45887protocol = qZonePublishTagBean.getProtocol();
        publishEventTag.picUrl = qZonePublishTagBean.getPicUrl();
        publishEventTag.f45886id = qZonePublishTagBean.getId();
        publishEventTag.uin = qZonePublishTagBean.getUin();
        publishEventTag.time = qZonePublishTagBean.getTime();
        publishEventTag.advId = qZonePublishTagBean.getAdvId();
        return publishEventTag;
    }

    public static final QZonePublishTagBean b(PublishEventTag publishEventTag) {
        if (publishEventTag == null) {
            return null;
        }
        QZonePublishTagBean qZonePublishTagBean = new QZonePublishTagBean();
        qZonePublishTagBean.r(publishEventTag.title);
        qZonePublishTagBean.l(publishEventTag.desc);
        qZonePublishTagBean.m(publishEventTag.descTruncateNum);
        qZonePublishTagBean.p(publishEventTag.f45887protocol);
        qZonePublishTagBean.o(publishEventTag.picUrl);
        qZonePublishTagBean.n(publishEventTag.f45886id);
        qZonePublishTagBean.s(publishEventTag.uin);
        qZonePublishTagBean.q(publishEventTag.time);
        qZonePublishTagBean.k(publishEventTag.advId);
        return qZonePublishTagBean;
    }
}
