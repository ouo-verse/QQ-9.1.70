package trpc.qq_vgame.playgame;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class AvGamePlay$GetCurrentGameReq extends MessageMicro<AvGamePlay$GetCurrentGameReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"roomid"}, new Object[]{0L}, AvGamePlay$GetCurrentGameReq.class);
    public final PBUInt64Field roomid = PBField.initUInt64(0);
}
