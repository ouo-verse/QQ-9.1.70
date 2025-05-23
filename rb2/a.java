package rb2;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.intervideo.now.dynamic.b;
import com.tencent.mobileqq.now.enter.pb.NowPushMsgList$NowPushMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.Manager;

/* compiled from: P */
/* loaded from: classes9.dex */
public class a implements Manager {

    /* renamed from: d, reason: collision with root package name */
    private QQAppInterface f431021d;

    public a(QQAppInterface qQAppInterface) {
        this.f431021d = qQAppInterface;
    }

    private void a(NowPushMsgList$NowPushMsg nowPushMsgList$NowPushMsg) {
        b(nowPushMsgList$NowPushMsg);
    }

    private boolean b(NowPushMsgList$NowPushMsg nowPushMsgList$NowPushMsg) {
        if (nowPushMsgList$NowPushMsg.uint32_version.get() == 0 && nowPushMsgList$NowPushMsg.uint64_start_time.get() == 0 && nowPushMsgList$NowPushMsg.uint64_end_time.get() == 0) {
            if (QLog.isColorLevel()) {
                QLog.i("NowHongbaoPushManager", 2, "\u53d1\u9001wns\u65e5\u5fd7\u8bf7\u6c42");
            }
            ((b) this.f431021d.getManager(QQManagerFactory.NOW_DYNAMIC_MANAGER)).f();
            return true;
        }
        return false;
    }

    public void c(NowPushMsgList$NowPushMsg nowPushMsgList$NowPushMsg) {
        QLog.i("NowHongbaoPushManager", 1, "receiveOfflinePush \uff1a type=" + nowPushMsgList$NowPushMsg.uint32_type.get() + ", show=" + nowPushMsgList$NowPushMsg.uint32_switch.get() + ", startTime=" + nowPushMsgList$NowPushMsg.uint64_start_time.get() + ", endTime=" + nowPushMsgList$NowPushMsg.uint64_end_time.get() + ",taskId =" + nowPushMsgList$NowPushMsg.uint32_task_id.get() + ",version =" + nowPushMsgList$NowPushMsg.uint32_version.get());
        a(nowPushMsgList$NowPushMsg);
    }

    public void d(NowPushMsgList$NowPushMsg nowPushMsgList$NowPushMsg) {
        QLog.i("NowHongbaoPushManager", 1, "receiveOnLinePush \uff1a type=" + nowPushMsgList$NowPushMsg.uint32_type.get() + ", show=" + nowPushMsgList$NowPushMsg.uint32_switch.get() + ", startTime=" + nowPushMsgList$NowPushMsg.uint64_start_time.get() + ", endTime=" + nowPushMsgList$NowPushMsg.uint64_end_time.get() + ",taskId =" + nowPushMsgList$NowPushMsg.uint32_task_id.get() + ",version =" + nowPushMsgList$NowPushMsg.uint32_version.get());
        a(nowPushMsgList$NowPushMsg);
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
    }
}
