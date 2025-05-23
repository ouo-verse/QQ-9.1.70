package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class MessageOuterClass$LiveRoomLotteryResultMsg extends MessageMicro<MessageOuterClass$LiveRoomLotteryResultMsg> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"h5_msg", "task_id"}, new Object[]{null, 0}, MessageOuterClass$LiveRoomLotteryResultMsg.class);
    public MessageOuterClass$H5Msg h5_msg = new MessageOuterClass$H5Msg();
    public final PBInt32Field task_id = PBField.initInt32(0);
}
