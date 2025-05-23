package yg2;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qqexpand.utils.q;

/* compiled from: P */
/* loaded from: classes36.dex */
public class k extends RecyclerView.ViewHolder implements View.OnClickListener {

    /* renamed from: d, reason: collision with root package name */
    private final com.tencent.mobileqq.qqexpand.fragment.f f450303d;

    /* renamed from: e, reason: collision with root package name */
    private final TextView f450304e;

    public k(View view, com.tencent.mobileqq.qqexpand.fragment.f fVar) {
        super(view);
        this.f450303d = fVar;
        TextView textView = (TextView) view.findViewById(R.id.ker);
        this.f450304e = textView;
        textView.setOnClickListener(this);
        textView.setOnTouchListener(q.f264107a);
    }

    public void b(k kVar, com.tencent.mobileqq.qqexpand.bean.feed.b bVar) {
        String qqStr;
        int i3 = bVar.mFooterType;
        boolean z16 = false;
        if (i3 == 0) {
            qqStr = HardCodeUtil.qqStr(R.string.mnp);
        } else if (i3 == 1) {
            qqStr = HardCodeUtil.qqStr(R.string.mnr);
            z16 = true;
        } else if (i3 != 2) {
            qqStr = "";
        } else {
            qqStr = HardCodeUtil.qqStr(R.string.mnq);
        }
        kVar.f450304e.setText(qqStr);
        kVar.f450304e.setEnabled(z16);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.tencent.mobileqq.qqexpand.fragment.f fVar = this.f450303d;
        if (fVar != null) {
            fVar.M5();
        }
    }
}
