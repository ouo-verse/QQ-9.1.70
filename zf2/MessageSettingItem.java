package zf2;

import com.tencent.mobileqq.qqecommerce.biz.messagecenter.api.model.MessageType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u001d\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u00c6\u0001J\t\u0010\b\u001a\u00020\u0007H\u00d6\u0001J\t\u0010\n\u001a\u00020\tH\u00d6\u0001J\u0013\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0005\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0017"}, d2 = {"Lzf2/c;", "", "Lcom/tencent/mobileqq/qqecommerce/biz/messagecenter/api/model/c;", "type", "Lcom/tencent/mobileqq/qqecommerce/biz/messagecenter/api/model/e;", "status", "a", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/mobileqq/qqecommerce/biz/messagecenter/api/model/c;", "d", "()Lcom/tencent/mobileqq/qqecommerce/biz/messagecenter/api/model/c;", "b", "Lcom/tencent/mobileqq/qqecommerce/biz/messagecenter/api/model/e;", "c", "()Lcom/tencent/mobileqq/qqecommerce/biz/messagecenter/api/model/e;", "<init>", "(Lcom/tencent/mobileqq/qqecommerce/biz/messagecenter/api/model/c;Lcom/tencent/mobileqq/qqecommerce/biz/messagecenter/api/model/e;)V", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: zf2.c, reason: from toString */
/* loaded from: classes36.dex */
public final /* data */ class MessageSettingItem {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final MessageType type;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final com.tencent.mobileqq.qqecommerce.biz.messagecenter.api.model.e status;

    public MessageSettingItem(MessageType type, com.tencent.mobileqq.qqecommerce.biz.messagecenter.api.model.e status) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(status, "status");
        this.type = type;
        this.status = status;
    }

    public final MessageSettingItem a(MessageType type, com.tencent.mobileqq.qqecommerce.biz.messagecenter.api.model.e status) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(status, "status");
        return new MessageSettingItem(type, status);
    }

    /* renamed from: c, reason: from getter */
    public final com.tencent.mobileqq.qqecommerce.biz.messagecenter.api.model.e getStatus() {
        return this.status;
    }

    /* renamed from: d, reason: from getter */
    public final MessageType getType() {
        return this.type;
    }

    public int hashCode() {
        return (this.type.hashCode() * 31) + this.status.hashCode();
    }

    public String toString() {
        return "MessageSettingItem(type=" + this.type + ", status=" + this.status + ")";
    }

    public static /* synthetic */ MessageSettingItem b(MessageSettingItem messageSettingItem, MessageType messageType, com.tencent.mobileqq.qqecommerce.biz.messagecenter.api.model.e eVar, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            messageType = messageSettingItem.type;
        }
        if ((i3 & 2) != 0) {
            eVar = messageSettingItem.status;
        }
        return messageSettingItem.a(messageType, eVar);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MessageSettingItem)) {
            return false;
        }
        MessageSettingItem messageSettingItem = (MessageSettingItem) other;
        return Intrinsics.areEqual(this.type, messageSettingItem.type) && Intrinsics.areEqual(this.status, messageSettingItem.status);
    }
}
