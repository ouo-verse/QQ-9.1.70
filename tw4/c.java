package tw4;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.vas.update.wrapper.VasUpdateWrapper;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import sw4.c;

/* compiled from: P */
/* loaded from: classes27.dex */
public class c implements sw4.c {
    private String e(int i3) {
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    return null;
                }
                return "table_file_md5";
            }
            return "table_should_update";
        }
        return "table_local";
    }

    @Override // sw4.c
    public List<c.a> a(int i3) {
        Map<String, ?> all;
        String e16 = e(i3);
        if (TextUtils.isEmpty(e16) || (all = VasUpdateWrapper.getCommonManager().getApplicationContext().getSharedPreferences(e16, 0).getAll()) == null || all.size() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, ?> entry : all.entrySet()) {
            c.a aVar = new c.a();
            aVar.f434914a = entry.getKey();
            aVar.f434915b = (String) entry.getValue();
            arrayList.add(aVar);
        }
        return arrayList;
    }

    @Override // sw4.c
    public String b(int i3, String str) {
        String e16 = e(i3);
        if (TextUtils.isEmpty(e16)) {
            return null;
        }
        return VasUpdateWrapper.getCommonManager().getApplicationContext().getSharedPreferences(e16, 0).getString(str, null);
    }

    @Override // sw4.c
    public void c(int i3, String str) {
        String e16 = e(i3);
        if (TextUtils.isEmpty(e16)) {
            return;
        }
        SharedPreferences.Editor edit = VasUpdateWrapper.getCommonManager().getApplicationContext().getSharedPreferences(e16, 0).edit();
        edit.remove(str);
        edit.commit();
    }

    @Override // sw4.c
    public void d(int i3, String str, String str2) {
        String e16 = e(i3);
        if (TextUtils.isEmpty(e16)) {
            return;
        }
        SharedPreferences.Editor edit = VasUpdateWrapper.getCommonManager().getApplicationContext().getSharedPreferences(e16, 0).edit();
        edit.putString(str, str2);
        edit.commit();
    }
}
