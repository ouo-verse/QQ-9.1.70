package tencent.im.oidb.cmd0xd79;

import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class Oidb_0xd79$ReqBody extends MessageMicro<Oidb_0xd79$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_content;
    public final PBBytesField bytes_qua;
    public final PBBytesField bytes_word_ext;
    public final PBUInt64Field uint64_sender_uin;
    public final PBUInt64Field uint64_seq = PBField.initUInt64(0);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    public final PBUInt32Field uint32_compress_flag = PBField.initUInt32(0);

    static {
        String[] strArr = {"uint64_seq", "uint64_uin", "uint32_compress_flag", MessageForUniteGrayTip.KEY_BYTES_CONTENT, "uint64_sender_uin", "bytes_qua", "bytes_word_ext"};
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 40, 50, 58}, strArr, new Object[]{0L, 0L, 0, byteStringMicro, 0L, byteStringMicro, byteStringMicro}, Oidb_0xd79$ReqBody.class);
    }

    public Oidb_0xd79$ReqBody() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_content = PBField.initBytes(byteStringMicro);
        this.uint64_sender_uin = PBField.initUInt64(0L);
        this.bytes_qua = PBField.initBytes(byteStringMicro);
        this.bytes_word_ext = PBField.initBytes(byteStringMicro);
    }
}
