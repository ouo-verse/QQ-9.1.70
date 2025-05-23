package ro2;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.RoundFrameLayout;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.trpcprotocol.unite.unifysearch.head_template.HeadTemplatePB$SearchTemplateResp;

/* compiled from: P */
/* loaded from: classes18.dex */
public class a extends b implements View.OnClickListener {
    private ImageView C;
    private TextView D;
    private View E;

    /* renamed from: i, reason: collision with root package name */
    private c f431802i;

    /* renamed from: m, reason: collision with root package name */
    private RoundFrameLayout f431803m;

    @Override // ro2.b
    public void d(HeadTemplatePB$SearchTemplateResp headTemplatePB$SearchTemplateResp, int i3, int i16) {
        boolean z16;
        boolean z17;
        boolean z18;
        super.d(headTemplatePB$SearchTemplateResp, i3, i16);
        this.f431803m.setVisibility(8);
        this.E.setVisibility(8);
        if (b(headTemplatePB$SearchTemplateResp)) {
            return;
        }
        boolean has = headTemplatePB$SearchTemplateResp.header.has();
        boolean isEmpty = TextUtils.isEmpty(headTemplatePB$SearchTemplateResp.image.text.get());
        if (has) {
            z16 = TextUtils.isEmpty(headTemplatePB$SearchTemplateResp.header.title.get());
            z17 = TextUtils.isEmpty(headTemplatePB$SearchTemplateResp.header.description.get());
            z18 = TextUtils.isEmpty(headTemplatePB$SearchTemplateResp.header.button.text.get());
        } else {
            z16 = true;
            z17 = true;
            z18 = true;
        }
        if (!isEmpty || !z16 || !z17 || !z18) {
            this.E.setVisibility(0);
        }
        this.f431803m.setVisibility(0);
        so2.a.a(this.f431803m, headTemplatePB$SearchTemplateResp.image.report_info.get(), i16);
        this.D.setText(headTemplatePB$SearchTemplateResp.image.text.get());
        String str = headTemplatePB$SearchTemplateResp.image.image.get();
        QLog.i("QCircleSearchGameUnionBannerPresenter", 1, "imgUrl:" + str);
        if (!TextUtils.isEmpty(str)) {
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            Drawable drawable = com.tencent.mobileqq.urldrawable.b.f306350a;
            obtain.mFailedDrawable = drawable;
            obtain.mLoadingDrawable = drawable;
            this.C.setImageDrawable(URLDrawable.getDrawable(str, obtain));
        }
        this.f431802i.d(headTemplatePB$SearchTemplateResp, i3, i16);
    }

    @Override // ro2.b
    public void e(View view) {
        super.e(view);
        RoundFrameLayout roundFrameLayout = (RoundFrameLayout) view.findViewById(R.id.f52472_w);
        this.f431803m = roundFrameLayout;
        this.C = (ImageView) roundFrameLayout.findViewById(R.id.f52972b9);
        this.D = (TextView) this.f431803m.findViewById(R.id.f52482_x);
        this.E = view.findViewById(R.id.f52442_t);
        this.f431803m.setRadius(ViewUtils.dip2px(4.0f));
        this.f431803m.setOnClickListener(this);
        c cVar = new c();
        this.f431802i = cVar;
        cVar.f(true);
        this.f431802i.e(this.f431803m.findViewById(R.id.f53102bl));
    }

    public void f() {
        ((LinearLayout.LayoutParams) this.f431803m.getLayoutParams()).bottomMargin = ViewUtils.dip2px(16.0f);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view == this.f431803m) {
            a("QCircleSearchGameUnionBannerPresenter", this.f431805e.image.scheme.get());
        }
        EventCollector.getInstance().onViewClicked(view);
    }
}
