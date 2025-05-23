package tencent.im.selfgif;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class CameraEmotionRoaming_sso$GetListRsp extends MessageMicro<CameraEmotionRoaming_sso$GetListRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"server_timestamp_version", "rpt_img_info"}, new Object[]{ByteStringMicro.EMPTY, null}, CameraEmotionRoaming_sso$GetListRsp.class);
    public final PBBytesField server_timestamp_version = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<CameraEmotionRoaming_sso$ImgInfo> rpt_img_info = PBField.initRepeatMessage(CameraEmotionRoaming_sso$ImgInfo.class);
}
