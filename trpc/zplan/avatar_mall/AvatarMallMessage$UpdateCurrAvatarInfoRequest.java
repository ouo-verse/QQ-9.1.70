package trpc.zplan.avatar_mall;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import trpc.zplan.CsCommon$AvatarInfo;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class AvatarMallMessage$UpdateCurrAvatarInfoRequest extends MessageMicro<AvatarMallMessage$UpdateCurrAvatarInfoRequest> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"avatar_info", "seq_id"}, new Object[]{null, 0}, AvatarMallMessage$UpdateCurrAvatarInfoRequest.class);
    public CsCommon$AvatarInfo avatar_info = new CsCommon$AvatarInfo();
    public final PBUInt32Field seq_id = PBField.initUInt32(0);
}
