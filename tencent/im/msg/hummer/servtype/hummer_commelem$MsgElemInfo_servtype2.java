package tencent.im.msg.hummer.servtype;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class hummer_commelem$MsgElemInfo_servtype2 extends MessageMicro<hummer_commelem$MsgElemInfo_servtype2> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_poke_summary;
    public final PBBytesField bytes_vaspoke_minver;
    public final PBBytesField bytes_vaspoke_name;
    public final PBUInt32Field uint32_double_hit;
    public final PBUInt32Field uint32_face_bubble_count;
    public final PBUInt32Field uint32_msg_type;
    public final PBUInt32Field uint32_poke_flag;
    public final PBUInt32Field uint32_poke_strength;
    public final PBUInt32Field uint32_poke_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_vaspoke_id;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32, 42, 50, 56, 64, 72, 80}, new String[]{"uint32_poke_type", "bytes_poke_summary", "uint32_double_hit", "uint32_vaspoke_id", "bytes_vaspoke_name", "bytes_vaspoke_minver", "uint32_poke_strength", "uint32_msg_type", "uint32_face_bubble_count", "uint32_poke_flag"}, new Object[]{0, byteStringMicro, 0, 0, byteStringMicro, byteStringMicro, 0, 0, 0, 0}, hummer_commelem$MsgElemInfo_servtype2.class);
    }

    public hummer_commelem$MsgElemInfo_servtype2() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_poke_summary = PBField.initBytes(byteStringMicro);
        this.uint32_double_hit = PBField.initUInt32(0);
        this.uint32_vaspoke_id = PBField.initUInt32(0);
        this.bytes_vaspoke_name = PBField.initBytes(byteStringMicro);
        this.bytes_vaspoke_minver = PBField.initBytes(byteStringMicro);
        this.uint32_poke_strength = PBField.initUInt32(0);
        this.uint32_msg_type = PBField.initUInt32(0);
        this.uint32_face_bubble_count = PBField.initUInt32(0);
        this.uint32_poke_flag = PBField.initUInt32(0);
    }
}
