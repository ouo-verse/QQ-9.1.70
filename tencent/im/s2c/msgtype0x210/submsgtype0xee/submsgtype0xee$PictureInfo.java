package tencent.im.s2c.msgtype0x210.submsgtype0xee;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

/* loaded from: classes29.dex */
public final class submsgtype0xee$PictureInfo extends MessageMicro<submsgtype0xee$PictureInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"bytes_url"}, new Object[]{ByteStringMicro.EMPTY}, submsgtype0xee$PictureInfo.class);
    public final PBBytesField bytes_url = PBField.initBytes(ByteStringMicro.EMPTY);
}
