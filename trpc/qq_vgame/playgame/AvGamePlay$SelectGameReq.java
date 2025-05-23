package trpc.qq_vgame.playgame;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class AvGamePlay$SelectGameReq extends MessageMicro<AvGamePlay$SelectGameReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"uin", "roomid", "type"}, new Object[]{0L, 0L, 0}, AvGamePlay$SelectGameReq.class);
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public final PBUInt64Field roomid = PBField.initUInt64(0);
    public final PBEnumField type = PBField.initEnum(0);
}
