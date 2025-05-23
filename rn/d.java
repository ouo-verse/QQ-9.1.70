package rn;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import com.qzone.common.account.LoginData;
import com.qzone.reborn.qzmoment.bean.QZMPublishBean;
import com.tencent.mobileqq.winkpublish.WinkPublishHelper2;
import com.tencent.mobileqq.winkpublish.WinkPublishServiceProxy2;
import com.tencent.mobileqq.winkpublish.model.params.ImageParams;
import com.tencent.mobileqq.winkpublish.model.params.MediaParams;
import com.tencent.mobileqq.winkpublish.model.params.WinkPublishParams;
import com.tencent.qphone.base.util.QLog;
import ho.i;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

/* compiled from: P */
/* loaded from: classes36.dex */
public class d {

    /* compiled from: P */
    /* loaded from: classes36.dex */
    public interface a {
        void a(boolean z16);
    }

    private static void c(View view) {
        HashMap hashMap = new HashMap();
        hashMap.put("operator_uin", LoginData.getInstance().getUinString());
        if (view != null) {
            fo.c.b("publishing_interception", view, "em_custom_report_default_element_id", new fo.b().l(hashMap));
        } else {
            fo.c.c("publishing_interception", hashMap);
        }
    }

    public static boolean d(Context context, View view) {
        if (!com.tencent.mobileqq.service.qzone.b.s()) {
            c6.a.i(com.tencent.mobileqq.service.qzone.b.l());
            c(view);
            return false;
        }
        return ((jn.b) i.t(jn.b.class)).f(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void g(WinkPublishServiceProxy2 winkPublishServiceProxy2, QZMPublishBean qZMPublishBean, a aVar) {
        try {
            WinkPublishParams winkPublishParams = new WinkPublishParams(9, UUID.randomUUID().toString(), qZMPublishBean.mTraceId, true, 23, f(qZMPublishBean), null, null, new Bundle(), null);
            QLog.d("QZMPublish_QZMPublishHelper", 1, "sendUploadRequest add upload task,traceId:", qZMPublishBean.mTraceId);
            qZMPublishBean.mTaskId = winkPublishServiceProxy2.addTask(winkPublishParams).getTaskId();
            aVar.a(true);
        } catch (Exception e16) {
            QLog.e("QZMPublish_QZMPublishHelper", 1, "sendUploadRequest failed,traceId:", qZMPublishBean.mTraceId, ",exception:", Log.getStackTraceString(e16));
            aVar.a(false);
        }
    }

    public static void b(final QZMPublishBean qZMPublishBean, final a aVar) {
        if (qZMPublishBean == null || aVar == null) {
            return;
        }
        WinkPublishHelper2.INSTANCE.bindService(9, new WinkPublishHelper2.Callback() { // from class: rn.c
            @Override // com.tencent.mobileqq.winkpublish.WinkPublishHelper2.Callback
            public final void onServiceConnected(WinkPublishServiceProxy2 winkPublishServiceProxy2) {
                d.g(winkPublishServiceProxy2, QZMPublishBean.this, aVar);
            }
        });
    }

    private static List<? extends MediaParams> f(QZMPublishBean qZMPublishBean) {
        if (qZMPublishBean == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        ImageParams imageParams = new ImageParams(qZMPublishBean.mFrontPath, 3, 0, 0, 0L, 0, 0, new File(qZMPublishBean.mFrontPath).length(), "", null);
        ImageParams imageParams2 = new ImageParams(qZMPublishBean.mBackPath, 3, 0, 0, 0L, 0, 0, new File(qZMPublishBean.mBackPath).length(), "", null);
        arrayList.add(imageParams);
        arrayList.add(imageParams2);
        return arrayList;
    }
}
