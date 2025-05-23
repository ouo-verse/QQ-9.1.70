package vk2;

import com.tencent.mobileqq.data.QQWalletAioBodyReserve;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001Ba\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0013\u001a\u00020\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0004\u0012\u0006\u0010\u001a\u001a\u00020\u0004\u0012\u0006\u0010\u001d\u001a\u00020\u0004\u0012\u0006\u0010 \u001a\u00020\u0004\u0012\b\u0010#\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010%\u001a\u0004\u0018\u00010\u0002\u0012\f\u0010+\u001a\b\u0012\u0004\u0012\u00020'0&\u0012\u0006\u0010-\u001a\u00020\u0004\u00a2\u0006\u0004\b.\u0010/J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0013\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0010\u0010\u0012R\u0017\u0010\u0017\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u001a\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0014\u001a\u0004\b\u0019\u0010\u0016R\u0017\u0010\u001d\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u0014\u001a\u0004\b\u001c\u0010\u0016R\u0017\u0010 \u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u0014\u001a\u0004\b\u001f\u0010\u0016R\u0019\u0010#\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010!\u001a\u0004\b\u001b\u0010\"R\u0019\u0010%\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b$\u0010!\u001a\u0004\b\n\u0010\"R\u001d\u0010+\u001a\b\u0012\u0004\u0012\u00020'0&8\u0006\u00a2\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b\u001e\u0010*R\u0017\u0010-\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b,\u0010\u0014\u001a\u0004\b\u0018\u0010\u0016\u00a8\u00060"}, d2 = {"Lvk2/c;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lvk2/b;", "a", "Lvk2/b;", "c", "()Lvk2/b;", "elem", "Lcom/tencent/mobileqq/data/QQWalletAioBodyReserve;", "b", "Lcom/tencent/mobileqq/data/QQWalletAioBodyReserve;", "()Lcom/tencent/mobileqq/data/QQWalletAioBodyReserve;", "body", "I", "getChannelId", "()I", "channelId", "d", "g", "templateId", "e", "getResend", "resend", "f", "getRedType", "redType", "Ljava/lang/String;", "()Ljava/lang/String;", "redPacketId", h.F, "authkey", "", "", "i", "Ljava/util/List;", "()Ljava/util/List;", "specifyUinList", "j", "redChannel", "<init>", "(Lvk2/b;Lcom/tencent/mobileqq/data/QQWalletAioBodyReserve;IIIILjava/lang/String;Ljava/lang/String;Ljava/util/List;I)V", "qqpay-api_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: vk2.c, reason: from toString */
/* loaded from: classes16.dex */
public final /* data */ class QWalletHbModel {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final b elem;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final QQWalletAioBodyReserve body;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final int channelId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final int templateId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final int resend;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private final int redType;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String redPacketId;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String authkey;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final List<Long> specifyUinList;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata and from toString */
    private final int redChannel;

    public QWalletHbModel(@NotNull b elem, @NotNull QQWalletAioBodyReserve body, int i3, int i16, int i17, int i18, @Nullable String str, @Nullable String str2, @NotNull List<Long> specifyUinList, int i19) {
        Intrinsics.checkNotNullParameter(elem, "elem");
        Intrinsics.checkNotNullParameter(body, "body");
        Intrinsics.checkNotNullParameter(specifyUinList, "specifyUinList");
        this.elem = elem;
        this.body = body;
        this.channelId = i3;
        this.templateId = i16;
        this.resend = i17;
        this.redType = i18;
        this.redPacketId = str;
        this.authkey = str2;
        this.specifyUinList = specifyUinList;
        this.redChannel = i19;
    }

    @Nullable
    /* renamed from: a, reason: from getter */
    public final String getAuthkey() {
        return this.authkey;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final QQWalletAioBodyReserve getBody() {
        return this.body;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final b getElem() {
        return this.elem;
    }

    /* renamed from: d, reason: from getter */
    public final int getRedChannel() {
        return this.redChannel;
    }

    @Nullable
    /* renamed from: e, reason: from getter */
    public final String getRedPacketId() {
        return this.redPacketId;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof QWalletHbModel)) {
            return false;
        }
        QWalletHbModel qWalletHbModel = (QWalletHbModel) other;
        if (Intrinsics.areEqual(this.elem, qWalletHbModel.elem) && Intrinsics.areEqual(this.body, qWalletHbModel.body) && this.channelId == qWalletHbModel.channelId && this.templateId == qWalletHbModel.templateId && this.resend == qWalletHbModel.resend && this.redType == qWalletHbModel.redType && Intrinsics.areEqual(this.redPacketId, qWalletHbModel.redPacketId) && Intrinsics.areEqual(this.authkey, qWalletHbModel.authkey) && Intrinsics.areEqual(this.specifyUinList, qWalletHbModel.specifyUinList) && this.redChannel == qWalletHbModel.redChannel) {
            return true;
        }
        return false;
    }

    @NotNull
    public final List<Long> f() {
        return this.specifyUinList;
    }

    /* renamed from: g, reason: from getter */
    public final int getTemplateId() {
        return this.templateId;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2 = ((((((((((this.elem.hashCode() * 31) + this.body.hashCode()) * 31) + this.channelId) * 31) + this.templateId) * 31) + this.resend) * 31) + this.redType) * 31;
        String str = this.redPacketId;
        int i3 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int i16 = (hashCode2 + hashCode) * 31;
        String str2 = this.authkey;
        if (str2 != null) {
            i3 = str2.hashCode();
        }
        return ((((i16 + i3) * 31) + this.specifyUinList.hashCode()) * 31) + this.redChannel;
    }

    @NotNull
    public String toString() {
        return "QWalletHbModel(elem=" + this.elem + ", body=" + this.body + ", channelId=" + this.channelId + ", templateId=" + this.templateId + ", resend=" + this.resend + ", redType=" + this.redType + ", redPacketId=" + this.redPacketId + ", authkey=" + this.authkey + ", specifyUinList=" + this.specifyUinList + ", redChannel=" + this.redChannel + ')';
    }
}
