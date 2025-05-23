package x83;

import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u001e\u0010\t\u001a\u00020\u00032\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005H\u0016J\b\u0010\n\u001a\u00020\u0003H\u0016J\u001e\u0010\u000b\u001a\u00020\u00032\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005H&\u00a8\u0006\u000e"}, d2 = {"Lx83/b;", "Lx83/a;", "", "", "i", "", "", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "mediaList", "k", "g", "j", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public abstract class b extends a {
    @Override // x83.a
    public boolean g() {
        return j(null);
    }

    @Override // x83.a
    public boolean i() {
        return k(null);
    }

    public abstract boolean j(@Nullable Map<String, ? extends LocalMediaInfo> mediaList);

    public boolean k(@Nullable Map<String, ? extends LocalMediaInfo> mediaList) {
        Integer num;
        String c16 = c();
        if (mediaList != null) {
            num = Integer.valueOf(mediaList.size());
        } else {
            num = null;
        }
        QLog.d(c16, 1, "startProcess, media size:" + num);
        if (!e(true)) {
            QLog.d(c(), 1, "startProcess, isSwitchOpen is false ");
            h();
            return false;
        }
        return j(mediaList);
    }
}
