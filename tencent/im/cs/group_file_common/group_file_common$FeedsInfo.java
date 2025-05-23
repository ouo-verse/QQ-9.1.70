package tencent.im.cs.group_file_common;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import msf.msgsvc.msg_ctrl$MsgCtrl;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class group_file_common$FeedsInfo extends MessageMicro<group_file_common$FeedsInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34, 40, 50, 58, 64}, new String[]{"uint32_bus_id", "str_file_id", "uint32_msg_random", "bytes_ext", "uint32_feed_flag", "msg_ctrl", "str_download_url", "uint32_file_from_scene"}, new Object[]{0, "", 0, ByteStringMicro.EMPTY, 0, null, "", 0}, group_file_common$FeedsInfo.class);
    public final PBUInt32Field uint32_bus_id = PBField.initUInt32(0);
    public final PBStringField str_file_id = PBField.initString("");
    public final PBUInt32Field uint32_msg_random = PBField.initUInt32(0);
    public final PBBytesField bytes_ext = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_feed_flag = PBField.initUInt32(0);
    public msg_ctrl$MsgCtrl msg_ctrl = new msg_ctrl$MsgCtrl();
    public final PBStringField str_download_url = PBField.initString("");
    public final PBUInt32Field uint32_file_from_scene = PBField.initUInt32(0);
}
