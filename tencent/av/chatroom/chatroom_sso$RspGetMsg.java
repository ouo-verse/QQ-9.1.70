package tencent.av.chatroom;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKCommonParamEnum;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class chatroom_sso$RspGetMsg extends MessageMicro<chatroom_sso$RspGetMsg> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 40}, new String[]{"result", "err_msg", "msg_list", TVKCommonParamEnum.REQ_PARAM_KEY_RETRY, "retry_delay"}, new Object[]{0, "", null, Boolean.FALSE, 0L}, chatroom_sso$RspGetMsg.class);
    public final PBUInt32Field result = PBField.initUInt32(0);
    public final PBStringField err_msg = PBField.initString("");
    public final PBRepeatMessageField<chatroom_sso$Msg> msg_list = PBField.initRepeatMessage(chatroom_sso$Msg.class);
    public final PBBoolField retry = PBField.initBool(false);
    public final PBUInt64Field retry_delay = PBField.initUInt64(0);
}
