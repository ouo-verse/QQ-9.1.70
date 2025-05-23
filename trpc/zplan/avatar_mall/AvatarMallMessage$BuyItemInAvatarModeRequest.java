package trpc.zplan.avatar_mall;

import com.tencent.mobileqq.pb.MessageMicro;
import trpc.zplan.CsCommon$AvatarInfo;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class AvatarMallMessage$BuyItemInAvatarModeRequest extends MessageMicro<AvatarMallMessage$BuyItemInAvatarModeRequest> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"buy_items"}, new Object[]{null}, AvatarMallMessage$BuyItemInAvatarModeRequest.class);
    public CsCommon$AvatarInfo buy_items = new CsCommon$AvatarInfo();
}
