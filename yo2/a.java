package yo2;

import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.libra.LoadState;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.search.business.net.view.c;
import com.tencent.mobileqq.search.searchdetail.content.wxminapp.report.sugreport.NetSearchSugWXReport;
import com.tencent.mobileqq.search.searchdetail.multimedia.o;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.qphone.base.util.QLog;
import lo2.ag;

/* compiled from: P */
/* loaded from: classes18.dex */
public class a extends c {
    private LinearLayout M;
    private TextView N;
    private ImageView P;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: yo2.a$a, reason: collision with other inner class name */
    /* loaded from: classes18.dex */
    public class C11625a implements IPicLoadStateListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ag f450726d;

        C11625a(ag agVar) {
            this.f450726d = agVar;
        }

        @Override // com.tencent.libra.listener.IPicLoadStateListener
        public void onStateChange(LoadState loadState, Option option) {
            if (loadState == LoadState.STATE_SUCCESS && !this.f450726d.X().iconColorToken.isEmpty()) {
                Integer c16 = o.f284545a.c(this.f450726d.X().iconColorToken, a.this.M.getContext());
                Drawable drawable = a.this.P.getDrawable();
                if (c16 != null && drawable != null) {
                    drawable.setColorFilter(new PorterDuffColorFilter(c16.intValue(), PorterDuff.Mode.SRC_IN));
                }
            }
        }
    }

    public a(ViewGroup viewGroup, int i3) {
        super(viewGroup, i3);
    }

    private void s(ag agVar) {
        if (!TextUtils.isEmpty(agVar.X().iconLink)) {
            t(agVar);
        } else if (!TextUtils.isEmpty(agVar.X().iconToken)) {
            w(agVar);
        } else {
            ImageView imageView = this.P;
            imageView.setImageDrawable(imageView.getContext().getDrawable(R.drawable.qvideo_skin_icon_general_search_secondary));
        }
    }

    private void t(ag agVar) {
        o.f284545a.f("NetSearchTemplateSuggestWordsView", this.P, agVar.X().iconLink, new C11625a(agVar));
    }

    private void u(ag agVar) {
        if (!TextUtils.isEmpty(agVar.a0())) {
            this.N.setText(agVar.a0());
            this.N.setVisibility(0);
        } else {
            this.N.setVisibility(8);
        }
    }

    private void v(ag agVar) {
        TextView b16 = b();
        if (b16 != null) {
            CharSequence titleSpans = agVar.getTitleSpans();
            String keyword = agVar.getKeyword();
            if (!TextUtils.isEmpty(titleSpans) && !TextUtils.isEmpty(keyword) && (titleSpans instanceof String)) {
                titleSpans = SearchUtils.G((String) titleSpans, keyword, true);
            }
            b16.setText(titleSpans);
            n(b16, R.color.qui_common_text_primary);
        }
    }

    private void w(ag agVar) {
        Integer c16;
        try {
            o oVar = o.f284545a;
            Drawable e16 = oVar.e(this.M.getContext(), agVar.X().iconToken);
            if (!agVar.X().iconColorToken.isEmpty() && (c16 = oVar.c(agVar.X().iconColorToken, this.M.getContext())) != null && e16 != null) {
                e16.setColorFilter(new PorterDuffColorFilter(c16.intValue(), PorterDuff.Mode.SRC_IN));
            }
            this.P.setImageDrawable(e16);
        } catch (Exception e17) {
            QLog.e("NetSearchTemplateSuggestWordsView", 1, "loadTokenImage error", e17);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.search.business.net.view.c, sn2.g
    public void a() {
        super.a();
        View j3 = j(this.E);
        if (j3 != null) {
            LinearLayout linearLayout = (LinearLayout) j3.findViewById(R.id.ecl);
            this.M = linearLayout;
            this.N = (TextView) linearLayout.findViewById(R.id.f97925lp);
            this.P = (ImageView) this.M.findViewById(R.id.icon);
        }
    }

    public void r(ag agVar) {
        LinearLayout linearLayout = this.M;
        if (linearLayout != null && linearLayout.getParent() != null) {
            ((View) this.M.getParent()).setPadding(0, 0, 0, 0);
        }
        if (agVar == null) {
            QLog.e("NetSearchTemplateSuggestWordsView", 1, "bindData error item is null!!");
            return;
        }
        v(agVar);
        s(agVar);
        u(agVar);
        if (!agVar.f415118e0) {
            NetSearchSugWXReport netSearchSugWXReport = NetSearchSugWXReport.f284428a;
            if (netSearchSugWXReport.f(agVar.Z().sugWordType, agVar.Y())) {
                netSearchSugWXReport.g(NetSearchSugWXReport.ReqBusinessType.LOCAL_SEARCH, NetSearchSugWXReport.SugReportActionType.IMPL, agVar.Y, agVar.Z, agVar.N, agVar.getTitleSpans().toString(), agVar.Y());
                agVar.f415118e0 = true;
            }
        }
    }
}
