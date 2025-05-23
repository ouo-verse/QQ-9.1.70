package zh;

import android.text.TextUtils;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.queue.DownloadState;
import com.tencent.biz.richframework.queue.RFWDownloadQueue;
import com.tencent.biz.richframework.queue.RFWDownloadQueueResultListener;
import com.tencent.biz.richframework.queue.RFWDownloadQueueTaskInfo;
import com.tencent.biz.richframework.queue.RFWDownloadTaskStateData;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.NetworkState;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes36.dex */
public class b implements RFWDownloadQueueResultListener, NetworkState.NetworkStateListener {

    /* renamed from: f, reason: collision with root package name */
    private static volatile b f452538f;

    /* renamed from: d, reason: collision with root package name */
    private final HashMap<String, Set<RFWDownloadQueueResultListener>> f452539d = new HashMap<>();

    /* renamed from: e, reason: collision with root package name */
    private final HashMap<String, List<RFWDownloadTaskStateData>> f452540e = new HashMap<>();

    b() {
        RFWDownloadQueue.getInstance().addDownloadListener(j9.a.f409661a.a(), this);
    }

    public static b l() {
        if (f452538f == null) {
            synchronized (b.class) {
                f452538f = new b();
            }
        }
        return f452538f;
    }

    public void c(String str) {
        RFWDownloadQueue.getInstance().cancelTask(j9.a.f409661a.a(), str);
    }

    public void d(String str) {
        List<RFWDownloadTaskStateData> list = this.f452540e.get(str);
        if (list == null) {
            return;
        }
        Iterator<RFWDownloadTaskStateData> it = list.iterator();
        while (it.hasNext()) {
            RFWDownloadQueue.getInstance().continueTask(j9.a.f409661a.a(), it.next().getUrl());
        }
    }

    public void e(String str) {
        RFWDownloadQueue.getInstance().continueTask(j9.a.f409661a.a(), str);
    }

    public List<RFWDownloadTaskStateData> f(String str) {
        List<RFWDownloadTaskStateData> list = this.f452540e.get(str);
        return list != null ? list : new ArrayList();
    }

