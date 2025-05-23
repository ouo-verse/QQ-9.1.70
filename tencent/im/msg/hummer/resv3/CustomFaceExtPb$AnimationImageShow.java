package tencent.im.msg.hummer.resv3;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* loaded from: classes29.dex */
public final class CustomFaceExtPb$AnimationImageShow extends MessageMicro<CustomFaceExtPb$AnimationImageShow> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{"int32_product_id", "bytes_animation_param", "int32_version"}, new Object[]{0, ByteStringMicro.EMPTY, 0}, CustomFaceExtPb$AnimationImageShow.class);
    public final PBInt32Field int32_product_id = PBField.initInt32(0);
    public final PBBytesField bytes_animation_param = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBInt32Field int32_version = PBField.initInt32(0);
}
