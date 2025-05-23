package w4;

import NS_MOBILE_FEEDS.s_picdata;
import NS_MOBILE_QUN.Album;
import NS_MOBILE_QUN.qun_get_batch_photo_rsp;
import NS_MOBILE_QUN.qun_get_time_rsp;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.qzone.album.protocol.QZoneQueryServerTimeRequest;
import com.qzone.album.qun.business.protocol.QZoneQunBatchPhotoRequest;
import com.qzone.common.account.LoginData;
import com.qzone.common.business.IQZoneServiceListener;
import com.qzone.common.business.QZoneBusinessLooper;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.common.business.service.e;
import com.qzone.common.business.task.QZoneTask;
import com.qzone.common.event.Event;
import com.qzone.common.event.EventCenter;
import com.qzone.common.event.IObserver;
import com.qzone.common.event.Observable;
import com.qzone.component.cache.database.DbCacheManager;
import com.qzone.component.cache.database.c;
import com.qzone.util.al;
import com.qzone.util.image.ImageInfo;
import com.qzone.util.image.NetImageInfo;
import common.config.service.QzoneConfig;
import cooperation.qzone.model.BusinessAlbumInfo;
import cooperation.qzone.util.NetworkState;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import n7.a;

/* compiled from: P */
/* loaded from: classes36.dex */
public class a extends Observable implements IQZoneServiceListener, IObserver.background {
    static final String C = "w4.a";
    private static final al<a, Void> D = new C11458a();

    /* renamed from: d, reason: collision with root package name */
    private HashMap<String, String> f444548d;

    /* renamed from: e, reason: collision with root package name */
    private HashMap<String, String> f444549e;

    /* renamed from: f, reason: collision with root package name */
    private HashMap<String, Integer> f444550f;

    /* renamed from: h, reason: collision with root package name */
    private HashMap<String, Integer> f444551h;

    /* renamed from: i, reason: collision with root package name */
    private final b f444552i;

    /* renamed from: m, reason: collision with root package name */
    private final b f444553m;

    /* compiled from: P */
    /* renamed from: w4.a$a, reason: collision with other inner class name */
    /* loaded from: classes36.dex */
    class C11458a extends al<a, Void> {
        C11458a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.qzone.util.al
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public a a(Void r16) {
            return new a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes36.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        long f444554a;

        /* renamed from: b, reason: collision with root package name */
        DbCacheManager f444555b;

        /* renamed from: c, reason: collision with root package name */
        String f444556c;

        /* renamed from: d, reason: collision with root package name */
        Class<? extends com.qzone.component.cache.database.a> f444557d;

        /* renamed from: e, reason: collision with root package name */
        a.InterfaceC10828a f444558e = new C11459a();

        /* compiled from: P */
        /* renamed from: w4.a$b$a, reason: collision with other inner class name */
        /* loaded from: classes36.dex */
        class C11459a implements a.InterfaceC10828a {
            C11459a() {
            }

            @Override // n7.a.InterfaceC10828a
            public void onClosed(n7.a aVar) {
                if (QZLog.isDevelopLevel()) {
                    QZLog.d("DbCacheDatabase.CacheManager", 4, "DbCacheManager onClosed QZoneQunAlbumService table:" + b.this.f444556c);
                }
                b bVar = b.this;
                bVar.f444554a = 0L;
                bVar.f444555b = null;
            }
        }

        public b(String str, Class<? extends com.qzone.component.cache.database.a> cls) {
            this.f444556c = str;
            this.f444557d = cls;
        }
    }

    a() {
        super(QzoneConfig.SECONDARY_QUN_ALBUM_URL);
        this.f444548d = new HashMap<>();
        this.f444549e = new HashMap<>();
        this.f444550f = new HashMap<>();
        this.f444551h = new HashMap<>();
        this.f444552i = new b("TABLE_QUN_ALBUMLIST", v4.a.class);
        this.f444553m = new b("TABLE_QUN_PHOTO", v4.b.class);
        C();
    }

    private void C() {
        EventCenter.getInstance().addObserver(this, 3, "WriteOperation", 24, 29, 30, 31);
    }

    private void F(String str, String str2) {
        DbCacheManager J;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || (J = J()) == null) {
            return;
        }
        J.b0("qunid=? AND albumid=?", new String[]{str, str2});
    }

    private DbCacheManager J() {
        H(this.f444552i);
        return this.f444552i.f444555b;
    }

    public static a L() {
        return D.get(null);
    }

    private DbCacheManager M() {
        H(this.f444553m);
        return this.f444553m.f444555b;
    }

    private void O(String str, String str2, Album album) {
        if (QZLog.isColorLevel()) {
            QZLog.d(C, 2, "onPhotoListDataChange, qunId: " + str + "\t albumId: " + str2);
        }
        notify(2, str, str2, album);
    }

    private void T(String str, List<v4.b> list, boolean z16) {
        DbCacheManager M = M();
        if (M != null) {
            if (z16) {
                G(M, "albumid=?", new String[]{str});
            }
            if (list == null || list.isEmpty()) {
                return;
            }
            M.p0(list, 1);
        }
    }

    public void D(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        G(M(), "albumid=?", new String[]{str});
    }

    public void E(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        G(M(), "lloc=?", new String[]{str});
    }

