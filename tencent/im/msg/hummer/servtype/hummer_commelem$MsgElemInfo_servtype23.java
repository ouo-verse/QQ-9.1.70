package tencent.im.msg.hummer.servtype;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class hummer_commelem$MsgElemInfo_servtype23 extends MessageMicro<hummer_commelem$MsgElemInfo_servtype23> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_face_summary;
    public final PBBytesField bytes_others;
    public hummer_commelem$MsgElemInfo_servtype33 msg_yellow_face;
    public final PBUInt32Field uint32_flag;
    public final PBUInt32Field uint32_face_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_face_bubble_count = PBField.initUInt32(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32, 42, 50}, new String[]{"uint32_face_type", "uint32_face_bubble_count", "bytes_face_summary", "uint32_flag", "bytes_others", "msg_yellow_face"}, new Object[]{0, 0, byteStringMicro, 0, byteStringMicro, null}, hummer_commelem$MsgElemInfo_servtype23.class);
    }

    public hummer_commelem$MsgElemInfo_servtype23() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_face_summary = PBField.initBytes(byteStringMicro);
        this.uint32_flag = PBField.initUInt32(0);
        this.bytes_others = PBField.initBytes(byteStringMicro);
        this.msg_yellow_face = new hummer_commelem$MsgElemInfo_servtype33();
    }
}
