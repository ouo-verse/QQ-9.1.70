package ta1;

import com.tencent.mobileqq.config.ai;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes10.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private boolean f435635a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f435636b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f435637c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f435638d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f435639e;

    /* renamed from: h, reason: collision with root package name */
    private boolean f435642h;

    /* renamed from: r, reason: collision with root package name */
    private boolean f435652r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f435653s;

    /* renamed from: f, reason: collision with root package name */
    private int f435640f = -1;

    /* renamed from: g, reason: collision with root package name */
    private String f435641g = "https://eim.connect.qq.com/guide/install.html?install=1";

    /* renamed from: i, reason: collision with root package name */
    private int f435643i = -1;

    /* renamed from: j, reason: collision with root package name */
    private String f435644j = "";

    /* renamed from: k, reason: collision with root package name */
    private String f435645k = "";

    /* renamed from: l, reason: collision with root package name */
    private String f435646l = "";

    /* renamed from: m, reason: collision with root package name */
    private String f435647m = "";

    /* renamed from: n, reason: collision with root package name */
    private int f435648n = -1;

    /* renamed from: o, reason: collision with root package name */
    private String f435649o = "";

    /* renamed from: p, reason: collision with root package name */
    private String f435650p = "";

    /* renamed from: q, reason: collision with root package name */
    private int f435651q = -1;

    /* renamed from: t, reason: collision with root package name */
    private String f435654t = "";

    /* renamed from: u, reason: collision with root package name */
    private Map<String, Long> f435655u = new HashMap();

    public static f s(ai[] aiVarArr) {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z26;
        boolean z27;
        boolean z28;
        boolean z29;
        if (aiVarArr != null && aiVarArr.length > 0) {
            f fVar = new f();
            try {
                JSONObject jSONObject = new JSONObject(aiVarArr[0].f202268b);
                if (jSONObject.has("TIMDocs")) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject("TIMDocs");
                    if (jSONObject2.has("autoImportToSharedDocSwitch")) {
                        if (jSONObject2.getInt("autoImportToSharedDocSwitch") == 1) {
                            z29 = true;
                        } else {
                            z29 = false;
                        }
                        fVar.f435635a = z29;
                    }
                    if (jSONObject2.has("openWithSharedDocInTimSwitch")) {
                        if (jSONObject2.getInt("openWithSharedDocInTimSwitch") == 1) {
                            z28 = true;
                        } else {
                            z28 = false;
                        }
                        fVar.f435636b = z28;
                    }
                    if (jSONObject2.has("openFileInTimSwitch")) {
                        if (jSONObject2.getInt("openFileInTimSwitch") == 1) {
                            z27 = true;
                        } else {
                            z27 = false;
                        }
                        fVar.f435637c = z27;
                    }
                    if (jSONObject2.has("aioSwitch")) {
                        if (jSONObject2.getInt("aioSwitch") == 1) {
                            z26 = true;
                        } else {
                            z26 = false;
                        }
                        fVar.f435638d = z26;
                    }
                    if (jSONObject2.has("fileViewerMenuSwitch")) {
                        if (jSONObject2.getInt("fileViewerMenuSwitch") == 1) {
                            z19 = true;
                        } else {
                            z19 = false;
                        }
                        fVar.f435639e = z19;
                    }
                    if (jSONObject2.has("openFileInTimEntry")) {
                        fVar.f435640f = jSONObject2.getInt("openFileInTimEntry");
                    }
                    if (jSONObject2.has("androidURL")) {
                        fVar.f435641g = jSONObject2.getString("androidURL");
                    }
                    if (jSONObject2.has("insertGrayTipAfterOpenWithSharedDocInTim")) {
                        if (jSONObject2.getInt("insertGrayTipAfterOpenWithSharedDocInTim") == 1) {
                            z18 = true;
                        } else {
                            z18 = false;
                        }
                        fVar.f435642h = z18;
                    }
                    if (jSONObject2.has("timVersion")) {
                        fVar.f435643i = jSONObject2.getInt("timVersion");
                    }
                    if (jSONObject2.has("saveTipLine0")) {
                        fVar.f435644j = jSONObject2.getString("saveTipLine0");
                    }
                    if (jSONObject2.has("saveTipLine1")) {
                        fVar.f435645k = jSONObject2.getString("saveTipLine1");
                    }
                    if (jSONObject2.has("saveAndCloseTipLine0")) {
                        fVar.f435646l = jSONObject2.getString("saveAndCloseTipLine0");
                    }
                    if (jSONObject2.has("saveAndCloseTipLine1")) {
                        fVar.f435647m = jSONObject2.getString("saveAndCloseTipLine1");
                    }
                    if (jSONObject2.has("saveTipCount")) {
                        fVar.f435648n = jSONObject2.getInt("saveTipCount");
                    }
                    if (jSONObject2.has("contentEditedTipLine0")) {
                        fVar.f435649o = jSONObject2.getString("contentEditedTipLine0");
                    }
                    if (jSONObject2.has("contentEditedTipLine1")) {
                        fVar.f435650p = jSONObject2.getString("contentEditedTipLine1");
                    }
                    if (jSONObject2.has("contentEditedTipCount")) {
                        fVar.f435651q = jSONObject2.getInt("contentEditedTipCount");
                    }
                    if (jSONObject2.has("docListEntryInFileSwitch")) {
                        if (jSONObject2.getInt("docListEntryInFileSwitch") == 1) {
                            z17 = true;
                        } else {
                            z17 = false;
                        }
                        fVar.f435652r = z17;
                    }
                    if (jSONObject2.has("hideDocAuthoritySettingEntry")) {
                        if (jSONObject2.getInt("hideDocAuthoritySettingEntry") == 1) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        fVar.f435653s = z16;
                    }
                    if (jSONObject2.has("docListUrl")) {
                        fVar.f435654t = jSONObject2.getString("docListUrl");
                    }
                    if (jSONObject2.has("editSupport")) {
                        JSONObject jSONObject3 = jSONObject2.getJSONObject("editSupport");
                        Iterator keys = jSONObject3.keys();
                        while (keys.hasNext()) {
                            String str = (String) keys.next();
                            fVar.f435655u.put(str, Long.valueOf(jSONObject3.getLong(str)));
                        }
                    }
                }
            } catch (JSONException e16) {
                QLog.e("TencentDocConvertConfigBean", 1, e16.getLocalizedMessage(), e16);
            }
            return fVar;
        }
        return null;
    }

    public String a() {
        return this.f435641g;
    }

    public int b() {
        return this.f435651q;
    }

    public String c() {
        return this.f435649o;
    }

    public String d() {
        return this.f435650p;
    }

    public String e() {
        return this.f435654t;
    }

    public int f() {
        return this.f435640f;
    }

    public String g() {
        return this.f435646l;
    }

    public String h() {
        return this.f435647m;
    }

    public int i() {
        return this.f435648n;
    }

    public String j() {
        return this.f435644j;
    }

    public String k() {
        return this.f435645k;
    }

    public Map<String, Long> l() {
        return this.f435655u;
    }

    public int m() {
        return this.f435643i;
    }

    public boolean n() {
        return this.f435638d;
    }

    public boolean o() {
        return this.f435639e;
    }

    public boolean p() {
        return this.f435642h;
    }

    public boolean q() {
        return this.f435637c;
    }

    public boolean r() {
        return this.f435636b;
    }
}
