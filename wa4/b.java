package wa4;

import android.app.Activity;
import android.os.Bundle;
import android.os.IBinder;
import android.text.TextUtils;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkpublish.TaskInfo;
import com.tencent.mobileqq.winkpublish.WinkPublishHelper2;
import com.tencent.mobileqq.winkpublish.WinkPublishServiceProxy2;
import com.tencent.mobileqq.winkpublish.api.ITaskListener;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zootopia.api.e;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.publish.event.ZPlanFeedsPublishSuccessEvent;
import com.tencent.sqshow.zootopia.utils.ag;
import com.tencent.sqshow.zootopia.utils.ah;
import com.tencent.state.report.SquareReportConst;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Foreground;
import pu4.j;
import pu4.l;
import pu4.n;
import wa4.b;
import xa4.f;

/* compiled from: P */
@Metadata(d1 = {"\u0000S\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0007*\u0001'\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b+\u0010,J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J,\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002J\u0012\u0010\u0011\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\u0012\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0018\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\u0014\u001a\u00020\u0006H\u0002J\u0006\u0010\u0015\u001a\u00020\u0006J\u0006\u0010\u0016\u001a\u00020\u0006R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010\"\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010&\u001a\u00020#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010*\u001a\u00020'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010)\u00a8\u0006-"}, d2 = {"Lwa4/b;", "", "Lcom/tencent/mobileqq/winkpublish/TaskInfo;", "taskInfo", "", "isFinalSuccess", "", DomainData.DOMAIN_NAME, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "j", "Lpu4/n;", "serverRspInfo", "", "error", "", "message", "k", "l", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, ReportConstant.COSTREPORT_PREFIX, "r", "o", "p", "Lcom/tencent/mobileqq/winkpublish/WinkPublishServiceProxy2;", "b", "Lcom/tencent/mobileqq/winkpublish/WinkPublishServiceProxy2;", "winkService", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lwa4/d;", "c", "Ljava/util/concurrent/CopyOnWriteArrayList;", "mListenerList", "d", "Lcom/tencent/mobileqq/winkpublish/TaskInfo;", "mCurTaskInfo", "Lid3/d;", "e", "Lid3/d;", "dtReporter", "wa4/b$b", "f", "Lwa4/b$b;", "mListener", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class b {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static WinkPublishServiceProxy2 winkService;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static TaskInfo mCurTaskInfo;

    /* renamed from: a, reason: collision with root package name */
    public static final b f445350a = new b();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final CopyOnWriteArrayList<d> mListenerList = new CopyOnWriteArrayList<>();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static final id3.d dtReporter = new id3.d(null, 1, null);

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static final C11472b mListener = new C11472b();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"wa4/b$a", "Lcom/tencent/mobileqq/zootopia/api/e;", "Liw4/b;", "result", "", "a", "", "error", "", "message", "onResultFailure", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes36.dex */
    public static final class a implements e<iw4.b> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ TaskInfo f445356d;

        a(TaskInfo taskInfo) {
            this.f445356d = taskInfo;
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(iw4.b result) {
            Intrinsics.checkNotNullParameter(result, "result");
            b.f445350a.k(this.f445356d, result.f408873a, 0, null);
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            b.f445350a.k(this.f445356d, null, error, message);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"wa4/b$c", "Lcom/tencent/mobileqq/winkpublish/WinkPublishHelper2$Callback;", "Lcom/tencent/mobileqq/winkpublish/WinkPublishServiceProxy2;", "service", "", "onServiceConnected", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes36.dex */
    public static final class c implements WinkPublishHelper2.Callback {
        c() {
        }

        @Override // com.tencent.mobileqq.winkpublish.WinkPublishHelper2.Callback
        public void onServiceConnected(WinkPublishServiceProxy2 service) {
            Object firstOrNull;
            Intrinsics.checkNotNullParameter(service, "service");
            b.winkService = service;
            List<TaskInfo> runningTasks = service.getRunningTasks();
            ArrayList arrayList = new ArrayList();
            for (Object obj : runningTasks) {
                if (b.f445350a.l((TaskInfo) obj)) {
                    arrayList.add(obj);
                }
            }
            QLog.i("ZPlanFeedsPublishHelper", 1, "bindService#onServiceConnected - " + service + ", curZPlanTasks = " + arrayList);
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) arrayList);
            TaskInfo taskInfo = (TaskInfo) firstOrNull;
            if (taskInfo != null) {
                b.mListener.onTaskChange(taskInfo);
            }
            service.addTaskListener(b.mListener);
        }
    }

    b() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j(TaskInfo taskInfo) {
        QLog.i("ZPlanFeedsPublishHelper", 1, "doWhenWinkPublishSuccess - " + taskInfo.getTaskId() + ", feedId=" + taskInfo.getFeedId());
        yb4.b bVar = yb4.b.f450051a;
        iw4.a aVar = new iw4.a();
        aVar.f408869b = taskInfo.getFeedId();
        yb4.b.b(bVar, aVar, new a(taskInfo), 0, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k(TaskInfo taskInfo, n serverRspInfo, int error, String message) {
        j jVar;
        j jVar2;
        Activity topActivity = Foreground.getTopActivity();
        if (topActivity == null) {
            topActivity = QBaseActivity.sTopActivity;
        }
        String str = "handleFinalPublishResult - error=" + error + ", message=" + message + ", serverRspInfo= {feedId=" + ((serverRspInfo == null || (jVar2 = serverRspInfo.f427498a) == null) ? null : jVar2.f427463b) + ", id=" + ((serverRspInfo == null || (jVar = serverRspInfo.f427498a) == null) ? null : jVar.f427462a) + "}, curTopActivity= " + topActivity;
        if (error == 0 && serverRspInfo != null) {
            QLog.i("ZPlanFeedsPublishHelper", 1, str);
            s(taskInfo, serverRspInfo);
        } else {
            QLog.e("ZPlanFeedsPublishHelper", 1, str);
        }
        TaskInfo taskInfo2 = mCurTaskInfo;
        boolean z16 = false;
        if (taskInfo2 != null && taskInfo2.getTaskId() == taskInfo.getTaskId()) {
            z16 = true;
        }
        if (z16) {
            n(taskInfo, true);
            mCurTaskInfo = null;
        }
        if (serverRspInfo != null && topActivity != null && !topActivity.isFinishing()) {
            f.Companion companion = f.INSTANCE;
            ZootopiaSource b16 = ag.f373258a.b();
            if (b16 == null) {
                b16 = ZootopiaSource.INSTANCE.g();
            }
            companion.a(serverRspInfo, topActivity, b16);
        } else {
            QQToast.makeText(BaseApplication.getContext(), 2, R.string.xo_, 1).show();
        }
        SimpleEventBus.getInstance().dispatchEvent(new ZPlanFeedsPublishSuccessEvent(serverRspInfo));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n(TaskInfo taskInfo, boolean isFinalSuccess) {
        ZPlanFeedsPublishData zPlanFeedsPublishData = new ZPlanFeedsPublishData(taskInfo.getTaskId(), taskInfo, isFinalSuccess);
        Iterator<T> it = mListenerList.iterator();
        while (it.hasNext()) {
            ((d) it.next()).a(zPlanFeedsPublishData);
        }
    }

    private final void q() {
        WinkPublishHelper2.INSTANCE.bindService(1, new c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r() {
        String str;
        id3.d dVar = dtReporter;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        ZootopiaSource b16 = ag.f373258a.b();
        if (b16 == null || (str = ah.b(b16)) == null) {
            str = "";
        }
        linkedHashMap.put(SquareReportConst.Key.KEY_EXTERNAL_ENTRANCE, str);
        Unit unit = Unit.INSTANCE;
        dVar.d("ev_zplan_outfit_publish_fail", linkedHashMap);
    }

    private final void s(TaskInfo taskInfo, n serverRspInfo) {
        String str;
        Object obj;
        Object obj2;
        id3.d dVar = dtReporter;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        ZootopiaSource b16 = ag.f373258a.b();
        if (b16 == null || (str = ah.b(b16)) == null) {
            str = "";
        }
        linkedHashMap.put(SquareReportConst.Key.KEY_EXTERNAL_ENTRANCE, str);
        l lVar = serverRspInfo.f427499b;
        String str2 = lVar != null ? lVar.f427476a : null;
        if (str2 == null) {
            str2 = "";
        } else {
            Intrinsics.checkNotNullExpressionValue(str2, "serverRspInfo.detailInfo?.id ?: \"\"");
        }
        linkedHashMap.put("zplan_content_id", str2);
        l lVar2 = serverRspInfo.f427499b;
        if (lVar2 == null) {
            obj = "";
        } else {
            obj = Integer.valueOf(lVar2.f427491p);
        }
        linkedHashMap.put("zplan_content_type", obj);
        j jVar = serverRspInfo.f427498a;
        if (jVar == null) {
            obj2 = "";
        } else {
            obj2 = Integer.valueOf(jVar.f427466e);
        }
        linkedHashMap.put("zplan_visible_range", obj2);
        Bundle transParams = taskInfo.getTransParams();
        String string = transParams != null ? transParams.getString(WinkDaTongReportConstant.ElementParamKey.XSJ_PUBLISH_IS_SYNC_QZONE) : null;
        Bundle transParams2 = taskInfo.getTransParams();
        String string2 = transParams2 != null ? transParams2.getString(WinkDaTongReportConstant.ElementParamKey.XSJ_PUBLISH_IS_SAVE) : null;
        QLog.i("ZPlanFeedsPublishHelper", 1, "reportSuccessEvent, isSyncQZone= " + string + ", isSaveLocal= " + string2);
        if (!TextUtils.isEmpty(string)) {
            if (string == null) {
                string = "";
            }
            linkedHashMap.put("zplan_is_sync_qzone", string);
        }
        if (!TextUtils.isEmpty(string2)) {
            linkedHashMap.put("zplan_is_save_locally", string2 != null ? string2 : "");
        }
        Unit unit = Unit.INSTANCE;
        dVar.d("ev_zplan_outfit_publish_success", linkedHashMap);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"wa4/b$b", "Lcom/tencent/mobileqq/winkpublish/api/ITaskListener;", "Landroid/os/IBinder;", "asBinder", "Lcom/tencent/mobileqq/winkpublish/TaskInfo;", "taskInfo", "", "onTaskChange", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: wa4.b$b, reason: collision with other inner class name */
    /* loaded from: classes36.dex */
    public static final class C11472b implements ITaskListener {
        C11472b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void v(TaskInfo taskInfo) {
            b.mCurTaskInfo = taskInfo;
            b bVar = b.f445350a;
            bVar.n(taskInfo, false);
            if (taskInfo.isFinish()) {
                if (bVar.m(taskInfo)) {
                    bVar.j(taskInfo);
                } else {
                    bVar.r();
                }
            }
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.tencent.mobileqq.winkpublish.api.ITaskListener
        public void onTaskChange(final TaskInfo taskInfo) {
            if (taskInfo != null) {
                if (b.f445350a.l(taskInfo)) {
                    QLog.i("ZPlanFeedsPublishHelper", 1, "mListener#onTaskChange - " + taskInfo);
                    ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: wa4.c
                        @Override // java.lang.Runnable
                        public final void run() {
                            b.C11472b.v(TaskInfo.this);
                        }
                    });
                    return;
                }
                QLog.i("ZPlanFeedsPublishHelper", 1, "mListener#onTaskChange, not zplan");
            }
        }
    }

    public final void o() {
        QLog.i("ZPlanFeedsPublishHelper", 1, "onCreate");
        q();
    }

    public final void p() {
        QLog.i("ZPlanFeedsPublishHelper", 1, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean l(TaskInfo taskInfo) {
        return taskInfo != null && taskInfo.isTrueUpload() && com.tencent.sqshow.zootopia.samestyle.b.f372897a.i(xb4.b.f447772a.r(taskInfo.getTransParams()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean m(TaskInfo taskInfo) {
        if (taskInfo != null) {
            return (taskInfo.getFeedId().length() > 0) && taskInfo.getFeedTime() != 0;
        }
        return false;
    }
}
