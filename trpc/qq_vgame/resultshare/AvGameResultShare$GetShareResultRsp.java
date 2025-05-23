package trpc.qq_vgame.resultshare;

import com.tencent.mobileqq.haoliyou.sso.CheckForwardServlet;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class AvGameResultShare$GetShareResultRsp extends MessageMicro<AvGameResultShare$GetShareResultRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42}, new String[]{CheckForwardServlet.KEY_ERR_CODE, "err_msg", "cover_url", "video_url", "ranking_list"}, new Object[]{0, "", "", "", null}, AvGameResultShare$GetShareResultRsp.class);
    public final PBUInt32Field err_code = PBField.initUInt32(0);
    public final PBStringField err_msg = PBField.initString("");
    public final PBStringField cover_url = PBField.initString("");
    public final PBStringField video_url = PBField.initString("");
    public final PBRepeatMessageField<AvGameResultShare$UserScoreInfo> ranking_list = PBField.initRepeatMessage(AvGameResultShare$UserScoreInfo.class);
}
