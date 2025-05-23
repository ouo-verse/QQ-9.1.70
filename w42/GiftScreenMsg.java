package w42;

import com.tencent.mobileqq.icgame.data.gift.GiftMessage;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\n\u00a2\u0006\u0004\b\u0014\u0010\u0015J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lw42/d;", "Lw42/f;", "", "toString", "", "hashCode", "", "other", "", "equals", "Lcom/tencent/mobileqq/icgame/data/gift/GiftMessage;", "d", "Lcom/tencent/mobileqq/icgame/data/gift/GiftMessage;", "b", "()Lcom/tencent/mobileqq/icgame/data/gift/GiftMessage;", "giftMessage", "Lw42/i;", "e", "Lw42/i;", "msgHeader", "<init>", "(Lcom/tencent/mobileqq/icgame/data/gift/GiftMessage;)V", "ic-game-widget-kit_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: w42.d, reason: from toString */
/* loaded from: classes15.dex */
public final /* data */ class GiftScreenMsg implements f {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final GiftMessage giftMessage;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final i msgHeader;

    public GiftScreenMsg(@NotNull GiftMessage giftMessage) {
        Intrinsics.checkNotNullParameter(giftMessage, "giftMessage");
        this.giftMessage = giftMessage;
        this.msgHeader = new i();
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final GiftMessage getGiftMessage() {
        return this.giftMessage;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if ((other instanceof GiftScreenMsg) && Intrinsics.areEqual(this.giftMessage, ((GiftScreenMsg) other).giftMessage)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.giftMessage.hashCode();
    }

    @NotNull
    public String toString() {
        return "GiftScreenMsg(giftMessage=" + this.giftMessage + ')';
    }
}
