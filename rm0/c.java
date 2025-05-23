package rm0;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes6.dex */
public class c {
    public static void a(TextView textView, String str, int i3) {
        if (textView == null) {
            QLog.i("GdtMvTitleUtil", 1, "refreshCountDown view is null");
        } else {
            textView.setText(str);
            textView.setVisibility(i3);
        }
    }

    public static void b(ImageView imageView, Drawable drawable, int i3) {
        if (imageView == null) {
            QLog.i("GdtMvTitleUtil", 1, "refreshVoiceIcon view is null");
        } else {
            imageView.setImageDrawable(drawable);
            imageView.setContentDescription(HardCodeUtil.qqStr(i3));
        }
    }
}
