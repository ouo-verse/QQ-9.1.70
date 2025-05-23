package za0;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.factory.IQFSViewAttrParse;

/* compiled from: P */
/* loaded from: classes5.dex */
public class b implements IQFSViewAttrParse {
    @Override // cooperation.qqcircle.factory.IQFSViewAttrParse
    public boolean isNeedParse(String str) {
        return TextUtils.equals(str, "text");
    }

    @Override // cooperation.qqcircle.factory.IQFSViewAttrParse
    public void updateViewValue(View view, String str, String str2) {
        if (!(view instanceof TextView)) {
            return;
        }
        TextView textView = (TextView) view;
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        QLog.d("DTR-QFSTextViewAttrParse", 1, "[updateTextToView] view: " + view + " | text: " + str2);
        textView.setText(str2);
    }
}
