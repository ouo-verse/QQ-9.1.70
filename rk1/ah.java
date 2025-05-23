package rk1;

import com.google.gson.Gson;

/* compiled from: P */
/* loaded from: classes13.dex */
public class ah extends b {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ok1.a
    public String k() {
        return "showToolsBar";
    }

    @Override // ok1.a
    protected boolean o(String str, String str2, String str3) {
        in1.e l3 = l();
        if (l3 == null) {
            return false;
        }
        l3.Jb((jn1.e) new Gson().fromJson(j(), jn1.e.class));
        return true;
    }
}
