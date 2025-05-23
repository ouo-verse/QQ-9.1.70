package trpc.zplan.avatar_mall;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import trpc.zplan.CsCommon$RspHeader;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class AvatarMallMessage$QuerryIsRegistedReply extends MessageMicro<AvatarMallMessage$QuerryIsRegistedReply> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"rsp_header", "is_registed"}, new Object[]{null, Boolean.FALSE}, AvatarMallMessage$QuerryIsRegistedReply.class);
    public CsCommon$RspHeader rsp_header = new CsCommon$RspHeader();
    public final PBBoolField is_registed = PBField.initBool(false);
}
