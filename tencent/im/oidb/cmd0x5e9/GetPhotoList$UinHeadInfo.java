package tencent.im.oidb.cmd0x5e9;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class GetPhotoList$UinHeadInfo extends MessageMicro<GetPhotoList$UinHeadInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 42, 50}, new String[]{"uint64_uin", "uint32_timestamp", "uint32_headcount", "rpt_msg_headinfo", "str_headurl", "msg_verify_video_info"}, new Object[]{0L, 0, 0, null, "", null}, GetPhotoList$UinHeadInfo.class);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    public final PBUInt32Field uint32_timestamp = PBField.initUInt32(0);
    public final PBUInt32Field uint32_headcount = PBField.initUInt32(0);
    public final PBRepeatMessageField<GetPhotoList$HeadInfo> rpt_msg_headinfo = PBField.initRepeatMessage(GetPhotoList$HeadInfo.class);
    public final PBStringField str_headurl = PBField.initString("");
    public GetPhotoList$HeadInfo msg_verify_video_info = new GetPhotoList$HeadInfo();
}
