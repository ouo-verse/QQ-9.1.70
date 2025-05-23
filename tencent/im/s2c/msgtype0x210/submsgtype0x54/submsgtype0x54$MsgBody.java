package tencent.im.s2c.msgtype0x210.submsgtype0x54;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.transfile.ProtocolDownloaderConstants;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class submsgtype0x54$MsgBody extends MessageMicro<submsgtype0x54$MsgBody> {
    public static final int TYPE_C2C = 1;
    public static final int TYPE_DISCUSS = 2;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"peer_type", ProtocolDownloaderConstants.HEADER_FRIEND_UIN, "task_list"}, new Object[]{1, 0L, null}, submsgtype0x54$MsgBody.class);
    public final PBEnumField peer_type = PBField.initEnum(1);
    public final PBUInt64Field peer_uin = PBField.initUInt64(0);
    public final PBRepeatMessageField<TaskInfo> task_list = PBField.initRepeatMessage(TaskInfo.class);

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class TaskInfo extends MessageMicro<TaskInfo> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"task_id"}, new Object[]{0}, TaskInfo.class);
        public final PBUInt32Field task_id = PBField.initUInt32(0);
    }
}
