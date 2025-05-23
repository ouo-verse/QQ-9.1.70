package trpc.zplan.avatar_mall;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import trpc.zplan.CsCommon$RspHeader;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class AvatarMallMessage$UpdateAvatarInfoTemplatesReply extends MessageMicro<AvatarMallMessage$UpdateAvatarInfoTemplatesReply> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"rsp_header", "seq_id"}, new Object[]{null, 0}, AvatarMallMessage$UpdateAvatarInfoTemplatesReply.class);
    public CsCommon$RspHeader rsp_header = new CsCommon$RspHeader();
    public final PBUInt32Field seq_id = PBField.initUInt32(0);
}
