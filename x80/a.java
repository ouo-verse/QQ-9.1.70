package x80;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.launcher.QCircleSchemeLauncher;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes4.dex */
abstract class a extends b implements View.OnClickListener {
    protected View J;
    private TextView K;
    private View L;

    @IdRes
    private final int M;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(int i3) {
        this.M = i3;
    }

    private void j1() {
        String h16 = h1();
        if (TextUtils.isEmpty(h16)) {
            QLog.w(w0(), 1, "#jumpToMore: url is empty");
        } else {
            QCircleSchemeLauncher.f(this.L.getContext(), h16);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void N0(@NonNull View view) {
        super.N0(view);
        View findViewById = view.findViewById(this.M);
        this.J = findViewById;
        this.K = (TextView) findViewById.findViewById(R.id.f52912b3);
        View findViewById2 = this.J.findViewById(R.id.f52902b2);
        this.L = findViewById2;
        findViewById2.setOnClickListener(this);
    }

    protected abstract String h1();

    protected abstract String i1();

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: k1, reason: merged with bridge method [inline-methods] */
    public void L0(w80.c cVar, int i3) {
        super.L0(cVar, i3);
        this.K.setText(i1());
        if (TextUtils.isEmpty(h1())) {
            this.L.setVisibility(8);
        } else {
            this.L.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view == this.L) {
            j1();
        }
        EventCollector.getInstance().onViewClicked(view);
    }
}
