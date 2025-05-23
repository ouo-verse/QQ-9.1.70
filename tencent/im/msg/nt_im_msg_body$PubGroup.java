package tencent.im.msg;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes29.dex */
public final class nt_im_msg_body$PubGroup extends MessageMicro<nt_im_msg_body$PubGroup> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32}, new String[]{"bytes_nickname", "uint32_gender", "uint32_age", "uint32_distance"}, new Object[]{ByteStringMicro.EMPTY, 0, 0, 0}, nt_im_msg_body$PubGroup.class);
    public final PBBytesField bytes_nickname = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_gender = PBField.initUInt32(0);
    public final PBUInt32Field uint32_age = PBField.initUInt32(0);
    public final PBUInt32Field uint32_distance = PBField.initUInt32(0);
}
