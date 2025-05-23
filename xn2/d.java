package xn2;

import android.text.TextUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.api.ISearchPieceFetcher;
import com.tencent.mobileqq.search.model.y;
import java.util.Set;
import mqq.app.MobileQQ;
import rn2.k;
import wn2.i;
import wn2.q;

/* compiled from: P */
/* loaded from: classes18.dex */
public class d extends c {

    /* renamed from: h, reason: collision with root package name */
    private Set<String> f448201h;

    public d(IFaceDecoder iFaceDecoder, com.tencent.mobileqq.search.view.d dVar, Set<String> set, Set<String> set2) {
        super(iFaceDecoder, dVar, set);
        this.f448201h = set2;
    }

    private void p(y yVar, sn2.c cVar) {
        RelativeLayout.LayoutParams layoutParams;
        if ((cVar instanceof yn2.c) && (yVar instanceof q)) {
            q qVar = (q) yVar;
            if (qVar.f445977e0 == 3 && cVar.getView() != null) {
                TextView textView = (TextView) cVar.getView().findViewById(R.id.i6s);
                CharSequence R = qVar.R();
                if (textView != null && !TextUtils.isEmpty(R)) {
                    textView.setVisibility(0);
                    textView.setText(R);
                }
                TextView b16 = cVar.b();
                if (b16 != null && (layoutParams = (RelativeLayout.LayoutParams) b16.getLayoutParams()) != null) {
                    layoutParams.addRule(15, 0);
                    b16.setLayoutParams(layoutParams);
                }
            }
        }
    }

    @Override // xn2.c, qn2.f, qn2.d
    /* renamed from: g */
    public void a(y yVar, sn2.c cVar) {
        super.a(yVar, cVar);
        if (cVar.k() != null) {
            String uin = yVar.getUin();
            Set<String> set = this.f448201h;
            if (set != null && set.contains(uin)) {
                cVar.k().setText(HardCodeUtil.qqStr(R.string.t9h));
            }
        }
        AppInterface appInterface = (AppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
        boolean d16 = k.d(appInterface, yVar.getUin());
        if (((ISearchPieceFetcher) QRoute.api(ISearchPieceFetcher.class)).isQQAppInterface(appInterface) && (cVar instanceof yn2.c)) {
            ((yn2.c) cVar).p(d16);
        }
        if (cVar.g() != null) {
            if (!(yVar instanceof q) && !(yVar instanceof wn2.a) && !(yVar instanceof i)) {
                if (cVar.k() != null) {
                    cVar.k().setVisibility(0);
                }
                cVar.g().setVisibility(8);
            } else {
                if (cVar.k() != null) {
                    cVar.k().setVisibility(8);
                }
                cVar.g().setVisibility(0);
            }
        }
        p(yVar, cVar);
    }

    @Override // qn2.f
    public void m(y yVar, sn2.c cVar) {
    }
}
