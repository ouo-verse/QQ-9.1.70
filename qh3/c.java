package qh3;

import com.tencent.mobileqq.zplan.authorize.impl.manager.CheckPhoneManager;
import kotlin.Metadata;
import qh3.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016\u00a8\u0006\t"}, d2 = {"Lqh3/c;", "Lqh3/b;", "", "getSceneType", "b", "Lcom/tencent/mobileqq/zplan/authorize/impl/manager/CheckPhoneManager$EntryType;", "a", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public abstract class c implements b {
    @Override // qh3.b
    public CheckPhoneManager.EntryType a() {
        return CheckPhoneManager.EntryType.PAGE;
    }

    @Override // qh3.b
    public int b() {
        return 0;
    }

    @Override // qh3.b
    public boolean d() {
        return b.a.e(this);
    }

    @Override // qh3.b
    public int getPageId() {
        return b.a.b(this);
    }

    @Override // qh3.b
    public int getSceneId() {
        return b.a.c(this);
    }

    @Override // qh3.b
    public int getSceneType() {
        return 0;
    }
}
