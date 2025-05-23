package zj3;

import android.text.TextUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.zplan.api.IZPlanMMKVApi;
import com.tencent.raft.standard.storage.IRStorage;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.aspectj.lang.JoinPoint;
import zj3.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \"2\u00020\u0001:\u0001\u0016B\u001b\u0012\u0006\u0010\u0018\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0019\u00a2\u0006\u0004\b \u0010!J\u0019\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0002H\u0016\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\t\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u001a\u0010\n\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u0003H\u0016J\u0012\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0006\u001a\u00020\u0003H\u0016J\u0018\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0007H\u0016J\u001a\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u0003H\u0016J\u001a\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u000bH\u0016J\u0010\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u0003H\u0016J\b\u0010\u0013\u001a\u00020\u000eH\u0016J\b\u0010\u0014\u001a\u00020\u000eH\u0016J\b\u0010\u0015\u001a\u00020\u000eH\u0016R\u0014\u0010\u0018\u001a\u00020\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001f\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001e\u00a8\u0006#"}, d2 = {"Lzj3/f;", "Lcom/tencent/raft/standard/storage/IRStorage;", "", "", "allKeys", "()[Ljava/lang/String;", "key", "", "defValue", "getLong", "getString", "", "getByteArray", "value", "", "putLong", "putString", "putByteArray", "remove", "trim", JoinPoint.SYNCHRONIZATION_LOCK, JoinPoint.SYNCHRONIZATION_UNLOCK, "a", "Ljava/lang/String;", "keyPrefix", "Lzj3/a$a;", "b", "Lzj3/a$a;", "Lcom/tencent/mobileqq/zplan/api/IZPlanMMKVApi;", "c", "Lcom/tencent/mobileqq/zplan/api/IZPlanMMKVApi;", "zplanMMKVApi", "<init>", "(Ljava/lang/String;Lzj3/a$a;)V", "d", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class f implements IRStorage {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String keyPrefix;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final a.C11686a lock;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final IZPlanMMKVApi zplanMMKVApi;

    public f(String keyPrefix, a.C11686a c11686a) {
        Intrinsics.checkNotNullParameter(keyPrefix, "keyPrefix");
        this.keyPrefix = keyPrefix;
        this.lock = c11686a;
        QRouteApi api = QRoute.api(IZPlanMMKVApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IZPlanMMKVApi::class.java)");
        this.zplanMMKVApi = (IZPlanMMKVApi) api;
    }

    @Override // com.tencent.raft.standard.storage.IRStorage
    public String[] allKeys() {
        boolean startsWith$default;
        String[] allKeyArr = this.zplanMMKVApi.edit().allKeyArr();
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(this.keyPrefix)) {
            if (allKeyArr != null) {
                CollectionsKt__MutableCollectionsKt.addAll(arrayList, allKeyArr);
            }
        } else if (allKeyArr != null) {
            ArrayList<String> arrayList2 = new ArrayList();
            for (String it : allKeyArr) {
                Intrinsics.checkNotNullExpressionValue(it, "it");
                startsWith$default = StringsKt__StringsJVMKt.startsWith$default(it, this.keyPrefix, false, 2, null);
                if (startsWith$default) {
                    arrayList2.add(it);
                }
            }
            for (String it5 : arrayList2) {
                if (it5.length() >= this.keyPrefix.length() + 1) {
                    Intrinsics.checkNotNullExpressionValue(it5, "it");
                    String substring = it5.substring(this.keyPrefix.length() + 1);
                    Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
                    arrayList.add(substring);
                }
            }
        }
        Object[] array = arrayList.toArray(new String[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return (String[]) array;
    }

    @Override // com.tencent.raft.standard.storage.IRStorage
    public /* synthetic */ void clear() {
        hz3.a.a(this);
    }

    @Override // com.tencent.raft.standard.storage.IRStorage
    public byte[] getByteArray(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        IZPlanMMKVApi iZPlanMMKVApi = this.zplanMMKVApi;
        if (!TextUtils.isEmpty(this.keyPrefix)) {
            key = this.keyPrefix + "_" + key;
        }
        return iZPlanMMKVApi.getBytes(key, new byte[0]);
    }

    @Override // com.tencent.raft.standard.storage.IRStorage
    public long getLong(String key, long defValue) {
        Intrinsics.checkNotNullParameter(key, "key");
        IZPlanMMKVApi iZPlanMMKVApi = this.zplanMMKVApi;
        if (!TextUtils.isEmpty(this.keyPrefix)) {
            key = this.keyPrefix + "_" + key;
        }
        return iZPlanMMKVApi.getLong(key, defValue);
    }

    @Override // com.tencent.raft.standard.storage.IRStorage
    public String getString(String key, String defValue) {
        Intrinsics.checkNotNullParameter(key, "key");
        IZPlanMMKVApi iZPlanMMKVApi = this.zplanMMKVApi;
        if (!TextUtils.isEmpty(this.keyPrefix)) {
            key = this.keyPrefix + "_" + key;
        }
        if (defValue == null) {
            defValue = "";
        }
        return iZPlanMMKVApi.getString(key, defValue);
    }

    @Override // com.tencent.raft.standard.storage.IRStorage
    public void lock() {
        a.C11686a c11686a = this.lock;
        if (c11686a != null) {
            c11686a.b();
        }
    }

    @Override // com.tencent.raft.standard.storage.IRStorage
    public void putByteArray(String key, byte[] value) {
        Intrinsics.checkNotNullParameter(key, "key");
        IZPlanMMKVApi iZPlanMMKVApi = this.zplanMMKVApi;
        if (!TextUtils.isEmpty(this.keyPrefix)) {
            key = this.keyPrefix + "_" + key;
        }
        if (value == null) {
            value = new byte[0];
        }
        iZPlanMMKVApi.setBytes(key, value);
    }

    @Override // com.tencent.raft.standard.storage.IRStorage
    public void putLong(String key, long value) {
        Intrinsics.checkNotNullParameter(key, "key");
        IZPlanMMKVApi iZPlanMMKVApi = this.zplanMMKVApi;
        if (!TextUtils.isEmpty(this.keyPrefix)) {
            key = this.keyPrefix + "_" + key;
        }
        iZPlanMMKVApi.setLong(key, value);
    }

    @Override // com.tencent.raft.standard.storage.IRStorage
    public void putString(String key, String value) {
        Intrinsics.checkNotNullParameter(key, "key");
        IZPlanMMKVApi iZPlanMMKVApi = this.zplanMMKVApi;
        if (!TextUtils.isEmpty(this.keyPrefix)) {
            key = this.keyPrefix + "_" + key;
        }
        if (value == null) {
            value = "";
        }
        iZPlanMMKVApi.setString(key, value);
    }

    @Override // com.tencent.raft.standard.storage.IRStorage
    public void remove(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        IZPlanMMKVApi iZPlanMMKVApi = this.zplanMMKVApi;
        if (!TextUtils.isEmpty(this.keyPrefix)) {
            key = this.keyPrefix + "_" + key;
        }
        iZPlanMMKVApi.remove(key);
    }

    @Override // com.tencent.raft.standard.storage.IRStorage
    public void unlock() {
        a.C11686a c11686a = this.lock;
        if (c11686a != null) {
            c11686a.c();
        }
    }

    @Override // com.tencent.raft.standard.storage.IRStorage
    public void trim() {
    }
}
