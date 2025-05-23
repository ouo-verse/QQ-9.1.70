package qu1;

import android.util.Base64;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.group_pro_proto.common.common$Role;

/* compiled from: P */
/* loaded from: classes14.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public long f429567a;

    /* renamed from: b, reason: collision with root package name */
    public byte[] f429568b;

    /* renamed from: c, reason: collision with root package name */
    public int f429569c;

    public a(common$Role common_role) {
        this.f429567a = common_role.f435943id.get();
        this.f429568b = common_role.info.get().toByteArray();
        this.f429569c = common_role.flag.get();
    }

    public String a() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("roleId", this.f429567a);
            jSONObject.put("roleInfo", Base64.encodeToString(this.f429568b, 0));
            jSONObject.put("roleFlag", this.f429569c);
            return jSONObject.toString();
        } catch (JSONException e16) {
            QLog.e("Guild.user.GuildRoleInfo", 1, e16.getMessage());
            return "";
        }
    }
}
