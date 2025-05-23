package z8;

import com.qzone.publish.business.model.groupalbum.GroupAlbumUploadAlbumParams;
import com.qzone.publish.business.model.groupalbum.GroupAlbumUploadMediaResult;
import com.qzone.publish.business.model.groupalbum.GroupAlbumUploadTaskBatchInfo;
import com.qzone.publish.business.model.groupalbum.GroupAlbumUploadTaskGeneralInfo;
import com.qzone.reborn.albumx.common.bean.CommonAlbumUploadMediaInfo;
import com.qzone.reborn.groupalbum.event.GroupAlbumUploadAlbumEvent;
import com.qzone.reborn.util.i;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import qzone.QZoneBaseMeta$StMedia;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00112\u00020\u0001:\u0001\bB\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005J@\u0010\u0011\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\t2\u0016\b\u0002\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u000b2\u0016\b\u0002\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000bJ\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\t2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\f0\u0012J\u000e\u0010\u0015\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0007R\u0016\u0010\u001a\u001a\u00020\u00188\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lz8/e;", "", "", "e", "g", "Lcom/qzone/publish/business/model/groupalbum/GroupAlbumUploadAlbumParams;", "params", "Lcom/qzone/publish/business/model/groupalbum/GroupAlbumUploadTaskBatchInfo;", "a", "", "batchId", "", "", "", "resultBoolMap", "Lqzone/QZoneBaseMeta$StMedia;", "resultMap", "b", "", "originalPathList", "f", "d", "batchInfo", "c", "Lcom/qzone/publish/business/model/groupalbum/GroupAlbumUploadTaskGeneralInfo;", "Lcom/qzone/publish/business/model/groupalbum/GroupAlbumUploadTaskGeneralInfo;", "taskGeneralInfo", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private GroupAlbumUploadTaskGeneralInfo taskGeneralInfo;

    public e() {
        e();
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x003a, code lost:
    
        if (r0 == null) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void e() {
        GroupAlbumUploadTaskGeneralInfo groupAlbumUploadTaskGeneralInfo;
        RFWLog.i("GroupAlbumUploadTaskBatchUtil", RFWLog.USR, "restoreGeneralInfo, start ");
        byte[] e16 = i.b().e("group_album_upload_task_general_info", null);
        if (e16 != null) {
            groupAlbumUploadTaskGeneralInfo = GroupAlbumUploadTaskGeneralInfo.INSTANCE.a(e16);
            if (groupAlbumUploadTaskGeneralInfo != null) {
                RFWLog.i("GroupAlbumUploadTaskBatchUtil", RFWLog.USR, "restoreGeneralInfo, from cache , ret:" + groupAlbumUploadTaskGeneralInfo);
            } else {
                groupAlbumUploadTaskGeneralInfo = null;
            }
        }
        RFWLog.i("GroupAlbumUploadTaskBatchUtil", RFWLog.USR, "restoreGeneralInfo, from default ");
        groupAlbumUploadTaskGeneralInfo = new GroupAlbumUploadTaskGeneralInfo(null, 1, null);
        this.taskGeneralInfo = groupAlbumUploadTaskGeneralInfo;
    }

    private final void g() {
        GroupAlbumUploadTaskGeneralInfo groupAlbumUploadTaskGeneralInfo = this.taskGeneralInfo;
        if (groupAlbumUploadTaskGeneralInfo == null) {
            Intrinsics.throwUninitializedPropertyAccessException("taskGeneralInfo");
            groupAlbumUploadTaskGeneralInfo = null;
        }
        RFWLog.d("GroupAlbumUploadTaskBatchUtil", RFWLog.DEV, "updateGeneralInfo, generalInfo:" + groupAlbumUploadTaskGeneralInfo);
        byte[] bytes = groupAlbumUploadTaskGeneralInfo.toBytes();
        if (bytes != null) {
            i.b().m("group_album_upload_task_general_info", bytes);
        }
    }

    public final GroupAlbumUploadTaskBatchInfo a(GroupAlbumUploadAlbumParams params) {
        Intrinsics.checkNotNullParameter(params, "params");
        RFWLog.i("GroupAlbumUploadTaskBatchUtil", RFWLog.USR, "addBatchInfo, params:" + params);
        GroupAlbumUploadTaskGeneralInfo groupAlbumUploadTaskGeneralInfo = this.taskGeneralInfo;
        if (groupAlbumUploadTaskGeneralInfo == null) {
            Intrinsics.throwUninitializedPropertyAccessException("taskGeneralInfo");
            groupAlbumUploadTaskGeneralInfo = null;
        }
        ConcurrentHashMap<Long, GroupAlbumUploadTaskBatchInfo> batchInfoMap = groupAlbumUploadTaskGeneralInfo.getBatchInfoMap();
        Long valueOf = Long.valueOf(params.getBatchId());
        GroupAlbumUploadTaskBatchInfo groupAlbumUploadTaskBatchInfo = batchInfoMap.get(valueOf);
        if (groupAlbumUploadTaskBatchInfo == null) {
            RFWLog.i("GroupAlbumUploadTaskBatchUtil", RFWLog.USR, "addBatchInfo, put default batch info ");
            groupAlbumUploadTaskBatchInfo = new GroupAlbumUploadTaskBatchInfo(null, null, null, 7, null);
            GroupAlbumUploadTaskBatchInfo putIfAbsent = batchInfoMap.putIfAbsent(valueOf, groupAlbumUploadTaskBatchInfo);
            if (putIfAbsent != null) {
                groupAlbumUploadTaskBatchInfo = putIfAbsent;
            }
        }
        GroupAlbumUploadTaskBatchInfo batchInfo = groupAlbumUploadTaskBatchInfo;
        batchInfo.setUploadParams(params);
        RFWLog.i("GroupAlbumUploadTaskBatchUtil", RFWLog.USR, "addBatchInfo, batchInfo:" + batchInfo);
        g();
        Intrinsics.checkNotNullExpressionValue(batchInfo, "batchInfo");
        return GroupAlbumUploadTaskBatchInfo.copy$default(batchInfo, null, null, null, 7, null);
    }

    public final GroupAlbumUploadTaskBatchInfo b(long batchId, Map<String, Boolean> resultBoolMap, Map<String, QZoneBaseMeta$StMedia> resultMap) {
        GroupAlbumUploadTaskBatchInfo groupAlbumUploadTaskBatchInfo;
        int mapCapacity;
        RFWLog.i("GroupAlbumUploadTaskBatchUtil", RFWLog.USR, "appendBatchInfo, batchId:" + batchId + ", resultBoolMap:" + resultBoolMap + ", resultMap:" + resultMap);
        GroupAlbumUploadTaskGeneralInfo groupAlbumUploadTaskGeneralInfo = this.taskGeneralInfo;
        if (groupAlbumUploadTaskGeneralInfo == null) {
            Intrinsics.throwUninitializedPropertyAccessException("taskGeneralInfo");
            groupAlbumUploadTaskGeneralInfo = null;
        }
        GroupAlbumUploadTaskBatchInfo groupAlbumUploadTaskBatchInfo2 = groupAlbumUploadTaskGeneralInfo.getBatchInfoMap().get(Long.valueOf(batchId));
        if (groupAlbumUploadTaskBatchInfo2 != null) {
            if (resultBoolMap != null) {
                groupAlbumUploadTaskBatchInfo2.getUploadResultBoolMap().putAll(resultBoolMap);
            }
            if (resultMap != null) {
                ConcurrentHashMap<String, GroupAlbumUploadMediaResult> uploadResultMap = groupAlbumUploadTaskBatchInfo2.getUploadResultMap();
                mapCapacity = MapsKt__MapsJVMKt.mapCapacity(resultMap.size());
                LinkedHashMap linkedHashMap = new LinkedHashMap(mapCapacity);
                Iterator<T> it = resultMap.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry entry = (Map.Entry) it.next();
                    linkedHashMap.put(entry.getKey(), GroupAlbumUploadMediaResult.INSTANCE.a((QZoneBaseMeta$StMedia) entry.getValue()));
                }
                uploadResultMap.putAll(linkedHashMap);
            }
            groupAlbumUploadTaskBatchInfo = groupAlbumUploadTaskBatchInfo2;
        } else {
            groupAlbumUploadTaskBatchInfo = null;
        }
        RFWLog.i("GroupAlbumUploadTaskBatchUtil", RFWLog.USR, "appendBatchInfo, batchInfo:" + groupAlbumUploadTaskBatchInfo);
        if (groupAlbumUploadTaskBatchInfo == null) {
            return null;
        }
        g();
        return GroupAlbumUploadTaskBatchInfo.copy$default(groupAlbumUploadTaskBatchInfo, null, null, null, 7, null);
    }

    public final void c(GroupAlbumUploadTaskBatchInfo batchInfo) {
        Intrinsics.checkNotNullParameter(batchInfo, "batchInfo");
        RFWLog.i("GroupAlbumUploadTaskBatchUtil", RFWLog.USR, "checkRemoveBatchInfo, batchInfo:" + batchInfo);
        int size = batchInfo.getUploadParams().getLocalMediaList().size();
        ConcurrentHashMap<String, Boolean> uploadResultBoolMap = batchInfo.getUploadResultBoolMap();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, Boolean> entry : uploadResultBoolMap.entrySet()) {
            if (entry.getValue().booleanValue()) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        int size2 = linkedHashMap.size();
        ConcurrentHashMap<String, Boolean> uploadResultBoolMap2 = batchInfo.getUploadResultBoolMap();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        Iterator<Map.Entry<String, Boolean>> it = uploadResultBoolMap2.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Map.Entry<String, Boolean> next = it.next();
            if (true ^ next.getValue().booleanValue()) {
                linkedHashMap2.put(next.getKey(), next.getValue());
            }
        }
        int size3 = linkedHashMap2.size();
        RFWLog.i("GroupAlbumUploadTaskBatchUtil", RFWLog.USR, "checkRemoveBatchInfo, batchId:" + batchInfo.getUploadParams().getBatchId() + ", totalCount:" + size + ", succeedCount:" + size2 + ", failedCount:" + size3);
        if (size == 0) {
            d(batchInfo.getUploadParams().getBatchId());
        }
        if (size2 == size) {
            SimpleEventBus.getInstance().dispatchEvent(new GroupAlbumUploadAlbumEvent(batchInfo.getUploadParams().getGroupId(), batchInfo.getUploadParams().getAlbumInfo().getAlbumId(), batchInfo.getUploadParams().getBatchId(), size2, batchInfo.getUploadParams().getClientKey()));
            d(batchInfo.getUploadParams().getBatchId());
        }
    }

    public final void d(long batchId) {
        RFWLog.i("GroupAlbumUploadTaskBatchUtil", RFWLog.USR, "removeBatchInfo, batchId:" + batchId);
        GroupAlbumUploadTaskGeneralInfo groupAlbumUploadTaskGeneralInfo = this.taskGeneralInfo;
        if (groupAlbumUploadTaskGeneralInfo == null) {
            Intrinsics.throwUninitializedPropertyAccessException("taskGeneralInfo");
            groupAlbumUploadTaskGeneralInfo = null;
        }
        groupAlbumUploadTaskGeneralInfo.getBatchInfoMap().remove(Long.valueOf(batchId));
        g();
    }

    public final GroupAlbumUploadTaskBatchInfo f(long batchId, List<String> originalPathList) {
        GroupAlbumUploadTaskBatchInfo groupAlbumUploadTaskBatchInfo;
        Set set;
        Intrinsics.checkNotNullParameter(originalPathList, "originalPathList");
        RFWLog.i("GroupAlbumUploadTaskBatchUtil", RFWLog.USR, "subtractBatchInfo, batchId:" + batchId + ", originalPathList:" + originalPathList);
        GroupAlbumUploadTaskGeneralInfo groupAlbumUploadTaskGeneralInfo = this.taskGeneralInfo;
        if (groupAlbumUploadTaskGeneralInfo == null) {
            Intrinsics.throwUninitializedPropertyAccessException("taskGeneralInfo");
            groupAlbumUploadTaskGeneralInfo = null;
        }
        GroupAlbumUploadTaskBatchInfo groupAlbumUploadTaskBatchInfo2 = groupAlbumUploadTaskGeneralInfo.getBatchInfoMap().get(Long.valueOf(batchId));
        if (groupAlbumUploadTaskBatchInfo2 != null) {
            CopyOnWriteArrayList<CommonAlbumUploadMediaInfo> localMediaList = groupAlbumUploadTaskBatchInfo2.getUploadParams().getLocalMediaList();
            ArrayList arrayList = new ArrayList();
            for (Object obj : localMediaList) {
                if (originalPathList.contains(((CommonAlbumUploadMediaInfo) obj).getOriginalPath())) {
                    arrayList.add(obj);
                }
            }
            set = CollectionsKt___CollectionsKt.toSet(arrayList);
            localMediaList.removeAll(set);
            for (String str : originalPathList) {
                groupAlbumUploadTaskBatchInfo2.getUploadResultBoolMap().remove(str);
                groupAlbumUploadTaskBatchInfo2.getUploadResultMap().remove(str);
            }
            groupAlbumUploadTaskBatchInfo = groupAlbumUploadTaskBatchInfo2;
        } else {
            groupAlbumUploadTaskBatchInfo = null;
        }
        RFWLog.i("GroupAlbumUploadTaskBatchUtil", RFWLog.USR, "subtractBatchInfo, batchInfo:" + groupAlbumUploadTaskBatchInfo);
        if (groupAlbumUploadTaskBatchInfo == null) {
            return null;
        }
        g();
        return GroupAlbumUploadTaskBatchInfo.copy$default(groupAlbumUploadTaskBatchInfo, null, null, null, 7, null);
    }
}
