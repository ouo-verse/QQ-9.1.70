package re2;

import com.tencent.mobileqq.guild.message.api.IGuildUniteGrayTipUtilApi;
import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0006\u001a\u00020\u0004J\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007R\u0014\u0010\u000b\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lre2/a;", "", "", "d", "Lorg/json/JSONObject;", "a", "b", "", "", "c", "Lorg/json/JSONObject;", "aladdinId2UnitedIdMapping", "<init>", "()V", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f431161a = new a();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final JSONObject aladdinId2UnitedIdMapping;

    static {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("652", 100096);
        jSONObject.put("357", 100097);
        jSONObject.put("422", 100098);
        jSONObject.put("428", 100099);
        jSONObject.put("580", 100100);
        jSONObject.put("631", AudienceReportConst.EVENT_ID_ENTER_ROOM_SUCCESS);
        jSONObject.put("657", AudienceReportConst.EVENT_ID_ENTER_ROOM_FAILURE);
        jSONObject.put("633", AudienceReportConst.EVENT_ID_PLAY_START);
        jSONObject.put("635", 100104);
        jSONObject.put("636", 100105);
        jSONObject.put("658", 100106);
        jSONObject.put(IGuildUniteGrayTipUtilApi.GUILD_TOP_MESSAGE, 100107);
        jSONObject.put(IGuildUniteGrayTipUtilApi.GUILD_CANCEL_TOP_MESSAGE, 100108);
        jSONObject.put("661", AudienceReportConst.EVENT_ID_BUFFER_START);
        jSONObject.put("662", AudienceReportConst.EVENT_ID_BUFFER_END);
        jSONObject.put("663", AudienceReportConst.EVENT_ID_NETWORK_CHANGE);
        jSONObject.put("664", AudienceReportConst.EVENT_ID_RESOLUTION_CHANGE);
        jSONObject.put("665", AudienceReportConst.EVENT_ID_AUDIO_BREAK);
        jSONObject.put("667", AudienceReportConst.EVENT_ID_AUDIO_RESUME);
        aladdinId2UnitedIdMapping = jSONObject;
    }

    a() {
    }

    public final JSONObject a() {
        return aladdinId2UnitedIdMapping;
    }

    public final JSONObject b() {
        JSONObject optJSONObject = qe2.a.f428882a.e("ecommerce_config_switch_880082675", new JSONObject()).optJSONObject("mapping_table");
        return optJSONObject == null ? new JSONObject() : optJSONObject;
    }

    public final List<Integer> c() {
        JSONArray optJSONArray = qe2.a.f428882a.e("ecommerce_config_switch_880082675", new JSONObject()).optJSONArray("rollback_key");
        if (optJSONArray == null) {
            optJSONArray = new JSONArray();
        }
        ArrayList arrayList = new ArrayList();
        int length = optJSONArray.length();
        for (int i3 = 0; i3 < length; i3++) {
            arrayList.add(Integer.valueOf(optJSONArray.optInt(i3, 0)));
        }
        return arrayList;
    }

    public final boolean d() {
        return qe2.a.f428882a.b("ecommerce_config_switch_880082675", false);
    }
}
