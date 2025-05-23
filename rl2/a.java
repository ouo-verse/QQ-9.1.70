package rl2;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.preload.IPreloadImgApi;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016\u00a8\u0006\t"}, d2 = {"Lrl2/a;", "Lrl2/e;", "", "", "d", "", "a", "<init>", "()V", "qqpay-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class a extends e {
    @Override // rl2.e
    public void a() {
        try {
            ((IPreloadImgApi) QRoute.api(IPreloadImgApi.class)).onDestory();
            super.a();
        } catch (Exception e16) {
            QLog.e("StorageManagement", 1, "clearPreloadFile error", e16);
        }
    }

    @Override // rl2.e
    @NotNull
    public List<String> d() {
        List<String> listOf;
        d dVar = d.f431658a;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{dVar.h() + com.tencent.mobileqq.base.a.c() + "/.preloaduni/", dVar.h() + ".preloaduni/", dVar.j() + ".preloaduni/"});
        return listOf;
    }
}
