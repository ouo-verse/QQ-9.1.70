package sy3;

import android.app.Dialog;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;

/* compiled from: P */
/* loaded from: classes25.dex */
public class a {
    public static void a(Dialog dialog) {
        if (dialog == null) {
            return;
        }
        String[] strArr = {"mDismissMessage", "mCancelMessage", "mShowMessage"};
        for (int i3 = 0; i3 < 3; i3++) {
            try {
                Field declaredField = Dialog.class.getDeclaredField(strArr[i3]);
                if (declaredField != null) {
                    if (!declaredField.isAccessible()) {
                        declaredField.setAccessible(true);
                    }
                    Object obj = declaredField.get(dialog);
                    if (obj instanceof Message) {
                        Message message = (Message) obj;
                        if (message.obj != null) {
                            message.obj = null;
                            message.what = 0;
                        }
                    }
                }
            } catch (IllegalAccessException e16) {
                QLog.e("ActivityLeakSolution", 1, "catch error = ", e16);
            } catch (IllegalArgumentException e17) {
                QLog.e("ActivityLeakSolution", 1, "catch error = ", e17);
            } catch (NoSuchFieldException e18) {
                QLog.e("ActivityLeakSolution", 1, "catch error = ", e18);
            } catch (Throwable th5) {
                QLog.e("ActivityLeakSolution", 1, "catch error = ", th5);
            }
        }
    }
}
