package zn;

import a9.f;
import com.qzone.publish.business.task.IQueueTask;
import com.qzone.reborn.repair.bean.QZonePhotoRepairSyncStatusEvent;
import com.qzone.reborn.repair.bean.QZonePhotoUploadStatusEvent;
import com.qzone.reborn.repair.bean.QZoneRepairTaskStateBean;
import com.qzone.reborn.repair.request.QZoneRepairUpdateResultRequest;
import com.qzone.util.l;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.util.QQToastUtil;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import qzone.SuperResolution$UpdateResultRsp;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001a2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u001bB\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u00a2\u0006\u0004\b\u0018\u0010\u0019J#\u0010\t\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\b\u0010\u000b\u001a\u00020\bH\u0016J\u0012\u0010\u000e\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\u0012\u0010\u0010\u001a\u00020\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003H\u0016J\u0014\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00120\u0011H\u0016R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001c"}, d2 = {"Lzn/c;", "Lcom/qzone/publish/business/publishqueue/b;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "photoSource", "", "state", "", "c", "(Ljava/lang/String;Ljava/lang/Integer;)V", "onQueueChanged", "Lcom/qzone/publish/business/task/IQueueTask;", "task", "H", "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "getEventClass", "Lcom/qzone/reborn/repair/bean/QZoneRepairTaskStateBean;", "d", "Lcom/qzone/reborn/repair/bean/QZoneRepairTaskStateBean;", "taskBean", "<init>", "(Lcom/qzone/reborn/repair/bean/QZoneRepairTaskStateBean;)V", "e", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class c implements com.qzone.publish.business.publishqueue.b, SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final QZoneRepairTaskStateBean taskBean;

    public c(QZoneRepairTaskStateBean taskBean) {
        Intrinsics.checkNotNullParameter(taskBean, "taskBean");
        this.taskBean = taskBean;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(c this$0, BaseRequest baseRequest, boolean z16, long j3, String str, SuperResolution$UpdateResultRsp superResolution$UpdateResultRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i("QZonePhotoRepairUploadListener", 1, "updateResultRequest task=" + this$0.taskBean + ", retCode=" + j3 + ", errMsg=" + str);
        RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: zn.b
            @Override // java.lang.Runnable
            public final void run() {
                c.e();
            }
        });
        SimpleEventBus.getInstance().dispatchEvent(new QZonePhotoRepairSyncStatusEvent(this$0.taskBean.getTaskId(), 2, Long.valueOf(System.currentTimeMillis())));
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent event) {
        if (event instanceof QZonePhotoUploadStatusEvent) {
            QZonePhotoUploadStatusEvent qZonePhotoUploadStatusEvent = (QZonePhotoUploadStatusEvent) event;
            QLog.i("QZonePhotoRepairUploadListener", 1, "onReceiveEvent upload pic, state=" + qZonePhotoUploadStatusEvent.getState() + ", photoSource=" + qZonePhotoUploadStatusEvent.getPhotoSource());
            c(qZonePhotoUploadStatusEvent.getPhotoSource(), Integer.valueOf(qZonePhotoUploadStatusEvent.getState()));
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(QZonePhotoUploadStatusEvent.class);
        return arrayListOf;
    }

    private final void c(String photoSource, Integer state) {
        boolean z16 = false;
        if (photoSource != null) {
            if (photoSource.length() == 0) {
                z16 = true;
            }
        }
        if (!z16 && Intrinsics.areEqual(photoSource, this.taskBean.getSrUrl()) && state != null && state.intValue() == 3) {
            VSNetworkHelper.getInstance().sendRequest(new QZoneRepairUpdateResultRequest(this.taskBean.getTaskId(), 0L, 2), new VSDispatchObserver.OnVSRspCallBack() { // from class: zn.a
                @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
                public final void onReceive(BaseRequest baseRequest, boolean z17, long j3, String str, Object obj) {
                    c.d(c.this, baseRequest, z17, j3, str, (SuperResolution$UpdateResultRsp) obj);
                }
            });
            if (lc.b.d()) {
                f.f25725a.c().M(this);
            } else {
                SimpleEventBus.getInstance().unRegisterReceiver(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e() {
        QQToastUtil.showQQToast(2, l.a(R.string.wao));
    }

    @Override // com.qzone.publish.business.publishqueue.b
    public void H(IQueueTask task) {
        QLog.i("QZonePhotoRepairUploadListener", 1, "onProgressChanged upload pic, state=" + (task != null ? Integer.valueOf(task.getState()) : null) + ", info()=" + (task != null ? task.getInfo() : null));
        c(task != null ? task.getPhotoSource() : null, task != null ? Integer.valueOf(task.getState()) : null);
    }

    @Override // com.qzone.publish.business.publishqueue.b
    public void onQueueChanged() {
    }
}
