package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes30.dex */
public final class MessageOuterClass$YoloRoomNewDataPushMsg extends MessageMicro<MessageOuterClass$YoloRoomNewDataPushMsg> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"new_data_time_ms"}, new Object[]{0L}, MessageOuterClass$YoloRoomNewDataPushMsg.class);
    public final PBUInt64Field new_data_time_ms = PBField.initUInt64(0);
}
