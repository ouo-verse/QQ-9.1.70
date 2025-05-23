package tw4;

import android.content.SharedPreferences;
import com.tencent.vas.update.wrapper.VasUpdateWrapper;

/* compiled from: P */
/* loaded from: classes27.dex */
public class h implements sw4.e {
    private SharedPreferences b() {
        return VasUpdateWrapper.getCommonManager().getApplicationContext().getSharedPreferences("mmkv", 0);
    }

    @Override // sw4.e
    public String a(String str) {
        return b().getString(str, "");
    }

    @Override // sw4.e
    public void encodeString(String str, String str2) {
        b().edit().putString(str, str2).commit();
    }
}