    public v4.a I(String str, String str2) {
        DbCacheManager J;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || (J = J()) == null) {
            return null;
        }
        return (v4.a) J.k0("qunid=? AND albumid=?", new String[]{str, str2});
    }

    public void K(Handler handler, String str, String str2, String str3, int i3, String str4) {
        QZoneBusinessLooper.getInstance().runTask(new QZoneTask(new QZoneQunBatchPhotoRequest(str, str2, str3, i3, str4), handler, this, 8));
    }

    public void S(String str, Handler handler) {
        if (NetworkState.isNetSupport()) {
            QZoneTask qZoneTask = new QZoneTask(new QZoneQueryServerTimeRequest(str), handler, this, 9);
            qZoneTask.extraData.put("RequestValidBit", Boolean.TRUE);
            Message obtain = Message.obtain();
            obtain.what = 1000027;
            obtain.obj = qZoneTask;
            handler.sendMessageDelayed(obtain, 5000L);
            QZoneBusinessLooper.getInstance().runTask(qZoneTask);
            return;
        }
        handler.sendEmptyMessage(1000027);
    }

    @Override // com.qzone.common.event.IObserver.background
    public void onEventBackgroundThread(Event event) {
        if ("WriteOperation".equals(event.source.getName())) {
            Object[] objArr = (Object[]) event.params;
            int i3 = event.what;
            if (i3 != 24) {
                switch (i3) {
                    case 29:
                        String str = (String) objArr[0];
                        String str2 = (String) objArr[1];
                        ArrayList arrayList = (ArrayList) objArr[2];
                        if (arrayList != null && !arrayList.isEmpty()) {
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                E((String) it.next());
                            }
                        }
                        O(str, str2, null);
                        e.D().E();
                        return;
                    case 30:
                        Q((List) objArr[0], (String) objArr[1], (BusinessAlbumInfo) objArr[2]);
                        return;
                    case 31:
                        String str3 = (String) objArr[0];
                        String str4 = (String) objArr[1];
                        F(str3, str4);
                        D(str4);
                        e.D().E();
                        return;
                    default:
                        return;
                }
            }
            R((List) objArr[0], (String) objArr[1], (String) objArr[2], ((BusinessAlbumInfo) objArr[3]).getTitle(), (String) objArr[4]);
        }
    }

    @Override // com.qzone.common.business.IQZoneServiceListener
    public void onTaskResponse(QZoneTask qZoneTask) {
        if (QZLog.isColorLevel()) {
            QZLog.d(QZLog.TO_DEVICE_TAG, 2, C + "\t onTaskResponse() task.mType:" + qZoneTask.mType);
        }
        int i3 = qZoneTask.mType;
        if (i3 == 8) {
            N(qZoneTask);
        } else {
            if (i3 != 9) {
                return;
            }
            P(qZoneTask);
        }
    }

    protected void G(DbCacheManager dbCacheManager, String str, String[] strArr) {
        if (dbCacheManager != null) {
            dbCacheManager.b0(str, strArr);
        }
    }

    protected void Q(List<NetImageInfo> list, String str, BusinessAlbumInfo businessAlbumInfo) {
        if (list == null || list.isEmpty() || TextUtils.isEmpty(str) || businessAlbumInfo == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<NetImageInfo> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(v4.b.createFakePhoto(str, businessAlbumInfo.getId(), it.next()));
        }
        T(businessAlbumInfo.getId(), arrayList, false);
        O(str, businessAlbumInfo.getId(), null);
    }

    protected void R(List<ImageInfo> list, String str, String str2, String str3, String str4) {
        if (list == null || list.isEmpty() || TextUtils.isEmpty(str)) {
            return;
        }
        if (QZLog.isColorLevel()) {
            QZLog.d(C, 2, "receive qunUploadPic notify, size: " + list.size() + "\t qunId: " + str + "\t albumId: " + str2 + "\t albumName: " + str3);
        }
        ArrayList arrayList = new ArrayList();
        Iterator<ImageInfo> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(v4.b.createFakePhoto(str, str2, it.next()));
        }
        T(str2, arrayList, false);
        O(str, str2, null);
    }

    private void H(b bVar) {
        DbCacheManager dbCacheManager;
        if (bVar == null) {
            return;
        }
        long uin = LoginData.getInstance().getUin();
        if (uin != bVar.f444554a || (dbCacheManager = bVar.f444555b) == null || dbCacheManager.isClosed()) {
            bVar.f444554a = uin;
            DbCacheManager e16 = c.g().e(bVar.f444557d, uin, bVar.f444556c);
            bVar.f444555b = e16;
            e16.U(bVar.f444558e);
        }
    }

    private void N(QZoneTask qZoneTask) {
        ArrayList<s_picdata> arrayList;
        QZoneResult result = qZoneTask.getResult(1000026);
        qun_get_batch_photo_rsp qun_get_batch_photo_rspVar = (qun_get_batch_photo_rsp) qZoneTask.mRequest.rsp;
        if (qun_get_batch_photo_rspVar != null && (arrayList = qun_get_batch_photo_rspVar.photolist) != null) {
            int size = arrayList.size();
            ArrayList arrayList2 = new ArrayList();
            for (int i3 = 0; i3 < size; i3++) {
                s_picdata s_picdataVar = qun_get_batch_photo_rspVar.photolist.get(i3);
                if (s_picdataVar != null) {
                    v4.b createFromResponse = v4.b.createFromResponse(s_picdataVar);
                    createFromResponse.albumid = qun_get_batch_photo_rspVar.albuminfo.albumid;
                    arrayList2.add(createFromResponse);
                }
            }
            result.setData(arrayList2);
        }
        qZoneTask.sendResultMsg(result);
    }

    private void P(QZoneTask qZoneTask) {
        QZoneResult result = qZoneTask.getResult(1000027);
        qun_get_time_rsp response = ((QZoneQueryServerTimeRequest) qZoneTask.mRequest).getResponse();
        if (response != null) {
            result.setData(Long.valueOf(response.server_time));
            result.setSucceed(true);
        }
        Boolean bool = (Boolean) qZoneTask.extraData.get("RequestValidBit");
        if (bool == null || bool.booleanValue()) {
            qZoneTask.sendResultMsg(result);
        }
    }
}
