package qb4;

import com.tencent.mobileqq.utils.abtest.ABTestController;
import com.tencent.mobileqq.utils.abtest.ExpEntityInfo;
import com.tencent.util.AppSetting;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0006\u001a\u00020\u0002J\u0006\u0010\u0007\u001a\u00020\u0002J\u0006\u0010\b\u001a\u00020\u0004\u00a8\u0006\u000b"}, d2 = {"Lqb4/a;", "", "", "a", "", "d", "c", "b", "e", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f428794a = new a();

    a() {
    }

    public final boolean a() {
        return true;
    }

    public final boolean b() {
        return false;
    }

    public final boolean c() {
        return true;
    }

    public final String d() {
        return "exp_zplan_avatar_create_exp_E";
    }

    public final String e() {
        ExpEntityInfo expEntity;
        if (AppSetting.isPublicVersion() && !AppSetting.isGrayVersion()) {
            expEntity = ABTestController.getInstance().getExpEntity("exp_qqshow_avatar_create_8970");
        } else {
            expEntity = ABTestController.getInstance().getExpEntity("exp_qqshow_avatar_create_8970_gray");
        }
        Intrinsics.checkNotNullExpressionValue(expEntity, "if (AppSetting.isPublicV\u2026EATE_8970_GRAY)\n        }");
        expEntity.reportExpExposure();
        String assignment = expEntity.getAssignment();
        Intrinsics.checkNotNullExpressionValue(assignment, "entityInfo.assignment");
        return assignment;
    }
}
