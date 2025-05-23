package qn2;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.api.IPublicAccountHandler;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.api.ISearchPieceFetcher;
import com.tencent.mobileqq.search.model.t;
import com.tencent.mobileqq.search.model.v;
import com.tencent.mobileqq.search.model.y;
import com.tencent.mobileqq.search.model.z;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.search.util.al;
import com.tencent.mobileqq.search.util.am;
import com.tencent.mobileqq.search.util.x;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import rn2.k;
import wn2.q;

/* compiled from: P */
/* loaded from: classes18.dex */
public class f implements c<y, sn2.c>, b {

    /* renamed from: d, reason: collision with root package name */
    protected IFaceDecoder f429094d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ y f429095d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ sn2.c f429096e;

        a(y yVar, sn2.c cVar) {
            this.f429095d = yVar;
            this.f429096e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            QLog.d("SearchResultPresenter", 1, "presenter.class:" + getClass().getName() + "   model.class:" + this.f429095d.getClass().getName() + "  view.class:" + this.f429096e.getClass().getName());
            this.f429095d.v(view);
            y yVar = this.f429095d;
            if (yVar instanceof z) {
                al.b((z) yVar);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public f(IFaceDecoder iFaceDecoder) {
        this.f429094d = iFaceDecoder;
    }

    private void j(y yVar, sn2.c cVar) {
        TextView c16;
        if (com.tencent.mobileqq.search.util.y.a() && (c16 = cVar.c()) != null && !TextUtils.isEmpty(c16.getText())) {
            if ((yVar instanceof q) || (yVar instanceof wn2.f) || (yVar instanceof wn2.a)) {
                c16.setTextColor(c16.getResources().getColor(R.color.qui_common_text_primary));
            }
        }
    }

    public void b(v vVar, View view, int i3, int i16) {
        if (vVar instanceof z) {
            String valueOf = String.valueOf(((y) vVar).u());
            z zVar = (z) vVar;
            if (zVar.x() == 13) {
                valueOf = String.valueOf(zVar.m());
            }
            am.t(view, valueOf, x.e(vVar), zVar.z(), i3, i16, String.valueOf(vVar.hashCode()), vVar.h(), x.g(vVar), x.c(vVar));
        }
    }

    @Override // qn2.d
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public void a(y yVar, sn2.c cVar) {
        m(yVar, cVar);
        k(cVar, yVar);
        if (cVar.c() != null) {
            cVar.c().setText(yVar.t());
        }
        if (cVar.k() != null) {
            cVar.k().setText(yVar.m());
        }
        if (cVar.d() != null) {
            cVar.d().setText(yVar.o());
        }
        if (cVar.g() != null) {
            if (yVar.r() && !com.tencent.mobileqq.search.util.y.d()) {
                cVar.g().setVisibility(0);
            } else {
                cVar.g().setVisibility(8);
            }
        }
        h(yVar, cVar);
        j(yVar, cVar);
        if (yVar instanceof lo2.d) {
            try {
                ImageView imageView = (ImageView) cVar.getView().findViewById(R.id.f167121l13);
                ImageView imageView2 = (ImageView) cVar.getView().findViewById(R.id.bat);
                TextView textView = (TextView) cVar.getView().findViewById(R.id.d9e);
                if (imageView != null && imageView2 != null && textView != null) {
                    imageView.setVisibility(4);
                    imageView2.setVisibility(4);
                    textView.setVisibility(4);
                }
                lo2.d dVar = (lo2.d) yVar;
                int dimensionPixelSize = cVar.getView().getResources().getDimensionPixelSize(R.dimen.f159238y4);
                cVar.f().setImageDrawable(URLDrawable.getDrawable(dVar.G(), dimensionPixelSize, dimensionPixelSize));
                if (dVar.I() != null && dVar.I().video_article.has() && dVar.I().video_article.get() == SearchUtils.f284958g && imageView != null && imageView2 != null) {
                    imageView.setVisibility(0);
                    imageView2.getBackground().setAlpha(25);
                    imageView2.setVisibility(0);
                }
                if (((lo2.d) yVar).H() != null && textView != null) {
                    textView.setVisibility(0);
                    if (cVar.b() != null) {
                        cVar.b().setMaxWidth(SearchUtils.l(190.0f, cVar.getView().getResources()));
                    }
                    if (dVar.H() != null) {
                        ((IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "", "0X8006F27", "0X8006F27", 0, 0, dVar.s(), dVar.H().hotword.get(), String.valueOf(dVar.H().hotword_type.get()), "");
                    }
                }
                if (yVar.m() == null) {
                    cVar.k().setVisibility(8);
                }
            } catch (Exception e16) {
                QLog.d("SearchResultPresenter", 1, "groupnetsearch model construct error:" + e16.toString());
            }
        } else {
            c(yVar, cVar);
        }
        if (!TextUtils.isEmpty(yVar.l())) {
            try {
                if (TextUtils.equals(yVar.l(), String.valueOf(((ISearchPieceFetcher) QRoute.api(ISearchPieceFetcher.class)).getShoppingAccount()))) {
                    ((IMiniAppService) QRoute.api(IMiniAppService.class)).reportEshopExpo("search", "");
                }
            } catch (Exception e17) {
                QLog.e("SearchResultPresenter", 1, "report expo failed", e17);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void h(y yVar, sn2.c cVar) {
        View view = cVar.getView();
        if (view != null) {
            view.setOnClickListener(new a(yVar, cVar));
        }
    }

    @Override // qn2.c
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public void c(y yVar, sn2.c cVar) {
        if (cVar.f() != null && !(yVar instanceof lo2.d) && (yVar instanceof t)) {
            cVar.f().setImageDrawable(SearchUtils.u(this.f429094d, yVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void k(sn2.c cVar, y yVar) {
        if (cVar.b() != null && yVar != null) {
            cVar.b().setText(yVar.u());
        }
    }

    @Override // qn2.c
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public void f(y yVar, sn2.c cVar, Bitmap bitmap) {
        if (cVar.f() != null && !(yVar instanceof lo2.d)) {
            cVar.f().setImageBitmap(bitmap);
        }
    }

    public void m(y yVar, sn2.c cVar) {
        int i3;
        View view = cVar.getView();
        if (yVar.p() == 0) {
            Integer num = (Integer) view.getTag(R.id.kxa);
            Integer num2 = (Integer) view.getTag(R.id.kxc);
            if (num != null && num2 != null) {
                k.e(yVar, num.intValue(), num2.intValue());
            }
        }
        int p16 = yVar.p();
        int q16 = yVar.q();
        if (yVar instanceof z) {
            i3 = ((z) yVar).f283548i;
        } else {
            i3 = 0;
        }
        k.b(p16, q16, view, i3);
    }
}
