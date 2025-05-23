package tencent.im.oidb.cmd0xb3e;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0xb3e$ReqBody extends MessageMicro<cmd0xb3e$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_gallery_rowkey = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatField<ByteStringMicro> bytes_gallery_rowkey_list = PBField.initRepeat(PBBytesField.__repeatHelper__);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"bytes_gallery_rowkey", "bytes_gallery_rowkey_list"}, new Object[]{byteStringMicro, byteStringMicro}, cmd0xb3e$ReqBody.class);
    }
}
