package yk0;

import com.google.gson.annotations.SerializedName;
import com.tencent.filament.zplanservice.util.log.FLog;
import com.tencent.zplan.common.utils.GsonUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u001d\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r\u00a2\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001a\u0010\t\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0014"}, d2 = {"Lyk0/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "success", "Z", "b", "()Z", "Lyk0/c;", "furniture", "Lyk0/c;", "a", "()Lyk0/c;", "<init>", "(ZLyk0/c;)V", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* renamed from: yk0.a, reason: from toString */
/* loaded from: classes6.dex */
public final /* data */ class DecorateInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @SerializedName("result")
    @Nullable
    private final FurnitureDesc furniture;

    @SerializedName("isSucc")
    private final boolean success;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\u0004\u001a\u0004\u0018\u00010\u0003*\u0004\u0018\u00010\u0002R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006\u00a8\u0006\t"}, d2 = {"Lyk0/a$a;", "", "", "Lyk0/a;", "a", "TAG", "Ljava/lang/String;", "<init>", "()V", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
    /* renamed from: yk0.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes6.dex */
    public static final class Companion {
        Companion() {
        }

        @Nullable
        public final DecorateInfo a(@Nullable String str) {
            boolean z16;
            if (str != null && str.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                return null;
            }
            try {
                return (DecorateInfo) GsonUtil.f385283b.a().fromJson(str, DecorateInfo.class);
            } catch (Throwable th5) {
                FLog.INSTANCE.e("DecorateInfo", "toMessageCallbackRet " + str + " exception", th5);
                return null;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public DecorateInfo() {
        this(false, null, 3, 0 == true ? 1 : 0);
    }

    @Nullable
    /* renamed from: a, reason: from getter */
    public final FurnitureDesc getFurniture() {
        return this.furniture;
    }

    /* renamed from: b, reason: from getter */
    public final boolean getSuccess() {
        return this.success;
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof DecorateInfo) {
                DecorateInfo decorateInfo = (DecorateInfo) other;
                if (this.success != decorateInfo.success || !Intrinsics.areEqual(this.furniture, decorateInfo.furniture)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public int hashCode() {
        int i3;
        boolean z16 = this.success;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        int i16 = r06 * 31;
        FurnitureDesc furnitureDesc = this.furniture;
        if (furnitureDesc != null) {
            i3 = furnitureDesc.hashCode();
        } else {
            i3 = 0;
        }
        return i16 + i3;
    }

    @NotNull
    public String toString() {
        return "DecorateInfo(success=" + this.success + ", furniture=" + this.furniture + ")";
    }

    public DecorateInfo(boolean z16, @Nullable FurnitureDesc furnitureDesc) {
        this.success = z16;
        this.furniture = furnitureDesc;
    }

    public /* synthetic */ DecorateInfo(boolean z16, FurnitureDesc furnitureDesc, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? false : z16, (i3 & 2) != 0 ? null : furnitureDesc);
    }
}
