package zo2;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import yn2.c;

/* compiled from: P */
/* loaded from: classes18.dex */
public class a extends c {
    public Button H;
    private View I;

    public a(ViewGroup viewGroup, int i3) {
        super(viewGroup, i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // yn2.c, sn2.g
    public void a() {
        this.f434000e = (TextView) this.f433999d.findViewById(R.id.nickname);
        this.f434004m = (ImageView) this.f433999d.findViewById(R.id.f163821d);
        this.f434001f = (TextView) this.f433999d.findViewById(R.id.i95);
        Button button = (Button) this.f433999d.findViewById(R.id.i8s);
        this.H = button;
        button.setText(HardCodeUtil.qqStr(R.string.f170028dd));
        this.f434003i = (TextView) this.f433999d.findViewById(R.id.iz7);
        this.f434002h = (TextView) this.f433999d.findViewById(R.id.f166787i92);
        this.I = this.f433999d.findViewById(R.id.kab);
    }

    @Override // yn2.c
    public void p(boolean z16) {
        int i3;
        View view = this.I;
        if (view != null) {
            if (z16) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            view.setVisibility(i3);
        }
    }

    public Button q() {
        return this.H;
    }
}
