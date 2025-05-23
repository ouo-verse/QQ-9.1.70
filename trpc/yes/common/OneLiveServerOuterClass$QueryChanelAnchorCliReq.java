package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class OneLiveServerOuterClass$QueryChanelAnchorCliReq extends MessageMicro<OneLiveServerOuterClass$QueryChanelAnchorCliReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"GuildID", "ChannelID"}, new Object[]{"", ""}, OneLiveServerOuterClass$QueryChanelAnchorCliReq.class);
    public final PBStringField GuildID = PBField.initString("");
    public final PBStringField ChannelID = PBField.initString("");
}
