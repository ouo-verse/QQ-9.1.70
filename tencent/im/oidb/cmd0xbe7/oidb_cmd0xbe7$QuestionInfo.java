package tencent.im.oidb.cmd0xbe7;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xbe7$QuestionInfo extends MessageMicro<oidb_cmd0xbe7$QuestionInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_rowkey;
    public final PBBytesField bytes_title;
    public final PBBytesField bytes_url;
    public final PBUInt32Field uint32_answer_num;
    public final PBUInt32Field uint32_fans_num;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 42}, new String[]{"bytes_rowkey", "bytes_title", "uint32_fans_num", "uint32_answer_num", "bytes_url"}, new Object[]{byteStringMicro, byteStringMicro, 0, 0, byteStringMicro}, oidb_cmd0xbe7$QuestionInfo.class);
    }

    public oidb_cmd0xbe7$QuestionInfo() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_rowkey = PBField.initBytes(byteStringMicro);
        this.bytes_title = PBField.initBytes(byteStringMicro);
        this.uint32_fans_num = PBField.initUInt32(0);
        this.uint32_answer_num = PBField.initUInt32(0);
        this.bytes_url = PBField.initBytes(byteStringMicro);
    }
}
