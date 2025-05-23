package ro2;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.trpcprotocol.unite.unifysearch.head_template.HeadTemplatePB$SearchTemplateResp;
import com.tencent.widget.RoundRectImageView;

/* compiled from: P */
/* loaded from: classes18.dex */
public class c extends b implements View.OnClickListener {
    private TextView C;
    private TextView D;
    private QUIButton E;
    private boolean F;
    private int G = -2;

    /* renamed from: i, reason: collision with root package name */
    private View f431808i;

    /* renamed from: m, reason: collision with root package name */
    private RoundRectImageView f431809m;

    @Override // ro2.b
    public void d(HeadTemplatePB$SearchTemplateResp headTemplatePB$SearchTemplateResp, int i3, int i16) {
        int i17;
        super.d(headTemplatePB$SearchTemplateResp, i3, i16);
        this.f431808i.setVisibility(8);
        if (!headTemplatePB$SearchTemplateResp.header.has()) {
            this.f431806f = true;
            return;
        }
        if (!this.F && !b(headTemplatePB$SearchTemplateResp)) {
            this.f431806f = true;
            return;
        }
        this.f431806f = false;
        so2.a.a(this.f431808i, headTemplatePB$SearchTemplateResp.header.report_info.get(), i16);
        String str = headTemplatePB$SearchTemplateResp.header.icon.get();
        if (str.isEmpty()) {
            this.f431809m.setVisibility(8);
        } else {
            this.f431809m.setVisibility(0);
            this.f431809m.setImageDrawable(URLDrawable.getDrawable(str));
        }
        this.C.setText(headTemplatePB$SearchTemplateResp.header.title.get());
        String str2 = headTemplatePB$SearchTemplateResp.header.description.get();
        if (TextUtils.isEmpty(str2)) {
            this.D.setVisibility(8);
        } else {
            this.D.setVisibility(0);
            this.D.setText(str2);
        }
        String str3 = headTemplatePB$SearchTemplateResp.header.button.text.get();
        if (TextUtils.isEmpty(str3)) {
            this.E.setVisibility(8);
        } else {
            this.E.setVisibility(0);
            this.E.setText(str3);
            if (this.G < 0) {
                this.G = this.E.getLayoutParams().width;
            }
            ViewGroup.LayoutParams layoutParams = this.E.getLayoutParams();
            if (str3.length() >= 4) {
                i17 = -2;
            } else {
                i17 = this.G;
            }
            layoutParams.width = i17;
            so2.a.a(this.E, headTemplatePB$SearchTemplateResp.header.button.report_info.get(), i16);
        }
        if (!str.isEmpty() || !TextUtils.isEmpty(str2) || !TextUtils.isEmpty(str3)) {
            this.f431808i.setVisibility(0);
        }
    }

    @Override // ro2.b
    public void e(View view) {
        super.e(view);
        this.f431808i = view;
        this.f431809m = (RoundRectImageView) view.findViewById(R.id.f53072bi);
        this.C = (TextView) view.findViewById(R.id.f53122bn);
        this.D = (TextView) view.findViewById(R.id.f53092bk);
        this.E = (QUIButton) view.findViewById(R.id.f53082bj);
        this.f431809m.setCornerRadiusAndMode(ViewUtils.dip2px(4.0f), 1);
        this.f431808i.setOnClickListener(this);
        this.E.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(boolean z16) {
        this.F = z16;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view == this.f431808i) {
            a("QCircleSearchGameUnionHeadPresenter", this.f431805e.header.scheme.get());
        } else if (view == this.E) {
            a("QCircleSearchGameUnionHeadPresenter", this.f431805e.header.button.scheme.get());
        }
        EventCollector.getInstance().onViewClicked(view);
    }
}
