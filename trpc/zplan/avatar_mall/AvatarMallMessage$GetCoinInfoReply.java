package trpc.zplan.avatar_mall;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import trpc.zplan.CsCommon$RspHeader;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class AvatarMallMessage$GetCoinInfoReply extends MessageMicro<AvatarMallMessage$GetCoinInfoReply> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24}, new String[]{"rsp_header", "diamond", "bean"}, new Object[]{null, 0, 0}, AvatarMallMessage$GetCoinInfoReply.class);
    public CsCommon$RspHeader rsp_header = new CsCommon$RspHeader();
    public final PBUInt32Field diamond = PBField.initUInt32(0);
    public final PBUInt32Field bean = PBField.initUInt32(0);
}
