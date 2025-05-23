package sx2;

import android.content.Context;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.tvideo.danmaku.manager.l;
import com.tencent.qphone.base.util.QLog;
import uz3.k;

/* compiled from: P */
/* loaded from: classes19.dex */
public class b extends i70.a {
    public b(Context context) {
        super(context);
    }

    @Override // uz3.k
    public int h(Object obj) {
        if (!(obj instanceof m70.a)) {
            return 1;
        }
        m70.a aVar = (m70.a) obj;
        if (l.i(aVar.a())) {
            return 30;
        }
        if (i70.b.b(aVar)) {
            return 2;
        }
        if (!i70.b.a(aVar)) {
            return 1;
        }
        return 3;
    }

    @Override // uz3.k
    public k.a k(int i3) {
        Context o16 = o();
        if (o16 == null) {
            QLog.d("QDM-TVideoBarrageHolderAdapter", 1, "[onCreateViewHolder] context should not be null.");
            return null;
        }
        if (i3 == 1) {
            return p(o16);
        }
        if (i3 == 2) {
            return n(o16);
        }
        if (i3 == 3) {
            return n(o16);
        }
        if (i3 != 30) {
            return null;
        }
        return new f(o16);
    }

    public k.a p(@NonNull Context context) {
        try {
            return new e(context);
        } catch (Throwable th5) {
            QLog.e("QDM-TVideoBarrageHolderAdapter", 1, "[createNormalBarrageHolder] error: ", th5);
            return null;
        }
    }
}
