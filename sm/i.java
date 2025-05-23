package sm;

import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.publish.business.publishqueue.common.CommonPublishVideoStatusInfo;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH&J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\r"}, d2 = {"Lsm/i;", "", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "data", "", "i7", "", "clientKey", "Lcom/qzone/publish/business/publishqueue/common/g;", "videoStatusInfo", "z5", "v1", "I4", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public interface i {
    void I4(BusinessFeedData data);

    void i7(BusinessFeedData data);

    void v1(String clientKey);

    void z5(String clientKey, CommonPublishVideoStatusInfo videoStatusInfo);
}
