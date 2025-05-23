package xn2;

import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.search.model.y;
import java.util.Set;
import wn2.r;

/* compiled from: P */
/* loaded from: classes18.dex */
public class f extends c {
    public f(IFaceDecoder iFaceDecoder, com.tencent.mobileqq.search.view.d dVar, Set<String> set) {
        super(iFaceDecoder, dVar, set);
    }

    @Override // xn2.c, qn2.f, qn2.d
    /* renamed from: g */
    public void a(y yVar, sn2.c cVar) {
        boolean z16;
        super.a(yVar, cVar);
        if (cVar.k() != null) {
            r rVar = (r) yVar;
            Set<String> set = this.f448193f;
            int i3 = 0;
            if (set != null && set.contains(rVar.l())) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!TextUtils.isEmpty(rVar.m())) {
                cVar.k().setText(rVar.m());
                z16 = true;
            }
            TextView k3 = cVar.k();
            if (!z16) {
                i3 = 8;
            }
            k3.setVisibility(i3);
            cVar.getView().setClickable(!z16);
        }
        if (cVar.g() != null) {
            cVar.g().setVisibility(8);
        }
    }
}
