package x61;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.freesia.IConfigData;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes10.dex */
public class c implements IConfigData {

    /* renamed from: d, reason: collision with root package name */
    public JSONObject f447285d = new JSONObject();

    @NonNull
    public static c a(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                c cVar = new c();
                cVar.f447285d = jSONObject;
                return cVar;
            } catch (Exception e16) {
                QLog.e("AdEmoConfigBean", 1, e16.getMessage());
            }
        }
        return new c();
    }
}
