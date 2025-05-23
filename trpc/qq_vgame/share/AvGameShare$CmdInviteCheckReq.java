package trpc.qq_vgame.share;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class AvGameShare$CmdInviteCheckReq extends MessageMicro<AvGameShare$CmdInviteCheckReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"key"}, new Object[]{""}, AvGameShare$CmdInviteCheckReq.class);
    public final PBStringField key = PBField.initString("");
}
