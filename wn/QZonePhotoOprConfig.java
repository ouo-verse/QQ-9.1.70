package wn;

import com.google.gson.annotations.SerializedName;
import com.tencent.qne.model.QneInterpreter;
import com.tencent.qne.model.f;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0012\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0004\u0012\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006\u0012\u000e\b\u0002\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0004\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001a\u0010\t\u001a\u00020\u0004*\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007J\t\u0010\u000b\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\r\u001a\u00020\fH\u00d6\u0001J\u0013\u0010\u000f\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001a\u0010\u0010\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R \u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u00068\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R \u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00020\u00068\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0015\u001a\u0004\b\u0019\u0010\u0017R\u001a\u0010\u001a\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u001a\u0010\u0011\u001a\u0004\b\u001b\u0010\u0013\u00a8\u0006\u001e"}, d2 = {"Lwn/a;", "", "", "model", "", "c", "", "Lcom/tencent/qne/model/QneInterpreter;", "interpreter", "a", "d", "toString", "", "hashCode", "other", "equals", "enable", "Z", "getEnable", "()Z", "supportedBackend", "Ljava/util/List;", "getSupportedBackend", "()Ljava/util/List;", "modelBlackList", "getModelBlackList", "onlyDownloadOnWifi", "b", "<init>", "(ZLjava/util/List;Ljava/util/List;Z)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: wn.a, reason: from toString */
/* loaded from: classes36.dex */
public final /* data */ class QZonePhotoOprConfig {

    @SerializedName("enable")
    private final boolean enable;

    @SerializedName("modelBlackList")
    private final List<String> modelBlackList;

    @SerializedName("onlyDownloadOnWifi")
    private final boolean onlyDownloadOnWifi;

    @SerializedName("supportedBackend")
    private final List<String> supportedBackend;

    public QZonePhotoOprConfig() {
        this(false, null, null, false, 15, null);
    }

    private final boolean a(List<String> list, QneInterpreter qneInterpreter) {
        f c16 = qneInterpreter.c();
        return c16 != null && list.contains(c16.b());
    }

    private final boolean c(String model) {
        Object obj;
        boolean equals;
        if (!this.modelBlackList.isEmpty()) {
            Iterator<T> it = this.modelBlackList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                equals = StringsKt__StringsJVMKt.equals((String) obj, model, true);
                if (equals) {
                    break;
                }
            }
            if (obj != null) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: b, reason: from getter */
    public final boolean getOnlyDownloadOnWifi() {
        return this.onlyDownloadOnWifi;
    }

    public final boolean d(QneInterpreter interpreter) {
        Intrinsics.checkNotNullParameter(interpreter, "interpreter");
        if (this.enable && !c(interpreter.b())) {
            return a(this.supportedBackend, interpreter);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    public int hashCode() {
        boolean z16 = this.enable;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        int hashCode = ((((r06 * 31) + this.supportedBackend.hashCode()) * 31) + this.modelBlackList.hashCode()) * 31;
        boolean z17 = this.onlyDownloadOnWifi;
        return hashCode + (z17 ? 1 : z17 ? 1 : 0);
    }

    public String toString() {
        return "QZonePhotoOprConfig(enable=" + this.enable + ", supportedBackend=" + this.supportedBackend + ", modelBlackList=" + this.modelBlackList + ", onlyDownloadOnWifi=" + this.onlyDownloadOnWifi + ")";
    }

    public QZonePhotoOprConfig(boolean z16, List<String> supportedBackend, List<String> modelBlackList, boolean z17) {
        Intrinsics.checkNotNullParameter(supportedBackend, "supportedBackend");
        Intrinsics.checkNotNullParameter(modelBlackList, "modelBlackList");
        this.enable = z16;
        this.supportedBackend = supportedBackend;
        this.modelBlackList = modelBlackList;
        this.onlyDownloadOnWifi = z17;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof QZonePhotoOprConfig)) {
            return false;
        }
        QZonePhotoOprConfig qZonePhotoOprConfig = (QZonePhotoOprConfig) other;
        return this.enable == qZonePhotoOprConfig.enable && Intrinsics.areEqual(this.supportedBackend, qZonePhotoOprConfig.supportedBackend) && Intrinsics.areEqual(this.modelBlackList, qZonePhotoOprConfig.modelBlackList) && this.onlyDownloadOnWifi == qZonePhotoOprConfig.onlyDownloadOnWifi;
    }

    public /* synthetic */ QZonePhotoOprConfig(boolean z16, List list, List list2, boolean z17, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? false : z16, (i3 & 2) != 0 ? CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{f.d.f344357i.b(), f.e.f344358i.b(), f.C9348f.f344359i.b()}) : list, (i3 & 4) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list2, (i3 & 8) != 0 ? true : z17);
    }
}
