package x80;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.immersive.views.search.util.ad;
import com.tencent.biz.qqcircle.launcher.QCircleSchemeLauncher;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.RoundRectImageView;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes4.dex */
public abstract class c extends x80.a {
    private static final int Q = ViewUtils.dip2px(4.0f);
    private a N;

    @LayoutRes
    private final int P;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a extends v80.a<w80.h, b> {
        a() {
        }

        @Override // v80.a
        protected int i0() {
            return c.this.P;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // v80.a
        /* renamed from: m0, reason: merged with bridge method [inline-methods] */
        public b j0(View view) {
            return new b(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class b extends v80.b<w80.h> implements View.OnClickListener {
        private final RoundRectImageView G;
        private final TextView H;
        private final TextView I;
        private final TextView J;

        b(@NonNull View view) {
            super(view);
            RoundRectImageView roundRectImageView = (RoundRectImageView) view.findViewById(R.id.f53202bv);
            this.G = roundRectImageView;
            this.H = (TextView) view.findViewById(R.id.f53212bw);
            this.I = (TextView) view.findViewById(R.id.f53192bu);
            TextView textView = (TextView) view.findViewById(R.id.f53182bt);
            this.J = textView;
            view.setOnClickListener(this);
            textView.setOnClickListener(this);
            roundRectImageView.setCornerRadiusAndMode(c.Q, 1);
        }

        /* JADX WARN: Multi-variable type inference failed */
        private void o() {
            q(((w80.h) this.E).f444992d);
        }

        /* JADX WARN: Multi-variable type inference failed */
        private void p() {
            q(((w80.h) this.E).f444994f);
        }

        private void q(String str) {
            if (TextUtils.isEmpty(str)) {
                QLog.w(c.this.w0(), 1, "#jumpToUrl: url is empty");
            } else {
                QCircleSchemeLauncher.f(this.itemView.getContext(), str);
            }
        }

        private void s(w80.h hVar) {
            HashMap hashMap = new HashMap();
            hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_TRANSFER_INFO, hVar.f444995g);
            ua0.i.k(this.itemView, c.this.o1(), hashMap, hVar.hashCode());
            String n16 = c.this.n1();
            if (!TextUtils.isEmpty(n16)) {
                ua0.i.k(this.J, n16, hashMap, hVar.hashCode());
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        private void t() {
            if (TextUtils.isEmpty(((w80.h) this.E).f444992d)) {
                this.J.setVisibility(8);
                return;
            }
            this.J.setVisibility(0);
            String str = ((w80.h) this.E).f444993e;
            if (!TextUtils.isEmpty(str)) {
                this.J.setText(str);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        private void u() {
            if (TextUtils.isEmpty(((w80.h) this.E).f444991c)) {
                this.I.setVisibility(8);
            } else {
                this.I.setVisibility(0);
                this.I.setText(((w80.h) this.E).f444991c);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (view == this.J) {
                o();
            } else if (view == this.itemView) {
                p();
            }
            EventCollector.getInstance().onViewClicked(view);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // v80.b
        /* renamed from: r, reason: merged with bridge method [inline-methods] */
        public void m(w80.h hVar, int i3) {
            ad.s(this.G, hVar.f444989a);
            this.H.setText(hVar.f444990b);
            u();
            t();
            s(hVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(int i3, int i16) {
        super(i16);
        this.P = i3;
    }

    @Override // x80.a, com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void N0(@NonNull View view) {
        super.N0(view);
        RecyclerView recyclerView = (RecyclerView) this.J.findViewById(R.id.f53062bh);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        a aVar = new a();
        this.N = aVar;
        recyclerView.setAdapter(aVar);
    }

    @Override // x80.a, com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: k1 */
    public void L0(w80.c cVar, int i3) {
        List<w80.h> p16 = p1();
        if (p16 != null && !p16.isEmpty()) {
            super.L0(cVar, i3);
            this.J.setVisibility(0);
            this.N.setData(p16);
            return;
        }
        this.J.setVisibility(8);
    }

    @Nullable
    protected abstract String n1();

    @NonNull
    protected abstract String o1();

    protected abstract List<w80.h> p1();
}
