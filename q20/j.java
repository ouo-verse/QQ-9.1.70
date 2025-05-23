package q20;

import androidx.annotation.NonNull;
import java.util.List;
import qqcircle.QQCircleEnvHub$CommentActivityInfo;

/* compiled from: P */
/* loaded from: classes4.dex */
public class j implements a {
    @Override // q20.a
    public int a() {
        return 4;
    }

    @Override // q20.a
    public boolean b(@NonNull QQCircleEnvHub$CommentActivityInfo qQCircleEnvHub$CommentActivityInfo, String str, boolean z16, List<String> list) {
        if (!d.d(qQCircleEnvHub$CommentActivityInfo, list)) {
            return false;
        }
        return z16;
    }
}
