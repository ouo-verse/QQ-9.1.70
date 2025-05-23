package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes30.dex */
public final class MessageOuterClass$PowerRedpacketLotteryResultMsg extends MessageMicro<MessageOuterClass$PowerRedpacketLotteryResultMsg> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"h5_msg", "activity_id"}, new Object[]{null, ""}, MessageOuterClass$PowerRedpacketLotteryResultMsg.class);
    public MessageOuterClass$H5Msg h5_msg = new MessageOuterClass$H5Msg();
    public final PBStringField activity_id = PBField.initString("");
}
