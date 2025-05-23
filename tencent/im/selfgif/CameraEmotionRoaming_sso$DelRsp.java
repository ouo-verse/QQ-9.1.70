package tencent.im.selfgif;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class CameraEmotionRoaming_sso$DelRsp extends MessageMicro<CameraEmotionRoaming_sso$DelRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"client_timestamp_version", "del_ret", "rpt_img_info"}, new Object[]{ByteStringMicro.EMPTY, null, null}, CameraEmotionRoaming_sso$DelRsp.class);
    public final PBBytesField client_timestamp_version = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<CameraEmotionRoaming_sso$DelRet> del_ret = PBField.initRepeatMessage(CameraEmotionRoaming_sso$DelRet.class);
    public final PBRepeatMessageField<CameraEmotionRoaming_sso$ImgInfo> rpt_img_info = PBField.initRepeatMessage(CameraEmotionRoaming_sso$ImgInfo.class);
}
