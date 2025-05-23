package zd2;

import android.util.Pair;
import androidx.annotation.Nullable;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qcircle.api.helper.QCircleChatBoxHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.api.IRedPointUIManager;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import java.util.List;
import qqcircle.QQCircleCounter$AttachInfo;
import qqcircle.QQCircleCounter$PrivateMessage;
import uq3.c;

/* compiled from: P */
/* loaded from: classes16.dex */
public class b implements com.tencent.mobileqq.tianshu.red.request.a {
    @Override // com.tencent.mobileqq.tianshu.red.request.a
    @Nullable
    public byte[] a(int i3) {
        Pair<Integer, List<QQCircleCounter$PrivateMessage>> unReadMessages = QCircleChatBoxHelper.getInstance().getUnReadMessages();
        if (unReadMessages != null && unReadMessages.second != null) {
            QQCircleCounter$AttachInfo qQCircleCounter$AttachInfo = new QQCircleCounter$AttachInfo();
            int i16 = 1;
            if (RFWLog.isDevelopLevel()) {
                RFWLog.d("QFSRedPoint_QFSRedRequestBusinessProcessor", RFWLog.USR, "getPrivateMessageAttachInfo unReadMessages size =" + ((List) unReadMessages.second).size());
            }
            qQCircleCounter$AttachInfo.privateMsgList.set((List) unReadMessages.second);
            if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_add_main_tab_info_when_tianshu_req", true)) {
                boolean M6 = c.M6();
                PBUInt32Field pBUInt32Field = qQCircleCounter$AttachInfo.sence;
                if (!M6) {
                    i16 = 2;
                }
                pBUInt32Field.set(i16);
            }
            return qQCircleCounter$AttachInfo.toByteArray();
        }
        return new byte[0];
    }

    @Override // com.tencent.mobileqq.tianshu.red.request.a
    public boolean b(int i3) {
        return ((IRedPointUIManager) QRoute.api(IRedPointUIManager.class)).isSwitchOn();
    }

    @Override // com.tencent.mobileqq.tianshu.red.request.a
    public void onError(int i3) {
        RFWLog.e("QFSRedPoint_QFSRedRequestBusinessProcessor", RFWLog.USR, "onError:" + i3);
    }
}
