package tencent.im.selfgif;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class CameraEmotionRoaming_sso$DelReq extends MessageMicro<CameraEmotionRoaming_sso$DelReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"bytes_resource_id"}, new Object[]{ByteStringMicro.EMPTY}, CameraEmotionRoaming_sso$DelReq.class);
    public final PBRepeatField<ByteStringMicro> bytes_resource_id = PBField.initRepeat(PBBytesField.__repeatHelper__);
}
