package si0;

import com.tencent.mobileqq.qwallet.transaction.impl.NotifyMsgApiImpl;
import java.net.URLEncoder;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0013\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0006\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0006\u0010\u0003\u001a\u00020\u0002J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\t\u0010\u0007\u001a\u00020\u0006H\u00d6\u0001J\u0013\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0011\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u0010\u0010\rR\u0017\u0010\u0014\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u000b\u001a\u0004\b\u0013\u0010\rR\u0017\u0010\u0019\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lsi0/a;", "", "Lorg/json/JSONObject;", "a", "", "toString", "", "hashCode", "other", "", "equals", "Ljava/lang/String;", "getUin", "()Ljava/lang/String;", "uin", "b", "getName", "name", "c", "getIcon", "icon", "d", "I", "getGroupType", "()I", NotifyMsgApiImpl.KEY_GROUP_TYPE, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "ecommerce_api_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: si0.a, reason: from toString */
/* loaded from: classes5.dex */
public final /* data */ class ECTroopInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String uin;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String name;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String icon;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final int groupType;

    public ECTroopInfo() {
        this(null, null, null, 0, 15, null);
    }

    @NotNull
    public final JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("uin", this.uin);
        jSONObject.put("name", URLEncoder.encode(this.name));
        jSONObject.put("icon", this.icon);
        jSONObject.put(NotifyMsgApiImpl.KEY_GROUP_TYPE, this.groupType);
        return jSONObject;
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof ECTroopInfo) {
                ECTroopInfo eCTroopInfo = (ECTroopInfo) other;
                if (!Intrinsics.areEqual(this.uin, eCTroopInfo.uin) || !Intrinsics.areEqual(this.name, eCTroopInfo.name) || !Intrinsics.areEqual(this.icon, eCTroopInfo.icon) || this.groupType != eCTroopInfo.groupType) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i3;
        int i16;
        String str = this.uin;
        int i17 = 0;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = 0;
        }
        int i18 = i3 * 31;
        String str2 = this.name;
        if (str2 != null) {
            i16 = str2.hashCode();
        } else {
            i16 = 0;
        }
        int i19 = (i18 + i16) * 31;
        String str3 = this.icon;
        if (str3 != null) {
            i17 = str3.hashCode();
        }
        return ((i19 + i17) * 31) + this.groupType;
    }

    @NotNull
    public String toString() {
        return "ECTroopInfo(uin=" + this.uin + ", name=" + this.name + ", icon=" + this.icon + ", groupType=" + this.groupType + ")";
    }

    public ECTroopInfo(@NotNull String str, @NotNull String str2, @NotNull String str3, int i3) {
        this.uin = str;
        this.name = str2;
        this.icon = str3;
        this.groupType = i3;
    }

    public /* synthetic */ ECTroopInfo(String str, String str2, String str3, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? "" : str, (i16 & 2) != 0 ? "" : str2, (i16 & 4) != 0 ? "" : str3, (i16 & 8) != 0 ? 0 : i3);
    }
}
