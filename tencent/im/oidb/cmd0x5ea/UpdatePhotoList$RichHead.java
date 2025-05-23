package tencent.im.oidb.cmd0x5ea;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes29.dex */
public final class UpdatePhotoList$RichHead extends MessageMicro<UpdatePhotoList$RichHead> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint32_headid", "str_video_id"}, new Object[]{0, ""}, UpdatePhotoList$RichHead.class);
    public final PBUInt32Field uint32_headid = PBField.initUInt32(0);
    public final PBStringField str_video_id = PBField.initString("");
}
