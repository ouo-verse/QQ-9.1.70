package tencent.im.selfgif;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class CameraEmotionRoaming_sso$UpLoadStateReq extends MessageMicro<CameraEmotionRoaming_sso$UpLoadStateReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"upload_state"}, new Object[]{null}, CameraEmotionRoaming_sso$UpLoadStateReq.class);
    public final PBRepeatMessageField<CameraEmotionRoaming_sso$UpLoadState> upload_state = PBField.initRepeatMessage(CameraEmotionRoaming_sso$UpLoadState.class);
}
