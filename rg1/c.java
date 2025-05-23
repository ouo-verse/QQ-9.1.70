package rg1;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.ViewUtils;

/* compiled from: P */
/* loaded from: classes12.dex */
public class c implements a {
    @Override // rg1.a
    public int a() {
        return ViewUtils.dip2px(62.0f);
    }

    @Override // rg1.a
    public int b() {
        return ViewUtils.dip2px(40.0f);
    }

    @Override // rg1.a
    public int c() {
        return ViewUtils.dip2px(8.0f);
    }

    @Override // rg1.a
    public View d(Context context) {
        View view = new View(context);
        view.setBackgroundColor(context.getResources().getColor(R.color.f157324c50));
        view.setLayoutParams(new LinearLayout.LayoutParams(ViewUtils.dip2px(1.0f), -1));
        return view;
    }

    @Override // rg1.a
    public int e(Context context) {
        return context.getResources().getColor(R.color.c4v);
    }

    @Override // rg1.a
    public int f(Context context) {
        return context.getResources().getColor(R.color.c4w);
    }
}
