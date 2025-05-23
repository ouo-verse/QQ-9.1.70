package q20;

import androidx.annotation.NonNull;
import com.tencent.biz.richframework.part.utils.RFSafeListUtils;
import java.util.Iterator;
import java.util.List;
import qqcircle.QQCircleEnvHub$CommentActivityInfo;

/* compiled from: P */
/* loaded from: classes4.dex */
public abstract class d implements a {
    public static boolean d(@NonNull QQCircleEnvHub$CommentActivityInfo qQCircleEnvHub$CommentActivityInfo, List<String> list) {
        List<String> list2 = qQCircleEnvHub$CommentActivityInfo.topicID.get();
        if (RFSafeListUtils.isEmpty(list2)) {
            return true;
        }
        Iterator<String> it = list2.iterator();
        while (it.hasNext()) {
            if (list.contains(it.next())) {
                return true;
            }
        }
        return false;
    }

    @Override // q20.a
    public final int a() {
        int i3 = 0;
        for (int i16 : c()) {
            i3 |= i16;
        }
        return i3;
    }

    @Override // q20.a
    public final boolean b(@NonNull QQCircleEnvHub$CommentActivityInfo qQCircleEnvHub$CommentActivityInfo, String str, boolean z16, List<String> list) {
        for (int i3 : c()) {
            a a16 = e.a(i3);
            if (a16 == null || !a16.b(qQCircleEnvHub$CommentActivityInfo, str, z16, list)) {
                return false;
            }
        }
        return true;
    }

    @NonNull
    protected abstract int[] c();
}
