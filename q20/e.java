package q20;

import android.util.SparseArray;
import androidx.annotation.NonNull;
import java.util.List;
import qqcircle.QQCircleEnvHub$CommentActivityInfo;

/* compiled from: P */
/* loaded from: classes4.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private static final SparseArray<a> f428222a = new SparseArray<>();

    static {
        c(new i());
        c(new c());
        c(new j());
        c(new f());
        c(new g());
        c(new b());
        c(new h());
    }

    public static a a(int i3) {
        return f428222a.get(i3);
    }

    public static boolean b(@NonNull QQCircleEnvHub$CommentActivityInfo qQCircleEnvHub$CommentActivityInfo, String str, boolean z16, List<String> list) {
        a a16 = a(qQCircleEnvHub$CommentActivityInfo.commentTriggerType.get());
        if (a16 != null && a16.b(qQCircleEnvHub$CommentActivityInfo, str, z16, list)) {
            return true;
        }
        return false;
    }

    private static void c(a aVar) {
        f428222a.put(aVar.a(), aVar);
    }
}
