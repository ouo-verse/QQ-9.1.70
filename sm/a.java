package sm;

import com.qzone.reborn.publish.QZoneFakeFeedDbEntity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.transaction.PersistTransaction;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes36.dex */
public class a {

    /* renamed from: b, reason: collision with root package name */
    private static volatile a f433957b;

    /* renamed from: a, reason: collision with root package name */
    private volatile EntityManager f433958a;

    private EntityManager b() {
        if (this.f433958a == null) {
            synchronized (a.class) {
                if (this.f433958a == null) {
                    this.f433958a = com.qzone.reborn.util.c.a();
                }
            }
        }
        return this.f433958a;
    }

    public static a c() {
        if (f433957b == null) {
            synchronized (a.class) {
                if (f433957b == null) {
                    f433957b = new a();
                }
            }
        }
        return f433957b;
    }

    public boolean a(String str, String str2) {
        EntityManager b16 = b();
        if (b16 == null) {
            QLog.e("upload2_QZoneFakeFeedDbManager", 1, "[clearDataByType] but entityManager is null");
            return false;
        }
        try {
            QLog.d("upload2_QZoneFakeFeedDbManager", 1, "[clearData] clear count: " + b16.delete(QZoneFakeFeedDbEntity.class.getSimpleName(), "spaceId=? AND clintKey=?", new String[]{str, str2}) + ",spaceId:" + str + ",clientKey:" + str2);
        } catch (Exception e16) {
            QLog.w("upload2_QZoneFakeFeedDbManager", 1, "[clearData] error: ", e16);
        }
        return true;
    }

    public boolean d(QZoneFakeFeedDbEntity qZoneFakeFeedDbEntity) {
        EntityManager b16 = b();
        if (b16 == null) {
            QLog.e("upload2_QZoneFakeFeedDbManager", 1, "[insert] but entityManager is null");
            return false;
        }
        QLog.d("upload2_QZoneFakeFeedDbManager", 1, "[insert]");
        ArrayList arrayList = new ArrayList();
        arrayList.add(new PersistTransaction(qZoneFakeFeedDbEntity));
        b16.doMultiDBOperateByTransaction(arrayList);
        return true;
    }

    public List<QZoneFakeFeedDbEntity> e() {
        List arrayList = new ArrayList();
        EntityManager b16 = b();
        if (b16 == null) {
            QLog.e("upload2_QZoneFakeFeedDbManager", 1, "[query] but entityManager is null");
            return arrayList;
        }
        try {
            arrayList = b16.query(QZoneFakeFeedDbEntity.class, false, null, null, null, null, "insertTime asc", null);
            if (arrayList == null) {
                arrayList = new ArrayList();
            }
            QLog.d("upload2_QZoneFakeFeedDbManager", 1, "[query] data size: " + arrayList.size());
        } catch (Exception e16) {
            QLog.w("upload2_QZoneFakeFeedDbManager", 1, "[query] error: ", e16);
        }
        return arrayList;
    }
}
