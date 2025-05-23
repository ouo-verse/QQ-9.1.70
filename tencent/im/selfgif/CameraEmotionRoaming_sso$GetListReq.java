package tencent.im.selfgif;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class CameraEmotionRoaming_sso$GetListReq extends MessageMicro<CameraEmotionRoaming_sso$GetListReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"client_timestamp_version"}, new Object[]{ByteStringMicro.EMPTY}, CameraEmotionRoaming_sso$GetListReq.class);
    public final PBBytesField client_timestamp_version = PBField.initBytes(ByteStringMicro.EMPTY);
}
