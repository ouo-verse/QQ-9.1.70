package trpc.qq_vgame.stranger_match;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class AvGameStrangerMatch$AddMatchUserReq extends MessageMicro<AvGameStrangerMatch$AddMatchUserReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"uin", "type", "gender"}, new Object[]{0L, 0, 0}, AvGameStrangerMatch$AddMatchUserReq.class);
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public final PBUInt32Field type = PBField.initUInt32(0);
    public final PBUInt32Field gender = PBField.initUInt32(0);
}
