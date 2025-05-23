package tencent.im.cs.longconn;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class hd_video_comm$CryptInfo extends MessageMicro<hd_video_comm$CryptInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"enum_crypt_type", "uint32_key_len", "bytes_key_buf"}, new Object[]{1, 0, ByteStringMicro.EMPTY}, hd_video_comm$CryptInfo.class);
    public final PBEnumField enum_crypt_type = PBField.initEnum(1);
    public final PBUInt32Field uint32_key_len = PBField.initUInt32(0);
    public final PBBytesField bytes_key_buf = PBField.initBytes(ByteStringMicro.EMPTY);
}
