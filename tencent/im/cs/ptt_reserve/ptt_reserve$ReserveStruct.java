package tencent.im.cs.ptt_reserve;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class ptt_reserve$ReserveStruct extends MessageMicro<ptt_reserve$ReserveStruct> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_general_flags;
    public final PBBytesField bytes_redpack_score_id;
    public final PBBytesField bytes_voice_text_abs;
    public final PBUInt32Field uint32_autototext_voice;
    public final PBUInt32Field uint32_change_voice = PBField.initUInt32(0);
    public final PBUInt32Field uint32_color_text_id;
    public final PBUInt32Field uint32_redpack_type;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 40, 50, 56, 66}, new String[]{"uint32_change_voice", "bytes_general_flags", "uint32_color_text_id", "uint32_redpack_type", "bytes_redpack_score_id", "uint32_autototext_voice", "bytes_voice_text_abs"}, new Object[]{0, byteStringMicro, 0, 0, byteStringMicro, 0, byteStringMicro}, ptt_reserve$ReserveStruct.class);
    }

    public ptt_reserve$ReserveStruct() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_general_flags = PBField.initBytes(byteStringMicro);
        this.uint32_color_text_id = PBField.initUInt32(0);
        this.uint32_redpack_type = PBField.initUInt32(0);
        this.bytes_redpack_score_id = PBField.initBytes(byteStringMicro);
        this.uint32_autototext_voice = PBField.initUInt32(0);
        this.bytes_voice_text_abs = PBField.initBytes(byteStringMicro);
    }
}
