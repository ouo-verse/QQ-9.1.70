package tencent.im.selfgif;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class CameraEmotionRoaming_sso$UpLoadRsp extends MessageMicro<CameraEmotionRoaming_sso$UpLoadRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"int32_is_upload", "bytes_resource_id"}, new Object[]{0, ByteStringMicro.EMPTY}, CameraEmotionRoaming_sso$UpLoadRsp.class);
    public final PBInt32Field int32_is_upload = PBField.initInt32(0);
    public final PBBytesField bytes_resource_id = PBField.initBytes(ByteStringMicro.EMPTY);
}
