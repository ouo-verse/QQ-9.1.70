package trpc.qq_vgame.share;

import com.tencent.mobileqq.mini.servlet.GetGuildJoinUrlServlet;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class AvGameShare$CmdGetShareLinkRsp extends MessageMicro<AvGameShare$CmdGetShareLinkRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{GetGuildJoinUrlServlet.BUNDLE_KEY_URL}, new Object[]{""}, AvGameShare$CmdGetShareLinkRsp.class);
    public final PBStringField share_url = PBField.initString("");
}
