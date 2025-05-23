package uk3;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.zplan.api.IZPlanMMKVApi;
import com.tencent.mobileqq.zplan.model.AccessibleDetail;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0006\u001a\u00020\u0004J>\u0010\f\u001a:\u0012\u0004\u0012\u00020\b\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\n0\t\u0018\u00010\u0007j\u001c\u0012\u0004\u0012\u00020\b\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\n0\t\u0018\u0001`\u000bR\u0016\u0010\u000f\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Luk3/a;", "", "", "accessibleStr", "", "b", "c", "Ljava/util/HashMap;", "", "", "Lcom/tencent/mobileqq/zplan/model/AccessibleDetail;", "Lkotlin/collections/HashMap;", "a", "", "Z", "hasInit", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f439108a = new a();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static boolean hasInit;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002<\u00128\u00126\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050\u00040\u0002j\u001a\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050\u0004`\u00060\u0001\u00a8\u0006\u0007"}, d2 = {"uk3/a$a", "Lcom/google/gson/reflect/TypeToken;", "Ljava/util/HashMap;", "", "", "Lcom/tencent/mobileqq/zplan/model/AccessibleDetail;", "Lkotlin/collections/HashMap;", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: uk3.a$a, reason: collision with other inner class name */
    /* loaded from: classes36.dex */
    public static final class C11357a extends TypeToken<HashMap<Long, Map<Long, AccessibleDetail>>> {
        C11357a() {
        }
    }

    a() {
    }

    private final void b(String accessibleStr) {
        QLog.i("AccessibleDetailDiskCache", 1, "zplan_accessible_detail saveToDisk size:" + accessibleStr.length());
        ((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).setString("zplan_accessible_detail", accessibleStr);
    }

    public final synchronized HashMap<Long, Map<Long, AccessibleDetail>> a() {
        HashMap<Long, Map<Long, AccessibleDetail>> hashMap;
        hasInit = true;
        String string = ((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).getString("zplan_accessible_detail", "");
        QLog.i("AccessibleDetailDiskCache", 2, "accessible config string : " + string);
        try {
            hashMap = (HashMap) new Gson().fromJson(string, new C11357a().getType());
        } catch (Exception e16) {
            QLog.e("AccessibleDetailDiskCache", 2, "getAccessibleDetail error " + e16.getMessage());
            b("");
            hashMap = null;
        }
        return hashMap;
    }

    public final void c() {
        if (!hasInit) {
            b.f439110a.d(a());
        }
        String accessibleStr = new Gson().toJson(b.f439110a.a());
        Intrinsics.checkNotNullExpressionValue(accessibleStr, "accessibleStr");
        b(accessibleStr);
    }
}
