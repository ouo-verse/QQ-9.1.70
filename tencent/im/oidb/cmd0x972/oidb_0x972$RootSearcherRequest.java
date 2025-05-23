package tencent.im.oidb.cmd0x972;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.transfile.filebrowser.MimeTypeParser;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x972$RootSearcherRequest extends MessageMicro<oidb_0x972$RootSearcherRequest> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField cookie;
    public final PBBytesField extension;
    public final PBEnumField business = PBField.initEnum(64);
    public final PBUInt32Field page_size = PBField.initUInt32(0);
    public final PBRepeatField<Long> rpt_busi_mask = PBField.initRepeat(PBUInt64Field.__repeatHelper__);

    static {
        String[] strArr = {"business", "page_size", "rpt_busi_mask", "cookie", MimeTypeParser.ATTR_EXTENSION};
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{16, 32, 80, 90, 442}, strArr, new Object[]{64, 0, 0L, byteStringMicro, byteStringMicro}, oidb_0x972$RootSearcherRequest.class);
    }

    public oidb_0x972$RootSearcherRequest() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.cookie = PBField.initBytes(byteStringMicro);
        this.extension = PBField.initBytes(byteStringMicro);
    }
}
