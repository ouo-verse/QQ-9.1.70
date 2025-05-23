package sa1;

import androidx.annotation.NonNull;
import com.tencent.freesia.IConfigData;
import com.tencent.mobileqq.config.ai;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes10.dex */
public class a implements IConfigData {

    /* renamed from: d, reason: collision with root package name */
    private int f433557d;

    /* renamed from: e, reason: collision with root package name */
    private int f433558e;

    /* renamed from: f, reason: collision with root package name */
    private int f433559f = 1;

    /* renamed from: h, reason: collision with root package name */
    private boolean f433560h;

    private static void a(a aVar, String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            aVar.j(jSONObject.optInt("hotword_switch_message", 0));
            aVar.h(jSONObject.optInt("hotword_switch_contact", 0));
            aVar.i(jSONObject.optInt("hotword_switch_dongtai", 1));
            aVar.f433560h = true;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("SearchHotWordConfBean", 2, "parse error->" + e16);
            }
        }
    }

    public static a f(ai aiVar) {
        a aVar = new a();
        if (aiVar != null) {
            if (QLog.isColorLevel()) {
                QLog.d("SearchHotWordConfBean", 2, "parse taskid->" + aiVar.f202267a + " content->" + aiVar.f202268b);
            }
            a(aVar, aiVar.f202268b);
        }
        return aVar;
    }

    public static a g(String str) {
        a aVar = new a();
        a(aVar, str);
        return aVar;
    }

    public boolean b() {
        if (this.f433558e == 1) {
            return true;
        }
        return false;
    }

    public boolean c() {
        if (this.f433559f == 1) {
            return true;
        }
        return false;
    }

    public boolean d() {
        if (this.f433557d == 1) {
            return true;
        }
        return false;
    }

    public boolean e() {
        return this.f433560h;
    }

    void h(int i3) {
        this.f433558e = i3;
    }

    void i(int i3) {
        this.f433559f = i3;
    }

    void j(int i3) {
        this.f433557d = i3;
    }

    @NonNull
    public String toString() {
        return String.format("mHotWordSwitchTabMessage:%d, mHotWordSwitchTabContact:%d, mHotWordSwitchTabDongtai:%d", Integer.valueOf(this.f433557d), Integer.valueOf(this.f433558e), Integer.valueOf(this.f433559f));
    }
}
