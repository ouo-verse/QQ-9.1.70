package tencent.im.oidb.cmd0xedb;

import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xedb$RspHeadInfo extends MessageMicro<oidb_0xedb$RspHeadInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 42}, new String[]{"dstUin", "faceType", "timestamp", FaceConstant.AvatarInfoBuilderKeys.FACE_FLAG, "url"}, new Object[]{0L, 0, 0, 0, ""}, oidb_0xedb$RspHeadInfo.class);
    public final PBUInt64Field dstUin = PBField.initUInt64(0);
    public final PBUInt32Field faceType = PBField.initUInt32(0);
    public final PBUInt32Field timestamp = PBField.initUInt32(0);
    public final PBUInt32Field faceFlag = PBField.initUInt32(0);
    public final PBStringField url = PBField.initString("");
}
