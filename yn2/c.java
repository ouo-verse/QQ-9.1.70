package yn2;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.search.util.aq;
import sn2.g;

/* compiled from: P */
/* loaded from: classes18.dex */
public class c extends g {
    private TextView F;
    private View G;

    public c(ViewGroup viewGroup, int i3) {
        super(viewGroup, i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // sn2.g
    public void a() {
        super.a();
        this.F = (TextView) this.f433999d.findViewById(R.id.iww);
        this.G = this.f433999d.findViewById(R.id.kab);
        if (aq.a()) {
            n(this.F, R.color.qui_common_text_primary);
            n(b(), R.color.qui_common_text_primary);
            n(k(), R.color.qui_common_text_secondary);
            n(c(), R.color.qui_common_text_secondary);
            View findViewById = this.f433999d.findViewById(R.id.dpr);
            if (findViewById == null) {
                return;
            }
            findViewById.setBackgroundResource(R.drawable.qui_common_fill_light_primary_bg_selector);
        }
    }

    public TextView o() {
        return this.F;
    }

    public void p(boolean z16) {
        int i3;
        View view = this.G;
        if (view != null) {
            if (z16) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            view.setVisibility(i3);
        }
    }

    public c(View view) {
        super(view);
    }
}
