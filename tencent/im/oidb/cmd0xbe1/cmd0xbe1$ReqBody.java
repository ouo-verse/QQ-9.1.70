package tencent.im.oidb.cmd0xbe1;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0xbe1$ReqBody extends MessageMicro<cmd0xbe1$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBRepeatField<ByteStringMicro> rpt_bytes_more_rowkey_list;
    public final PBRepeatField<ByteStringMicro> rpt_bytes_rowkey_list;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"rpt_bytes_rowkey_list", "rpt_bytes_more_rowkey_list"}, new Object[]{byteStringMicro, byteStringMicro}, cmd0xbe1$ReqBody.class);
    }

    public cmd0xbe1$ReqBody() {
        PBBytesField pBBytesField = PBBytesField.__repeatHelper__;
        this.rpt_bytes_rowkey_list = PBField.initRepeat(pBBytesField);
        this.rpt_bytes_more_rowkey_list = PBField.initRepeat(pBBytesField);
    }
}
