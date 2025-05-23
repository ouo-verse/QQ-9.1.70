package y53;

import com.tencent.shadow.dynamic.host.Constant;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002R0\u0010\n\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u0006j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0004`\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\r"}, d2 = {"Ly53/d;", "", "", "errorCode", "", "a", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "b", "Ljava/util/HashMap;", "errorCodeMap", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final d f449481a = new d();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final HashMap<Long, String> errorCodeMap;

    static {
        HashMap<Long, String> hashMapOf;
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to(1001L, "\u68c0\u6d4b\u4e0d\u5230\u4eba\u8138"), TuplesKt.to(Long.valueOf(Constant.FROM_ID_UNINSTALL_PLUGIN), "\u4eba\u8138\u89d2\u5ea6\u8d85\u51fa\u9650\u65f6"), TuplesKt.to(Long.valueOf(Constant.FROM_ID_START_ACTIVITY), "\u4eba\u4f53\u59ff\u6001\u4e0d\u7b26\u5408\u8981\u6c42"), TuplesKt.to(1004L, "\u4eba\u8138\u6570\u76ee\u8d85\u8fc7\u9650\u5236"), TuplesKt.to(1006L, "\u4eba\u8138\u8fc7\u5c0f"), TuplesKt.to(1007L, "\u4eba\u8138\u8fc7\u5927"), TuplesKt.to(1091L, "\u4eba\u6570\u592a\u591a\uff0c\u6362\u4e00\u5f20\u56fe\u8bd5\u8bd5"), TuplesKt.to(2111L, "\u6d3b\u52a8\u706b\u7206\u7a0d\u540e\u518d\u8bd5"), TuplesKt.to(2114L, "\u6362\u4e00\u5f20\u56fe\u7247\u8bd5\u8bd5"));
        errorCodeMap = hashMapOf;
    }

    d() {
    }

    @Nullable
    public final String a(long errorCode) {
        HashMap<Long, String> hashMap = errorCodeMap;
        if (hashMap.containsKey(Long.valueOf(errorCode))) {
            return hashMap.get(Long.valueOf(errorCode));
        }
        return null;
    }
}
