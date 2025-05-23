package uc3;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.zootopia.api.e;
import com.tencent.mobileqq.zootopia.g;
import com.tencent.qphone.base.util.QLog;
import hw4.j;
import hw4.l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016Jo\u0010\u0014\u001a\u00020\u00122\u0016\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n2M\u0010\u0013\u001aI\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0010\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00120\fH\u0016J\u0080\u0001\u0010\u0016\u001a\u00020\u00122v\u0010\u0013\u001ar\u0012'\u0012%\u0012\u0004\u0012\u00020\t\u0018\u00010\bj\n\u0012\u0004\u0012\u00020\t\u0018\u0001`\n\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0010\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00120\u0015H\u0016J\b\u0010\u0017\u001a\u00020\u0002H\u0016Jo\u0010\u0018\u001a\u00020\u00122\u0016\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n2M\u0010\u0013\u001aI\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0010\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00120\fH\u0016J\b\u0010\u0019\u001a\u00020\u0012H\u0016\u00a8\u0006\u001c"}, d2 = {"Luc3/b;", "Luc3/a;", "", "getTitle", "f", "", "size", "g", "Ljava/util/ArrayList;", "Lhw4/j;", "Lkotlin/collections/ArrayList;", "list", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "status", "errCode", "errMsg", "", "callback", "a", "Lkotlin/Function4;", "d", "e", "b", "c", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class b implements a {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"uc3/b$b", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lhw4/e;", "result", "", "a", "", "error", "", "message", "onResultFailure", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: uc3.b$b, reason: collision with other inner class name */
    /* loaded from: classes36.dex */
    public static final class C11338b implements e<hw4.e> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Function3<Integer, Integer, String, Unit> f438791d;

        /* JADX WARN: Multi-variable type inference failed */
        C11338b(Function3<? super Integer, ? super Integer, ? super String, Unit> function3) {
            this.f438791d = function3;
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(hw4.e result) {
            Intrinsics.checkNotNullParameter(result, "result");
            this.f438791d.invoke(1, 0, null);
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            this.f438791d.invoke(2, Integer.valueOf(error), message);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"uc3/b$c", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lhw4/l;", "result", "", "a", "", "error", "", "message", "onResultFailure", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes36.dex */
    public static final class c implements e<l> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Function4<ArrayList<j>, Integer, Integer, String, Unit> f438792d;

        /* JADX WARN: Multi-variable type inference failed */
        c(Function4<? super ArrayList<j>, ? super Integer, ? super Integer, ? super String, Unit> function4) {
            this.f438792d = function4;
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(l result) {
            List filterNotNull;
            Intrinsics.checkNotNullParameter(result, "result");
            Function4<ArrayList<j>, Integer, Integer, String, Unit> function4 = this.f438792d;
            j[] jVarArr = result.f406530a;
            Intrinsics.checkNotNullExpressionValue(jVarArr, "result.blacklist");
            filterNotNull = ArraysKt___ArraysKt.filterNotNull(jVarArr);
            function4.invoke(new ArrayList<>(filterNotNull), 1, 0, null);
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            this.f438792d.invoke(null, 2, Integer.valueOf(error), message);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"uc3/b$d", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lhw4/a;", "result", "", "a", "", "error", "", "message", "onResultFailure", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes36.dex */
    public static final class d implements e<hw4.a> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Function3<Integer, Integer, String, Unit> f438793d;

        /* JADX WARN: Multi-variable type inference failed */
        d(Function3<? super Integer, ? super Integer, ? super String, Unit> function3) {
            this.f438793d = function3;
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(hw4.a result) {
            Intrinsics.checkNotNullParameter(result, "result");
            this.f438793d.invoke(Integer.valueOf(result.f406515a), 0, null);
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            this.f438793d.invoke(2, Integer.valueOf(error), message);
        }
    }

    public b() {
        com.tencent.mobileqq.zplan.report.c cVar = com.tencent.mobileqq.zplan.report.c.f335070a;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("pgid", "pg_zplan_xiaowo_permit");
        linkedHashMap.put("dt_pgid", "pg_zplan_xiaowo_permit");
        linkedHashMap.put("eid", "em_zplan_xiaowo_permit_blacklist_add");
        Unit unit = Unit.INSTANCE;
        cVar.a("imp", linkedHashMap);
    }

    @Override // uc3.a
    public void a(ArrayList<j> list, Function3<? super Integer, ? super Integer, ? super String, Unit> callback) {
        int collectionSizeOrDefault;
        Intrinsics.checkNotNullParameter(list, "list");
        Intrinsics.checkNotNullParameter(callback, "callback");
        DefaultConstructorMarker defaultConstructorMarker = null;
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        AppInterface appInterface = waitAppRuntime instanceof AppInterface ? (AppInterface) waitAppRuntime : null;
        int i3 = 1;
        if (appInterface != null) {
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(Long.valueOf(((j) it.next()).f406525a));
            }
            new com.tencent.mobileqq.zootopia.service.j(0, i3, defaultConstructorMarker).a(appInterface, arrayList, new d(callback));
            return;
        }
        QLog.e("SmallHomeBlackListScene", 1, "handleAdd app is null");
        callback.invoke(2, -999, null);
    }

    @Override // uc3.a
    public void b(ArrayList<j> list, Function3<? super Integer, ? super Integer, ? super String, Unit> callback) {
        int collectionSizeOrDefault;
        Intrinsics.checkNotNullParameter(list, "list");
        Intrinsics.checkNotNullParameter(callback, "callback");
        DefaultConstructorMarker defaultConstructorMarker = null;
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        AppInterface appInterface = waitAppRuntime instanceof AppInterface ? (AppInterface) waitAppRuntime : null;
        int i3 = 1;
        if (appInterface != null) {
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(Long.valueOf(((j) it.next()).f406525a));
            }
            new com.tencent.mobileqq.zootopia.service.j(0, i3, defaultConstructorMarker).c(appInterface, arrayList, new C11338b(callback));
            return;
        }
        QLog.e("SmallHomeBlackListScene", 1, "deleteFriend app is null");
        callback.invoke(2, -999, null);
    }

    @Override // uc3.a
    public void c() {
        com.tencent.mobileqq.zplan.report.c cVar = com.tencent.mobileqq.zplan.report.c.f335070a;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("pgid", "pg_zplan_xiaowo_permit");
        linkedHashMap.put("dt_pgid", "pg_zplan_xiaowo_permit");
        linkedHashMap.put("eid", "em_zplan_xiaowo_permit_blacklist_add");
        Unit unit = Unit.INSTANCE;
        cVar.a("clck", linkedHashMap);
    }

    @Override // uc3.a
    public void d(Function4<? super ArrayList<j>, ? super Integer, ? super Integer, ? super String, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        DefaultConstructorMarker defaultConstructorMarker = null;
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        AppInterface appInterface = waitAppRuntime instanceof AppInterface ? (AppInterface) waitAppRuntime : null;
        int i3 = 1;
        if (appInterface == null) {
            QLog.e("SmallHomeBlackListScene", 1, "getBlackList app is null");
            callback.invoke(null, 2, -999, null);
        } else {
            com.tencent.mobileqq.zootopia.service.j.h(new com.tencent.mobileqq.zootopia.service.j(0, i3, defaultConstructorMarker), appInterface, 0, g.f328305a.b(), new c(callback), 2, null);
        }
    }

    @Override // uc3.a
    public String e() {
        return "\u5c06\u597d\u53cb\u79fb\u9664\u51fa\u9ed1\u540d\u5355";
    }

    @Override // uc3.a
    public String f() {
        return "\u8bbe\u7f6e\u9ed1\u540d\u5355";
    }

    @Override // uc3.a
    public String g(int size) {
        return "\u9009\u4e2d\u7684\u4eba\u4e0d\u53ef\u4ee5\u8fdb\u5165\u4f60\u7684\u5c0f\u7a9d";
    }

    @Override // uc3.a
    public String getTitle() {
        return "\u8fdb\u5165\u9ed1\u540d\u5355";
    }
}
