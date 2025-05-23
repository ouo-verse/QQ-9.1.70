package trpc.zplan.avatar_mall;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import trpc.zplan.CsCommon$AvatarInfo;
import trpc.zplan.CsCommon$RspHeader;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class AvatarMallMessage$GetMyAvatarInfoReply extends MessageMicro<AvatarMallMessage$GetMyAvatarInfoReply> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 42}, new String[]{"rsp_header", "avatar_info", "diamond", "bean", "face_info"}, new Object[]{null, null, 0, 0, null}, AvatarMallMessage$GetMyAvatarInfoReply.class);
    public CsCommon$RspHeader rsp_header = new CsCommon$RspHeader();
    public CsCommon$AvatarInfo avatar_info = new CsCommon$AvatarInfo();
    public final PBUInt32Field diamond = PBField.initUInt32(0);
    public final PBUInt32Field bean = PBField.initUInt32(0);
    public CsCommon$AvatarInfo face_info = new CsCommon$AvatarInfo();
}
