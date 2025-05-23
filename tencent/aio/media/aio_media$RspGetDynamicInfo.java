package tencent.aio.media;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class aio_media$RspGetDynamicInfo extends MessageMicro<aio_media$RspGetDynamicInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 82, 90, 98, 106, 114}, new String[]{"msg_result", "msg_music_info", "msg_video_info", "msg_ksing_info", "msg_play_info", "rpt_dynamic_info"}, new Object[]{null, null, null, null, null, null}, aio_media$RspGetDynamicInfo.class);
    public aio_media$ResultInfo msg_result = new aio_media$ResultInfo();
    public aio_media$DynamicInfo msg_music_info = new aio_media$DynamicInfo();
    public aio_media$DynamicInfo msg_video_info = new aio_media$DynamicInfo();
    public aio_media$DynamicInfo msg_ksing_info = new aio_media$DynamicInfo();
    public aio_media$DynamicInfo msg_play_info = new aio_media$DynamicInfo();
    public final PBRepeatMessageField<aio_media$DynamicInfo> rpt_dynamic_info = PBField.initRepeatMessage(aio_media$DynamicInfo.class);
}
