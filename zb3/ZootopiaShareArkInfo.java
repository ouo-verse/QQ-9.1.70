package zb3;

import com.tencent.mobileqq.zootopia.service.api.IZootopiaShareArkService;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b$\b\u0086\b\u0018\u0000 \u00172\u00020\u0001:\u0001\rB\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\b\u00a2\u0006\u0004\b.\u0010\u0011J\u000e\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0005J\t\u0010\u0007\u001a\u00020\u0005H\u00d6\u0001J\t\u0010\t\u001a\u00020\bH\u00d6\u0001J\u0013\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u0012\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\r\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0019\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u001b\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\u0014\u001a\u0004\b\u0013\u0010\u0016\"\u0004\b\u001a\u0010\u0018R\"\u0010\u001e\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0004\u0010\u0014\u001a\u0004\b\u001c\u0010\u0016\"\u0004\b\u001d\u0010\u0018R\"\u0010!\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u0014\u001a\u0004\b\u001f\u0010\u0016\"\u0004\b \u0010\u0018R\"\u0010$\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\"\u0010\u0014\u001a\u0004\b#\u0010\u0016\"\u0004\b\"\u0010\u0018R\"\u0010'\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b%\u0010\u0014\u001a\u0004\b&\u0010\u0016\"\u0004\b%\u0010\u0018R\"\u0010+\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b(\u0010\u000e\u001a\u0004\b)\u0010\u000f\"\u0004\b*\u0010\u0011R\"\u0010-\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010\u0014\u001a\u0004\b,\u0010\u0016\"\u0004\b(\u0010\u0018\u00a8\u0006/"}, d2 = {"Lzb3/o;", "", "Lov4/m;", "info", "d", "", "c", "toString", "", "hashCode", "other", "", "equals", "a", "I", "()I", "setMapID", "(I)V", IZootopiaShareArkService.ARK_MAP_ID, "b", "Ljava/lang/String;", "getGameTeamParams", "()Ljava/lang/String;", "j", "(Ljava/lang/String;)V", IZootopiaShareArkService.ARK_MAP_TEAM_PARAMS, "k", "mapName", "getBackground", "e", "background", "getFooterColor", "i", "footerColor", "f", "getButtonColor", "buttonColor", "g", "getButtonText", "buttonText", tl.h.F, "getSceneType", "l", "sceneType", "getExtInfo", "extInfo", "<init>", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: zb3.o, reason: from toString */
/* loaded from: classes36.dex */
public final /* data */ class ZootopiaShareArkInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private int mapID;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private String gameTeamParams;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private String mapName;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private String background;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private String footerColor;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private String buttonColor;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private String buttonText;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int sceneType;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private String extInfo;

    public ZootopiaShareArkInfo() {
        this(0, 1, null);
    }

    /* renamed from: a, reason: from getter */
    public final int getMapID() {
        return this.mapID;
    }

    /* renamed from: b, reason: from getter */
    public final String getMapName() {
        return this.mapName;
    }

    public final String c() {
        try {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(IZootopiaShareArkService.ARK_MAP_ID, this.mapID);
            jSONObject2.put(IZootopiaShareArkService.ARK_MAP_TEAM_PARAMS, this.gameTeamParams);
            jSONObject2.put("mapName", this.mapName);
            jSONObject2.put("background", this.background);
            jSONObject2.put("footerColor", this.footerColor);
            jSONObject2.put("buttonColor", this.buttonColor);
            jSONObject2.put("buttonText", this.buttonText);
            jSONObject2.put("sceneType", this.sceneType);
            jSONObject2.put("extInfo", this.extInfo);
            jSONObject2.put("isPreview", 1);
            jSONObject.put("info", jSONObject2);
            String jSONObject3 = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject3, "meta.toString()");
            return jSONObject3;
        } catch (Throwable th5) {
            QLog.e("ZootopiaShareArkInfo", 2, th5, new Object[0]);
            return "";
        }
    }

    public final ZootopiaShareArkInfo d(ov4.m info) {
        Intrinsics.checkNotNullParameter(info, "info");
        ZootopiaShareArkInfo zootopiaShareArkInfo = new ZootopiaShareArkInfo(info.f424176a);
        String str = info.f424177b;
        Intrinsics.checkNotNullExpressionValue(str, "info.mapName");
        zootopiaShareArkInfo.mapName = str;
        String str2 = info.f424178c;
        Intrinsics.checkNotNullExpressionValue(str2, "info.background");
        zootopiaShareArkInfo.background = str2;
        String str3 = info.f424179d;
        Intrinsics.checkNotNullExpressionValue(str3, "info.footerColor");
        zootopiaShareArkInfo.footerColor = str3;
        String str4 = info.f424180e;
        Intrinsics.checkNotNullExpressionValue(str4, "info.buttonColor");
        zootopiaShareArkInfo.buttonColor = str4;
        String str5 = info.f424181f;
        Intrinsics.checkNotNullExpressionValue(str5, "info.button");
        zootopiaShareArkInfo.buttonText = str5;
        return zootopiaShareArkInfo;
    }

    public final void e(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.background = str;
    }

    public final void f(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.buttonColor = str;
    }

    public final void g(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.buttonText = str;
    }

    public final void h(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.extInfo = str;
    }

    public int hashCode() {
        return this.mapID;
    }

    public final void i(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.footerColor = str;
    }

    public final void j(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.gameTeamParams = str;
    }

    public final void k(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mapName = str;
    }

    public final void l(int i3) {
        this.sceneType = i3;
    }

    public String toString() {
        return "ZootopiaShareArkInfo(mapID=" + this.mapID + ")";
    }

    public ZootopiaShareArkInfo(int i3) {
        this.mapID = i3;
        this.gameTeamParams = "";
        this.mapName = "";
        this.background = "";
        this.footerColor = "";
        this.buttonColor = "";
        this.buttonText = "";
        this.extInfo = "";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof ZootopiaShareArkInfo) && this.mapID == ((ZootopiaShareArkInfo) other).mapID;
    }

    public /* synthetic */ ZootopiaShareArkInfo(int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? 0 : i3);
    }
}
