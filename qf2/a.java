package qf2;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.CouponH5Data;
import com.tencent.mobileqq.perf.block.DBMethodProxy;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J \u0010\n\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006J&\u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006J&\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\f\u00a8\u0006\u0013"}, d2 = {"Lqf2/a;", "", "Lcom/tencent/mobileqq/persistence/EntityManager;", "c", "Lcom/tencent/common/app/AppInterface;", "b", "", "host", "path", "key", "d", "hash", "", "e", "isDelAllHostData", "", "a", "<init>", "()V", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class a {
    private final AppInterface b() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.common.app.AppInterface");
        return (AppInterface) peekAppRuntime;
    }

    private final EntityManager c() {
        AppInterface b16 = b();
        String account = b16.getAccount();
        if (account == null || account.length() == 0) {
            return null;
        }
        EntityManagerFactory entityManagerFactory = MobileQQ.sMobileQQ.peekAppRuntime().getEntityManagerFactory(b16.getAccount());
        if (entityManagerFactory != null) {
            try {
                return entityManagerFactory.createEntityManager();
            } catch (RuntimeException e16) {
                QLog.e("QQKuiklyWebDataEntityHelper", 1, "getEntityManager error", e16);
            }
        }
        QLog.w("QQKuiklyWebDataEntityHelper", 1, "getEntityManager is null");
        return null;
    }

    public final int a(String host, String path, String key, boolean isDelAllHostData) {
        Intrinsics.checkNotNullParameter(host, "host");
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(key, "key");
        EntityManager c16 = c();
        if (c16 == null) {
            return -1;
        }
        QLog.d("QQKuiklyWebDataEntityHelper", 1, "deleteData host=" + host + " path=" + path + " key=" + key + " isDelAllHostData=" + isDelAllHostData);
        if (isDelAllHostData) {
            Entity find = DBMethodProxy.find(c16, CouponH5Data.class, "mHost = ?", new String[]{host});
            if (find != null) {
                c16.remove(find);
            }
            c16.close();
            return 0;
        }
        if (key.length() > 0) {
            Entity find2 = DBMethodProxy.find(c16, CouponH5Data.class, "mHost = ? AND mPath = ? AND mKey = ?", new String[]{host, path, key});
            if (find2 != null) {
                c16.remove(find2);
            }
            c16.close();
            return 0;
        }
        List<? extends Entity> query = c16.query(CouponH5Data.class, false, "mHost = ? AND mPath = ?", new String[]{host, path}, null, null, null, null);
        if (query != null) {
            Iterator<? extends Entity> it = query.iterator();
            while (it.hasNext()) {
                c16.remove(it.next());
            }
        }
        c16.close();
        return 0;
    }

    public final String d(String host, String path, String key) {
        Intrinsics.checkNotNullParameter(host, "host");
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(key, "key");
        EntityManager c16 = c();
        if (c16 == null) {
            return null;
        }
        Entity find = DBMethodProxy.find(c16, CouponH5Data.class, "mHost = ? AND mPath = ? AND mKey = ?", new String[]{host, path, key});
        QLog.d("QQKuiklyWebDataEntityHelper", 1, "readData entity=" + find);
        c16.close();
        if (find != null) {
            return ((CouponH5Data) find).mData;
        }
        return null;
    }

    public final boolean e(String host, String path, String key, String hash) {
        Intrinsics.checkNotNullParameter(host, "host");
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(hash, "hash");
        EntityManager c16 = c();
        if (c16 == null) {
            return false;
        }
        Entity find = DBMethodProxy.find(c16, CouponH5Data.class, "mHost = ? AND mPath = ? AND mKey = ?", new String[]{host, path, key});
        QLog.d("QQKuiklyWebDataEntityHelper", 1, "writeData entity=" + find);
        if (find == null) {
            c16.persist(new CouponH5Data(host, path, key, hash));
        } else {
            CouponH5Data couponH5Data = (CouponH5Data) find;
            couponH5Data.mData = hash;
            c16.update(couponH5Data);
        }
        c16.close();
        return true;
    }
}
