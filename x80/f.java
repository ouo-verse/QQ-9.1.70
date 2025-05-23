package x80;

import android.graphics.Typeface;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.immersive.views.search.util.ad;
import com.tencent.biz.qqcircle.launcher.QCircleSchemeLauncher;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.RoundRectImageView;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class f extends x80.a {
    private static final int Q = ViewUtils.dip2px(4.0f);
    private List<View> N;
    private w80.d P;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a extends v80.b<w80.h> implements View.OnClickListener {
        private final RoundRectImageView G;
        private final TextView H;
        private final TextView I;

        a(@NonNull View view) {
            super(view);
            RoundRectImageView roundRectImageView = (RoundRectImageView) view.findViewById(R.id.f53202bv);
            this.G = roundRectImageView;
            this.H = (TextView) view.findViewById(R.id.f53212bw);
            TextView textView = (TextView) view.findViewById(R.id.f53192bu);
            this.I = textView;
            roundRectImageView.setCornerRadiusAndMode(f.Q, 1);
            textView.setTypeface(Typeface.DEFAULT_BOLD);
            view.setOnClickListener(this);
        }

        private CharSequence n(@NonNull String str) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
            if (!str.startsWith("\uffe5")) {
                spannableStringBuilder.insert(0, (CharSequence) "\uffe5");
            }
            spannableStringBuilder.setSpan(new AbsoluteSizeSpan(15, true), 0, 1, 34);
            int indexOf = str.indexOf(".");
            if (indexOf > 0) {
                spannableStringBuilder.setSpan(new AbsoluteSizeSpan(15, true), indexOf + 1, str.length(), 34);
            }
            return spannableStringBuilder;
        }

        private void p(w80.h hVar) {
            HashMap hashMap = new HashMap();
            hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_TRANSFER_INFO, hVar.f444995g);
            ua0.i.k(this.itemView, f.this.I.h(), hashMap, hVar.hashCode());
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // v80.b
        /* renamed from: o, reason: merged with bridge method [inline-methods] */
        public void m(w80.h hVar, int i3) {
            ad.s(this.G, hVar.f444989a);
            this.H.setText(hVar.f444990b);
            String str = hVar.f444991c;
            if (TextUtils.isEmpty(str)) {
                this.I.setVisibility(8);
            } else {
                this.I.setVisibility(0);
                this.I.setText(n(str));
            }
            p(hVar);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            String str = ((w80.h) this.E).f444994f;
            if (TextUtils.isEmpty(str)) {
                QLog.w("QCircleSearchGameUnionGoodsPresenter", 1, "#onClick: url is empty");
            } else {
                QCircleSchemeLauncher.f(view.getContext(), str);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public f() {
        super(R.id.f53012bc);
    }

    private a m1(View view) {
        Object tag = view.getTag();
        if (tag instanceof a) {
            return (a) tag;
        }
        a aVar = new a(view);
        view.setTag(aVar);
        return aVar;
    }

    private void n1(List<w80.h> list) {
        Iterator<View> it = this.N.iterator();
        while (it.hasNext()) {
            it.next().setVisibility(4);
        }
        int min = Math.min(list.size(), this.N.size());
        for (int i3 = 0; i3 < min; i3++) {
            w80.h hVar = list.get(i3);
            View view = this.N.get(i3);
            view.setVisibility(0);
            m1(view).l(hVar, i3);
        }
    }

    @Override // x80.a, com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void N0(@NonNull View view) {
        super.N0(view);
        View findViewById = this.J.findViewById(R.id.f53022bd);
        View findViewById2 = this.J.findViewById(R.id.f53032be);
        View findViewById3 = this.J.findViewById(R.id.f53042bf);
        ArrayList arrayList = new ArrayList(3);
        this.N = arrayList;
        arrayList.add(findViewById);
        this.N.add(findViewById2);
        this.N.add(findViewById3);
    }

    @Override // x80.a
    protected String h1() {
        return this.P.f444975c;
    }

    @Override // x80.a
    protected String i1() {
        return this.P.f444974b;
    }

    @Override // x80.a, com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: k1 */
    public void L0(w80.c cVar, int i3) {
        w80.d dVar = cVar.f444968f;
        this.P = dVar;
        if (dVar.f444973a.isEmpty()) {
            this.J.setVisibility(8);
            return;
        }
        super.L0(cVar, i3);
        this.J.setVisibility(0);
        n1(this.P.f444973a);
    }

    @Override // x80.a, android.view.View.OnClickListener
    public /* bridge */ /* synthetic */ void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        super.onClick(view);
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: w0 */
    public String getTAG() {
        return "QCircleSearchGameUnionGoodsPresenter";
    }
}
