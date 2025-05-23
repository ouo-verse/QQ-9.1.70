package tencent.im.selfgif;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class CameraEmotionRoaming_sso$DelRet extends MessageMicro<CameraEmotionRoaming_sso$DelRet> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"int32_del_ret", "bytes_resource_id"}, new Object[]{0, ByteStringMicro.EMPTY}, CameraEmotionRoaming_sso$DelRet.class);
    public final PBInt32Field int32_del_ret = PBField.initInt32(0);
    public final PBBytesField bytes_resource_id = PBField.initBytes(ByteStringMicro.EMPTY);
}
