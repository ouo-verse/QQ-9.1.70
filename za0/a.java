package za0;

import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.qqcircle.widgets.person.QFSSettingSwitchView;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.factory.IQFSViewAttrParse;

/* compiled from: P */
/* loaded from: classes5.dex */
public class a implements IQFSViewAttrParse {
    @Override // cooperation.qqcircle.factory.IQFSViewAttrParse
    public boolean isNeedParse(String str) {
        if (!TextUtils.equals(str, "hint") && !TextUtils.equals(str, "title")) {
            return false;
        }
        return true;
    }

    @Override // cooperation.qqcircle.factory.IQFSViewAttrParse
    public void updateViewValue(View view, String str, String str2) {
        if (!(view instanceof QFSSettingSwitchView)) {
            return;
        }
        QFSSettingSwitchView qFSSettingSwitchView = (QFSSettingSwitchView) view;
        if (TextUtils.equals(str, "hint")) {
            qFSSettingSwitchView.setHide(str2);
        } else if (TextUtils.equals(str, "title")) {
            qFSSettingSwitchView.setTitle(str2);
        }
        QLog.d("DTR-QFSSettingSwitchAttrParse", 1, "[updateTextToView] view: " + view + " | attributeName: " + str + " | value: " + str2);
    }
}