    public int g(String str) {
        List<RFWDownloadTaskStateData> list = this.f452540e.get(str);
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public long h(String str) {
        List<RFWDownloadTaskStateData> list = this.f452540e.get(str);
        long j3 = 0;
        if (list == null) {
            return 0L;
        }
        for (RFWDownloadTaskStateData rFWDownloadTaskStateData : list) {
            if (rFWDownloadTaskStateData.getTaskGenerateTime() > j3) {
                j3 = rFWDownloadTaskStateData.getTaskGenerateTime();
            }
        }
        return j3;
    }

    public boolean j(String str) {
        List<RFWDownloadTaskStateData> list = this.f452540e.get(str);
        if (list == null) {
            return false;
        }
        for (RFWDownloadTaskStateData rFWDownloadTaskStateData : list) {
            if (rFWDownloadTaskStateData.getState() == DownloadState.STATE_START_RUN || rFWDownloadTaskStateData.getState() == DownloadState.STATE_RUNNING) {
                return true;
            }
        }
        return false;
    }

    public boolean k(String str) {
        List<RFWDownloadTaskStateData> list = this.f452540e.get(str);
        if (list == null) {
            return false;
        }
        Iterator<RFWDownloadTaskStateData> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().getState() == DownloadState.STATE_WAITING) {
                return true;
            }
        }
        return false;
    }

    public void o() {
        RFWDownloadQueue.getInstance().cancelBizAllTask(j9.a.f409661a.a());
        this.f452539d.clear();
        this.f452540e.clear();
    }

    public void p(String str) {
        RFWDownloadQueue.getInstance().pauseTask(j9.a.f409661a.a(), str);
    }

    public void q(final String str, final RFWDownloadQueue.QueryBizTaskStateCallback queryBizTaskStateCallback) {
        RFWDownloadQueue.getInstance().queryBizTaskStateList(j9.a.f409661a.a(), new RFWDownloadQueue.QueryBizTaskStateCallback() { // from class: zh.a
            @Override // com.tencent.biz.richframework.queue.RFWDownloadQueue.QueryBizTaskStateCallback
            public final void onTaskListRsp(List list) {
                b.this.n(queryBizTaskStateCallback, str, list);
            }
        });
    }

    public void r(String str, RFWDownloadQueueResultListener rFWDownloadQueueResultListener) {
        if (TextUtils.isEmpty(str) || rFWDownloadQueueResultListener == null) {
            return;
        }
        Set<RFWDownloadQueueResultListener> set = this.f452539d.get(str);
        if (set == null) {
            set = new HashSet<>();
            this.f452539d.put(str, set);
        }
        set.add(rFWDownloadQueueResultListener);
    }

    public void b(RFWDownloadQueueTaskInfo rFWDownloadQueueTaskInfo) {
        if (rFWDownloadQueueTaskInfo == null) {
            QLog.e("GroupAlbumAlbumDownloadManager", 1, "[addDownloadTask]  taskInfo == null");
        } else if (rFWDownloadQueueTaskInfo.getExtMap() != null && !TextUtils.isEmpty(i(rFWDownloadQueueTaskInfo.getExtMap()))) {
            RFWDownloadQueue.getInstance().addTask(j9.a.f409661a.a(), rFWDownloadQueueTaskInfo);
        } else {
            QLog.e("GroupAlbumAlbumDownloadManager", 1, "[addDownloadTask]  no add groupId");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public void n(RFWDownloadQueue.QueryBizTaskStateCallback queryBizTaskStateCallback, List<RFWDownloadTaskStateData> list, String str) {
        if (list != null) {
            for (RFWDownloadTaskStateData rFWDownloadTaskStateData : list) {
                String i3 = i(rFWDownloadTaskStateData.getExtMap());
                List<RFWDownloadTaskStateData> list2 = this.f452540e.get(i3);
                if (list2 == null) {
                    list2 = new ArrayList<>();
                    this.f452540e.put(i3, list2);
                }
                ListIterator<RFWDownloadTaskStateData> listIterator = list2.listIterator();
                while (true) {
                    if (listIterator.hasNext()) {
                        if (TextUtils.equals(rFWDownloadTaskStateData.getUrl(), listIterator.next().getUrl())) {
                            listIterator.remove();
                            break;
                        }
                    }
                }
                list2.add(rFWDownloadTaskStateData);
            }
        }
        List<RFWDownloadTaskStateData> list3 = this.f452540e.get(str);
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[handleQueryBizTaskStateList] | querySpaceId = ");
        sb5.append(str);
        sb5.append(" | list = ");
        sb5.append(list3 != null ? list3.size() : 0);
        sb5.append(" | allSize = ");
        sb5.append(this.f452540e.values().size());
        QLog.i("GroupAlbumAlbumDownloadManager", 1, sb5.toString());
        if (queryBizTaskStateCallback == null || TextUtils.isEmpty(str)) {
            return;
        }
        queryBizTaskStateCallback.onTaskListRsp(list3);
    }

    @Override // com.tencent.biz.richframework.queue.RFWDownloadQueueResultListener
    public void onStateChange(RFWDownloadTaskStateData rFWDownloadTaskStateData) {
        if (rFWDownloadTaskStateData == null || !TextUtils.equals(rFWDownloadTaskStateData.getBusinessKey(), j9.a.f409661a.a().getBusinessKey())) {
            return;
        }
        String i3 = i(rFWDownloadTaskStateData.getExtMap());
        List<RFWDownloadTaskStateData> list = this.f452540e.get(i3);
        if (list == null) {
            list = new ArrayList<>();
            this.f452540e.put(i3, list);
        }
        ListIterator<RFWDownloadTaskStateData> listIterator = list.listIterator();
        while (true) {
            if (!listIterator.hasNext()) {
                break;
            }
            if (TextUtils.equals(rFWDownloadTaskStateData.getUrl(), listIterator.next().getUrl())) {
                listIterator.remove();
                break;
            }
        }
        if (rFWDownloadTaskStateData.getState() != DownloadState.STATE_SUCCESS && rFWDownloadTaskStateData.getState() != DownloadState.STATE_CANCEL) {
            list.add(rFWDownloadTaskStateData);
        }
        Set<RFWDownloadQueueResultListener> set = this.f452539d.get(i3);
        if (set != null) {
            Iterator<RFWDownloadQueueResultListener> it = set.iterator();
            while (it.hasNext()) {
                it.next().onStateChange(rFWDownloadTaskStateData);
            }
        }
    }

    public void s(String str, RFWDownloadQueueResultListener rFWDownloadQueueResultListener) {
        if (rFWDownloadQueueResultListener == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            RFWLog.e("GroupAlbumAlbumDownloadManager", RFWLog.USR, "unregisterDownloadListener spaceId is null");
            Iterator<Map.Entry<String, Set<RFWDownloadQueueResultListener>>> it = this.f452539d.entrySet().iterator();
            while (it.hasNext()) {
                Set<RFWDownloadQueueResultListener> value = it.next().getValue();
                if (value != null) {
                    value.remove(rFWDownloadQueueResultListener);
                }
            }
            return;
        }
        Set<RFWDownloadQueueResultListener> set = this.f452539d.get(str);
        if (set == null) {
            return;
        }
        set.remove(rFWDownloadQueueResultListener);
    }

    private String i(HashMap<String, String> hashMap) {
        if (hashMap == null) {
            return null;
        }
        return hashMap.get("ext_key_space_id");
    }

    @Override // cooperation.qzone.util.NetworkState.NetworkStateListener
    public void onNetworkConnect(boolean z16) {
    }
}
