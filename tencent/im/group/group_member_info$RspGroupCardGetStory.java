package tencent.im.group;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class group_member_info$RspGroupCardGetStory extends MessageMicro<group_member_info$RspGroupCardGetStory> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26}, new String[]{"result", "flag", "video_info"}, new Object[]{null, 0, null}, group_member_info$RspGroupCardGetStory.class);
    public group_member_info$ErrorInfo result = new MessageMicro<group_member_info$ErrorInfo>() { // from class: tencent.im.group.group_member_info$ErrorInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"error_code", "error_desc"}, new Object[]{0, ByteStringMicro.EMPTY}, group_member_info$ErrorInfo.class);
        public final PBUInt32Field error_code = PBField.initUInt32(0);
        public final PBBytesField error_desc = PBField.initBytes(ByteStringMicro.EMPTY);
    };
    public final PBUInt32Field flag = PBField.initUInt32(0);
    public final PBRepeatMessageField<group_member_info$InfoCardVideoInfo> video_info = PBField.initRepeatMessage(group_member_info$InfoCardVideoInfo.class);
}
