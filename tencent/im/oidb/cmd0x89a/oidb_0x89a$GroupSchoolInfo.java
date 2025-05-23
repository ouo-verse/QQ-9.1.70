package tencent.im.oidb.cmd0x89a;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x89a$GroupSchoolInfo extends MessageMicro<oidb_0x89a$GroupSchoolInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_location;
    public final PBBytesField bytes_school;
    public final PBUInt32Field uint32_grade;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26}, new String[]{"bytes_location", "uint32_grade", "bytes_school"}, new Object[]{byteStringMicro, 0, byteStringMicro}, oidb_0x89a$GroupSchoolInfo.class);
    }

    public oidb_0x89a$GroupSchoolInfo() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_location = PBField.initBytes(byteStringMicro);
        this.uint32_grade = PBField.initUInt32(0);
        this.bytes_school = PBField.initBytes(byteStringMicro);
    }
}
