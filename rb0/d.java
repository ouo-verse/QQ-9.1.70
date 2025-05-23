package rb0;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes5.dex */
public class d implements b {
    @Override // rb0.b
    public int a() {
        return cx.a(62.0f);
    }

    @Override // rb0.b
    public int b() {
        return cx.a(40.0f);
    }

    @Override // rb0.b
    public int c() {
        return cx.a(8.0f);
    }

    @Override // rb0.b
    public View d(Context context) {
        View view = new View(context);
        view.setBackgroundColor(context.getResources().getColor(R.color.f157324c50));
        view.setLayoutParams(new LinearLayout.LayoutParams(cx.a(1.0f), -1));
        return view;
    }

    @Override // rb0.b
    public int e(Context context) {
        return context.getResources().getColor(R.color.c4v);
    }

    @Override // rb0.b
    public int f(Context context) {
        return context.getResources().getColor(R.color.c4w);
    }
}
