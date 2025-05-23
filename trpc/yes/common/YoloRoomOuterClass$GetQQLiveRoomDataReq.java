package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class YoloRoomOuterClass$GetQQLiveRoomDataReq extends MessageMicro<YoloRoomOuterClass$GetQQLiveRoomDataReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"live_uid", "uid"}, new Object[]{0L, 0L}, YoloRoomOuterClass$GetQQLiveRoomDataReq.class);
    public final PBUInt64Field live_uid = PBField.initUInt64(0);
    public final PBUInt64Field uid = PBField.initUInt64(0);
}
