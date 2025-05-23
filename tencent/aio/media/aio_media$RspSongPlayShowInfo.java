package tencent.aio.media;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class aio_media$RspSongPlayShowInfo extends MessageMicro<aio_media$RspSongPlayShowInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24}, new String[]{"msg_result", "uint32_join_num", "rpt_uint64_join_uins"}, new Object[]{null, 0, 0L}, aio_media$RspSongPlayShowInfo.class);
    public aio_media$ResultInfo msg_result = new aio_media$ResultInfo();
    public final PBUInt32Field uint32_join_num = PBField.initUInt32(0);
    public final PBRepeatField<Long> rpt_uint64_join_uins = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
}
