package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes30.dex */
public final class UserProxyCmdOuterClass$GetFansGroupReq extends MessageMicro<UserProxyCmdOuterClass$GetFansGroupReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"live_room_id", "live_uid"}, new Object[]{0L, 0L}, UserProxyCmdOuterClass$GetFansGroupReq.class);
    public final PBUInt64Field live_room_id = PBField.initUInt64(0);
    public final PBUInt64Field live_uid = PBField.initUInt64(0);
}
