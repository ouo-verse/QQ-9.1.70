package tencent.im.oidb.cmd0x5e9;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes29.dex */
public final class GetPhotoList$HeadInfo extends MessageMicro<GetPhotoList$HeadInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 32, 40, 48, 56, 64, 74, 80, 88, 98}, new String[]{"uint32_headid", "str_headurl", "uint32_is_curhead", "uint32_flag", "uint32_proc_state", "uint32_face", "uint32_charm", "str_video_url", "uint32_video_time", "uint32_video_size", "str_video_id"}, new Object[]{0, "", 0, 0, 0, 0, 0, "", 0, 0, ""}, GetPhotoList$HeadInfo.class);
    public final PBUInt32Field uint32_headid = PBField.initUInt32(0);
    public final PBStringField str_headurl = PBField.initString("");
    public final PBUInt32Field uint32_is_curhead = PBField.initUInt32(0);
    public final PBUInt32Field uint32_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_proc_state = PBField.initUInt32(0);
    public final PBUInt32Field uint32_face = PBField.initUInt32(0);
    public final PBUInt32Field uint32_charm = PBField.initUInt32(0);
    public final PBStringField str_video_url = PBField.initString("");
    public final PBUInt32Field uint32_video_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_video_size = PBField.initUInt32(0);
    public final PBStringField str_video_id = PBField.initString("");
}
