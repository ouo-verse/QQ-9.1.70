package x80;

import android.text.TextUtils;
import android.util.Size;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.immersive.views.search.game.union.widget.QFSSearchGameUnionButtonContainer;
import com.tencent.biz.qqcircle.widgets.QCircleAvatarView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class g extends b {
    private static final int S = ViewUtils.dip2px(20.0f);
    private TextView J;
    private TextView K;
    private QCircleAvatarView L;
    private QCircleAvatarView M;
    private QCircleAvatarView N;
    private TextView P;
    private QFSSearchGameUnionButtonContainer Q;
    private w80.e R;

    private void i1() {
        String str = this.R.f444977b;
        if (TextUtils.isEmpty(str)) {
            this.K.setVisibility(8);
        } else {
            this.K.setVisibility(0);
            this.K.setText(str);
        }
    }

    private void j1(boolean z16) {
        if (z16) {
            String str = this.R.f444978c;
            if (!TextUtils.isEmpty(str)) {
                this.P.setVisibility(0);
                this.P.setText(str);
            }
        }
    }

    private void k1() {
        this.P.setVisibility(8);
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(this.L);
        arrayList.add(this.M);
        arrayList.add(this.N);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((QCircleAvatarView) it.next()).setVisibility(8);
        }
        List<w80.f> list = this.R.f444979d;
        if (list.isEmpty()) {
            QLog.i("QCircleSearchGameUnionHeadPresenter", 1, "#setupUsers: no user");
            return;
        }
        int i3 = S;
        Size size = new Size(i3, i3);
        boolean z16 = false;
        for (w80.f fVar : list) {
            if (arrayList.isEmpty()) {
                break;
            }
            String str = fVar.f444982a;
            if (!TextUtils.isEmpty(str)) {
                QCircleAvatarView qCircleAvatarView = (QCircleAvatarView) arrayList.remove(0);
                qCircleAvatarView.setAvatarByUrl(str, size);
                qCircleAvatarView.setVisibility(0);
                z16 = true;
            }
        }
        j1(z16);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void N0(@NonNull View view) {
        super.N0(view);
        this.J = (TextView) view.findViewById(R.id.f53122bn);
        this.K = (TextView) view.findViewById(R.id.f53092bk);
        this.L = (QCircleAvatarView) view.findViewById(R.id.f53132bo);
        this.M = (QCircleAvatarView) view.findViewById(R.id.f53142bp);
        this.N = (QCircleAvatarView) view.findViewById(R.id.f53152bq);
        this.P = (TextView) view.findViewById(R.id.f53162br);
        this.Q = (QFSSearchGameUnionButtonContainer) view.findViewById(R.id.f53082bj);
        this.L.h();
        this.M.h();
        this.N.h();
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: h1, reason: merged with bridge method [inline-methods] */
    public void L0(w80.c cVar, int i3) {
        super.L0(cVar, i3);
        w80.e eVar = cVar.f444964b;
        this.R = eVar;
        this.J.setText(eVar.f444976a);
        this.Q.e(cVar, this.I);
        i1();
        k1();
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: w0 */
    public String getTAG() {
        return "QCircleSearchGameUnionHeadPresenter";
    }
}
