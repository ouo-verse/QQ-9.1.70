package tencent.im.msg;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class obj_msg$ObjMsg extends MessageMicro<obj_msg$ObjMsg> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_title;
    public final PBBytesField bytes_title_ext;
    public final PBRepeatMessageField<obj_msg$MsgContentInfo> msg_content_info;
    public final PBRepeatField<ByteStringMicro> rpt_bytes_abstact;
    public final PBRepeatMessageField<obj_msg$MsgPic> rpt_msg_pic;
    public final PBUInt32Field uint32_msg_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_report_id_show;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 42, 50, 58, 64}, new String[]{"uint32_msg_type", "bytes_title", "rpt_bytes_abstact", "bytes_title_ext", "rpt_msg_pic", "msg_content_info", "uint32_report_id_show"}, new Object[]{0, byteStringMicro, byteStringMicro, byteStringMicro, null, null, 0}, obj_msg$ObjMsg.class);
    }

    public obj_msg$ObjMsg() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_title = PBField.initBytes(byteStringMicro);
        this.rpt_bytes_abstact = PBField.initRepeat(PBBytesField.__repeatHelper__);
        this.bytes_title_ext = PBField.initBytes(byteStringMicro);
        this.rpt_msg_pic = PBField.initRepeatMessage(obj_msg$MsgPic.class);
        this.msg_content_info = PBField.initRepeatMessage(obj_msg$MsgContentInfo.class);
        this.uint32_report_id_show = PBField.initUInt32(0);
    }
}
