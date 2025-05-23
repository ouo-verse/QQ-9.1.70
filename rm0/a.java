package rm0;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes6.dex */
public class a implements d {

    /* renamed from: a, reason: collision with root package name */
    private TextView f431672a;

    /* renamed from: b, reason: collision with root package name */
    private ImageView f431673b;

    @Override // rm0.d
    public void a(long j3, long j16, long j17) {
        if (j3 > 0) {
            c.a(this.f431672a, HardCodeUtil.qqStr(R.string.n1f) + j16 + ReportConstant.COSTREPORT_PREFIX, 0);
            return;
        }
        c.a(this.f431672a, "", 8);
    }

    @Override // rm0.d
    public void b(ViewGroup viewGroup, b bVar) {
        viewGroup.addView(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.ecx, viewGroup, false));
        this.f431672a = (TextView) viewGroup.findViewById(R.id.vsl);
        ImageView imageView = (ImageView) viewGroup.findViewById(R.id.vsm);
        this.f431673b = imageView;
        bVar.f431674d = imageView;
        imageView.setOnClickListener(bVar);
        bVar.f431675e = viewGroup.findViewById(R.id.vsj);
        bVar.f431676f = viewGroup.findViewById(R.id.vs5);
        bVar.f431675e.setOnClickListener(bVar);
        TextView textView = (TextView) viewGroup.findViewById(R.id.vsk);
        bVar.f431677h = textView;
        textView.setOnClickListener(bVar);
        bVar.f431677h.setVisibility(8);
        if (bVar.F != 0) {
            bVar.f431675e.setVisibility(8);
        }
        TextView textView2 = this.f431672a;
        if (textView2 != null) {
            textView2.setClickable(true);
        }
    }

    @Override // rm0.d
    public void c(Context context, boolean z16) {
        if (this.f431673b == null) {
            QLog.i("GdtMvOldTitleFactory", 1, "refreshVoiceIconDrawableInner return");
            return;
        }
        QLog.i("GdtMvOldTitleFactory", 1, "refreshVoiceIconDrawableInner " + z16);
        if (z16) {
            c.b(this.f431673b, context.getResources().getDrawable(R.drawable.c6n), R.string.ipz);
        } else {
            c.b(this.f431673b, context.getResources().getDrawable(R.drawable.c6o), R.string.ipy);
        }
    }
}
