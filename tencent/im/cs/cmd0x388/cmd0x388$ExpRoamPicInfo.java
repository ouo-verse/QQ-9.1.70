package tencent.im.cs.cmd0x388;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes29.dex */
public final class cmd0x388$ExpRoamPicInfo extends MessageMicro<cmd0x388$ExpRoamPicInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"uint32_shop_flag", "uint32_pkg_id", "bytes_pic_id"}, new Object[]{0, 0, ByteStringMicro.EMPTY}, cmd0x388$ExpRoamPicInfo.class);
    public final PBUInt32Field uint32_shop_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_pkg_id = PBField.initUInt32(0);
    public final PBBytesField bytes_pic_id = PBField.initBytes(ByteStringMicro.EMPTY);
}
