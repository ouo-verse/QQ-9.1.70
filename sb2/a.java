package sb2;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.tencent.mobileqq.app.BaseActivity;

/* compiled from: P */
/* loaded from: classes9.dex */
public class a {
    public static void a(BaseActivity baseActivity, RecyclerView.ViewHolder viewHolder) {
        b bVar = (b) viewHolder;
        bVar.f433615f.setText(wb2.a.b());
        bVar.f433614e.setImageDrawable(wb2.a.a(baseActivity));
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(baseActivity);
        linearLayoutManager.setOrientation(0);
        bVar.f433617i.setLayoutManager(linearLayoutManager);
        bVar.f433617i.setAdapter(new c(baseActivity, vb2.b.c().b()));
    }
}
