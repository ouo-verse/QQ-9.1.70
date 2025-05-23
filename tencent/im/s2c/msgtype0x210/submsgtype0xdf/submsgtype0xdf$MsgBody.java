package tencent.im.s2c.msgtype0x210.submsgtype0xdf;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import tencent.im.apollo_game_status$STCMGameMessage;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class submsgtype0xdf$MsgBody extends MessageMicro<submsgtype0xdf$MsgBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"msg_game_state", "rpt_uint32_uinList"}, new Object[]{null, 0}, submsgtype0xdf$MsgBody.class);
    public apollo_game_status$STCMGameMessage msg_game_state = new apollo_game_status$STCMGameMessage();
    public final PBRepeatField<Integer> rpt_uint32_uinList = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
}
