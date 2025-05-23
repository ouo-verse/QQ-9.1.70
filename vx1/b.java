package vx1;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;

/* compiled from: P */
/* loaded from: classes14.dex */
public class b extends RecyclerView.ViewHolder {
    private TextView E;

    public b(@NonNull View view) {
        super(view);
        this.E = (TextView) view.findViewById(R.id.arv);
    }

    public static int m() {
        return R.layout.f66;
    }

    public void l(int i3, by1.b bVar) {
        int dip2px;
        if (i3 == 0) {
            dip2px = 0;
        } else {
            dip2px = ScreenUtil.dip2px(1.0f);
        }
        this.itemView.setPadding(0, dip2px, 0, 0);
        this.E.setText(bVar.b());
    }
}
