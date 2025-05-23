package zf2;

import com.tencent.mobileqq.qqecommerce.biz.messagecenter.api.model.MessageType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\b\u00a2\u0006\u0004\b\f\u0010\rR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\u000b\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\t\u001a\u0004\b\u0003\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lzf2/e;", "Lzf2/b;", "Lcom/tencent/mobileqq/qqecommerce/biz/messagecenter/api/model/c;", "a", "Lcom/tencent/mobileqq/qqecommerce/biz/messagecenter/api/model/c;", "b", "()Lcom/tencent/mobileqq/qqecommerce/biz/messagecenter/api/model/c;", "type", "Lcom/tencent/mobileqq/qqecommerce/biz/messagecenter/api/model/e;", "Lcom/tencent/mobileqq/qqecommerce/biz/messagecenter/api/model/e;", "()Lcom/tencent/mobileqq/qqecommerce/biz/messagecenter/api/model/e;", "status", "<init>", "(Lcom/tencent/mobileqq/qqecommerce/biz/messagecenter/api/model/c;Lcom/tencent/mobileqq/qqecommerce/biz/messagecenter/api/model/e;)V", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class e extends b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final MessageType type;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final com.tencent.mobileqq.qqecommerce.biz.messagecenter.api.model.e status;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(MessageType type, com.tencent.mobileqq.qqecommerce.biz.messagecenter.api.model.e status) {
        super(null);
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(status, "status");
        this.type = type;
        this.status = status;
    }

    /* renamed from: a, reason: from getter */
    public final com.tencent.mobileqq.qqecommerce.biz.messagecenter.api.model.e getStatus() {
        return this.status;
    }

    /* renamed from: b, reason: from getter */
    public final MessageType getType() {
        return this.type;
    }
}
