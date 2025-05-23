package tencent.im.oidb.cmd0xb40;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

/* loaded from: classes29.dex */
public final class oidb_0xb40$PicInfo extends MessageMicro<oidb_0xb40$PicInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"bytes_uri"}, new Object[]{ByteStringMicro.EMPTY}, oidb_0xb40$PicInfo.class);
    public final PBBytesField bytes_uri = PBField.initBytes(ByteStringMicro.EMPTY);
}
