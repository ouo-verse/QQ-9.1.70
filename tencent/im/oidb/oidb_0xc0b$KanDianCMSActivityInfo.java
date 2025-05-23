package tencent.im.oidb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xc0b$KanDianCMSActivityInfo extends MessageMicro<oidb_0xc0b$KanDianCMSActivityInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_picture_url;
    public final PBBytesField bytes_wording;
    public final PBUInt64Field uint64_activity_id = PBField.initUInt64(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"uint64_activity_id", "bytes_wording", "bytes_picture_url"}, new Object[]{0L, byteStringMicro, byteStringMicro}, oidb_0xc0b$KanDianCMSActivityInfo.class);
    }

    public oidb_0xc0b$KanDianCMSActivityInfo() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_wording = PBField.initBytes(byteStringMicro);
        this.bytes_picture_url = PBField.initBytes(byteStringMicro);
    }
}
