package yl0;

import cooperation.qzone.util.PerfTracer;
import java.net.URLEncoder;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes36.dex */
public class a extends c {

    /* renamed from: d, reason: collision with root package name */
    private int f450573d;

    /* renamed from: f, reason: collision with root package name */
    private int f450575f;

    /* renamed from: g, reason: collision with root package name */
    private String f450576g;

    /* renamed from: e, reason: collision with root package name */
    private zl0.a f450574e = null;

    /* renamed from: h, reason: collision with root package name */
    private boolean f450577h = true;

    /* renamed from: i, reason: collision with root package name */
    public boolean f450578i = true;

    private int l() {
        if (h() == null) {
            return 0;
        }
        return h().a();
    }

    public boolean g() {
        return this.f450577h;
    }

    public zl0.a h() {
        return this.f450574e;
    }

    public int i() {
        return this.f450575f;
    }

    public String j() {
        return this.f450576g;
    }

    public String k() {
        int l3 = l();
        int id5 = a().getScene().getId();
        int id6 = a().getId();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("click_scene", String.valueOf(id5));
            jSONObject.put("click_pos", String.valueOf(id6));
            jSONObject.put("pos_attribute", String.valueOf(l3));
            jSONObject.put(PerfTracer.PARAM_CLICK_TIME, String.valueOf(System.currentTimeMillis()));
            return jSONObject.toString();
        } catch (JSONException e16) {
            e16.printStackTrace();
            return null;
        }
    }

    public String m() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(PerfTracer.PARAM_CLICK_TIME, System.currentTimeMillis());
            return URLEncoder.encode(jSONObject.toString(), "UTF-8");
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }

    public int n() {
        return this.f450573d;
    }

    public void o(zl0.a aVar) {
        this.f450574e = aVar;
    }

    public void p(String str) {
        this.f450576g = str;
    }

    public void q(boolean z16) {
        this.f450577h = z16;
    }

    public void r(int i3) {
        this.f450573d = i3;
    }
}
