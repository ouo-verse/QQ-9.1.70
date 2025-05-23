package q20;

import androidx.annotation.NonNull;
import java.util.Iterator;
import java.util.List;
import qqcircle.QQCircleEnvHub$CommentActivityInfo;

/* compiled from: P */
/* loaded from: classes4.dex */
public class i implements a {
    @Override // q20.a
    public int a() {
        return 1;
    }

    @Override // q20.a
    public boolean b(@NonNull QQCircleEnvHub$CommentActivityInfo qQCircleEnvHub$CommentActivityInfo, String str, boolean z16, List<String> list) {
        if (str == null) {
            str = "";
        }
        if (!d.d(qQCircleEnvHub$CommentActivityInfo, list)) {
            return false;
        }
        Iterator<String> it = qQCircleEnvHub$CommentActivityInfo.keyWords.get().iterator();
        while (it.hasNext()) {
            if (str.contains(it.next())) {
                return true;
            }
        }
        return false;
    }
}
