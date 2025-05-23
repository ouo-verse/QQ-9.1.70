package ue3;

import com.tencent.mobileqq.zplan.api.UECacheData;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u00012\u00020\u0002J\b\u0010\u0004\u001a\u00020\u0003H&J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H&J\b\u0010\n\u001a\u00020\u0003H&\u00a8\u0006\u000b"}, d2 = {"Lue3/b;", "Lue3/a;", "Lvb3/b;", "", "refreshCache", "", "cacheKey", "Lcom/tencent/mobileqq/zplan/api/UECacheData;", "cacheData", "V", "doWhenQQLogout", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public interface b extends a, vb3.b {
    void V(String cacheKey, UECacheData cacheData);

    void doWhenQQLogout();

    void refreshCache();
}
