package x51;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes10.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private boolean f447251a;

    /* renamed from: b, reason: collision with root package name */
    private ArrayList<String> f447252b = new ArrayList<>();

    public a() {
        this.f447251a = false;
        this.f447251a = false;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0077  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static a b(String str) {
        int i3;
        JSONObject jSONObject;
        if (QLog.isColorLevel()) {
            QLog.d("TroopDragonKingAnimEntryConfig.config", 2, "content : " + str);
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        boolean z16 = false;
        try {
            jSONObject = new JSONObject(str);
            i3 = jSONObject.optInt("globalOpenWithNoCheckGrayUin", 0);
        } catch (JSONException e16) {
            e = e16;
            i3 = 0;
        }
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("grayQunUin");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                for (int i16 = 0; i16 < optJSONArray.length(); i16++) {
                    arrayList.add(String.valueOf(optJSONArray.getInt(i16)));
                }
            }
        } catch (JSONException e17) {
            e = e17;
            e.printStackTrace();
            a aVar = new a();
            if (i3 == 1) {
            }
            aVar.f447251a = z16;
            aVar.f447252b = arrayList;
            if (QLog.isColorLevel()) {
            }
            return aVar;
        }
        a aVar2 = new a();
        if (i3 == 1) {
            z16 = true;
        }
        aVar2.f447251a = z16;
        aVar2.f447252b = arrayList;
        if (QLog.isColorLevel()) {
            QLog.d("TroopDragonKingAnimEntryConfig.config", 2, "bDragonKingEntry : " + aVar2.f447251a + "arrayGrayList : " + aVar2.f447252b.toString());
        }
        return aVar2;
    }

    public boolean a(String str) {
        if (str == null) {
            if (QLog.isColorLevel()) {
                QLog.d("TroopDragonKingAnimEntryConfig.config", 2, "isDragKingEntry : troopUin null");
            }
            return false;
        }
        if (str.isEmpty()) {
            if (QLog.isColorLevel()) {
                QLog.d("TroopDragonKingAnimEntryConfig.config", 2, "isDragKingEntry : troopUin empty");
            }
            return false;
        }
        if (this.f447251a) {
            if (QLog.isColorLevel()) {
                QLog.d("TroopDragonKingAnimEntryConfig.config", 2, "isDragKingEntry : true");
            }
            return true;
        }
        if (this.f447252b.isEmpty()) {
            return false;
        }
        String substring = str.substring(str.length() - 1);
        for (int i3 = 0; i3 < this.f447252b.size(); i3++) {
            if (this.f447252b.get(i3).equals(substring)) {
                if (QLog.isColorLevel()) {
                    QLog.d("TroopDragonKingAnimEntryConfig.config", 2, "isDragKingEntry : gray true!");
                }
                return true;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("TroopDragonKingAnimEntryConfig.config", 2, "isDragKingEntry: gray false!");
        }
        return false;
    }
}
