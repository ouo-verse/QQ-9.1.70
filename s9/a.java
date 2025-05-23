package s9;

import android.text.TextUtils;
import com.qzone.common.business.service.QZoneWriteOperationService;
import com.qzone.publish.business.protocol.QZonePublishMoodRequest;
import com.qzone.publish.ui.model.c;
import com.qzone.reborn.albumx.common.bean.CommonPublishMoodBean;
import com.qzone.reborn.base.k;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.report.lp.LpReportManager;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0007\u0018\u0000 \r2\u00020\u0001:\u0001\u000eB\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u001c\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000f"}, d2 = {"Ls9/a;", "Lcom/qzone/reborn/base/k;", "Lcom/qzone/reborn/albumx/common/bean/f;", "bean", "", "C9", "", "action", "", "args", "handleBroadcastMessage", "<init>", "()V", "d", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class a extends k {
    @Override // com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(String action, Object args) {
        super.handleBroadcastMessage(action, args);
        if (TextUtils.equals(action, "SILENT_PUBLISH_PIC_MOOD")) {
            C9(args instanceof CommonPublishMoodBean ? (CommonPublishMoodBean) args : null);
        }
    }

    private final void C9(CommonPublishMoodBean bean) {
        if (TextUtils.isEmpty(bean != null ? bean.getFilePath() : null)) {
            QLog.e("CommonPublishMoodPart", 1, "[handlePublishPicMood] file path is empty");
            return;
        }
        Intrinsics.checkNotNull(bean);
        String filePath = bean.getFilePath();
        QLog.i("CommonPublishMoodPart", 2, "start publish pic mood, file path is " + filePath);
        c cVar = new c();
        cVar.f51934b = "";
        cVar.f51945g0 = bean.getInfo().reserves3;
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("is_feeds_long_pics_browsing_mode", "0");
        cVar.E = hashMap;
        cVar.f51954p = hashMap;
        HashMap hashMap2 = new HashMap();
        hashMap2.put(QZonePublishMoodRequest.KEY_APPID_FOR_CLIENT_FAKE_FEED, "311");
        hashMap2.put(QZonePublishMoodRequest.IS_INTEGRATION_VIDEO, "0");
        cVar.f51935b0 = hashMap2;
        cVar.f51956r = 2;
        cVar.f51959u = 1;
        cVar.I = "shuoshuoOther";
        cVar.H = 2;
        LocalMediaInfo localMediaInfo = new LocalMediaInfo();
        localMediaInfo.path = filePath;
        ArrayList arrayList = new ArrayList();
        arrayList.add(localMediaInfo);
        cVar.f51940e = arrayList;
        ArrayList<String> arrayList2 = new ArrayList<>();
        arrayList2.add(filePath);
        cVar.f51936c = arrayList2;
        cVar.P = arrayList2;
        LpReportManager.getInstance().reportToPF00064(bean.getInfo(), false, false);
        QZoneWriteOperationService.v0().O1(cVar);
    }
}
