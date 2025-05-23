package x80;

import android.os.MessageQueue;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.immersive.views.search.util.ad;
import com.tencent.biz.qqcircle.launcher.QCircleSchemeLauncher;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.HashMap;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class i extends x80.b implements View.OnClickListener {
    private RecyclerView J;
    private View K;
    private View L;
    private List<w80.f> M;
    private a N;
    private boolean P;

    @LayoutRes
    private final int Q;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a extends v80.a<w80.f, b> {
        a() {
        }

        @Override // v80.a
        protected int i0() {
            return i.this.Q;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // v80.a
        /* renamed from: m0, reason: merged with bridge method [inline-methods] */
        public b j0(View view) {
            return new b(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class b extends v80.b<w80.f> implements View.OnClickListener {
        private final ImageView G;
        private final TextView H;

        b(@NonNull View view) {
            super(view);
            this.G = (ImageView) view.findViewById(R.id.f53202bv);
            this.H = (TextView) view.findViewById(R.id.f53212bw);
            view.setOnClickListener(this);
        }

        private void o(w80.f fVar) {
            HashMap hashMap = new HashMap();
            hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_TRANSFER_INFO, fVar.f444985d);
            ua0.i.k(this.itemView, i.this.I.b(), hashMap, fVar.hashCode());
        }

        @Override // v80.b
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public void m(w80.f fVar, int i3) {
            ad.s(this.G, fVar.f444982a);
            this.H.setText(fVar.f444983b);
            o(fVar);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            String str = ((w80.f) this.E).f444984c;
            if (TextUtils.isEmpty(str)) {
                QLog.w("QCircleSearchGameUnionIconPresenter", 1, "#onClick: url is empty");
            } else {
                QCircleSchemeLauncher.f(this.itemView.getContext(), str);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public i(int i3) {
        this.Q = i3;
    }

    private void j1() {
        HashMap hashMap = new HashMap();
        hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_FOLD_UNFOLD_TYPE, QCircleDaTongConstant.ElementParamValue.PYMK_FOLD);
        View view = this.L;
        ua0.i.k(view, QCircleDaTongConstant.ElementId.EM_XSJ_FOLD_UNFOLD_BUTTON, hashMap, view.hashCode());
    }

    private void k1() {
        RecyclerView recyclerView = this.J;
        recyclerView.setLayoutManager(new GridLayoutManager(recyclerView.getContext(), 4));
        a aVar = new a();
        this.N = aVar;
        this.J.setAdapter(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean l1() {
        VideoReport.traverseExposure();
        return false;
    }

    private void n1() {
        HashMap hashMap = new HashMap();
        hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_FOLD_UNFOLD_TYPE, WinkDaTongReportConstant.ElementParamValue.XSJ_CHOOSE_ARRPOSID_STATE_UNFOLD);
        View view = this.K;
        ua0.i.k(view, QCircleDaTongConstant.ElementId.EM_XSJ_FOLD_UNFOLD_BUTTON, hashMap, view.hashCode());
    }

    private void o1() {
        if (this.M.size() <= 4) {
            this.N.setData(this.M);
            this.K.setVisibility(8);
            this.L.setVisibility(8);
        } else if (this.P) {
            this.N.setData(this.M);
            this.K.setVisibility(8);
            this.L.setVisibility(0);
            j1();
        } else {
            this.N.setData(this.M.subList(0, 4));
            this.K.setVisibility(0);
            this.L.setVisibility(8);
            n1();
        }
        RFWThreadManager.getUIHandler().getLooper().getQueue().addIdleHandler(new MessageQueue.IdleHandler() { // from class: x80.h
            @Override // android.os.MessageQueue.IdleHandler
            public final boolean queueIdle() {
                boolean l16;
                l16 = i.l1();
                return l16;
            }
        });
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void N0(@NonNull View view) {
        super.N0(view);
        this.J = (RecyclerView) view.findViewById(R.id.f53172bs);
        this.K = view.findViewById(R.id.f53312c6);
        this.L = view.findViewById(R.id.f52992ba);
        this.K.setOnClickListener(this);
        this.L.setOnClickListener(this);
        k1();
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: m1, reason: merged with bridge method [inline-methods] */
    public void L0(w80.c cVar, int i3) {
        super.L0(cVar, i3);
        List<w80.f> list = cVar.f444965c;
        this.M = list;
        this.P = false;
        if (list.isEmpty()) {
            this.J.setVisibility(8);
            this.K.setVisibility(8);
            this.L.setVisibility(8);
        } else {
            this.J.setVisibility(0);
            o1();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view == this.K || view == this.L) {
            EventCollector.getInstance().onViewClicked(view);
            this.P = !this.P;
            o1();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: w0 */
    public String getTAG() {
        return "QCircleSearchGameUnionIconPresenter";
    }
}
