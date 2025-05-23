package tencent.im.selfgif;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class CameraEmotionRoaming_sso$UpLoadStateRet extends MessageMicro<CameraEmotionRoaming_sso$UpLoadStateRet> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"int32_upload_state_ret", "img_info"}, new Object[]{0, null}, CameraEmotionRoaming_sso$UpLoadStateRet.class);
    public final PBInt32Field int32_upload_state_ret = PBField.initInt32(0);
    public CameraEmotionRoaming_sso$ImgInfo img_info = new CameraEmotionRoaming_sso$ImgInfo();
}
