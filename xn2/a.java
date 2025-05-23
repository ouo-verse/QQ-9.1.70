package xn2;

import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.search.model.y;
import java.util.Iterator;
import java.util.List;
import wn2.m;

/* compiled from: P */
/* loaded from: classes18.dex */
public class a extends c {

    /* renamed from: h, reason: collision with root package name */
    private List<PhoneContact> f448189h;

    public a(IFaceDecoder iFaceDecoder, com.tencent.mobileqq.search.view.d dVar, List<PhoneContact> list) {
        super(iFaceDecoder, dVar);
        this.f448189h = list;
    }

    @Override // xn2.c, qn2.f, qn2.d
    /* renamed from: g */
    public void a(y yVar, sn2.c cVar) {
        boolean z16;
        super.a(yVar, cVar);
        if (cVar.k() != null) {
            m mVar = (m) yVar;
            List<PhoneContact> list = this.f448189h;
            int i3 = 0;
            if (list != null) {
                Iterator<PhoneContact> it = list.iterator();
                z16 = false;
                while (it.hasNext()) {
                    if (it.next().contactID == mVar.X.contactID) {
                        cVar.k().setText(HardCodeUtil.qqStr(R.string.l2h));
                        z16 = true;
                    }
                }
            } else {
                z16 = false;
            }
            if (!TextUtils.isEmpty(mVar.m())) {
                cVar.k().setText(mVar.m());
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

    @Override // qn2.f
    public void m(y yVar, sn2.c cVar) {
    }
}
