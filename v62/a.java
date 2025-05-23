package v62;

import com.tencent.biz.common.util.HttpUtil;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0003\u001a\u00020\u0002H\u0007\u00a8\u0006\u0006"}, d2 = {"Lv62/a;", "", "", "a", "<init>", "()V", "kandian_feature_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f441187a = new a();

    a() {
    }

    @JvmStatic
    public static final int a() {
        switch (HttpUtil.getNetWorkTypeContain5G()) {
            case 0:
            default:
                return 0;
            case 1:
            case 5:
                return 4;
            case 2:
                return 1;
            case 3:
                return 2;
            case 4:
                return 3;
            case 6:
                return 5;
        }
    }
}
