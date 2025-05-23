package tencent.im.selfgif;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class CameraEmotionRoaming_sso$UpLoadStateRsp extends MessageMicro<CameraEmotionRoaming_sso$UpLoadStateRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"upload_state_ret", "server_timestamp_version"}, new Object[]{null, ByteStringMicro.EMPTY}, CameraEmotionRoaming_sso$UpLoadStateRsp.class);
    public final PBRepeatMessageField<CameraEmotionRoaming_sso$UpLoadStateRet> upload_state_ret = PBField.initRepeatMessage(CameraEmotionRoaming_sso$UpLoadStateRet.class);
    public final PBBytesField server_timestamp_version = PBField.initBytes(ByteStringMicro.EMPTY);
}
