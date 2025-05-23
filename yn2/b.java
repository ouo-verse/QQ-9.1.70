package yn2;

import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.widget.ThemeImageView;

/* compiled from: P */
/* loaded from: classes18.dex */
public class b extends c {
    public Button H;

    public b(ViewGroup viewGroup, int i3) {
        super(viewGroup, i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // yn2.c, sn2.g
    public void a() {
        this.f434000e = (TextView) this.f433999d.findViewById(R.id.nickname);
        this.f434004m = (ImageView) this.f433999d.findViewById(R.id.f163821d);
        this.f434001f = (TextView) this.f433999d.findViewById(R.id.i95);
        this.f434003i = (TextView) this.f433999d.findViewById(R.id.iz7);
        Button button = (Button) this.f433999d.findViewById(R.id.i8s);
        this.H = button;
        button.setText(HardCodeUtil.qqStr(R.string.f170028dd));
        this.f434002h = (TextView) this.f433999d.findViewById(R.id.f166787i92);
        ImageView imageView = this.f434004m;
        if (imageView instanceof ThemeImageView) {
            ((ThemeImageView) imageView).setSupportMaskView(true);
        }
    }

    public Button q() {
        return this.H;
    }
}
