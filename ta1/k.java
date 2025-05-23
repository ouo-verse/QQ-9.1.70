package ta1;

import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.freesia.IConfigData;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes10.dex */
public class k implements IConfigData {

    /* renamed from: d, reason: collision with root package name */
    private String f435697d = "";

    /* renamed from: e, reason: collision with root package name */
    private long f435698e = 0;

    /* renamed from: f, reason: collision with root package name */
    private String f435699f = "";

    /* renamed from: h, reason: collision with root package name */
    private String f435700h = "";

    /* renamed from: i, reason: collision with root package name */
    private String f435701i = "";

    public static k f(String str) {
        QLog.d("TencentDocImportFileInfoBean", 2, str);
        k kVar = new k();
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("DocsImportFileInfo")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("DocsImportFileInfo");
                if (jSONObject2.has("importFileMaxSize")) {
                    String string = jSONObject2.getString("importFileMaxSize");
                    if (!TextUtils.isEmpty(string)) {
                        kVar.f435698e = Long.parseLong(string);
                    }
                }
                if (jSONObject2.has("importFileType")) {
                    JSONArray jSONArray = jSONObject2.getJSONArray("importFileType");
                    StringBuilder sb5 = new StringBuilder();
                    StringBuilder sb6 = new StringBuilder();
                    if (jSONArray != null && jSONArray.length() > 0) {
                        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                            JSONObject jSONObject3 = (JSONObject) jSONArray.get(i3);
                            if (jSONObject3.has("suffix")) {
                                sb5.append(jSONObject3.getString("suffix"));
                                sb6.append(jSONObject3.getString("suffix"));
                                if (jSONObject3.has("maxSize")) {
                                    sb6.append("_");
                                    sb6.append(jSONObject3.getString("maxSize"));
                                    sb6.append("#");
                                }
                            }
                        }
                    }
                    kVar.f435699f = sb6.toString();
                    kVar.f435700h = sb5.toString();
                }
                if (jSONObject2.has("fileGroupType")) {
                    JSONArray jSONArray2 = jSONObject2.getJSONArray("fileGroupType");
                    StringBuilder sb7 = new StringBuilder();
                    if (jSONArray2 != null && jSONArray2.length() > 0) {
                        for (int i16 = 0; i16 < jSONArray2.length(); i16++) {
                            JSONObject jSONObject4 = (JSONObject) jSONArray2.get(i16);
                            if (jSONObject4.has(VipFunCallConstants.KEY_GROUP) && jSONObject4.has("suffix")) {
                                sb7.append(jSONObject4.getString(VipFunCallConstants.KEY_GROUP) + "_" + jSONObject4.getString("suffix") + ContainerUtils.FIELD_DELIMITER);
                            }
                        }
                    }
                    kVar.f435701i = sb7.toString();
                }
                if (jSONObject2.has("importFileTips")) {
                    String string2 = jSONObject2.getString("importFileTips");
                    if (!TextUtils.isEmpty(string2)) {
                        kVar.f435697d = string2;
                    }
                }
            }
        } catch (JSONException e16) {
            if (QLog.isColorLevel()) {
                QLog.e("TencentDocImportFileInfoBean", 1, "exception = " + e16.toString());
            }
        }
        return kVar;
    }

    public String a() {
        return this.f435699f;
    }

    public String b() {
        return this.f435701i;
    }

    public long c() {
        return this.f435698e;
    }

    public String d() {
        return this.f435697d;
    }

    public String e() {
        return this.f435700h;
    }

    public void g(String str) {
        this.f435697d = str;
    }
}
