package tencent.im.group_pro_proto.msgpush;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.weiyun.transmission.db.JobDbManager;
import tencent.im.group_pro_proto.common.common$Msg;

/* loaded from: classes29.dex */
public final class msgpush$MsgOnlinePush extends MessageMicro<msgpush$MsgOnlinePush> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field compress_flag;
    public final PBBytesField compress_msg;
    public msgpush$FocusInfo focus_info;
    public final PBUInt32Field huge_flag;
    public final PBBytesField server_buf;
    public final PBRepeatMessageField<common$Msg> msgs = PBField.initRepeatMessage(common$Msg.class);
    public final PBUInt32Field general_flag = PBField.initUInt32(0);
    public final PBUInt32Field need_resp = PBField.initUInt32(0);

    static {
        String[] strArr = {"msgs", "general_flag", "need_resp", "server_buf", JobDbManager.COL_UP_COMPRESS_FLAG, "compress_msg", "focus_info", "huge_flag"};
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 34, 40, 50, 58, 64}, strArr, new Object[]{null, 0, 0, byteStringMicro, 0, byteStringMicro, null, 0}, msgpush$MsgOnlinePush.class);
    }

    public msgpush$MsgOnlinePush() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.server_buf = PBField.initBytes(byteStringMicro);
        this.compress_flag = PBField.initUInt32(0);
        this.compress_msg = PBField.initBytes(byteStringMicro);
        this.focus_info = new msgpush$FocusInfo();
        this.huge_flag = PBField.initUInt32(0);
    }
}
