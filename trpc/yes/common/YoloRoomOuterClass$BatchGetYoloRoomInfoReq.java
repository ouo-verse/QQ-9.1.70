package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class YoloRoomOuterClass$BatchGetYoloRoomInfoReq extends MessageMicro<YoloRoomOuterClass$BatchGetYoloRoomInfoReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"room_id_list"}, new Object[]{0L}, YoloRoomOuterClass$BatchGetYoloRoomInfoReq.class);
    public final PBRepeatField<Long> room_id_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
}
