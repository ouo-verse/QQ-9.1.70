package xm;

import com.qzone.common.business.service.QZoneWriteOperationService;
import com.qzone.proxy.feedcomponent.model.User;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qcircle.api.qqvideo.data.QCircleFeedOperateFakeSyncExternalInfo;
import com.tencent.mobileqq.qcircle.api.qqvideo.event.QCircleFeedJSPermissionChangeEvent;
import com.tencent.mobileqq.qcircle.api.qqvideo.event.QCircleFeedOperateFakeSyncExternalEvent;
import common.config.service.QZoneConfigHelper;
import cooperation.qzone.util.QZLog;
import ef.d;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007H\u0002J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\rH\u0002J\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\rH\u0002J\u0010\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\rH\u0002J\u0010\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\rH\u0002J\u0010\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\rH\u0002J\u0010\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\rH\u0002J\u0010\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\rH\u0002J\u0010\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\rH\u0002J\u0010\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\rH\u0002J\u0006\u0010\u0017\u001a\u00020\u0005J\u0012\u0010\u0018\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016J\u0014\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u001a0\u0019H\u0016R\u0016\u0010\u001e\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u001d\u00a8\u0006!"}, d2 = {"Lxm/a;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Lcom/tencent/mobileqq/qcircle/api/qqvideo/event/QCircleFeedJSPermissionChangeEvent;", "event", "", "k", "", "qqVideoFeedRight", "a", "qzoneType", "", "b", "Lcom/tencent/mobileqq/qcircle/api/qqvideo/event/QCircleFeedOperateFakeSyncExternalEvent;", "j", "i", "e", "l", h.F, "c", "f", "d", "g", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "getEventClass", "", "Z", "mHasRegister", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class a implements SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: d, reason: collision with root package name */
    public static final a f448133d = new a();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static boolean mHasRegister;

    a() {
    }

    private final int a(int qqVideoFeedRight) {
        if (qqVideoFeedRight == 1) {
            return 1;
        }
        if (qqVideoFeedRight != 2) {
            if (qqVideoFeedRight == 3) {
                return 6;
            }
            if (qqVideoFeedRight == 5) {
                return 3;
            }
            if (qqVideoFeedRight != 6) {
                return 1;
            }
            return 8;
        }
        return 4;
    }

    private final void c(QCircleFeedOperateFakeSyncExternalEvent event) {
        QZLog.d("QZoneFeedxSyncQCircleFeedOperateManager", 1, "[handleAddComment] " + event.getOperateSyncInfo());
        if (!(event.getOperateSyncInfo().getUgcKey().length() == 0)) {
            if (!(event.getOperateSyncInfo().getCommentId().length() == 0)) {
                if (!(event.getOperateSyncInfo().getContent().length() == 0)) {
                    QZoneWriteOperationService.l lVar = new QZoneWriteOperationService.l();
                    lVar.f45708a = event.getOperateSyncInfo().getUgcKey();
                    lVar.f45710c = event.getOperateSyncInfo().getCommentId();
                    lVar.f45709b = event.getOperateSyncInfo().getFeedId();
                    lVar.f45715h = event.getOperateSyncInfo().getContent();
                    QZoneWriteOperationService.v0().F1(lVar);
                    return;
                }
            }
        }
        QZLog.e("QZoneFeedxSyncQCircleFeedOperateManager", 1, "[handleAddComment] sync info is error");
    }

    private final void d(QCircleFeedOperateFakeSyncExternalEvent event) {
        QZLog.d("QZoneFeedxSyncQCircleFeedOperateManager", 1, "[handleAddReply] " + event.getOperateSyncInfo());
        if (!(event.getOperateSyncInfo().getUgcKey().length() == 0)) {
            if (!(event.getOperateSyncInfo().getCommentId().length() == 0)) {
                if (!(event.getOperateSyncInfo().getReplyId().length() == 0)) {
                    if (!(event.getOperateSyncInfo().getContent().length() == 0)) {
                        long l3 = d.l(event.getOperateSyncInfo().getTargetUin(), 0L);
                        if (l3 == 0) {
                            QZLog.e("QZoneFeedxSyncQCircleFeedOperateManager", 1, "[handleAddReply] targetUin illegal, targetUin=" + event.getOperateSyncInfo().getTargetUin());
                            return;
                        }
                        QZoneWriteOperationService.o oVar = new QZoneWriteOperationService.o();
                        oVar.f45760a = event.getOperateSyncInfo().getUgcKey();
                        oVar.f45763d = event.getOperateSyncInfo().getCommentId();
                        oVar.f45762c = event.getOperateSyncInfo().getReplyId();
                        oVar.f45761b = event.getOperateSyncInfo().getFeedId();
                        oVar.f45767h = event.getOperateSyncInfo().getContent();
                        oVar.f45766g = new User(l3, event.getOperateSyncInfo().getTargetNick());
                        QZoneWriteOperationService.v0().M1(oVar);
                        return;
                    }
                }
            }
        }
        QZLog.e("QZoneFeedxSyncQCircleFeedOperateManager", 1, "[handleAddReply] sync info is error");
    }

    private final void e(QCircleFeedOperateFakeSyncExternalEvent event) {
        QZLog.d("QZoneFeedxSyncQCircleFeedOperateManager", 1, "[handleCommentLike] " + event.getOperateSyncInfo());
        if (!(event.getOperateSyncInfo().getUgcKey().length() == 0)) {
            if (!(event.getOperateSyncInfo().getCommentId().length() == 0)) {
                QZoneWriteOperationService.k kVar = new QZoneWriteOperationService.k();
                kVar.f45696c = event.getOperateSyncInfo().getUgcKey();
                kVar.f45703j = event.getOperateSyncInfo().getCommentId();
                kVar.f45700g = event.getOperateSyncInfo().getIsLike();
                QZoneWriteOperationService.v0().J1(kVar);
                return;
            }
        }
        QZLog.e("QZoneFeedxSyncQCircleFeedOperateManager", 1, "[handleCommentLike] sync info is error");
    }

    private final void f(QCircleFeedOperateFakeSyncExternalEvent event) {
        QZLog.d("QZoneFeedxSyncQCircleFeedOperateManager", 1, "[handleDeleteComment] " + event.getOperateSyncInfo());
        if (!(event.getOperateSyncInfo().getUgcKey().length() == 0)) {
            if (!(event.getOperateSyncInfo().getCommentId().length() == 0)) {
                QZoneWriteOperationService.v0().G1(event.getOperateSyncInfo().getUgcKey(), event.getOperateSyncInfo().getCommentId(), 0);
                return;
            }
        }
        QZLog.e("QZoneFeedxSyncQCircleFeedOperateManager", 1, "[handleDeleteComment] sync info is error");
    }

    private final void g(QCircleFeedOperateFakeSyncExternalEvent event) {
        QZLog.d("QZoneFeedxSyncQCircleFeedOperateManager", 1, "[handleDeleteReply] " + event.getOperateSyncInfo());
        if (!(event.getOperateSyncInfo().getUgcKey().length() == 0)) {
            if (!(event.getOperateSyncInfo().getCommentId().length() == 0)) {
                if (!(event.getOperateSyncInfo().getReplyId().length() == 0)) {
                    QZoneWriteOperationService.o oVar = new QZoneWriteOperationService.o();
                    oVar.f45760a = event.getOperateSyncInfo().getUgcKey();
                    oVar.f45763d = event.getOperateSyncInfo().getCommentId();
                    oVar.f45764e = event.getOperateSyncInfo().getReplyId();
                    QZoneWriteOperationService.v0().I1(oVar);
                    return;
                }
            }
        }
        QZLog.e("QZoneFeedxSyncQCircleFeedOperateManager", 1, "[handleDeleteReply] sync info is error");
    }

    private final void h(QCircleFeedOperateFakeSyncExternalEvent event) {
        String clientKey;
        QZLog.d("QZoneFeedxSyncQCircleFeedOperateManager", 1, "[handleFeedDelete] " + event.getOperateSyncInfo());
        if (event.getOperateSyncInfo().getUgcKey().length() == 0) {
            if (event.getOperateSyncInfo().getClientKey().length() == 0) {
                QZLog.e("QZoneFeedxSyncQCircleFeedOperateManager", 1, "[handleFeedDelete] sync info is error");
                return;
            }
        }
        boolean z16 = event.getOperateSyncInfo().getUgcKey().length() > 0;
        QCircleFeedOperateFakeSyncExternalInfo operateSyncInfo = event.getOperateSyncInfo();
        if (z16) {
            clientKey = operateSyncInfo.getUgcKey();
        } else {
            clientKey = operateSyncInfo.getClientKey();
        }
        QZoneWriteOperationService.v0().H1(clientKey, event.getOperateSyncInfo().getClientKey());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void i(QCircleFeedOperateFakeSyncExternalEvent event) {
        QZLog.d("QZoneFeedxSyncQCircleFeedOperateManager", 1, "[handleFeedLike] " + event.getOperateSyncInfo());
        if ((event.getOperateSyncInfo().getUgcKey().length() == 0) != false) {
            QZLog.e("QZoneFeedxSyncQCircleFeedOperateManager", 1, "[handleFeedLike] sync info is error");
            return;
        }
        QZoneWriteOperationService.m mVar = new QZoneWriteOperationService.m();
        mVar.f45734a = event.getOperateSyncInfo().getUgcKey();
        boolean isLike = event.getOperateSyncInfo().getIsLike();
        mVar.f45738e = isLike;
        QZoneWriteOperationService.v0().K1(!isLike ? 1 : 0, mVar);
    }

    private final void j(QCircleFeedOperateFakeSyncExternalEvent event) {
        switch (event.getOperateSyncInfo().getEventType()) {
            case 1:
                i(event);
                return;
            case 2:
                e(event);
                return;
            case 3:
                l(event);
                return;
            case 4:
                c(event);
                return;
            case 5:
                f(event);
                return;
            case 6:
                d(event);
                return;
            case 7:
                g(event);
                return;
            case 8:
                h(event);
                return;
            default:
                return;
        }
    }

    private final void k(QCircleFeedJSPermissionChangeEvent event) {
        if (!(event.getUgcKey().length() == 0) && event.getRightFlag() != 0) {
            int a16 = a(event.getRightFlag());
            String b16 = b(event.getRightFlag(), event.getQzoneType());
            QZLog.d("QZoneFeedxSyncQCircleFeedOperateManager", 1, "[handleQCircleJSPermissionChangeEvent] feedId=" + event.getFeedId() + ", ugcKey=" + event.getUgcKey() + ", right=" + event.getRightFlag() + ", qzoneRightFlag=" + a16 + ", qzoneType=" + event.getQzoneType() + ", qzoneRightTxt==" + b16);
            QZoneWriteOperationService.v0().N1(event.getUgcKey(), b16, a16);
            return;
        }
        QZLog.e("QZoneFeedxSyncQCircleFeedOperateManager", 1, "[handleQCircleJSPermissionChangeEvent] permission info is error, ugcKey=" + event.getUgcKey() + ", right=" + event.getRightFlag() + ", qzoneType=" + event.getQzoneType());
    }

    private final void l(QCircleFeedOperateFakeSyncExternalEvent event) {
        QZLog.d("QZoneFeedxSyncQCircleFeedOperateManager", 1, "[handleReplyLike] " + event.getOperateSyncInfo());
        if (!(event.getOperateSyncInfo().getUgcKey().length() == 0)) {
            if (!(event.getOperateSyncInfo().getCommentId().length() == 0)) {
                if (!(event.getOperateSyncInfo().getReplyId().length() == 0)) {
                    QZoneWriteOperationService.k kVar = new QZoneWriteOperationService.k();
                    kVar.f45696c = event.getOperateSyncInfo().getUgcKey();
                    kVar.f45703j = event.getOperateSyncInfo().getCommentId();
                    kVar.f45704k = event.getOperateSyncInfo().getReplyId();
                    kVar.f45700g = event.getOperateSyncInfo().getIsLike();
                    QZoneWriteOperationService.v0().L1(kVar);
                    return;
                }
            }
        }
        QZLog.e("QZoneFeedxSyncQCircleFeedOperateManager", 1, "[handleReplyLike] sync info is error");
    }

    public final void m() {
        boolean A = QZoneConfigHelper.A();
        QZLog.d("QZoneFeedxSyncQCircleFeedOperateManager", 1, "[registerReceiver] hasRegister=" + mHasRegister + ", enableFake=" + A);
        if (mHasRegister || !A) {
            return;
        }
        SimpleEventBus.getInstance().registerReceiver(this);
        mHasRegister = true;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent event) {
        boolean A = QZoneConfigHelper.A();
        if (event == null || !A) {
            QZLog.e("QZoneFeedxSyncQCircleFeedOperateManager", 1, "[onReceiveEvent] enableFake=" + A + ", event=" + event);
        }
        if (event instanceof QCircleFeedOperateFakeSyncExternalEvent) {
            j((QCircleFeedOperateFakeSyncExternalEvent) event);
        } else if (event instanceof QCircleFeedJSPermissionChangeEvent) {
            k((QCircleFeedJSPermissionChangeEvent) event);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(QCircleFeedOperateFakeSyncExternalEvent.class, QCircleFeedJSPermissionChangeEvent.class);
        return arrayListOf;
    }

    private final String b(int qqVideoFeedRight, int qzoneType) {
        if (qzoneType == 2) {
            return "\u7a7a\u95f4\u72b6\u6001\u4e3a\u79c1\u5bc6";
        }
        if (qqVideoFeedRight == 2) {
            return "QQ\u597d\u53cb\u53ef\u89c1";
        }
        if (qqVideoFeedRight == 3) {
            return "\u90e8\u5206\u597d\u53cb\u53ef\u89c1";
        }
        if (qqVideoFeedRight == 5) {
            return "\u4ec5\u81ea\u5df1\u53ef\u89c1";
        }
        if (qqVideoFeedRight != 6) {
            return "";
        }
        return "\u90e8\u5206\u597d\u53cb\u4e0d\u53ef\u89c1";
    }
}
