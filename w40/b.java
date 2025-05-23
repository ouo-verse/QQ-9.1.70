package w40;

import android.app.Activity;
import android.text.TextUtils;
import com.tencent.biz.qqcircle.beans.QCircleLayerBean;
import com.tencent.biz.qqcircle.immersive.part.u;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.event.QZoneVideoRetryPlayEvent;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes4.dex */
public class b extends u {

    /* renamed from: d, reason: collision with root package name */
    private final QCircleLayerBean f444560d;

    public b(QCircleLayerBean qCircleLayerBean) {
        this.f444560d = qCircleLayerBean;
    }

    private String x9(QCircleLayerBean qCircleLayerBean) {
        HashMap<String, String> schemeAttrs = qCircleLayerBean.getSchemeAttrs();
        if (schemeAttrs != null) {
            return schemeAttrs.get(QZoneVideoRetryPlayEvent.CLICK_VIEW_HASH_CODE);
        }
        return "";
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.u, com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(String str, Object obj) {
        super.handleBroadcastMessage(str, obj);
        if (TextUtils.equals(str, "MSG_FEED_NOT_EXIST")) {
            String x95 = x9(this.f444560d);
            QLog.d(getLogTag(), 1, "handleBroadcastMessage feed not exist;feedID:" + this.f444560d.getQQVideoBusinessFeedID() + ",clickViewHashCode:" + x95);
            if (!TextUtils.isEmpty(x95)) {
                SimpleEventBus.getInstance().dispatchEvent(new QZoneVideoRetryPlayEvent(this.f444560d.getQQVideoBusinessFeedID(), x95));
                Activity activity = getActivity();
                if (activity != null) {
                    activity.finish();
                }
            }
        }
    }
}
