package xk3;

import android.text.TextUtils;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.zootopia.download.HalleyDownloader;
import com.tencent.mobileqq.zootopia.download.mod.ZPlanModResManager;
import com.tencent.mobileqq.zootopia.download.normal.BaseDownloadQueue;
import com.tencent.mobileqq.zootopia.space.MapOccupiedSpaceManager;
import com.tencent.mobileqq.zootopia.ue.ZPlanExitMapEvent;
import com.tencent.mobileqq.zplan.utils.stack.lifecycle.ProcessName;
import com.tencent.qphone.base.util.QLog;
import com.tencent.upload.report.UploadQualityReportBuilder;
import com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener;
import com.tencent.zplan.engine.ZPlanServiceHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0002\u00a2\u0006\u0004\b6\u00107J \u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0003H\u0002J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0003H\u0002J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u0003H\u0002J\u0012\u0010\u000f\u001a\u00020\b2\b\b\u0001\u0010\u000e\u001a\u00020\u0003H\u0002J\u0010\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u0013\u001a\u0004\u0018\u00010\u0003J\b\u0010\u0014\u001a\u0004\u0018\u00010\u0003J\u0014\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0015J*\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u0003H\u0016J*\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u0003H\u0016J \u0010\u001b\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J \u0010\u001c\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u001a\u0010\u001f\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u00052\b\u0010\u001e\u001a\u0004\u0018\u00010\u0003H\u0016J\u0018\u0010\"\u001a\u00020\b2\u0006\u0010 \u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u0003H\u0016J\u0018\u0010#\u001a\u00020\b2\u0006\u0010 \u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u0003H\u0016J\u0010\u0010$\u001a\u00020\b2\u0006\u0010 \u001a\u00020\u0005H\u0016J\u000e\u0010&\u001a\u00020\b2\u0006\u0010%\u001a\u00020\u0003J\u000e\u0010'\u001a\u00020\b2\u0006\u0010%\u001a\u00020\u0003J\u0016\u0010(\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005R\u0016\u0010*\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010,\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010+R\u001a\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00030-8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010.R&\u00100\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00150-8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010.R&\u00105\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000302018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b3\u00104\u00a8\u00068"}, d2 = {"Lxk3/e;", "Lyk3/d;", "Lcom/tencent/zplan/engine/ZPlanEngineStatusUpdateListener;", "", "activityName", "", "hashCode", "logPrefix", "", "d", "needRemoveItem", "l", "activityKey", "k", "deadProcess", "c", "", UploadQualityReportBuilder.STATE_CONNECT, "serviceConnected", "g", h.F, "Lkotlin/Pair;", "f", "isEnginePage", "processName", "activityCreate", "activityResume", "activityFinish", "activityDestroy", "sceneType", "sceneParams", "ueEnterAvatarScene", "mapId", "mapName", "doEnterUeMap", "doExitUeMap", "clearInvalidModRes", "logMsg", "j", "i", "e", "I", "mCurUeMapId", "Ljava/lang/String;", "mCurUeMapName", "Ljava/util/LinkedList;", "Ljava/util/LinkedList;", "mZPlanActivityStack", "mEngineSceneStack", "Ljava/util/HashMap;", "Ljava/util/HashSet;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/HashMap;", "mProcessStackMap", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class e implements yk3.d, ZPlanEngineStatusUpdateListener {

    /* renamed from: d, reason: collision with root package name */
    public static final e f448113d;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static int mCurUeMapId;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static String mCurUeMapName;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private static final LinkedList<String> mZPlanActivityStack;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private static final LinkedList<Pair<String, String>> mEngineSceneStack;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private static final HashMap<String, HashSet<String>> mProcessStackMap;

    static {
        e eVar = new e();
        f448113d = eVar;
        mCurUeMapName = "";
        mZPlanActivityStack = new LinkedList<>();
        mEngineSceneStack = new LinkedList<>();
        mProcessStackMap = new HashMap<>();
        QLog.i("ZPlanLifeCycleRecordManager_", 1, "init: " + eVar + " -- " + MobileQQ.processName);
        ZPlanServiceHelper.I.E0(eVar);
    }

    e() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b() {
        f448113d.j("activityCreate first entrance, HalleyDownloader#startDnsPrepareIfNecessary");
        HalleyDownloader.f327980a.o();
    }

    private final synchronized void c(@ProcessName String deadProcess) {
        HashSet<String> remove = mProcessStackMap.remove(deadProcess);
        j("clearAllTaskOfProcess deadProcess:" + deadProcess + ", needRemoveItem:" + remove);
        if (remove == null || remove.isEmpty()) {
            return;
        }
        Iterator<String> it = remove.iterator();
        while (it.hasNext()) {
            String item = it.next();
            Intrinsics.checkNotNullExpressionValue(item, "item");
            k(item);
        }
    }

    private final void d(String activityName, int hashCode, String logPrefix) {
        String e16 = e(activityName, hashCode);
        k(e16);
        l(e16);
        j(logPrefix + " key:" + e16 + ", after remove:" + mZPlanActivityStack);
        j(logPrefix + " key:" + e16 + ", after remove mProcessStackMap:" + mProcessStackMap);
    }

    private final void k(String activityKey) {
        Set set;
        LinkedList<String> linkedList = mZPlanActivityStack;
        boolean z16 = !linkedList.isEmpty();
        linkedList.remove(activityKey);
        ArrayList arrayList = new ArrayList();
        int size = mEngineSceneStack.size();
        for (int i3 = 0; i3 < size; i3++) {
            Pair<String, String> pair = mEngineSceneStack.get(i3);
            Intrinsics.checkNotNullExpressionValue(pair, "mEngineSceneStack[index]");
            Pair<String, String> pair2 = pair;
            if (Intrinsics.areEqual(pair2.getSecond(), activityKey)) {
                arrayList.add(pair2);
            }
        }
        if (arrayList.size() > 0) {
            j("removeEngine - " + arrayList.size());
            LinkedList<Pair<String, String>> linkedList2 = mEngineSceneStack;
            set = CollectionsKt___CollectionsKt.toSet(arrayList);
            linkedList2.removeAll(set);
        }
        if (mZPlanActivityStack.isEmpty() && z16) {
            j("removeActivityFromStack " + activityKey + ", after mZPlanActivityStack is empty, HalleyDownloader#stopDnsPrepare");
            HalleyDownloader.f327980a.p();
        }
    }

    private final void l(String needRemoveItem) {
        for (Map.Entry<String, HashSet<String>> entry : mProcessStackMap.entrySet()) {
            if (entry.getValue().contains(needRemoveItem)) {
                entry.getValue().remove(needRemoveItem);
            }
        }
    }

    @Override // yk3.d
    public synchronized void activityCreate(boolean isEnginePage, String activityName, int hashCode, String processName) {
        Intrinsics.checkNotNullParameter(activityName, "activityName");
        String e16 = e(activityName, hashCode);
        if (processName == null) {
            i("activityCreate key:" + e16 + ", isEnginePage=" + isEnginePage + ", processName= null!!!");
            return;
        }
        LinkedList<String> linkedList = mZPlanActivityStack;
        boolean isEmpty = linkedList.isEmpty();
        linkedList.add(e16);
        HashMap<String, HashSet<String>> hashMap = mProcessStackMap;
        HashSet<String> hashSet = hashMap.get(processName);
        if (hashSet == null) {
            hashSet = new HashSet<>();
        }
        hashSet.add(e16);
        hashMap.put(processName, hashSet);
        j("activityCreate key:" + e16 + ", isEnginePage=" + isEnginePage + ", processName=" + processName + ", after add:" + linkedList);
        StringBuilder sb5 = new StringBuilder();
        sb5.append("activityCreate after add mProcessStackMap:");
        sb5.append(hashMap);
        j(sb5.toString());
        if (isEmpty) {
            ThreadManagerV2.excute(new Runnable() { // from class: xk3.d
                @Override // java.lang.Runnable
                public final void run() {
                    e.b();
                }
            }, 16, null, true);
        }
    }

    @Override // yk3.d
    public synchronized void activityDestroy(boolean isEnginePage, String activityName, int hashCode) {
        Intrinsics.checkNotNullParameter(activityName, "activityName");
        d(activityName, hashCode, "activityDestroy");
    }

    @Override // yk3.d
    public synchronized void activityFinish(boolean isEnginePage, String activityName, int hashCode) {
        Intrinsics.checkNotNullParameter(activityName, "activityName");
        d(activityName, hashCode, "activityFinish");
    }

    @Override // yk3.d
    public synchronized void activityResume(boolean isEnginePage, String activityName, int hashCode, String processName) {
        Intrinsics.checkNotNullParameter(activityName, "activityName");
        j("activityResume key:" + e(activityName, hashCode));
    }

    @Override // yk3.d
    public void clearInvalidModRes(int mapId) {
        ZPlanModResManager.f328075a.b(String.valueOf(mapId));
    }

    @Override // yk3.d
    public void doEnterUeMap(int mapId, String mapName) {
        Intrinsics.checkNotNullParameter(mapName, "mapName");
        i("doEnterUeMap - mapId:" + mapId + ", mapName:" + mapName);
        mCurUeMapId = mapId;
        mCurUeMapName = mapName;
    }

    @Override // yk3.d
    public void doExitUeMap(int mapId, String mapName) {
        Intrinsics.checkNotNullParameter(mapName, "mapName");
        i("doExitUeMap - mapId:" + mapId + ", mapName:" + mapName);
        int i3 = mCurUeMapId;
        if (mapId != i3) {
            i("doExitUeMap but not equal!!! curMapId=" + i3 + ", curName=" + mCurUeMapName);
        }
        mCurUeMapId = 0;
        mCurUeMapName = "";
        BaseDownloadQueue.INSTANCE.a();
        MapOccupiedSpaceManager.f329259b.B(String.valueOf(mapId));
        SimpleEventBus.getInstance().dispatchEvent(new ZPlanExitMapEvent(mapId, mapName));
    }

    public final String e(String activityName, int hashCode) {
        Intrinsics.checkNotNullParameter(activityName, "activityName");
        return b.f448110a.a(activityName, hashCode);
    }

    @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
    public void engineDestroy() {
        ZPlanEngineStatusUpdateListener.a.a(this);
    }

    @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
    @Deprecated(message = "\u8bf7\u4f7f\u7528world\u7684FirstFrame\u72b6\u6001\u56de\u8c03")
    public void engineFirstFrame() {
        ZPlanEngineStatusUpdateListener.a.b(this);
    }

    @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
    public void engineInitFinish(boolean z16) {
        ZPlanEngineStatusUpdateListener.a.c(this, z16);
    }

    @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
    public void engineInversePurged() {
        ZPlanEngineStatusUpdateListener.a.d(this);
    }

    @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
    public void enginePurged() {
        ZPlanEngineStatusUpdateListener.a.e(this);
    }

    @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
    public void enginePurging() {
        ZPlanEngineStatusUpdateListener.a.f(this);
    }

    @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
    public void engineSuspended() {
        ZPlanEngineStatusUpdateListener.a.g(this);
    }

    public final Pair<Integer, String> f() {
        int i3 = mCurUeMapId;
        if (i3 > 0) {
            return new Pair<>(Integer.valueOf(i3), mCurUeMapName);
        }
        return null;
    }

    public final String g() {
        try {
            return mZPlanActivityStack.getLast();
        } catch (NoSuchElementException unused) {
            return null;
        }
    }

    public final String h() {
        try {
            return mEngineSceneStack.getLast().getFirst();
        } catch (NoSuchElementException unused) {
            return null;
        }
    }

    @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
    public void hotPatchDownloadFailed(int i3, String str) {
        ZPlanEngineStatusUpdateListener.a.h(this, i3, str);
    }

    public final void i(String logMsg) {
        Intrinsics.checkNotNullParameter(logMsg, "logMsg");
        QLog.e("ZPlanLifeCycleRecordManager_", 1, logMsg);
    }

    public final void j(String logMsg) {
        Intrinsics.checkNotNullParameter(logMsg, "logMsg");
        QLog.i("ZPlanLifeCycleRecordManager_", 1, logMsg);
    }

    @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
    public void serviceConnected(boolean connect) {
        QLog.i("ZPlanLifeCycleRecordManager_", 1, "serviceConnected connect:" + connect);
        if (connect) {
            return;
        }
        c("zplan");
    }

    @Override // yk3.d
    public synchronized void ueEnterAvatarScene(int sceneType, String sceneParams) {
        String str;
        if (TextUtils.isEmpty(sceneParams)) {
            str = "";
        } else {
            str = "_" + sceneParams;
        }
        String str2 = sceneType + str;
        String g16 = g();
        LinkedList<Pair<String, String>> linkedList = mEngineSceneStack;
        linkedList.add(new Pair<>(str2, g16 == null ? "" : g16));
        j("ueEnterAvatarScene - curActivity:" + g16 + ", sceneName:" + str2.hashCode() + ",  afterAdd.size - " + linkedList.size());
        BaseDownloadQueue.INSTANCE.a();
    }
}
