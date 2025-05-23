package rk1;

import com.google.gson.Gson;
import com.tencent.qqmini.miniapp.widget.CanvasView;

/* compiled from: P */
/* loaded from: classes13.dex */
public class af extends b {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ok1.a
    public String k() {
        return CanvasView.ACTION_SET_FONT_STYLE;
    }

    @Override // ok1.a
    protected boolean o(String str, String str2, String str3) {
        in1.e l3 = l();
        if (l3 == null) {
            return false;
        }
        l3.ee((jn1.c) new Gson().fromJson(j(), jn1.c.class));
        return true;
    }
}
