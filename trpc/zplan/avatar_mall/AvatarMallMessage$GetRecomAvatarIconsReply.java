package trpc.zplan.avatar_mall;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import trpc.zplan.CsCommon$RecomAvatarIcon;
import trpc.zplan.CsCommon$RspHeader;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class AvatarMallMessage$GetRecomAvatarIconsReply extends MessageMicro<AvatarMallMessage$GetRecomAvatarIconsReply> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24}, new String[]{"rsp_header", "recom_avatar_icons", "total_icon_nums"}, new Object[]{null, null, 0}, AvatarMallMessage$GetRecomAvatarIconsReply.class);
    public CsCommon$RspHeader rsp_header = new CsCommon$RspHeader();
    public final PBRepeatMessageField<CsCommon$RecomAvatarIcon> recom_avatar_icons = PBField.initRepeatMessage(CsCommon$RecomAvatarIcon.class);
    public final PBUInt32Field total_icon_nums = PBField.initUInt32(0);
}
