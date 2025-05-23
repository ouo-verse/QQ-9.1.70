package sx1;

import android.text.Editable;
import android.text.SpannableString;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes14.dex */
public class c {
    public boolean a(String str, String str2, String str3, boolean z16, boolean z17) {
        zo0.a a16 = ap0.f.a();
        if (a16 == null) {
            return false;
        }
        SpannableString o16 = com.tencent.guild.aio.input.at.utils.b.o(a16.f452872c, str, str2, a16.f452870a, z16);
        QLog.i("RobotInput", 1, "insertAtSpan: stringForQuickAt:" + ((Object) o16));
        if (TextUtils.isEmpty(o16)) {
            return false;
        }
        Editable editableText = a16.f452870a.getEditableText();
        editableText.clear();
        ap0.f.isAtListeningBlocked = true;
        if (z17) {
            ap0.f.isSlashListeningBlocked = true;
        } else {
            editableText.insert(0, o16);
        }
        editableText.insert(a16.f452870a.getSelectionStart(), str3 + " ");
        ap0.f.isAtListeningBlocked = false;
        a16.d(str, false, true);
        QLog.i("RobotInput", 1, "insertAtSpan: invoked.editableText: " + ((Object) editableText));
        return true;
    }
}
