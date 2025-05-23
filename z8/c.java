package z8;

import android.os.Handler;
import com.qzone.publish.business.publishqueue.common.CommonPublishQueue;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.upload.uinterface.UploadServiceBuilder;
import cooperation.qzone.UploadEnv;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0011\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0086\u0002J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\n\u001a\u00020\bR \u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u0011\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0010R\u0014\u0010\u0014\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0013R\u0014\u0010\u0017\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lz8/c;", "", "", "d", "", "groupId", "Lcom/qzone/publish/business/publishqueue/common/CommonPublishQueue;", "c", "", "g", "e", "", "b", "Ljava/util/Map;", "publishQueueMap", "Lcom/qzone/publish/business/publishqueue/common/f;", "Lcom/qzone/publish/business/publishqueue/common/f;", "taskManager", "Lcom/qzone/publish/business/publishqueue/common/e;", "Lcom/qzone/publish/business/publishqueue/common/e;", "restoreFilterHelper", "Landroid/os/Handler;", "Landroid/os/Handler;", "handler", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f452134a = new c();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final Map<String, CommonPublishQueue> publishQueueMap = new LinkedHashMap();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final com.qzone.publish.business.publishqueue.common.f taskManager = new com.qzone.publish.business.publishqueue.common.f(2);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static final com.qzone.publish.business.publishqueue.common.e restoreFilterHelper = new com.qzone.publish.business.publishqueue.common.e();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static final Handler handler = new Handler(QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.RealTimeThread).getLooper());

    c() {
    }

    private final boolean d() {
        return MobileQQ.PACKAGE_NAME.equals(BaseApplication.processName);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f() {
        taskManager.r();
        Iterator<Map.Entry<String, CommonPublishQueue>> it = publishQueueMap.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().N();
        }
        publishQueueMap.clear();
        restoreFilterHelper.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(String groupId) {
        Intrinsics.checkNotNullParameter(groupId, "$groupId");
        if (taskManager.t()) {
            com.qzone.publish.business.publishqueue.common.e eVar = restoreFilterHelper;
            if (eVar.b(groupId)) {
                RFWLog.i("GroupAlbumPublishQueueManager", RFWLog.USR, "restore, has retry, return, groupId:" + groupId);
                return;
            }
            eVar.c(groupId);
            RFWLog.i("GroupAlbumPublishQueueManager", RFWLog.USR, "restore, repeat, groupId:" + groupId);
            f452134a.c(groupId).O();
        }
    }

    public final CommonPublishQueue c(String groupId) {
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        Map<String, CommonPublishQueue> map = publishQueueMap;
        CommonPublishQueue commonPublishQueue = map.get(groupId);
        if (commonPublishQueue == null) {
            RFWLog.i("GroupAlbumPublishQueueManager", RFWLog.USR, "invoke, groupId:" + groupId);
            if (!UploadServiceBuilder.getInstance().isInitialized()) {
                UploadEnv uploadEnv = new UploadEnv();
                UploadServiceBuilder.init(BaseApplication.getContext(), new r7.b(), new r7.d(), new r7.e(), uploadEnv, uploadEnv, null);
                RFWLog.i("GroupAlbumPublishQueueManager", RFWLog.USR, "initPublishQueue,  again init UploadService");
            }
            com.qzone.publish.business.publishqueue.common.f fVar = taskManager;
            String BUSINESS_FLAG_GROUP_ALBUM = eo.d.f396891k;
            Intrinsics.checkNotNullExpressionValue(BUSINESS_FLAG_GROUP_ALBUM, "BUSINESS_FLAG_GROUP_ALBUM");
            commonPublishQueue = new CommonPublishQueue(groupId, fVar, BUSINESS_FLAG_GROUP_ALBUM);
            map.put(groupId, commonPublishQueue);
        }
        return commonPublishQueue;
    }

    public final void e() {
        RFWLog.i("GroupAlbumPublishQueueManager", RFWLog.USR, "onAccountChanged ");
        handler.post(new Runnable() { // from class: z8.b
            @Override // java.lang.Runnable
            public final void run() {
                c.f();
            }
        });
    }

    public final void g(final String groupId) {
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        boolean d16 = d();
        RFWLog.i("GroupAlbumPublishQueueManager", RFWLog.USR, "restore, start, isMainProcess:" + d16);
        if (d16) {
            handler.post(new Runnable() { // from class: z8.a
                @Override // java.lang.Runnable
                public final void run() {
                    c.h(groupId);
                }
            });
        }
    }
}
